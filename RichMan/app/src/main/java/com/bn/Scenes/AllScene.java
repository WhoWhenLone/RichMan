package com.bn.Scenes;

import com.bn.RichMan.MyGLSurFaceView;
import com.bn.Thread.RotateThread;
import com.bn.Util.MatrixState3D;
import static com.bn.Constant.Constant.*;
import static com.bn.Constant.IdDataConstant.*;
import static com.bn.Constant.IdDataConstant.fireId;
import static com.bn.Constant.LovoConstant.*;
import static com.bn.Constant.ParticleScenceData.psdata;
import static com.bn.Scenes.ScenesData.*;


//绘制基础物体
//  固定的  地图  花草 房屋
public class AllScene {

    MyGLSurFaceView mv;
    public static RotateThread rotateThread;

    public static int currCube;
    public AllScene(MyGLSurFaceView mv)
    {
        this.mv=mv;
        rotateThread = new RotateThread();
        rectMap = new RectMap(mv);
        skyBox = new SkyBox(mv);
        P1_shadow = new Shadow(mv);
        P2_shadow = new Shadow(mv);
        P3_shadow = new Shadow(mv);
        P4_shadow = new Shadow(mv);
        shadowArray[0] = P1_shadow;
        shadowArray[1] = P2_shadow;
        shadowArray[2] = P3_shadow;
        shadowArray[3] = P4_shadow;
        rotateThread.start();

    }
    public void drawSelf()
    {
        //绘制基础地图  草坪
        MatrixState3D.pushMatrix();
        rectMap.drawSelf(caopiId);
        MatrixState3D.popMatrix();
        //天空盒
        MatrixState3D.pushMatrix();
        skyBox.drawSelf(skyBoxId);
        MatrixState3D.popMatrix();

        //基本公路
        Draw.drawself(ScenesData.roaddatalen, ScenesData.roaddata,lovoMapCube,roadZId);
        //医院
        Draw.drawself(ScenesData.hospitaldatalen, ScenesData.hospitaldata,lovoHospital,hospitalId);
        //地皮
        Draw.drawself(ScenesData.dipidatalen, ScenesData.dipidata,lovoDiPi,dipiId);
        //基本建筑
        Draw.drawself(ScenesData.building1datalen, ScenesData.building1data,lovoRedHoouse,redhouseId);
        Draw.drawself(ScenesData.building2datalen, ScenesData.building2data,lovoGrayHouse,grayhouseId);
        Draw.drawself(ScenesData.building3datalen, ScenesData.building3data,lovoYellowHouse,yellowhouseId);
        //商店
        Draw.drawself(ScenesData.shopdatalen,ScenesData.shopdata,lovoShop,shopId);
        //加油站
        Draw.drawself(ScenesData.OilStationdatalen,ScenesData.OilStationdata,lovoOilStation, oilStationId);
        //公交站
        Draw.drawself(ScenesData.busStationdatalen, ScenesData.busStationdata,lovoBusStation,busStationId);
        //汽车
        Draw.drawselfSingle(lovoQiche,cheAId,ScenesData.qichedata[0]);
        Draw.drawselfSingle(lovoQiche,cheBId,ScenesData.qichedata[1]);
        Draw.drawselfSingle(lovoQiche,cheCId,ScenesData.qichedata[2]);
        Draw.drawselfSingle(lovoShuiniche,shuinicheId,ScenesData.qichedata[3]);
        Draw.drawselfSingle(lovoQiche,cheAId,ScenesData.qichedata[4]);
        Draw.drawselfSingle(lovoQiche,cheBId,ScenesData.qichedata[5]);
        Draw.drawselfSingle(lovoQiche,cheCId,ScenesData.qichedata[6]);
        Draw.drawselfSingle(lovoShuiniche,shuinicheId,ScenesData.qichedata[7]);
        //Draw.drawselfSingle(lovoQiche,cheAId,ScenesData.qichedata[4]);
        //出租车
        Draw.drawself(ScenesData.taxidatalen,ScenesData.taxidata,lovoTaxi,taxiId);
        //公交车
        Draw.drawself(ScenesData.busdatalen,ScenesData.busdata,lovoBus,busId);
        //维修站
        Draw.drawself(ScenesData.weixiudatalen,ScenesData.weixiudata,lovoWeiXiu,weixiuId);
        //摩天轮
        Draw.drawself(ScenesData.motianlun_dzdatalen,ScenesData.motianlun_dzdata,lovoMTL_DZ,motianlunId);
        Draw.drawself(ScenesData.motianlundatalen,ScenesData.motianlundata,lovoMTL_ZL,motianlunId);
        Draw.drawself(ScenesData.motianlunroom1datalen, motianlunroom1data,lovoMTL_room1,motianlunId);
        Draw.drawself(ScenesData.motianlunroomdatalen, motianlunroom2data,lovoMTL_room2,motianlunId);
        Draw.drawself(ScenesData.motianlunroomdatalen,ScenesData.motianlunroom3data,lovoMTL_room3,motianlunId);
        Draw.drawself(ScenesData.motianlunroomdatalen,ScenesData.motianlunroom4data,lovoMTL_room4,motianlunId);
        Draw.drawself(ScenesData.motianlunroomdatalen,ScenesData.motianlunroom5data,lovoMTL_room5,motianlunId);
        Draw.drawself(ScenesData.motianlunroomdatalen,ScenesData.motianlunroom6data,lovoMTL_room6,motianlunId);
        Draw.drawself(ScenesData.motianlunroomdatalen,ScenesData.motianlunroom7data,lovoMTL_room7,motianlunId);
        Draw.drawself(ScenesData.motianlunroomdatalen,ScenesData.motianlunroom8data,lovoMTL_room8,motianlunId);
        Draw.drawself(ScenesData.motianlunroomdatalen,ScenesData.motianlunroom9data,lovoMTL_room9,motianlunId);
        Draw.drawself(ScenesData.motianlunroomdatalen,ScenesData.motianlunroom10data,lovoMTL_room10,motianlunId);
        Draw.drawself(ScenesData.motianlunroomdatalen,ScenesData.motianlunroom11data,lovoMTL_room11,motianlunId);
        Draw.drawself(ScenesData.motianlunroomdatalen,ScenesData.motianlunroom12data,lovoMTL_room12,motianlunId);
        //大厦
        Draw.drawself(ScenesData.dashadatalen,ScenesData.dashadata,lovoDaSha,dashaId);
        //汽车旅馆
        Draw.drawself(ScenesData.moteldatalen,ScenesData.moteldata,lovoMotel,motelId);
        //火车站
        Draw.drawself(ScenesData.chezhandatalen,ScenesData.chezhandata,lovoCheZhan,chezhanId);
        //铁轨
        Draw.drawself(ScenesData.tieguidatalen,ScenesData.tieguidata,lovoTieGui,tieguiId);
        //飞机模型
        Draw.drawself(ScenesData.planedatalen,ScenesData.planedata,lovoPlane,planeId);
        //火车
        Draw.drawself(ScenesData.traindatalen,ScenesData.traindata,lovoTrain,trainId);
        //草坪
        Draw.drawself(ScenesData.caopingdatalen,ScenesData.caopingdata,lovoCaoPing,caopingId);
        //水果店
        Draw.drawself(ScenesData.fruitshopdatalen,ScenesData.fruitshopdata,lovoFruitShop,fruitshopId);
        //办公室
        Draw.drawself(ScenesData.officedatalen,ScenesData.officedata,lovoOffice,officeId);

        if(godCaiShenState)
        {
            System.out.println("绘制财神附身效果");
            Draw.drawself(ScenesData.godflydatalen,ScenesData.godflydata,lovoGodCaiShen,caishenCubeId);
        }
        if(godShuaiShenState)
        {
            System.out.println("绘制衰神附身效果");
            Draw.drawself(ScenesData.godflydatalen,ScenesData.godflydata,lovoGodShuaiShen,shuaishenCubeId);
        }
        if(godTianShiState)
        {
            System.out.println("绘制天使附身效果");
            Draw.drawself(ScenesData.godflydatalen,ScenesData.godflydata,lovoChiBang,tianshiCubeId);
        }
        if(godEmoState)
        {
            System.out.println("绘制恶魔附身效果");
            Draw.drawself(ScenesData.godflydatalen,ScenesData.godflydata,lovoChiBang,emoCubeId);
        }



        int j=0;
        for (int i=0;i<cubeRoadArray.length;i++)
        {
            if((i>=7&&i<=15)||(i>=19&&i<=25)||(i>=38&&i<=46)||(i>=63&&i<=67)||(i>=69&&i<=84)||(i>=87&&i<=92))
            {
                if(cubeRoadArray[i].getRoadState()==0)
                {
                    if(CameraState==false)
                    {
                        cubeRoadArray[i].dataArray = onsalefirstCdata[j];
                    }
                    else
                    {
                        cubeRoadArray[i].dataArray = onsaledata[j];
                    }

                }
                j++;
            }
        }

        for (int i=0;i<cubeRoadArrayList.size();i++)
        {
            if(cubeRoadArrayList.get(i)!=null)
            {

                cubeRoadArrayList.get(i).drawSelf();
            }
        }


        currCube=currentRoadArray[personId];
        //地皮
        if(psdata[currCube-1][10]==1){
            if ((currCube >= 7 && currCube <= 15) || (currCube >= 19 && currCube <= 25) || (currCube>= 38 && currCube <= 46) || (currCube >= 63 && currCube <= 67) || (currCube >= 69 && currCube <= 84) || (currCube >= 87 && currCube <= 92)) {
                MatrixState3D.pushMatrix();
                MatrixState3D.translate(psdata[currCube-1][0],psdata[currCube-1][1]-3,psdata[currCube-1][2]);
                MatrixState3D.scale(0f,4f,0f);
                fps.calculateBillboardDirection();
                fps.drawSelf(fireId);
                MatrixState3D.popMatrix();
            }
        }

        if(psdata[currCube-1][10]==2){
            if ((currCube >= 7 && currCube <= 15) || (currCube >= 19 && currCube <= 25) || (currCube>= 38 && currCube <= 46) || (currCube >= 63 && currCube <= 67) || (currCube >= 69 && currCube <= 84) || (currCube >= 87 && currCube <= 92)) {
                MatrixState3D.pushMatrix();
                MatrixState3D.translate(psdata[currCube-1][0]+2,psdata[currCube-1][1]+7*2,psdata[currCube-1][2]);
                MatrixState3D.scale(10,10,10);
                fpfs.calculateBillboardDirection();
                fpfs.drawSelf(fireId);
                MatrixState3D.popMatrix();

            }
        }
        //地皮
        Draw.drawself(ScenesData.dipidatalen, ScenesData.dipidata,lovoDiPi,dipiId);

        for(int i=0;i<4;i++)
        {
            if(i!=personId)
            {

                MatrixState3D.pushMatrix();
                shadowArray[i].drawSelf(shadowId,locationJArray[i][0],2.85f*Mapscale,locationJArray[i][2]);
                MatrixState3D.popMatrix();
            }

        }
        //绘制所有人物
        for(int i=0;i<4;i++)
        {
            if(i!=personId)
            {
                personArray[i][1].draw(locationJArray[i][0],locationJArray[i][1],locationJArray[i][2],locationJArray[i][3]);
            }
        }
        //绘制当前行走的人物
        if(MoveStateArray[personId]==false)
        {
            personArray[personId][1].draw(locationJArray[personId][0],locationJArray[personId][1],locationJArray[personId][2], locationJArray[personId][3]);
            personArray[personId][1].setDtFactor(0);
        }
        else if(MoveStateArray[personId]==true)
        {
            personArray[personId][0].draw(locationDArray[personId][0],locationDArray[personId][1],locationDArray[personId][2],locationDArray[personId][3]);
            if(personId==1)
            {
                personArray[personId][0].setDtFactor(0.05f);
            }
            else {
                personArray[personId][0].setDtFactor(0.03f);
            }

        }

        for (int i=0;i<4;i++)
        {
            //当前人物有神仙附体并且不再医院
            if (shenxianArray[i][0]!=0&&hosStateArray[i][0]==0)
            {
                //27   30
                if(shenxianArray[i][0]==25)
                {
                    MatrixState3D.pushMatrix();
                    MatrixState3D.translate(locationDArray[i][0]-0.35f*Mapscale,locationDArray[i][1]*1.15f,locationDArray[i][2]);
                    MatrixState3D.rotate(-90,0,1,0);
                    MatrixState3D.scale(1.2f,1.2f,1.2f);
                    lovoGodCaiShen.drawSelf(picGodArray[shenxianArray[i][0]-25]);
                    MatrixState3D.popMatrix();
                }
                else if(shenxianArray[i][0]==28)
                {
                    MatrixState3D.pushMatrix();
                    MatrixState3D.translate(locationDArray[i][0]-0.35f*Mapscale,locationDArray[i][1]*1.15f,locationDArray[i][2]);
                    MatrixState3D.rotate(-90,0,1,0);
                    MatrixState3D.scale(1.2f,1.2f,1.2f);
                    lovoGodShuaiShen.drawSelf(picGodArray[shenxianArray[i][0]-25]);
                    MatrixState3D.popMatrix();
                }
                else if(shenxianArray[i][0]==27)
                {
                    MatrixState3D.pushMatrix();
                    MatrixState3D.translate(locationDArray[i][0]-0.25f*Mapscale,locationDArray[i][1]*1.15f,locationDArray[i][2]);
                    MatrixState3D.rotate(-90,0,1,0);
                    MatrixState3D.scale(1.2f,1.2f,1.2f);
                    lovoChiBang.drawSelf(picGodArray[shenxianArray[i][0]-25]);
                    MatrixState3D.popMatrix();
                }
                else if(shenxianArray[i][0]==30)
                {
                    MatrixState3D.pushMatrix();
                    MatrixState3D.translate(locationDArray[i][0]-0.25f*Mapscale,locationDArray[i][1]*1.15f,locationDArray[i][2]);
                    MatrixState3D.rotate(-90,0,1,0);
                    MatrixState3D.scale(1.2f,1.2f,1.2f);
                    lovoChiBang.drawSelf(picGodArray[shenxianArray[i][0]-25]);
                    MatrixState3D.popMatrix();
                }
            }
        }
        //绘制当前行走的人物的影子
        if(MoveStateArray[personId]==false)
        {
            MatrixState3D.pushMatrix();
            shadowArray[personId].drawSelf(shadowId,locationJArray[personId][0],2.85f*Mapscale,locationJArray[personId][2]);
            MatrixState3D.popMatrix();
        }
        else if(MoveStateArray[personId]==true)
        {
            MatrixState3D.pushMatrix();
            shadowArray[personId].drawSelf(shadowId,locationDArray[personId][0],2.85f*Mapscale,locationDArray[personId][2]);
            MatrixState3D.popMatrix();
        }
    }
}
