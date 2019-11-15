package com.bn.Util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

import com.bn.RichMan.MainActivity;
import com.bn.RichMan.MyGLSurFaceView;
import com.bn.RichMan.R;

import java.util.HashMap;

import static com.bn.Constant.Constant.SOUND_ClickBtn;
import static com.bn.Constant.Constant.SOUND_MenuView;
import static com.bn.Constant.Constant.SOUND_ThrowBtn;
import static com.bn.Constant.Constant.SOUND_UpHome;
import static com.bn.Constant.Constant.SOUND_YanHua;

/**
 * Created by mezzi on 2017/11/11 0011.
 */


@SuppressLint("UseSparseArrays")
public class SoundManager
{
    SoundPool sp ;
    HashMap<Integer	,Integer> hm ;
    MainActivity activity ;

    public MediaPlayer mp  ;
    public MyGLSurFaceView mv;
    public static boolean ismusic=true;
    public SoundManager(MainActivity activity)
    {
        this.activity = activity  ;
        initSound();
    }



    public  void initSound()
    {
        sp = new SoundPool
                (4,
                        AudioManager.STREAM_MUSIC,
                        100
                );
        //String path="sound/";
        hm = new HashMap<Integer, Integer>();
        hm.put(SOUND_ClickBtn, sp.load(activity, R.raw.clickbtn, 1));		//按钮点击声音
        hm.put(SOUND_MenuView, sp.load(activity, R.raw.viewbtn,1));          //界面弹出声音
        hm.put(SOUND_ThrowBtn, sp.load(activity, R.raw.throwbtn,1));          //界面弹出声音
        hm.put(SOUND_UpHome, sp.load(activity, R.raw.uphouse,1));
        hm.put(SOUND_YanHua, sp.load(activity, R.raw.yanhua,1));


    }
    public void playBackGroundMusic(Activity ac, int Id)
    {
        if(MainActivity.sound.mp!=null){
            MainActivity.sound.mp.pause();
            MainActivity.sound.mp=null;
        }
        if(MainActivity.sound.mp==null)
        {
            MainActivity.sound.mp =  MediaPlayer.create(ac, Id);
            AudioManager am = (AudioManager)activity.getSystemService(activity.AUDIO_SERVICE);
            float steamVolumCurrent = am.getStreamVolume(AudioManager.STREAM_MUSIC)  ;
            float steamVolumMax = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC)  ;
            float volum = steamVolumCurrent/steamVolumMax  ;
            MainActivity.sound.mp.setVolume(volum, volum);
            MainActivity.sound.mp.setLooping(true);
            MainActivity.sound.mp.start();
        }
    }
    public void playMusic(int sound,int loop)
    {

        AudioManager am = (AudioManager)activity.getSystemService(activity.AUDIO_SERVICE);
        float steamVolumCurrent = am.getStreamVolume(AudioManager.STREAM_MUSIC)  ;
        float steamVolumMax = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC)  ;
        float volum = steamVolumCurrent/steamVolumMax  ;
        sp.play(hm.get(sound), 1, 1, 1	, loop, 1)  ;
    }


    long preTimeStamp=0;
    public void playGameMusic(int sound,int loop)
    {
        long currTimeStamp=System.nanoTime();
        if(currTimeStamp-preTimeStamp<500000000L)
        {
            return;
        }
        preTimeStamp=currTimeStamp;
        @SuppressWarnings("static-access")
        AudioManager am = (AudioManager)activity.getSystemService(activity.AUDIO_SERVICE);
        float steamVolumCurrent = am.getStreamVolume(AudioManager.STREAM_MUSIC)  ;
        float steamVolumMax = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC)  ;
        float volum = steamVolumCurrent/steamVolumMax  ;
        sp.play(
                hm.get(sound),
                volum,
                volum,
                1	,
                loop,
                1
        );
    }

    public void stopGameMusic(int sound)
    {
        sp.pause(sound);
        sp.stop(sound);
        sp.setVolume(sound, 0, 0);
    }
    public void stopmusic()
    {
        if(MainActivity.sound.mp!=null)
        {
            mp.stop();
        }
    }
    public void pauseSound(){
        if(MainActivity.sound.mp!=null)
        {
            mp.pause();
        }
    }
    public void continueSound(){
        if(MainActivity.sound.mp!=null)
        {
            mp.start();
        }
    }
}

