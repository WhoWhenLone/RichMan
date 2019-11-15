package com.bn.Util;

import android.content.Context;
import android.content.SharedPreferences;

import com.bn.Scenes.CubeRoad;

import static com.bn.Constant.Constant.*;
import static com.bn.Constant.IdDataConstant.*;
import static com.bn.Constant.LovoConstant.*;
import static com.bn.Scenes.ScenesData.*;


public class CDPreferences {


    public static SharedPreferences sp = ContextUtil.getInstance().getSharedPreferences("UID",Context.MODE_MULTI_PROCESS |Context.MODE_PRIVATE);
    //存入数据
    static SharedPreferences.Editor editor = sp.edit();


//------------------------------------------------------------------------------------------------//

    //存储当前存档的时间
    public static int GetCDTimeYear2()
    {
        return sp.getInt("cdyear2",0);
    }
    public static void WriteCDTimeYear2(int cdyear)
    {
        editor.putInt("cdyear2", cdyear);
        editor.commit();
    }
    public static int GetCDTimeMonth2()
    {
        return sp.getInt("cdmonth2",0);
    }
    public static void WriteCDTimeMonth2(int cdmonth1)
    {
        editor.putInt("cdmonth2", cdmonth1);
        editor.commit();
    }
    public static int GetCDTimeDay2()
    {
        return sp.getInt("cdday2",0);
    }
    public static void WriteCDTimecdDay2(int cdday1)
    {
        editor.putInt("cdday2", cdday1);
        editor.commit();
    }
    public static int GetCDTimeHour2()
    {
        return sp.getInt("cdhour2",0);
    }
    public static void WriteCDTimeHour2(int cdhour1)
    {
        editor.putInt("cdhour2", cdhour1);
        editor.commit();
    }
    public static int GetCDTimeMin2()
    {
        return sp.getInt("cdmin2",0);
    }
    public static void WriteCDTimeMin2(int cdmin1)
    {
        editor.putInt("cdmin2", cdmin1);
        editor.commit();
    }
    public static int GetCDTimeSec2()
    {
        return sp.getInt("cdsec2",0);
    }
    public static void WriteCDTimeSec2(int cdsec2)
    {
        editor.putInt("cdsec2", cdsec2);
        editor.commit();
    }
    //存储当前存档的时间
    public static int GetCDTimeYear1()
    {
        return sp.getInt("cdyear1",0);
    }
    public static void WriteCDTimeYear1(int cdyear)
    {
        editor.putInt("cdyear1", cdyear);
        editor.commit();
    }
    public static int GetCDTimeMonth1()
    {
        return sp.getInt("cdmonth1",0);
    }
    public static void WriteCDTimeMonth1(int cdmonth1)
    {
        editor.putInt("cdmonth1", cdmonth1);
        editor.commit();
    }
    public static int GetCDTimeDay1()
    {
        return sp.getInt("cdday1",0);
    }
    public static void WriteCDTimecdDay1(int cdday1)
    {
        editor.putInt("cdday1", cdday1);
        editor.commit();
    }
    public static int GetCDTimeHour1()
    {
        return sp.getInt("cdhour1",0);
    }
    public static void WriteCDTimeHour1(int cdhour1)
    {
        editor.putInt("cdhour1", cdhour1);
        editor.commit();
    }

    public static int GetCDTimeMin1()
    {
        return sp.getInt("cdmin1",0);
    }
    public static void WriteCDTimeMin1(int cdmin1)
    {
        editor.putInt("cdmin1", cdmin1);
        editor.commit();
    }
    public static int GetCDTimeSec1()
    {
        return sp.getInt("cdsec1",0);
    }
    public static void WriteCDTimeSec1(int cdsec1)
    {
        editor.putInt("cdsec1", cdsec1);
        editor.commit();
    }
    //存储当前存档的时间
    public static int GetCDTimeYear3()
    {
        return sp.getInt("cdyear3",0);
    }
    public static void WriteCDTimeYear3(int cdyear)
    {
        editor.putInt("cdyear3", cdyear);
        editor.commit();
    }
    public static int GetCDTimeMonth3()
    {
        return sp.getInt("cdmonth3",0);
    }
    public static void WriteCDTimeMonth3(int cdmonth1)
    {
        editor.putInt("cdmonth3", cdmonth1);
        editor.commit();
    }
    public static int GetCDTimeDay3()
    {
        return sp.getInt("cdday3",0);
    }
    public static void WriteCDTimecdDay3(int cdday1)
    {
        editor.putInt("cdday3", cdday1);
        editor.commit();
    }
    public static int GetCDTimeHour3()
    {
        return sp.getInt("cdhour3",0);
    }
    public static void WriteCDTimeHour3(int cdhour1)
    {
        editor.putInt("cdhour3", cdhour1);
        editor.commit();
    }
    public static int GetCDTimeMin3()
    {
        return sp.getInt("cdmin3",0);
    }
    public static void WriteCDTimeMin3(int cdmin1)
    {
        editor.putInt("cdmin3", cdmin1);
        editor.commit();
    }
    public static int GetCDTimeSec3()
    {
        return sp.getInt("cdsec3",0);
    }
    public static void WriteCDTimeSec3(int cdsec3)
    {
        editor.putInt("cdsec3", cdsec3);
        editor.commit();
    }
    //存储当前存档的时间
    public static int GetCDTimeYear4()
    {
        return sp.getInt("cdyear4",0);
    }
    public static void WriteCDTimeYear4(int cdyear)
    {
        editor.putInt("cdyear4", cdyear);
        editor.commit();
    }
    public static int GetCDTimeMonth4()
    {
        return sp.getInt("cdmonth4",0);
    }
    public static void WriteCDTimeMonth4(int cdmonth1)
    {
        editor.putInt("cdmonth4", cdmonth1);
        editor.commit();
    }
    public static int GetCDTimecdDay4()
    {
        return sp.getInt("cdday4",0);
    }
    public static void WriteCDTimecdDay4(int cdday1)
    {
        editor.putInt("cdday4", cdday1);
        editor.commit();
    }
    public static int GetCDTimeHour4()
    {
        return sp.getInt("cdhour4",0);
    }
    public static void WriteCDTimeHour4(int cdhour1)
    {
        editor.putInt("cdhour4", cdhour1);
        editor.commit();
    }
    public static int GetCDTimeMin4()
    {
        return sp.getInt("cdmin4",0);
    }
    public static void WriteCDTimeMin4(int cdmin1)
    {
        editor.putInt("cdmin4", cdmin1);
        editor.commit();
    }
    public static int GetCDTimeSec4()
    {
        return sp.getInt("cdsec4",0);
    }
    public static void WriteCDTimeSec4(int cdsec4)
    {
        editor.putInt("cdsec4", cdsec4);
        editor.commit();
    }
    //当前是否含有存档的标志位
    public static int GetCDState()
    {
        return sp.getInt("cdState",0);
    }
    public static void WriteCDState(int cdState)
    {
        editor.putInt("cdState", cdState);
        editor.commit();
    }
    //日期
    public static int GetYear()
    {
        return sp.getInt("year",year);
    }
    public static void WriteYear(int year)
    {
        editor.putInt("year",year);
        editor.commit();
    }

    public static int GetMonth()
    {
        return sp.getInt("month",month);
    }
    public static void WriteMonth(int month)
    {
        editor.putInt("month",month);
        editor.commit();
    }

    public static int GetDay()
    {
        return sp.getInt("day",day);
    }
    public static void WriteDay(int day)
    {
        editor.putInt("day",day);
        editor.commit();
    }
    public static int GetHuihe()//回合数
    {
        return sp.getInt("huiheId",huiheId);
    }
    public static void WriteHuihe(int huiheId)
    {
        editor.putInt("huiheId",huiheId);
        editor.commit();
    }
    public static int GetPersonId()
    {
        return sp.getInt("personId",personId);
    }

    //第一个人物坐标 x
    public static float GetLocationP1_x()
    {
        System.out.println("p1_x获取"+sp.getFloat("p1_x",0));
        return sp.getFloat("p1_x",0);
    }
    public static void WriteLocationP1_x(float p1_x)
    {
        System.out.println("p1_x存储"+p1_x);
        editor.putFloat("p1_x", p1_x);
        editor.commit();
    }

    //第一个人物坐标 z
    public static float GetLocationP1_z()
    {
        return sp.getFloat("p1_z",0);
    }
    public static void WriteLocationP1_z(float p1_z)
    {
        editor.putFloat("p1_z", p1_z);
        editor.commit();
    }

    //第一个人物的角度
    public static float GetLocationP1_angle()
    {
        return sp.getFloat("p1_angle",0);
    }
    public static void WriteLocationP1_angle(float p1_angle)
    {
        editor.putFloat("p1_angle", p1_angle);
        editor.commit();
    }
    public static int GetP1_roadId()
    {
        return sp.getInt("p1_roadId",0);
    }
    public static void WriteP1_roadId(int p1_roadId)
    {
        editor.putInt("p1_roadId", p1_roadId);
        editor.commit();
    }
    public static int GetP1_CuberoadId()
    {
        return sp.getInt("p1_cuberoadId",0);
    }
    public static void WriteP1_CuberoadId(int p1_cuberoadId)
    {
        editor.putInt("p1_cuberoadId", p1_cuberoadId);
        editor.commit();
    }
    public static float GetP1_Money()
    {
        return sp.getFloat("p1_money",0);
    }
    public static void WriteP1_Money(float p1_money)
    {
        editor.putFloat("p1_money", p1_money);
        editor.commit();
    }
    public static float GetP1_Moneybank()
    {
        return sp.getFloat("p1_moneybank",0);
    }
    public static void WriteP1_Moneybank(float p1_moneybank)
    {
        editor.putFloat("p1_moneybank", p1_moneybank);
        editor.commit();
    }
    public static int GetP1_DQ()
    {
        return sp.getInt("p1_dq",0);
    }
    public static void WriteP1_DQ(int p1_dq)
    {
        editor.putInt("p1_dq", p1_dq);
        editor.commit();
    }
    public static int GetP1_DPCount()
    {
        return sp.getInt("p1_dpcount",0);
    }
    public static void WriteP1_DPCount(int p1_dpcount)
    {
        editor.putInt("p1_dpcount", p1_dpcount);
        editor.commit();
    }
    public static int GetP1_GPCount()
    {
        return sp.getInt("p1_gpcount",0);
    }
    public static void WriteP1_GPCount(int p1_gpcount)
    {
        editor.putInt("p1_gpcount", p1_gpcount);
        editor.commit();
    }
    //--------------------------------------------------------------------------------------------//
    //第2个人物坐标 x
    public static float GetLocationP2_x()
    {
        return sp.getFloat("p2_x",0);
    }
    public static void WriteLocationP2_x(float p2_x)
    {
        editor.putFloat("p2_x", p2_x);
        editor.commit();
    }

    //第2个人物坐标 z
    public static float GetLocationP2_z()
    {
        return sp.getFloat("p2_z",0);
    }
    public static void WriteLocationP2_z(float p2_z)
    {
        editor.putFloat("p2_z", p2_z);
        editor.commit();
    }

    //第2个人物的角度
    public static float GetLocationP2_angle()
    {
        return sp.getFloat("p2_angle",0);
    }
    public static void WriteLocationP2_angle(float p2_angle)
    {
        editor.putFloat("p2_angle", p2_angle);
        editor.commit();
    }
    public static int GetP2_roadId()
    {
        return sp.getInt("p2_roadId",0);
    }
    public static void WriteP2_roadId(int p2_roadId)
    {
        editor.putInt("p2_roadId", p2_roadId);
        editor.commit();
    }

    public static int GetP2_CuberoadId()
    {
        return sp.getInt("p2_cuberoadId",0);
    }
    public static void WriteP2_CuberoadId(int p2_cuberoadId)
    {
        editor.putInt("p2_cuberoadId", p2_cuberoadId);
        editor.commit();
    }

    public static float GetP2_Money()
    {
        return sp.getFloat("p2_money",0);
    }
    public static void WriteP2_Money(float p2_money)
    {
        editor.putFloat("p2_money", p2_money);
        editor.commit();
    }
    public static float GetP2_Moneybank()
    {
        return sp.getFloat("p2_moneybank",0);
    }
    public static void WriteP2_Moneybank(float p2_moneybank)
    {
        editor.putFloat("p2_moneybank", p2_moneybank);
        editor.commit();
    }
    public static int GetP2_DQ()
    {
        return sp.getInt("p2_dq",0);
    }
    public static void WriteP2_DQ(int p2_dq)
    {
        editor.putInt("p2_dq", p2_dq);
        editor.commit();
    }
    public static int GetP2_DPCount()
    {
        return sp.getInt("p2_dpcount",0);
    }
    public static void WriteP2_DPCount(int p2_dpcount)
    {
        editor.putInt("p2_dpcount", p2_dpcount);
        editor.commit();
    }
    public static int GetP2_GPCount()
    {
        return sp.getInt("p2_gpcount",0);
    }
    public static void WriteP2_GPCount(int p2_gpcount)
    {
        editor.putInt("p2_gpcount", p2_gpcount);
        editor.commit();
    }
    //--------------------------------------------------------------------------------------------//
    //第3个人物坐标 x
    public static float GetLocationP3_x()
    {
        return sp.getFloat("p3_x",0);
    }
    public static void WriteLocationP3_x(float p3_x)
    {
        editor.putFloat("p3_x", p3_x);
        editor.commit();
    }

    //第3个人物坐标 z
    public static float GetLocationP3_z()
    {
        return sp.getFloat("p3_z",0);
    }
    public static void WriteLocationP3_z(float p3_z)
    {
        editor.putFloat("p3_z", p3_z);
        editor.commit();
    }

    //第3个人物的角度
    public static float GetLocationP3_angle()
    {
        return sp.getFloat("p3_angle",0);
    }
    public static void WriteLocationP3_angle(float p3_angle)
    {
        editor.putFloat("p3_angle", p3_angle);
        editor.commit();
    }
    public static int GetP3_roadId()
    {
        return sp.getInt("p3_roadId",0);
    }
    public static void WriteP3_roadId(int p3_roadId)
    {
        editor.putInt("p3_roadId", p3_roadId);
        editor.commit();
    }
    public static int GetP3_CuberoadId()
    {
        return sp.getInt("p3_cuberoadId",0);
    }
    public static void WriteP3_CuberoadId(int p3_cuberoadId)
    {
        editor.putInt("p3_cuberoadId", p3_cuberoadId);
        editor.commit();
    }
    public static float GetP3_Money()
    {
        return sp.getFloat("p3_money",0);
    }
    public static void WriteP3_Money(float p3_money)
    {
        editor.putFloat("p3_money", p3_money);
        editor.commit();
    }
    public static float GetP3_Moneybank()
    {
        return sp.getFloat("p3_moneybank",0);
    }
    public static void WriteP3_Moneybank(float p3_moneybank)
    {
        editor.putFloat("p3_moneybank", p3_moneybank);
        editor.commit();
    }
    public static int GetP3_DQ()
    {
        return sp.getInt("p3_dq",0);
    }
    public static void WriteP3_DQ(int p3_dq)
    {
        editor.putInt("p3_dq", p3_dq);
        editor.commit();
    }
    public static int GetP3_DPCount()
    {
        return sp.getInt("p3_dpcount",0);
    }
    public static void WriteP3_DPCount(int p3_dpcount)
    {
        editor.putInt("p3_dpcount", p3_dpcount);
        editor.commit();
    }
    public static int GetP3_GPCount()
    {
        return sp.getInt("p3_gpcount",0);
    }
    public static void WriteP3_GPCount(int p3_gpcount)
    {
        editor.putInt("p3_gpcount", p3_gpcount);
        editor.commit();
    }
    //------------------------------------------------------------------------------------------------//
//第4个人物坐标 x
    public static float GetLocationP4_x()
    {
        return sp.getFloat("p4_x",0);
    }
    public static void WriteLocationP4_x(float p4_x)
    {
        editor.putFloat("p4_x", p4_x);
        editor.commit();
    }

