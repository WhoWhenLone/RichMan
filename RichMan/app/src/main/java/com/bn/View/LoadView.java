package com.bn.View;

import android.annotation.TargetApi;
import android.opengl.GLES30;
import android.os.Build;
import android.view.MotionEvent;

import com.bn.Particle.ParticleDataConstant;
import com.bn.Particle.ParticleFireworkDataConstant;
import com.bn.Particle.ParticleFireworkForDraw;
import com.bn.Particle.ParticleFireworkSystem;
import com.bn.Particle.ParticleForDraw;
import com.bn.Particle.ParticleSystem;
import com.bn.RichMan.MainActivity;
import com.bn.RichMan.MyGLSurFaceView;
import com.bn.Scenes.AllScene;
import com.bn.Scenes.CubeRoad;
import com.bn.Scenes.Draw;
import com.bn.Scenes.MyCard;
import com.bn.Scenes.NumberForDraw;
import com.bn.Scenes.TextureRectangle2D;
import com.bn.Util.ThrowUtil;
import com.bn.Util.LoadUtil;
import com.bn.Util.MatrixState2D;
import com.bn.Util.TextureManager;
import com.bn.fbx.core.BNModel;
import javax.microedition.khronos.opengles.GL10;
import static com.bn.Constant.Constant.*;
import static com.bn.Constant.IdDataConstant.*;
import static com.bn.Constant.IdDataConstant.bagCardId;
import static com.bn.Constant.IdDataConstant.infoAllId;
import static com.bn.Constant.IdDataConstant.taxiId;
import static com.bn.Constant.IdDataConstant.weixiuId;
import static com.bn.Constant.IdDataConstant.yesId;
import static com.bn.Constant.LovoConstant.lovoTaxi;
import static com.bn.Constant.LovoConstant.lovoWeiXiu;
import static com.bn.RichMan.MyGLSurFaceView.*;
import static com.bn.Constant.LovoConstant.*;
import static com.bn.Scenes.ScenesData.*;

//加载资源界面 完成后 到 开始游戏界面
public class LoadView extends RMAbstractView {

    MyGLSurFaceView mv;
    MainActivity ma;
    int load_step=0;
    public  LoadView(MainActivity ma,MyGLSurFaceView mv)
    {
        TextureManager.loadingTexture(mv,0,TextureManager.texturesName.length);
        System.out.println("初始化纹理数据初始化纹理数据初始化纹理数据");
        this.mv=mv;
        this.ma=ma;
        richman=new TextureRectangle2D(mv,true);
        loadingtext=new TextureRectangle2D(this.mv,1.5f,8);
        loadbackground=new TextureRectangle2D(mv,5.0f,35);
        loadmove=new TextureRectangle2D(mv,3.3f,40);
        richmanId=TextureManager.getTextures("bg.png");
        jindutiaoId=TextureManager.getTextures("loading_inner.png");
        jinduId=TextureManager.getTextures("loading.png");
        jindutiaobgId=TextureManager.getTextures("lu0.png");
        loadingttextId=TextureManager.getTextures("loadingText.png");
    }
    @Override
    public void initView() {
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        return false;
    }

    @Override
    public void drawView(GL10 gl)
    {
        //清除颜色缓冲和深度缓冲
        GLES30.glClear(GLES30.GL_DEPTH_BUFFER_BIT
                | GLES30.GL_COLOR_BUFFER_BIT);
        if(!loadState)
        {
            drawLoadView();
        }
    }
    public void drawLoadView()
    {
        LoadSource();//加载资源
        //绘制加载界面等内容
        MatrixState2D.setProjectOrtho(-MyGLSurFaceView.ratio,MyGLSurFaceView.ratio,-1,1,1f,10);
        MatrixState2D.setCamera(0.0f,0.0f,3f,0.0f,0.0f,0.0f,0.0f,1.0f,0.0f);

        GLES30.glEnable(GLES30.GL_BLEND);
        GLES30.glDisable(GLES30.GL_DEPTH_TEST);

        GLES30.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        GLES30.glBlendFunc(GLES30.GL_SRC_ALPHA,GLES30.GL_ONE_MINUS_SRC_ALPHA);

        MatrixState2D.pushMatrix();
        MatrixState2D.translate(0f,-0.65f,1f);
        loadbackground.drawSelf(jindutiaobgId);
        MatrixState2D.popMatrix();

        MatrixState2D.pushMatrix();
        MatrixState2D.translate(0.0685f *load_step-1.8f , -0.68f, 1f);
        loadmove.drawSelf(jindutiaoId);//进度条
        MatrixState2D.popMatrix();


        MatrixState2D.pushMatrix();
        MatrixState2D.translate(0.12f,-0.68f,1.0f);
        loadingtext.drawSelf(loadingttextId);
        MatrixState2D.popMatrix();

        Draw.drawself2D(richman,richmanId,screenWidth/2,screenHeight/2,screenWidth,screenHeight,1);
        Draw.drawself2D(richman,logoId,screenWidth/2,screenHeight/3,screenWidth/3,screenHeight/2,1);

        GLES30.glDisable(GLES30.GL_BLEND);
        GLES30.glEnable(GLES30.GL_DEPTH_TEST);

    }

