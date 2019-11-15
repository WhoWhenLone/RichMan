package com.bn.RichMan;

import android.content.Context;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;

import android.util.Log;
import android.view.MotionEvent;

import com.bn.Util.MatrixState2D;
import com.bn.Util.MatrixState3D;
import com.bn.View.GameView;
import com.bn.View.LoadView;
import com.bn.View.RMAbstractView;

import java.util.Date;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import static com.bn.Constant.Constant.CameraState;

//界面绘制类  系统线程实时调用onDrawFrame方法
//来绘制界面
public class MyGLSurFaceView extends GLSurfaceView
{

    private final float TOUCH_SCALE_FACTOR = 180.0f/320;//角度缩放比例
    public SceneRenderer mRenderer;//场景渲染器
    public static LoadView loadView;
    public static RMAbstractView currView;
    public static  float ratio;
    public MainActivity activity;
    public MyGLSurFaceView(Context context)
    {
        super(context);
        this.setEGLContextClientVersion(3); //设置使用OPENGL ES3.0
        mRenderer = new SceneRenderer();	//创建场景渲染器
        setRenderer(mRenderer);				//设置渲染器
        setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);//设置渲染模式为主动渲染
    }

    @Override
    public boolean onTouchEvent(MotionEvent e)
    {
        if(currView==null)
        {
            return false;
        }
        return currView.onTouchEvent(e);
    }
    private class SceneRenderer implements GLSurfaceView.Renderer
    {
        @Override
        public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig)
        {
            GLES30.glClearColor(0,0,0,1.0f);//设置屏幕背景色RGBA
            GLES30.glEnable(GLES30.GL_DEPTH_TEST);//打开深度检测
            GLES30.glEnable(GLES30.GL_CULL_FACE);//打开背面剪裁
            MatrixState3D.setInitStack(); //初始化变换矩阵
            MatrixState3D.setLightLocation(8, 5, -5);   //初始化光源位置
            MatrixState3D.setLightDirection(0,1f,0f);   //初始化光源方向

            loadView = new LoadView(activity,MyGLSurFaceView.this);//构造加载界面对象
            currView=loadView;//跳转到加载界面
        }

        @Override
        public void onSurfaceChanged(GL10 gl10, int width, int height)
        {
            GLES30.glViewport(0, 0, width, height);//设置视窗大小及位置
             ratio=(float)width/height;//计算GLSurfaceView的宽高比
            if(CameraState==true)
            {
                MatrixState3D.setProjectFrustum(-ratio*0.35f ,ratio*0.35f, -1*0.35f, 1*0.35f, 1,300);//调用此方法计算产生透视投影矩阵
            }
            else
            {
                MatrixState3D.setProjectFrustum(-ratio*0.35f ,ratio*0.35f, -1*0.35f, 1*0.35f, 1,400);//调用此方法计算产生透视投影矩阵
            }

            MatrixState3D.setCamera(0, 0, 3, 0, 0, 0, 0f, 1.0f, 1.0f);//调用此方法设置摄像机9参数位置矩阵
            MatrixState2D.setInitStack();
            MatrixState2D.setCamera(0,0,3,0f,0f,0f,0f,1.0f,0.0f);
            MatrixState2D.setProjectOrtho(-ratio,ratio,-1,1,1,10);
        }

        @Override//绘制工作
        public void onDrawFrame(GL10 gl10)
        {
            Date curDate = new Date(System.currentTimeMillis());
            long longCur=curDate.getTime();
            if(currView !=null)
            {
                currView.drawView(gl10);

               // System.out.println("绘制当前界面绘制当前界面绘制当前界面");
//                Date endDate = new Date(System.currentTimeMillis());
//                long longEnd=endDate.getTime();
//                long ms=longEnd-longCur;
//                long fps=1000/ms;
//                Log.v("FPS: ",fps+"");
//                System.out.println("---------------FPS:"+fps+"+++++++++++++++++++");
            }
        }
    }
}