    //第4个人物坐标 z
    public static float GetLocationP4_z()
    {
        return sp.getFloat("p4_z",0);
    }
    public static void WriteLocationP4_z(float p4_z)
    {
        editor.putFloat("p4_z", p4_z);
        editor.commit();
    }

    //第4个人物的角度
    public static float GetLocationP4_angle()
    {
        return sp.getFloat("p4_angle",0);
    }
    public static void WriteLocationP4_angle(float p4_angle)
    {
        editor.putFloat("p4_angle", p4_angle);
        editor.commit();
    }
    public static int GetP4_roadId()
    {
        return sp.getInt("p4_roadId",0);
    }
    public static void WriteP4_roadId(int p4_roadId)
    {
        editor.putInt("p4_roadId", p4_roadId);
        editor.commit();
    }
    public static int GetP4_CuberoadId()
    {
        return sp.getInt("p4_cuberoadId",0);
    }
    public static void WriteP4_CuberoadId(int p4_cuberoadId)
    {
        editor.putInt("p4_cuberoadId", p4_cuberoadId);
        editor.commit();
    }
    public static float GetP4_Money()
    {
        return sp.getFloat("p4_money",0);
    }
    public static void WriteP4_Money(float p4_money)
    {
        editor.putFloat("p4_money", p4_money);
        editor.commit();
    }
    public static float GetP4_Moneybank()
    {
        return sp.getFloat("p4_moneybank",0);
    }
    public static void WriteP4_Moneybank(float p4_moneybank)
    {
        editor.putFloat("p4_moneybank", p4_moneybank);
        editor.commit();
    }
    public static int GetP4_DQ()
    {
        return sp.getInt("p4_dq",0);
    }
    public static void WriteP4_DQ(int p4_dq)
    {
        editor.putInt("p4_dq", p4_dq);
        editor.commit();
    }
    public static int GetP4_DPCount()
    {
        return sp.getInt("p4_dpcount",0);
    }
    public static void WriteP4_DPCount(int p4_dpcount)
    {
        editor.putInt("p4_dpcount", p4_dpcount);
        editor.commit();
    }
    public static int GetP4_GPCount()
    {
        return sp.getInt("p4_gpcount",0);
    }
    public static void WriteP4_GPCount(int p4_gpcount)
    {
        editor.putInt("p4_gpcount", p4_gpcount);
        editor.commit();
    }
//------------------------------------------------------------------------------------------------//

    public static void  WriteRoadState()
    {
        for (int i=0;i<cubeRoadArray.length;i++)
        {
            if((i>=7&&i<=15)||(i>=19&&i<=25)||(i>=38&&i<=46)||(i>=63&&i<=67)||(i>=69&&i<=84)||(i>=87&&i<=92))
            {
                //已经购买土地
                editor.putInt("cubeRoadArray"+i,cubeRoadArray[i].getRoadState());
                editor.commit();
            }
        }
    }

    public static void  GetRoadState()
    {
        for (int i=0;i<cubeRoadArray.length;i++)
        {
            //地皮
            if((i>=7&&i<=15)||(i>=19&&i<=25)||(i>=38&&i<=46)||(i>=63&&i<=67)||(i>=69&&i<=84)||(i>=87&&i<=92))
            {
                cubeRoadArray[i].RoadState = sp.getInt("cubeRoadArray"+i,0);
                //正在出售
                if(cubeRoadArray[i].RoadState==0)
                {
                    cubeRoadArray[i] = new CubeRoad(i,0,lovoOnSale,onsaleId,dipiarray[i]);
                }
                //P1
                else if(cubeRoadArray[i].RoadState==1)
                {
                    cubeRoadArray[i] = new CubeRoad(i,1,lovoBZMing,BZ_hongId,BZdata_P1[i]);
                }
                else if(cubeRoadArray[i].RoadState==2)
                {
                    cubeRoadArray[i] = new CubeRoad(i,2,lovoHouse1,houseId,houselevel1[i]);
                }
                else if(cubeRoadArray[i].RoadState==3)
                {
                    cubeRoadArray[i] = new CubeRoad(i,3,lovoHouse2, houseId, houselevel2[i]);
                }
                else if(cubeRoadArray[i].RoadState==4)
                {
                    cubeRoadArray[i] = new CubeRoad(i,4,lovoHouse3, houseId, houselevel3[i]);
                }
                //P2
                else if(cubeRoadArray[i].RoadState==5)
                {
                    cubeRoadArray[i] = new CubeRoad(i,5,lovoBZMing,BZ_lanId,BZdata_P2[i]);
                }
                else if(cubeRoadArray[i].RoadState==6)
                {
                    cubeRoadArray[i] = new CubeRoad(i,6,lovoHouse1,houseId,houselevel1[i]);
                }
                else if(cubeRoadArray[i].RoadState==7)
                {
                    cubeRoadArray[i] = new CubeRoad(i,7,lovoHouse2, houseId, houselevel2[i]);
                }
                else if(cubeRoadArray[i].RoadState==8)
                {
                    cubeRoadArray[i] = new CubeRoad(i,8,lovoHouse3, houseId, houselevel3[i]);
                }
                //P3
                else if(cubeRoadArray[i].RoadState==9)
                {
                    cubeRoadArray[i] = new CubeRoad(i,6,lovoBZMing,BZ_zongId,BZdata_P3[i]);
                }
                else if(cubeRoadArray[i].RoadState==10)
                {
                    cubeRoadArray[i] = new CubeRoad(i,10,lovoHouse2, houseId, houselevel2[i]);
                }
                else if(cubeRoadArray[i].RoadState==11)
                {
                    cubeRoadArray[i] = new CubeRoad(i,11,lovoBZMing,BZ_lanId,BZdata_P2[i]);
                }
                else if(cubeRoadArray[i].RoadState==12)
                {
                    cubeRoadArray[i] = new CubeRoad(i,12,lovoHouse3, houseId, houselevel3[i]);
                }
                //P4
                else if(cubeRoadArray[i].RoadState==13)
                {
                    cubeRoadArray[i] = new CubeRoad(i,13,lovoBZMing,BZ_heId,BZdata_P4[i]);
                }
                else if(cubeRoadArray[i].RoadState==14)
                {
                    cubeRoadArray[i] = new CubeRoad(i,14,lovoHouse1,houseId,houselevel1[i]);
                }
                else if(cubeRoadArray[i].RoadState==15)
                {
                    cubeRoadArray[i] = new CubeRoad(i,15,lovoHouse2, houseId, houselevel2[i]);
                }
                else if(cubeRoadArray[i].RoadState==16)
                {
                    cubeRoadArray[i] = new CubeRoad(i,16,lovoHouse3, houseId, houselevel3[i]);
                }
            }
            else
            {
                cubeRoadArray[i] = null;
            }
        }
        cubeRoadArray[2] = new CubeRoad(2,22,lovoMapCube,road20Id,road20data[0]);
        cubeRoadArray[4] = new CubeRoad(4,22,lovoMapCube,road20Id,road20data[1]);
        cubeRoadArray[32] = new CubeRoad(32,22,lovoMapCube,road20Id,road20data[2]);
        cubeRoadArray[34] = new CubeRoad(34,22,lovoMapCube,road20Id,road20data[3]);
        cubeRoadArray[36] = new CubeRoad(36,22,lovoMapCube,road20Id,road20data[4]);
        cubeRoadArray[48] = new CubeRoad(48,22,lovoMapCube,road20Id,road20data[5]);
        cubeRoadArray[50] = new CubeRoad(50,22,lovoMapCube,road20Id,road20data[6]);
        cubeRoadArray[58] = new CubeRoad(58,22,lovoMapCube,road20Id,road20data[7]);
        cubeRoadArray[60] = new CubeRoad(60,22,lovoMapCube,road20Id,road20data[8]);
        cubeRoadArray[95] = new CubeRoad(95,22,lovoMapCube,road20Id,road20data[9]);
        cubeRoadArray[97] = new CubeRoad(97,22,lovoMapCube,road20Id,road20data[10]);
        cubeRoadArray[99] = new CubeRoad(99,22,lovoMapCube,road20Id,road20data[11]);
        cubeRoadArray[47] = new CubeRoad(47,23,lovoMapCube,road20Id,road50data[2]);
        //点券 50  1   5  47 52 57 62 94 100
        cubeRoadArray[1] = new CubeRoad(1,23,lovoMapCube,road50Id,road50data[0]);
        cubeRoadArray[5] = new CubeRoad(5,23,lovoMapCube,road50Id,road50data[1]);
        cubeRoadArray[52] = new CubeRoad(52,23,lovoMapCube,road50Id,road50data[3]);
        cubeRoadArray[57] = new CubeRoad(57,23,lovoMapCube,road50Id,road50data[4]);
        cubeRoadArray[62] = new CubeRoad(62,23,lovoMapCube,road50Id,road50data[5]);
        cubeRoadArray[94] = new CubeRoad(94,23,lovoMapCube,road50Id,road50data[6]);
        //彩票站
        cubeRoadArray[100] = new CubeRoad(100,32,lovoMapCube,cpstationId,road50data[7]);
        // bank  hospital shop bank shop
        cubeRoadArray[16] = new CubeRoad(16,17,lovoMapCube,bankCubeId,bsydata[1]);
        cubeRoadArray[18] = new CubeRoad(18,24,lovoMapCube,hospitalCubeId,bsydata[0]);
        cubeRoadArray[30] = new CubeRoad(30,18,lovoMapCube,shopCubeId,bsydata[2]);
        cubeRoadArray[56] = new CubeRoad(56,17,lovoMapCube,bankCubeId,bsydata[3]);
        cubeRoadArray[101] = new CubeRoad(101,18,lovoMapCube,shopCubeId,bsydata[4]);
        //神仙的方块
        //  6  17 26 31  37  53  68 85 93
        cubeRoadArray[6] = new CubeRoad(6,25,lovoMapCube,caishenId,shenxiandata[0]);    //财神
        cubeRoadArray[17] = new CubeRoad(17,26,lovoMapCube,fushenId,shenxiandata[1]);   //福神
        cubeRoadArray[26] = new CubeRoad(26,27,lovoMapCube,tianshiId,shenxiandata[2]);  //天使
        cubeRoadArray[31] = new CubeRoad(31,28,lovoMapCube,shuaishenId,shenxiandata[3]);//衰神
        cubeRoadArray[37] = new CubeRoad(37,29,lovoMapCube,caishenId,shenxiandata[4]);//财神
        cubeRoadArray[53] = new CubeRoad(53,25,lovoMapCube,caishenId,shenxiandata[5]);     //财神
        cubeRoadArray[68] = new CubeRoad(68,27,lovoMapCube,tianshiId,shenxiandata[6]);     //天使
        cubeRoadArray[85] = new CubeRoad(85,30,lovoMapCube,emoId,shenxiandata[7]);      //恶魔
        cubeRoadArray[93] = new CubeRoad(93,28,lovoMapCube,shuaishenId,shenxiandata[8]);  //衰神
        //28  29  加油站
        cubeRoadArray[28] = new CubeRoad(28,20,lovoMapCube,jiantouZId,jiantoudata[0]);
        cubeRoadArray[29] = new CubeRoad(29,20,lovoJianTouW,jiantouWId,jiantoudata[1]);
        //54  55 商店
        cubeRoadArray[54] = new CubeRoad(54,19,lovoMapCube,jiantouZId,jiantoudata[2]);
        cubeRoadArray[55] = new CubeRoad(55,19,lovoJianTouW,jiantouWId,jiantoudata[3]);
        ///motel 102 103
        cubeRoadArray[102] = new CubeRoad(102,21,lovoMapCube,jiantouZId,jiantoudata[4]);
        cubeRoadArray[103] = new CubeRoad(103,21,lovoJianTouW,jiantouWId,jiantoudata[5]);
        cubeRoadArrayList.clear();
        //初始化所有公路块数据
        for (int i=0;i<cubeRoadArray.length;i++)
        {
            cubeRoadArrayList.add(cubeRoadArray[i]);
        }
    }
    //读取存档
    public static void readData()
    {
        locationDArray[0][0] = GetLocationP1_x();
        locationDArray[0][2] = GetLocationP1_z();
        locationDArray[0][3] = GetLocationP1_angle();

        locationDArray[1][0] = GetLocationP2_x();
        locationDArray[1][2] = GetLocationP2_z();
        locationDArray[1][3] = GetLocationP2_angle();

        locationDArray[2][0] = GetLocationP3_x();
        locationDArray[2][2] = GetLocationP3_z();
        locationDArray[2][3] = GetLocationP3_angle();

        locationDArray[3][0] = GetLocationP4_x();
        locationDArray[3][2] = GetLocationP4_z();
        locationDArray[3][3] = GetLocationP4_angle();

        locationJArray[0][0] = locationDArray[0][0];
        locationJArray[0][2] = locationDArray[0][2];
        locationJArray[0][3] = locationDArray[0][3];
        locationJArray[1][0] = locationDArray[1][0];
        locationJArray[1][2] = locationDArray[1][2];
        locationJArray[1][3] = locationDArray[1][3];
        locationJArray[2][0] = locationDArray[2][0];
        locationJArray[2][2] = locationDArray[2][2];
        locationJArray[2][3] = locationDArray[2][3];
        locationJArray[3][0] = locationDArray[3][0];
        locationJArray[3][2] = locationDArray[3][2];
        locationJArray[3][3] = locationDArray[3][3];

        roadIdArray[0] = GetP1_roadId();
        roadIdArray[1] = GetP2_roadId();
        roadIdArray[2] = GetP3_roadId();
        roadIdArray[3] = GetP4_roadId();

        currentRoadArray[0]  =GetP1_CuberoadId();
        currentRoadArray[1]  =GetP2_CuberoadId();
        currentRoadArray[2]  =GetP3_CuberoadId();
        currentRoadArray[3]  =GetP4_CuberoadId();

        moneyArray[0][0] =GetP1_Money();
        moneyArray[1][0] =GetP2_Money();
        moneyArray[2][0] =GetP3_Money();
        moneyArray[3][0] =GetP4_Money();

        moneyArray[0][1] =GetP1_Moneybank();
        moneyArray[1][1] =GetP2_Moneybank();
        moneyArray[2][1] =GetP3_Moneybank();
        moneyArray[3][1] =GetP4_Moneybank();

        moneyArray[0][2] = moneyArray[0][0]+moneyArray[0][1];
        moneyArray[1][2] = moneyArray[1][0]+moneyArray[1][1];
        moneyArray[2][2] = moneyArray[2][0]+moneyArray[2][1];
        moneyArray[3][2] = moneyArray[3][0]+moneyArray[3][1];

        cardmoneyArray[0] = GetP1_DQ();
        cardmoneyArray[1] = GetP2_DQ();
        cardmoneyArray[2] = GetP3_DQ();
        cardmoneyArray[3] = GetP4_DQ();

        dipicount[0] = GetP1_DPCount();
        dipicount[1] = GetP2_DPCount();
        dipicount[2] = GetP3_DPCount();
        dipicount[3] = GetP4_DPCount();

        chiyoushu[0] =GetP1_GPCount();
        chiyoushu[1] =GetP2_GPCount();
        chiyoushu[2] =GetP3_GPCount();
        chiyoushu[3] =GetP4_GPCount();

        jiaoyiliang[0] = 2000-chiyoushu[0];
        jiaoyiliang[1] = 2000-chiyoushu[1];
        jiaoyiliang[2] = 2000-chiyoushu[2];
        jiaoyiliang[3] = 2000-chiyoushu[3];

        GetRoadState();
        year = GetYear();
        month = GetMonth();
        day = GetDay();
        huiheId = GetHuihe();
        personId = huiheId%4;
        throwUtil = null;
        throwUtil = new ThrowUtil();
    }
    //存储存档
    public static void saveData()
    {
        WriteLocationP1_x(locationDArray[0][0]);
        WriteLocationP1_z(locationDArray[0][2]);
        WriteLocationP1_angle(locationDArray[0][3]);

        WriteLocationP2_x(locationDArray[1][0]);
        WriteLocationP2_z(locationDArray[1][2]);
        WriteLocationP2_angle(locationDArray[1][3]);

        WriteLocationP3_x(locationDArray[2][0]);
        WriteLocationP3_z(locationDArray[2][2]);
        WriteLocationP3_angle(locationDArray[2][3]);

        WriteLocationP4_x(locationDArray[3][0]);
        WriteLocationP4_z(locationDArray[3][2]);
        WriteLocationP4_angle(locationDArray[3][3]);

        WriteP1_roadId(roadIdArray[0]);
        WriteP2_roadId(roadIdArray[1]);
        WriteP3_roadId(roadIdArray[2]);
        WriteP4_roadId(roadIdArray[3]);

        WriteP1_CuberoadId(currentRoadArray[0]);
        WriteP2_CuberoadId(currentRoadArray[1]);
        WriteP3_CuberoadId(currentRoadArray[2]);
        WriteP4_CuberoadId(currentRoadArray[3]);

        WriteP1_Money(moneyArray[0][0]);
        WriteP2_Money(moneyArray[1][0]);
        WriteP3_Money(moneyArray[2][0]);
        WriteP4_Money(moneyArray[3][0]);

        WriteP1_Moneybank(moneyArray[0][1]);
        WriteP2_Moneybank(moneyArray[1][1]);
        WriteP3_Moneybank(moneyArray[2][1]);
        WriteP4_Moneybank(moneyArray[3][1]);

        WriteP1_DQ(cardmoneyArray[0]);
        WriteP2_DQ(cardmoneyArray[1]);
        WriteP3_DQ(cardmoneyArray[2]);
        WriteP4_DQ(cardmoneyArray[3]);

        WriteP1_DPCount(dipicount[0]);
        WriteP2_DPCount(dipicount[1]);
        WriteP3_DPCount(dipicount[2]);
        WriteP4_DPCount(dipicount[3]);

        WriteP1_GPCount(chiyoushu[0]);
        WriteP2_GPCount(chiyoushu[1]);
        WriteP3_GPCount(chiyoushu[2]);
        WriteP4_GPCount(chiyoushu[3]);
        WriteRoadState();
        WriteYear(year);
        WriteMonth(month);
        WriteDay(day);
        WriteHuihe(huiheId);

        WriteCDTimeYear1(year1);
        WriteCDTimeMonth1(month1);
        WriteCDTimecdDay1(day1);
        WriteCDTimeHour1(hour1);
        WriteCDTimeMin1(min1);
    }

