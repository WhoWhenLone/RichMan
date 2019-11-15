package com.bn.View;

import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.opengl.GLES30;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.MotionEvent;
import com.bn.RichMan.MainActivity;
import com.bn.RichMan.MyGLSurFaceView;
import com.bn.Scenes.ScenesData;
import com.bn.Util.CDPreferences;
import com.bn.Util.MatrixState2D;
import com.bn.Util.MatrixState3D;

import java.util.Date;

import javax.microedition.khronos.opengles.GL10;
import static com.bn.Constant.Constant.*;
import static com.bn.Constant.IdDataConstant.*;
import static com.bn.Constant.LovoConstant.*;
import static com.bn.RichMan.MyGLSurFaceView.currView;
import static com.bn.RichMan.MyGLSurFaceView.ratio;
import static com.bn.Util.CDPreferences.GetCDState;
import static com.bn.Util.CDPreferences.GetCDState2;
import static com.bn.Util.CDPreferences.GetCDState3;
import static com.bn.Util.CDPreferences.GetCDState4;
import static com.bn.Util.CDPreferences.GetCDTimeDay1;
import static com.bn.Util.CDPreferences.GetCDTimeDay2;
import static com.bn.Util.CDPreferences.GetCDTimeDay3;
import static com.bn.Util.CDPreferences.GetCDTimeHour1;
import static com.bn.Util.CDPreferences.GetCDTimeHour2;
import static com.bn.Util.CDPreferences.GetCDTimeHour3;
import static com.bn.Util.CDPreferences.GetCDTimeHour4;
import static com.bn.Util.CDPreferences.GetCDTimeMin1;
import static com.bn.Util.CDPreferences.GetCDTimeMin2;
import static com.bn.Util.CDPreferences.GetCDTimeMin3;
import static com.bn.Util.CDPreferences.GetCDTimeMin4;
import static com.bn.Util.CDPreferences.GetCDTimeMonth1;
import static com.bn.Util.CDPreferences.GetCDTimeMonth2;
import static com.bn.Util.CDPreferences.GetCDTimeMonth3;
import static com.bn.Util.CDPreferences.GetCDTimeMonth4;
import static com.bn.Util.CDPreferences.GetCDTimeSec1;
import static com.bn.Util.CDPreferences.GetCDTimeSec2;
import static com.bn.Util.CDPreferences.GetCDTimeSec3;
import static com.bn.Util.CDPreferences.GetCDTimeSec4;
import static com.bn.Util.CDPreferences.GetCDTimeYear1;
import static com.bn.Util.CDPreferences.GetCDTimeYear2;
import static com.bn.Util.CDPreferences.GetCDTimeYear3;
import static com.bn.Util.CDPreferences.GetCDTimeYear4;
import static com.bn.Util.CDPreferences.GetCDTimecdDay4;
import static com.bn.View.MenuButton.GAMEMENUVIEW;

