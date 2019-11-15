package com.bn.View;

import android.opengl.GLES30;
import android.opengl.Matrix;

import com.bn.RichMan.MainActivity;
import com.bn.RichMan.MyGLSurFaceView;
import com.bn.Scenes.Draw;
import com.bn.Scenes.TextureRectangle2D;
import com.bn.Util.MatrixState2D;

import java.util.ArrayList;
import static com.bn.Constant.Constant.*;
import static com.bn.Constant.Constant.day;
import static com.bn.Constant.Constant.day_x;
import static com.bn.Constant.Constant.day_y;
import static com.bn.Constant.Constant.dipinumber;
import static com.bn.Constant.Constant.infoRoadn_x;
import static com.bn.Constant.Constant.infoRoadn_y;
import static com.bn.Constant.Constant.infocMoney_x;
import static com.bn.Constant.Constant.infocMoney_y;
import static com.bn.Constant.Constant.infodianquan_x;
import static com.bn.Constant.Constant.infodianquan_y;
import static com.bn.Constant.Constant.infoxMoney_x;
import static com.bn.Constant.Constant.infoxMoney_y;
import static com.bn.Constant.Constant.month;
import static com.bn.Constant.Constant.month_x;
import static com.bn.Constant.Constant.month_y;

import static com.bn.Constant.Constant.wanjia_x;
import static com.bn.Constant.Constant.wanjia_y;
import static com.bn.Constant.Constant.year;
import static com.bn.Constant.Constant.year_x;
import static com.bn.Constant.Constant.year_y;
import static com.bn.Constant.IdDataConstant.*;
import static com.bn.Constant.IdDataConstant.cardbagId;
import static com.bn.Constant.IdDataConstant.infoAllId;

import static com.bn.Constant.LovoConstant.*;
import static com.bn.Constant.LovoConstant.tr2dInfo;

import static com.bn.Constant.LovoConstant.trcardbag;
import static com.bn.Util.SoundManager.ismusic;

public class MenuButton {
    MyGLSurFaceView mv;
    MainActivity ma;
    public static final int INITIALVIEW = 1;//初始界面
    public static  final int SETVIEW = 2;//设置界面
    public static  final int HELPVIEW = 3;//帮助界面
    public static final int ABOUTVIEW = 4;//关于界面
    public static final int GAMEVIEW  = 5;//游戏界面
    public static final int SYSTEMVIEW =6;//系统界面
    public static final int SPECIALVIEW = 7;//特殊人物界面
    public static final int OTHERVIEW = 8;//其它界面
    public static  final int GAMEMENUVIEW=9;//开始菜单界面
    public static int currentView=1;//主view
    public static int currview;//辅view


