package com.bn.Constant;

import com.bn.Scenes.MyCard;
import com.bn.Scenes.NumberForDraw;
import com.bn.Scenes.RectMap;
import com.bn.Scenes.Shadow;
import com.bn.Scenes.SkyBox;
import com.bn.Scenes.TextureRectangle2D;
import com.bn.Util.LoadedObjectVertexNormalTexture;
import com.bn.fbx.core.BNModel;

//加载的obj模型的常量类
public class LovoConstant {
    //基本模型  场景
    public static LoadedObjectVertexNormalTexture lovoHospital;

    public static LoadedObjectVertexNormalTexture lovoDiPi;
    public static LoadedObjectVertexNormalTexture lovoOnSale;
    public static LoadedObjectVertexNormalTexture lovoMapCube;

    public static LoadedObjectVertexNormalTexture lovoShop;

    public static LoadedObjectVertexNormalTexture lovoHouse1;
    public static LoadedObjectVertexNormalTexture lovoHouse2;
    public static LoadedObjectVertexNormalTexture lovoHouse3;
    public static LoadedObjectVertexNormalTexture lovoOilStation;
    public static LoadedObjectVertexNormalTexture lovoBZMing;
    public static LoadedObjectVertexNormalTexture lovoBZP3;
    public static LoadedObjectVertexNormalTexture lovoBZP4;
    //车
    public static LoadedObjectVertexNormalTexture lovoQiche;
    public static LoadedObjectVertexNormalTexture lovoShuiniche;
    public  static LoadedObjectVertexNormalTexture lovoBusStation;
    public static LoadedObjectVertexNormalTexture lovoBus;
    public static LoadedObjectVertexNormalTexture lovoWeiXiu;
    public static LoadedObjectVertexNormalTexture lovoTaxi;

    public static LoadedObjectVertexNormalTexture lovoRedHoouse;
    public static LoadedObjectVertexNormalTexture lovoGrayHouse;
    public static LoadedObjectVertexNormalTexture lovoYellowHouse;
    public static LoadedObjectVertexNormalTexture lovoDaSha;
    public static LoadedObjectVertexNormalTexture lovoMotel;
    public static LoadedObjectVertexNormalTexture lovoCheZhan;
    public static LoadedObjectVertexNormalTexture lovoTieGui;
    public static LoadedObjectVertexNormalTexture lovoPlane;
    public static LoadedObjectVertexNormalTexture lovoTrain;
    public static LoadedObjectVertexNormalTexture lovoCaoPing;
    public static LoadedObjectVertexNormalTexture lovoFruitShop;
    public static LoadedObjectVertexNormalTexture lovoOffice;
    public static LoadedObjectVertexNormalTexture lovoJianTouW;
    public static LoadedObjectVertexNormalTexture lovoGodCube;
    public static LoadedObjectVertexNormalTexture lovoGodCaiShen;
    public static LoadedObjectVertexNormalTexture lovoGodShuaiShen;
    public static LoadedObjectVertexNormalTexture lovoChiBang;
    public static LoadedObjectVertexNormalTexture lovoMTL_ZL;
    public static LoadedObjectVertexNormalTexture lovoMTL_DZ;

    public static LoadedObjectVertexNormalTexture lovoMTL_room1;
    public static LoadedObjectVertexNormalTexture lovoMTL_room2;
    public static LoadedObjectVertexNormalTexture lovoMTL_room3;
    public static LoadedObjectVertexNormalTexture lovoMTL_room4;
    public static LoadedObjectVertexNormalTexture lovoMTL_room5;
    public static LoadedObjectVertexNormalTexture lovoMTL_room6;
    public static LoadedObjectVertexNormalTexture lovoMTL_room7;
    public static LoadedObjectVertexNormalTexture lovoMTL_room8;
    public static LoadedObjectVertexNormalTexture lovoMTL_room9;
    public static LoadedObjectVertexNormalTexture lovoMTL_room10;
    public static LoadedObjectVertexNormalTexture lovoMTL_room11;
    public static LoadedObjectVertexNormalTexture lovoMTL_room12;


    //人物模型 明
    //蓝色人物
    public static BNModel bnLanD;
    public static BNModel bnLanJ;
    //红色人物
    public static BNModel bnHongD;
    public static BNModel bnHongJ;
    //褐色人物
    public static BNModel bnHeD;
    public static BNModel bnHeJ;
    //棕色人物
    public static BNModel bnZongD;
    public static BNModel bnZongJ;