    //第二条存档**************************--//
    //------------------------------------------------------------------------------------------------//
    //当前是否含有存档的标志位
    public static int GetCDState2()
    {
        System.out.println("cdState2获取"+sp.getInt("cdState2",0));
        return sp.getInt("cdState2",0);
    }
    public static void WriteCDState2(int cdState2)
    {
        System.out.println("cdState2"+cdState2);
        editor.putInt("cdState2", cdState2);
        editor.commit();
    }
    //日期
    public static int GetYear2()
    {
        return sp.getInt("year2",year2);
    }
    public static void WriteYear2(int year2)
    {
        editor.putInt("year2",year2);
        editor.commit();
    }

    public static int GetMonth2()
    {
        return sp.getInt("month2",month2);
    }
    public static void WriteMonth2(int month2)
    {
        editor.putInt("month2",month2);
        editor.commit();
    }

    public static int GetDay2()
    {
        return sp.getInt("day2",day2);
    }
    public static void WriteDay2(int day2)
    {
        editor.putInt("day2",day2);
        editor.commit();
    }
    //第一个人物坐标 x
    public static float GetLocationP1_x2()
    {

        return sp.getFloat("p1_x2",0);
    }
    public static void WriteLocationP1_x2(float p1_x2)
    {
        editor.putFloat("p1_x2", p1_x2);
        editor.commit();
    }

    //第一个人物坐标 z
    public static float GetLocationP1_z2()
    {
        return sp.getFloat("p1_z2",0);
    }
    public static void WriteLocationP1_z2(float p1_z2)
    {
        editor.putFloat("p1_z2", p1_z2);
        editor.commit();
    }

    //第一个人物的角度
    public static float GetLocationP1_angle2()
    {
        return sp.getFloat("p1_angle2",0);
    }
    public static void WriteLocationP1_angle2(float p1_angle2)
    {
        editor.putFloat("p1_angle2", p1_angle2);
        editor.commit();
    }
    public static int GetP1_roadId2()
    {
        return sp.getInt("p1_roadId2",0);
    }
    public static void WriteP1_roadId2(int p1_roadId2)
    {
        editor.putInt("p1_roadId2", p1_roadId2);
        editor.commit();
    }
    public static int GetP1_CuberoadId2()
    {
        return sp.getInt("p1_cuberoadId2",0);
    }
    public static void WriteP1_CuberoadId2(int p1_cuberoadId2)
    {
        editor.putInt("p1_cuberoadId2", p1_cuberoadId2);
        editor.commit();
    }
    public static float GetP1_Money2()
    {
        return sp.getFloat("p1_money2",0);
    }
    public static void WriteP1_Money2(float p1_money2)
    {
        editor.putFloat("p1_money2", p1_money2);
        editor.commit();
    }
    public static float GetP1_Moneybank2()
    {
        return sp.getFloat("p1_moneybank2",0);
    }
    public static void WriteP1_Moneybank2(float p1_moneybank2)
    {
        editor.putFloat("p1_moneybank2", p1_moneybank2);
        editor.commit();
    }
    public static int GetP1_DQ2()
    {
        return sp.getInt("p1_dq2",0);
    }
    public static void WriteP1_DQ2(int p1_dq2)
    {
        editor.putInt("p1_dq2", p1_dq2);
        editor.commit();
    }
    public static int GetP1_DPCount2()
    {
        return sp.getInt("p1_dpcount2",0);
    }
    public static void WriteP1_DPCount2(int p1_dpcount2)
    {
        editor.putInt("p1_dpcount2", p1_dpcount2);
        editor.commit();
    }
    public static int GetP1_GPCount2()
    {
        return sp.getInt("p1_gpcount2",0);
    }
    public static void WriteP1_GPCount2(int p1_gpcount2)
    {
        editor.putInt("p1_gpcount2", p1_gpcount2);
        editor.commit();
    }
    //--------------------------------------------------------------------------------------------//
    //第2个人物坐标 x
    public static float GetLocationP2_x2()
    {
        return sp.getFloat("p2_x2",0);
    }
    public static void WriteLocationP2_x2(float p2_x2)
    {
        editor.putFloat("p2_x2", p2_x2);
        editor.commit();
    }

    //第2个人物坐标 z
    public static float GetLocationP2_z2()
    {
        return sp.getFloat("p2_z2",0);
    }
    public static void WriteLocationP2_z2(float p2_z2)
    {
        editor.putFloat("p2_z2", p2_z2);
        editor.commit();
    }

    //第2个人物的角度
    public static float GetLocationP2_angle2()
    {
        return sp.getFloat("p2_angle2",0);
    }
    public static void WriteLocationP2_angle2(float p2_angle2)
    {
        editor.putFloat("p2_angle2", p2_angle2);
        editor.commit();
    }
    public static int GetP2_roadId2()
    {
        return sp.getInt("p2_roadId2",0);
    }
    public static void WriteP2_roadId2(int p2_roadId2)
    {
        editor.putInt("p2_roadId2", p2_roadId2);
        editor.commit();
    }

    public static int GetP2_CuberoadId2()
    {
        return sp.getInt("p2_cuberoadId2",0);
    }
    public static void WriteP2_CuberoadId2(int p2_cuberoadId2)
    {
        editor.putInt("p2_cuberoadId2", p2_cuberoadId2);
        editor.commit();
    }

    public static float GetP2_Money2()
    {
        return sp.getFloat("p2_money2",0);
    }
    public static void WriteP2_Money2(float p2_money2)
    {
        editor.putFloat("p2_money2", p2_money2);
        editor.commit();
    }
    public static float GetP2_Moneybank2()
    {
        return sp.getFloat("p2_moneybank2",0);
    }
    public static void WriteP2_Moneybank2(float p2_moneybank2)
    {
        editor.putFloat("p2_moneybank2", p2_moneybank2);
        editor.commit();
    }
    public static int GetP2_DQ2()
    {
        return sp.getInt("p2_dq2",0);
    }
    public static void WriteP2_DQ2(int p2_dq2)
    {
        editor.putInt("p2_dq2", p2_dq2);
        editor.commit();
    }
    public static int GetP2_DPCount2()
    {
        return sp.getInt("p2_dpcount2",0);
    }
    public static void WriteP2_DPCount2(int p2_dpcount2)
    {
        editor.putInt("p2_dpcount2", p2_dpcount2);
        editor.commit();
    }
    public static int GetP2_GPCount2()
    {
        return sp.getInt("p2_gpcount2",0);
    }
    public static void WriteP2_GPCount2(int p2_gpcount2)
    {
        editor.putInt("p2_gpcount2", p2_gpcount2);
        editor.commit();
    }
    //--------------------------------------------------------------------------------------------//
    //第3个人物坐标 x
    public static float GetLocationP3_x2()
    {
        return sp.getFloat("p3_x2",0);
    }
    public static void WriteLocationP3_x2(float p3_x2)
    {
        editor.putFloat("p3_x2", p3_x2);
        editor.commit();
    }

    //第3个人物坐标 z
    public static float GetLocationP3_z2()
    {
        return sp.getFloat("p3_z2",0);
    }
    public static void WriteLocationP3_z2(float p3_z2)
    {
        editor.putFloat("p3_z2", p3_z2);
        editor.commit();
    }

    //第3个人物的角度
    public static float GetLocationP3_angle2()
    {
        return sp.getFloat("p3_angle2",0);
    }
    public static void WriteLocationP3_angle2(float p3_angle2)
    {
        editor.putFloat("p3_angle2", p3_angle2);
        editor.commit();
    }
    public static int GetP3_roadId2()
    {
        return sp.getInt("p3_roadId2",0);
    }
    public static void WriteP3_roadId2(int p3_roadId2)
    {
        editor.putInt("p3_roadId2", p3_roadId2);
        editor.commit();
    }
    public static int GetP3_CuberoadId2()
    {
        return sp.getInt("p3_cuberoadId2",0);
    }
    public static void WriteP3_CuberoadId2(int p3_cuberoadId2)
    {
        editor.putInt("p3_cuberoadId2", p3_cuberoadId2);
        editor.commit();
    }
    public static float GetP3_Money2()
    {
        return sp.getFloat("p3_money2",0);
    }
    public static void WriteP3_Money2(float p3_money2)
    {
        editor.putFloat("p3_money2", p3_money2);
        editor.commit();
    }
    public static float GetP3_Moneybank2()
    {
        return sp.getFloat("p3_moneybank2",0);
    }
    public static void WriteP3_Moneybank2(float p3_moneybank2)
    {
        editor.putFloat("p3_moneybank2", p3_moneybank2);
        editor.commit();
    }
    public static int GetP3_DQ2()
    {
        return sp.getInt("p3_dq2",0);
    }
    public static void WriteP3_DQ2(int p3_dq2)
    {
        editor.putInt("p3_dq2", p3_dq2);
        editor.commit();
    }
    public static int GetP3_DPCount2()
    {
        return sp.getInt("p3_dpcount2",0);
    }
    public static void WriteP3_DPCount2(int p3_dpcount2)
    {
        editor.putInt("p3_dpcount2", p3_dpcount2);
        editor.commit();
    }
    public static int GetP3_GPCount2()
    {
        return sp.getInt("p3_gpcount2",0);
    }
    public static void WriteP3_GPCount2(int p3_gpcount2)
    {
        editor.putInt("p3_gpcount2", p3_gpcount2);
        editor.commit();
    }
    //------------------------------------------------------------------------------------------------//
//第4个人物坐标 x
    public static float GetLocationP4_x2()
    {
        return sp.getFloat("p4_x2",0);
    }
    public static void WriteLocationP4_x2(float p4_x2)
    {
        editor.putFloat("p4_x2", p4_x2);
        editor.commit();
    }

    //第4个人物坐标 z
    public static float GetLocationP4_z2()
    {
        return sp.getFloat("p4_z2",0);
    }
    public static void WriteLocationP4_z2(float p4_z2)
    {
        editor.putFloat("p4_z2", p4_z2);
        editor.commit();
    }