public class GameMenuView extends RMAbstractView {
    MainActivity ma;
    MyGLSurFaceView mv;
    private float mPreviousX;
    private int mingNum=1;
    public GameMenuView(MainActivity ma, MyGLSurFaceView mv)
    {
        this.ma=ma;
        this.mv=mv;
    }
    @Override
    public void initView() {
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        try
        {
            float x=event.getX();
            float y=event.getY();
            if(event.getAction()==MotionEvent.ACTION_MOVE)
            {
                float dx = x - mPreviousX;
                dx=dx/screenHeight;
                ScenesData.mingdata[0][3]+=dx*200;
            }
            if (event.getAction()==MotionEvent.ACTION_UP)
            {
                if(!cundangView.drawState)
                {
                    if (menuButton.currentView==GAMEMENUVIEW)
                    {
                        if (x>startLeft&&x<startRight&&y<startBottom&&y>startTop)
                        {
                            gameView.soundOfButton();
                            gameView=new GameView(ma,mv);
                            currView=gameView;
                        }else if (x>backLeft&&x<backRight&&y>backTop&&y<backBottom)
                        {
                            gameView.soundOfButton();
                            startView=new StartView(ma,mv);
                            currView=startView;
                        }else if (x>selectleftLeft&&x<selectleftRight&&y>selectleftTop&&y<selectleftBottom)
                        {
                            mingNum--;
                            if(mingNum==0)
                            {
                                mingNum=4;
                            }
                            gameView.soundOfButton();

                        }else if (x>selectrightLeft&&x<selectrightRight&&y>selectrightTop&&y<selectrightBottom)
                        {
                            mingNum++;
                            if(mingNum==5)
                            {
                                mingNum =1;
                            }
                            gameView.soundOfButton();
                        }
                        else if (x>continueLeft&&x<continueRight&&y>continueTop&&y<continueBottom)
                        {
                            //有存档 继续游戏
                            if (cundangState==1||cundangState2==1||cundangState3==1||cundangState4==1)
                            {
                                GetTime();
                                String s1=year1+""+"/"+month1+""+"/"+day1+" "+"/"+hour1+""+"/"+min1+""+"/"+sec1+"";
                                String s2=year2+""+"/"+month2+""+"/"+day2+" "+"/"+hour2+""+"/"+min2+""+"/"+sec2+"";
                                String s3=year3+""+"/"+month3+""+"/"+day3+" "+"/"+hour3+""+"/"+min3+""+"/"+sec3+"";
                                String s4=year4+""+"/"+month4+""+"/"+day4+" "+"/"+hour4+""+"/"+min4+""+"/"+sec4+"";
                                compare_date(s1,s2,s3,s4);
                                currView=gameView;
                            }
                            //没有存档无法继续
                            else
                            {
                                noContinue.drawState = true;
                                try
                                {
                                    Thread.sleep(1500);
                                }
                                catch (Exception e)
                                {
                                    e.printStackTrace();
                                }
                                noContinue.drawState = false;
                            }
                        }
                        else if (x>readLeft&&x<readRight&&y>readTop&&y<readBottom)
                        {
                            gameView.soundOfButton();
                            cundangView.drawState = true;
                            cundangState=GetCDState();
                            cundangState2=GetCDState2();
                            cundangState3=GetCDState3();
                            cundangState4=GetCDState4();

                            year1=GetCDTimeYear1();
                            month1=GetCDTimeMonth1();
                            day1=GetCDTimeDay1();
                            hour1=GetCDTimeHour1();
                            min1=GetCDTimeMin1();

                            year2=GetCDTimeYear2();
                            month2=GetCDTimeMonth2();
                            day2=GetCDTimeDay2();
                            hour2=GetCDTimeHour2();
                            min2=GetCDTimeMin2();

                            year3=GetCDTimeYear3();
                            month3=GetCDTimeMonth3();
                            day3=GetCDTimeDay3();
                            hour3=GetCDTimeHour3();
                            min3=GetCDTimeMin3();

                            year4=GetCDTimeYear4();
                            month4=GetCDTimeMonth4();
                            day4=GetCDTimecdDay4();
                            hour4=GetCDTimeHour4();
                            min4=GetCDTimeMin4();
                        }
                    }
                }
                else
                {
                    //点击读取存档的按钮
                    if (x>cunbackLeft&&x<cunbackRight&&y>cunbackTop&&y<cunbackBottom)
                    {
                        gameView.soundOfButton();
                        cundangView.drawState = false;
                    }else if (x>cundang1Left&&x<cundang1Right&&y>cundang1Top&&y<cundang1Bottom)
                    {
                        if (cundangState==1)
                        {
                            CDPreferences.readData();
                            cundangView.drawState = false;
                            currView=gameView;
                        }
                    }
                    else if (x>cundang2Left&&x<cundang2Right&&y>cundang2Top&&y<cundang2Bottom)
                    {
                        if (cundangState2==1)
                        {
                            CDPreferences.readData2();
                            cundangView.drawState = false;
                            currView=gameView;
                        }
                    }
                    else if (x>cundang3Left&&x<cundang3Right&&y>cundang3Top&&y<cundang3Bottom)
                    {
                        if (cundangState3==1)
                        {
                            CDPreferences.readData3();
                            cundangView.drawState = false;
                            currView=gameView;
                        }
                    }
                    else if (x>cundang4Left&&x<cundang4Right&&y>cundang4Top&&y<cundang4Bottom)
                    {
                        if (cundangState4==1)
                        {
                            CDPreferences.readData4();
                            cundangView.drawState = false;
                            currView=gameView;
                        }
                    }
                }
            }
            mPreviousX=x;
        }catch(Exception e)
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
        GLES30.glEnable(GLES30.GL_BLEND);
        GLES30.glEnable(GLES30.GL_CULL_FACE);
        menuButton.currentView=GAMEMENUVIEW;
        MatrixState2D.setCamera(0,0,1,0f,0f,0f,0f,1.0f,0.0f);
        MatrixState2D.pushMatrix();
        if (loadState)
        {
            menuButton.drawSelf();
        }
        MatrixState2D.popMatrix();
        MatrixState3D.setProjectFrustum(-ratio*0.35f ,ratio*0.35f, -1*0.35f, 1*0.35f, 1,400);//调用此方法计算产生透视投影矩阵
        MatrixState3D.pushMatrix();
        MatrixState3D.setCamera(0, 0, 10, 0, 0, 0, 0f, 1.0f, 0f);
        MatrixState3D.popMatrix();
        if(!cundangView.drawState&&!noContinue.drawState)
        {
            if(mingNum==1){
                //褐色
                //人物模型初始化
                personArray[0][0]=bnHongD;
                personArray[0][1]=bnHongJ;
                personArray[1][0]=bnHeD;
                personArray[1][1]=bnHeJ;
                personArray[2][0]=bnZongD;
                personArray[2][1]=bnZongJ;
                personArray[3][0]=bnLanD;
                personArray[3][1]=bnLanJ;
                //人物头像初始化
                persontxArray[0] = pzeroId;
                persontxArray[1] = pthreeId;
                persontxArray[2] = ptwoId;
                persontxArray[3] = poneId;
                bnHeD.draw(-0.8f*Mapscale,-0.5f*Mapscale,-3f*Mapscale,ScenesData.mingdata[0][3]);
            }else if(mingNum==2){
                //红色
                //人物模型初始化
                personArray[0][0]=bnLanD;
                personArray[0][1]=bnLanJ;
                personArray[1][0]=bnHongD;
                personArray[1][1]=bnHongJ;
                personArray[2][0]=bnZongD;
                personArray[2][1]=bnZongJ;
                personArray[3][0]=bnHeD;
                personArray[3][1]=bnHeJ;
                //人物头像初始化
                persontxArray[0] = poneId;
                persontxArray[1] = pzeroId;
                persontxArray[2] = ptwoId;
                persontxArray[3] = pthreeId;
                bnHongD.draw(-0.8f*Mapscale,-0.5f*Mapscale,-3f*Mapscale,ScenesData.mingdata[0][3]);
            }else if(mingNum==3){
                //人物模型初始化
                //蓝色
                personArray[0][0]=bnHongD;
                personArray[0][1]=bnHongJ;
                personArray[1][0]=bnLanD;
                personArray[1][1]=bnLanJ;
                personArray[2][0]=bnZongD;
                personArray[2][1]=bnZongJ;
                personArray[3][0]=bnHeD;
                personArray[3][1]=bnHeJ;
                //人物头像初始化
                persontxArray[0] = pzeroId;
                persontxArray[1] = poneId;
                persontxArray[2] = ptwoId;
                persontxArray[3] = pthreeId;
                bnLanD.draw(-0.8f*Mapscale,-0.5f*Mapscale,-3f*Mapscale,ScenesData.mingdata[0][3]);
            }else if(mingNum==4){
                //人物模型初始化
                //棕色
                personArray[0][0]=bnHongD;
                personArray[0][1]=bnHongJ;
                personArray[1][0]=bnZongD;
                personArray[1][1]=bnZongJ;
                personArray[2][0]=bnLanD;
                personArray[2][1]=bnLanJ;
                personArray[3][0]=bnHeD;
                personArray[3][1]=bnHeJ;
                //人物头像初始化
                persontxArray[0] = pzeroId;
                persontxArray[1] = ptwoId;
                persontxArray[2] = poneId;
                persontxArray[3] = pthreeId;
                bnZongD.draw(-0.8f*Mapscale,-0.5f*Mapscale,-3f*Mapscale,ScenesData.mingdata[0][3]);
            }
        }
        GLES30.glEnable(GLES30.GL_DEPTH_TEST);
        GLES30.glDisable(GLES30.GL_BLEND);
    }
    public void GetTime()
    {
        year1=GetCDTimeYear1();
        month1=GetCDTimeMonth1();
        day1=GetCDTimeDay1();
        hour1=GetCDTimeHour1();
        min1=GetCDTimeMin1();
        sec1=GetCDTimeSec1();

        year2=GetCDTimeYear2();
        month2=GetCDTimeMonth2();
        day2=GetCDTimeDay2();
        hour2=GetCDTimeHour2();
        min2=GetCDTimeMin2();
        sec2=GetCDTimeSec2();

        year3=GetCDTimeYear3();
        month3=GetCDTimeMonth3();
        day3=GetCDTimeDay3();
        hour3=GetCDTimeHour3();
        min3=GetCDTimeMin3();
        sec3=GetCDTimeSec3();

        year4=GetCDTimeYear4();
        month4=GetCDTimeMonth4();
        day4=GetCDTimecdDay4();
        hour4=GetCDTimeHour4();
        min4=GetCDTimeMin4();
        sec4=GetCDTimeSec4();
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void compare_date(String date1, String date2, String date3, String date4)
    {
        DateFormat df=new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss");
        try
        {
            Date dt1=df.parse(date1);
            Date dt2=df.parse(date2);
            Date dt3=df.parse(date3);
            Date dt4=df.parse(date4);
            if (dt1.getTime()>dt2.getTime()||dt1.getTime()>dt3.getTime()||dt1.getTime()>dt4.getTime())
            {
                CDPreferences.readData();
            }else if (dt2.getTime()>dt3.getTime()||dt2.getTime()>dt4.getTime())
            {
                CDPreferences.readData2();
            }else if (dt3.getTime()>dt4.getTime())
            {
                CDPreferences.readData3();
            }else
            {
                CDPreferences.readData4();
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