    public void LoadSource()
    {
        InitAllTexture(load_step);
        load_step++;
    }
    //加载本游戏所需的所有资源
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public void InitAllTexture(int index)
    {
        switch (index)
        {
            case 1:
                fireId=TextureManager.getTextures("fire.png");
                bgId= TextureManager.getTextures("bg1.png");
                logoId = TextureManager.getTextures("logo1.png");
                setId = TextureManager.getTextures("setting.png");
                helpId = TextureManager.getTextures("help.png");
                musicOnId = TextureManager.getTextures("voice.png");
                musicOffId = TextureManager.getTextures("voice_close.png");
                shop1Id = TextureManager.getTextures("gameshop.png");
                playId = TextureManager.getTextures("play.png");
                musicOffId = TextureManager.getTextures("voice_close.png");//开始界面
                svbgId = TextureManager.getTextures("svbg.png");
                renwuId = TextureManager.getTextures("role.png");
                backId = TextureManager.getTextures("back.png");
                startId = TextureManager.getTextures("playgame_m.png");
                continueId = TextureManager.getTextures("continue_m.png");
                readId = TextureManager.getTextures("read_m.png");//开始游戏界面
                bankmoneyId = TextureManager.getTextures("bankmoney.png");//银行存取钱
                wanjiaId = TextureManager.getTextures("wanjia.png");
                maohaoId = TextureManager.getTextures("maohao.png");

                buymap1Id = TextureManager.getTextures("buymap1.png");
                upmap1Id = TextureManager.getTextures("upmapfor1.png");
                upmap2Id = TextureManager.getTextures("upmapfor2.png");
                upmap3Id = TextureManager.getTextures("upmapfor3.png");
                noId = TextureManager.getTextures("no.png");
                yesId = TextureManager.getTextures("ok.png");//买地，升级界面

                goId = TextureManager.getTextures("go_light.png");
                datebgId = TextureManager.getTextures("date.png");
                numberId = TextureManager.getTextures("number1.png");

                bankCardId = TextureManager.getTextures("bankcard.png");
                cashId = TextureManager.getTextures("cash.png");
                coinId = TextureManager.getTextures("coin.png");//人物财产
                shaderId = TextureManager.getTextures("shader.png");


                gupiaoId = TextureManager.getTextures("gupiao.png");
                cardId = TextureManager.getTextures("card.png");
                infoId = TextureManager.getTextures("info.png");//右侧菜单
                infoAllId = TextureManager.getTextures("infoall.png");
                setMenuId = TextureManager.getTextures("settingMenu.png");
                xuandanId = TextureManager.getTextures("xuandan.png");
                buybtnId = TextureManager.getTextures("buybtn.png");

                touXiangId = TextureManager.getTextures("touxiang.png");
                datexId  = TextureManager.getTextures("xiegang.png");
                pzeroId = TextureManager.getTextures("pzero.png");
                poneId = TextureManager.getTextures("pone.png");
                ptwoId = TextureManager.getTextures("ptwo.png");
                pthreeId = TextureManager.getTextures("pthree.png");//人物头像


                up1Id = TextureManager.getTextures("upfor1.png");
                up2Id = TextureManager.getTextures("upfor2.png");
                up3Id = TextureManager.getTextures("upfor3.png");//系统人物买地升级

                dianquan20Id = TextureManager.getTextures("get20.png");
                dianquan50Id = TextureManager.getTextures("get50.png");
                payforId =TextureManager.getTextures("payfor.png");
                payhalfId = TextureManager.getTextures("payhalf.png");
                caishenMId = TextureManager.getTextures("caishenM.png");
                emoMId= TextureManager.getTextures("emoM.png");
                fushenMId = TextureManager.getTextures("fushenM.png");
                shuaishenMId = TextureManager.getTextures("shuaishenM.png");
                tianshiMId = TextureManager.getTextures("tianshiM.png");
                tianshiupId = TextureManager.getTextures("uplv.png");
                emodownId = TextureManager.getTextures("downlv.png");
                upfor1Id = TextureManager.getTextures("upfor1.png");
                upfor2Id = TextureManager.getTextures("upfor2.png");
                upfor3Id = TextureManager.getTextures("upfor3.png");
                paylevel1Id = TextureManager.getTextures("paylevel1.png");
                paylevel2Id = TextureManager.getTextures("paylevel2.png");
                paylevel3Id = TextureManager.getTextures("paylevel3.png");
                paylevel4Id = TextureManager.getTextures("paylevel4.png");
                payhalflevel1Id = TextureManager.getTextures("payhalflevel1.png");
                payhalflevel2Id = TextureManager.getTextures("payhalflevel2.png");
                payhalflevel3Id = TextureManager.getTextures("payhalflevel3.png");
                payhalflevel4Id = TextureManager.getTextures("payhalflevel4.png");
                paydoublelevel1Id = TextureManager.getTextures("paydoublelevel1.png");
                paydoublelevel2Id = TextureManager.getTextures("paydoublelevel2.png");
                paydoublelevel3Id = TextureManager.getTextures("paydoublelevel3.png");
                paydoublelevel4Id = TextureManager.getTextures("paydoublelevel4.png");

                payshopId = TextureManager.getTextures("payshop.png");
                saleshopMId = TextureManager.getTextures("saleshopM.png");
                saleshopCId = TextureManager.getTextures("saleshopC.png");
                shopoffId = TextureManager.getTextures("shopoff.png");
                payjyzId = TextureManager.getTextures("payjyz.png");
                salejyzMId = TextureManager.getTextures("salejyzM.png");
                salejyzCId = TextureManager.getTextures("salejyzC.png");
                jyzoffId = TextureManager.getTextures("jyzoff.png");
                payhotelId = TextureManager.getTextures("payhotel.png");
                salehotelMId = TextureManager.getTextures("salehotelM.png");
                salehotelCId = TextureManager.getTextures("salehotelC.png");
                hoteloffId = TextureManager.getTextures("hoteloff.png");
                cardshopId = TextureManager.getTextures("cardshopView.png");
                cardbagId = TextureManager.getTextures("cardbagView.png");
                bagCardId[0] = TextureManager.getTextures("yaokong.png");
                bagCardId[1] = TextureManager.getTextures("onepoint.png");
                bagCardId[2] = TextureManager.getTextures("sixpoint.png");
                bagCardId[3] = TextureManager.getTextures("stopcard.png");
                bagCardId[4] = TextureManager.getTextures("caishencard.png");
                bagCardId[5] = TextureManager.getTextures("fushencard.png");
                getmoneyId = TextureManager.getTextures("money.png");
                gohosId = TextureManager.getTextures("gohos.png");
                caipiaoId = TextureManager.getTextures("caipiao.png");
                caipiaoP0Id = TextureManager.getTextures("cpnum4.png");
                caipiaoP2Id = TextureManager.getTextures("cpnum7.png");
                caipiaoP3Id = TextureManager.getTextures("cpnum9.png");
                kaijiangId = TextureManager.getTextures("kaijiang.png");
                getcpId = TextureManager.getTextures("zhongjiang.png");
                nonegetcpId = TextureManager.getTextures("none.png");

                gpviewId = TextureManager.getTextures("GPView.png");
                gpnumId = TextureManager.getTextures("GPNum.png");
                plusId = TextureManager.getTextures("plus.png");
                reduceId = TextureManager.getTextures("reduce.png");
                jiaId = TextureManager.getTextures("jia.png");
                jianId = TextureManager.getTextures("jian.png");
                pointId = TextureManager.getTextures("point.png");
                xuhuaId = TextureManager.getTextures("xuhua.png");
                shijiaoId = TextureManager.getTextures("shijiao.png");

                selectleftId = TextureManager.getTextures("play_left.png");
                selectrightId = TextureManager.getTextures("play_right.png");

                numberGreenId = TextureManager.getTextures("numbers_green.png");
                numberRedId = TextureManager.getTextures("numbers_red.png");
                cunchuId = TextureManager.getTextures("cunchu.png");
                cundangViewId = TextureManager.getTextures("cundangView.png");
                saveCDId = TextureManager.getTextures("saveCD.png");

                mycardYKId = TextureManager.getTextures("myyaokong.png");
                mycardYDId = TextureManager.getTextures("myonepoint.png");
                mycardLDId = TextureManager.getTextures("mysixpoint.png");
                mycardTLId = TextureManager.getTextures("mystopcard.png");
                mycardCSId = TextureManager.getTextures("mycaishencard.png");
                mycardFSId = TextureManager.getTextures("myfushencard.png");

                fugaiId = TextureManager.getTextures("fugai.png");
                pochanId = TextureManager.getTextures("pochan.png");
                uperrorId = TextureManager.getTextures("uperror.png");
                saleerrorId = TextureManager.getTextures("saleerror.png");
                moneyNoId = TextureManager.getTextures("moneyno.png");
                noContinueId = TextureManager.getTextures("nocontinue.png");
                break;
            case 2:
                //筛子
                dian1Id= TextureManager.getTextures("1.png");
                dian2Id= TextureManager.getTextures("2.png");
                dian3Id= TextureManager.getTextures("3.png");
                dian4Id= TextureManager.getTextures("4.png");
                dian5Id= TextureManager.getTextures("5.png");
                dian6Id= TextureManager.getTextures("6.png");
                a1Id= TextureManager.getTextures("a1.png");
                a2Id= TextureManager.getTextures("a2.png");
                a3Id= TextureManager.getTextures("a3.png");
                a4Id= TextureManager.getTextures("a4.png");
                //获取纹理id
                hospitalId = TextureManager.getTextures("hospital.jpg");//医院
                dipiId = TextureManager.getTextures("dipi2.jpg");//正在出售的绿地
                onsaleId = TextureManager.getTextures("onsale.jpg");//正在出售
                roadZId = TextureManager.getTextures("roadZ.png");
                break;
            case 3:
                caopiId = TextureManager.getTextures("dipi.png");//草皮
                shopId = TextureManager.getTextures("shop.jpg");//商店
                oilStationId = TextureManager.getTextures("jiayouzhan.jpg");//加油站
                houseId = TextureManager.getTextures("housepic.jpg");//一级房屋 二级 三级
                //level2HouseId = TextureManager.getTextures("zonghe2.png");//二级房屋
                skyBoxId = TextureManager.getTextures("sky.png");//天空盒
                break;
            case 4:
                road20Id= TextureManager.getTextures("road20dq.png");//20点券
                road50Id= TextureManager.getTextures("road50dq.png");//50点券
                caishenId=TextureManager.getTextures("caishen.png");//财神地皮
                fushenId=TextureManager.getTextures("fushen.png");
                tianshiId=TextureManager.getTextures("tianshi.png");
                shuaishenId=TextureManager.getTextures("shuaishen.png");
                emoId=TextureManager.getTextures("emo.png");//恶魔地皮

                shopCubeId=TextureManager.getTextures("shopCube.jpg");//商店地皮
                bankCubeId=TextureManager.getTextures("bank.jpg");//银行地皮
                hospitalCubeId=TextureManager.getTextures("hospitalcube.jpg");//医院地皮
                break;
            case 5:
                //车贴图

                cheAId=TextureManager.getTextures("qicheA.png");
                cheBId=TextureManager.getTextures("qicheB.png");
                cheCId=TextureManager.getTextures("qicheC.png");
                shuinicheId=TextureManager.getTextures("shuiniche.png");//水泥车
                busStationId=TextureManager.getTextures("busStation.jpg");//公交站牌
                busId = TextureManager.getTextures("bus.jpg");//公交车
                taxiId=TextureManager.getTextures("taxi.png");//出租车
                weixiuId = TextureManager.getTextures("simple.png");//维修站
                motianlunId = TextureManager.getTextures("motianlun.png");//摩天轮
                redhouseId = TextureManager.getTextures("redhouse1.jpg");
                grayhouseId = TextureManager.getTextures("grayhouse.jpg");
                yellowhouseId = TextureManager.getTextures("yellowhouse.jpg");//基本房屋
                dashaId = TextureManager.getTextures("motianlun.png");
                motelId = TextureManager.getTextures("motel.jpg");//汽车旅馆
                chezhanId = TextureManager.getTextures("chezhan.jpg");//火车站
                tieguiId = TextureManager.getTextures("tiegui.jpg");//铁轨
                planeId = TextureManager.getTextures("plane.jpg");//飞机
                trainId = TextureManager.getTextures("huoche.jpg");//火车
                caopingId = TextureManager.getTextures("caoping.jpg");//摩天轮下的草坪

                fruitshopId = TextureManager.getTextures("fruitshop.jpg");//水果摊
                officeId = TextureManager.getTextures("office.jpg");//coffee店
                jiantouWId = TextureManager.getTextures("jiantouW.jpg");//箭头弯的
                jiantouZId = TextureManager.getTextures("jiantouZ.jpg");//直箭头

                //神仙方块
                caishenCubeId = TextureManager.getTextures("caishen.jpg");
                emoCubeId = TextureManager.getTextures("chibangEMO.png");
                fushenCubeId = TextureManager.getTextures("fushenCube.jpg");
                qiongshenCubeId = TextureManager.getTextures("qiongshenCube.png");
                shuaishenCubeId = TextureManager.getTextures("shuaishen.jpg");
                tianshiCubeId = TextureManager.getTextures("chibangTS.png");
                tudiCubeId = TextureManager.getTextures("tudiCube.png");
                youlingCubeId = TextureManager.getTextures("youlingCube.png");

                BZ_lanId = TextureManager.getTextures("BZ_lan.jpg");//人物标志
                BZ_hongId = TextureManager.getTextures("BZ_hong.jpg");
                BZ_zongId = TextureManager.getTextures("BZ_zong.jpg");
                BZ_heId = TextureManager.getTextures("BZ_he.jpg");
                shadowId = TextureManager.getTextures("shadow.png");//人物影子
                cpstationId = TextureManager.getTextures("cpstation.jpg");//彩票站


                break;
            case 6:
                //加载obj模型
                lovoHospital = LoadUtil.loadFromFile("hospital.obj",mv.getResources(),mv);
                lovoDiPi = LoadUtil.loadFromFile("dipi.obj",mv.getResources(),mv);
                lovoOnSale = LoadUtil.loadFromFile("onsale.obj",mv.getResources(),mv);
                lovoMapCube = LoadUtil.loadFromFile("mapcube.obj",mv.getResources(),mv);
                break;
            case 7:
                lovoShop = LoadUtil.loadFromFile("shop.obj",mv.getResources(),mv);
                lovoHouse1 = LoadUtil.loadFromFile("house1.obj",mv.getResources(),mv);
                lovoHouse2 = LoadUtil.loadFromFile("house2.obj",mv.getResources(),mv);
                lovoHouse3 = LoadUtil.loadFromFile("l3house.obj",mv.getResources(),mv);
                lovoOilStation = LoadUtil.loadFromFile("jiayouzhan.obj",mv.getResources(),mv);
                break;
            case 8:
                lovoBZMing = LoadUtil.loadFromFile("MingBZ.obj",mv.getResources(),mv);
                lovoBusStation=LoadUtil.loadFromFile("busStation.obj",mv.getResources(),mv);
                //车模型
                lovoQiche=LoadUtil.loadFromFile("qiche.obj",mv.getResources(),mv);
                lovoShuiniche=LoadUtil.loadFromFile("shuiniche.obj",mv.getResources(),mv);
                lovoTaxi=LoadUtil.loadFromFile("taxi.obj",mv.getResources(),mv);
                lovoBus =  LoadUtil.loadFromFile("bus.obj",mv.getResources(),mv);
                lovoWeiXiu = LoadUtil.loadFromFile("weixiu.obj",mv.getResources(),mv);
                lovoRedHoouse = LoadUtil.loadFromFile("redhouse1.obj",mv.getResources(),mv);
                lovoGrayHouse = LoadUtil.loadFromFile("grayhouse.obj",mv.getResources(),mv);
                lovoYellowHouse = LoadUtil.loadFromFile("yellowhouse.obj",mv.getResources(),mv);
                lovoDaSha = LoadUtil.loadFromFile("dasha.obj",mv.getResources(),mv);
                lovoMotel = LoadUtil.loadFromFile("motel.obj",mv.getResources(),mv);
                lovoCheZhan = LoadUtil.loadFromFile("chezhan.obj",mv.getResources(),mv);
                lovoTieGui = LoadUtil.loadFromFile("tiegui.obj",mv.getResources(),mv);
                lovoPlane = LoadUtil.loadFromFile("plane.obj",mv.getResources(),mv);
                lovoTrain = LoadUtil.loadFromFile("huoche.obj",mv.getResources(),mv);
                lovoCaoPing = LoadUtil.loadFromFile("caoping.obj",mv.getResources(),mv);
                lovoFruitShop = LoadUtil.loadFromFile("fruitshop.obj",mv.getResources(),mv);
                lovoOffice = LoadUtil.loadFromFile("office.obj",mv.getResources(),mv);
                lovoJianTouW = LoadUtil.loadFromFile("jiantouW.obj",mv.getResources(),mv);
                lovoGodCaiShen = LoadUtil.loadFromFile("caishen.obj",mv.getResources(),mv);
                lovoGodShuaiShen = LoadUtil.loadFromFile("shuaishen.obj",mv.getResources(),mv);
                lovoChiBang = LoadUtil.loadFromFile("chibang.obj",mv.getResources(),mv);
                lovoMTL_DZ = LoadUtil.loadFromFile("MTL_DZ.obj", mv.getResources(),mv);
                lovoMTL_ZL = LoadUtil.loadFromFile("MTL_ZL.obj", mv.getResources(),mv);
                lovoMTL_room1 = LoadUtil.loadFromFile("MTL_WZH.obj", mv.getResources(),mv);
                lovoMTL_room2 = LoadUtil.loadFromFile("MTL_WZRed.obj", mv.getResources(),mv);
                lovoMTL_room3 = LoadUtil.loadFromFile("MTL_WZH.obj", mv.getResources(),mv);
                lovoMTL_room4 = LoadUtil.loadFromFile("MTL_WZRed.obj", mv.getResources(),mv);
                lovoMTL_room5 = LoadUtil.loadFromFile("MTL_WZH.obj", mv.getResources(),mv);
                lovoMTL_room6 = LoadUtil.loadFromFile("MTL_WZRed.obj", mv.getResources(),mv);
                lovoMTL_room7 = LoadUtil.loadFromFile("MTL_WZH.obj", mv.getResources(),mv);
                lovoMTL_room8 = LoadUtil.loadFromFile("MTL_WZRed.obj", mv.getResources(),mv);
                lovoMTL_room9 = LoadUtil.loadFromFile("MTL_WZH.obj", mv.getResources(),mv);
                lovoMTL_room10 = LoadUtil.loadFromFile("MTL_WZRed.obj", mv.getResources(),mv);
                lovoMTL_room11 = LoadUtil.loadFromFile("MTL_WZH.obj", mv.getResources(),mv);
                lovoMTL_room12 = LoadUtil.loadFromFile("MTL_WZRed.obj", mv.getResources(),mv);
                fpfd=new ParticleForDraw(mv, ParticleDataConstant.RADIS[0]);
                fps=new ParticleSystem(ParticleDataConstant.positionFireXZ[0][0],
                        ParticleDataConstant.positionFireXZ[0][1],
                        ParticleDataConstant.positionFireXZ[0][2],fpfd,ParticleDataConstant.COUNT[0],0);

                fpfd1=new ParticleForDraw(mv, ParticleDataConstant.RADIS[1]);
                fps1=new ParticleSystem(ParticleDataConstant.positionFireXZ[0][0],
                        ParticleDataConstant.positionFireXZ[0][1],
                        ParticleDataConstant.positionFireXZ[0][2],fpfd1,ParticleDataConstant.COUNT[1],1);

                fpffd=new ParticleFireworkForDraw(mv, ParticleFireworkDataConstant.RADIS);
                fpfs=new ParticleFireworkSystem(ParticleFireworkDataConstant.positionFireXZ[0][0],
                        ParticleFireworkDataConstant.positionFireXZ[0][1],
                        ParticleFireworkDataConstant.positionFireXZ[0][2]
                        ,fpffd, ParticleFireworkDataConstant.COUNT);
                //------------------------------方块公路建设----------------------------//[0]
                break;
            case 9:
                //初始化基本 建筑  正在出售
                int j=0;
                for (int i=0;i<cubeRoadArray.length;i++)
                {
                    if((i>=7&&i<=15)||(i>=19&&i<=25)||(i>=38&&i<=46)||(i>=63&&i<=67)||(i>=69&&i<=84)||(i>=87&&i<=92))
                    {
                        cubeRoadArray[i] = new CubeRoad(i,0,lovoOnSale,onsaleId,onsaledata[j]);
                        j++;
                    }
                    else
                    {
                        cubeRoadArray[i] = null;
                    }
                }

                //初始化  特殊位置
//                cubeRoadArray[8]= new CubeRoad(8,1,lovoBZMing,BZ_hongId,BZdata_1[1]);
//                cubeRoadArray[9]= new CubeRoad(9,2,lovoHouse1,houseId,houselevel_1[2]);
//                cubeRoadArray[10]= new CubeRoad(10,3,lovoHouse2,houseId,houselevel_2[3]);
//                cubeRoadArray[13]= new CubeRoad(13,5,lovoBZMing,BZ_lanId,BZdata_2[6]);
//                cubeRoadArray[12] = new CubeRoad(12,32,lovoMapCube,cpstationId,ceshidata[0]);//彩票
//                cubeRoadArray[11] = new CubeRoad(11,17,lovoMapCube,bankCubeId,ceshidata[2]);//卡片商店
                //点券 20  2  4 32 34 36 48 50 58 60 95 97 99
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
                break;
            case 10:
                //bsy 16 18 29  55 102
                // bank  hospital shop bank shop
                cubeRoadArray[16] = new CubeRoad(16,17,lovoMapCube,bankCubeId,bsydata[1]);
                cubeRoadArray[18] = new CubeRoad(18,24,lovoMapCube,hospitalCubeId,bsydata[0]);
                cubeRoadArray[30] = new CubeRoad(30,18,lovoMapCube,shopCubeId,bsydata[2]);
                cubeRoadArray[56] = new CubeRoad(56,17,lovoMapCube,bankCubeId,bsydata[3]);
                cubeRoadArray[101] = new CubeRoad(101,18,lovoMapCube,shopCubeId,bsydata[4]);
                //cubeRoadArray[55] = new CubeRoad()
                break;
            case 11:
                //神仙的方块
                //  6  17 26 31  37  53  68 85 93
                //cubeRoadArray[6] = new CubeRoad(6,32,lovoMapCube,cpstationId,shenxiandata[0]);    //彩票站
                cubeRoadArray[6] = new CubeRoad(6,25,lovoMapCube,caishenId,shenxiandata[0]);    //财神
                cubeRoadArray[17] = new CubeRoad(17,25,lovoMapCube,caishenId,shenxiandata[1]);   //福神
                cubeRoadArray[26] = new CubeRoad(26,27,lovoMapCube,tianshiId,shenxiandata[2]);  //天使
                cubeRoadArray[31] = new CubeRoad(31,28,lovoMapCube,shuaishenId,shenxiandata[3]);//衰神
                cubeRoadArray[37] = new CubeRoad(37,25,lovoMapCube,caishenId,shenxiandata[4]);//财神
                cubeRoadArray[53] = new CubeRoad(53,25,lovoMapCube,caishenId,shenxiandata[5]);     //财神
                cubeRoadArray[68] = new CubeRoad(68,27,lovoMapCube,tianshiId,shenxiandata[6]);     //天使
                cubeRoadArray[85] = new CubeRoad(85,30,lovoMapCube,emoId,shenxiandata[7]);      //恶魔
                cubeRoadArray[93] = new CubeRoad(93,28,lovoMapCube,shuaishenId,shenxiandata[8]);  //衰神

//                //28  29  加油站
                cubeRoadArray[28] = new CubeRoad(28,20,lovoMapCube,jiantouZId,jiantoudata[0]);
                cubeRoadArray[29] = new CubeRoad(29,20,lovoJianTouW,jiantouWId,jiantoudata[1]);
                //54  55 商店
                cubeRoadArray[54] = new CubeRoad(54,19,lovoMapCube,jiantouZId,jiantoudata[2]);
                cubeRoadArray[55] = new CubeRoad(55,19,lovoJianTouW,jiantouWId,jiantoudata[3]);
                ///motel 102 103
                cubeRoadArray[102] = new CubeRoad(102,21,lovoMapCube,jiantouZId,jiantoudata[4]);
                cubeRoadArray[103] = new CubeRoad(103,21,lovoJianTouW,jiantouWId,jiantoudata[5]);
                for (int i=0;i<cubeRoadArray.length;i++)
                {
                    cubeRoadArrayList.add(cubeRoadArray[i]);

                }
                //初始 等级房屋 人物标志 数组
                j=0;
                for(int i=0;i<cubeRoadArray.length;i++)
                {
                    if((i>=7&&i<=15)||(i>=19&&i<=25)||(i>=38&&i<=46)||(i>=63&&i<=67)||(i>=69&&i<=84)||(i>=87&&i<=92))
                    {
                        houselevel1[i] = houselevel_1[j];
                        houselevel2[i] = houselevel_2[j];
                        houselevel3[i] = houselevel_3[j];
                        dipiarray[i] = onsaledata[j];
                        BZdata_P1[i] = BZdata_1[j];
                        BZdata_P2[i] = BZdata_2[j];
                        BZdata_P3[i] = BZdata_3[j];
                        BZdata_P4[i] = BZdata_4[j];
                        j++;
                    }
                    else
                    {
                        houselevel1[i] = null;
                        houselevel2[i] = null;
                        houselevel3[i] = null;
                        dipiarray[i] = null;
                        BZdata_P1[i] = null;
                        BZdata_P2[i] = null;
                        BZdata_P3[i] = null;
                        BZdata_P4[i] = null;
                    }
                }
                break;
            case 12:
                //骨骼动画 模型加载

                bnHongD = new BNModel("bngg/mingD.bnggdh","bnggpic/Per_hong.jpg",true,0.05f,mv);
                bnHongJ = new BNModel("bngg/mingJ.bnggdh","bnggpic/Per_hong.jpg",true,0,mv);

                bnLanD = new BNModel("bngg/mingD.bnggdh","bnggpic/Per_lan.jpg",true,0.05f,mv);
                bnLanJ = new BNModel("bngg/mingJ.bnggdh","bnggpic/Per_lan.jpg",true,0,mv);

                bnZongD = new BNModel("bngg/renzheD.bnggdh","bnggpic/Per_zong.jpg",true,0.05f,mv);
                bnZongJ = new BNModel("bngg/renzheJ.bnggdh","bnggpic/Per_zong.jpg",true,0,mv);

                bnHeD = new BNModel("bngg/renzheD.bnggdh","bnggpic/Per_he.jpg",true,0.05f,mv);
                bnHeJ = new BNModel("bngg/renzheJ.bnggdh","bnggpic/Per_he.jpg",true,0,mv);

                tr2Dmusic[0]=new TextureRectangle2D(mv,true);
                tr2Dmusic[1]=new TextureRectangle2D(mv,true);

                rectangle2Ds[0]=new TextureRectangle2D(mv,false);
                rectangle2Ds[1]=new TextureRectangle2D(mv,false);
                rectangle2Ds[2]=new TextureRectangle2D(mv,false);
                rectangle2Ds[3]=new TextureRectangle2D(mv,false);//人物买地升级

                rectangle2Ds[4]=new TextureRectangle2D(mv,false);//不能再升级

                trgo=new TextureRectangle2D(mv,true);//筛子
                trcardbag=new TextureRectangle2D(mv,false);//卡片背包
                tr2Dbmenu[0]=new TextureRectangle2D(mv,true);//卡片
                tr2Dbmenu[1]=new TextureRectangle2D(mv,true);//股票
                tr2Dbmenu[2]=new TextureRectangle2D(mv,true);//个人信息
                tr2Dbmenu[3]=new TextureRectangle2D(mv,true);//设置

                tr2dInfo[0]=new TextureRectangle2D(mv,false);
                tr2dInfo[1]=new TextureRectangle2D(mv,false);
                tr2dInfo[2]=new TextureRectangle2D(mv,false);
                tr2dInfo[3]=new TextureRectangle2D(mv,false);

                tr2dSetMenu=new TextureRectangle2D(mv,false);
                tr2dSet[0]=new TextureRectangle2D(mv,false);
                tr2dSet[1]=new TextureRectangle2D(mv,false);
                tr2dSet[2]=new TextureRectangle2D(mv,false);
                tr2dSet[3]=new TextureRectangle2D(mv,false);
                tr2dSet[4]=new TextureRectangle2D(mv,false);

                tr2dCard[0]=new TextureRectangle2D(mv,false);
                tr2dCard[1]=new TextureRectangle2D(mv,false);
                tr2dCard[2]=new TextureRectangle2D(mv,false);
                tr2dCard[3]=new TextureRectangle2D(mv,false);
                tr2dCard[4]=new TextureRectangle2D(mv,false);
                tr2dCard[5]=new TextureRectangle2D(mv,false);
                moneyNo=new TextureRectangle2D(mv,false);
                noContinue =new TextureRectangle2D(mv,false);

                tr2Dperson =new TextureRectangle2D(mv,true);//pzero

                trbankmoney=new TextureRectangle2D(mv,false);//银行存取钱

                money=new NumberForDraw(10,moneychangdu,moneykuandu,mv);
                cp=new NumberForDraw(10,cpnumchang,cpnumkuan,mv);
                gp=new NumberForDraw(10,gpnumberchang,gpnumberkuan,mv);
                cardNum=new NumberForDraw(10,cardNumchangdu,cardNumkuandu,mv);
                shaizi=new TextureRectangle2D(mv,false);
                get20 = new TextureRectangle2D(mv,false);
                get50 = new TextureRectangle2D(mv,false);
                payfor = new TextureRectangle2D(mv,false);
                payhalf = new TextureRectangle2D(mv,false);
                caishenM = new TextureRectangle2D(mv,false);
                emoM = new TextureRectangle2D(mv,false);
                fushenM = new TextureRectangle2D(mv,false);
                shuaishenM = new TextureRectangle2D(mv,false);
                tianshiM = new TextureRectangle2D(mv,false);
                tianshiup = new TextureRectangle2D(mv,false);
                emodown = new TextureRectangle2D(mv,false);
                upfor1 = new TextureRectangle2D(mv,false);
                upfor2 = new TextureRectangle2D(mv,false);
                upfor3 = new TextureRectangle2D(mv,false);
                paylevel1 = new TextureRectangle2D(mv,false);
                paylevel2 = new TextureRectangle2D(mv,false);
                paylevel3 = new TextureRectangle2D(mv,false);
                paylevel4 = new TextureRectangle2D(mv,false);
                payhalflevel1 = new TextureRectangle2D(mv,false);
                payhalflevel2 = new TextureRectangle2D(mv,false);
                payhalflevel3 = new TextureRectangle2D(mv,false);
                payhalflevel4 = new TextureRectangle2D(mv,false);
                paydoublelevel1 = new TextureRectangle2D(mv,false);
                paydoublelevel2 = new TextureRectangle2D(mv,false);
                paydoublelevel3 = new TextureRectangle2D(mv,false);
                paydoublelevel4 = new TextureRectangle2D(mv,false);
                payshop = new TextureRectangle2D(mv,false);
                saleshopM = new TextureRectangle2D(mv,false);
                saleshopC = new TextureRectangle2D(mv,false);
                shopoff = new TextureRectangle2D(mv,false);
                payjyz = new TextureRectangle2D(mv,false);
                salejyzM = new TextureRectangle2D(mv,false);
                salejyzC = new TextureRectangle2D(mv,false);
                jyzoff = new TextureRectangle2D(mv,false);
                payhotel = new TextureRectangle2D(mv,false);
                salehotelM = new TextureRectangle2D(mv,false);
                salehotelC = new TextureRectangle2D(mv,false);
                hoteloff = new TextureRectangle2D(mv,false);
                cardshop = new TextureRectangle2D(mv,false);
                getmoney = new TextureRectangle2D(mv,false);
                gohos = new TextureRectangle2D(mv,false);

                caipiao = new TextureRectangle2D(mv,false);
                caipiaoP0 = new TextureRectangle2D(mv,false);
                caipiaoP2 = new TextureRectangle2D(mv,false);
                caipiaoP3 = new TextureRectangle2D(mv,false);

                kaijiang = new TextureRectangle2D(mv,false);
                getcp = new TextureRectangle2D(mv,false);
                nonegetcp = new TextureRectangle2D(mv,false);
                gpview = new TextureRectangle2D(mv,false);
                gpnum[0] = new TextureRectangle2D(mv,false);
                gpnum[1] = new TextureRectangle2D(mv,false);
                gpnum[2] = new TextureRectangle2D(mv,false);
                gpnum[3] = new TextureRectangle2D(mv,false);
                gpnum[4] = new TextureRectangle2D(mv,false);
                gpnum[5] = new TextureRectangle2D(mv,false);
                gpnum[6] = new TextureRectangle2D(mv,false);
                gpnum[7] = new TextureRectangle2D(mv,false);
                gpnum[8] = new TextureRectangle2D(mv,false);
                gpnum[9] = new TextureRectangle2D(mv,false);

                gpmai[0] = new TextureRectangle2D(mv,true);
                gpmai[1] = new TextureRectangle2D(mv,true);
                gpj[0] = new TextureRectangle2D(mv,true);
                gpj[1] = new TextureRectangle2D(mv,true);

                xuhua = new TextureRectangle2D(mv,false);
                shijiao = new TextureRectangle2D(mv,true);
                cundangView = new TextureRectangle2D(mv,false);
                saveCD = new TextureRectangle2D(mv,false);
                fugai = new TextureRectangle2D(mv,false);
                pochan = new TextureRectangle2D(mv,false);
                uperror = new TextureRectangle2D(mv,false);
                saleerror = new TextureRectangle2D(mv,false);
                mycardYK = new MyCard(mv,false);
                mycardYD = new MyCard(mv,false);
                mycardLD = new MyCard(mv,false);
                mycardTL = new MyCard(mv,false);
                mycardCS = new MyCard(mv,false);
                mycardFS = new MyCard(mv,false);


                break;
            case 13:
                //初始人物骨骼
                personArray[0][0]=bnHongD;
                personArray[0][1]=bnHongJ;

                personArray[1][0]=bnLanD;
                personArray[1][1]=bnLanJ;

                personArray[2][0]=bnZongD;
                personArray[2][1]=bnZongJ;

                personArray[3][0]=bnHeD;
                personArray[3][1]=bnHeJ;
                //初始人物神仙模型贴图数组
                picGodArray[0] = caishenCubeId;
                picGodArray[1] = fushenCubeId;
                picGodArray[2] = tianshiCubeId;
                picGodArray[3] = shuaishenCubeId;
                picGodArray[4] = qiongshenCubeId;
                picGodArray[5] = emoCubeId;
                picGodArray[6] = tudiCubeId;

                //cun
                locationDArray[0] = new float[]{1.5f*Mapscale,2.85f*Mapscale,2.5f*Mapscale,0};
                locationDArray[1] = new float[]{2.5f*Mapscale,2.85f*Mapscale,-8.5f*Mapscale,270};
                locationDArray[2] = new float[]{-1.5f*Mapscale,2.85f*Mapscale,-4.5f*Mapscale,0};
                locationDArray[3] = new float[]{8.5f*Mapscale,2.85f*Mapscale,-8.5f*Mapscale,270};

                locationJArray[0] = new float[]{1.5f*Mapscale,2.85f*Mapscale,2.5f*Mapscale,0};
                locationJArray[1] = new float[]{2.5f*Mapscale,2.85f*Mapscale,-8.5f*Mapscale,270};
                locationJArray[2] = new float[]{-1.5f*Mapscale,2.85f*Mapscale,-4.5f*Mapscale,0};
                locationJArray[3] = new float[]{8.5f*Mapscale,2.85f*Mapscale,-8.5f*Mapscale,270};

                //当前人物在那条路
                roadIdArray = new int[]{1,6,7,6};//cun
                //当前人物在那块路
                currentRoadArray = new int[]{1,43,51,37};//cun

                for(int i=0;i<4;i++)
                {
                    for(int l=0;l<6;l++)
                    {
                        cardArray[i][l][0] = 0;
                    }
                }
                saleStateArray[playerId] = false;
                throwUtil = new ThrowUtil();
                persontxArray[0] = pzeroId;
                persontxArray[1] = poneId;
                persontxArray[2] = ptwoId;
                persontxArray[3] = pthreeId;
//                P1_shadow = new Shadow(mv);
//                P2_shadow = new Shadow(mv);
//                P3_shadow = new Shadow(mv);
//                P4_shadow = new Shadow(mv);
//                shadowArray[0] = P1_shadow;
//                shadowArray[1] = P2_shadow;
//                shadowArray[2] = P3_shadow;
//                shadowArray[3] = P4_shadow;
                break;
            case 14:
                allScene = new AllScene(mv);
                break;
            case 15:
                System.out.println("加载资源完毕加载资源完毕加载资源完毕加载资源完毕");
                //上帝视角
                cx=locationDArray[1][0]/Mapscale-11;//摄像机x位置
                cy=8.5f*Mapscale;//摄像机y位置`
                cz=locationDArray[1][2]/Mapscale+11;//摄像机z位置0
                tx=cx+11;//目标点x位置
                ty=2.5f*Mapscale;//目标点y位置
                tz=cz-11;//目标点z位置
                ux=2;//up向量
                uy=2;
                uz=-2;

                //第一人称视角
                Fcx=locationDArray[1][0]/Mapscale+3.65f;//摄像机x位置
                Fcy=3.5f*Mapscale;//摄像机y位置
                Fcz=locationDArray[1][2]/Mapscale-5.6f;//摄像机z位置0
                Ftx=Fcx-10;//目标点x位置
                Fty=Fcy*0.7f;//目标点y位置
                Ftz=Fcz;//目标点z位置
                Fux=0;//up向量
                Fuy=1;
                break;
            case 16:
                menuButton=new MenuButton(mv);
                //加载完毕 跳转到游戏界面
                startView = new StartView(ma,mv);
                gameView=new GameView(ma,mv);
                currView=startView;
                //currView=gameView;
                System.out.println("跳转界面跳转界面跳转界面");
                loadState=true;
                //MoveState=false;
                break;
        }

    }
}
