package com.bn.View;

import android.opengl.GLES30;
import android.view.MotionEvent;
import com.bn.RichMan.MainActivity;
import com.bn.RichMan.MyGLSurFaceView;
import com.bn.Scenes.ScenesData;
import com.bn.Thread.MoveThread;
import com.bn.Util.CDPreferences;
import com.bn.Util.MatrixState2D;
import com.bn.Util.MatrixState3D;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.microedition.khronos.opengles.GL10;
import static com.bn.Constant.Constant.*;
import static com.bn.Constant.IdDataConstant.*;
import static com.bn.Constant.LovoConstant.*;
import static com.bn.Constant.ParticleScenceData.psdata;
import static com.bn.RichMan.MyGLSurFaceView.currView;
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
import static com.bn.Util.CDPreferences.GetCDTimeYear1;
import static com.bn.Util.CDPreferences.GetCDTimeYear2;
import static com.bn.Util.CDPreferences.GetCDTimeYear3;
import static com.bn.Util.CDPreferences.GetCDTimeYear4;
import static com.bn.Util.CDPreferences.GetCDTimecdDay4;
import static com.bn.Util.CDPreferences.WriteCDState;
import static com.bn.Util.CDPreferences.WriteCDState2;
import static com.bn.Util.CDPreferences.WriteCDState3;
import static com.bn.Util.CDPreferences.WriteCDState4;
import static com.bn.Util.SoundManager.ismusic;
import static com.bn.View.MenuButton.GAMEVIEW;
import static com.bn.View.MenuButton.currentView;

//游戏界面
public class GameView extends RMAbstractView
{
    MainActivity ma;
    MyGLSurFaceView mv;
    private float mPreviousX;
    private float mPreviousY;
    static int mVscale=6;//触摸移动系数
    public static MoveThread moveThread;

    public GameView(MainActivity ma, MyGLSurFaceView mv)
    {
        this.ma=ma;
        this.mv=mv;

        moveThread = new MoveThread();
        moveThread.start();

    }
    @Override
    public void initView() {
    }

