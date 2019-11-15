package com.bn.View;

import android.view.MotionEvent;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Administrator on 2017/8/29.
 */

public abstract class RMAbstractView {
    public abstract void initView();//初始化资源
    public abstract boolean onTouchEvent(MotionEvent e);//触控
    public abstract void drawView(GL10 gl);//绘制界面
}
