package com.bn.Util;

import com.bn.RichMan.MainActivity;
import com.bn.RichMan.MyGLSurFaceView;
import com.bn.Thread.MoveThread;

import static com.bn.Constant.Constant.CYState;
import static com.bn.Constant.Constant.Mapscale;
import static com.bn.Constant.Constant.MoveStateArray;
import static com.bn.Constant.Constant.SOUND_ThrowBtn;
import static com.bn.Constant.Constant.cx;
import static com.bn.Constant.Constant.cz;
import static com.bn.Constant.Constant.day;
import static com.bn.Constant.Constant.dianshu;
import static com.bn.Constant.Constant.drawNum;
import static com.bn.Constant.Constant.hosStateArray;
import static com.bn.Constant.Constant.huiheId;
import static com.bn.Constant.Constant.locationDArray;
import static com.bn.Constant.Constant.month;
import static com.bn.Constant.Constant.nextgameState;
import static com.bn.Constant.Constant.overId;
import static com.bn.Constant.Constant.personId;
import static com.bn.Constant.Constant.shaiziState;
import static com.bn.Constant.Constant.shenxianArray;
import static com.bn.Constant.Constant.tx;
import static com.bn.Constant.Constant.tz;
import static com.bn.Constant.Constant.walllen;
import static com.bn.Constant.Constant.year;
import static com.bn.Constant.Constant.zhangdieran;
import static com.bn.Constant.LovoConstant.shaizi;
import static com.bn.Util.SoundManager.ismusic;
import static com.bn.View.GameView.moveThread;

//掷骰子线程
public class ThrowUtil
{
    MyGLSurFaceView mv;
    public void nextGame()
    {

        nextgameState=true;
        if(shaiziState)
        {
            //-----------------开始下一回合的所有操作----------------------
            //神仙作用时间减少
            for (int i=0;i<4;i++)
            {
                //神仙作用天数减少
                if(shenxianArray[i][0]!=0)
                {
                    shenxianArray[i][1]--;
                    //神仙作用天数到达
                    if (shenxianArray[i][1]==0)
                    {
                        //神仙消失
                        shenxianArray[i][0] = 0;
                    }
                }
                //人物在住院中
                if(hosStateArray[i][0]!=0)
                {
                    //天数减少
                    hosStateArray[i][1]=hosStateArray[i][1]-1;
                    System.out.println("天数减少"+hosStateArray[i][1]);
                    if(hosStateArray[i][1]==0)
                    {
                        //出院了
                        hosStateArray[i][0]=0;
                        //设置刚出院的标志位
                        CYState[i] = 1;
                    }
                }
            }
            //回合增加 人物切换到下一位
            huiheId=huiheId+1;
            personId =huiheId%4;
            if(personId==overId)
            {
                personId = (personId+1)%4;
            }

            if (huiheId>4&&huiheId%4==1)
            {
                day=day+1;
                zhangdieran=zhangdieran+1;
                if (zhangdieran%4==0)
                {
                    zhangdieran=0;
                }
                if (day%30==0)
                {
                    month=month+1;
                    day=1;
                }
                if (month%12==0)
                {
                    year=year+1;
                    month=1;
                }
            }

            //判断当前人物是否刚出院
            if (CYState[personId] == 1)
            {
                //显示图片  出院了

                //改变人物当前位置  医院门口
                locationDArray[personId][0] = 13.5f * Mapscale;
                locationDArray[personId][2] = 1.5f * Mapscale;
                //改变状态位未进医院
                CYState[personId] = 0;
            }
            System.out.println("------------------------------------------------------------------------");
            System.out.println("本回合人物id"+personId+"         下一个人物的回合开始      "+huiheId);
            System.out.println("本回合人物id"+personId+"         下一个人物的回合开始      "+huiheId);


            //切换摄像头
            cx=locationDArray[personId][0]/Mapscale*1.2f-11;tx=cx+11;
            cz=locationDArray[personId][2]/Mapscale*1.2f+11;tz=cz-11;

            //播放筛子动画
            shaizi.drawState=true;
            if (ismusic==true)
            {
                try
                {
                    MainActivity.sound.playMusic(SOUND_ThrowBtn,0);
                    //MainActivity.sound.playBackGroundMusic(mv.activity,SOUND_BGM1);
                }
                catch (Exception e1){
                    e1.printStackTrace();
                }
            }

            //当前人物不在医院
            if(hosStateArray[personId][0]==0)
            {
                drawNum=0;
//                dianshu= (int)(Math.random()*6);//dianshu只能取到0-5六个数
//                dianshu++;
                dianshu=4;
                walllen=dianshu*Mapscale;
                try
                {
                    Thread.sleep(3000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                shaizi.drawState=false;
                //改变人物前进标志位 人物前进
                MoveStateArray[personId]=true;
                moveThread = new MoveThread();
                moveThread.start();
                System.out.println("throwthread掷骰子结果：   "+dianshu+"       当前人物前进标志位MoveState:    "+MoveStateArray[personId]);

            }
            //当前人物还在住院中
            else
            {
                //弹出图片 还在住院中
                //剩余天数为
                //hosStateArray[personId][1]/4;
                System.out.println("当前人物住院剩余天数       "+hosStateArray[personId][1]/4);
            }
        }
        shaiziState = false;
    }

}
