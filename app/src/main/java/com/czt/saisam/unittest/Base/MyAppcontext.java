package com.czt.saisam.unittest.Base;

import android.app.Application;
import android.util.Log;

/**
 * Created by weichyang on 2017/1/3.
 * 测试Appcontext 关联类
 */

public class MyAppcontext extends Application {

    public static MyAppcontext appcontext;

    @Override
    public void onCreate() {
        super.onCreate();
        appcontext = this;
        Log.d("onCreat", "单元测试Appcontext");
    }

    public static MyAppcontext getInstance() {
        return appcontext;
    }

}
