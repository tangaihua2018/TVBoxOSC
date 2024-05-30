package com.github.tvbox.osc.util;

import android.content.Context;

import com.github.tvbox.osc.base.App;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class AssetUtils {

    public static String copyAssetToInternalStorage(Context context, String assetFileName, String destinationFileName) {
        InputStream inputStream = null;
        FileOutputStream outputStream = null;
        File outFile = new File(context.getFilesDir(), destinationFileName);

        try {
            inputStream = context.getAssets().open(assetFileName);
            outputStream = new FileOutputStream(outFile);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return outFile.getAbsolutePath();
    }

    public static String localConfigPath(String oriFileName) {
        return "file://" + AssetUtils.copyAssetToInternalStorage(App.getInstance(), oriFileName, oriFileName);
    }
}