    //第4个人物的角度
    public static float GetLocationP4_angle2()
    {
        return sp.getFloat("p4_angle2",0);
    }
    public static void WriteLocationP4_angle2(float p4_angle2)
    {
        editor.putFloat("p4_angle2", p4_angle2);
        editor.commit();
    }
    public static int GetP4_roadId2()
    {
        return sp.getInt("p4_roadId2",0);
    }
    public static void WriteP4_roadId2(int p4_roadId2)
    {
        editor.putInt("p4_roadId2", p4_roadId2);
        editor.commit();
    }
    public static int GetP4_CuberoadId2()
    {
        return sp.getInt("p4_cuberoadId2",0);
    }
    public static void WriteP4_CuberoadId2(int p4_cuberoadId)
    {
        editor.putInt("p4_cuberoadId2", p4_cuberoadId);
        editor.commit();
    }
    public static float GetP4_Money2()
    {
        return sp.getFloat("p4_money2",0);
    }
    public static void WriteP4_Money2(float p4_money)
    {
        editor.putFloat("p4_money2", p4_money);
        editor.commit();
    }
    public static float GetP4_Moneybank2()
    {
        return sp.getFloat("p4_moneybank2",0);
    }
    public static void WriteP4_Moneybank2(float p4_moneybank)
    {
        editor.putFloat("p4_moneybank2", p4_moneybank);
        editor.commit();
    }
    public static int GetP4_DQ2()
    {
        return sp.getInt("p4_dq2",0);
    }
    public static void WriteP4_DQ2(int p4_dq)
    {
        editor.putInt("p4_dq2", p4_dq);
        editor.commit();
    }
    public static int GetP4_DPCount2()
    {
        return sp.getInt("p4_dpcount2",0);
    }
    public static void WriteP4_DPCount2(int p4_dpcount)
    {
        editor.putInt("p4_dpcount2", p4_dpcount);
        editor.commit();
    }
    public static int GetP4_GPCount2()
    {
        return sp.getInt("p4_gpcount2",0);
    }
    public static void WriteP4_GPCount2(int p4_gpcount)
    {
        editor.putInt("p4_gpcount2", p4_gpcount);
        editor.commit();
    }
//------------------------------------------------------------------------------------------------//

    public static void  WriteRoadState2()
    {
        for (int i=0;i<cubeRoadArray.length;i++)
        {
            if((i>=7&&i<=15)||(i>=19&&i<=25)||(i>=38&&i<=46)||(i>=63&&i<=67)||(i>=69&&i<=84)||(i>=87&&i<=92))
            {
                //已经购买土地
                editor.putInt("cubeRoadArray2"+i,cubeRoadArray[i].getRoadState());
                editor.commit();
            }
        }
    }

    public static void  GetRoadState2()
    {
        for (int i=0;i<cubeRoadArray.length;i++)
        {
            //地皮
            if((i>=7&&i<=15)||(i>=19&&i<=25)||(i>=38&&i<=46)||(i>=63&&i<=67)||(i>=69&&i<=84)||(i>=87&&i<=92))
            {
                cubeRoadArray[i].RoadState = sp.getInt("cubeRoadArray2"+i,0);
                //正在出售
                if(cubeRoadArray[i].RoadState==0)
                {
                    cubeRoadArray[i] = new CubeRoad(i,0,lovoOnSale,onsaleId,dipiarray[i]);
                }
                //P1
                else if(cubeRoadArray[i].RoadState==1)
                {
                    cubeRoadArray[i] = new CubeRoad(i,1,lovoBZMing,BZ_hongId,BZdata_P1[i]);
                }
                else if(cubeRoadArray[i].RoadState==2)
                {
                    cubeRoadArray[i] = new CubeRoad(i,2,lovoHouse1,houseId,houselevel1[i]);
                }
                else if(cubeRoadArray[i].RoadState==3)
                {
                    cubeRoadArray[i] = new CubeRoad(i,3,lovoHouse2, houseId, houselevel2[i]);
                }
                else if(cubeRoadArray[i].RoadState==4)
                {
                    cubeRoadArray[i] = new CubeRoad(i,4,lovoHouse3, houseId, houselevel3[i]);
                }
                //P2
                else if(cubeRoadArray[i].RoadState==5)
                {
                    cubeRoadArray[i] = new CubeRoad(i,5,lovoBZMing,BZ_lanId,BZdata_P2[i]);
                }
                else if(cubeRoadArray[i].RoadState==6)
                {
                    cubeRoadArray[i] = new CubeRoad(i,6,lovoHouse1,houseId,houselevel1[i]);
                }
                else if(cubeRoadArray[i].RoadState==7)
                {
                    cubeRoadArray[i] = new CubeRoad(i,7,lovoHouse2, houseId, houselevel2[i]);
                }
                else if(cubeRoadArray[i].RoadState==8)
                {
                    cubeRoadArray[i] = new CubeRoad(i,8,lovoHouse3, houseId, houselevel3[i]);
                }
                //P3
                else if(cubeRoadArray[i].RoadState==9)
                {
                    cubeRoadArray[i] = new CubeRoad(i,6,lovoBZMing,BZ_zongId,BZdata_P3[i]);
                }
                else if(cubeRoadArray[i].RoadState==10)
                {
                    cubeRoadArray[i] = new CubeRoad(i,10,lovoHouse2, houseId, houselevel2[i]);
                }
                else if(cubeRoadArray[i].RoadState==11)
                {
                    cubeRoadArray[i] = new CubeRoad(i,11,lovoBZMing,BZ_lanId,BZdata_P2[i]);
                }
                else if(cubeRoadArray[i].RoadState==12)
                {
                    cubeRoadArray[i] = new CubeRoad(i,12,lovoHouse3, houseId, houselevel3[i]);
                }
                //P4
                else if(cubeRoadArray[i].RoadState==13)
                {
                    cubeRoadArray[i] = new CubeRoad(i,13,lovoBZMing,BZ_heId,BZdata_P4[i]);
                }
                else if(cubeRoadArray[i].RoadState==14)
                {
                    cubeRoadArray[i] = new CubeRoad(i,14,lovoHouse1,houseId,houselevel1[i]);
                }
                else if(cubeRoadArray[i].RoadState==15)
                {
                    cubeRoadArray[i] = new CubeRoad(i,15,lovoHouse2, houseId, houselevel2[i]);
                }
                else if(cubeRoadArray[i].RoadState==16)
                {
                    cubeRoadArray[i] = new CubeRoad(i,16,lovoHouse3, houseId, houselevel3[i]);
                }
            }
            else
            {
                cubeRoadArray[i] = null;
            }
        }
        cubeRoadArray[2] = new CubeRoad(2,22,lovoMapCube,road20Id,road20data[0]);
        cubeRoadArray[4] = new CubeRoad(4,22,lovoMapCube,road20Id,road20data[1]);
        cubeRoadArray[32] = new CubeRoad(32,22,lovoMapCube,road20Id,road20data[2]);
        cubeRoadArray[34] = new CubeRoad(34,22,lovoMapCube,road20Id,road20data[3]);
        cubeRoadArray[36] = new CubeRoad(36,22,lovoMapCube,road20Id,road20data[4]);
        cubeRoadArray[48] = new CubeRoad(48,22,lovoMapCube,road20Id,road20data[5]);
        cubeRoadArray[50] = new CubeRoad(50,22,lovoMapCube,road20Id,road20data[6]);
        cubeRoadArray[58] = new CubeRoad(58,22,lovoMapCube,road20Id,road20data[7]);
        cubeRoadArray[60] = new CubeRoad(60,22,lovoMapCube,road20Id,road20data[8]);
        cubeRoadArray[95] = new CubeRoad(95,22,lovoMapCube,road20Id,road20data[9]);
        cubeRoadArray[97] = new CubeRoad(97,22,lovoMapCube,road20Id,road20data[10]);
        cubeRoadArray[99] = new CubeRoad(99,22,lovoMapCube,road20Id,road20data[11]);
        cubeRoadArray[47] = new CubeRoad(47,23,lovoMapCube,road20Id,road50data[2]);
        //点券 50  1   5  47 52 57 62 94 100
        cubeRoadArray[1] = new CubeRoad(1,23,lovoMapCube,road50Id,road50data[0]);
        cubeRoadArray[5] = new CubeRoad(5,23,lovoMapCube,road50Id,road50data[1]);
        cubeRoadArray[52] = new CubeRoad(52,23,lovoMapCube,road50Id,road50data[3]);
        cubeRoadArray[57] = new CubeRoad(57,23,lovoMapCube,road50Id,road50data[4]);
        cubeRoadArray[62] = new CubeRoad(62,23,lovoMapCube,road50Id,road50data[5]);
        cubeRoadArray[94] = new CubeRoad(94,23,lovoMapCube,road50Id,road50data[6]);
        //彩票站
        cubeRoadArray[100] = new CubeRoad(100,32,lovoMapCube,cpstationId,road50data[7]);
        // bank  hospital shop bank shop
        cubeRoadArray[16] = new CubeRoad(16,17,lovoMapCube,bankCubeId,bsydata[1]);
        cubeRoadArray[18] = new CubeRoad(18,24,lovoMapCube,hospitalCubeId,bsydata[0]);
        cubeRoadArray[30] = new CubeRoad(30,18,lovoMapCube,shopCubeId,bsydata[2]);
        cubeRoadArray[56] = new CubeRoad(56,17,lovoMapCube,bankCubeId,bsydata[3]);
        cubeRoadArray[101] = new CubeRoad(101,18,lovoMapCube,shopCubeId,bsydata[4]);
        //神仙的方块
        //  6  17 26 31  37  53  68 85 93
        cubeRoadArray[6] = new CubeRoad(6,25,lovoMapCube,caishenId,shenxiandata[0]);    //财神
        cubeRoadArray[17] = new CubeRoad(17,26,lovoMapCube,fushenId,shenxiandata[1]);   //福神
        cubeRoadArray[26] = new CubeRoad(26,27,lovoMapCube,tianshiId,shenxiandata[2]);  //天使
        cubeRoadArray[31] = new CubeRoad(31,28,lovoMapCube,shuaishenId,shenxiandata[3]);//衰神
        cubeRoadArray[37] = new CubeRoad(37,29,lovoMapCube,caishenId,shenxiandata[4]);//财神
        cubeRoadArray[53] = new CubeRoad(53,25,lovoMapCube,caishenId,shenxiandata[5]);     //财神
        cubeRoadArray[68] = new CubeRoad(68,27,lovoMapCube,tianshiId,shenxiandata[6]);     //天使
        cubeRoadArray[85] = new CubeRoad(85,30,lovoMapCube,emoId,shenxiandata[7]);      //恶魔
        cubeRoadArray[93] = new CubeRoad(93,28,lovoMapCube,shuaishenId,shenxiandata[8]);  //衰神
        //28  29  加油站
        cubeRoadArray[28] = new CubeRoad(28,20,lovoMapCube,jiantouZId,jiantoudata[0]);
        cubeRoadArray[29] = new CubeRoad(29,20,lovoJianTouW,jiantouWId,jiantoudata[1]);
        //54  55 商店
        cubeRoadArray[54] = new CubeRoad(54,19,lovoMapCube,jiantouZId,jiantoudata[2]);
        cubeRoadArray[55] = new CubeRoad(55,19,lovoJianTouW,jiantouWId,jiantoudata[3]);
        ///motel 102 103
        cubeRoadArray[102] = new CubeRoad(102,21,lovoMapCube,jiantouZId,jiantoudata[4]);
        cubeRoadArray[103] = new CubeRoad(103,21,lovoJianTouW,jiantouWId,jiantoudata[5]);
        cubeRoadArrayList.clear();
        //初始化所有公路块数据
        for (int i=0;i<cubeRoadArray.length;i++)
        {
            cubeRoadArrayList.add(cubeRoadArray[i]);
        }
    }
    //读取存档
    public static void readData2()
    {
        locationDArray[0][0] = GetLocationP1_x2();
        locationDArray[0][2] = GetLocationP1_z2();
        locationDArray[0][3] = GetLocationP1_angle2();

        locationDArray[1][0] = GetLocationP2_x2();
        locationDArray[1][2] = GetLocationP2_z2();
        locationDArray[1][3] = GetLocationP2_angle2();

        locationDArray[2][0] = GetLocationP3_x2();
        locationDArray[2][2] = GetLocationP3_z2();
        locationDArray[2][3] = GetLocationP3_angle2();

        locationDArray[3][0] = GetLocationP4_x2();
        locationDArray[3][2] = GetLocationP4_z2();
        locationDArray[3][3] = GetLocationP4_angle2();

        locationJArray[0][0] = locationDArray[0][0];
        locationJArray[0][2] = locationDArray[0][2];
        locationJArray[0][3] = locationDArray[0][3];
        locationJArray[1][0] = locationDArray[1][0];
        locationJArray[1][2] = locationDArray[1][2];
        locationJArray[1][3] = locationDArray[1][3];
        locationJArray[2][0] = locationDArray[2][0];
        locationJArray[2][2] = locationDArray[2][2];
        locationJArray[2][3] = locationDArray[2][3];
        locationJArray[3][0] = locationDArray[3][0];
        locationJArray[3][2] = locationDArray[3][2];
        locationJArray[3][3] = locationDArray[3][3];

        roadIdArray[0] = GetP1_roadId2();
        roadIdArray[1] = GetP2_roadId2();
        roadIdArray[2] = GetP3_roadId2();
        roadIdArray[3] = GetP4_roadId2();

        currentRoadArray[0]  =GetP1_CuberoadId2();
        currentRoadArray[1]  =GetP2_CuberoadId2();
        currentRoadArray[2]  =GetP3_CuberoadId2();
        currentRoadArray[3]  =GetP4_CuberoadId2();

        moneyArray[0][0] =GetP1_Money2();
        moneyArray[1][0] =GetP2_Money2();
        moneyArray[2][0] =GetP3_Money2();
        moneyArray[3][0] =GetP4_Money2();

        moneyArray[0][1] =GetP1_Moneybank2();
        moneyArray[1][1] =GetP2_Moneybank2();
        moneyArray[2][1] =GetP3_Moneybank2();
        moneyArray[3][1] =GetP4_Moneybank2();

        moneyArray[0][2] = moneyArray[0][0]+moneyArray[0][1];
        moneyArray[1][2] = moneyArray[1][0]+moneyArray[1][1];
        moneyArray[2][2] = moneyArray[2][0]+moneyArray[2][1];
        moneyArray[3][2] = moneyArray[3][0]+moneyArray[3][1];

        cardmoneyArray[0] = GetP1_DQ2();
        cardmoneyArray[1] = GetP2_DQ2();
        cardmoneyArray[2] = GetP3_DQ2();
        cardmoneyArray[3] = GetP4_DQ2();

        dipicount[0] = GetP1_DPCount2();
        dipicount[1] = GetP2_DPCount2();
        dipicount[2] = GetP3_DPCount2();
        dipicount[3] = GetP4_DPCount2();

        chiyoushu[0] =GetP1_GPCount2();
        chiyoushu[1] =GetP2_GPCount2();
        chiyoushu[2] =GetP3_GPCount2();
        chiyoushu[3] =GetP4_GPCount2();

        jiaoyiliang[0] = 2000-chiyoushu[0];
        jiaoyiliang[1] = 2000-chiyoushu[1];
        jiaoyiliang[2] = 2000-chiyoushu[2];
        jiaoyiliang[3] = 2000-chiyoushu[3];

        GetRoadState2();
        year = GetYear2();
        month = GetMonth2();
        day = GetDay2();
        huiheId = 0;
        personId = 0;
        throwUtil = null;
        throwUtil = new ThrowUtil();
    }
    //存储存档
    public static void saveData2()
    {
        WriteLocationP1_x2(locationDArray[0][0]);
        WriteLocationP1_z2(locationDArray[0][2]);
        WriteLocationP1_angle2(locationDArray[0][3]);

        WriteLocationP2_x2(locationDArray[1][0]);
        WriteLocationP2_z2(locationDArray[1][2]);
        WriteLocationP2_angle2(locationDArray[1][3]);

        WriteLocationP3_x2(locationDArray[2][0]);
        WriteLocationP3_z2(locationDArray[2][2]);
        WriteLocationP3_angle2(locationDArray[2][3]);

        WriteLocationP4_x2(locationDArray[3][0]);
        WriteLocationP4_z2(locationDArray[3][2]);
        WriteLocationP4_angle2(locationDArray[3][3]);

        WriteP1_roadId2(roadIdArray[0]);
        WriteP2_roadId2(roadIdArray[1]);
        WriteP3_roadId2(roadIdArray[2]);
        WriteP4_roadId2(roadIdArray[3]);

        WriteP1_CuberoadId2(currentRoadArray[0]);
        WriteP2_CuberoadId2(currentRoadArray[1]);
        WriteP3_CuberoadId2(currentRoadArray[2]);
        WriteP4_CuberoadId2(currentRoadArray[3]);

        WriteP1_Money2(moneyArray[0][0]);
        WriteP2_Money2(moneyArray[1][0]);
        WriteP3_Money2(moneyArray[2][0]);
        WriteP4_Money2(moneyArray[3][0]);

        WriteP1_Moneybank2(moneyArray[0][1]);
        WriteP2_Moneybank2(moneyArray[1][1]);
        WriteP3_Moneybank2(moneyArray[2][1]);
        WriteP4_Moneybank2(moneyArray[3][1]);

        WriteP1_DQ2(cardmoneyArray[0]);
        WriteP2_DQ2(cardmoneyArray[1]);
        WriteP3_DQ2(cardmoneyArray[2]);
        WriteP4_DQ2(cardmoneyArray[3]);

        WriteP1_DPCount2(dipicount[0]);
        WriteP2_DPCount2(dipicount[1]);
        WriteP3_DPCount2(dipicount[2]);
        WriteP4_DPCount2(dipicount[3]);

        WriteP1_GPCount2(chiyoushu[0]);
        WriteP2_GPCount2(chiyoushu[1]);
        WriteP3_GPCount2(chiyoushu[2]);
        WriteP4_GPCount2(chiyoushu[3]);
        WriteRoadState2();
        WriteYear2(year);
        WriteMonth2(month);
        WriteDay2(day);

        WriteCDTimeYear2(year2);
        WriteCDTimeMonth2(month2);
        WriteCDTimecdDay2(day2);
        WriteCDTimeHour2(hour2);
        WriteCDTimeMin2(min2);
    }