    public ArrayList<TextureRectangle2D> init=new ArrayList<TextureRectangle2D>();
    public MenuButton(MyGLSurFaceView mv)
    {
        this.mv=mv;
        gameView=new GameView(ma,mv);
        startView=new StartView (ma,mv);
    }
    public void drawSelf()
    {
        GLES30.glEnable(GLES30.GL_BLEND);			//开启混合
        GLES30.glBlendFunc(GLES30.GL_SRC_ALPHA,	//设置混合因子
                GLES30.GL_ONE_MINUS_SRC_ALPHA);
        GLES30.glDisable(GLES30.GL_DEPTH_TEST);
        if (currentView == INITIALVIEW || currview == INITIALVIEW)
        {
            Draw.drawself2D(richman,bgId,screenWidth/2,screenHeight/2,screenWidth,screenHeight,1);//背景图
            Draw.drawself2D(richman,logoId,screenWidth/2,screenHeight/3,screenWidth/3,screenHeight/2,1);
//            Draw.drawself2D(richman,setId,set_x,set_y,buttonchangdu,buttonkuandu,1);//设置按钮
//            Draw.drawself2D(richman,helpId,help_x,help_y,buttonchangdu,buttonkuandu,1);//帮助按钮
            Draw.drawself2D(richman,playId,play_x,play_y,playchangdu,playkuandu,1);//开始游戏按钮
            if(ismusic==true)
            {
                Draw.drawself2D(tr2Dmusic[0],musicOnId,yinyue_x,yinyue_y,buttonchangdu,buttonkuandu,1);//音乐按钮
            }else
            {
                Draw.drawself2D(tr2Dmusic[1],musicOffId,yinyue_x,yinyue_y,buttonchangdu,buttonkuandu,1);
            }
//            Draw.drawself2D(richman,shop1Id,shop1_x,shop1_y,buttonchangdu,buttonkuandu,1);//音乐按钮
        }
        else if (currentView == SETVIEW || currview == SETVIEW)
        {

        }else if (currview == HELPVIEW || currentView == HELPVIEW)
        {


        }else if(currentView == GAMEMENUVIEW||currview == GAMEMENUVIEW) {

            Draw.drawself2D(richman, svbgId, screenWidth / 2, screenHeight / 2, screenWidth, screenHeight, 1);//开始界面菜单
            Draw.drawself2D(richman, backId, back_x, back_y, backchangdu, backkuandu, 1);
            Draw.drawself2D(richman, renwuId, renwu_x, renwu_y, renwuchangdu, renwukuandu, 1);
            Draw.drawself2D(richman, startId, start_x, start_y, startchangdu, startkuandu, 1);
            Draw.drawself2D(richman, continueId, continue_x, continue_y, startchangdu / 2, startkuandu / 2, 1);
            Draw.drawself2D(richman, readId, read_x, read_y, startchangdu / 2, startkuandu / 2, 1);
            Draw.drawself2D(richman, selectleftId, selectleft_x, selectleft_y, cardchangdu, cardkuandu, 1);
            Draw.drawself2D(richman, selectrightId, selectright_x, selectright_y, cardchangdu, cardkuandu, 1);
            Draw.drawself2D(noContinue, noContinueId, screenWidth / 2, screenHeight / 2, 2*screenWidth/3, 2*screenHeight/3, 1);
            Draw.drawself2D(cundangView, cundangViewId, screenWidth / 2, screenHeight / 2, screenWidth, screenHeight, 1);//读取存档界面

            if (cundangState == 1 && cundangView.drawState == true) {
                money.drawSelfPrice(year1 + "", numberId, cundangyear1_x, cundangyear1_y);

                Draw.drawself2D(richman, datexId, cundangdate11_x, cundangdate11_y, moneychangdu * 0.4f, moneykuandu * 0.5f, 1);
                if (month1 < 10) {
                    money.drawSelfPrice("0" + month1 + "", numberId, cundangmonth1_x, cundangmonth1_y);
                } else {
                    money.drawSelfPrice(month1 + "", numberId, cundangmonth1_x, cundangmonth1_y);
                }


                Draw.drawself2D(richman, datexId, cundangdate21_x, cundangdate21_y, moneychangdu * 0.4f, moneykuandu * 0.5f, 1);
                if (day1 < 10) {
                    money.drawSelfPrice("0" + day1 + "", numberId, cundangday1_x, cundangday1_y);
                } else {
                    money.drawSelfPrice(day1 + "", numberId, cundangday1_x, cundangday1_y);
                }

                if (hour1 < 10) {
                    money.drawSelfPrice("0" + hour1 + "", numberId, cundanghour1_x, cundanghour1_y);
                } else {
                    money.drawSelfPrice(hour1 + "", numberId, cundanghour1_x, cundanghour1_y);
                }


                Draw.drawself2D(richman, maohaoId, cundangdate31_x, cundangdate31_y, moneychangdu * 0.4f, moneykuandu * 0.5f, 1);
                if (min1 < 10) {
                    money.drawSelfPrice("0" + min1 + "", numberId, cundangmin1_x, cundangmin1_y);
                } else {
                    money.drawSelfPrice(min1 + "", numberId, cundangmin1_x, cundangmin1_y);
                }

            }
            //第2条存档
            if (cundangState2 == 1 && cundangView.drawState) {
                money.drawSelfPrice(year2 + "", numberId, cundangyear1_x, cundang2_y);

                Draw.drawself2D(richman, datexId, cundangdate11_x, cundang2_y, moneychangdu * 0.4f, moneykuandu * 0.5f, 1);
                if (month2 < 10) {
                    money.drawSelfPrice("0" + month2 + "", numberId, cundangmonth1_x, cundang2_y);
                } else {
                    money.drawSelfPrice(month2 + "", numberId, cundangmonth1_x, cundang2_y);
                }
                Draw.drawself2D(richman, datexId, cundangdate21_x, cundang2_y, moneychangdu * 0.4f, moneykuandu * 0.5f, 1);
                if (day2 < 10) {
                    money.drawSelfPrice("0" + day2 + "", numberId, cundangday1_x, cundang2_y);
                } else {
                    money.drawSelfPrice(day2 + "", numberId, cundangday1_x, cundang2_y);
                }
                if (hour2 < 10) {
                    money.drawSelfPrice("0" + hour2 + "", numberId, cundanghour1_x, cundang2_y);
                } else {
                    money.drawSelfPrice(hour2 + "", numberId, cundanghour1_x, cundang2_y);
                }
                Draw.drawself2D(richman, maohaoId, cundangdate31_x, cundang2_y, moneychangdu * 0.4f, moneykuandu * 0.5f, 1);
                if (min2 < 10) {
                    money.drawSelfPrice("0" + min2 + "", numberId, cundangmin1_x, cundang2_y);
                } else {
                    money.drawSelfPrice(min2 + "", numberId, cundangmin1_x, cundang2_y);
                }

            }
            //第3条存档
            if (cundangState3 == 1 && cundangView.drawState) {
                money.drawSelfPrice(year3 + "", numberId, cundangyear1_x, cundang3_y);
                Draw.drawself2D(richman, datexId, cundangdate11_x, cundang3_y, moneychangdu * 0.4f, moneykuandu * 0.5f, 1);
                if (month3 < 10) {
                    money.drawSelfPrice("0" + month3 + "", numberId, cundangmonth1_x, cundang3_y);
                } else {
                    money.drawSelfPrice(month3 + "", numberId, cundangmonth1_x, cundang3_y);
                }
                Draw.drawself2D(richman, datexId, cundangdate21_x, cundang3_y, moneychangdu * 0.4f, moneykuandu * 0.5f, 1);
                if (day3 < 10) {
                    money.drawSelfPrice("0" + day3 + "", numberId, cundangday1_x, cundang3_y);
                } else {
                    money.drawSelfPrice(day3 + "", numberId, cundangday1_x, cundang3_y);
                }
                if (hour3 < 10) {
                    money.drawSelfPrice("0" + hour3 + "", numberId, cundanghour1_x, cundang3_y);
                } else {
                    money.drawSelfPrice(hour3 + "", numberId, cundanghour1_x, cundang3_y);
                }
                Draw.drawself2D(richman, maohaoId, cundangdate31_x, cundang3_y, moneychangdu * 0.4f, moneykuandu * 0.5f, 1);
                if (min3 < 10) {
                    money.drawSelfPrice("0" + min3 + "", numberId, cundangmin1_x, cundang3_y);
                } else {
                    money.drawSelfPrice(min3 + "", numberId, cundangmin1_x, cundang3_y);
                }

            }
            //第4条存档
            if (cundangState4 == 1 && cundangView.drawState) {
                money.drawSelfPrice(year4 + "", numberId, cundangyear1_x, cundang4_y);

                Draw.drawself2D(richman, datexId, cundangdate11_x, cundang4_y, moneychangdu * 0.4f, moneykuandu * 0.5f, 1);

                if (month4 < 10) {
                    money.drawSelfPrice("0" + month4 + "", numberId, cundangmonth1_x, cundang4_y);
                } else {
                    money.drawSelfPrice(month4 + "", numberId, cundangmonth1_x, cundang4_y);
                }
                Draw.drawself2D(richman, datexId, cundangdate21_x, cundang4_y, moneychangdu * 0.4f, moneykuandu * 0.5f, 1);
                if (day4 < 10) {
                    money.drawSelfPrice("0" + day4 + "", numberId, cundangday1_x, cundang4_y);
                } else {
                    money.drawSelfPrice(day4 + "", numberId, cundangday1_x, cundang4_y);
                }
                if (hour4 < 10) {
                    money.drawSelfPrice("0" + hour4 + "", numberId, cundanghour1_x, cundang4_y);
                } else {
                    money.drawSelfPrice(hour4 + "", numberId, cundanghour1_x, cundang4_y);
                }
                Draw.drawself2D(richman, maohaoId, cundangdate31_x, cundang4_y, moneychangdu * 0.4f, moneykuandu * 0.5f, 1);
                if (min4 < 10) {
                    money.drawSelfPrice("0" + min4 + "", numberId, cundangmin1_x, cundang4_y);
                } else {
                    money.drawSelfPrice(min4 + "", numberId, cundangmin1_x, cundang4_y);
                }
            }
        }
        //游戏界面
        else if (currentView == GAMEVIEW || currview == GAMEVIEW)
        {

            Draw.drawself2D(richman,touXiangId,datebg_x,datebg_y,datechangdu,datekuandu,1);//头像日期背景
            Draw.drawself2D(richman,wanjiaId,wanjia0_x,wanjia0_y,xingqichang,xingqikuan,1);
            Draw.drawself2D(richman,shaderId,shader1_x,shader1_y,shaderchangdu,shaderkuandu,1);
            Draw.drawself2D(richman,coinId,coin_x,coin_y,coinchangdu,coinkuandu,1);//现金
            Draw.drawself2D(richman,shaderId,shader2_x,shader2_y,shaderchangdu,shaderkuandu,1);
            Draw.drawself2D(richman,bankCardId,bankcard_x,bankcard_y,coinchangdu,coinkuandu,1);//存款
            Draw.drawself2D(richman,shaderId,shader3_x,shader3_y,shaderchangdu*0.8f,shaderkuandu,1);
            Draw.drawself2D(richman,cashId,cash_x,cash_y,coinchangdu,coinkuandu,1);//点券

            Draw.drawself2D(tr2Dperson,persontxArray[personId],head_x,head_y,headchangdu,headkuandu,1);

            money.drawSelfPrice(personId+1+"",numberId,wanjian_x,wanjian_y);


            MatrixState2D.pushMatrix();
            money.drawSelfPrice(year+"",numberId,year_x,year_y);
            MatrixState2D.popMatrix();

            Draw.drawself2D(richman,datexId,datex1_x,datex_y,moneychangdu*0.4f,moneykuandu*0.5f,1);

            if (month<10)
            {
                money.drawSelfPrice("0"+month+"",numberId,month_x,month_y);
            }else
            {
                money.drawSelfPrice(month+"",numberId,month_x,month_y);
            }
            Draw.drawself2D(richman,datexId,datex2_x,datex_y,moneychangdu*0.4f,moneykuandu*0.5f,1);

            if (day<10)
            {
                money.drawSelfPrice("0"+day+"",numberId,day_x,day_y);
            }else
            {
                money.drawSelfPrice(day+"",numberId,day_x,day_y);
            }


            MatrixState2D.pushMatrix();//画人物财产
            money.drawSelfPrice(String.valueOf((int) (moneyArray[personId][0])), numberId, xMoney_x, xMoney_y);//String.valueOf(moneyArray1[personId][0])
            MatrixState2D.popMatrix();

            MatrixState2D.pushMatrix();
            money.drawSelfPrice(String.valueOf((int) (moneyArray[personId][1])), numberId, cMoney_x, cMoney_y);//String.valueOf(moneyArray1[personId][0])
            MatrixState2D.popMatrix();

            MatrixState2D.pushMatrix();
            money.drawSelfPrice(String.valueOf(cardmoneyArray[personId]),numberId,dianquan_x,dianquan_y);
            MatrixState2D.popMatrix();

                if (MoveStateArray[personId]==false)//人物停止
                {
                    //go按钮
                    Draw.drawself2D(trgo,goId,go_x,go_y,gochangdu,gokuandu,1);
                    //游戏界面右侧按钮
                    Draw.drawself2D(tr2Dbmenu[0],cardId,cardMenu_x,cardMenu_y,cardchangdu,cardkuandu,1);
                    Draw.drawself2D(tr2Dbmenu[1],gupiaoId,gupiaoMenu_x,gupiaoMenu_y,cardchangdu,cardkuandu,1);
                    Draw.drawself2D(tr2Dbmenu[2],infoId,infoMenu_x,infoMenu_y,cardchangdu,cardkuandu,1);
                    Draw.drawself2D(tr2Dbmenu[3],setId,setMenu_x,setMenu_y,cardchangdu,cardkuandu,1);
                    //切换视角按钮
                    Draw.drawself2D(shijiao,shijiaoId,shijiao_x,shijiao_y,cardchangdu,cardkuandu,1);
                    //背景虚化
                    Draw.drawself2D(xuhua,xuhuaId,screenWidth/2,screenHeight/2,screenWidth,screenHeight,1);

                    if(personId==1)
                    {
                        Draw.drawself2D(rectangle2Ds[0],buymap1Id,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                        Draw.drawself2D(rectangle2Ds[1],upmap1Id,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                        Draw.drawself2D(rectangle2Ds[2],upmap2Id,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                        Draw.drawself2D(rectangle2Ds[3],upmap3Id,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    }
                    //个人信息界面
                    Draw.drawself2D(tr2dInfo[0],infoAllId,SCREEN_WIDTH/2,SCREEN_HEIGHT/2,4*SCREEN_WIDTH/5,4*SCREEN_HEIGHT/5,1);
                    Draw.drawself2D(tr2dInfo[1],infoAllId,SCREEN_WIDTH/2,SCREEN_HEIGHT/2,4*SCREEN_WIDTH/5,4*SCREEN_HEIGHT/5,1);
                    Draw.drawself2D(tr2dInfo[2],infoAllId,SCREEN_WIDTH/2,SCREEN_HEIGHT/2,4*SCREEN_WIDTH/5,4*SCREEN_HEIGHT/5,1);
                    Draw.drawself2D(tr2dInfo[3],infoAllId,SCREEN_WIDTH/2,SCREEN_HEIGHT/2,4*SCREEN_WIDTH/5,4*SCREEN_HEIGHT/5,1);

                    if (tr2dInfo[0].drawState==true&&tr2dInfo[1].drawState==false&&tr2dInfo[2].drawState==false&&tr2dInfo[3].drawState==false)
                    {
                        money.drawSelfPrice(String.valueOf((int)(moneyArray[0][0])),numberId,infoxMoney_x,infoxMoney_y);
                        money.drawSelfPrice(String.valueOf((int)(moneyArray[0][1])),numberId,infocMoney_x,infocMoney_y);
                        money.drawSelfPrice(String.valueOf(cardmoneyArray[0]),numberId,infodianquan_x,infodianquan_y);
                        money.drawSelfPrice(String.valueOf(dipinumber[0]),numberId,infoRoadn_x,infoRoadn_y);
                        money.drawSelfPrice("1",numberId,wanjia_x,wanjia_y);
                    }else if (tr2dInfo[0].drawState==false&&tr2dInfo[1].drawState==true&&tr2dInfo[2].drawState==false&&tr2dInfo[3].drawState==false)
                    {
                        money.drawSelfPrice(String.valueOf((int)(moneyArray[1][0])),numberId,infoxMoney_x,infoxMoney_y);
                        money.drawSelfPrice(String.valueOf((int)(moneyArray[1][1])),numberId,infocMoney_x,infocMoney_y);
                        money.drawSelfPrice(String.valueOf(cardmoneyArray[1]),numberId,infodianquan_x,infodianquan_y);
                        money.drawSelfPrice(String.valueOf(dipinumber[1]),numberId,infoRoadn_x,infoRoadn_y);
                        money.drawSelfPrice("2",numberId,wanjia_x,wanjia_y);
                    }else if (tr2dInfo[0].drawState==false&&tr2dInfo[1].drawState==false&&tr2dInfo[2].drawState==true&&tr2dInfo[3].drawState==false)
                    {
                        money.drawSelfPrice(String.valueOf((int)(moneyArray[2][0])),numberId,infoxMoney_x,infoxMoney_y);
                        money.drawSelfPrice(String.valueOf((int)(moneyArray[2][1])),numberId,infocMoney_x,infocMoney_y);
                        money.drawSelfPrice(String.valueOf(cardmoneyArray[2]),numberId,infodianquan_x,infodianquan_y);
                        money.drawSelfPrice(String.valueOf(dipinumber[2]),numberId,infoRoadn_x,infoRoadn_y);
                        money.drawSelfPrice("3",numberId,wanjia_x,wanjia_y);
                    }else if (tr2dInfo[0].drawState==false&&tr2dInfo[1].drawState==false&&tr2dInfo[2].drawState==false&&tr2dInfo[3].drawState==true)
                    {
                        money.drawSelfPrice(String.valueOf((int)(moneyArray[3][0])),numberId,infoxMoney_x,infoxMoney_y);
                        money.drawSelfPrice(String.valueOf((int)(moneyArray[3][1])),numberId,infocMoney_x,infocMoney_y);
                        money.drawSelfPrice(String.valueOf(cardmoneyArray[3]),numberId,infodianquan_x,infodianquan_y);
                        money.drawSelfPrice(String.valueOf(dipinumber[3]),numberId,infoRoadn_x,infoRoadn_y);
                        money.drawSelfPrice("4",numberId,wanjia_x,wanjia_y);
                    }
                    //设置界面
                    Draw.drawself2D(tr2dSetMenu,setMenuId,setPage_x,setPage_y+ButtonRangeY*0.1f,setPagechang,setpagekuan+ButtonRangeY*0.2f,1);
                    Draw.drawself2D(tr2dSet[0],backId,setback_x,setback_y,cardchangdu,cardkuandu,1);
                    Draw.drawself2D(tr2dSet[1],xuandanId,setxuandan_x,setxuandan_y,cardchangdu,cardkuandu,1);
                    if (ismusic)
                    {
                        Draw.drawself2D(tr2dSet[2],musicOnId,setMusic_x,setMusic_y,cardchangdu,cardkuandu,1);
                    }else
                    {
                        Draw.drawself2D(tr2dSet[3],musicOffId,setMusic_x,setMusic_y,cardchangdu,cardkuandu,1);
                    }
                    Draw.drawself2D(tr2dSet[4],cunchuId,setcunchu_x,setcunchu_y,cardchangdu,cardkuandu,1);
                    //绘制点券
                    Draw.drawself2D(get20,dianquan20Id,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(get50,dianquan50Id,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    //购买土地
                    Draw.drawself2D(payfor,payforId,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    //花费一半
                    Draw.drawself2D(payhalf,payhalfId,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    //神仙附体图片
                    Draw.drawself2D(caishenM,caishenMId,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(emoM,emoMId,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(fushenM,fushenMId,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(shuaishenM,shuaishenMId,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(tianshiM,tianshiMId,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    //神仙产生效果
                    Draw.drawself2D(tianshiup,tianshiupId,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(emodown,emodownId,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    //升级地皮卡片
                    Draw.drawself2D(upfor1,upfor1Id,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(upfor2,upfor2Id,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(upfor3,upfor3Id,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    //正常过路费
                    Draw.drawself2D(paylevel1,paylevel1Id,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(paylevel2,paylevel2Id,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(paylevel3,paylevel3Id,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(paylevel4,paylevel4Id,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    //财神附体 一半过路费
                    Draw.drawself2D(payhalflevel1,payhalflevel1Id,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(payhalflevel2,payhalflevel2Id,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(payhalflevel3,payhalflevel3Id,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(payhalflevel4,payhalflevel4Id,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    //衰神附体 双倍过路费
                    Draw.drawself2D(paydoublelevel1,paydoublelevel1Id,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(paydoublelevel2,paydoublelevel2Id,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(paydoublelevel3,paydoublelevel3Id,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(paydoublelevel4,paydoublelevel4Id,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    //商店
                    Draw.drawself2D(payshop,payshopId,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(saleshopM,saleshopMId,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(saleshopC,saleshopCId,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(shopoff,shopoffId,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    //旅馆
                    Draw.drawself2D(payhotel,payhotelId,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(salehotelM,salehotelMId,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(salehotelC,salehotelCId,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(hoteloff,hoteloffId,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    //加油站
                    Draw.drawself2D(payjyz,payjyzId,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(salejyzM,salejyzMId,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(salejyzC,salejyzCId,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(jyzoff,jyzoffId,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    //bank
                    Draw.drawself2D(trbankmoney,bankmoneyId,screenWidth/2,screenHeight/2,screenWidth/2,4*screenHeight/5,1);
                    Draw.drawself2D(moneyNo,moneyNoId,screenWidth/2,screenHeight/2,screenWidth/2,3*screenHeight/4,1);
                    Draw.drawself2D(pochan,pochanId,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(uperror,uperrorId,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(saleerror,saleerrorId,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);

                    if (trbankmoney.drawState==true)
                    {
                        money.drawSelfPrice(bankmoney+"",numberId,bankmoney_x,bankmoney_y);
                    }
                    //卡片商店
                    Draw.drawself2D(cardshop,cardshopId,screenWidth/2,screenHeight/2,2*SCREEN_WIDTH/3,2*SCREEN_HEIGHT/3,1);
                    //卡片背包
                    Draw.drawself2D(trcardbag,cardbagId,SCREEN_WIDTH/2,SCREEN_HEIGHT/2,2*SCREEN_WIDTH/3,2*SCREEN_HEIGHT/3,1);
                    //原始卡片
                    Draw.drawselfMyCard(mycardYK,mycardYKId,card1_x,card1_y,cardchang,cardkuan,1,cardArray[1][0][0]);
                    Draw.drawselfMyCard(mycardYD,mycardYDId,card2_x,card2_y,cardchang,cardkuan,1,cardArray[1][1][0]);
                    Draw.drawselfMyCard(mycardLD,mycardLDId,card3_x,card3_y,cardchang,cardkuan,1,cardArray[1][2][0]);
                    Draw.drawselfMyCard(mycardTL,mycardTLId,card4_x,card4_y,cardchang,cardkuan,1,cardArray[1][3][0]);
                    Draw.drawselfMyCard(mycardCS,mycardCSId,card5_x,card5_y,cardchang,cardkuan,1,cardArray[1][4][0]);
                    Draw.drawselfMyCard(mycardFS,mycardFSId,card6_x,card6_y,cardchang,cardkuan,1,cardArray[1][5][0]);
                    //显示卡片
                    Draw.drawself2D(tr2dCard[0],bagCardId[0],showcard_x,showcard_y,showcardchang,showcardkuan,1);
                    Draw.drawself2D(tr2dCard[1],bagCardId[1],showcard_x,showcard_y,showcardchang,showcardkuan,1);
                    Draw.drawself2D(tr2dCard[2],bagCardId[2],showcard_x,showcard_y,showcardchang,showcardkuan,1);
                    Draw.drawself2D(tr2dCard[3],bagCardId[3],showcard_x,showcard_y,showcardchang,showcardkuan,1);
                    Draw.drawself2D(tr2dCard[4],bagCardId[4],showcard_x,showcard_y,showcardchang,showcardkuan,1);
                    Draw.drawself2D(tr2dCard[5],bagCardId[5],showcard_x,showcard_y,showcardchang,showcardkuan,1);
                    //显示数字
                    if (trcardbag.drawState==true)
                    {
                        cardNum.drawSelfPrice(cardArray[1][0][0]+"",numberId,cardNum1_x,cardNum1_y);
                        cardNum.drawSelfPrice(cardArray[1][1][0]+"",numberId,cardNum2_x,cardNum2_y);
                        cardNum.drawSelfPrice(cardArray[1][2][0]+"",numberId,cardNum3_x,cardNum3_y);
                        cardNum.drawSelfPrice(cardArray[1][3][0]+"",numberId,cardNum4_x,cardNum4_y);
                        cardNum.drawSelfPrice(cardArray[1][4][0]+"",numberId,cardNum5_x,cardNum5_y);
                        cardNum.drawSelfPrice(cardArray[1][5][0]+"",numberId,cardNum6_x,cardNum6_y);
                    }


                    //彩票
                    Draw.drawself2D(caipiao,caipiaoId,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    if (caipiao.drawState==true)
                    {
                        money.drawSelfPrice(cpnumArray[1]+"",numberId,showcpnum_x,showcpnum_y);
                    }

                    Draw.drawself2D(caipiaoP0,caipiaoP0Id,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(caipiaoP2,caipiaoP2Id,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(caipiaoP3,caipiaoP3Id,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(kaijiang,kaijiangId,screenWidth/2,screenHeight/2,screenWidth/2,2*screenHeight/3,1);
                    if (kaijiang.drawState==true)
                    {
                        money.drawSelfPrice(cpnum+"",numberId,zhongjiang_x,zhongjiang_y);
                    }

                    Draw.drawself2D(getcp,getcpId,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);
                    Draw.drawself2D(nonegetcp,nonegetcpId,screenWidth/2,screenHeight/2,2*screenWidth/3,2*screenHeight/3,1);

                    //股票
                    Draw.drawself2D(gpview,gpviewId,screenWidth/2,screenHeight/2,4*screenWidth/5,4*screenHeight/5,1);
                    if (gpview.drawState==true)
                    {

                        gp.drawSelfPrice(chengjiaojia[0]+"",numberId,chengjiaojia_x,chengjiaojia1_y);
                        gp.drawSelfPrice(chengjiaojia[1]+"",numberId,chengjiaojia_x,chengjiaojia2_y);
                        gp.drawSelfPrice(chengjiaojia[2]+"",numberId,chengjiaojia_x,chengjiaojia3_y);
                        gp.drawSelfPrice(chengjiaojia[3]+"",numberId,chengjiaojia_x,chengjiaojia4_y);
                        gp.drawSelfPrice(chengjiaojia[4]+"",numberId,chengjiaojia_x,chengjiaojia5_y);

                        if (zhangdie[0][zhangdieran]<0)
                        {
                            Draw.drawself2D(richman,jianId,zhangdie_x*0.98f,zhangdie1_y,gpnumberchang*0.8f,gpnumberkuan*0.5f,1);
                            gp.drawSelfPrice(Math.abs(zhangdie[0][zhangdieran])+"",numberGreenId,zhangdie_x,zhangdie1_y);
                        }else
                        {
                            gp.drawSelfPrice(Math.abs(zhangdie[0][zhangdieran])+"",numberRedId,zhangdie_x,zhangdie1_y);
                        }

                        if (zhangdie[1][zhangdieran]<0)
                        {
                            Draw.drawself2D(richman,jianId,zhangdie_x*0.98f,zhangdie2_y,gpnumberchang*0.8f,gpnumberkuan*0.f,1);
                            gp.drawSelfPrice(Math.abs(zhangdie[1][zhangdieran])+"",numberGreenId,zhangdie_x,zhangdie2_y);
                        }
                        else
                        {
                            gp.drawSelfPrice(Math.abs(zhangdie[1][zhangdieran])+"",numberRedId,zhangdie_x,zhangdie2_y);
                        }

                        if (zhangdie[2][zhangdieran]<0)
                        {
                            Draw.drawself2D(richman,jianId,zhangdie_x*0.98f,zhangdie3_y,gpnumberchang*0.8f,gpnumberkuan*0.5f,1);
                            gp.drawSelfPrice(Math.abs(zhangdie[2][zhangdieran])+"",numberGreenId,zhangdie_x,zhangdie3_y);
                        }else
                        {
                            gp.drawSelfPrice(Math.abs(zhangdie[2][zhangdieran])+"",numberRedId,zhangdie_x,zhangdie3_y);
                        }

                        if (zhangdie[3][zhangdieran]<0)
                        {
                            Draw.drawself2D(richman,jianId,zhangdie_x*0.98f,zhangdie4_y,gpnumberchang*0.8f,gpnumberkuan*0.5f,1);
                            gp.drawSelfPrice(Math.abs(zhangdie[3][zhangdieran])+"",numberGreenId,zhangdie_x,zhangdie4_y);
                        }else
                        {
                            gp.drawSelfPrice(Math.abs(zhangdie[3][zhangdieran])+"",numberRedId,zhangdie_x,zhangdie4_y);
                        }

                        if (zhangdie[4][zhangdieran]<0)
                        {
                            Draw.drawself2D(richman,jianId,zhangdie_x*0.95f,zhangdie5_y,gpnumberchang*0.8f,gpnumberkuan*0.5f,1);
                            gp.drawSelfPrice(Math.abs(zhangdie[4][zhangdieran])+"",numberGreenId,zhangdie_x,zhangdie5_y);
                        }else
                        {
                            gp.drawSelfPrice(Math.abs(zhangdie[4][zhangdieran])+"",numberRedId,zhangdie_x,zhangdie5_y);
                        }

                        gp.drawSelfPrice(jiaoyiliang[0]+"",numberId,jiaoyiliang_x,jiaoyiliang1_y);
                        gp.drawSelfPrice(jiaoyiliang[1]+"",numberId,jiaoyiliang_x,jiaoyiliang2_y);
                        gp.drawSelfPrice(jiaoyiliang[2]+"",numberId,jiaoyiliang_x,jiaoyiliang3_y);
                        gp.drawSelfPrice(jiaoyiliang[3]+"",numberId,jiaoyiliang_x,jiaoyiliang4_y);
                        gp.drawSelfPrice(jiaoyiliang[4]+"",numberId,jiaoyiliang_x,jiaoyiliang5_y);


                        gp.drawSelfPrice(chiyoushu[0]+"",numberId,chiyoushu_x,chiyoushu1_y);
                        gp.drawSelfPrice(chiyoushu[1]+"",numberId,chiyoushu_x,chiyoushu2_y);
                        gp.drawSelfPrice(chiyoushu[2]+"",numberId,chiyoushu_x,chiyoushu3_y);
                        gp.drawSelfPrice(chiyoushu[3]+"",numberId,chiyoushu_x,chiyoushu4_y);
                        gp.drawSelfPrice(chiyoushu[4]+"",numberId,chiyoushu_x,chiyoushu5_y);
                    }
                    Draw.drawself2D(gpnum[0],gpnumId,screenWidth/2,screenHeight/2,screenWidth/2,2*screenHeight/3,1);
                    Draw.drawself2D(gpnum[1],gpnumId,screenWidth/2,screenHeight/2,screenWidth/2,2*screenHeight/3,1);
                    Draw.drawself2D(gpnum[2],gpnumId,screenWidth/2,screenHeight/2,screenWidth/2,2*screenHeight/3,1);
                    Draw.drawself2D(gpnum[3],gpnumId,screenWidth/2,screenHeight/2,screenWidth/2,2*screenHeight/3,1);
                    Draw.drawself2D(gpnum[4],gpnumId,screenWidth/2,screenHeight/2,screenWidth/2,2*screenHeight/3,1);
                    Draw.drawself2D(gpnum[5],gpnumId,screenWidth/2,screenHeight/2,screenWidth/2,2*screenHeight/3,1);
                    Draw.drawself2D(gpnum[6],gpnumId,screenWidth/2,screenHeight/2,screenWidth/2,2*screenHeight/3,1);
                    Draw.drawself2D(gpnum[7],gpnumId,screenWidth/2,screenHeight/2,screenWidth/2,2*screenHeight/3,1);
                    Draw.drawself2D(gpnum[8],gpnumId,screenWidth/2,screenHeight/2,screenWidth/2,2*screenHeight/3,1);
                    Draw.drawself2D(gpnum[9],gpnumId,screenWidth/2,screenHeight/2,screenWidth/2,2*screenHeight/3,1);

                        if (gpnum[0].drawState==true)
                        {
                            money.drawSelfPrice(mairugp[0]+"",numberId,gpnum_x,gpnum_y);
                        }
                        else if (gpnum[1].drawState==true)
                        {
                            money.drawSelfPrice(mairugp[1]+"",numberId,gpnum_x,gpnum_y);
                        }else if (gpnum[2].drawState==true)
                        {
                            money.drawSelfPrice(mairugp[2]+"",numberId,gpnum_x,gpnum_y);
                        }else if (gpnum[3].drawState==true)
                        {
                            money.drawSelfPrice(mairugp[3]+"",numberId,gpnum_x,gpnum_y);
                        }else if (gpnum[4].drawState==true)
                        {
                            money.drawSelfPrice(mairugp[4]+"",numberId,gpnum_x,gpnum_y);
                        }else if (gpnum[5].drawState==true)
                        {
                            money.drawSelfPrice(maichugp[0]+"",numberId,gpnum_x,gpnum_y);
                        }else if (gpnum[6].drawState==true)
                        {
                            money.drawSelfPrice(maichugp[1]+"",numberId,gpnum_x,gpnum_y);
                        }else if (gpnum[7].drawState==true)
                        {
                            money.drawSelfPrice(maichugp[2]+"",numberId,gpnum_x,gpnum_y);
                        }else if (gpnum[8].drawState==true)
                        {
                            money.drawSelfPrice(maichugp[3]+"",numberId,gpnum_x,gpnum_y);
                        }else if (gpnum[9].drawState==true)
                        {
                            money.drawSelfPrice(maichugp[4]+"",numberId,gpnum_x,gpnum_y);
                        }


                    if (trcardbag.drawState==true)
                    {
                        money.drawSelfPrice(cardArray[1][salecardId][0]+"",numberId,cardnumber_x,cardnumber_y);
                    }
                    //bank
                    Draw.drawself2D(getmoney,getmoneyId,screenWidth/2,screenHeight/2,screenWidth/2,2*screenHeight/3,1);

                    //进医院
                    Draw.drawself2D(gohos,gohosId,screenWidth/2,screenHeight/2,screenWidth/2,2*screenHeight/3,1);


                    //切换筛子点数动画
                    drawNum++;
                    if((drawNum>=0&&drawNum<5)||(drawNum>=20&&drawNum<25)){
                        Draw.drawself2D(shaizi,a1Id,screenWidth*0.5f,screenHeight*0.5f,gochangdu,gokuandu,1);
                    }else if((drawNum>=5&&drawNum<10)||(drawNum>=25&&drawNum<30)){
                        Draw.drawself2D(shaizi,a2Id,screenWidth*0.5f,screenHeight*0.5f,gochangdu,gokuandu,1);
                    }else if((drawNum>=10&&drawNum<15)||(drawNum>=30&&drawNum<35)){
                        Draw.drawself2D(shaizi,a3Id,screenWidth*0.5f,screenHeight*0.5f,gochangdu,gokuandu,1);
                    }else if((drawNum>=15&&drawNum<20)||(drawNum>=40&&drawNum<40)){
                        Draw.drawself2D(shaizi,a4Id,screenWidth*0.5f,screenHeight*0.5f,gochangdu,gokuandu,1);
                    }
                    if (drawNum>=40){
                        switch (dianshu){
                            case 1:
                                Draw.drawself2D(shaizi,dian1Id,screenWidth*0.5f,screenHeight*0.5f,gochangdu,gokuandu,1);
                                break;
                            case 2:
                                Draw.drawself2D(shaizi,dian2Id,screenWidth*0.5f,screenHeight*0.5f,gochangdu,gokuandu,1);
                                break;
                            case 3:
                                Draw.drawself2D(shaizi,dian3Id,screenWidth*0.5f,screenHeight*0.5f,gochangdu,gokuandu,1);
                                break;
                            case 4:
                                Draw.drawself2D(shaizi,dian4Id,screenWidth*0.5f,screenHeight*0.5f,gochangdu,gokuandu,1);
                                break;
                            case 5:
                                Draw.drawself2D(shaizi,dian5Id,screenWidth*0.5f,screenHeight*0.5f,gochangdu,gokuandu,1);
                                break;
                            case 6:
                                Draw.drawself2D(shaizi,dian6Id,screenWidth*0.5f,screenHeight*0.5f,gochangdu,gokuandu,1);
                                break;
                        }
                    }

                }
            Draw.drawself2D(cundangView, cundangViewId, screenWidth / 2, screenHeight / 2, screenWidth, screenHeight, 1);//进行存档界面
            if (cundangState==1&&cundangView.drawState==true)
            {
                money.drawSelfPrice(year1+"",numberId,cundangyear1_x,cundangyear1_y);

                Draw.drawself2D(richman,datexId,cundangdate11_x,cundangdate11_y,moneychangdu*0.4f,moneykuandu*0.5f,1);
                if (month1<10)
                {
                    money.drawSelfPrice("0"+month1+"",numberId,cundangmonth1_x,cundangmonth1_y);
                }else
                {
                    money.drawSelfPrice(month1+"",numberId,cundangmonth1_x,cundangmonth1_y);
                }


                Draw.drawself2D(richman,datexId,cundangdate21_x,cundangdate21_y,moneychangdu*0.4f,moneykuandu*0.5f,1);
                if (day1<10)
                {
                    money.drawSelfPrice("0"+day1+"",numberId,cundangday1_x,cundangday1_y);
                }else
                {
                    money.drawSelfPrice(day1+"",numberId,cundangday1_x,cundangday1_y);
                }

                if (hour1<10)
                {
                    money.drawSelfPrice("0"+hour1+"",numberId,cundanghour1_x,cundanghour1_y);
                }else
                {
                    money.drawSelfPrice(hour1+"",numberId,cundanghour1_x,cundanghour1_y);
                }


                Draw.drawself2D(richman,maohaoId,cundangdate31_x,cundangdate31_y,moneychangdu*0.4f,moneykuandu*0.5f,1);
                if (min1<10)
                {
                    money.drawSelfPrice("0"+min1+"",numberId,cundangmin1_x,cundangmin1_y);
                }else
                {
                    money.drawSelfPrice(min1+"",numberId,cundangmin1_x,cundangmin1_y);
                }

            }
            //第2条存档
            if (cundangState2==1&&cundangView.drawState)
            {
                money.drawSelfPrice(year2+"",numberId,cundangyear1_x,cundang2_y);

                Draw.drawself2D(richman,datexId,cundangdate11_x,cundang2_y,moneychangdu*0.4f,moneykuandu*0.5f,1);
                if (month2<10)
                {
                    money.drawSelfPrice("0"+month2+"",numberId,cundangmonth1_x,cundang2_y);
                }else
                {
                    money.drawSelfPrice(month2+"",numberId,cundangmonth1_x,cundang2_y);
                }
                Draw.drawself2D(richman,datexId,cundangdate21_x,cundang2_y,moneychangdu*0.4f,moneykuandu*0.5f,1);
                if (day2<10)
                {
                    money.drawSelfPrice("0"+day2+"",numberId,cundangday1_x,cundang2_y);
                }else
                {
                    money.drawSelfPrice(day2+"",numberId,cundangday1_x,cundang2_y);
                }
                if (hour2<10)
                {
                    money.drawSelfPrice("0"+hour2+"",numberId,cundanghour1_x,cundang2_y);
                }else
                {
                    money.drawSelfPrice(hour2+"",numberId,cundanghour1_x,cundang2_y);
                }
                Draw.drawself2D(richman,maohaoId,cundangdate31_x,cundang2_y,moneychangdu*0.4f,moneykuandu*0.5f,1);
                if (min2<10)
                {
                    money.drawSelfPrice("0"+min2+"",numberId,cundangmin1_x,cundang2_y);
                }else
                {
                    money.drawSelfPrice(min2+"",numberId,cundangmin1_x,cundang2_y);
                }

            }
            //第3条存档
            if (cundangState3==1&&cundangView.drawState)
            {
                money.drawSelfPrice(year3+"",numberId,cundangyear1_x,cundang3_y);
                Draw.drawself2D(richman,datexId,cundangdate11_x,cundang3_y,moneychangdu*0.4f,moneykuandu*0.5f,1);
                if (month3<10)
                {
                    money.drawSelfPrice("0"+month3+"",numberId,cundangmonth1_x,cundang3_y);
                }else
                {
                    money.drawSelfPrice(month3+"",numberId,cundangmonth1_x,cundang3_y);
                }
                Draw.drawself2D(richman,datexId,cundangdate21_x,cundang3_y,moneychangdu*0.4f,moneykuandu*0.5f,1);
                if (day3<10)
                {
                    money.drawSelfPrice("0"+day3+"",numberId,cundangday1_x,cundang3_y);
                }else
                {
                    money.drawSelfPrice(day3+"",numberId,cundangday1_x,cundang3_y);
                }
                if (hour3<10)
                {
                    money.drawSelfPrice("0"+hour3+"",numberId,cundanghour1_x,cundang3_y);
                }else
                {
                    money.drawSelfPrice(hour3+"",numberId,cundanghour1_x,cundang3_y);
                }
                Draw.drawself2D(richman,maohaoId,cundangdate31_x,cundang3_y,moneychangdu*0.4f,moneykuandu*0.5f,1);
                if (min3<10)
                {
                    money.drawSelfPrice("0"+min3+"",numberId,cundangmin1_x,cundang3_y);
                }else
                {
                    money.drawSelfPrice(min3+"",numberId,cundangmin1_x,cundang3_y);
                }

            }
            //第4条存档
            if (cundangState4==1&&cundangView.drawState)
            {
                money.drawSelfPrice(year4+"",numberId,cundangyear1_x,cundang4_y);

                Draw.drawself2D(richman,datexId,cundangdate11_x,cundang4_y,moneychangdu*0.4f,moneykuandu*0.5f,1);

                if (month4<10)
                {
                    money.drawSelfPrice("0"+month4+"",numberId,cundangmonth1_x,cundang4_y);
                }else
                {
                    money.drawSelfPrice(month4+"",numberId,cundangmonth1_x,cundang4_y);
                }
                Draw.drawself2D(richman,datexId,cundangdate21_x,cundang4_y,moneychangdu*0.4f,moneykuandu*0.5f,1);
                if (day4<10)
                {
                    money.drawSelfPrice("0"+day4+"",numberId,cundangday1_x,cundang4_y);
                }else
                {
                    money.drawSelfPrice(day4+"",numberId,cundangday1_x,cundang4_y);
                }
                if (hour4<10)
                {
                    money.drawSelfPrice("0"+hour4+"",numberId,cundanghour1_x,cundang4_y);
                }else
                {
                    money.drawSelfPrice(hour4+"",numberId,cundanghour1_x,cundang4_y);
                }
                Draw.drawself2D(richman,maohaoId,cundangdate31_x,cundang4_y,moneychangdu*0.4f,moneykuandu*0.5f,1);
                if (min4<10)
                {
                    money.drawSelfPrice("0"+min4+"",numberId,cundangmin1_x,cundang4_y);
                }else
                {
                    money.drawSelfPrice(min4+"",numberId,cundangmin1_x,cundang4_y);
                }

            }
            //覆盖存档
            Draw.drawself2D(fugai,fugaiId,screenWidth / 2, screenHeight / 2, screenWidth/2, 2*screenHeight/3, 1);
            Draw.drawself2D(saveCD,saveCDId,screenWidth / 2, screenHeight / 2, 2*screenWidth/3, 2*screenHeight/3, 1);
        }
        GLES30.glEnable(GLES30.GL_DEPTH_TEST);
        GLES30.glDisable(GLES30.GL_BLEND);
    }

}

