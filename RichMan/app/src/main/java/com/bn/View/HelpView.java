package com.bn.View;

import android.opengl.GLES30;
import android.view.MotionEvent;

import com.bn.RichMan.MainActivity;
import com.bn.RichMan.MyGLSurFaceView;
import com.bn.Util.MatrixState2D;

import javax.microedition.khronos.opengles.GL10;

import static com.bn.Constant.Constant.loadState;
import static com.bn.Constant.Constant.menuButton;
import static com.bn.Constant.Constant.startView;
import static com.bn.Constant.Constant.systemBottom;
import static com.bn.Constant.Constant.systemLeft;
import static com.bn.Constant.Constant.systemRight;
import static com.bn.Constant.Constant.systemTop;
import static com.bn.View.MenuButton.HELPVIEW;
import static com.bn.View.MenuButton.SYSTEMVIEW;

/**
 * Created by Administrator on 2017/10/19.
 */

public class HelpView extends RMAbstractView {
    MainActivity ma;
    MyGLSurFaceView mv;
    public static int flag=0;//0是系统，1是特殊人物，2是其它；
    public HelpView(MainActivity ma, MyGLSurFaceView mv)
    {

        this.ma=ma;
        this.mv=mv;
    }

    @Override
    public void initView() {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
       startView=new StartView(ma,mv);
        try{
            float x=event.getX();
            float y=event.getY();
            if (event.getAction()==MotionEvent.ACTION_UP)
            {
                if (x>systemLeft&&x<systemRight&&y<systemBottom&&y>systemTop)
                {
                    flag=0;
                    menuButton.currview=SYSTEMVIEW;
                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return true;

    }

    @Override
    public void drawView(GL10 gl)
    {
        GLES30.glClear(GLES30.GL_DEPTH_BUFFER_BIT|GLES30.GL_COLOR_BUFFER_BIT);
        GLES30.glEnable(GLES30.GL_DEPTH_TEST);
        GLES30.glEnable(GLES30.GL_CULL_FACE);
        menuButton.currentView=HELPVIEW;
        MatrixState2D.setCamera(0,0,1,0f,0f,0f,0f,1.0f,0.0f);//
        //MatrixState3D.setCamera(mVscale*cx, cy, mVscale*cz, mVscale*tx, ty, mVscale*tz, ux, uy, uz);
        MatrixState2D.pushMatrix();
        //   maintRect.drawSelf(richmanId);
        if (loadState)
        {
            menuButton.drawSelf();
        }
        MatrixState2D.popMatrix();

    }
}