    //第三条存档**----------------------//
    //------------------------------------------------------------------------------------------------//
    //当前是否含有存档的标志位
    public static int GetCDState3()
    {
        return sp.getInt("cdState3",0);
    }
    public static void WriteCDState3(int cdState)
    {
        editor.putInt("cdState3", cdState);
        editor.commit();
    }
    //日期
    public static int GetYear3()
    {
        return sp.getInt("year3",0);
    }
    public static void WriteYear3(int year)
    {
        editor.putInt("year3",year);
        editor.commit();
    }

    public static int GetMonth3()
    {
        return sp.getInt("month3",0);
    }
    public static void WriteMonth3(int month)
    {
        editor.putInt("month3",month);
        editor.commit();
    }

    public static int GetDay3()
    {
        return sp.getInt("day3",0);
    }
    public static void WriteDay3(int day)
    {
        editor.putInt("day3",day);
        editor.commit();
    }
    //第一个人物坐标 x
    public static float GetLocationP1_x3()
    {

        return sp.getFloat("p1_x3",0);
    }
    public static void WriteLocationP1_x3(float p1_x)
    {
        editor.putFloat("p1_x3", p1_x);
        editor.commit();
    }

    //第一个人物坐标 z
    public static float GetLocationP1_z3()
    {
        return sp.getFloat("p1_z3",0);
    }
    public static void WriteLocationP1_z3(float p1_z)
    {
        editor.putFloat("p1_z3", p1_z);
        editor.commit();
    }

    //第一个人物的角度
    public static float GetLocationP1_angle3()
    {
        return sp.getFloat("p1_angle3",0);
    }
    public static void WriteLocationP1_angle3(float p1_angle)
    {
        editor.putFloat("p1_angle3", p1_angle);
        editor.commit();
    }
    public static int GetP1_roadId3()
    {
        return sp.getInt("p1_roadId3",0);
    }
    public static void WriteP1_roadId3(int p1_roadId)
    {
        editor.putInt("p1_roadId3", p1_roadId);
        editor.commit();
    }
    public static int GetP1_CuberoadId3()
    {
        return sp.getInt("p1_cuberoadId3",0);
    }
    public static void WriteP1_CuberoadId3(int p1_cuberoadId)
    {
        editor.putInt("p1_cuberoadId3", p1_cuberoadId);
        editor.commit();
    }
    public static float GetP1_Money3()
    {
        return sp.getFloat("p1_money3",0);
    }
    public static void WriteP1_Money3(float p1_money)
    {
        editor.putFloat("p1_money3", p1_money);
        editor.commit();
    }
    public static float GetP1_Moneybank3()
    {
        return sp.getFloat("p1_moneybank3",0);
    }
    public static void WriteP1_Moneybank3(float p1_moneybank)
    {
        editor.putFloat("p1_moneybank3", p1_moneybank);
        editor.commit();
    }
    public static int GetP1_DQ3()
    {
        return sp.getInt("p1_dq3",0);
    }
    public static void WriteP1_DQ3(int p1_dq)
    {
        editor.putInt("p1_dq3", p1_dq);
        editor.commit();
    }
    public static int GetP1_DPCount3()
    {
        return sp.getInt("p1_dpcount3",0);
    }
    public static void WriteP1_DPCount3(int p1_dpcount)
    {
        editor.putInt("p1_dpcount3", p1_dpcount);
        editor.commit();
    }
    public static int GetP1_GPCount3()
    {
        return sp.getInt("p1_gpcount3",0);
    }
    public static void WriteP1_GPCount3(int p1_gpcount)
    {
        editor.putInt("p1_gpcount3", p1_gpcount);
        editor.commit();
    }
    //--------------------------------------------------------------------------------------------//
    //第2个人物坐标 x
    public static float GetLocationP2_x3()
    {
        return sp.getFloat("p2_x3",0);
    }
    public static void WriteLocationP2_x3(float p2_x)
    {
        editor.putFloat("p2_x3", p2_x);
        editor.commit();
    }

    //第2个人物坐标 z
    public static float GetLocationP2_z3()
    {
        return sp.getFloat("p2_z3",0);
    }
    public static void WriteLocationP2_z3(float p2_z)
    {
        editor.putFloat("p2_z3", p2_z);
        editor.commit();
    }

    //第2个人物的角度
    public static float GetLocationP2_angle3()
    {
        return sp.getFloat("p2_angle3",0);
    }
    public static void WriteLocationP2_angle3(float p2_angle)
    {
        editor.putFloat("p2_angle3", p2_angle);
        editor.commit();
    }
    public static int GetP2_roadId3()
    {
        return sp.getInt("p2_roadId3",0);
    }
    public static void WriteP2_roadId3(int p2_roadId)
    {
        editor.putInt("p2_roadId3", p2_roadId);
        editor.commit();
    }

    public static int GetP2_CuberoadId3()
    {
        return sp.getInt("p2_cuberoadId3",0);
    }
    public static void WriteP2_CuberoadId3(int p2_cuberoadId)
    {
        editor.putInt("p2_cuberoadId3", p2_cuberoadId);
        editor.commit();
    }

    public static float GetP2_Money3()
    {
        return sp.getFloat("p2_money3",0);
    }
    public static void WriteP2_Money3(float p2_money)
    {
        editor.putFloat("p2_money3", p2_money);
        editor.commit();
    }
    public static float GetP2_Moneybank3()
    {
        return sp.getFloat("p2_moneybank3",0);
    }
    public static void WriteP2_Moneybank3(float p2_moneybank)
    {
        editor.putFloat("p2_moneybank3", p2_moneybank);
        editor.commit();
    }
    public static int GetP2_DQ3()
    {
        return sp.getInt("p2_dq3",0);
    }
    public static void WriteP2_DQ3(int p2_dq)
    {
        editor.putInt("p2_dq3", p2_dq);
        editor.commit();
    }
    public static int GetP2_DPCount3()
    {
        return sp.getInt("p2_dpcount3",0);
    }
    public static void WriteP2_DPCount3(int p2_dpcount)
    {
        editor.putInt("p2_dpcount3", p2_dpcount);
        editor.commit();
    }
    public static int GetP2_GPCount3()
    {
        return sp.getInt("p2_gpcount3",0);
    }
    public static void WriteP2_GPCount3(int p2_gpcount)
    {
        editor.putInt("p2_gpcount3", p2_gpcount);
        editor.commit();
    }
    //--------------------------------------------------------------------------------------------//
    //第3个人物坐标 x
    public static float GetLocationP3_x3()
    {
        return sp.getFloat("p3_x3",0);
    }
    public static void WriteLocationP3_x3(float p3_x)
    {
        editor.putFloat("p3_x3", p3_x);
        editor.commit();
    }

    //第3个人物坐标 z
    public static float GetLocationP3_z3()
    {
        return sp.getFloat("p3_z3",0);
    }
    public static void WriteLocationP3_z3(float p3_z)
    {
        editor.putFloat("p3_z3", p3_z);
        editor.commit();
    }

    //第3个人物的角度
    public static float GetLocationP3_angle3()
    {
        return sp.getFloat("p3_angle3",0);
    }
    public static void WriteLocationP3_angle3(float p3_angle)
    {
        editor.putFloat("p3_angle3", p3_angle);
        editor.commit();
    }
    public static int GetP3_roadId3()
    {
        return sp.getInt("p3_roadId3",0);
    }
    public static void WriteP3_roadId3(int p3_roadId)
    {
        editor.putInt("p3_roadId3", p3_roadId);
        editor.commit();
    }
    public static int GetP3_CuberoadId3()
    {
        return sp.getInt("p3_cuberoadId3",0);
    }
    public static void WriteP3_CuberoadId3(int p3_cuberoadId)
    {
        editor.putInt("p3_cuberoadId3", p3_cuberoadId);
        editor.commit();
    }
    public static float GetP3_Money3()
    {
        return sp.getFloat("p3_money3",0);
    }
    public static void WriteP3_Money3(float p3_money)
    {
        editor.putFloat("p3_money3", p3_money);
        editor.commit();
    }
    public static float GetP3_Moneybank3()
    {
        return sp.getFloat("p3_moneybank3",0);
    }
    public static void WriteP3_Moneybank3(float p3_moneybank)
    {
        editor.putFloat("p3_moneybank3", p3_moneybank);
        editor.commit();
    }
    public static int GetP3_DQ3()
    {
        return sp.getInt("p3_dq3",0);
    }
    public static void WriteP3_DQ3(int p3_dq)
    {
        editor.putInt("p3_dq3", p3_dq);
        editor.commit();
    }
    public static int GetP3_DPCount3()
    {
        return sp.getInt("p3_dpcount3",0);
    }
    public static void WriteP3_DPCount3(int p3_dpcount)
    {
        editor.putInt("p3_dpcount3", p3_dpcount);
        editor.commit();
    }
    public static int GetP3_GPCount3()
    {
        return sp.getInt("p3_gpcount3",0);
    }
    public static void WriteP3_GPCount3(int p3_gpcount)
    {
        editor.putInt("p3_gpcount3", p3_gpcount);
        editor.commit();
    }
    //------------------------------------------------------------------------------------------------//
//第4个人物坐标 x
    public static float GetLocationP4_x3()
    {
        return sp.getFloat("p4_x3",0);
    }
    public static void WriteLocationP4_x3(float p4_x)
    {
        editor.putFloat("p4_x3", p4_x);
        editor.commit();
    }

    //第4个人物坐标 z
    public static float GetLocationP4_z3()
    {
        return sp.getFloat("p4_z3",0);
    }
    public static void WriteLocationP4_z3(float p4_z)
    {
        editor.putFloat("p4_z3", p4_z);
        editor.commit();
    }

    //第4个人物的角度
    public static float GetLocationP4_angle3()
    {
        return sp.getFloat("p4_angle3",0);
    }
    public static void WriteLocationP4_angle3(float p4_angle)
    {
        editor.putFloat("p4_angle3", p4_angle);
        editor.commit();
    }
    public static int GetP4_roadId3()
    {
        return sp.getInt("p4_roadId3",0);
    }
    public static void WriteP4_roadId3(int p4_roadId)
    {
        editor.putInt("p4_roadId3", p4_roadId);
        editor.commit();
    }
    public static int GetP4_CuberoadId3()
    {
        return sp.getInt("p4_cuberoadId3",0);
    }
    public static void WriteP4_CuberoadId3(int p4_cuberoadId)
    {
        editor.putInt("p4_cuberoadId3", p4_cuberoadId);
        editor.commit();
    }
    public static float GetP4_Money3()
    {
        return sp.getFloat("p4_money3",0);
    }
    public static void WriteP4_Money3(float p4_money)
    {
        editor.putFloat("p4_money3", p4_money);
        editor.commit();
    }
    public static float GetP4_Moneybank3()
    {
        return sp.getFloat("p4_moneybank3",0);
    }
    public static void WriteP4_Moneybank3(float p4_moneybank)
    {
        editor.putFloat("p4_moneybank3", p4_moneybank);
        editor.commit();
    }
    public static int GetP4_DQ3()
    {
        return sp.getInt("p4_dq3",0);
    }
    public static void WriteP4_DQ3(int p4_dq)
    {
        editor.putInt("p4_dq3", p4_dq);
        editor.commit();
    }
    public static int GetP4_DPCount3()
    {
        return sp.getInt("p4_dpcount3",0);
    }
    public static void WriteP4_DPCount3(int p4_dpcount)
    {
        editor.putInt("p4_dpcount3", p4_dpcount);
        editor.commit();
    }
    public static int GetP4_GPCount3()
    {
        return sp.getInt("p4_gpcount3",0);
    }
    public static void WriteP4_GPCount3(int p4_gpcount)
    {
        editor.putInt("p4_gpcount3", p4_gpcount);
        editor.commit();
    }
//------------------------------------------------------------------------------------------------//