    //基本草坪
    public static RectMap rectMap;
    //人物影子
    public static Shadow P1_shadow;
    public static Shadow P2_shadow;
    public static Shadow P3_shadow;
    public static Shadow P4_shadow;
    //天空盒
    public static SkyBox skyBox;
    //2D贴图
    public static TextureRectangle2D rectangle2Ds[]=new TextureRectangle2D[5];
    public static TextureRectangle2D tr2Dperson;
    public static TextureRectangle2D tr2Dbmenu[]=new TextureRectangle2D[4];
    public static TextureRectangle2D tr2Dmusic[]=new TextureRectangle2D[2];
    public static TextureRectangle2D tr2dInfo[]=new TextureRectangle2D[4];
    public static TextureRectangle2D tr2dSetMenu;//设置界面
    public static TextureRectangle2D tr2dSet[] =new TextureRectangle2D[5];
    public static TextureRectangle2D loadbackground;//加载背景
    public static TextureRectangle2D loadmove;//进度条
    public static TextureRectangle2D richman;//背景图
    public static TextureRectangle2D loadingtext;//加载文字
    public static TextureRectangle2D cundangView;

    public static TextureRectangle2D trgo;//骰子图片

    public static TextureRectangle2D trbankmoney;//银行
    public static NumberForDraw money;//人物财产
    public static NumberForDraw cp;//彩票数字
    public static NumberForDraw gp;//股票数字
    public static NumberForDraw cardNum;//卡片的剩余量

    public static TextureRectangle2D shaizi;//骰子掷动画

    //获得点券
    public static TextureRectangle2D get50;
    public static TextureRectangle2D get20;
    //电脑购买土地
    public static TextureRectangle2D payfor;
    //花费一半
    public static TextureRectangle2D payhalf;

    //神仙附体
    public static TextureRectangle2D caishenM;
    public static TextureRectangle2D emoM;
    public static TextureRectangle2D fushenM;
    public static TextureRectangle2D shuaishenM;
    public static TextureRectangle2D tianshiM;

    //神仙产生效果
    public static TextureRectangle2D tianshiup;
    public static TextureRectangle2D emodown;

    //电脑玩家升级土地
    public static TextureRectangle2D upfor1;
    public static TextureRectangle2D upfor2;
    public static TextureRectangle2D upfor3;

    //正常过路费
    public static TextureRectangle2D paylevel1;
    public static TextureRectangle2D paylevel2;
    public static TextureRectangle2D paylevel3;
    public static TextureRectangle2D paylevel4;

    //财神附体 过路费一半
    public static TextureRectangle2D payhalflevel1;
    public static TextureRectangle2D payhalflevel2;
    public static TextureRectangle2D payhalflevel3;
    public static TextureRectangle2D payhalflevel4;

    //衰神附体 过路费双倍
    public static TextureRectangle2D paydoublelevel1;
    public static TextureRectangle2D paydoublelevel2;
    public static TextureRectangle2D paydoublelevel3;
    public static TextureRectangle2D paydoublelevel4;

    //与商店有关
    public static TextureRectangle2D payshop;
    public static TextureRectangle2D saleshopM;
    public static TextureRectangle2D saleshopC;
    public static TextureRectangle2D shopoff;

    //加油站
    public static TextureRectangle2D payjyz;
    public static TextureRectangle2D salejyzM;
    public static TextureRectangle2D salejyzC;
    public static TextureRectangle2D jyzoff;

    //旅馆
    public static TextureRectangle2D payhotel;
    public static TextureRectangle2D salehotelM;
    public static TextureRectangle2D salehotelC;
    public static TextureRectangle2D hoteloff;

    //卡片商店
    public static TextureRectangle2D cardshop;
    //卡片背包
    public static TextureRectangle2D trcardbag;
    public static TextureRectangle2D tr2dCard[]=new TextureRectangle2D[6];
    //bank
    public static TextureRectangle2D getmoney;
    //进医院
    public static TextureRectangle2D gohos;
    //彩票
    public static TextureRectangle2D caipiao;
    public static TextureRectangle2D caipiaoP0;
    public static TextureRectangle2D caipiaoP2;
    public static TextureRectangle2D caipiaoP3;
    public static TextureRectangle2D kaijiang;
    public static TextureRectangle2D getcp;
    public static TextureRectangle2D nonegetcp;

    //股票
    public static TextureRectangle2D gpview;
    public static TextureRectangle2D gpnum[] = new TextureRectangle2D[10];
    public static TextureRectangle2D gpmai[]=new TextureRectangle2D[2];//是否购买
    public static TextureRectangle2D gpj[]=new TextureRectangle2D[2];//“-”“+”

    //背景虚化
    public static TextureRectangle2D xuhua;
    //切换视角
    public static TextureRectangle2D shijiao;
    //存档成功
    public static TextureRectangle2D saveCD;
    //破产
    public static TextureRectangle2D pochan;
    //升级失败
    public static TextureRectangle2D uperror;
    //购买失败
    public static TextureRectangle2D saleerror;
    public static TextureRectangle2D moneyNo;//存取金额不足
    public static TextureRectangle2D noContinue;//存取金额不足


    //我的卡片
    public static MyCard mycardYK;
    public static MyCard mycardYD;
    public static MyCard mycardLD;
    public static MyCard mycardTL;
    public static MyCard mycardCS;
    public static MyCard mycardFS;

    //覆盖
    public static TextureRectangle2D fugai;

}
