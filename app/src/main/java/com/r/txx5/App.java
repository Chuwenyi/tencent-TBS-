package com.r.txx5;

/**
 * Created by 12457 on 2017/8/2.
 */

import android.app.Application;
import android.util.Log;

import com.tencent.smtt.sdk.QbSdk;

/**
 * Created by ljh
 * on 2016/12/22.
 */
public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        //增加这句话
       // QbSdk.initX5Environment(this,null);
        ExceptionHandler.getInstance().initConfig(this);
        QbSdk.initX5Environment(this, new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {
                //x5内核初始化完成回调接口，此接口回调并表示已经加载起来了x5，有可能特殊情况下x5内核加载失败，切换到系统内核。
                Log.e("print","是否加载");
            }

            @Override
            public void onViewInitFinished(boolean b) {
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.e("print","加载内核是否成功:"+b);
            }
        });
    }


}
