package com.github.tvbox.osc.util;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.github.tvbox.osc.base.App;
import com.github.tvbox.osc.server.ControlManager;
import com.iheartradio.m3u8.Encoding;
import com.iheartradio.m3u8.Format;
import com.iheartradio.m3u8.ParseException;
import com.iheartradio.m3u8.PlaylistException;
import com.iheartradio.m3u8.PlaylistParser;
import com.iheartradio.m3u8.PlaylistWriter;
import com.iheartradio.m3u8.data.MasterPlaylist;
import com.iheartradio.m3u8.data.MediaPlaylist;
import com.iheartradio.m3u8.data.Playlist;
import com.iheartradio.m3u8.data.PlaylistData;
import com.iheartradio.m3u8.data.TrackData;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.dnsoverhttps.OkHttp3Helper;

public class CutM3u8Ads {
    public static byte[] cutAds(byte[] m3u8In, String baseUrl) throws PlaylistException, IOException, ParseException, URISyntaxException {
        Handler handler = new Handler(Looper.getMainLooper());

        InputStream inputStream = new ByteArrayInputStream(m3u8In);
        PlaylistParser parser = new PlaylistParser(inputStream, Format.EXT_M3U, Encoding.UTF_8);
        Playlist playlist = parser.parse();
        MediaPlaylist mediaPlaylist = playlist.getMediaPlaylist();

        if (mediaPlaylist == null) {
            MasterPlaylist masterPlaylist = playlist.getMasterPlaylist();
            PlaylistData data = masterPlaylist.getPlaylists().get(0);
            // 拼接绝对路径
            String absUrl = new URI(baseUrl).resolve(data.getUri()).toString();
            Request request = new Request.Builder().url(absUrl).build();
            okhttp3.Response response = OkGoHelper.getDefaultClient().newCall(request).execute();
            byte[] res = response.body().bytes();
            return cutAds(res, absUrl);
        }

        double duration = cut_ads_list(mediaPlaylist, baseUrl);
        if (duration > 0) {
            @SuppressLint("DefaultLocale")
            String text = String.format("已经去掉插播广告，总时间：%.03f秒", duration);
            handler.post(() -> showToast(App.getInstance(), text));
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PlaylistWriter writer = new PlaylistWriter(outputStream, Format.EXT_M3U, Encoding.UTF_8);
        writer.write(playlist);

        return outputStream.toByteArray();
    }

    public static boolean haveAds(String flag, String url) {
        if (url == null || !url.endsWith(".m3u8")) return false;

        return flag != null && (
                flag.equals("lzm3u8") ||
                        flag.equals("ffm3u8") ||
                        flag.equals("bfzym3u8")
        );
    }

    public static double cut_ads_list(MediaPlaylist mediaPlaylist, String baseUrl) throws URISyntaxException {
        List<TrackData> trackDataList = mediaPlaylist.getTracks();
        boolean start = false;
        int cnt = 0, len = trackDataList.size();
        for (int i = 0; i < len; i++) {
            TrackData trackData = trackDataList.get(i);
            if (trackData.hasDiscontinuity() && !start && i > 0) {
                String prevUrl = incrementTsFilename(trackDataList.get(i - 1).getUri());
                if (!trackData.getUri().equals(prevUrl) && cnt == 0) {
                    start = true;
                    cnt += 0;
                }
            } else if (trackData.hasDiscontinuity() && start) {
                start = false;
            }
            trackData.setDiscontinuity(start);
        }

        double duration = 0;
        for (int i = 0; i < len; ) {
            if (trackDataList.get(i).hasDiscontinuity()) {
                trackDataList.remove(i);
                duration += trackDataList.get(i).getTrackInfo().duration;
                len--;
            } else {
                // 拼接绝对路径
                if (baseUrl != null) {
                    URI resolvedUri = new URI(baseUrl).resolve(trackDataList.get(i).getUri());
                    trackDataList.get(i).setUri(resolvedUri.toString());
                }
                i++;
            }
        }

        return duration;
    }

    public static String incrementTsFilename(String filename) {
        Pattern pattern = Pattern.compile("(\\d+)(?=\\.ts$)");
        Matcher matcher = pattern.matcher(filename);

        if (matcher.find()) {
            String number = matcher.group(1);
            long newNumber = Long.parseLong(number) + 1;
            String newNumberStr = String.format("%0" + number.length() + "d", newNumber);
            String newFilename = filename.substring(0, matcher.start(1)) + newNumberStr + filename.substring(matcher.end(1));
            return newFilename;
        } else {
            return filename;
        }
    }

    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static String fixUrlForCutAds(Map<String, String> headers, String uri) {
        if (headers == null || headers.size() == 0 || !uri.endsWith(".m3u8")) return uri;

        String flag = headers.get("flag");
        if (!"lzm3u8".equals(flag) && !"ffm3u8".equals(flag) && !"bfzym3u8".equals(flag)) return uri;
        return ControlManager.get()
                .getAddress(true)
                .concat("m3u8?url=")
                .concat(URLEncoder.encode(uri));
    }
}
