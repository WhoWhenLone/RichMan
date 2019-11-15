package com.bn.Util;

import android.app.Application;
/**
 * Created by Administrator on 2017/4/3.
 */

public class ContextUtil extends Application
{
    private static ContextUtil instance;

    public static ContextUtil getInstance()
    {
        return instance;
    }

    private static final String TAG = "MoblieApplication";

    @Override
    public void onCreate()
    {
        super.onCreate();
        instance = this;

    }


}
