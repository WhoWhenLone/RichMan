package com.bn.RichMan;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import com.bn.Constant.Constant;
import com.bn.Util.ScreenScaleUtil;
import com.bn.Util.SoundManager;
import com.bn.Util.TextureManager;

import static com.bn.Constant.Constant.SCREEN_HEIGHT;
import static com.bn.Constant.Constant.SCREEN_WIDTH;
import static com.bn.Constant.Constant.screenScaleResult;
import static com.bn.Constant.Constant.screenWidth;
import static com.bn.Constant.Constant.screenHeight;
import static com.bn.Constant.Constant.ratio;
import static com.bn.Util.SoundManager.ismusic;


public class MainActivity extends Activity
{
    MyGLSurFaceView myGLSurFaceView;
    public static SoundManager sound;
    //屏幕对应的宽度和高度
    public static float WIDTH;
    public static float HEIGHT;
    public static AudioManager audioManager;
    public static MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);//设置为全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//设置为横屏模式

        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        if(dm.widthPixels>dm.heightPixels)
        {
            WIDTH=dm.widthPixels;//!!!
            HEIGHT=dm.heightPixels;
        }
        else
        {
            WIDTH=dm.heightPixels;
            HEIGHT=dm.widthPixels;
        }
        ratio=HEIGHT/WIDTH;
        screenWidth=display.getWidth();   //获取屏幕的宽
        screenHeight=display.getHeight();	 //获取屏幕的高

        SCREEN_WIDTH=dm.widthPixels;   //获取屏幕的宽
        SCREEN_HEIGHT=dm.heightPixels;	 //获取屏幕的高
        screenScaleResult = ScreenScaleUtil.calScale(SCREEN_WIDTH,SCREEN_HEIGHT);
        myGLSurFaceView = new MyGLSurFaceView(this);
        setContentView(myGLSurFaceView);
        TextureManager.loadingTexture(myGLSurFaceView,0,2);
        myGLSurFaceView.requestFocus();//获取焦点
        myGLSurFaceView.setFocusableInTouchMode(true);//设置为可触控
        sound = new SoundManager(this);
        //背景音乐
        mediaPlayer =  MediaPlayer.create(this,R.raw.music_a);
        audioManager = (AudioManager)this.getSystemService(Context.AUDIO_SERVICE);
        float steamVolumCurrent = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)  ;
        float steamVolumMax = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)  ;
        float volum = steamVolumCurrent/steamVolumMax  ;
        mediaPlayer.setVolume(volum-0.4f, volum-0.4f);
        mediaPlayer.setLooping(true);
        //mediaPlayer.start();
        Constant.caculatLocationData();

    }
    @Override
    protected  void onResume()
    {
        super.onResume();
        myGLSurFaceView.onResume();
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        myGLSurFaceView.onPause();
    }
}