    public static void  WriteRoadState3()
    {
        for (int i=0;i<cubeRoadArray.length;i++)
        {
            if((i>=7&&i<=15)||(i>=19&&i<=25)||(i>=38&&i<=46)||(i>=63&&i<=67)||(i>=69&&i<=84)||(i>=87&&i<=92))
            {
                //已经购买土地
                editor.putInt("cubeRoadArray3"+i,cubeRoadArray[i].getRoadState());
                editor.commit();
            }
        }
    }

    public static void  GetRoadState3()
    {
        for (int i=0;i<cubeRoadArray.length;i++)
        {
            //地皮
            if((i>=7&&i<=15)||(i>=19&&i<=25)||(i>=38&&i<=46)||(i>=63&&i<=67)||(i>=69&&i<=84)||(i>=87&&i<=92))
            {
                cubeRoadArray[i].RoadState = sp.getInt("cubeRoadArray3"+i,0);
                //正在出售
                if(cubeRoadArray[i].RoadState==0)
                {
                    cubeRoadArray[i] = new CubeRoad(i,0,lovoOnSale,onsaleId,dipiarray[i]);
                }
                //P1
                else if(cubeRoadArray[i].RoadState==1)
                {
                    cubeRoadArray[i] = new CubeRoad(i,1,lovoBZMing,BZ_hongId,BZdata_P1[i]);
                }
                else if(cubeRoadArray[i].RoadState==2)
                {
                    cubeRoadArray[i] = new CubeRoad(i,2,lovoHouse1,houseId,houselevel1[i]);
                }
                else if(cubeRoadArray[i].RoadState==3)
                {
                    cubeRoadArray[i] = new CubeRoad(i,3,lovoHouse2, houseId, houselevel2[i]);
                }
                else if(cubeRoadArray[i].RoadState==4)
                {
                    cubeRoadArray[i] = new CubeRoad(i,4,lovoHouse3, houseId, houselevel3[i]);
                }
                //P2
                else if(cubeRoadArray[i].RoadState==5)
                {
                    cubeRoadArray[i] = new CubeRoad(i,5,lovoBZMing,BZ_lanId,BZdata_P2[i]);
                }
                else if(cubeRoadArray[i].RoadState==6)
                {
                    cubeRoadArray[i] = new CubeRoad(i,6,lovoHouse1,houseId,houselevel1[i]);
                }
                else if(cubeRoadArray[i].RoadState==7)
                {
                    cubeRoadArray[i] = new CubeRoad(i,7,lovoHouse2, houseId, houselevel2[i]);
                }
                else if(cubeRoadArray[i].RoadState==8)
                {
                    cubeRoadArray[i] = new CubeRoad(i,8,lovoHouse3, houseId, houselevel3[i]);
                }
                //P3
                else if(cubeRoadArray[i].RoadState==9)
                {
                    cubeRoadArray[i] = new CubeRoad(i,6,lovoBZMing,BZ_zongId,BZdata_P3[i]);
                }
                else if(cubeRoadArray[i].RoadState==10)
                {
                    cubeRoadArray[i] = new CubeRoad(i,10,lovoHouse2, houseId, houselevel2[i]);
                }
                else if(cubeRoadArray[i].RoadState==11)
                {
                    cubeRoadArray[i] = new CubeRoad(i,11,lovoBZMing,BZ_lanId,BZdata_P2[i]);
                }
                else if(cubeRoadArray[i].RoadState==12)
                {
                    cubeRoadArray[i] = new CubeRoad(i,12,lovoHouse3, houseId, houselevel3[i]);
                }
                //P4
                else if(cubeRoadArray[i].RoadState==13)
                {
                    cubeRoadArray[i] = new CubeRoad(i,13,lovoBZMing,BZ_heId,BZdata_P4[i]);
                }
                else if(cubeRoadArray[i].RoadState==14)
                {
                    cubeRoadArray[i] = new CubeRoad(i,14,lovoHouse1,houseId,houselevel1[i]);
                }
                else if(cubeRoadArray[i].RoadState==15)
                {
                    cubeRoadArray[i] = new CubeRoad(i,15,lovoHouse2, houseId, houselevel2[i]);
                }
                else if(cubeRoadArray[i].RoadState==16)
                {
                    cubeRoadArray[i] = new CubeRoad(i,16,lovoHouse3, houseId, houselevel3[i]);
                }
            }
            else
            {
                cubeRoadArray[i] = null;
            }
        }
        cubeRoadArray[2] = new CubeRoad(2,22,lovoMapCube,road20Id,road20data[0]);
        cubeRoadArray[4] = new CubeRoad(4,22,lovoMapCube,road20Id,road20data[1]);
        cubeRoadArray[32] = new CubeRoad(32,22,lovoMapCube,road20Id,road20data[2]);
        cubeRoadArray[34] = new CubeRoad(34,22,lovoMapCube,road20Id,road20data[3]);
        cubeRoadArray[36] = new CubeRoad(36,22,lovoMapCube,road20Id,road20data[4]);
        cubeRoadArray[48] = new CubeRoad(48,22,lovoMapCube,road20Id,road20data[5]);
        cubeRoadArray[50] = new CubeRoad(50,22,lovoMapCube,road20Id,road20data[6]);
        cubeRoadArray[58] = new CubeRoad(58,22,lovoMapCube,road20Id,road20data[7]);
        cubeRoadArray[60] = new CubeRoad(60,22,lovoMapCube,road20Id,road20data[8]);
        cubeRoadArray[95] = new CubeRoad(95,22,lovoMapCube,road20Id,road20data[9]);
        cubeRoadArray[97] = new CubeRoad(97,22,lovoMapCube,road20Id,road20data[10]);
        cubeRoadArray[99] = new CubeRoad(99,22,lovoMapCube,road20Id,road20data[11]);
        cubeRoadArray[47] = new CubeRoad(47,23,lovoMapCube,road20Id,road50data[2]);
        //点券 50  1   5  47 52 57 62 94 100
        cubeRoadArray[1] = new CubeRoad(1,23,lovoMapCube,road50Id,road50data[0]);
        cubeRoadArray[5] = new CubeRoad(5,23,lovoMapCube,road50Id,road50data[1]);
        cubeRoadArray[52] = new CubeRoad(52,23,lovoMapCube,road50Id,road50data[3]);
        cubeRoadArray[57] = new CubeRoad(57,23,lovoMapCube,road50Id,road50data[4]);
        cubeRoadArray[62] = new CubeRoad(62,23,lovoMapCube,road50Id,road50data[5]);
        cubeRoadArray[94] = new CubeRoad(94,23,lovoMapCube,road50Id,road50data[6]);
        //彩票站
        cubeRoadArray[100] = new CubeRoad(100,32,lovoMapCube,cpstationId,road50data[7]);
        // bank  hospital shop bank shop
        cubeRoadArray[16] = new CubeRoad(16,17,lovoMapCube,bankCubeId,bsydata[1]);
        cubeRoadArray[18] = new CubeRoad(18,24,lovoMapCube,hospitalCubeId,bsydata[0]);
        cubeRoadArray[30] = new CubeRoad(30,18,lovoMapCube,shopCubeId,bsydata[2]);
        cubeRoadArray[56] = new CubeRoad(56,17,lovoMapCube,bankCubeId,bsydata[3]);
        cubeRoadArray[101] = new CubeRoad(101,18,lovoMapCube,shopCubeId,bsydata[4]);
        //神仙的方块
        //  6  17 26 31  37  53  68 85 93
        cubeRoadArray[6] = new CubeRoad(6,25,lovoMapCube,caishenId,shenxiandata[0]);    //财神
        cubeRoadArray[17] = new CubeRoad(17,26,lovoMapCube,fushenId,shenxiandata[1]);   //福神
        cubeRoadArray[26] = new CubeRoad(26,27,lovoMapCube,tianshiId,shenxiandata[2]);  //天使
        cubeRoadArray[31] = new CubeRoad(31,28,lovoMapCube,shuaishenId,shenxiandata[3]);//衰神
        cubeRoadArray[37] = new CubeRoad(37,29,lovoMapCube,caishenId,shenxiandata[4]);//财神
        cubeRoadArray[53] = new CubeRoad(53,25,lovoMapCube,caishenId,shenxiandata[5]);     //财神
        cubeRoadArray[68] = new CubeRoad(68,27,lovoMapCube,tianshiId,shenxiandata[6]);     //天使
        cubeRoadArray[85] = new CubeRoad(85,30,lovoMapCube,emoId,shenxiandata[7]);      //恶魔
        cubeRoadArray[93] = new CubeRoad(93,28,lovoMapCube,shuaishenId,shenxiandata[8]);  //衰神
        //28  29  加油站
        cubeRoadArray[28] = new CubeRoad(28,20,lovoMapCube,jiantouZId,jiantoudata[0]);
        cubeRoadArray[29] = new CubeRoad(29,20,lovoJianTouW,jiantouWId,jiantoudata[1]);
        //54  55 商店
        cubeRoadArray[54] = new CubeRoad(54,19,lovoMapCube,jiantouZId,jiantoudata[2]);
        cubeRoadArray[55] = new CubeRoad(55,19,lovoJianTouW,jiantouWId,jiantoudata[3]);
        ///motel 102 103
        cubeRoadArray[102] = new CubeRoad(102,21,lovoMapCube,jiantouZId,jiantoudata[4]);
        cubeRoadArray[103] = new CubeRoad(103,21,lovoJianTouW,jiantouWId,jiantoudata[5]);
        cubeRoadArrayList.clear();
        //初始化所有公路块数据
        for (int i=0;i<cubeRoadArray.length;i++)
        {
            cubeRoadArrayList.add(cubeRoadArray[i]);
        }
    }
    //读取存档
    public static void readData3()
    {
        locationDArray[0][0] = GetLocationP1_x3();
        locationDArray[0][2] = GetLocationP1_z3();
        locationDArray[0][3] = GetLocationP1_angle3();

        locationDArray[1][0] = GetLocationP2_x3();
        locationDArray[1][2] = GetLocationP2_z3();
        locationDArray[1][3] = GetLocationP2_angle3();

        locationDArray[2][0] = GetLocationP3_x3();
        locationDArray[2][2] = GetLocationP3_z3();
        locationDArray[2][3] = GetLocationP3_angle3();

        locationDArray[3][0] = GetLocationP4_x3();
        locationDArray[3][2] = GetLocationP4_z3();
        locationDArray[3][3] = GetLocationP4_angle3();

        locationJArray[0][0] = locationDArray[0][0];
        locationJArray[0][2] = locationDArray[0][2];
        locationJArray[0][3] = locationDArray[0][3];
        locationJArray[1][0] = locationDArray[1][0];
        locationJArray[1][2] = locationDArray[1][2];
        locationJArray[1][3] = locationDArray[1][3];
        locationJArray[2][0] = locationDArray[2][0];
        locationJArray[2][2] = locationDArray[2][2];
        locationJArray[2][3] = locationDArray[2][3];
        locationJArray[3][0] = locationDArray[3][0];
        locationJArray[3][2] = locationDArray[3][2];
        locationJArray[3][3] = locationDArray[3][3];

        roadIdArray[0] = GetP1_roadId3();
        roadIdArray[1] = GetP2_roadId3();
        roadIdArray[2] = GetP3_roadId3();
        roadIdArray[3] = GetP4_roadId3();

        currentRoadArray[0]  =GetP1_CuberoadId3();
        currentRoadArray[1]  =GetP2_CuberoadId3();
        currentRoadArray[2]  =GetP3_CuberoadId3();
        currentRoadArray[3]  =GetP4_CuberoadId3();

        moneyArray[0][0] =GetP1_Money3();
        moneyArray[1][0] =GetP2_Money3();
        moneyArray[2][0] =GetP3_Money3();
        moneyArray[3][0] =GetP4_Money3();

        moneyArray[0][1] =GetP1_Moneybank3();
        moneyArray[1][1] =GetP2_Moneybank3();
        moneyArray[2][1] =GetP3_Moneybank3();
        moneyArray[3][1] =GetP4_Moneybank3();

        moneyArray[0][2] = moneyArray[0][0]+moneyArray[0][1];
        moneyArray[1][2] = moneyArray[1][0]+moneyArray[1][1];
        moneyArray[2][2] = moneyArray[2][0]+moneyArray[2][1];
        moneyArray[3][2] = moneyArray[3][0]+moneyArray[3][1];

        cardmoneyArray[0] = GetP1_DQ3();
        cardmoneyArray[1] = GetP2_DQ3();
        cardmoneyArray[2] = GetP3_DQ3();
        cardmoneyArray[3] = GetP4_DQ3();

        dipicount[0] = GetP1_DPCount3();
        dipicount[1] = GetP2_DPCount3();
        dipicount[2] = GetP3_DPCount3();
        dipicount[3] = GetP4_DPCount3();

        chiyoushu[0] =GetP1_GPCount3();
        chiyoushu[1] =GetP2_GPCount3();
        chiyoushu[2] =GetP3_GPCount3();
        chiyoushu[3] =GetP4_GPCount3();

        jiaoyiliang[0] = 2000-chiyoushu[0];
        jiaoyiliang[1] = 2000-chiyoushu[1];
        jiaoyiliang[2] = 2000-chiyoushu[2];
        jiaoyiliang[3] = 2000-chiyoushu[3];

        GetRoadState3();
        year= GetYear3();
        month = GetMonth3();
        day = GetDay3();
        huiheId = 0;
        personId = 0;
        throwUtil = null;
        throwUtil = new ThrowUtil();
    }
    //存储存档
    public static void saveData3()
    {
        WriteLocationP1_x3(locationDArray[0][0]);
        WriteLocationP1_z3(locationDArray[0][2]);
        WriteLocationP1_angle3(locationDArray[0][3]);

        WriteLocationP2_x3(locationDArray[1][0]);
        WriteLocationP2_z3(locationDArray[1][2]);
        WriteLocationP2_angle3(locationDArray[1][3]);

        WriteLocationP3_x3(locationDArray[2][0]);
        WriteLocationP3_z3(locationDArray[2][2]);
        WriteLocationP3_angle3(locationDArray[2][3]);

        WriteLocationP4_x3(locationDArray[3][0]);
        WriteLocationP4_z3(locationDArray[3][2]);
        WriteLocationP4_angle3(locationDArray[3][3]);

        WriteP1_roadId3(roadIdArray[0]);
        WriteP2_roadId3(roadIdArray[1]);
        WriteP3_roadId3(roadIdArray[2]);
        WriteP4_roadId3(roadIdArray[3]);

        WriteP1_CuberoadId3(currentRoadArray[0]);
        WriteP2_CuberoadId3(currentRoadArray[1]);
        WriteP3_CuberoadId3(currentRoadArray[2]);
        WriteP4_CuberoadId3(currentRoadArray[3]);

        WriteP1_Money3(moneyArray[0][0]);
        WriteP2_Money3(moneyArray[1][0]);
        WriteP3_Money3(moneyArray[2][0]);
        WriteP4_Money3(moneyArray[3][0]);

        WriteP1_Moneybank3(moneyArray[0][1]);
        WriteP2_Moneybank3(moneyArray[1][1]);
        WriteP3_Moneybank3(moneyArray[2][1]);
        WriteP4_Moneybank3(moneyArray[3][1]);

        WriteP1_DQ3(cardmoneyArray[0]);
        WriteP2_DQ3(cardmoneyArray[1]);
        WriteP3_DQ3(cardmoneyArray[2]);
        WriteP4_DQ3(cardmoneyArray[3]);

        WriteP1_DPCount3(dipicount[0]);
        WriteP2_DPCount3(dipicount[1]);
        WriteP3_DPCount3(dipicount[2]);
        WriteP4_DPCount3(dipicount[3]);

        WriteP1_GPCount3(chiyoushu[0]);
        WriteP2_GPCount3(chiyoushu[1]);
        WriteP3_GPCount3(chiyoushu[2]);
        WriteP4_GPCount3(chiyoushu[3]);
        WriteRoadState3();
        WriteYear3(year);
        WriteMonth3(month);
        WriteDay3(day);

        WriteCDTimeYear3(year3);
        WriteCDTimeMonth3(month3);
        WriteCDTimecdDay3(day3);
        WriteCDTimeHour3(hour3);
        WriteCDTimeMin3(min3);
    }

