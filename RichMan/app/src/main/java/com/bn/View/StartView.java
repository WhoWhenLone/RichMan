package com.bn.View;

import android.opengl.GLES30;
import android.opengl.Matrix;
import android.view.MotionEvent;

import com.bn.RichMan.MainActivity;
import com.bn.RichMan.MyGLSurFaceView;
import com.bn.Scenes.TextureRectangle2D;
import com.bn.Util.MatrixState2D;
import com.bn.Util.MatrixState3D;

import javax.microedition.khronos.opengles.GL10;
import static com.bn.Constant.Constant.*;
import static com.bn.Constant.Constant.gameMenuView;
import static com.bn.Constant.Constant.menuButton;
import static com.bn.Constant.IdDataConstant.*;
import static com.bn.RichMan.MyGLSurFaceView.currView;
import static com.bn.Util.SoundManager.ismusic;
import static com.bn.View.MenuButton.INITIALVIEW;

/**
 * Created by Administrator on 2017/9/1.
 */
//游戏开始界面  点击开始 到游戏界面
public class StartView extends RMAbstractView{

    MainActivity ma;
    MyGLSurFaceView mv;

    public StartView(MainActivity ma,MyGLSurFaceView mv)
    {
        this.ma=ma;
        this.mv=mv;
    }

    @Override
    public void initView() {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gameMenuView = new GameMenuView(ma,mv);
        if (loadState)
        {
            try
            {
                float x = event.getX();
                float y = event.getY();

                if (event.getAction()==MotionEvent.ACTION_UP)
                {
                    if (menuButton.currentView==INITIALVIEW)
                    {
                        if (x>playLeft&&x<playRight&&
                                y<playBottom&&y>playTop)
                        {
                            gameView.soundOfButton();
                            System.out.print("点击到了开始按钮");
                            currView=gameMenuView;
                        }
                        else if (x>yinyueLeft&&x<yinyueRight&&y>yinyueTop&&y<yinyueBottom)
                        {
                            gameView.soundOfButton();
                            if (ismusic)
                            {
                                ismusic=false;
                                MainActivity.mediaPlayer.pause();
                            }else
                            {
                                ismusic=true;
                                MainActivity.mediaPlayer.start();
                            }
                        }
                    }

                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return true;

        }else
        {
            return  false;
        }


    }

    @Override
    public void drawView(GL10 gl) {
        GLES30.glClear(GLES30.GL_DEPTH_BUFFER_BIT|GLES30.GL_COLOR_BUFFER_BIT);
        GLES30.glEnable(GLES30.GL_DEPTH_TEST);
        GLES30.glEnable(GLES30.GL_BLEND);
        GLES30.glEnable(GLES30.GL_CULL_FACE);
        menuButton.currentView=INITIALVIEW;
        MatrixState2D.setCamera(0,0,1,0f,0f,0f,0f,1.0f,0.0f);//
        MatrixState2D.pushMatrix();
        if (loadState)
        {
            menuButton.drawSelf();
        }
        MatrixState2D.popMatrix();

        GLES30.glEnable(GLES30.GL_DEPTH_TEST);
        GLES30.glDisable(GLES30.GL_BLEND);
    }
}
