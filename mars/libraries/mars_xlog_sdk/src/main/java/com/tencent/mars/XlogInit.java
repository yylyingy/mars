package com.tencent.mars;

import android.content.Context;
import android.os.Environment;

import com.tencent.mars.xlog.Log;
import com.tencent.mars.xlog.Xlog;

import java.util.UUID;

/**
 * <br> ClassName:
 * <br> Description:
 * <br>
 * <br> Author:      yangyinglong
 * <br> Date:        2018/8/31 11:53
 */
public class XlogInit {
    public static void init(Context context) {
        System.loadLibrary("c++_shared");
        System.loadLibrary("marsxlog");

        final String SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath();
        final String logPath = SDCARD + "/marssample/log";

// this is necessary, or may cash for SIGBUS
        String cachePath = context.getFilesDir() + "/xlog";
        cachePath = SDCARD + "/marssample/logcache";
//init xlog
        if (BuildConfig.DEBUG) {
            Xlog.appenderOpen(Xlog.LEVEL_DEBUG, Xlog.AppednerModeAsync, cachePath, logPath,
                    "y-log",0, "");
            Xlog.setConsoleLogOpen(true);

        } else {
            Xlog.appenderOpen(Xlog.LEVEL_INFO, Xlog.AppednerModeAsync, cachePath, logPath,
                    "y-log", 0,"");
            Xlog.setConsoleLogOpen(false);
        }

        Log.setLogImp(new Xlog());
    }
}