    //第四条存档***----------------//
    //------------------------------------------------------------------------------------------------//
    //当前是否含有存档的标志位
    public static int GetCDState4()
    {
        return sp.getInt("cdState4",0);
    }
    public static void WriteCDState4(int cdState)
    {
        editor.putInt("cdState4", cdState);
        editor.commit();
    }
    //日期
    public static int GetYear4()
    {
        return sp.getInt("year4",year);
    }
    public static void WriteYear4(int year)
    {
        editor.putInt("year4",year);
        editor.commit();
    }

    public static int GetMonth4()
    {
        return sp.getInt("month4",month);
    }
    public static void WriteMonth4(int month)
    {
        editor.putInt("month4",month);
        editor.commit();
    }

    public static int GetDay4()
    {
        return sp.getInt("day4",day);
    }
    public static void WriteDay4(int day)
    {
        editor.putInt("day4",day);
        editor.commit();
    }
    //第一个人物坐标 x
    public static float GetLocationP1_x4()
    {
        return sp.getFloat("p1_x4",0);
    }
    public static void WriteLocationP1_x4(float p1_x)
    {
        editor.putFloat("p1_x4", p1_x);
        editor.commit();
    }

    //第一个人物坐标 z
    public static float GetLocationP1_z4()
    {
        return sp.getFloat("p1_z4",0);
    }
    public static void WriteLocationP1_z4(float p1_z)
    {
        editor.putFloat("p1_z4", p1_z);
        editor.commit();
    }

    //第一个人物的角度
    public static float GetLocationP1_angle4()
    {
        return sp.getFloat("p1_angle4",0);
    }
    public static void WriteLocationP1_angle4(float p1_angle)
    {
        editor.putFloat("p1_angle4", p1_angle);
        editor.commit();
    }
    public static int GetP1_roadId4()
    {
        return sp.getInt("p1_roadId4",0);
    }
    public static void WriteP1_roadId4(int p1_roadId)
    {
        editor.putInt("p1_roadId4", p1_roadId);
        editor.commit();
    }
    public static int GetP1_CuberoadId4()
    {
        return sp.getInt("p1_cuberoadId4",0);
    }
    public static void WriteP1_CuberoadId4(int p1_cuberoadId)
    {
        editor.putInt("p1_cuberoadId4", p1_cuberoadId);
        editor.commit();
    }
    public static float GetP1_Money4()
    {
        return sp.getFloat("p1_money4",0);
    }
    public static void WriteP1_Money4(float p1_money)
    {
        editor.putFloat("p1_money4", p1_money);
        editor.commit();
    }
    public static float GetP1_Moneybank4()
    {
        return sp.getFloat("p1_moneybank4",0);
    }
    public static void WriteP1_Moneybank4(float p1_moneybank)
    {
        editor.putFloat("p1_moneybank4", p1_moneybank);
        editor.commit();
    }
    public static int GetP1_DQ4()
    {
        return sp.getInt("p1_dq4",0);
    }
    public static void WriteP1_DQ4(int p1_dq)
    {
        editor.putInt("p1_dq4", p1_dq);
        editor.commit();
    }
    public static int GetP1_DPCount4()
    {
        return sp.getInt("p1_dpcount4",0);
    }
    public static void WriteP1_DPCount4(int p1_dpcount)
    {
        editor.putInt("p1_dpcount4", p1_dpcount);
        editor.commit();
    }
    public static int GetP1_GPCount4()
    {
        return sp.getInt("p1_gpcount4",0);
    }
    public static void WriteP1_GPCount4(int p1_gpcount)
    {
        editor.putInt("p1_gpcount4", p1_gpcount);
        editor.commit();
    }
    //--------------------------------------------------------------------------------------------//
    //第2个人物坐标 x
    public static float GetLocationP2_x4()
    {
        return sp.getFloat("p2_x4",0);
    }
    public static void WriteLocationP2_x4(float p2_x)
    {
        editor.putFloat("p2_x4", p2_x);
        editor.commit();
    }

    //第2个人物坐标 z
    public static float GetLocationP2_z4()
    {
        return sp.getFloat("p2_z4",0);
    }
    public static void WriteLocationP2_z4(float p2_z)
    {
        editor.putFloat("p2_z4", p2_z);
        editor.commit();
    }

    //第2个人物的角度
    public static float GetLocationP2_angle4()
    {
        return sp.getFloat("p2_angle4",0);
    }
    public static void WriteLocationP2_angle4(float p2_angle)
    {
        editor.putFloat("p2_angle4", p2_angle);
        editor.commit();
    }
    public static int GetP2_roadId4()
    {
        return sp.getInt("p2_roadId4",0);
    }
    public static void WriteP2_roadId4(int p2_roadId)
    {
        editor.putInt("p2_roadId4", p2_roadId);
        editor.commit();
    }

    public static int GetP2_CuberoadId4()
    {
        return sp.getInt("p2_cuberoadId4",0);
    }
    public static void WriteP2_CuberoadId4(int p2_cuberoadId)
    {
        editor.putInt("p2_cuberoadId4", p2_cuberoadId);
        editor.commit();
    }

    public static float GetP2_Money4()
    {
        return sp.getFloat("p2_money4",0);
    }
    public static void WriteP2_Money4(float p2_money)
    {
        editor.putFloat("p2_money4", p2_money);
        editor.commit();
    }
    public static float GetP2_Moneybank4()
    {
        return sp.getFloat("p2_moneybank4",0);
    }
    public static void WriteP2_Moneybank4(float p2_moneybank)
    {
        editor.putFloat("p2_moneybank4", p2_moneybank);
        editor.commit();
    }
    public static int GetP2_DQ4()
    {
        return sp.getInt("p2_dq4",0);
    }
    public static void WriteP2_DQ4(int p2_dq)
    {
        editor.putInt("p2_dq4", p2_dq);
        editor.commit();
    }
    public static int GetP2_DPCount4()
    {
        return sp.getInt("p2_dpcount4",0);
    }
    public static void WriteP2_DPCount4(int p2_dpcount)
    {
        editor.putInt("p2_dpcount4", p2_dpcount);
        editor.commit();
    }
    public static int GetP2_GPCount4()
    {
        return sp.getInt("p2_gpcount4",0);
    }
    public static void WriteP2_GPCount4(int p2_gpcount)
    {
        editor.putInt("p2_gpcount4", p2_gpcount);
        editor.commit();
    }
    //--------------------------------------------------------------------------------------------//
    //第3个人物坐标 x
    public static float GetLocationP3_x4()
    {
        return sp.getFloat("p3_x4",0);
    }
    public static void WriteLocationP3_x4(float p3_x)
    {
        editor.putFloat("p3_x4", p3_x);
        editor.commit();
    }

    //第3个人物坐标 z
    public static float GetLocationP3_z4()
    {
        return sp.getFloat("p3_z4",0);
    }
    public static void WriteLocationP3_z4(float p3_z)
    {
        editor.putFloat("p3_z4", p3_z);
        editor.commit();
    }

    //第3个人物的角度
    public static float GetLocationP3_angle4()
    {
        return sp.getFloat("p3_angle4",0);
    }
    public static void WriteLocationP3_angle4(float p3_angle)
    {
        editor.putFloat("p3_angle4", p3_angle);
        editor.commit();
    }
    public static int GetP3_roadId4()
    {
        return sp.getInt("p3_roadId4",0);
    }
    public static void WriteP3_roadId4(int p3_roadId)
    {
        editor.putInt("p3_roadId4", p3_roadId);
        editor.commit();
    }
    public static int GetP3_CuberoadId4()
    {
        return sp.getInt("p3_cuberoadId4",0);
    }
    public static void WriteP3_CuberoadId4(int p3_cuberoadId)
    {
        editor.putInt("p3_cuberoadId4", p3_cuberoadId);
        editor.commit();
    }
    public static float GetP3_Money4()
    {
        return sp.getFloat("p3_money4",0);
    }
    public static void WriteP3_Money4(float p3_money)
    {
        editor.putFloat("p3_money4", p3_money);
        editor.commit();
    }
    public static float GetP3_Moneybank4()
    {
        return sp.getFloat("p3_moneybank4",0);
    }
    public static void WriteP3_Moneybank4(float p3_moneybank)
    {
        editor.putFloat("p3_moneybank4", p3_moneybank);
        editor.commit();
    }
    public static int GetP3_DQ4()
    {
        return sp.getInt("p3_dq4",0);
    }
    public static void WriteP3_DQ4(int p3_dq)
    {
        editor.putInt("p3_dq4", p3_dq);
        editor.commit();
    }
    public static int GetP3_DPCount4()
    {
        return sp.getInt("p3_dpcount4",0);
    }
    public static void WriteP3_DPCount4(int p3_dpcount)
    {
        editor.putInt("p3_dpcount4", p3_dpcount);
        editor.commit();
    }
    public static int GetP3_GPCount4()
    {
        return sp.getInt("p3_gpcount4",0);
    }
    public static void WriteP3_GPCount4(int p3_gpcount)
    {
        editor.putInt("p3_gpcount4", p3_gpcount);
        editor.commit();
    }
    //------------------------------------------------------------------------------------------------//
//第4个人物坐标 x
    public static float GetLocationP4_x4()
    {
        return sp.getFloat("p4_x4",0);
    }
    public static void WriteLocationP4_x4(float p4_x)
    {
        editor.putFloat("p4_x4", p4_x);
        editor.commit();
    }

    //第4个人物坐标 z
    public static float GetLocationP4_z4()
    {
        return sp.getFloat("p4_z4",0);
    }
    public static void WriteLocationP4_z4(float p4_z)
    {
        editor.putFloat("p4_z4", p4_z);
        editor.commit();
    }

    //第4个人物的角度
    public static float GetLocationP4_angle4()
    {
        return sp.getFloat("p4_angle4",0);
    }
    public static void WriteLocationP4_angle4(float p4_angle)
    {
        editor.putFloat("p4_angle4", p4_angle);
        editor.commit();
    }
    public static int GetP4_roadId4()
    {
        return sp.getInt("p4_roadId4",0);
    }
    public static void WriteP4_roadId4(int p4_roadId)
    {
        editor.putInt("p4_roadId4", p4_roadId);
        editor.commit();
    }
    public static int GetP4_CuberoadId4()
    {
        return sp.getInt("p4_cuberoadId4",0);
    }
    public static void WriteP4_CuberoadId4(int p4_cuberoadId)
    {
        editor.putInt("p4_cuberoadId4", p4_cuberoadId);
        editor.commit();
    }
    public static float GetP4_Money4()
    {
        return sp.getFloat("p4_money4",0);
    }
    public static void WriteP4_Money4(float p4_money)
    {
        editor.putFloat("p4_money4", p4_money);
        editor.commit();
    }
    public static float GetP4_Moneybank4()
    {
        return sp.getFloat("p4_moneybank4",0);
    }
    public static void WriteP4_Moneybank4(float p4_moneybank)
    {
        editor.putFloat("p4_moneybank4", p4_moneybank);
        editor.commit();
    }
    public static int GetP4_DQ4()
    {
        return sp.getInt("p4_dq4",0);
    }
    public static void WriteP4_DQ4(int p4_dq)
    {
        editor.putInt("p4_dq4", p4_dq);
        editor.commit();
    }
    public static int GetP4_DPCount4()
    {
        return sp.getInt("p4_dpcount4",0);
    }
    public static void WriteP4_DPCount4(int p4_dpcount)
    {
        editor.putInt("p4_dpcount4", p4_dpcount);
        editor.commit();
    }
    public static int GetP4_GPCount4()
    {
        return sp.getInt("p4_gpcount4",0);
    }
    public static void WriteP4_GPCount4(int p4_gpcount)
    {
        editor.putInt("p4_gpcount4", p4_gpcount);
        editor.commit();
    }
//------------------------------------------------------------------------------------------------//

    public static void  WriteRoadState4()
    {
        for (int i=0;i<cubeRoadArray.length;i++)
        {
            if((i>=7&&i<=15)||(i>=19&&i<=25)||(i>=38&&i<=46)||(i>=63&&i<=67)||(i>=69&&i<=84)||(i>=87&&i<=92))
            {
                //已经购买土地
                editor.putInt("cubeRoadArray4"+i,cubeRoadArray[i].getRoadState());
                editor.commit();
            }
        }
    }

