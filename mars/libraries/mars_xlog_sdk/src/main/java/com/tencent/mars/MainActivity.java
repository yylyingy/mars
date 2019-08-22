package com.tencent.mars;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import com.tencent.mars.xlog.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i < 20;i ++) {
                    Log.d("t","test yyl");
//                    Log.appenderFlush(true);
                }
                Log.appenderFlush(true);
//                Log.appenderClose();
            }
        });

    }
}
