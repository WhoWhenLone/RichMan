package com.bn.Thread;

import static com.bn.Constant.Constant.*;
import static com.bn.Constant.IdDataConstant.BZ_heId;
import static com.bn.Constant.IdDataConstant.BZ_hongId;
import static com.bn.Constant.IdDataConstant.BZ_lanId;
import static com.bn.Constant.IdDataConstant.BZ_zongId;
import static com.bn.Constant.IdDataConstant.houseId;
import static com.bn.Constant.IdDataConstant.level2HouseId;
import static com.bn.Constant.LovoConstant.lovoBZMing;
import static com.bn.Constant.LovoConstant.lovoHouse1;
import static com.bn.Constant.LovoConstant.lovoHouse2;
import static com.bn.Constant.LovoConstant.lovoHouse3;
import static com.bn.Constant.LovoConstant.rectangle2Ds;
import static com.bn.View.GameView.moveThread;

//根据当前的 player 的状态 来进入不同的 走路方法
// 单独写拐点 遇到拐点时  根据走路的方向 拐弯
//直接根据 公路的id  以及 前进的 格数

//每当掷骰子 完毕 传递点数  改变 MoveState状态
//根据当前的 personId 来改变对应数组的数据
//数据包括  x  y   z  angle
public class MoveThread extends Thread
{
    float dx=0;
    float dz=0;
    @Override
    public void run()
    {
        while(MoveStateArray[personId])
        {
            switch (roadIdArray[personId]) {
                case 1:
                    locationDArray[personId][2]+=0.065f;
                    GoArray[personId]=4;
                    changeLocation();
                    changeCamera();
                    if(walllen <= dx+dz)
                    {
                        changeCurrRoadId();
                        //-------人物走路停止 调用方法
                        // 买地 付费 升级楼房等等
                        System.out.println("MoveState  to   changeSale" + roadIdArray[personId]);
                        if(nextgameState==true)
                        {
                            gameView.changeSale(currentRoadArray[personId]);
                        }
                    }
                    if (locationDArray[personId][2] > 6.5f * Mapscale && walllen >= dx+dz)
                    {
                        locationDArray[personId][2] = 6.5f*Mapscale;
                        locationDArray[personId][3]=90;
                        locationDArray[personId][0]+=0.065f;
                        roadIdArray[personId]=2;
                        GoArray[personId]=1;
                        changeCamera();
                    }
                    break;
                case 2:
                    locationDArray[personId][0]+=0.065f;
                    GoArray[personId]=1;
                    changeLocation();
                    changeCamera();
                    if(walllen*0.98f <= dx+dz)
                    {
                        //-------人物走路停止 调用方法
                        // 买地 付费 升级楼房等等
                        changeCurrRoadId();
                        System.out.println("MoveState  to   changeSale" + roadIdArray[personId]);
                        if(nextgameState==true)
                        {
                            gameView.changeSale(currentRoadArray[personId]);
                        }
                    }
                    if (locationDArray[personId][0] > 13.5f * Mapscale && walllen*0.98f >= dx+dz)
                    {
                        locationDArray[personId][0] = 13.5f*Mapscale;
                        locationDArray[personId][3]=180;
                        locationDArray[personId][2]-=0.065f;
                        roadIdArray[personId]=3;
                        GoArray[personId]=2;
                        changeCamera();
                    }
                    break;
                case 3:
                    locationDArray[personId][2]-=0.065f;
                    GoArray[personId]=2;
                    changeLocation();
                    changeCamera();
                    if(walllen <= dx+dz)
                    {
//                        roadIdArray[personId]=4;
                        //-------人物走路停止 调用方法
                        // 买地 付费 升级楼房等等
                        changeCurrRoadId();
                        System.out.println("MoveState  to   changeSale" + roadIdArray[personId]);
                        if(nextgameState==true)
                        {
                            gameView.changeSale(currentRoadArray[personId]);
                        }
                    }
                    if (locationDArray[personId][2]<- 2.5f * Mapscale && walllen >= dx+dz)
                    {
                        locationDArray[personId][2] = -2.5f*Mapscale;
                        locationDArray[personId][3]=270;
                        locationDArray[personId][0]-=0.065f;
                        roadIdArray[personId]=4;
                        GoArray[personId]=3;
                        changeCamera();
                    }
                    break;
                case 4:
                    locationDArray[personId][0]-=0.065f;
                    GoArray[personId]=3;
                    changeLocation();
                    changeCamera();
                    if(walllen <= dx+dz)
                    {
                        //-------人物走路停止 调用方法
                        // 买地 付费 升级楼房等等
                        changeCurrRoadId();
                        System.out.println("MoveState  to   changeSale" + roadIdArray[personId]);
                        if(nextgameState==true)
                        {
                            gameView.changeSale(currentRoadArray[personId]);
                        }
                    }
                    if (locationDArray[personId][0]<8.5f * Mapscale && walllen >= dx+dz)
                    {
                        locationDArray[personId][0] = 8.5f*Mapscale;
                        locationDArray[personId][3]=180;
                        locationDArray[personId][2]-=0.065f;
                        roadIdArray[personId]=5;
                        GoArray[personId]=2;
                        changeCamera();
                    }
                    break;
                case 5:
                    locationDArray[personId][2]-=0.065f;
                    GoArray[personId]=2;
                    changeLocation();
                    changeCamera();
                    if(walllen <= dx+dz)
                    {
                        //-------人物走路停止 调用方法
                        // 买地 付费 升级楼房等等
                        changeCurrRoadId();
                        System.out.println("MoveState  to   changeSale" + roadIdArray[personId]);
                        if(nextgameState==true)
                        {
                            gameView.changeSale(currentRoadArray[personId]);
                        }
                    }
                    if (locationDArray[personId][2]<-8.5f * Mapscale && walllen >= dx+dz)
                    {
                        locationDArray[personId][2] = -8.5f*Mapscale;
                        locationDArray[personId][3]=270;
                        locationDArray[personId][0]-=0.065f;
                        roadIdArray[personId]=6;
                        GoArray[personId]=3;
                        changeCamera();
                    }
                    break;
                case 6:
                    locationDArray[personId][0]-=0.065f;
                    GoArray[personId]=3;
                    changeLocation();
                    changeCamera();
                    if(walllen <= dx+dz)
                    {
                        //-------人物走路停止 调用方法
                        // 买地 付费 升级楼房等等
                        changeCurrRoadId();
                        System.out.println("MoveState  to   changeSale" + roadIdArray[personId]);
                        if(nextgameState==true)
                        {
                            gameView.changeSale(currentRoadArray[personId]);
                        }
                    }
                    if (locationDArray[personId][0]<-1.5f * Mapscale && walllen >= dx+dz)
                    {
                        locationDArray[personId][0] = -1.5f*Mapscale;
                        locationDArray[personId][3]=0;
                        locationDArray[personId][2]+=0.065f;
                        roadIdArray[personId]=7;
                        GoArray[personId]=4;
                        changeCamera();
                    }
                    break;
                case 7:
                    locationDArray[personId][2]+=0.065f;
                    GoArray[personId]=4;
                    changeLocation();
                    changeCamera();
                    if(walllen <= dx+dz)
                    {
                        //-------人物走路停止 调用方法
                        // 买地 付费 升级楼房等等
                        changeCurrRoadId();
                        System.out.println("MoveState  to   changeSale" + roadIdArray[personId]);
                        if(nextgameState==true)
                        {
                            gameView.changeSale(currentRoadArray[personId]);
                        }
                    }
                    if (locationDArray[personId][2]>-3.5f * Mapscale && walllen >= dx+dz)
                    {
                        locationDArray[personId][2] = -3.5f*Mapscale;
                        locationDArray[personId][3]=270;
                        locationDArray[personId][0]-=0.065f;
                        roadIdArray[personId]=8;
                        GoArray[personId]=3;
                        changeCamera();
                    }
                    break;
                case 8:
                    locationDArray[personId][0]-=0.065f;
                    GoArray[personId]=3;
                    changeLocation();
                    changeCamera();
                    if(walllen <= dx+dz)
                    {
                        //-------人物走路停止 调用方法
                        // 买地 付费 升级楼房等等
                        changeCurrRoadId();
                        System.out.println("MoveState  to   changeSale" + roadIdArray[personId]);
                        if(nextgameState==true)
                        {
                            gameView.changeSale(currentRoadArray[personId]);
                        }
                    }
                    if (locationDArray[personId][0]<-6.5f * Mapscale && walllen >= dx+dz)
                    {
                        locationDArray[personId][0] = -6.5f*Mapscale;
                        locationDArray[personId][3]=180;
                        locationDArray[personId][2]-=0.065f;
                        roadIdArray[personId]=9;
                        GoArray[personId]=2;
                        changeCamera();
                    }
                    break;
                case 9:
                    locationDArray[personId][2]-=0.065f;
                    GoArray[personId]=2;
                    changeLocation();
                    changeCamera();
                    if(walllen <= dx+dz)
                    {
                        //-------人物走路停止 调用方法
                        // 买地 付费 升级楼房等等
                        changeCurrRoadId();
                        System.out.println("MoveState  to   changeSale" + roadIdArray[personId]);
                        if(nextgameState==true)
                        {
                            gameView.changeSale(currentRoadArray[personId]);
                        }
                    }
                    if (locationDArray[personId][2]<-8.5f * Mapscale && walllen >= dx+dz)
                    {
                        locationDArray[personId][2] = -8.5f*Mapscale;
                        locationDArray[personId][3]=270;
                        locationDArray[personId][0]-=0.065f;
                        roadIdArray[personId]=10;
                        GoArray[personId]=3;
                        changeCamera();
                    }
                    break;
                case 10:
                    locationDArray[personId][0]-=0.065f;
                    GoArray[personId]=3;
                    changeLocation();
                    changeCamera();
                    if(walllen <= dx+dz)
                    {
                        changeCurrRoadId();
                        //-------人物走路停止 调用方法
                        // 买地 付费 升级楼房等等
                        System.out.println("MoveState  to   changeSale" + roadIdArray[personId]);
                        if(nextgameState==true)
                        {
                            gameView.changeSale(currentRoadArray[personId]);
                        }
                    }
                    if (locationDArray[personId][0]<-12.5f * Mapscale && walllen >= dx+dz)
                    {
                        locationDArray[personId][0] = -12.5f*Mapscale;
                        locationDArray[personId][3]=0;
                        locationDArray[personId][2]+=0.065f;
                        roadIdArray[personId]=11;
                        GoArray[personId]=4;
                        changeCamera();
                    }
                    break;
                case 11:
                    locationDArray[personId][2]+=0.065f;
                    GoArray[personId]=4;
                    changeLocation();
                    changeCamera();
                    if(walllen <= dx+dz)
                    {
                        //-------人物走路停止 调用方法
                        // 买地 付费 升级楼房等等
                        changeCurrRoadId();
                        System.out.println("MoveState  to   changeSale" + roadIdArray[personId]);
                        if(nextgameState==true)
                        {
                            gameView.changeSale(currentRoadArray[personId]);
                        }
                    }
                    if (locationDArray[personId][2]>8.5f * Mapscale && walllen >= dx+dz)
                    {
                        locationDArray[personId][2] = 8.5f*Mapscale;
                        locationDArray[personId][3]=90;
                        locationDArray[personId][0]+=0.065f;
                        roadIdArray[personId]=12;
                        GoArray[personId]=1;
                        changeCamera();
                    }
                    break;
                case 12:
                    locationDArray[personId][0]+=0.065f;
                    GoArray[personId]=1;
                    changeLocation();
                    changeCamera();
                    if(walllen <= dx+dz)
                    {
                        //-------人物走路停止 调用方法
                        // 买地 付费 升级楼房等等
                        changeCurrRoadId();
                        System.out.println("MoveState  to   changeSale" + roadIdArray[personId]);
                        if(nextgameState==true)
                        {
                            gameView.changeSale(currentRoadArray[personId]);
                        }
                    }
                    if (locationDArray[personId][0]>-3.5f * Mapscale && walllen >= dx+dz)
                    {
                        locationDArray[personId][0] = -3.5f*Mapscale;
                        locationDArray[personId][3]=180;
                        locationDArray[personId][2]-=0.065f;
                        roadIdArray[personId]=13;
                        GoArray[personId]=2;
                        changeCamera();
                    }
                    break;
                case 13:
                    locationDArray[personId][2]-=0.065f;
                    GoArray[personId]=2;
                    changeLocation();
                    changeCamera();
                    if(walllen <= dx+dz)
                    {
                        //-------人物走路停止 调用方法
                        // 买地 付费 升级楼房等等
                        changeCurrRoadId();
                        System.out.println("MoveState  to   changeSale" + roadIdArray[personId]);
                        if(nextgameState==true)
                        {
                            gameView.changeSale(currentRoadArray[personId]);
                        }
                    }
                    if (locationDArray[personId][2]<2.5f * Mapscale && walllen >= dx+dz)
                    {
                        locationDArray[personId][2] = 2.5f*Mapscale;
                        locationDArray[personId][3]=90;
                        locationDArray[personId][0]+=0.065f;
                        roadIdArray[personId]=14;
                        GoArray[personId]=1;
                        changeCamera();
                    }
                    break;
                case 14:
                    locationDArray[personId][0]+=0.065f;
                    GoArray[personId]=1;
                    changeLocation();
                    changeCamera();
                    if(walllen <= dx+dz)
                    {
                        //-------人物走路停止 调用方法
                        // 买地 付费 升级楼房等等
                        changeCurrRoadId();
                        System.out.println("MoveState  to   changeSale" + roadIdArray[personId]);
                        if(nextgameState==true)
                        {
                            gameView.changeSale(currentRoadArray[personId]);
                        }
                    }
                    if (locationDArray[personId][0]>1.5f * Mapscale && walllen >= dx+dz)
                    {
                        locationDArray[personId][0] = 1.5f*Mapscale;
                        locationDArray[personId][3]=0;
                        locationDArray[personId][2]+=0.065f;
                        roadIdArray[personId]=1;
                        GoArray[personId]=4;
                        changeCamera();
                    }
                    break;
            }
            try{
                sleep(8);
            }
            catch(Exception e )
            {
                e.printStackTrace();
            }
        }
    }
    //根据当前  路的编号状态 来判断  地皮的状态 是否购买 还是
    //获取当前人物的所在  公路的状态
    //改变当前人物位置  摄像机移动
    //总共的方块公路有104块
    public void changeLocation()
    {
        dx =Math.abs(locationDArray[personId][0]-locationJArray[personId][0]);
        dz =Math.abs(locationDArray[personId][2]-locationJArray[personId][2]);
    }

