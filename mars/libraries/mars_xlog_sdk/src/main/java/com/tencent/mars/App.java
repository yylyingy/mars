package com.tencent.mars;

import android.app.Application;

/**
 * <br> ClassName:
 * <br> Description: todo(这里用一句话描述这个类的作用)
 * <br>
 * <br> Author:      Yangyl
 * <br> Date:        2019/4/10 0:35
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        XlogInit.init(getApplicationContext());
    }
}