    public static void  GetRoadState4()
    {
        for (int i=0;i<cubeRoadArray.length;i++)
        {
            //地皮
            if((i>=7&&i<=15)||(i>=19&&i<=25)||(i>=38&&i<=46)||(i>=63&&i<=67)||(i>=69&&i<=84)||(i>=87&&i<=92))
            {
                cubeRoadArray[i].RoadState = sp.getInt("cubeRoadArray4"+i,0);
                //正在出售
                if(cubeRoadArray[i].RoadState==0)
                {
                    cubeRoadArray[i] = new CubeRoad(i,0,lovoOnSale,onsaleId,dipiarray[i]);
                }
                //P1
                else if(cubeRoadArray[i].RoadState==1)
                {
                    cubeRoadArray[i] = new CubeRoad(i,1,lovoBZMing,BZ_hongId,BZdata_P1[i]);
                }
                else if(cubeRoadArray[i].RoadState==2)
                {
                    cubeRoadArray[i] = new CubeRoad(i,2,lovoHouse1,houseId,houselevel1[i]);
                }
                else if(cubeRoadArray[i].RoadState==3)
                {
                    cubeRoadArray[i] = new CubeRoad(i,3,lovoHouse2, houseId, houselevel2[i]);
                }
                else if(cubeRoadArray[i].RoadState==4)
                {
                    cubeRoadArray[i] = new CubeRoad(i,4,lovoHouse3, houseId, houselevel3[i]);
                }
                //P2
                else if(cubeRoadArray[i].RoadState==5)
                {
                    cubeRoadArray[i] = new CubeRoad(i,5,lovoBZMing,BZ_lanId,BZdata_P2[i]);
                }
                else if(cubeRoadArray[i].RoadState==6)
                {
                    cubeRoadArray[i] = new CubeRoad(i,6,lovoHouse1,houseId,houselevel1[i]);
                }
                else if(cubeRoadArray[i].RoadState==7)
                {
                    cubeRoadArray[i] = new CubeRoad(i,7,lovoHouse2, houseId, houselevel2[i]);
                }
                else if(cubeRoadArray[i].RoadState==8)
                {
                    cubeRoadArray[i] = new CubeRoad(i,8,lovoHouse3, houseId, houselevel3[i]);
                }
                //P3
                else if(cubeRoadArray[i].RoadState==9)
                {
                    cubeRoadArray[i] = new CubeRoad(i,6,lovoBZMing,BZ_zongId,BZdata_P3[i]);
                }
                else if(cubeRoadArray[i].RoadState==10)
                {
                    cubeRoadArray[i] = new CubeRoad(i,10,lovoHouse2, houseId, houselevel2[i]);
                }
                else if(cubeRoadArray[i].RoadState==11)
                {
                    cubeRoadArray[i] = new CubeRoad(i,11,lovoBZMing,BZ_lanId,BZdata_P2[i]);
                }
                else if(cubeRoadArray[i].RoadState==12)
                {
                    cubeRoadArray[i] = new CubeRoad(i,12,lovoHouse3, houseId, houselevel3[i]);
                }
                //P4
                else if(cubeRoadArray[i].RoadState==13)
                {
                    cubeRoadArray[i] = new CubeRoad(i,13,lovoBZMing,BZ_heId,BZdata_P4[i]);
                }
                else if(cubeRoadArray[i].RoadState==14)
                {
                    cubeRoadArray[i] = new CubeRoad(i,14,lovoHouse1,houseId,houselevel1[i]);
                }
                else if(cubeRoadArray[i].RoadState==15)
                {
                    cubeRoadArray[i] = new CubeRoad(i,15,lovoHouse2, houseId, houselevel2[i]);
                }
                else if(cubeRoadArray[i].RoadState==16)
                {
                    cubeRoadArray[i] = new CubeRoad(i,16,lovoHouse3, houseId, houselevel3[i]);
                }
            }
            else
            {
                cubeRoadArray[i] = null;
            }
        }
        cubeRoadArray[2] = new CubeRoad(2,22,lovoMapCube,road20Id,road20data[0]);
        cubeRoadArray[4] = new CubeRoad(4,22,lovoMapCube,road20Id,road20data[1]);
        cubeRoadArray[32] = new CubeRoad(32,22,lovoMapCube,road20Id,road20data[2]);
        cubeRoadArray[34] = new CubeRoad(34,22,lovoMapCube,road20Id,road20data[3]);
        cubeRoadArray[36] = new CubeRoad(36,22,lovoMapCube,road20Id,road20data[4]);
        cubeRoadArray[48] = new CubeRoad(48,22,lovoMapCube,road20Id,road20data[5]);
        cubeRoadArray[50] = new CubeRoad(50,22,lovoMapCube,road20Id,road20data[6]);
        cubeRoadArray[58] = new CubeRoad(58,22,lovoMapCube,road20Id,road20data[7]);
        cubeRoadArray[60] = new CubeRoad(60,22,lovoMapCube,road20Id,road20data[8]);
        cubeRoadArray[95] = new CubeRoad(95,22,lovoMapCube,road20Id,road20data[9]);
        cubeRoadArray[97] = new CubeRoad(97,22,lovoMapCube,road20Id,road20data[10]);
        cubeRoadArray[99] = new CubeRoad(99,22,lovoMapCube,road20Id,road20data[11]);
        cubeRoadArray[47] = new CubeRoad(47,23,lovoMapCube,road20Id,road50data[2]);
        //点券 50  1   5  47 52 57 62 94 100
        cubeRoadArray[1] = new CubeRoad(1,23,lovoMapCube,road50Id,road50data[0]);
        cubeRoadArray[5] = new CubeRoad(5,23,lovoMapCube,road50Id,road50data[1]);
        cubeRoadArray[52] = new CubeRoad(52,23,lovoMapCube,road50Id,road50data[3]);
        cubeRoadArray[57] = new CubeRoad(57,23,lovoMapCube,road50Id,road50data[4]);
        cubeRoadArray[62] = new CubeRoad(62,23,lovoMapCube,road50Id,road50data[5]);
        cubeRoadArray[94] = new CubeRoad(94,23,lovoMapCube,road50Id,road50data[6]);
        //彩票站
        cubeRoadArray[100] = new CubeRoad(100,32,lovoMapCube,cpstationId,road50data[7]);
        // bank  hospital shop bank shop
        cubeRoadArray[16] = new CubeRoad(16,17,lovoMapCube,bankCubeId,bsydata[1]);
        cubeRoadArray[18] = new CubeRoad(18,24,lovoMapCube,hospitalCubeId,bsydata[0]);
        cubeRoadArray[30] = new CubeRoad(30,18,lovoMapCube,shopCubeId,bsydata[2]);
        cubeRoadArray[56] = new CubeRoad(56,17,lovoMapCube,bankCubeId,bsydata[3]);
        cubeRoadArray[101] = new CubeRoad(101,18,lovoMapCube,shopCubeId,bsydata[4]);
        //神仙的方块
        //  6  17 26 31  37  53  68 85 93
        cubeRoadArray[6] = new CubeRoad(6,25,lovoMapCube,caishenId,shenxiandata[0]);    //财神
        cubeRoadArray[17] = new CubeRoad(17,26,lovoMapCube,fushenId,shenxiandata[1]);   //福神
        cubeRoadArray[26] = new CubeRoad(26,27,lovoMapCube,tianshiId,shenxiandata[2]);  //天使
        cubeRoadArray[31] = new CubeRoad(31,28,lovoMapCube,shuaishenId,shenxiandata[3]);//衰神
        cubeRoadArray[37] = new CubeRoad(37,29,lovoMapCube,caishenId,shenxiandata[4]);//财神
        cubeRoadArray[53] = new CubeRoad(53,25,lovoMapCube,caishenId,shenxiandata[5]);     //财神
        cubeRoadArray[68] = new CubeRoad(68,27,lovoMapCube,tianshiId,shenxiandata[6]);     //天使
        cubeRoadArray[85] = new CubeRoad(85,30,lovoMapCube,emoId,shenxiandata[7]);      //恶魔
        cubeRoadArray[93] = new CubeRoad(93,28,lovoMapCube,shuaishenId,shenxiandata[8]);  //衰神
        //28  29  加油站
        cubeRoadArray[28] = new CubeRoad(28,20,lovoMapCube,jiantouZId,jiantoudata[0]);
        cubeRoadArray[29] = new CubeRoad(29,20,lovoJianTouW,jiantouWId,jiantoudata[1]);
        //54  55 商店
        cubeRoadArray[54] = new CubeRoad(54,19,lovoMapCube,jiantouZId,jiantoudata[2]);
        cubeRoadArray[55] = new CubeRoad(55,19,lovoJianTouW,jiantouWId,jiantoudata[3]);
        ///motel 102 103
        cubeRoadArray[102] = new CubeRoad(102,21,lovoMapCube,jiantouZId,jiantoudata[4]);
        cubeRoadArray[103] = new CubeRoad(103,21,lovoJianTouW,jiantouWId,jiantoudata[5]);
        cubeRoadArrayList.clear();
        //初始化所有公路块数据
        for (int i=0;i<cubeRoadArray.length;i++)
        {
            cubeRoadArrayList.add(cubeRoadArray[i]);
        }
    }
    //读取存档
    public static void readData4()
    {
        locationDArray[0][0] = GetLocationP1_x4();
        locationDArray[0][2] = GetLocationP1_z4();
        locationDArray[0][3] = GetLocationP1_angle4();

        locationDArray[1][0] = GetLocationP2_x4();
        locationDArray[1][2] = GetLocationP2_z4();
        locationDArray[1][3] = GetLocationP2_angle4();

        locationDArray[2][0] = GetLocationP3_x4();
        locationDArray[2][2] = GetLocationP3_z4();
        locationDArray[2][3] = GetLocationP3_angle4();

        locationDArray[3][0] = GetLocationP4_x4();
        locationDArray[3][2] = GetLocationP4_z4();
        locationDArray[3][3] = GetLocationP4_angle4();

        locationJArray[0][0] = locationDArray[0][0];
        locationJArray[0][2] = locationDArray[0][2];
        locationJArray[0][3] = locationDArray[0][3];
        locationJArray[1][0] = locationDArray[1][0];
        locationJArray[1][2] = locationDArray[1][2];
        locationJArray[1][3] = locationDArray[1][3];
        locationJArray[2][0] = locationDArray[2][0];
        locationJArray[2][2] = locationDArray[2][2];
        locationJArray[2][3] = locationDArray[2][3];
        locationJArray[3][0] = locationDArray[3][0];
        locationJArray[3][2] = locationDArray[3][2];
        locationJArray[3][3] = locationDArray[3][3];

        roadIdArray[0] = GetP1_roadId4();
        roadIdArray[1] = GetP2_roadId4();
        roadIdArray[2] = GetP3_roadId4();
        roadIdArray[3] = GetP4_roadId4();

        currentRoadArray[0]  =GetP1_CuberoadId4();
        currentRoadArray[1]  =GetP2_CuberoadId4();
        currentRoadArray[2]  =GetP3_CuberoadId4();
        currentRoadArray[3]  =GetP4_CuberoadId4();

        moneyArray[0][0] =GetP1_Money4();
        moneyArray[1][0] =GetP2_Money4();
        moneyArray[2][0] =GetP3_Money4();
        moneyArray[3][0] =GetP4_Money4();

        moneyArray[0][1] =GetP1_Moneybank4();
        moneyArray[1][1] =GetP2_Moneybank4();
        moneyArray[2][1] =GetP3_Moneybank4();
        moneyArray[3][1] =GetP4_Moneybank4();

        moneyArray[0][2] = moneyArray[0][0]+moneyArray[0][1];
        moneyArray[1][2] = moneyArray[1][0]+moneyArray[1][1];
        moneyArray[2][2] = moneyArray[2][0]+moneyArray[2][1];
        moneyArray[3][2] = moneyArray[3][0]+moneyArray[3][1];

        cardmoneyArray[0] = GetP1_DQ4();
        cardmoneyArray[1] = GetP2_DQ4();
        cardmoneyArray[2] = GetP3_DQ4();
        cardmoneyArray[3] = GetP4_DQ4();

        dipicount[0] = GetP1_DPCount4();
        dipicount[1] = GetP2_DPCount4();
        dipicount[2] = GetP3_DPCount4();
        dipicount[3] = GetP4_DPCount4();

        chiyoushu[0] =GetP1_GPCount4();
        chiyoushu[1] =GetP2_GPCount4();
        chiyoushu[2] =GetP3_GPCount4();
        chiyoushu[3] =GetP4_GPCount4();

        jiaoyiliang[0] = 2000-chiyoushu[0];
        jiaoyiliang[1] = 2000-chiyoushu[1];
        jiaoyiliang[2] = 2000-chiyoushu[2];
        jiaoyiliang[3] = 2000-chiyoushu[3];

        GetRoadState4();
        year = GetYear4();
        month = GetMonth4();
        day = GetDay4();
        huiheId = 0;
        personId = 0;
        throwUtil = null;
        throwUtil = new ThrowUtil();
    }
    //存储存档
    public static void saveData4()
    {
        WriteLocationP1_x4(locationDArray[0][0]);
        WriteLocationP1_z4(locationDArray[0][2]);
        WriteLocationP1_angle4(locationDArray[0][3]);

        WriteLocationP2_x4(locationDArray[1][0]);
        WriteLocationP2_z4(locationDArray[1][2]);
        WriteLocationP2_angle4(locationDArray[1][3]);

        WriteLocationP3_x4(locationDArray[2][0]);
        WriteLocationP3_z4(locationDArray[2][2]);
        WriteLocationP3_angle4(locationDArray[2][3]);

        WriteLocationP4_x4(locationDArray[3][0]);
        WriteLocationP4_z4(locationDArray[3][2]);
        WriteLocationP4_angle4(locationDArray[3][3]);

        WriteP1_roadId4(roadIdArray[0]);
        WriteP2_roadId4(roadIdArray[1]);
        WriteP3_roadId4(roadIdArray[2]);
        WriteP4_roadId4(roadIdArray[3]);

        WriteP1_CuberoadId4(currentRoadArray[0]);
        WriteP2_CuberoadId4(currentRoadArray[1]);
        WriteP3_CuberoadId4(currentRoadArray[2]);
        WriteP4_CuberoadId4(currentRoadArray[3]);

        WriteP1_Money4(moneyArray[0][0]);
        WriteP2_Money4(moneyArray[1][0]);
        WriteP3_Money4(moneyArray[2][0]);
        WriteP4_Money4(moneyArray[3][0]);

        WriteP1_Moneybank4(moneyArray[0][1]);
        WriteP2_Moneybank4(moneyArray[1][1]);
        WriteP3_Moneybank4(moneyArray[2][1]);
        WriteP4_Moneybank4(moneyArray[3][1]);

        WriteP1_DQ4(cardmoneyArray[0]);
        WriteP2_DQ4(cardmoneyArray[1]);
        WriteP3_DQ4(cardmoneyArray[2]);
        WriteP4_DQ4(cardmoneyArray[3]);

        WriteP1_DPCount4(dipicount[0]);
        WriteP2_DPCount4(dipicount[1]);
        WriteP3_DPCount4(dipicount[2]);
        WriteP4_DPCount4(dipicount[3]);

        WriteP1_GPCount4(chiyoushu[0]);
        WriteP2_GPCount4(chiyoushu[1]);
        WriteP3_GPCount4(chiyoushu[2]);
        WriteP4_GPCount4(chiyoushu[3]);
        WriteRoadState4();
        WriteYear4(year);
        WriteMonth4(month);
        WriteDay4(day);

        WriteCDTimeYear4(year4);
        WriteCDTimeMonth4(month4);
        WriteCDTimecdDay4(day4);
        WriteCDTimeHour4(hour4);
        WriteCDTimeMin4(min4);
    }
}