    public void changeCurrRoadId()
    {
        locationJArray[personId][0] = locationDArray[personId][0];
        locationJArray[personId][2] = locationDArray[personId][2];
        locationJArray[personId][3] = locationDArray[personId][3];
        //MoveState=false;
        MoveStateArray[personId] = false;

        currentRoadArray[personId] =currentRoadArray[personId] + dianshu;
        currentRoadArray[personId] =currentRoadArray[personId] % cubeRoadArray.length;
        if(currentRoadArray[personId]==0)
        {
            currentRoadArray[personId]=1;
        }
    }

    public void changeCamera()
    {
        //上帝视角
        cx=locationDArray[personId][0]/Mapscale*1.2f-11;tx=cx+11;
        cz=locationDArray[personId][2]/Mapscale*1.2f+11;tz=cz-11;
        //第一人称视角 每条路的偏移量都不一样
        if(roadIdArray[personId]==1)
        {
            Fcx = locationDArray[personId][0]/Mapscale+1.05f;
            Fcz = locationDArray[personId][2]/Mapscale*0.9f-0.5f;
            Ftx = Fcx;
            Ftz=Fcz+10;
        }
        else if(roadIdArray[personId]==2)
        {
            Fcx=locationDArray[personId][0]/Mapscale*0.9f-1.0f;//摄像机x位置
            Fcz=locationDArray[personId][2]/Mapscale+4.4f;//摄像机z位置0
            Ftx=Fcx+10;//目标点x位置
            Ftz=Fcz;
        }
        else if(roadIdArray[personId]==3)
        {
            Fcx=locationDArray[personId][0]/Mapscale+9.0f;//摄像机x位置
            Fcz=locationDArray[personId][2]/Mapscale*0.9f+6.4f;//摄像机z位置0
            Ftx=Fcx;//目标点x位置
            Ftz=Fcz-10;//目标点z位置
        }
        else if(roadIdArray[personId]==4)
        {
            Fcx=locationDArray[personId][0]/Mapscale*0.9f+9.3f;//摄像机x位置
            Fcz=locationDArray[personId][2]/Mapscale-1.5f;//摄像机z位置0
            Ftx=Fcx-10;//目标点x位置
            Ftz=Fcz;//目标点z位置
        }
        else if(roadIdArray[personId]==5)
        {
            Fcx=locationDArray[personId][0]/Mapscale+5.7f;//摄像机x位置
            Fcz=locationDArray[personId][2]/Mapscale*0.9f;//摄像机z位置0
            Ftx=Fcx;//目标点x位置
            Ftz=Fcz-10;//目标点z位置
        }
        else if(roadIdArray[personId]==6)
        {
            if(personId==3)
            {
                Fcx = locationDArray[personId][0]/Mapscale*0.9f+8.65f;
                Fcz = locationDArray[personId][2]/Mapscale-5.6f;
                Ftx = Fcx-10;
                Ftz=Fcz;
            }
            else
            {
                Fcx = locationDArray[personId][0]/Mapscale*0.9f+3.65f;
                Fcz = locationDArray[personId][2]/Mapscale-5.6f;
                Ftx = Fcx-10;
                Ftz=Fcz;
            }

        }
        else if(roadIdArray[personId]==7)
        {
            if(personId==1||personId==3)
            {
                Fcx=locationDArray[personId][0]/Mapscale-0.95f;//摄像机x位置
                Fcz=locationDArray[personId][2]/Mapscale*0.9f-8.8f;//摄像机z位置0
                Ftx=Fcx;//目标点x位置
                Ftz=Fcz+10;//目标点z位置
            }
            else
            {
                Fcx=locationDArray[personId][0]/Mapscale-0.95f;//摄像机x位置
                Fcz=locationDArray[personId][2]/Mapscale*0.9f-5.8f;//摄像机z位置0
                Ftx=Fcx;//目标点x位置
                Ftz=Fcz+10;//目标点z位置
            }

        }
        else if(roadIdArray[personId]==8)
        {
            Fcx=locationDArray[personId][0]/Mapscale*0.9f+1.5f;//摄像机x位置
            Fcz=locationDArray[personId][2]/Mapscale-2.4f;//摄像机z位置0
            Ftx=Fcx-10;//目标点x位置
            Ftz=Fcz;//目标点z位置
        }
        else if(roadIdArray[personId]==9)
        {
            Fcx=locationDArray[personId][0]/Mapscale-4.3f;//摄像机x位置
            Fcz=locationDArray[personId][2]/Mapscale*0.9f;//摄像机z位置0
            Ftx=Fcx;//目标点x位置
            Ftz=Fcz-10;//目标点z位置
        }
        else if(roadIdArray[personId]==10)
        {
            Fcx=locationDArray[personId][0]/Mapscale*0.9f-1.2f;//摄像机x位置
            Fcz=locationDArray[personId][2]/Mapscale-5.5f;//摄像机z位置0
            Ftx=Fcx-10;//目标点x位置
            Ftz=Fcz;//目标点z位置
        }
        else if(roadIdArray[personId]==11)
        {
            Fcx=locationDArray[personId][0]/Mapscale-8.3f;//摄像机x位置
            Fcz=locationDArray[personId][2]/Mapscale*0.9f-8f;//摄像机z位置0
            Ftx=Fcx;//目标点x位置
            Ftz=Fcz+10;//目标点z位置
        }
        else if(roadIdArray[personId]==12)
        {
            Fcx=locationDArray[personId][0]/Mapscale*0.9f-11f;//摄像机x位置
            Fcz=locationDArray[personId][2]/Mapscale+5.7f;//摄像机z位置0
            Ftx=Fcx+10;//目标点x位置
            Ftz=Fcz;//目标点z位置
        }
        else if(roadIdArray[personId]==13)
        {
            Fcx=locationDArray[personId][0]/Mapscale-2.5f;//摄像机x位置
            Fcz=locationDArray[personId][2]/Mapscale*0.9f+8.3f;//摄像机z位置0
            Ftx=Fcx;//目标点x位置
            Ftz=Fcz-10;//目标点z位置
        }
        else if(roadIdArray[personId]==14)
        {
            Fcx=locationDArray[personId][0]/Mapscale*0.9f-5f;//摄像机x位置
            Fcz=locationDArray[personId][2]/Mapscale+1.6f;//摄像机z位置0
            Ftx=Fcx+10;//目标点x位置
            Ftz=Fcz;//目标点z位置
        }
    }

}
