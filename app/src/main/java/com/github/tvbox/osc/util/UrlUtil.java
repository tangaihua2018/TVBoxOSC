package com.github.tvbox.osc.util;

import android.net.Uri;

import com.github.tvbox.osc.server.ControlManager;
import com.google.common.net.HttpHeaders;

public class UrlUtil {

    public static Uri uri(String url) {
        return Uri.parse(url.trim().replace("\\", ""));
    }

    public static String scheme(String url) {
        return url == null ? "" : scheme(Uri.parse(url));
    }

    public static String scheme(Uri uri) {
        String scheme = uri.getScheme();
        return scheme == null ? "" : scheme.toLowerCase().trim();
    }

    public static String host(String url) {
        return url == null ? "" : host(Uri.parse(url));
    }

    public static String host(Uri uri) {
        String host = uri.getHost();
        return host == null ? "" : host.toLowerCase().trim();
    }

    public static String path(Uri uri) {
        String path = uri.getPath();
        return path == null ? "" : path.trim();
    }

    public static String convert(String url) {
        String scheme = scheme(url);
        if ("clan".equals(scheme)) return convert(fixUrl(url));
        if ("local".equals(scheme)) return url.replace("local://", ControlManager.get().getAddress(false));
        if ("assets".equals(scheme)) return url.replace("assets://", ControlManager.get().getAddress(false));
        if ("file".equals(scheme)) return url.replace("file://", ControlManager.get().getAddress("file/"));
        if ("proxy".equals(scheme)) return url.replace("proxy://", ControlManager.get().getAddress("proxy?"));
        return url;
    }

    public static String fixUrl(String url) {
        if (url.contains("/localhost/")) url = url.replace("/localhost/", "/");
        if (url.startsWith("clan")) url = url.replace("clan", "file");
        return url;
    }

    public static String fixHeader(String key) {
        if (HttpHeaders.USER_AGENT.equalsIgnoreCase(key)) return HttpHeaders.USER_AGENT;
        if (HttpHeaders.REFERER.equalsIgnoreCase(key)) return HttpHeaders.REFERER;
        if (HttpHeaders.COOKIE.equalsIgnoreCase(key)) return HttpHeaders.COOKIE;
        return key;
    }
}