    @Override//触摸回调事件
    public boolean onTouchEvent(MotionEvent e) {
      // cdPreferences=new CDPreferences();
        float y=e.getY();
        float x=e.getX();

        switch (e.getAction()) {
            case MotionEvent.ACTION_MOVE:
                System.out.println("action_move:       " + xuhua.drawState);
                if (!xuhua.drawState) {
                    float dy = y - mPreviousY;
                    float dx = x - mPreviousX;
                    dx = dx / screenHeight;     //换算触摸屏幕移动距离在空间里的长度
                    dy = dy / screenWidth;
                    if (cx >= -25 - 5 && cx <= 10 - 5) {     //判断摄像机是否到达x轴边界
                        cx = cx - dx * mVscale * 2f + dy * mVscale * 2f;        //根据在屏幕上的移动距离换算摄像机的移动
                        tx = tx - dx * mVscale * 2f + dy * mVscale * 2f;        //同时改变目标点的坐标
                        if (cx < -25 - 5) {         //如果一次事件里摄像机移动超出左边界
                            cx = -25 - 5;         //复原摄像机坐标
                            tx = -14 - 5;          //复原目标点坐标
                        } else if (cx > 10 - 5) {
                            cx = 10 - 5;
                            tx = 21 - 5;
                        }
                    }
                    if (cz >= -3 && cz <= 20) {      //判断摄像机是否到达z轴边界
                        cz = cz - dy * mVscale * 2f - dx * mVscale * 2f;        //根据在屏幕上的移动距离换算摄像机的移动
                        tz = tz - dy * mVscale * 2f - dx * mVscale * 2f;        //同时改变目标点的坐标
                        if (cz < -3) {           //如果一次事件里摄像机移动超出上边界
                            cz = -3;           //复原摄像机坐标
                            tz = -14;          //复原目标点坐标
                        } else if (cz > 20) {
                            cz = 20;
                            tz = 9;
                        }
                    }
                }
                break;
            case MotionEvent.ACTION_DOWN:
                if (currView == gameView) {
                    //当前人物为1号人物 游戏玩家 personId = playerId ，才存在触摸，电脑玩家不用触摸，直接进行下一回合
                    if (MoveStateArray[personId] == false && !xuhua.drawState)
                    {
                        if (x > goLeft && x < goRight && y > goTop && y < goBottom) {
                            System.out.println("gameView触发骰子事件触发骰子事件");
                            //开启下一回合 打开筛子线程
                            //shaizi.drawState=true;
                            shaiziState = true;
                            System.out.println("gameVIew  nextGamenextGamenextGame");
                            throwUtil.nextGame();
                        }
                        if (x > shijiaoLeft && x < shijiaoRight && y > shijiaoTop && y < shijiaoBottom) {
                            CameraState = !CameraState;
                            soundOfButton();
                        }
                    }

                    //当前人物为游戏玩家
                    if (rectangle2Ds[0].drawState == true) {
                        //不购买按钮
                        if (x > buynoLeft && x < buynoRight && y > buynoTop && y < buynoBottom) {
                            saleState = false;
                            gameView.soundOfButton();
                            xuhua.drawState = false;
                            rectangle2Ds[0].drawState = false;
                        }
                        //购买按钮
                        else if (x > buyyesLeft && x < buyyesRight && y > buyyesTop && y < buyyesBottom) {
                            saleState = true;
                            gameView.soundOfButton();
                            xuhua.drawState = false;
                            rectangle2Ds[0].drawState = false;
                            System.out.println("GmaeView saleState  " + saleState);
                        }
                    }
                    //                    for (int i = 0; i < tr2Dbmenu.length; i++)
//                    {
                    if (MoveStateArray[personId] == false && tr2Dbmenu[0].drawState == true &&tr2Dbmenu[1].drawState==true
                            &&tr2Dbmenu[2].drawState==true&&tr2Dbmenu[3].drawState==true&& xuhua.drawState == false && tr2dSetMenu.drawState == false)
                    {
                        //卡片背包
                        if (x > cardMenuLeft && x < cardMenuRight && y > cardMenuTop && y < cardMenuBottom) {
                            xuhua.drawState = true;
                            trcardbag.drawState = true;
                            mycardYK.drawState = true;
                            mycardYD.drawState = true;
                            mycardLD.drawState = true;
                            mycardTL.drawState = true;
                            mycardCS.drawState = true;
                            mycardFS.drawState = true;
                            gameView.soundOfButton();
                        }
                        //股票
                        else if (x > gupiaoMenuLeft && x < gupiaoMenuRight && y > gupiaoMenuTop && y < gupiaoMenuBottom) {
                            xuhua.drawState = true;
                            gpview.drawState = true;
                            soundOfButton();
                        }
                        //个人信息
                        else if (x > infoMneuLeft && x < infoMenuRight && y > infoMenuTop && y < infoMenuBottom) {
                            xuhua.drawState = true;
                            gameView.soundOfButton();
                            tr2dInfo[0].drawState = true;
                        }
                        //设置
                        else if (x > setMenuLeft && x < setMenuRight && y > setMenuTop && y < setMenuBottom) {
                            gameView.soundOfButton();
                            xuhua.drawState = true;
                            tr2dSetMenu.drawState = true;
                            tr2dSet[0].drawState = true;
                            tr2dSet[1].drawState = true;
                            tr2dSet[2].drawState = true;
                            tr2dSet[3].drawState = true;
                            tr2dSet[4].drawState = true;
                        }
                        //}
                    }
                    //卡片背包
                    else if (trcardbag.drawState == true){
                        //使用卡片
                        if (x > usecardLeft && x < usecardRight && y > usecardTop && y < usecardBottom) {
                            xuhua.drawState = false;
                            trcardbag.drawState = false;

                            mycardYK.drawState = false;
                            mycardYD.drawState = false;
                            mycardLD.drawState = false;
                            mycardTL.drawState = false;
                            mycardCS.drawState = false;
                            mycardFS.drawState = false;

                            tr2dCard[0].drawState = false;
                            tr2dCard[1].drawState = false;
                            tr2dCard[2].drawState = false;
                            tr2dCard[3].drawState = false;
                            tr2dCard[4].drawState = false;
                            tr2dCard[5].drawState = false;
                        }
                        //关闭按钮
                        else if (x > closebagLeft && x < closeBagRight && y > closebagTop && y < closebagBottom) {
                            xuhua.drawState = false;
                            trcardbag.drawState = false;
                            mycardYK.drawState = false;
                            mycardYD.drawState = false;
                            mycardLD.drawState = false;
                            mycardTL.drawState = false;
                            mycardCS.drawState = false;
                            mycardFS.drawState = false;
                            for (int i = 0; i < tr2dCard.length; i++) {
                                tr2dCard[i].drawState = false;
                            }
                            gameView.soundOfButton();
                        } //card1
                        else if (x > card1Left && x < card1Right && y > card1Top && y < card1Bottom) {
                            System.out.println("choose card1");

                            salecardId = 0;
                            tr2dCard[0].drawState = true;
                            tr2dCard[1].drawState = false;
                            tr2dCard[2].drawState = false;
                            tr2dCard[3].drawState = false;
                            tr2dCard[4].drawState = false;
                            tr2dCard[5].drawState = false;
                            gameView.soundOfButton();
                        } else if (x > card2Left && x < card2Right && y > card2Top && y < card2Bottom) {
                            System.out.println("choose card2");

                            salecardId = 1;
                            tr2dCard[0].drawState = false;
                            tr2dCard[1].drawState = true;
                            tr2dCard[2].drawState = false;
                            tr2dCard[3].drawState = false;
                            tr2dCard[4].drawState = false;
                            tr2dCard[5].drawState = false;
                            gameView.soundOfButton();
                        } else if (x > card3Left && x < card3Right && y > card3Top && y < card3Bottom) {
                            System.out.println("choose card3");

                            salecardId = 2;
                            tr2dCard[0].drawState = false;
                            tr2dCard[1].drawState = false;
                            tr2dCard[2].drawState = true;
                            tr2dCard[3].drawState = false;
                            tr2dCard[4].drawState = false;
                            tr2dCard[5].drawState = false;
                            gameView.soundOfButton();
                        } else if (x > card4Left && x < card4Right && y > card4Top && y < card4Bottom) {
                            System.out.println("choose card4");

                            salecardId = 3;
                            tr2dCard[0].drawState = false;
                            tr2dCard[1].drawState = false;
                            tr2dCard[2].drawState = false;
                            tr2dCard[3].drawState = true;
                            tr2dCard[4].drawState = false;
                            tr2dCard[5].drawState = false;
                            gameView.soundOfButton();
                        } else if (x > card5Left && x < card5Right && y > card5Top && y < card5Bottom) {
                            System.out.println("choose card5");

                            salecardId = 4;
                            tr2dCard[0].drawState = false;
                            tr2dCard[1].drawState = false;
                            tr2dCard[2].drawState = false;
                            tr2dCard[3].drawState = false;
                            tr2dCard[4].drawState = true;
                            tr2dCard[5].drawState = false;
                            gameView.soundOfButton();
                        } else if (x > card6Left && x < card6Right && y > card6Top && y < card6Bottom) {
                            System.out.println("choose card6");

                            salecardId = 5;
                            tr2dCard[0].drawState = false;
                            tr2dCard[1].drawState = false;
                            tr2dCard[2].drawState = false;
                            tr2dCard[3].drawState = false;
                            tr2dCard[4].drawState = false;
                            tr2dCard[5].drawState = true;
                            gameView.soundOfButton();
                        }

                    }
                    //股票
                    else if (gpview.drawState == true) {
                        if (gpnum[0].drawState == false && gpnum[1].drawState == false && gpnum[2].drawState == false && gpnum[3].drawState == false && gpnum[4].drawState == false
                                && gpnum[5].drawState == false && gpnum[6].drawState == false && gpnum[7].drawState == false && gpnum[8].drawState == false && gpnum[9].drawState == false) {
                            if (x > closegpLeft && x < closegpRight && y > closegpTop && y < closegpBottom) {
                                xuhua.drawState = false;
                                gpview.drawState = false;
                                soundOfButton();
                            } else if (x > mairuLeft && x < mairuRight) {
                                if (y > mairu1Top && y < mairu1Bottom) {
                                    gpnum[0].drawState = true;
                                    gpnum[1].drawState = false;
                                    gpnum[2].drawState = false;
                                    gpnum[3].drawState = false;
                                    gpnum[4].drawState = false;
                                    gpnum[5].drawState = false;
                                    gpnum[6].drawState = false;
                                    gpnum[7].drawState = false;
                                    gpnum[8].drawState = false;
                                    gpnum[9].drawState = false;
                                } else if (y > mairu2Top && y < mairu2Bottom) {
                                    gpnum[0].drawState = false;
                                    gpnum[1].drawState = true;
                                    gpnum[2].drawState = false;
                                    gpnum[3].drawState = false;
                                    gpnum[4].drawState = false;
                                    gpnum[5].drawState = false;
                                    gpnum[6].drawState = false;
                                    gpnum[7].drawState = false;
                                    gpnum[8].drawState = false;
                                    gpnum[9].drawState = false;
                                } else if (y > mairu3Top && y < mairu3Bottom) {
                                    gpnum[0].drawState = false;
                                    gpnum[1].drawState = false;
                                    gpnum[2].drawState = true;
                                    gpnum[3].drawState = false;
                                    gpnum[4].drawState = false;
                                    gpnum[5].drawState = false;
                                    gpnum[6].drawState = false;
                                    gpnum[7].drawState = false;
                                    gpnum[8].drawState = false;
                                    gpnum[9].drawState = false;
                                } else if (y > mairu4Top && y < mairu4Bottom) {
                                    gpnum[0].drawState = false;
                                    gpnum[1].drawState = false;
                                    gpnum[2].drawState = false;
                                    gpnum[3].drawState = true;
                                    gpnum[4].drawState = false;
                                    gpnum[5].drawState = false;
                                    gpnum[6].drawState = false;
                                    gpnum[7].drawState = false;
                                    gpnum[8].drawState = false;
                                    gpnum[9].drawState = false;
                                } else if (y > mairu5Top && y < mairu5Bottom) {
                                    gpnum[0].drawState = false;
                                    gpnum[1].drawState = false;
                                    gpnum[2].drawState = false;
                                    gpnum[3].drawState = false;
                                    gpnum[4].drawState = true;
                                    gpnum[5].drawState = false;
                                    gpnum[6].drawState = false;
                                    gpnum[7].drawState = false;
                                    gpnum[8].drawState = false;
                                    gpnum[9].drawState = false;
                                }
                            } else if (x > maichuLeft && x < maichuRight) {
                                if (y > maichu1Top && y < maichu1Bottom) {
                                    gpnum[0].drawState = false;
                                    gpnum[1].drawState = false;
                                    gpnum[2].drawState = false;
                                    gpnum[3].drawState = false;
                                    gpnum[4].drawState = false;
                                    gpnum[5].drawState = true;
                                    gpnum[6].drawState = false;
                                    gpnum[7].drawState = false;
                                    gpnum[8].drawState = false;
                                    gpnum[9].drawState = false;
                                } else if (y > maichu2Top && y < maichu2Bottom) {
                                    gpnum[0].drawState = false;
                                    gpnum[1].drawState = false;
                                    gpnum[2].drawState = false;
                                    gpnum[3].drawState = false;
                                    gpnum[4].drawState = false;
                                    gpnum[5].drawState = false;
                                    gpnum[6].drawState = true;
                                    gpnum[7].drawState = false;
                                    gpnum[8].drawState = false;
                                    gpnum[9].drawState = false;
                                } else if (y > maichu3Top && y < maichu3Bottom) {
                                    gpnum[0].drawState = false;
                                    gpnum[1].drawState = false;
                                    gpnum[2].drawState = false;
                                    gpnum[3].drawState = false;
                                    gpnum[4].drawState = false;
                                    gpnum[5].drawState = false;
                                    gpnum[6].drawState = false;
                                    gpnum[7].drawState = true;
                                    gpnum[8].drawState = false;
                                    gpnum[9].drawState = false;
                                } else if (y > maichu4Top && y < maichu4Bottom) {
                                    gpnum[0].drawState = false;
                                    gpnum[1].drawState = false;
                                    gpnum[2].drawState = false;
                                    gpnum[3].drawState = false;
                                    gpnum[4].drawState = false;
                                    gpnum[5].drawState = false;
                                    gpnum[6].drawState = false;
                                    gpnum[7].drawState = false;
                                    gpnum[8].drawState = true;
                                    gpnum[9].drawState = false;
                                } else if (y > maichu5Top && y < maichu5Bottom) {
                                    gpnum[0].drawState = false;
                                    gpnum[1].drawState = false;
                                    gpnum[2].drawState = false;
                                    gpnum[3].drawState = false;
                                    gpnum[4].drawState = false;
                                    gpnum[5].drawState = false;
                                    gpnum[6].drawState = false;
                                    gpnum[7].drawState = false;
                                    gpnum[8].drawState = false;
                                    gpnum[9].drawState = true;
                                }
                            }
                        }

                        if (gpnum[0].drawState == true && gpnum[1].drawState == false && gpnum[2].drawState == false && gpnum[3].drawState == false && gpnum[4].drawState == false
                                && gpnum[5].drawState == false && gpnum[6].drawState == false && gpnum[7].drawState == false && gpnum[8].drawState == false && gpnum[9].drawState == false) {
                            if (x > mairureduceLeft && x < mairureduceRight && y > mairureduceTop && y < mairureduceBottom) {
                                if (jiaoyiliang[0] > 100) {
                                    if (mairugp[0] > 0) {
                                        mairugp[0] = mairugp[0] - 100;
                                    }
                                }
                            } else if (x > mairuplusLeft && x < mairuplusRight && y > mairuplusTop && y < mairuplusBottom) {

                                if (mairugp[0] < jiaoyiliang[0]) {
                                    mairugp[0] = mairugp[0] + 100;
                                }

                            } else if (x > mairuyesLeft && x < mairuyesRight && y > mairuyesTop && y < mairuyesBottom) {
                                gpnum[0].drawState = false;
                                chiyoushu[0] = chiyoushu[0] + mairugp[0];
                                jiaoyiliang[0] = jiaoyiliang[0] - mairugp[0];
                                moneyArray[personId][0] = moneyArray[personId][0] - (float) (chengjiaojia[0]) * mairugp[0];
                                mairugp[0] = 0;


                            } else if (x > mairunoLeft && x < mairunoRight && y > mairunoTop && y < mairunoBottom) {
                                gpnum[0].drawState = false;
                                mairugp[0] = 0;
                            }
                        }

                        if (gpnum[0].drawState == false && gpnum[1].drawState == true && gpnum[2].drawState == false && gpnum[3].drawState == false && gpnum[4].drawState == false
                                && gpnum[5].drawState == false && gpnum[6].drawState == false && gpnum[7].drawState == false && gpnum[8].drawState == false && gpnum[9].drawState == false) {
                            if (x > mairureduceLeft && x < mairureduceRight && y > mairureduceTop && y < mairureduceBottom) {
                                if (jiaoyiliang[1] > 0) {
                                    if (mairugp[1] > 0) {
                                        mairugp[1] = mairugp[1] - 100;
                                    }
                                }

                            } else if (x > mairuplusLeft && x < mairuplusRight && y > mairuplusTop && y < mairuplusBottom) {
                                if (mairugp[1] < jiaoyiliang[1]) {
                                    mairugp[1] = mairugp[1] + 100;
                                }

                            } else if (x > mairuyesLeft && x < mairuyesRight && y > mairuyesTop && y < mairuyesBottom) {
                                gpnum[1].drawState = false;
                                chiyoushu[1] = chiyoushu[1] + mairugp[1];
                                jiaoyiliang[1] = jiaoyiliang[1] - mairugp[1];
                                moneyArray[personId][0] = moneyArray[personId][0] - (float) (chengjiaojia[1]) * mairugp[1];
                                mairugp[1] = 0;

                            } else if (x > mairunoLeft && x < mairunoRight && y > mairunoTop && y < mairunoBottom) {
                                gpnum[1].drawState = false;
                                mairugp[1] = 0;
                            }
                        }

                        if (gpnum[0].drawState == false && gpnum[1].drawState == false && gpnum[2].drawState == true && gpnum[3].drawState == false && gpnum[4].drawState == false
                                && gpnum[5].drawState == false && gpnum[6].drawState == false && gpnum[7].drawState == false && gpnum[8].drawState == false && gpnum[9].drawState == false) {
                            if (x > mairureduceLeft && x < mairureduceRight && y > mairureduceTop && y < mairureduceBottom) {
                                if (jiaoyiliang[2] > 0) {
                                    if (mairugp[2] > 0) {
                                        mairugp[2] = mairugp[2] - 100;
                                    }
                                }

                            } else if (x > mairuplusLeft && x < mairuplusRight && y > mairuplusTop && y < mairuplusBottom) {
                                if (mairugp[2] < jiaoyiliang[2]) {
                                    mairugp[2] = mairugp[2] + 100;
                                }

                            } else if (x > mairuyesLeft && x < mairuyesRight && y > mairuyesTop && y < mairuyesBottom) {
                                gpnum[2].drawState = false;
                                chiyoushu[2] = chiyoushu[2] + mairugp[2];
                                jiaoyiliang[2] = jiaoyiliang[2] - mairugp[2];
                                moneyArray[personId][0] = moneyArray[personId][0] - (float) (chengjiaojia[2]) * mairugp[2];
                                mairugp[2] = 0;

                            } else if (x > mairunoLeft && x < mairunoRight && y > mairunoTop && y < mairunoBottom) {
                                gpnum[2].drawState = false;
                                mairugp[2] = 0;
                            }
                        }

                        if (gpnum[0].drawState == false && gpnum[1].drawState == false && gpnum[2].drawState == false && gpnum[3].drawState == true && gpnum[4].drawState == false
                                && gpnum[5].drawState == false && gpnum[6].drawState == false && gpnum[7].drawState == false && gpnum[8].drawState == false && gpnum[9].drawState == false) {

                            if (x > mairureduceLeft && x < mairureduceRight && y > mairureduceTop && y < mairureduceBottom) {
                                if (jiaoyiliang[3] > 0) {
                                    if (mairugp[3] > 0) {
                                        mairugp[3] = mairugp[3] - 100;
                                    }
                                }


                            } else if (x > mairuplusLeft && x < mairuplusRight && y > mairuplusTop && y < mairuplusBottom) {
                                if (mairugp[3] < jiaoyiliang[3]) {
                                    mairugp[3] = mairugp[3] + 100;
                                }

                            } else if (x > mairuyesLeft && x < mairuyesRight && y > mairuyesTop && y < mairuyesBottom) {
                                gpnum[3].drawState = false;
                                chiyoushu[3] = chiyoushu[3] + mairugp[3];
                                jiaoyiliang[3] = jiaoyiliang[3] - mairugp[3];
                                moneyArray[personId][0] = moneyArray[personId][0] - (float) (chengjiaojia[3]) * mairugp[3];
                                mairugp[3] = 0;

                            } else if (x > mairunoLeft && x < mairunoRight && y > mairunoTop && y < mairunoBottom) {
                                gpnum[3].drawState = false;
                                mairugp[3] = 0;
                            }
                        }

                        if (gpnum[0].drawState == false && gpnum[1].drawState == false && gpnum[2].drawState == false && gpnum[3].drawState == false && gpnum[4].drawState == true
                                && gpnum[5].drawState == false && gpnum[6].drawState == false && gpnum[7].drawState == false && gpnum[8].drawState == false && gpnum[9].drawState == false) {

                            if (x > mairureduceLeft && x < mairureduceRight && y > mairureduceTop && y < mairureduceBottom) {
                                if (jiaoyiliang[4] > 0) {
                                    if (mairugp[4] > 0) {
                                        mairugp[4] = mairugp[4] - 100;
                                    }
                                }
                            } else if (x > mairuplusLeft && x < mairuplusRight && y > mairuplusTop && y < mairuplusBottom) {
                                if (mairugp[4] < jiaoyiliang[4]) {
                                    mairugp[4] = mairugp[4] + 100;
                                }

                            } else if (x > mairuyesLeft && x < mairuyesRight && y > mairuyesTop && y < mairuyesBottom) {
                                gpnum[4].drawState = false;
                                chiyoushu[4] = chiyoushu[4] + mairugp[4];
                                jiaoyiliang[4] = jiaoyiliang[4] - mairugp[4];
                                moneyArray[personId][0] = moneyArray[personId][0] - (float) (chengjiaojia[4]) * mairugp[4];
                                mairugp[4] = 0;

                            } else if (x > mairunoLeft && x < mairunoRight && y > mairunoTop && y < mairunoBottom) {
                                gpnum[4].drawState = false;
                                mairugp[4] = 0;
                            }
                        }

                        if (gpnum[0].drawState == false && gpnum[1].drawState == false && gpnum[2].drawState == false && gpnum[3].drawState == false && gpnum[4].drawState == false
                                && gpnum[5].drawState == true && gpnum[6].drawState == false && gpnum[7].drawState == false && gpnum[8].drawState == false && gpnum[9].drawState == false) {
                            if (x > mairureduceLeft && x < mairureduceRight && y > mairureduceTop && y < mairureduceBottom) {
                                if (maichugp[0] > 0) {
                                    maichugp[0] = maichugp[0] - 100;
                                }

                            } else if (x > mairuplusLeft && x < mairuplusRight && y > mairuplusTop && y < mairuplusBottom) {
                                if (chiyoushu[0] > 0) {
                                    if (maichugp[0] <= chiyoushu[0]) {
                                        maichugp[0] = maichugp[0] + 100;
                                    }
                                }

                            } else if (x > mairuyesLeft && x < mairuyesRight && y > mairuyesTop && y < mairuyesBottom) {
                                gpnum[5].drawState = false;
                                chiyoushu[0] = chiyoushu[0] - maichugp[0];
                                jiaoyiliang[0] = jiaoyiliang[0] + maichugp[0];
                                moneyArray[personId][0] = moneyArray[personId][0] + (float) chengjiaojia[0] * (float) (100 + zhangdie[0][0]) * 0.01f * maichugp[0];
                                maichugp[0] = 0;

                            } else if (x > mairunoLeft && x < mairunoRight && y > mairunoTop && y < mairunoBottom) {
                                gpnum[5].drawState = false;
                                maichugp[0] = 0;
                            }
                        }

                        if (gpnum[0].drawState == false && gpnum[1].drawState == false && gpnum[2].drawState == false && gpnum[3].drawState == false && gpnum[4].drawState == false
                                && gpnum[5].drawState == false && gpnum[6].drawState == true && gpnum[7].drawState == false && gpnum[8].drawState == false && gpnum[9].drawState == false) {
                            if (x > mairureduceLeft && x < mairureduceRight && y > mairureduceTop && y < mairureduceBottom) {
                                if (maichugp[1] > 0) {
                                    maichugp[1] = maichugp[1] - 100;
                                }

                            } else if (x > mairuplusLeft && x < mairuplusRight && y > mairuplusTop && y < mairuplusBottom) {
                                if (chiyoushu[1] > 0) {
                                    if (maichugp[1] < chiyoushu[1]) {
                                        maichugp[1] = maichugp[1] + 100;
                                    }
                                }

                            } else if (x > mairuyesLeft && x < mairuyesRight && y > mairuyesTop && y < mairuyesBottom) {
                                gpnum[6].drawState = false;
                                chiyoushu[1] = chiyoushu[1] - maichugp[1];
                                jiaoyiliang[1] = jiaoyiliang[1] + maichugp[1];
                                moneyArray[personId][0] = moneyArray[personId][0] + (float) chengjiaojia[1] * (float) (100 + zhangdie[1][0]) * 0.01f * maichugp[1];
                                maichugp[1] = 0;

                            } else if (x > mairunoLeft && x < mairunoRight && y > mairunoTop && y < mairunoBottom) {
                                gpnum[6].drawState = false;
                                maichugp[1] = 0;
                            }
                        }

                        if (gpnum[0].drawState == false && gpnum[1].drawState == false && gpnum[2].drawState == false && gpnum[3].drawState == false && gpnum[4].drawState == false
                                && gpnum[5].drawState == false && gpnum[6].drawState == false && gpnum[7].drawState == true && gpnum[8].drawState == false && gpnum[9].drawState == false) {
                            if (x > mairureduceLeft && x < mairureduceRight && y > mairureduceTop && y < mairureduceBottom) {
                                if (maichugp[2] > 0) {
                                    maichugp[2] = maichugp[2] - 100;
                                }

                            } else if (x > mairuplusLeft && x < mairuplusRight && y > mairuplusTop && y < mairuplusBottom) {
                                if (chiyoushu[2] > 0) {
                                    if (maichugp[2] < chiyoushu[2]) {
                                        maichugp[2] = maichugp[2] + 100;
                                    }
                                }
                            } else if (x > mairuyesLeft && x < mairuyesRight && y > mairuyesTop && y < mairuyesBottom) {
                                gpnum[7].drawState = false;
                                chiyoushu[2] = chiyoushu[2] - maichugp[2];
                                jiaoyiliang[2] = jiaoyiliang[2] + maichugp[2];
                                moneyArray[personId][0] = moneyArray[personId][0] + (float) chengjiaojia[2] * (float) (100 + zhangdie[2][0]) * 0.01f * maichugp[2];
                                maichugp[2] = 0;

                            } else if (x > mairunoLeft && x < mairunoRight && y > mairunoTop && y < mairunoBottom) {
                                gpnum[7].drawState = false;
                                maichugp[2] = 0;
                            }
                        }

                        if (gpnum[0].drawState == false && gpnum[1].drawState == false && gpnum[2].drawState == false && gpnum[3].drawState == false && gpnum[4].drawState == false
                                && gpnum[5].drawState == false && gpnum[6].drawState == false && gpnum[7].drawState == false && gpnum[8].drawState == true && gpnum[9].drawState == false) {
                            if (x > mairureduceLeft && x < mairureduceRight && y > mairureduceTop && y < mairureduceBottom) {
                                if (maichugp[3] > 0) {
                                    maichugp[3] = maichugp[3] - 100;
                                }

                            } else if (x > mairuplusLeft && x < mairuplusRight && y > mairuplusTop && y < mairuplusBottom) {
                                if (chiyoushu[3] > 0) {
                                    if (maichugp[3] < chiyoushu[3]) {
                                        maichugp[3] = maichugp[3] + 100;
                                    }
                                }

                            } else if (x > mairuyesLeft && x < mairuyesRight && y > mairuyesTop && y < mairuyesBottom) {
                                gpnum[8].drawState = false;
                                chiyoushu[3] = chiyoushu[3] - maichugp[3];
                                jiaoyiliang[3] = jiaoyiliang[3] + maichugp[3];
                                moneyArray[personId][0] = moneyArray[personId][0] + (float) chengjiaojia[3] * (float) (100 + zhangdie[3][0]) * 0.01f * maichugp[3];
                                maichugp[3] = 0;

                            } else if (x > mairunoLeft && x < mairunoRight && y > mairunoTop && y < mairunoBottom) {
                                gpnum[8].drawState = false;
                                maichugp[3] = 0;
                            }
                        }

                        if (gpnum[0].drawState == false && gpnum[1].drawState == false && gpnum[2].drawState == false && gpnum[3].drawState == false && gpnum[4].drawState == false
                                && gpnum[5].drawState == false && gpnum[6].drawState == false && gpnum[7].drawState == false && gpnum[8].drawState == false && gpnum[9].drawState == true) {

                            if (x > mairureduceLeft && x < mairureduceRight && y > mairureduceTop && y < mairureduceBottom) {
                                if (maichugp[4] > 0) {
                                    maichugp[4] = maichugp[4] - 100;
                                }

                            } else if (x > mairuplusLeft && x < mairuplusRight && y > mairuplusTop && y < mairuplusBottom) {
                                if (chiyoushu[4] > 0) {
                                    if (maichugp[4] < chiyoushu[4]) {
                                        maichugp[4] = maichugp[4] + 100;
                                    }
                                }

                            } else if (x > mairuyesLeft && x < mairuyesRight && y > mairuyesTop && y < mairuyesBottom) {
                                gpnum[9].drawState = false;
                                chiyoushu[4] = chiyoushu[4] - maichugp[4];
                                jiaoyiliang[4] = jiaoyiliang[4] + maichugp[4];
                                moneyArray[personId][0] = moneyArray[personId][0] + (float) chengjiaojia[4] * (float) (100 + zhangdie[4][0]) * 0.01f * maichugp[4];
                                maichugp[4] = 0;

                            } else if (x > mairunoLeft && x < mairunoRight && y > mairunoTop && y < mairunoBottom) {
                                gpnum[9].drawState = false;
                                maichugp[4] = 0;
                            }
                        }
                    }
                    //个人信息界面
                    else if (tr2dInfo[0].drawState == true && tr2dInfo[1].drawState == false && tr2dInfo[2].drawState == false && tr2dInfo[3].drawState == false) {
                        if (x > infoCloseLeft && x < infoCloseRight && y > infoCloseTop && y < infoCloseBottom) {
                            xuhua.drawState = false;
                            tr2dInfo[0].drawState = false;
                            gameView.soundOfButton();
                        } else if (x > infoRightLeft && x < infoRightRight && y > infoRightTop && y < infoRightBottom) {
                            System.out.println("第1个界面右边按钮");
                            tr2dInfo[0].drawState = false;
                            tr2dInfo[1].drawState = true;
                            gameView.soundOfButton();
                        }
                    } else if (tr2dInfo[0].drawState == false && tr2dInfo[1].drawState == true && tr2dInfo[2].drawState == false && tr2dInfo[3].drawState == false) {
                        if (x > infoCloseLeft && x < infoCloseRight && y > infoCloseTop && y < infoCloseBottom) {
                            xuhua.drawState = false;
                            tr2dInfo[1].drawState = false;
                            gameView.soundOfButton();
                        } else if (x > infoLeftLeft && x < infoLeftRight && y > infoLeftTop && y < infoLeftBottom) {
                            System.out.println("第二个界面左边按钮");
                            tr2dInfo[0].drawState = true;
                            tr2dInfo[1].drawState = false;
                            gameView.soundOfButton();
                        } else if (x > infoRightLeft && x < infoRightRight && y > infoRightTop && y < infoRightBottom) {
                            System.out.println("第二个界面右边按钮");
                            tr2dInfo[1].drawState = false;
                            tr2dInfo[2].drawState = true;
                            gameView.soundOfButton();
                        }

                    } else if (tr2dInfo[0].drawState == false && tr2dInfo[1].drawState == false && tr2dInfo[2].drawState == true && tr2dInfo[3].drawState == false) {
                        if (x > infoCloseLeft && x < infoCloseRight && y > infoCloseTop && y < infoCloseBottom) {
                            xuhua.drawState = false;
                            tr2dInfo[2].drawState = false;
                            gameView.soundOfButton();
                        } else if (x > infoLeftLeft && x < infoLeftRight && y > infoLeftTop && y < infoLeftBottom) {
                            System.out.println("第3个界面左边按钮");
                            tr2dInfo[1].drawState = true;
                            tr2dInfo[2].drawState = false;
                            gameView.soundOfButton();
                        } else if (x > infoRightLeft && x < infoRightRight && y > infoRightTop && y < infoRightBottom) {
                            System.out.println("第3个界面右边按钮");
                            tr2dInfo[2].drawState = false;
                            tr2dInfo[3].drawState = true;
                            gameView.soundOfButton();
                        }

                    } else if (tr2dInfo[0].drawState == false && tr2dInfo[1].drawState == false && tr2dInfo[2].drawState == false && tr2dInfo[3].drawState == true) {
                        if (x > infoCloseLeft && x < infoCloseRight && y > infoCloseTop && y < infoCloseBottom) {
                            xuhua.drawState = false;
                            tr2dInfo[3].drawState = false;
                            gameView.soundOfButton();
                        } else if (x > infoLeftLeft && x < infoLeftRight && y > infoLeftTop && y < infoLeftBottom) {
                            System.out.println("第4个界面左边按钮");
                            tr2dInfo[2].drawState = true;
                            tr2dInfo[3].drawState = false;
                            gameView.soundOfButton();
                        }
                    }

                    //设置界面
                    else  if (xuhua.drawState == true && tr2dSetMenu.drawState == true)
                   {
                        if (x > setbackLeft && x < setbackRight && y > setbackTop && y < setbackBottom) {
                            soundOfButton();
                            xuhua.drawState = false;
                            tr2dSetMenu.drawState = false;
                            tr2dSet[0].drawState = false;
                            tr2dSet[1].drawState = false;
                            tr2dSet[2].drawState = false;
                            tr2dSet[3].drawState = false;
                            tr2dSet[4].drawState = false;

                        } else if (x > setxuandanLeft && x < setxuandanRight && y > setxuandanTop && y < setxuandanBottom) {
                            soundOfButton();
                            startView = new StartView(ma, mv);
                            xuhua.drawState = false;
                            tr2dSetMenu.drawState = false;
                            tr2dSet[0].drawState = false;
                            tr2dSet[1].drawState = false;
                            tr2dSet[2].drawState = false;
                            tr2dSet[3].drawState = false;
                            tr2dSet[4].drawState = false;
                            currView = startView;
                        } else if (x > setMusicLeft && x < setMusicRight && y > setMusicTop && y < setMusicBottom) {
                            soundOfButton();
                            if (ismusic == true) {
                                tr2dSet[2].drawState = false;
                                tr2dSet[3].drawState = true;
                                ismusic = false;
                            } else {
                                tr2dSet[2].drawState = true;
                                tr2dSet[3].drawState = false;
                                ismusic = true;
                            }
                        }
                        //存档
                        else if (x > setcunchuLeft && x < setcunchuRight && y > setcunchuTop && y < setcunchuBottom) {
                            System.out.println("存档存档存档存档");
                            xuhua.drawState = true;
                            cundangView.drawState = true;
                            soundOfButton();
                            //获取一下当前存档状态
                            cundangState = GetCDState();
                            cundangState2 = GetCDState2();
                            cundangState3 = GetCDState3();
                            cundangState4 = GetCDState4();

                            year1 = GetCDTimeYear1();
                            month1 = GetCDTimeMonth1();
                            day1 = GetCDTimeDay1();
                            hour1 = GetCDTimeHour1();
                            min1 = GetCDTimeMin1();

                            year2 = GetCDTimeYear2();
                            month2 = GetCDTimeMonth2();
                            day2 = GetCDTimeDay2();
                            hour2 = GetCDTimeHour2();
                            min2 = GetCDTimeMin2();

                            year3 = GetCDTimeYear3();
                            month3 = GetCDTimeMonth3();
                            day3 = GetCDTimeDay3();
                            hour3 = GetCDTimeHour3();
                            min3 = GetCDTimeMin3();

                            year4 = GetCDTimeYear4();
                            month4 = GetCDTimeMonth4();
                            day4 = GetCDTimecdDay4();
                            hour4 = GetCDTimeHour4();
                            min4 = GetCDTimeMin4();
                        }

                   }
                    //存档界面
                    if (cundangView.drawState == true && fugai.drawState == false)
                    {
                        if (x > cunbackLeft && x < cunbackRight && y > cunbackTop && y < cunbackBottom)
                        {
                            cundangView.drawState = false;
                            soundOfButton();
                        } else if (x > cundang1Left && x < cundang1Right && y > cundang1Top && y < cundang1Bottom) {
                            coverCDState = 1;
                            soundOfButton();
                            //当前有存档
                            if (cundangState == 1) {
                                //显示是否覆盖当前存档
                                fugai.drawState = true;
                            } else {
                                cundangState = 1;
                                SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd/HH/mm");
                                Date date = new Date();
                                String s1 = f.format(date);
                                String s2[] = s1.split("/");
                                year1 = Integer.parseInt(s2[0]);
                                month1 = Integer.parseInt(s2[1]);
                                day1 = Integer.parseInt(s2[2]);
                                hour1 = Integer.parseInt(s2[3]);
                                min1 = Integer.parseInt(s2[4]);

                                CDPreferences.saveData();
                                WriteCDState(cundangState);
                                saveCD.drawState = true;
                                try {
                                    Thread.sleep(1000);
                                } catch (Exception e1) {
                                    e1.printStackTrace();
                                }
                                saveCD.drawState = false;
                            }

                            System.out.println("存储数据存储数据存储数据存储数据");
                        } else if (x > cundang2Left && x < cundang2Right && y > cundang2Top && y < cundang2Bottom) {
                            coverCDState = 2;
                            soundOfButton();
                            if (cundangState2 == 1) {
                                //显示是否覆盖当前存档
                                fugai.drawState = true;
                            } else {
                                cundangState2 = 1;
                                SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd/HH/mm");
                                Date date = new Date();
                                String s1 = f.format(date);
                                String s2[] = s1.split("/");
                                year2 = Integer.parseInt(s2[0]);
                                month2 = Integer.parseInt(s2[1]);
                                day2 = Integer.parseInt(s2[2]);
                                hour2 = Integer.parseInt(s2[3]);
                                min2 = Integer.parseInt(s2[4]);

                                CDPreferences.saveData2();
                                WriteCDState2(cundangState2);
                                saveCD.drawState = true;
                                try {
                                    Thread.sleep(1000);
                                } catch (Exception e1) {
                                    e1.printStackTrace();
                                }
                                saveCD.drawState = false;
                            }


                            System.out.println("存储数据存储数据存储数据存储数据");
                        } else if (x > cundang3Left && x < cundang3Right && y > cundang3Top && y < cundang3Bottom) {
                            coverCDState = 3;
                            soundOfButton();
                            if (cundangState3 == 1) {
                                //显示是否覆盖当前存档
                                fugai.drawState = true;
                            } else {
                                cundangState3 = 1;
                                SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd/HH/mm");
                                Date date = new Date();
                                String s1 = f.format(date);
                                String s2[] = s1.split("/");
                                year3 = Integer.parseInt(s2[0]);
                                month3 = Integer.parseInt(s2[1]);
                                day3 = Integer.parseInt(s2[2]);
                                hour3 = Integer.parseInt(s2[3]);
                                min3 = Integer.parseInt(s2[4]);
                                CDPreferences.saveData3();
                                WriteCDState3(cundangState3);
                                saveCD.drawState = true;
                                try {
                                    Thread.sleep(1000);
                                } catch (Exception e1) {
                                    e1.printStackTrace();
                                }
                                saveCD.drawState = false;
                            }

                            System.out.println("存储数据存储数据存储数据存储数据");
                        } else if (x > cundang4Left && x < cundang4Right && y > cundang4Top && y < cundang4Bottom) {
                            coverCDState = 4;
                            soundOfButton();
                            if (cundangState4 == 1) {
                                //显示是否覆盖当前存档
                                fugai.drawState = true;
                            } else {
                                cundangState4 = 1;
                                SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd/HH/mm");
                                Date date = new Date();
                                String s1 = f.format(date);
                                String s2[] = s1.split("/");
                                year4 = Integer.parseInt(s2[0]);
                                month4 = Integer.parseInt(s2[1]);
                                day4 = Integer.parseInt(s2[2]);
                                hour4 = Integer.parseInt(s2[3]);
                                min4 = Integer.parseInt(s2[4]);
                                CDPreferences.saveData4();
                                WriteCDState4(cundangState4);
                                saveCD.drawState = true;
                                try {
                                    Thread.sleep(1000);
                                } catch (Exception e1) {
                                    e1.printStackTrace();
                                }
                                saveCD.drawState = false;
                            }

                            System.out.println("存储数据存储数据存储数据存储数据");
                        }
                    }
                    //是否覆盖存档
                    else if (fugai.drawState == true) {
                        //覆盖存档
                        if (x > coverCunDangLeft && x < coverCunDangRight && y > coverCunDangTop && y < coverCunDangBottom) {
                            fugai.drawState = false;
                            soundOfButton();
                            if (coverCDState == 1) {
                                cundangState = 1;
                                SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd/HH/mm");
                                Date date = new Date();
                                String s1 = f.format(date);
                                String s2[] = s1.split("/");
                                year1 = Integer.parseInt(s2[0]);
                                month1 = Integer.parseInt(s2[1]);
                                day1 = Integer.parseInt(s2[2]);
                                hour1 = Integer.parseInt(s2[3]);
                                min1 = Integer.parseInt(s2[4]);

                                CDPreferences.saveData();
                                WriteCDState(cundangState);
                            } else if (coverCDState == 2) {
                                cundangState2 = 1;
                                SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd/HH/mm");
                                Date date = new Date();
                                String s1 = f.format(date);
                                String s2[] = s1.split("/");
                                year2 = Integer.parseInt(s2[0]);
                                month2 = Integer.parseInt(s2[1]);
                                day2 = Integer.parseInt(s2[2]);
                                hour2 = Integer.parseInt(s2[3]);
                                min2 = Integer.parseInt(s2[4]);

                                CDPreferences.saveData2();
                                WriteCDState2(cundangState2);
                            } else if (coverCDState == 3) {
                                cundangState3 = 1;
                                SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd/HH/mm");
                                Date date = new Date();
                                String s1 = f.format(date);
                                String s2[] = s1.split("/");
                                year3 = Integer.parseInt(s2[0]);
                                month3 = Integer.parseInt(s2[1]);
                                day3 = Integer.parseInt(s2[2]);
                                hour3 = Integer.parseInt(s2[3]);
                                min3 = Integer.parseInt(s2[4]);
                                CDPreferences.saveData3();
                                WriteCDState3(cundangState3);
                            } else if (coverCDState == 4) {
                                cundangState4 = 1;
                                SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd/HH/mm");
                                Date date = new Date();
                                String s1 = f.format(date);
                                String s2[] = s1.split("/");
                                year4 = Integer.parseInt(s2[0]);
                                month4 = Integer.parseInt(s2[1]);
                                day4 = Integer.parseInt(s2[2]);
                                hour4 = Integer.parseInt(s2[3]);
                                min4 = Integer.parseInt(s2[4]);
                                CDPreferences.saveData4();
                                WriteCDState4(cundangState4);
                            }
                            saveCD.drawState = true;
                            try {
                                Thread.sleep(1000);
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                            saveCD.drawState = false;
                            fugai.drawState = false;
                        }
                        //不覆盖存档
                        else if (x > nocoverCunDangLeft && x < nocoverCunDangRight && y > nocoverCunDangTop && y < nocoverCunDangBottom) {
                            fugai.drawState = false;
                            coverCDState = 0;
                            soundOfButton();
                        }
                    }

                    //银行界面
                    if (trbankmoney.drawState == true) {
                        if (x > closebankLeft && x < closebankRight && y > closebankTop && y < closebankBottom) {
                            trbankmoney.drawState = false;
                            gameView.soundOfButton();
                            xuhua.drawState = false;
                        }else if (x > bankjian1Left && x < bankjian1Right && y > bankjian1Top && y < bankjian1Bottom)
                        {
                            if (bankmoney>=1000)
                            {
                                bankmoney=bankmoney-1000;
                            }
                            soundOfButton();
                        }
                        else if (x > bankjia1Left && x < bankjia1Right && y > bankjia1Top && y < bankjia1Bottom)
                        {
                            bankmoney=bankmoney+1000;
                            soundOfButton();
                        }
                        else if (x > bankjian5Left && x < bankjian5Right && y > bankjian5Top && y < bankjian5Bottom)
                        {
                            soundOfButton();
                            if (bankmoney>=5000)
                            {
                                bankmoney=bankmoney-5000;
                            }
                        }
                        else if (x > bankjia5Left && x < bankjia5Right && y > bankjia5Top && y < bankjia5Bottom)
                        {
                            bankmoney=bankmoney+5000;
                            soundOfButton();
                        }else if (x > cunLeft && x < cunRight && y > cunTop && y < cunBottom)
                        {
                            if (bankmoney<moneyArray[personId][0])
                            {
                                moneyArray[personId][0]=moneyArray[personId][0]-bankmoney;
                                moneyArray[personId][1]=moneyArray[personId][1]+bankmoney;
                                trbankmoney.drawState=false;
                                xuhua.drawState = false;
                                soundOfButton();
                            }else
                            {
                                moneyNo.drawState=true;
                                soundOfMenu();
                                try
                                {
                                    Thread.sleep(2000);
                                }catch(Exception ep)
                                {
                                    ep.printStackTrace();
                                }
                                moneyNo.drawState=false;
                            }

                        }
                        else if (x > quLeft && x < quRight && y > quTop && y < quBottom)
                        {
                            if (bankmoney <moneyArray[personId][1])
                            {
                                moneyArray[personId][0]=moneyArray[personId][0]+bankmoney;
                                moneyArray[personId][1]=moneyArray[personId][1]-bankmoney;
                                trbankmoney.drawState=false;
                                xuhua.drawState = false;
                                soundOfButton();
                            }
                            else
                            {
                                moneyNo.drawState=true;
                                soundOfMenu();
                                try
                                {
                                    Thread.sleep(2000);
                                }catch(Exception ep)
                                {
                                    ep.printStackTrace();
                                }
                                moneyNo.drawState=false;
                            }

                        }
                    }


                    //购买商店触控
                    if (saleshopM.drawState == true) {
                        if (x > buynoLeft && x < buynoRight && y > buynoTop && y < buynoBottom) {
                            saleState = false;
                            saleshopM.drawState = false;
                            gameView.soundOfButton();
                        }
                        //购买按钮
                        else if (x > buyyesLeft && x < buyyesRight && y > buyyesTop && y < buyyesBottom) {
                            saleState = true;
                            saleshopM.drawState = false;
                            gameView.soundOfButton();
                            System.out.println("GmaeView saleState  " + saleState);
                        }
                    }
                    //购买加油站触控
                    if (salejyzM.drawState == true) {
                        if (x > buynoLeft && x < buynoRight && y > buynoTop && y < buynoBottom) {
                            saleState = false;
                            salejyzM.drawState = false;
                            gameView.soundOfButton();
                        }
                        //购买按钮
                        else if (x > buyyesLeft && x < buyyesRight && y > buyyesTop && y < buyyesBottom) {
                            saleState = true;
                            salejyzM.drawState = false;
                            gameView.soundOfButton();
                            System.out.println("GmaeView saleState  " + saleState);
                        }
                    }
                    //购买旅馆触控
                    if (salehotelM.drawState == true) {
                        if (x > buynoLeft && x < buynoRight && y > buynoTop && y < buynoBottom) {
                            saleState = false;
                            salehotelM.drawState = false;
                            gameView.soundOfButton();
                        }
                        //购买按钮
                        else if (x > buyyesLeft && x < buyyesRight && y > buyyesTop && y < buyyesBottom) {
                            saleState = true;
                            salehotelM.drawState = false;
                            gameView.soundOfButton();
                            System.out.println("GmaeView saleState  " + saleState);
                        }
                    }
                    //卡片商店 购买卡片
                    if (cardshop.drawState == true) {
                        //card1
                        if (x > card1Left && x < card1Right && y > card1Top && y < card1Bottom) {
                            System.out.println("choose card1");
                            salecardId = 0;
                            tr2dCard[0].drawState = true;
                            tr2dCard[1].drawState = false;
                            tr2dCard[2].drawState = false;
                            tr2dCard[3].drawState = false;
                            tr2dCard[4].drawState = false;
                            tr2dCard[5].drawState = false;
                            gameView.soundOfButton();
                        } else if (x > card2Left && x < card2Right && y > card2Top && y < card2Bottom) {
                            System.out.println("choose card2");
                            salecardId = 1;
                            tr2dCard[0].drawState = false;
                            tr2dCard[1].drawState = true;
                            tr2dCard[2].drawState = false;
                            tr2dCard[3].drawState = false;
                            tr2dCard[4].drawState = false;
                            tr2dCard[5].drawState = false;
                            gameView.soundOfButton();
                        } else if (x > card3Left && x < card3Right && y > card3Top && y < card3Bottom) {
                            System.out.println("choose card3");
                            salecardId = 2;
                            tr2dCard[0].drawState = false;
                            tr2dCard[1].drawState = false;
                            tr2dCard[2].drawState = true;
                            tr2dCard[3].drawState = false;
                            tr2dCard[4].drawState = false;
                            tr2dCard[5].drawState = false;
                            gameView.soundOfButton();
                        } else if (x > card4Left && x < card4Right && y > card4Top && y < card4Bottom) {
                            System.out.println("choose card4");
                            salecardId = 3;
                            tr2dCard[0].drawState = false;
                            tr2dCard[1].drawState = false;
                            tr2dCard[2].drawState = false;
                            tr2dCard[3].drawState = true;
                            tr2dCard[4].drawState = false;
                            tr2dCard[5].drawState = false;
                            gameView.soundOfButton();
                        } else if (x > card5Left && x < card5Right && y > card5Top && y < card5Bottom) {
                            System.out.println("choose card5");
                            salecardId = 4;
                            tr2dCard[0].drawState = false;
                            tr2dCard[1].drawState = false;
                            tr2dCard[2].drawState = false;
                            tr2dCard[3].drawState = false;
                            tr2dCard[4].drawState = true;
                            tr2dCard[5].drawState = false;
                            gameView.soundOfButton();
                        } else if (x > card6Left && x < card6Right && y > card6Top && y < card6Bottom) {
                            System.out.println("choose card6");
                            salecardId = 5;
                            tr2dCard[0].drawState = false;
                            tr2dCard[1].drawState = false;
                            tr2dCard[2].drawState = false;
                            tr2dCard[3].drawState = false;
                            tr2dCard[4].drawState = false;
                            tr2dCard[5].drawState = true;
                            gameView.soundOfButton();
                        }

                        //点击购买按钮
                        else if (x > salecardLeft && x < salecardRight && y > salecardTop && y < salecardBottom) {
                            //添加一张卡片 花费20点券
                            cardArray[personId][salecardId][0] = cardArray[personId][salecardId][0] + 1;
                            cardmoneyArray[personId] = cardmoneyArray[personId] - 20;
                            cardshop.drawState = false;
                            gameView.soundOfButton();
                            System.out.println("购买了一张卡片 花费了20点券");
                        }

                    }
                    //购买彩票
                    if (caipiao.drawState == true) {
                        if (x > closebagLeft && x < closeBagRight && y > closebagTop && y < closebagBottom) {
                            caipiao.drawState = false;
                            gameView.soundOfButton();
                        } else if (x > cp1Left && x < cp1Right && y > cp1Top && y < cp1Bottom) {
                            cpnumArray[1] = 1;
                        } else if (x > cp2Left && x < cp2Right && y > cp2Top && y < cp2Bottom) {
                            cpnumArray[1] = 2;
                        } else if (x > cp3Left && x < cp3Right && y > cp3Top && y < cp3Bottom) {
                            cpnumArray[1] = 3;
                        } else if (x > cp4Left && x < cp4Right && y > cp4Top && y < cp4Bottom) {
                            cpnumArray[1] = 4;
                        } else if (x > cp5Left && x < cp5Right && y > cp5Top && y < cp5Bottom) {
                            cpnumArray[1] = 5;
                        } else if (x > cp6Left && x < cp6Right && y > cp6Top && y < cp6Bottom) {
                            cpnumArray[1] = 6;
                        } else if (x > cp7Left && x < cp7Right && y > cp7Top && y < cp7Bottom) {
                            cpnumArray[1] = 7;
                        } else if (x > cp8Left && x < cp8Right && y > cp8Top && y < cp8Bottom) {
                            cpnumArray[1] = 8;
                        } else if (x > cp9Left && x < cp9Right && y > cp9Top && y < cp9Bottom) {
                            cpnumArray[1] = 9;
                        } else if (x > salecardLeft && x < salecardRight && y > salecardTop && y < salecardBottom) {
                            //购买彩票花费50
                            moneyArray[personId][0] = moneyArray[personId][0] - 50;
                            caipiao.drawState = false;
                        }

                    }
                    break;
                }
        }
        mPreviousX=x;
        mPreviousY=y;
        return !MoveStateArray[personId];
    }

    @Override
    public void drawView(GL10 gl)
    {

        GLES30.glClear( GLES30.GL_DEPTH_BUFFER_BIT | GLES30.GL_COLOR_BUFFER_BIT);//清除深度缓存  颜色缓存
        GLES30.glEnable(GLES30.GL_DEPTH_TEST);//打开深度测试
        GLES30.glEnable(GLES30.GL_CULL_FACE);
        currentView=GAMEVIEW;

        if (CameraState==true)
        {
            MatrixState3D.pushMatrix();
            MatrixState3D.setCamera(mVscale*cx, cy, mVscale*cz, mVscale*tx, ty, mVscale*tz, ux, uy, uz);
            MatrixState3D.popMatrix();
        }
        else if(CameraState==false)
        {
            MatrixState3D.pushMatrix();
            MatrixState3D.setCamera(mVscale*Fcx, Fcy, mVscale*Fcz, mVscale*Ftx, Fty, mVscale*Ftz, Fux, Fuy, Fuz);
            MatrixState3D.popMatrix();

        }

        if (loadState)
        {
            allScene.drawSelf();//绘制基本场景

            MatrixState2D.pushMatrix();
            menuButton.drawSelf();
            MatrixState2D.popMatrix();

        }

    }
    //每当人物停止运动时  调用该方法
    //判断 是否买地 升级等等
    //根据当前personId 以及 当前位置的标志位  来判断 是否要 掏钱等等
    //购买基本地皮 15000 特殊地皮 20000
    //路过他人地皮 过路费1000 特殊地皮1500
    //特殊地皮营业额 一个月30000
    public void changeSale(int currentRoadId)
    {
        //获取当前人物所在路的状态位
        if(currentRoadId == -1 )
        {
            System.out.println("当前人物没有状态");
        }
        else if(cubeRoadArrayList.get(currentRoadId)!=null)
        {

            roadState = cubeRoadArrayList.get(currentRoadId).getRoadState();
        }
        else
        {
            roadState=-1;
        }

        System.out.println(" 买地changeSale     当前路块id  "+currentRoadId+"     当前路块的状态     "+roadState);

        //为售卖地皮  商店 银行 加油站 卡片商店
        //花草树木等 公共建筑
        if(roadState==-1)
        {
            System.out.println("没反应没反应没反应");
        }
        //正在出售
        else if(roadState==0)
        {
            //当前人物游戏玩家时，显示2d图片 更新是否购买标志位
            System.out.println("绘制2D图片    是否购买该地皮");
            if(personId==1)
            {
                xuhua.drawState = true;
                rectangle2Ds[0].drawState=true;
                soundOfMenu();
                try
                {
                    Thread.sleep(3000);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                saleStateArray[personId] = saleState;
                rectangle2Ds[0].drawState=false;
                xuhua.drawState = false;
            }

            if(saleStateArray[personId]==true)
            {
                //福神作用
                if(shenxianArray[personId][0]==26)
                {
                    System.out.println("福神作用 买地便宜一半");
                    if(judgeMoney(1500))
                    {
                        if(personId!=1)
                        {
                            payhalf.drawState = true;
                            xuhua.drawState = true;
                            soundOfMenu();
                            try
                            {
                                Thread.sleep(2000);
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                            payhalf.drawState = false;
                            xuhua.drawState = false;
                        }
                        moneyArray[personId][0] = moneyArray[personId][0]-1500;
                        dipicount[personId] = dipicount[personId]+1;
                        //添加为不同的 人物标志模型
                        if(personId==0)
                        {
                            cubeRoadArrayList.get(currentRoadId).changeData(1,lovoBZMing,BZ_hongId,BZdata_P1[currentRoadId]);
                        }
                        else if(personId==1)
                        {
                            cubeRoadArrayList.get(currentRoadId).changeData(5,lovoBZMing,BZ_lanId,BZdata_P2[currentRoadId]);
                        }
                        else if(personId==2)
                        {
                            cubeRoadArrayList.get(currentRoadId).changeData(9,lovoBZMing,BZ_zongId,BZdata_P3[currentRoadId]);
                        }
                        else if(personId==3)
                        {
                            cubeRoadArrayList.get(currentRoadId).changeData(13,lovoBZMing,BZ_heId,BZdata_P4[currentRoadId]);
                        }
                        System.out.println("买地了买地了买地了");
                        //gameEndState = true;
                        soundOfUpHouse();
                        psdata[currentRoadArray[personId]-1][10]=1;
                        try
                        {
                            Thread.sleep(3000);
                            psdata[currentRoadArray[personId]-1][10]=0;
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                    //余额不足  无法购买
                    else
                    {

                    }
                }
                else
                {
                    //余额足够
                    if(judgeMoney(3000))
                    {
                        //电脑玩家
                        if(personId!=1)
                        {
                            payfor.drawState = true;
                            xuhua.drawState = true;
                            soundOfMenu();
                            try
                            {
                                Thread.sleep(2000);
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                            payfor.drawState = false;
                            xuhua.drawState = false;
                        }
                        moneyArray[personId][0] = moneyArray[personId][0]-3000;
                        dipicount[personId] = dipicount[personId]+1;
                        //添加为不同的 人物标志模型
                        if(personId==0)
                        {
                            cubeRoadArrayList.get(currentRoadId).changeData(1,lovoBZMing,BZ_hongId,BZdata_P1[currentRoadId]);
                        }
                        else if(personId==1)
                        {
                            cubeRoadArrayList.get(currentRoadId).changeData(5,lovoBZMing,BZ_lanId,BZdata_P2[currentRoadId]);
                        }
                        else if(personId==2)
                        {
                            cubeRoadArrayList.get(currentRoadId).changeData(9,lovoBZMing,BZ_zongId,BZdata_P3[currentRoadId]);
                        }
                        else if(personId==3)
                        {
                            cubeRoadArrayList.get(currentRoadId).changeData(13,lovoBZMing,BZ_heId,BZdata_P4[currentRoadId]);
                        }
                        System.out.println("买地了买地了买地了");
                        //gameEndState = true;
                        soundOfUpHouse();
                        psdata[currentRoadArray[personId]-1][10]=1;
                        try
                        {
                            Thread.sleep(3000);
                            psdata[currentRoadArray[personId]-1][10]=0;
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                    //余额不足 无法购买
                    else
                    {
                        saleerror.drawState = true;
                        try
                        {
                            Thread.sleep(2000);
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                        saleerror.drawState = false;
                    }
                }

            }

        }
        //----升级房屋 付过路费等-----//
        else if(roadState>=1&&roadState<=16)
        {
            if (roadState / 4 == personId)
            {
                if (roadState % 4 == 1)
                {
                    //游戏玩家 神仙附体
                    if(personId==1&&(shenxianArray[personId][0] == 27||shenxianArray[personId][0] ==30))
                    {
                        saleStateArray[personId] = true;
                    }
                    //游戏玩家 正常状态 才可以自己判定是否升级土地
                    else if(personId==1)
                    {
                        xuhua.drawState = true;
                        rectangle2Ds[1].drawState = true;
                        soundOfMenu();
                        try
                        {
                            Thread.sleep(2000);
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                        saleStateArray[personId] = saleState;
                        rectangle2Ds[1].drawState=false;
                        xuhua.drawState = false;
                    }

                    if (saleStateArray[personId] == true)
                    {
                        System.out.println("草皮升级为一层楼草皮升级为一层楼草皮升级为一层楼");
                        //天使产生作用
                        if (shenxianArray[personId][0] == 27)
                        {
                            xuhua.drawState = true;
                            tianshiup.drawState = true;
                            soundOfMenu();
                            try
                            {
                                Thread.sleep(2000);
                            }
                            catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                            tianshiup.drawState = false;
                            xuhua.drawState = false;
                            soundOfUpHouse();
                            psdata[currentRoadArray[personId]-1][10]=1;
                            try
                            {
                                Thread.sleep(3000);
                                psdata[currentRoadArray[personId]-1][10]=0;
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                            cubeRoadArrayList.get(currentRoadId).changeData(personId * 4 + 2, lovoHouse1, houseId, houselevel1[currentRoadId]);

                        }
                        //恶魔产生作用
                        else if (shenxianArray[personId][0] == 30)
                        {
                            System.out.println("恶魔产生作用，基本地皮不在降低");
                        }
                        //普通状态
                        else
                        {
                            if(judgeMoney(1000))
                            {
                                upfor1.drawState = true;
                                xuhua.drawState = true;
                                soundOfMenu();
                                try
                                {
                                    Thread.sleep(2000);
                                }
                                catch (Exception e)
                                {
                                    e.printStackTrace();
                                }
                                upfor1.drawState = false;
                                moneyArray[personId][0] = moneyArray[personId][0] - 1000;
                                xuhua.drawState = false;
                                soundOfUpHouse();
                                psdata[currentRoadArray[personId]-1][10]=1;
                                try
                                {
                                    Thread.sleep(3000);
                                    psdata[currentRoadArray[personId]-1][10]=0;
                                }
                                catch(Exception e)
                                {
                                    e.printStackTrace();
                                }
                                cubeRoadArrayList.get(currentRoadId).changeData(personId * 4 + 2, lovoHouse1, houseId, houselevel1[currentRoadId]);
                            }
                            else
                            {
                                //余额不足升级失败
                                uperror.drawState = true;
                                try
                                {
                                    Thread.sleep(1000);
                                }
                                catch (Exception e)
                                {
                                    e.printStackTrace();
                                }
                                uperror.drawState = false;
                            }
                        }
                    }
                }
                else if (roadState % 4 == 2)
                {
                    //当前人物游戏玩家时，显示2d图片 更新是否购买标志位
                    if(personId==1&&(shenxianArray[personId][0] == 27||shenxianArray[personId][0] ==30))
                    {
                        saleStateArray[personId] = true;
                    }
                    else if(personId==1)
                    {
                        xuhua.drawState = true;
                        rectangle2Ds[2].drawState = true;
                        soundOfMenu();
                        try
                        {
                            Thread.sleep(2000);
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                        saleStateArray[personId] = saleState;
                        rectangle2Ds[0].drawState=false;
                        xuhua.drawState = false;
                    }

                    if (saleStateArray[personId] == true)
                    {
                        System.out.println("草皮升级为2层草皮升级为2层草皮升级为2层");
                        if (shenxianArray[personId][0] == 27)
                        {
                            xuhua.drawState = true;
                            tianshiup.drawState = true;
                            soundOfMenu();
                            try
                            {
                                Thread.sleep(2000);
                            }
                            catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                            tianshiup.drawState = false;
                            xuhua.drawState = false;
                            soundOfUpHouse();
                            psdata[currentRoadArray[personId]-1][10]=1;
                            try
                            {
                                Thread.sleep(3000);
                                psdata[currentRoadArray[personId]-1][10]=0;
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                            cubeRoadArrayList.get(currentRoadId).changeData(personId * 4 + 3, lovoHouse2, houseId, houselevel2[currentRoadId]);
                        }
                        else if (shenxianArray[personId][0] == 30)
                        {
                            System.out.println("恶魔产生作用，地皮等级降低");
                            xuhua.drawState = true;
                            emodown.drawState = true;
                            soundOfMenu();
                            try
                            {
                                Thread.sleep(2000);
                            }
                            catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                            emodown.drawState = false;
                            xuhua.drawState = false;
                            soundOfUpHouse();
                            psdata[currentRoadArray[personId]-1][10]=1;
                            try
                            {
                                Thread.sleep(3000);
                                psdata[currentRoadArray[personId]-1][10]=0;
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                            cubeRoadArrayList.get(currentRoadId).changeData(personId * 4 + 2, lovoHouse1, houseId, houselevel1[currentRoadId]);
                        }
                        else
                        {
                            if(judgeMoney(1500))
                            {
                                xuhua.drawState = true;
                                upfor2.drawState = true;
                                soundOfMenu();
                                try
                                {
                                    Thread.sleep(2000);
                                }
                                catch (Exception e)
                                {
                                    e.printStackTrace();
                                }
                                upfor2.drawState = false;
                                moneyArray[personId][0] = moneyArray[personId][0] - 1500;
                                xuhua.drawState = false;
                                soundOfUpHouse();
                                psdata[currentRoadArray[personId]-1][10]=1;
                                try
                                {
                                    Thread.sleep(3000);
                                    psdata[currentRoadArray[personId]-1][10]=0;
                                }
                                catch(Exception e)
                                {
                                    e.printStackTrace();
                                }
                                cubeRoadArrayList.get(currentRoadId).changeData(personId * 4 + 3, lovoHouse2, houseId, houselevel2[currentRoadId]);
                            }
                            else
                            {
                                //余额不足升级失败
                                uperror.drawState = true;
                                try
                                {
                                    Thread.sleep(1000);
                                }
                                catch (Exception e)
                                {
                                    e.printStackTrace();
                                }
                                uperror.drawState = false;
                            }

                        }
                    }
                }
                else if (roadState % 4 == 3)
                {
                    //当前人物游戏玩家时，显示2d图片 更新是否购买标志位
                    if(personId==1&&(shenxianArray[personId][0] == 27||shenxianArray[personId][0] ==30))
                    {
                        saleStateArray[personId] = true;
                    }
                    else if(personId==1)
                    {
                        xuhua.drawState = true;
                        rectangle2Ds[1].drawState = true;
                        soundOfMenu();
                        try
                        {
                            Thread.sleep(2000);
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                        saleStateArray[personId] = saleState;
                        rectangle2Ds[0].drawState=false;
                        xuhua.drawState = false;
                    }

                    if (saleStateArray[personId] == true)
                    {
                        System.out.println("草皮升级为3层草皮升级为3层草皮升级为3层");
                        if(personId==1&&(shenxianArray[personId][0] == 27||shenxianArray[personId][0] ==30))
                        {
                            saleStateArray[personId] = true;
                        }
                        else if (shenxianArray[personId][0] == 27)
                        {
                            xuhua.drawState = true;
                            tianshiup.drawState = true;
                            soundOfMenu();
                            try
                            {
                                Thread.sleep(2000);
                            }
                            catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                            tianshiup.drawState = false;
                            xuhua.drawState = false;
                            soundOfUpHouse();
                            psdata[currentRoadArray[personId]-1][10]=1;
                            try
                            {
                                Thread.sleep(3000);
                                psdata[currentRoadArray[personId]-1][10]=0;
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                            cubeRoadArrayList.get(currentRoadId).changeData(personId * 4 + 4, lovoHouse3, houseId, houselevel3[currentRoadId]);
                        }
                        else if (shenxianArray[personId][0] == 30)
                        {
                            xuhua.drawState = true;
                            emodown.drawState = true;
                            soundOfMenu();
                            try
                            {
                                Thread.sleep(2000);
                            }
                            catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                            emodown.drawState = false;
                            System.out.println("恶魔产生作用，地皮等级降低");
                            xuhua.drawState = false;
                            soundOfUpHouse();
                            psdata[currentRoadArray[personId]-1][10]=1;
                            try
                            {
                                Thread.sleep(3000);
                                psdata[currentRoadArray[personId]-1][10]=0;
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                            cubeRoadArrayList.get(currentRoadId).changeData(personId * 4 + 3, lovoHouse2, houseId, houselevel2[currentRoadId]);
                        }
                        else
                        {
                            if(judgeMoney(2000))
                            {
                                xuhua.drawState = true;
                                upfor3.drawState = true;
                                soundOfMenu();
                                try
                                {
                                    Thread.sleep(2000);
                                }
                                catch (Exception e)
                                {
                                    e.printStackTrace();
                                }
                                upfor3.drawState = false;
                                moneyArray[personId][0] = moneyArray[personId][0] - 2000;
                                xuhua.drawState = false;
                                soundOfUpHouse();
                                psdata[currentRoadArray[personId]-1][10]=1;
                                try
                                {
                                    Thread.sleep(3000);
                                    psdata[currentRoadArray[personId]-1][10]=0;
                                }
                                catch(Exception e)
                                {
                                    e.printStackTrace();
                                }
                                cubeRoadArrayList.get(currentRoadId).changeData(personId * 4 + 4, lovoHouse3, houseId, houselevel3[currentRoadId]);
                                soundOfYanHua();

                                psdata[currentRoadArray[personId]-1][10]=2;
                                try
                                {
                                    Thread.sleep(6000);
                                    psdata[currentRoadArray[personId]-1][10]=0;
                                }
                                catch(Exception e)
                                {
                                    e.printStackTrace();
                                }
                            }
                            else
                            {
                                //余额不足升级失败
                                uperror.drawState = true;
                                try
                                {
                                    Thread.sleep(1000);
                                }
                                catch (Exception e)
                                {
                                    e.printStackTrace();
                                }
                                uperror.drawState = false;
                            }

                        }
                    }
                }
                else if (roadState % 4 == 0)
                {
                    if(shenxianArray[personId][0]==30)
                    {
                        System.out.println("恶魔产生作用，地皮等级降低");
                        xuhua.drawState = true;
                        emodown.drawState = true;
                        soundOfMenu();
                        try
                        {
                            Thread.sleep(2000);
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                        emodown.drawState = false;
                        cubeRoadArrayList.get(currentRoadId).changeData(personId * 4 + 4, lovoHouse3, houseId, houselevel3[currentRoadId]);
                        xuhua.drawState = false;
                    }
                }

            }
            //过路费
            else {
                if (roadState / 4 == 0)
                {//当前人物为1号人物
                    System.out.println("当前人物向一号人物付过路费");

                    if (roadState % 4 == 1)
                    {
                        payMoney(1);
                        moneyArray[personId][0] = moneyArray[personId][0] - guolufeiArray[0]*guolufeiState;
                        moneyArray[0][2] = moneyArray[0][2] + guolufeiArray[0]*guolufeiState;
                        System.out.println("当前人物向一号人物付过路费+一级过路费");
                    }
                    else if (roadState % 4 == 2)
                    {
                        payMoney(2);
                        moneyArray[personId][0] = moneyArray[personId][0] - guolufeiArray[1]*guolufeiState;
                        moneyArray[0][2] = moneyArray[0][2] + guolufeiArray[1]*guolufeiState;
                        System.out.println("当前人物向一号人物付过路费+二级过路费");
                    }
                    else if (roadState % 4 == 3)
                    {
                        payMoney(3);
                        moneyArray[personId][0] = moneyArray[personId][0] - guolufeiArray[2]*guolufeiState;
                        moneyArray[0][2] = moneyArray[0][2] + guolufeiArray[2]*guolufeiState;
                        System.out.println("当前人物向一号人物付过路费+三级过路费");
                    }
                    else if (roadState % 4 == 0)
                    {
                        payMoney(4);
                        moneyArray[personId][0] = moneyArray[personId][0] - guolufeiArray[3]*guolufeiState;
                        moneyArray[0][2] = moneyArray[0][2] + guolufeiArray[3]*guolufeiState;
                        System.out.println("当前人物向一号人物付过路费+四级过路费 ");
                    }
                }
                if (roadState / 4 == 1)
                {//当前人物为2号人物

                    System.out.println("当前人物向二号人物付过路费");
                    if (roadState % 4 == 1)
                    {
                        moneyArray[personId][0] = 200;
                        System.out.println("当前人物余额   "+moneyArray[personId][0]);
                        if(judgeMoney(250))
                        {
                            payMoney(1);
                            moneyArray[personId][0] = moneyArray[personId][0] - guolufeiArray[0]*guolufeiState;
                            moneyArray[1][2] = moneyArray[1][2] + guolufeiArray[0]*guolufeiState;
                            System.out.println("当前人物向二号人物付过路费+一级过路费");
                        }
                        else
                        {
                            System.out.println("当前人物余额不足 支付过路费失败 退出游戏 ");
                            //破产退出游戏
                            overId = personId;
                            pochan.drawState = true;
                            try
                            {
                                Thread.sleep(1000);
                            }
                            catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                            pochan.drawState = false;
                        }

                    }
                    else if (roadState % 4 == 2)
                    {
                        payMoney(2);
                        moneyArray[personId][0] = moneyArray[personId][0] - guolufeiArray[1]*guolufeiState;
                        moneyArray[1][2] = moneyArray[1][2] + guolufeiArray[1]*guolufeiState;
                        System.out.println("当前人物向二号人物付过路费+二级过路费");
                    }
                    else if (roadState % 4 == 3)
                    {
                        payMoney(3);
                        moneyArray[personId][0] = moneyArray[personId][0] - guolufeiArray[2]*guolufeiState;
                        moneyArray[1][2] = moneyArray[1][2] + guolufeiArray[2]*guolufeiState;
                        System.out.println("当前人物向二号人物付过路费+三级过路费");
                    }
                    else if (roadState % 4 == 0)
                    {
                        payMoney(4);
                        moneyArray[personId][0] = moneyArray[personId][0] - guolufeiArray[3]*guolufeiState;
                        moneyArray[1][2] = moneyArray[1][2] + guolufeiArray[3]*guolufeiState;
                        System.out.println("当前人物向二号人物付过路费+四级过路费 ");
                    }
                }
                if (roadState / 4 == 2)
                {//当前人物为3号人物

                    System.out.println("当前人物向三号人物付过路费");
                    if (roadState % 4 == 1)
                    {
                        payMoney(1);
                        moneyArray[personId][0] = moneyArray[personId][0] - guolufeiArray[0]*guolufeiState;
                        moneyArray[2][2] = moneyArray[2][2] + guolufeiArray[0]*guolufeiState;
                        System.out.println("当前人物向三号人物付过路费+一级过路费");
                    }
                    else if (roadState % 4 == 2)
                    {
                        payMoney(2);
                        moneyArray[personId][0] = moneyArray[personId][0] - guolufeiArray[1]*guolufeiState;
                        moneyArray[2][2] = moneyArray[2][2] + guolufeiArray[1]*guolufeiState;
                        System.out.println("当前人物向三号人物付过路费+二级过路费");
                    }
                    else if (roadState % 4 == 3)
                    {
                        payMoney(3);
                        moneyArray[personId][0] = moneyArray[personId][0] - guolufeiArray[2]*guolufeiState;
                        moneyArray[2][2] = moneyArray[2][2] + guolufeiArray[2]*guolufeiState;
                        System.out.println("当前人物向三号人物付过路费+三级过路费");
                    }
                    else if (roadState % 4 == 0)
                    {
                        payMoney(4);
                        moneyArray[personId][0] = moneyArray[personId][0] - guolufeiArray[3]*guolufeiState;
                        moneyArray[2][2] = moneyArray[2][2] + guolufeiArray[3]*guolufeiState;
                        System.out.println("当前人物向三号人物付过路费+四级过路费 ");
                    }
                }
                if (roadState / 4 == 3)
                {//当前人物为4号人物

                    System.out.println("当前人物向四号人物付过路费");
                    if (roadState % 4 == 1)
                    {
                        payMoney(1);
                        moneyArray[personId][0] = moneyArray[personId][0] - guolufeiArray[0]*guolufeiState;
                        moneyArray[3][2] = moneyArray[3][2] + guolufeiArray[0]*guolufeiState;
                        System.out.println("当前人物向四号人物付过路费+一级过路费");
                    }
                    else if (roadState % 4 == 2)
                    {
                        payMoney(2);
                        moneyArray[personId][0] = moneyArray[personId][0] - guolufeiArray[1]*guolufeiState;
                        moneyArray[3][2] = moneyArray[3][2] + guolufeiArray[1]*guolufeiState;
                        System.out.println("当前人物向四号人物付过路费+二级过路费");
                    }
                    else if (roadState % 4 == 3)
                    {
                        payMoney(3);
                        moneyArray[personId][0] = moneyArray[personId][0] - guolufeiArray[2]*guolufeiState;
                        moneyArray[3][2] = moneyArray[3][2] + guolufeiArray[2]*guolufeiState;
                        System.out.println("当前人物向四号人物付过路费+三级过路费");
                    }
                    else if (roadState % 4 == 0)
                    {
                        payMoney(4);
                        moneyArray[personId][0] = moneyArray[personId][0] - guolufeiArray[3]*guolufeiState;
                        moneyArray[3][2] = moneyArray[3][2] + guolufeiArray[3]*guolufeiState;
                        System.out.println("当前人物向四号人物付过路费+四级过路费 ");
                    }
                }
            }

        }
        //银行
        //只能取钱 不能存钱
        else if(roadState==17)
        {
            if(personId==0)
            {
                xuhua.drawState = true;
                trbankmoney.drawState=true;
                //getmoney.drawState =true;
                soundOfMenu();
//                try
//                {
//                    Thread.sleep(5000);
//                }
//                catch (Exception e )
//                {
//                    e.printStackTrace();
//                }
//                trbankmoney.drawState=false;
                //getmoney.drawState =false;
                //xuhua.drawState = false;
            }
            System.out.println("银行取钱银行取钱银行取钱");
            //gameEndState = true;


        }
        //卡片商店
        else if(roadState==18)
        {
            System.out.println("买卡片买卡片买卡片买卡片");
            //gameEndState = true;
            if(personId ==1)
            {
                xuhua.drawState = true;
                //购买卡片
                cardshop.drawState = true;
                soundOfMenu();
                try
                {
                    Thread.sleep(5000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                cardshop.drawState = false;
                xuhua.drawState = false;
            }
        }
        //特殊地皮
        // 商店
        else if(roadState==19)
        {
            xuhua.drawState = true;

            //当前特殊地皮的状态为正在出售 才可以进行购买
            if(shopState==0)
            {
                if(personId==1)
                {

                    saleshopM.drawState = true;
                    soundOfMenu();
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    saleshopM.drawState = true;
                    saleStateArray[personId] = saleState;
                }
                //电脑玩家
                else
                {
                    saleshopC.drawState = true;
                    soundOfMenu();
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    saleshopC.drawState = false;
                }
                if (saleStateArray[personId] == true)
                {
                    shopState = personId;
                    moneyArray[personId][0] = moneyArray[personId][0] - 5000;
                    System.out.println(personId + "购买商店地皮购买商店地皮购买商店地皮");
                }
            }
            else if(shopState==personId)
            {
                shopoff.drawState = true;
                soundOfMenu();
                try
                {
                    Thread.sleep(2000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                shopoff.drawState = false;
                System.out.println("商店盈利 提取钱");//每当路过商店时 提取营业额 赚钱
                moneyArray[personId][2] = moneyArray[personId][2] + 1000;
            }
            else if (shopState!=personId)
            {
                payshop.drawState = true;
                soundOfMenu();
                try
                {
                    Thread.sleep(2000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                payshop.drawState = false;
                //每次路过商店 消费500
                moneyArray[personId][0] = moneyArray[personId][0] -500;
                System.out.println("路过商店 进去购物，进行消费");
            }
            xuhua.drawState = false;

        }
        //加油站
        else if(roadState==20)
        {
            xuhua.drawState = true;

            if(oilStationState==0)
            {
                if (saleStateArray[personId]==true)
                {
                    //游戏玩家
                    if(personId==1)
                    {
                        salejyzM.drawState = true;
                        soundOfMenu();
                        try
                        {
                            Thread.sleep(2000);
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                        salejyzM.drawState = true;
                        saleStateArray[personId] = saleState;
                    }
                    //电脑玩家
                    else
                    {
                        salejyzC.drawState = true;
                        soundOfMenu();
                        try
                        {
                            Thread.sleep(2000);
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                        salejyzC.drawState = false;
                    }
                    oilStationState=personId;
                    moneyArray[personId][0] = moneyArray[personId][0]-5000;
                    System.out.println("购买加油站");
                }
            }
            else if (oilStationState==personId)
            {
                jyzoff.drawState = true;
                soundOfMenu();
                try
                {
                    Thread.sleep(2000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                jyzoff.drawState = false;
                moneyArray[personId][2] = moneyArray[personId][2] + 1000;
                System.out.println("加油站盈利");
            }
            else if (oilStationState!=personId)
            {
                payjyz.drawState = true;
                soundOfMenu();
                try
                {
                    Thread.sleep(2000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                payjyz.drawState = false;
                moneyArray[personId][0] = moneyArray[personId][0] -500;
                System.out.println("路过加油站 掏钱加油");
            }
            xuhua.drawState = false;
            System.out.println("加油站加油站加油站");
        }
        //motel
        else if (roadState==21)
        {
            xuhua.drawState = true;
            if (restaurantState==0)
            {
                //游戏玩家
                if(personId==1)
                {
                    salehotelM.drawState = true;
                    soundOfMenu();
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    salehotelM.drawState = true;
                    saleStateArray[personId] = saleState;
                }
                //电脑玩家
                else
                {
                    salehotelC.drawState = true;
                    soundOfMenu();
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    salehotelC.drawState = false;
                }
                if (saleStateArray[personId] == true)
                {
                    restaurantState=personId;
                    moneyArray[personId][0] = moneyArray[personId][0] -5000;
                    System.out.println("购买旅馆地皮");
                }
            }
            else if (restaurantState==personId)
            {
                hoteloff.drawState = true;
                soundOfMenu();
                try
                {
                    Thread.sleep(2000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                hoteloff.drawState = false;
                moneyArray[personId][2] = moneyArray[personId][2] + 1000;
                System.out.println("旅馆盈利");
            }
            else if(restaurantState!=personId)
            {
                payhotel.drawState = true;
                soundOfMenu();
                try
                {
                    Thread.sleep(2000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                payhotel.drawState = false;
                moneyArray[personId][0] = moneyArray[personId][0] - 500;
                System.out.println("路过旅馆 掏钱住宿 一次");
            }
            xuhua.drawState = false;
            //gameEndState = true;
        }
        //获得点券-------------------
        else if(roadState==22)
        {
            xuhua.drawState = true;
            get20.drawState=true;
            soundOfMenu();
            try
            {
                Thread.sleep(1000);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            get20.drawState=false;
            cardmoneyArray[personId] = cardmoneyArray[personId] + 20;
            System.out.println("获得20点券获得20点券获得20点券"+cardmoneyArray[personId]);
            //gameEndState = true;
            xuhua.drawState = false;
        }
        else if(roadState==23)
        {
            xuhua.drawState = true;
            get50.drawState=true;
            soundOfMenu();
            try
            {
                Thread.sleep(1000);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            get50.drawState=false;
            cardmoneyArray[personId] = cardmoneyArray[personId] + 50;
            System.out.println("获得50点券获得50点券获得50点券"+cardmoneyArray[personId]);
            xuhua.drawState = false;
        }

        //医院
        else if(roadState==24)
        {
            gohos.drawState = true;
            try
            {
                Thread.sleep(2000);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            gohos.drawState = false;
            //改变当前人物的数据
            hosStateArray[personId][0] = 24;
            hosStateArray[personId][1] = 12;
            //当前人物位置为改变为 医院建筑的位置
            locationDArray[personId][0] =12*Mapscale-0.5f*Mapscale;//x 坐标
            locationDArray[personId][2] = 2*Mapscale-0.5f*Mapscale;//z坐标
            locationDArray[personId][3]=180;//旋转角度
            currentRoadArray[personId]=22;//人物当前所在路快的id
            roadIdArray[personId]=3;//人物当前所在的id
            GoArray[personId]=2;//人物当前前进方向

            System.out.println("进医院进医院进医院 住院3天");
        }
        //9 种神仙
        //神仙作用时间都为3天
        //过路费作用  财神25  衰神28
        //建筑作用  天使27  恶魔30
        //福神26 买地便宜一半
        //25 ---- 31
        //财神 减少一半过路费
        else if(roadState==25)
        {
            xuhua.drawState = true;
            caishenM.drawState = true;
            soundOfMenu();
            try
            {
                Thread.sleep(2000);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            caishenM.drawState = false;
            //在之前播放神仙附体过程效果
            System.out.println("神仙附体 产生作用");
            xuhua.drawState = false;
            try
            {
                Thread.sleep(500);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

            godCaiShenState = true;
            for(int i=0;i<100000;i++)
            {
                System.out.println("改变财神位置");
                ScenesData.godflydata[0][0] = locationDArray[personId][0]-0.35f*Mapscale;
                ScenesData.godflydata[0][1] = (locationDArray[personId][1]*1.15f)+20f-0.0002f*i;
                ScenesData.godflydata[0][2] = locationDArray[personId][2];
            }
            godCaiShenState = false;

            //记录神仙状态
            shenxianArray[personId][0] = roadState;
//            shenxianArray[personId][1] = 3*4;
            //设置神仙作用天数
            shenxianArray[personId][1] = 3;
        }
        //福神 买地便宜一半
        else if(roadState==26)
        {
            xuhua.drawState = true;
            fushenM.drawState = true;
            soundOfMenu();
            try
            {
                Thread.sleep(2000);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            fushenM.drawState = false;
            shenxianArray[personId][0] = roadState;
            shenxianArray[personId][1] = 3*4;
            System.out.println("神仙附体 产生作用");
            xuhua.drawState = false;
        }
        //天使 免费加盖一层
        else if(roadState==27)
        {
            xuhua.drawState = true;
            tianshiM.drawState = true;
            soundOfMenu();
            try
            {
                Thread.sleep(2000);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            tianshiM.drawState = false;
            System.out.println("神仙附体 产生作用");
            xuhua.drawState = false;
            godTianShiState = true;
            for(int i=0;i<100000;i++)
            {
                System.out.println("改变财神位置");
                ScenesData.godflydata[0][0] = locationDArray[personId][0]-0.25f*Mapscale;
                ScenesData.godflydata[0][1] = (locationDArray[personId][1]*1.15f)+20f-0.0002f*i;
                ScenesData.godflydata[0][2] = locationDArray[personId][2];
            }
            godTianShiState = false;
            shenxianArray[personId][0] = roadState;
            shenxianArray[personId][1] = 3*4;
        }
        //衰神 双倍路费
        else if(roadState==28)
        {
            xuhua.drawState = true;
            shuaishenM.drawState = true;
            soundOfMenu();
            try
            {
                Thread.sleep(2000);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            shuaishenM.drawState = false;
            xuhua.drawState = false;
            godShuaiShenState = true;
            for(int i=0;i<100000;i++)
            {
                System.out.println("改变财神位置");
                ScenesData.godflydata[0][0] = locationDArray[personId][0]-0.35f*Mapscale;
                ScenesData.godflydata[0][1] = (locationDArray[personId][1]*1.15f)+20f-0.0002f*i;
                ScenesData.godflydata[0][2] = locationDArray[personId][2];
            }
            godShuaiShenState = false;
            shenxianArray[personId][0] = roadState;
            shenxianArray[personId][1] = 3*4;
            System.out.println("神仙附体 产生作用");

        }
        //穷神  总资产 少2000------
        else if(roadState==29)
        {
            shenxianArray[personId][0] = roadState;
            shenxianArray[personId][1] = 3*4;
            System.out.println("神仙附体 产生作用");
//            gameEndState = true;
        }
        //恶魔  房屋降低一层
        else if(roadState==30)
        {
            xuhua.drawState = true;
            emoM.drawState = true;
            soundOfMenu();
            try
            {
                Thread.sleep(2000);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            emoM.drawState = false;

            System.out.println("神仙附体 产生作用");
            xuhua.drawState = false;
            godEmoState = true;
            for(int i=0;i<100000;i++)
            {
                System.out.println("改变财神位置");
                ScenesData.godflydata[0][0] = locationDArray[personId][0]-0.25f*Mapscale;
                ScenesData.godflydata[0][1] = (locationDArray[personId][1]*1.15f)+20f-0.0002f*i;
                ScenesData.godflydata[0][2] = locationDArray[personId][2];
            }
            godEmoState = false;
            shenxianArray[personId][0] = roadState;
            shenxianArray[personId][1] = 3*4;
        }
        //土地  占领土地 现金不减少
        //总资产增加
        else if(roadState==31)
        {
            shenxianArray[personId][0] = roadState;
            shenxianArray[personId][1] = 3*4;
            System.out.println("神仙附体 产生作用");
//            gameEndState = true;
        }
        //彩票
        else if(roadState==32)
        {
            //游戏玩家购买彩票
            if(personId==1)
            {
                xuhua.drawState = true;
                caipiao.drawState = true;
                try
                {
                    Thread.sleep(5000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                caipiao.drawState = false;
                xuhua.drawState = false;
            }
            //电脑玩家购买彩票
            else
            {
                xuhua.drawState = true;
                if(personId==0)
                {
                    caipiaoP0.drawState = true;
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    caipiaoP0.drawState = false;
                    moneyArray[0][0] = moneyArray[0][0]-50;
                    cpnumArray[personId] = 4;
                }
                else if(personId==2)
                {
                    caipiaoP2.drawState = true;
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    caipiaoP2.drawState = false;
                    moneyArray[2][0] = moneyArray[2][0]-50;
                    cpnumArray[personId] = 7;
                }
                else if(personId==3)
                {
                    caipiaoP3.drawState = true;
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    caipiaoP3.drawState = false;
                    moneyArray[3][0] = moneyArray[3][0]-50;
                    cpnumArray[personId] = 9;
                }
                xuhua.drawState = false;
            }
            System.out.println("购买彩票购买彩票购买彩票    花费50元");
        }
        //将 关于人物的标志清除
        roadState = -1;
        currentRoadId = -1;
        nextgameState = false;
        if(personId==1)
        {
            saleStateArray[personId] = false;
            saleState = false;
        }
        System.out.println(huiheId+"        MoveState一个人物的回合结束, 将所有的状态全部清除"+huiheId%13);
        System.out.println("roadState  "+roadState+"currentRoadId    "+currentRoadId);

//        //彩票开奖
//        if(huiheId>=13&&huiheId%13==0)
//        {
//            openCaiPiao();
//            System.out.println("openCaiPiao   openCaiPiao");
//        }
        //如果下个人物不是 游戏玩家 自动进入下一个
        try
        {
            Thread.sleep(3000);
            //??
            if(((personId+1)%4)!=1)
            {
                shaiziState=true;
                System.out.println("moveThread  nextGamenextGamenextGame");
                moveThread = null;
                throwUtil.nextGame();
                //彩票开奖
                if(huiheId%28==0)
                {
                    openCaiPiao();
                    System.out.println("openCaiPiao   openCaiPiao");
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public void soundOfMenu()
    {
        if (ismusic)
        {
            MainActivity.sound.playMusic(SOUND_MenuView,0);//菜单弹出框声音
        }
    }
    public void soundOfButton()
    {
        if (ismusic)
        {
            MainActivity.sound.playMusic(SOUND_ClickBtn,0);//按钮点击声音
        }
    }
    public void soundOfUpHouse()
    {
        if (ismusic)
        {
            MainActivity.sound.playMusic(SOUND_UpHome,0);//按钮点击声音
        }
    }
    public void soundOfYanHua()
    {
        if (ismusic)
        {
            MainActivity.sound.playMusic(SOUND_YanHua,1);//按钮点击声音
        }
    }
    //金额判断
    public boolean judgeMoney(int money)
    {
        boolean sale=false;

        if(moneyArray[personId][0]>=money)
        {
            sale = true;
        }else {
            sale = false;
        }

        return sale;
    }

    //彩票开奖
    //判断四个人物的号码 显示图片
    public void openCaiPiao()
    {
        //本期中奖号码
        cpnum = (int)(Math.random()*8+1);
        kaijiang.drawState = true;
        try
        {
            Thread.sleep(2000);
        }catch(Exception e )
        {
            e.printStackTrace();
        }
        kaijiang.drawState = false;
        //获奖 彩票中奖获得1000元
        if(cpnum==cpnumArray[0])
        {
            getcp.drawState = true;
            moneyArray[0][0] = moneyArray[0][0]+1000;
            try
            {
                Thread.sleep(2000);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            getcp.drawState =false;

        }
        else if(cpnum==cpnumArray[1])
        {
            getcp.drawState = true;
            moneyArray[1][0] = moneyArray[1][0]+1000;
            try
            {
                Thread.sleep(2000);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            getcp.drawState =false;
        }
        else if(cpnum==cpnumArray[2])
        {
            getcp.drawState = true;
            moneyArray[2][0] = moneyArray[2][0]+1000;
            try
            {
                Thread.sleep(2000);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            getcp.drawState =false;
        }
        else if(cpnum==cpnumArray[3])
        {
            getcp.drawState = true;
            moneyArray[3][0] = moneyArray[3][0]+1000;
            try
            {
                Thread.sleep(2000);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            getcp.drawState =false;
        }
        //没人中奖
        else
        {
            nonegetcp.drawState = true;
            try
            {
                Thread.sleep(2000);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            nonegetcp.drawState =false;
        }
    }
    //支付过路费
    public void payMoney(int level)
    {
        switch (level)
        {
            case 1:
                //一级过路费
                if(shenxianArray[personId][0]==25)
                {
                    xuhua.drawState = true;
                    guolufeiState=0.5f;
                    payhalflevel1.drawState = true;
                    soundOfMenu();
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    payhalflevel1.drawState = false;
                    xuhua.drawState = false;
                }
                else if (shenxianArray[personId][0]==28)
                {
                    xuhua.drawState = true;
                    guolufeiState=2;
                    paydoublelevel1.drawState = true;
                    soundOfMenu();
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    paydoublelevel1.drawState = false;
                    xuhua.drawState = false;
                }
                else
                {
                    xuhua.drawState = true;
                    guolufeiState=1;
                    paylevel1.drawState = true;
                    soundOfMenu();
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    paylevel1.drawState = false;
                    xuhua.drawState = false;

                }
                break;
            case 2:
                if(shenxianArray[personId][0]==25)
                {
                    guolufeiState=0.5f;
                    xuhua.drawState = true;
                    payhalflevel2.drawState = true;
                    soundOfMenu();
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    payhalflevel2.drawState = false;
                    xuhua.drawState = false;
                }
                else if (shenxianArray[personId][0]==28)
                {
                    guolufeiState=2;
                    xuhua.drawState = true;
                    paydoublelevel2.drawState = true;
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    paydoublelevel2.drawState = false;
                    xuhua.drawState = false;
                }
                else
                {
                    guolufeiState=1;
                    xuhua.drawState = true;
                    paylevel2.drawState = true;
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    paylevel2.drawState = false;
                    xuhua.drawState = false;

                }
                break;
            case 3:
                if(shenxianArray[personId][0]==25)
                {
                    xuhua.drawState = true;
                    guolufeiState=0.5f;
                    payhalflevel3.drawState = true;
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    payhalflevel3.drawState = false;
                    xuhua.drawState = false;
                }
                else if (shenxianArray[personId][0]==28)
                {
                    xuhua.drawState = true;
                    guolufeiState=2;
                    paydoublelevel3.drawState = true;
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    paydoublelevel3.drawState = false;
                    xuhua.drawState = false;
                }
                else
                {
                    xuhua.drawState = true;
                    guolufeiState=1;
                    paylevel3.drawState = true;
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    paylevel3.drawState = false;
                    xuhua.drawState = false;

                }
                break;
            case 4:
                if(shenxianArray[personId][0]==25)
                {
                    xuhua.drawState = true;
                    guolufeiState=0.5f;
                    payhalflevel4.drawState = true;
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    payhalflevel4.drawState = false;
                    xuhua.drawState = false;
                }
                else if (shenxianArray[personId][0]==28)
                {
                    xuhua.drawState = true;
                    guolufeiState=2;
                    paydoublelevel4.drawState = true;
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    paydoublelevel4.drawState = false;
                    xuhua.drawState = false;
                }
                else
                {
                    xuhua.drawState = true;
                    guolufeiState=1;
                    paylevel4.drawState = true;
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    paylevel4.drawState = false;
                    xuhua.drawState = false;

                }
                break;
        }
    }
}
