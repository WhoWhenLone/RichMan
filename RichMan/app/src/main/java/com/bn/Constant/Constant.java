package com.bn.Constant;

import com.bn.Particle.ParticleFireworkForDraw;
import com.bn.Particle.ParticleFireworkSystem;
import com.bn.Particle.ParticleForDraw;
import com.bn.Particle.ParticleSystem;
import com.bn.Scenes.AllScene;
import com.bn.Scenes.CubeRoad;
import com.bn.Scenes.Shadow;
import com.bn.Util.ThrowUtil;
import com.bn.Util.ScreenScaleResult;
import com.bn.Util.ScreenScaleUtil;
import com.bn.View.GameMenuView;
import com.bn.View.GameView;
import com.bn.View.MenuButton;
import com.bn.View.StartView;
import com.bn.fbx.core.BNModel;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/31.
 */
//各种常量
//例如标志板的长宽 摄像机参数
    //视口参数等等
public class Constant {
    public static float SCREEN_WIDTH;               //实际屏幕宽度
    public static float SCREEN_HEIGHT;              //实际屏幕高度
    public static float ratio;							 //比例
    public static float screenWidth;                //屏幕的宽
    public static float screenHeight;               //屏幕的高

    public static MenuButton menuButton;
    public static StartView startView;
    public static GameView gameView;
    public static GameMenuView gameMenuView;
    public static ParticleForDraw fpfd;
    public static ParticleSystem fps;//烟雾粒子系统

    public static ParticleSystem fps1;
    public static ParticleForDraw fpfd1;

    public static ParticleFireworkForDraw fpffd;//烟花
    public static ParticleFireworkSystem fpfs;

    public static ParticleFireworkForDraw fpffd1;
    public static ParticleFireworkSystem fpfs1;

    public static float Mapscale = 10;
    //软件资源路径
    public static String TexturePath="pic/";        //定义图片路径
    public static String ObjPath="obj/";            //定义obj文件路径
    public static String ShaderPath="shader/";      //定义着色器文件路径
    public static AllScene allScene;

    //视角变量
    public static final float DISTANCE = 3.0f;//摄像机位置距离观察目标点的距离
    public static final float MOVE_SPAN=0.1f;//摄像机每次移动的位移
    public static final float DEGREE_SPAN=(float)(5.0/180.0f*Math.PI);//摄像机每次转动的角度

    //每个人物第一人称初始的摄像机角度
    public static float PersonAngleArray[] = new float[]{
            90.0f,90.0f,90.0f,90.0f
    };

    //人物数组
    // 动态  静态
    public static BNModel personArray[][] = new  BNModel[4][4];


    //人物 位置 数据数组
    //动态人物   一格数来计算人物当前的位置时
    //格数和 人物偏移的位置 正负  相反
    public static float locationDArray[][] = new float[4][4];

    //静态人物
    public static float locationJArray[][] = new float[4][4];

    public static int huiheId = 0;//cun
    //回合数
    //初始为-1
    // 掷骰子后 增加1
    //第一回合结束 huiheId 为 0

    public static int personId=0 ;
    //回合数 对4 求余
    //0  代表第一个人
    //1        2
    //2        3
    //3        4

    public static int buymapPage=1;
    public static int reject=-1;//金钱是否足够
    public static int cardView=-1;//拥有的卡片
    public static int gupiaoView=-1;//股票数
    public static int chakanView=-1;//个人信息
    public static int setMenuView=-1;//退出设置
    //摄像机状态位
    public static boolean CameraState=true;
    //上帝视角  MvState  true
    public static float cx;
    public static float cy;
    public static float cz;
    public static float tx;
    public static float ty;
    public static float tz;
    public static float ux;
    public static float uy;
    public static float uz;


    //第一人称视角 MvState false
    public static float Fcx;
    public static float Fcy;
    public static float Fcz;
    public static float Ftx;
    public static float Fty;
    public static float Ftz;
    public static float Fux;
    public static float Fuy;
    public static float Fuz;


    public static boolean loadState=false;      //是否加载完毕标志

    //人物是否移动的 标志位
    public static boolean MoveState =  false;
    //当前路径的id
    public static int roadIdArray[];
    //筛子的点数
    public static int dianshu=0;
    //筛子的点数 代表当前的走的格数
    public static float walllen=0;
    //true 移动
    public static int roadState;
    //路的状态位


    //每个人物的当前位置的路快的id数组
    public static int currentRoadArray[];

    public static CubeRoad[] cubeRoadArray= new CubeRoad[104];
    //方块路 所属地皮
    public static ArrayList<CubeRoad> cubeRoadArrayList = new ArrayList<>();//cun

    //各种等级房屋 数组
    //地皮
    public static float dipiarray[][] = new float[105][10];
    //1
    public static float houselevel1[][] = new float[105][10];
    //2
    public static float houselevel2[][] = new float[105][10];
    //3
    public static float houselevel3[][] = new float[105][10];

    //各种人物标志的数组
    //1
    public static float BZdata_P1[][] = new float[105][10];
    //2
    public static float BZdata_P2[][] = new float[105][10];
    //3
    public static float BZdata_P3[][] = new float[105][10];
    //4
    public static float BZdata_P4[][] = new float[105][10];

    //public static int
    //人物的资金数组
    //现金 银行存钱的金额  总数
    public static float  moneyArray[][] = new float[][]{
            {100000,100000,200000},
            {100000,100000,200000},
            {100000,100000,200000},
            {100000,100000,200000}
    };
    public static String dialogMessage[] = {//对话框的提示信息
            "800",//购买第一块土地
            "1000",//将地皮升级为第一级
            "1500",//将地皮升级为第二级
            "2000"//将地皮升级为第三级
    };
    public static int[] dipinumber=new int[]
            {0,0,0,0};//地皮的数量
    public static int year=2017;
    public static int month=01;
    public static int day=01;

    public static int year1;
    public static int month1;
    public static int day1;
    public static int hour1;
    public static int min1;
    public static int sec1;

    public static int year2;
    public static int month2;
    public static int day2;
    public static int hour2;
    public static int min2;
    public static int sec2;

    public static int year3;
    public static int month3;
    public static int day3;
    public static int hour3;
    public static int min3;
    public static int sec3;

    public static int year4;
    public static int month4;
    public static int day4;
    public static int hour4;
    public static int min4;
    public static int sec4;


    public static int guolufeiArray[] = new int[]
            {
               500,1000,2000,3000//一级到四级过路费
            };
    public static float guolufeiState=1;
    public static int result;//现金的中间量，比如购买土地，升级房屋，过路费

    //特殊建筑的 状态
    //0 可购买 1 属于1号人物 2  2号 ....
    //商店
    public static int shopState=0;
    //加油站
    public static int oilStationState = 0;
    //饭店
    public static int restaurantState = 0;

    //当前人物走到银行时 取钱
    public static float moneyChange;

    //人物拥有点券的数组
    //初始点券为50//cun
    public static int cardmoneyArray[] = new int[]{
           50,50,50,50
    };
    //人物前进的方向数组
    // 1  右
    // 2  上
    // 3  左
    // 4  下
    public static int GoArray[] = new int[]
            {
              4,2,3,4
            };

    //人物当前神仙状态数组
    //0  当前没有神仙
    //对应的
    public static int shenxianArray[][] = new int[][]{
            {0,0},
            {0,0},
            {0,0},
            {0,0},
    };

    //每个人物当前神仙的状态
    public static int currentGodState[] = new int[]{
          0,0,0,0
    };
    //每个人当前神仙的模型图片id
    public static int picGodArray[] = new int[7];
    public static float godLocation[] = new float[]
            {
                    locationDArray[personId][0]-0.35f*Mapscale+10f,locationDArray[personId][1]*1.15f+10f,locationDArray[personId][2]+10f
            };


    //人物当前医院数组
    // 0 不在医院  1 待在医院
    //第二位天数 三天
    public static int hosStateArray[][] = new int[][]
            {
                    {0,0},
                    {0,0},
                    {0,0},
                    {0,0},
            };
    //人物出院的标志位
    public static int CYState[] = new int[]
            {
                    0,0,0,0
            };

//    //是否购买的标志位
    public static boolean saleState = false;
    //当前人物是否购买的标志位
    public static boolean saleStateArray[] = new boolean[]
            {
                    true,false,true,true
            };
    //当前人物是否前进的标志位
    public static boolean MoveStateArray[] = new boolean[]
            {
                    false,false,false,false
            };
    public static int drawNum=0;
    //筛子线程标志位
    public static boolean shaiziState=false;

    //当前游戏玩家id
    public static int playerId = 1;
    //一个回合结束的标志位
    public static boolean nextgameState = false;
    public static ThrowUtil throwUtil;

    //人物影子数组
    public static Shadow shadowArray[] = new Shadow[4];
    //人物头像数组
    public static int persontxArray[] = new int[4];
    //购买卡片的id
    public static int salecardId;
    //人物的卡片数组
    //人物个数 卡片id 卡片数量//cun
    public static int cardArray[][][] = new int[4][6][1];
    //地皮数量//cun
    public static int dipicount[] = new int[]
            {
              0,0,0,0
            };
    //购买彩票的号码 0 代表未购买彩票
    public static int cpnumArray[] = new int[]
            {
                    0,0,0,0
            };

    //每期彩票中奖号码
    public static int cpnum;
    //股票
    public static int [] chengjiaojia=new int[]
            {15,12,13,9,11};
    public static int[][] zhangdie=new int[][]
            {
                    {1,-1,2,-1},
                    {-1,1,2,-1},
                    {2,-1,-1,1},
                    {-2,1,1,1},
                    {1,-1,-1,2}
            };
    public static int[] jiaoyiliang=new int[]//cun
            {2000,2000,2000,2000,2000};
    public static int[] chiyoushu=new int[]//cun
            {0,0,0,0,0};
    public static int mairugp[] =new int[]{0,0,0,0,0};
    public static int maichugp[]=new int[]{0,0,0,0,0};
    public static int zhangdieran=0;

    //各个存档的标志位 1有存档
    public static int cundangState=-1;
    public static int cundangState2=-1;
    public static int cundangState3=-1;
    public static int cundangState4=-1;

    //覆盖存档的标志位
    public static int coverCDState = 0;
    public static int bankmoney=1000;
    public static int overId = -1;
    public static boolean godCaiShenState = false;
    public static boolean godShuaiShenState = false;
    public static boolean godTianShiState = false;
    public static boolean godEmoState = false;
//--------------------------------------------------------2d所需数据--------------------------------
    public  static ScreenScaleResult screenScaleResult;
    public static float sx;					       		 //自适应后的高
    public static float sy;								 //自适应后的高


    public  static float ButtonRangeX;
    public static float ButtonRangeY;

    public static float buttonkuandu;//开始界面按钮长宽
    public static float buttonchangdu;

    public static float helpviewbuttonkuandu;//帮助界面按钮长宽
    public static float helpviewbuttonchangcu;

    public static float backchangdu;//返回按钮长宽
    public static float backkuandu;

    public static float gochangdu;
    public static float gokuandu;

//    public static float bmenuchangdu;//右侧设置卡片等按钮
//    public static float bmenukuandu;

    public static float datechangdu;//日期背景长宽
    public static float datekuandu;

    public static float playchangdu;//开始长宽
    public static float playkuandu;

    public static float set_x;//设置按钮xy
    public static float set_y;
    public static float setLeft;
    public static float setRight;
    public static float setBottom;
    public static float setTop;

    public static float help_x;//帮助按钮
    public static float help_y;
    public static float helpLeft;
    public static float helpRight;
    public static float helpBottom;
    public static float helpTop;

    public static float play_x;
    public static float play_y;
    public static float playLeft;
    public static float playRight;
    public static float playBottom;
    public static float playTop;

    public static float yinyue_x;//音乐按钮
    public static float yinyue_y;
    public static float yinyueLeft;
    public static float yinyueRight;
    public static float yinyueBottom;
    public static float yinyueTop;

    public static float shop1_x;//关于按钮
    public static float shop1_y;
    public static float shop1Left;
    public static float shop1Right;
    public static float shop1Bttom;
    public static float shop1Top;

    public static float system_x;//系统说明
    public static float system_y;
    public static float systemLeft;
    public static float systemRight;
    public static float systemBottom;
    public static float systemTop;


    public static float back_x;//返回按钮xy
    public static float back_y;
    public static float backLeft;
    public static float backRight;
    public static float backBottom;
    public static float backTop;

    public static float startchangdu;
    public static float startkuandu;

    public static float start_x;//开始游戏按钮xy
    public static float start_y;
    public static float startLeft;
    public static float startRight;
    public static float startBottom;
    public static float startTop;

    public static float continue_x;//继续游戏按钮xy
    public static float continue_y;
    public static float continueLeft;
    public static float continueRight;
    public static float continueBottom;
    public static float continueTop;

    public static float read_x;//读取进度按钮xy
    public static float read_y;
    public static float readLeft;
    public static float readRight;
    public static float readBottom;
    public static float readTop;
    //每一个存档
    public static float cundangchangdu;
    public static float cundangkuandu;
    public static float cundang_x;
    public static float cundang1_y;
    public static float cundang1Left;
    public static float cundang1Right;
    public static float cundang1Top;
    public static float cundang1Bottom;

    public static float cundang2_y;
    public static float cundang2Left;
    public static float cundang2Right;
    public static float cundang2Top;
    public static float cundang2Bottom;

    public static float cundang3_y;
    public static float cundang3Left;
    public static float cundang3Right;
    public static float cundang3Top;
    public static float cundang3Bottom;

    public static float cundang4_y;
    public static float cundang4Left;
    public static float cundang4Right;
    public static float cundang4Top;
    public static float cundang4Bottom;

    public static float cundangyear1_x;
    public static float cundangyear1_y;

    public static float cundangdate11_x;
    public static float cundangdate11_y;

    public static float cundangmonth1_x;
    public  static float cundangmonth1_y;

    public static float cundangdate21_x;
    public static float cundangdate21_y;

    public static float cundangday1_x;
    public static float cundangday1_y;

    public static float cundanghour1_x;
    public static float cundanghour1_y;

    public static float cundangdate31_x;
    public static float cundangdate31_y;

    public static float cundangmin1_x;
    public static float cundangmin1_y;

    //存档返回
    public static float cunback_x;
    public static float cunback_y;
    public static float cunbackLeft;
    public static float cunbackRight;
    public static float cunbackTop;
    public static float cunbackBottom;

    public static float renwu_x;
    public static float renwu_y;
    public static float renwuchangdu;
    public static float renwukuandu;

    public static float buyyes_x;//购买土地按钮xy
    public static float buyyes_y;
    public static float buyyesLeft;
    public static float buyyesRight;
    public static float buyyesBottom;
    public static float buyyesTop;

    public static float buyno_x;//不购买土地按钮xy
    public static float buyno_y;
    public static float buynoLeft;
    public static float buynoRight;
    public static float buynoBottom;
    public static float buynoTop;

    public static float go_x;//骰子按钮
    public static float go_y;
    public static float goLeft;
    public static float goRight;
    public static float goBottom;
    public static float goTop;

    public static float datebg_x;//日期
    public static float datebg_y;

    public static float datex1_x;
    public static float datex_y;

    public static float datex2_x;

    public static float shaderchangdu;
    public static float shaderkuandu;

    public static float shader1_x;
    public static float shader1_y;

    public static float shader2_x;
    public static float shader2_y;

    public static float shader3_x;
    public static float shader3_y;

    public static float coin_x;
    public static float coin_y;
    public static float coinchangdu;
    public static float coinkuandu;

    public static float bankcard_x;
    public static float bankcard_y;

    public static float cash_x;
    public static float cash_y;

    public static float xMoney_x;//金钱
    public static float xMoney_y;
    public static float cMoney_x;
    public static float cMoney_y;
    public static float dianquan_x;
    public static float dianquan_y;

    public static float moneychangdu;
    public static float moneykuandu;

    public static float cardchangdu;
    public static float cardkuandu;

    public static float cardMenu_x;//卡片按钮
    public static float cardMenu_y;
    public static float cardMenuLeft;
    public static float cardMenuRight;
    public static float cardMenuTop;
    public static float cardMenuBottom;

    public static float gupiaoMenu_x;//右侧第二个按钮
    public static float gupiaoMenu_y;
    public static float gupiaoMenuLeft;
    public static float gupiaoMenuRight;
    public static float gupiaoMenuTop;
    public static float gupiaoMenuBottom;

    public static float infoMenu_x;//右侧第三个按钮
    public static float infoMenu_y;
    public static float infoMneuLeft;
    public static float infoMenuRight;
    public static float infoMenuTop;
    public static float infoMenuBottom;

    public static float setMenu_x;//右侧第四个按钮
    public static float setMenu_y;
    public static float setMenuLeft;
    public static float setMenuRight;
    public static float setMenuTop;
    public static float setMenuBottom;

    //设置界面xy长宽
    public static float setPagechang;
    public static float setpagekuan;
    public static float setPage_x;
    public static float setPage_y;

    public static float setback_x;
    public static float setback_y;
    public static float setbackLeft;
    public static float setbackRight;
    public static float setbackTop;
    public static float setbackBottom;

    public static float setxuandan_x;
    public static float setxuandan_y;
    public static float setxuandanLeft;
    public static float setxuandanRight;
    public static float setxuandanTop;
    public static float setxuandanBottom;



    public static float bankjiachangdu;
    public static float bankjiakuandu;

    public static float cunLeft;
    public static float cunRight;
    public static float cunTop;
    public static float cunBottom;

    public static float quLeft;
    public static float quRight;
    public static float quTop;
    public static float quBottom;

    public static float bankjia1_x;
    public static float bankjia1_y;
    public static float bankjia1Left;
    public static float bankjia1Right;
    public static float bankjia1Top;
    public static float bankjia1Bottom;

    public static float bankjian1_x;
    public static float bankjian1_y;
    public static float bankjian1Left;
    public static float bankjian1Right;
    public static float bankjian1Top;
    public static float bankjian1Bottom;

    public static float bankjia5_x;
    public static float bankjia5_y;
    public static float bankjia5Left;
    public static float bankjia5Right;
    public static float bankjia5Top;
    public static float bankjia5Bottom;

    public static float bankjian5_x;
    public static float bankjian5_y;
    public static float bankjian5Left;
    public static float bankjian5Right;
    public static float bankjian5Top;
    public static float bankjian5Bottom;

    public static float closebankchang;
    public static float closebankkuan;



    public static float bankmoney_x;
    public static float bankmoney_y;

    public static float setMusic_x;
    public static float setMusic_y;
    public static float setMusicLeft;
    public static float setMusicRight;
    public static float setMusicTop;
    public static float setMusicBottom;
    //存储
    public static float setcunchu_x;
    public static float setcunchu_y;
    public static float setcunchuLeft;
    public static float setcunchuRight;
    public static float setcunchuTop;
    public static float setcunchuBottom;

    public static float headchangdu;
    public static float headkuandu;

    public static float head_x;
    public static float head_y;

    public static float cunchangdu;
    public static float cunkuandu;

    public static float cun_x;
    public static float cun_y;

    public static float qu_x;
    public static  float qu_y;

    public static float closebank_x;
    public static float closebank_y;
    public static float closebankLeft;
    public static float closebankRight;
    public static float closebankTop;
    public static float closebankBottom;

    public static float xingqichang;
    public static float xingqikuan;
    public static float wanjia0_x;
    public static float wanjia0_y;

    public static float wanjian_x;
    public static float wanjian_y;

    public static float year_x;
    public static float year_y;

    public static float month_x;
    public static float month_y;

    public static float day_x;
    public static float day_y;
    //卡片背包关闭
    public static float closebagchang;
    public static float closebagkuan;
    public static float closebag_x;
    public static float closebag_y;
    public static float closebagLeft;
    public static float closeBagRight;
    public static float closebagTop;
    public static float closebagBottom;

    //购买卡片
    public static float salecardchang;
    public static float salecardkuan;
    public static float salecard_x;
    public static float salecard_y;
    public static float salecardLeft;
    public static float salecardRight;
    public static float salecardTop;
    public static float salecardBottom;

    //使用卡片
    public static float usecardchang;
    public static float usecardkuan;
    public static float usecard_x;
    public static float usecard_y;
    public static float usecardLeft;
    public static float usecardRight;
    public static float usecardTop;
    public static float usecardBottom;

    //card1
    public static float card1_x;
    public static float card1_y;
    public static float card1Left;
    public static float card1Right;
    public static float card1Top;
    public static float card1Bottom;

    //card2
    public static float card2_x;
    public static float card2_y;
    public static float card2Left;
    public static float card2Right;
    public static float card2Top;
    public static float card2Bottom;
    //card3
    public static float card3_x;
    public static float card3_y;
    public static float card3Left;
    public static float card3Right;
    public static float card3Top;
    public static float card3Bottom;
    //card4
    public static float card4_x;
    public static float card4_y;
    public static float card4Left;
    public static float card4Right;
    public static float card4Top;
    public static float card4Bottom;
    //card5
    public static float card5_x;
    public static float card5_y;
    public static float card5Left;
    public static float card5Right;
    public static float card5Top;
    public static float card5Bottom;
    //card6
    public static float card6_x;
    public static float card6_y;
    public static float card6Left;
    public static float card6Right;
    public static float card6Top;
    public static float card6Bottom;
    //showcard
    public static float showcardchang;
    public static float showcardkuan;
    public static float showcard_x;
    public static float showcard_y;
    public static float showcardLeft;
    public static float showcardRight;
    public static float showcardTop;
    public static float showcardBottom;
    //剩余数量
    public static float cardnumber_x;
    public static float cardnumber_y;

    public static float cardchang;
    public static float cardkuan;


    public static float infoLeftchang;
    public static float infoLeftkuan;
    public static float infoLeft_x;
    public static float infoLeft_y;
    public static float infoLeftLeft;
    public static float infoLeftRight;
    public static float infoLeftTop;
    public static float infoLeftBottom;

    public static float infoRight_x;
    public static float infoRight_y;
    public static float infoRightLeft;
    public static float infoRightRight;
    public static float infoRightTop;
    public static float infoRightBottom;

    public static float infoClosechang;
    public static float infoClosekuan;
    public static float infoClose_x;
    public static float infoClose_y;
    public static float infoCloseLeft;
    public static float infoCloseRight;
    public static float infoCloseTop;
    public static float infoCloseBottom;
    //个人信息界面数字位置
    public static float infoxMoney_x;
    public static float infoxMoney_y;
    public static float infocMoney_x;
    public static float infocMoney_y;
    public static float infoRoadn_x;
    public static float infoRoadn_y;
    public static float infodianquan_x;
    public static float infodianquan_y;
    //个人信息界面玩家1234
    public static float wanjia_x;
    public static float wanjia_y;

    //彩票点数1-9的位置
    public static float cpnumchang;
    public static float cpnumkuan;
    public static float cp1_x;
    public static float cp1_y;
    public static float cp1Left;
    public static float cp1Right;
    public static float cp1Top;
    public static float cp1Bottom;

    public static float cp2_x;
    public static float cp2_y;
    public static float cp2Left;
    public static float cp2Right;
    public static float cp2Top;
    public static float cp2Bottom;

    public static float cp3_x;
    public static float cp3_y;
    public static float cp3Left;
    public static float cp3Right;
    public static float cp3Top;
    public static float cp3Bottom;

    public static float cp4_x;
    public static float cp4_y;
    public static float cp4Left;
    public static float cp4Right;
    public static float cp4Top;
    public static float cp4Bottom;

    public static float cp5_x;
    public static float cp5_y;
    public static float cp5Left;
    public static float cp5Right;
    public static float cp5Top;
    public static float cp5Bottom;

    public static float cp6_x;
    public static float cp6_y;
    public static float cp6Left;
    public static float cp6Right;
    public static float cp6Top;
    public static float cp6Bottom;

    public static float cp7_x;
    public static float cp7_y;
    public static float cp7Left;
    public static float cp7Right;
    public static float cp7Top;
    public static float cp7Bottom;

    public static float cp8_x;
    public static float cp8_y;
    public static float cp8Left;
    public static float cp8Right;
    public static float cp8Top;
    public static float cp8Bottom;

    public static float cp9_x;
    public static float cp9_y;
    public static float cp9Left;
    public static float cp9Right;
    public static float cp9Top;
    public static float cp9Bottom;



    //显示玩家所选号码
    public static float showcpnum_x;
    public static float showcpnum_y;
    //中奖号码
    public static float zhongjiang_x;
    public static float zhongjiang_y;
    //股票关闭按钮
    public static float closegpchang;
    public static float closegpkuan;
    public static float closegp_x;
    public static float closegp_y;
    public static float closegpLeft;
    public static float closegpRight;
    public static float closegpTop;
    public static float closegpBottom;
    //买入卖出
    public static float mairuchang;
    public static float mairukuan;
    public static float mairu_x;
    public static float mairu1_y;
    public static float mairu2_y;
    public static float mairu3_y;
    public static float mairu4_y;
    public static float mairu5_y;

    public static float mairuLeft;
    public static float mairuRight;

    public static float mairu1Top;
    public static float mairu1Bottom;

    public static float mairu2Top;
    public static float mairu2Bottom;

    public static float mairu3Top;
    public static float mairu3Bottom;

    public static float mairu4Top;
    public static float mairu4Bottom;

    public static float mairu5Top;
    public static float mairu5Bottom;

    public static float maichu_x;
    public static float maichu1_y;
    public static float maichu2_y;
    public static float maichu3_y;
    public static float maichu4_y;
    public static float maichu5_y;

    public static float maichuLeft;
    public static float maichuRight;

    public static float maichu1Top;
    public static float maichu1Bottom;

    public static float maichu2Top;
    public static float maichu2Bottom;

    public static float maichu3Top;
    public static float maichu3Bottom;

    public static float maichu4Top;
    public static float maichu4Bottom;

    public static float maichu5Top;
    public static float maichu5Bottom;
    //买入卖出界面
    public static float mairuyeschang;
    public static float mairuyeskuan;
    public static float mairuyes_x;
    public static float mairuyes_y;
    public static float mairuyesLeft;
    public static float mairuyesRight;
    public static float mairuyesTop;
    public static float mairuyesBottom;

    public static float mairuno_x;
    public static float mairuno_y;
    public static float mairunoLeft;
    public static float mairunoRight;
    public static float mairunoTop;
    public static float mairunoBottom;

    public static float mairupluschang;
    public static float mairupluskuan;
    public static float mairuplus_x;
    public static float mairuplus_y;
    public static float mairuplusLeft;
    public static float mairuplusRight;
    public static float mairuplusTop;
    public static float mairuplusBottom;

    public static float mairureduce_x;
    public static float mairureduce_y;
    public static float mairureduceLeft;
    public static float mairureduceRight;
    public static float mairureduceTop;
    public static float mairureduceBottom;

    public static float gpnum_x;
    public static float gpnum_y;
    //股票数字
    public static float gpnumberchang;
    public static float gpnumberkuan;


    public static float chengjiaojia_x;
    public static float chengjiaojia1_y;
    public static float chengjiaojia2_y;
    public static float chengjiaojia3_y;
    public static float chengjiaojia4_y;
    public static float chengjiaojia5_y;

    public static float zhangdie_x;
    public static float zhangdie1_y;
    public static float zhangdie2_y;
    public static float zhangdie3_y;
    public static float zhangdie4_y;
    public static float zhangdie5_y;

    public static float jiaoyiliang_x;
    public static float jiaoyiliang1_y;
    public static float jiaoyiliang2_y;
    public static float jiaoyiliang3_y;
    public static float jiaoyiliang4_y;
    public static float jiaoyiliang5_y;

    public static float chiyoushu_x;
    public static float chiyoushu1_y;
    public static float chiyoushu2_y;
    public static float chiyoushu3_y;
    public static float chiyoushu4_y;
    public static float chiyoushu5_y;

  //小数点
    public static float pointchang;
    public static float pointkuan;
    public static float point_x;
    public static float point_y;
    public static float jia_x;
    public static float jia_y;
    public static float jian_x;
    public static float jian_y;


    //切换视角
    public static float shijiao_x;
    public static float shijiao_y;
    public static float shijiaoLeft;
    public static float shijiaoRight;
    public static float shijiaoTop;
    public static float shijiaoBottom;

    //选择人物
    public static float selectleft_x;
    public static float selectleft_y;
    public static float selectleftLeft;
    public static float selectleftRight;
    public static float selectleftTop;
    public static float selectleftBottom;

    public static float selectright_x;
    public static float selectright_y;
    public static float selectrightLeft;
    public static float selectrightRight;
    public static float selectrightTop;
    public static float selectrightBottom;

    //读取存档按钮
    public static float readCunDang_x;
    public static float readCunDang_y;
    public static float readCunDangLeft;
    public static float readCunDangRight;
    public static float readCunDangTop;
    public static float readCunDangBottom;

    //覆盖存档的按钮
    public static float coverCunDangchangdu;
    public static float coverCunDangkuandu;
    public static float coverCunDang_x;
    public static float coverCunDang_y;
    public static float coverCunDangLeft;
    public static float coverCunDangRight;
    public static float coverCunDangTop;
    public static float coverCunDangBottom;

    //不覆盖存档按钮
    public static float nocoverCunDang_x;
    public static float nocoverCunDang_y;
    public static float nocoverCunDangLeft;
    public static float nocoverCunDangRight;
    public static float nocoverCunDangTop;
    public static float nocoverCunDangBottom;

    //卡片拥有量的长度
    public static float cardNumchangdu;
    public static float cardNumkuandu;

    public static float cardNum1_x;
    public static float cardNum1_y;

    public static float cardNum2_x;
    public static float cardNum2_y;

    public static float cardNum3_x;
    public static float cardNum3_y;

    public static float cardNum4_x;
    public static float cardNum4_y;

    public static float cardNum5_x;
    public static float cardNum5_y;
    public static float cardNum6_x;
    public static float cardNum6_y;

    //音效

    public static int SOUND_ClickBtn=1;//点击按钮的音效
    public static int SOUND_MenuView=2;//菜单界面弹出音效
    public static int SOUND_ThrowBtn=3;//点击骰子音效
    public static int SOUND_UpHome=4;//升级房屋
    public static int SOUND_YanHua=5;//烟花



    public static void caculatLocationData()

    {
        screenScaleResult= ScreenScaleUtil.calScale(screenWidth, screenHeight);
        sx=screenScaleResult.lucX;
        sy=screenScaleResult.lucY;
        ratio=screenScaleResult.ratio;
        if (screenWidth>screenHeight)
        {
            ButtonRangeX = screenHeight/2;
            ButtonRangeY = screenWidth/2;
        }else
        {
            ButtonRangeX = screenWidth/2;
            ButtonRangeY = screenHeight/2;
        }

        //数字长宽
        moneychangdu = 0.13f*ButtonRangeX;
        moneykuandu = 0.15f*ButtonRangeY;
        //开始长宽
        playchangdu = 0.57f*ButtonRangeX;
        playkuandu = 0.33f*ButtonRangeY;
        //首页按钮长宽
        buttonchangdu = 0.39f*ButtonRangeX;
        buttonkuandu = 0.22f*ButtonRangeY;
        //返回长宽
        backchangdu = 0.36f*ButtonRangeX;
        backkuandu = 0.23f*ButtonRangeY;
        //开始游戏按钮长宽
        startchangdu = 1.2f*ButtonRangeX;
        startkuandu = 0.4f*ButtonRangeY;
        //人物长宽
        renwuchangdu = 0.9f*ButtonRangeX;
        renwukuandu = 1.5f*ButtonRangeX;
        //帮助界面按钮长宽
        helpviewbuttonchangcu = ButtonRangeX/3;
        helpviewbuttonkuandu = ButtonRangeY;
        //筛子长宽
        gochangdu=ButtonRangeX*0.6f;
        gokuandu = ButtonRangeY*0.4f;

        //设置按钮xy
        set_x=0.9f*ButtonRangeX-buttonchangdu/2;
        set_y=screenHeight-0.08f*ButtonRangeY-buttonkuandu/2;
        //帮助按钮xy
        help_x = 1.2f*ButtonRangeX;
        help_y=screenHeight-0.09f*ButtonRangeY-buttonkuandu/2;
        helpLeft=help_x-buttonchangdu/2;
        helpRight=help_x+buttonchangdu/2;
        helpBottom=help_y-buttonkuandu/2;
        helpTop=help_y+buttonkuandu/2;
        //继续xy
        continue_x = start_x-startchangdu*0.3f;
        continue_y = start_y+startkuandu*0.9f;
        continueLeft = continue_x-startchangdu/4;
        continueRight = continue_x+startchangdu/4;
        continueTop = continue_y-startkuandu/4;
        continueBottom = continue_y+startkuandu/4;
        //开始xy
        play_x=screenWidth/2;
        play_y=screenHeight-0.11f*ButtonRangeY-buttonkuandu/2;
        playLeft = play_x-playchangdu/2;
        playRight = play_x+playchangdu/2;
        playTop = play_y-playkuandu/2;
        playBottom = play_y+playkuandu/2;
        //音乐xy
        yinyue_x=screenWidth-0.9f*ButtonRangeX+buttonchangdu;//screenWidth-1.2f*ButtonRangeX;
        yinyue_y=screenHeight-2*buttonkuandu/3;
        yinyueLeft=yinyue_x-buttonchangdu/2;
        yinyueRight=yinyue_x+buttonchangdu/2;
        yinyueTop=yinyue_y-buttonkuandu/2;
        yinyueBottom=yinyue_y+buttonkuandu/2;
        //商店xy
        shop1_x = screenWidth-0.9f*ButtonRangeX+buttonchangdu/2;
        shop1_y=screenHeight-0.08f*ButtonRangeY-buttonkuandu/2;

        system_x=screenWidth/2-helpviewbuttonchangcu*2+helpviewbuttonchangcu/2;
        system_y=screenHeight-0.5f*ButtonRangeX-helpviewbuttonkuandu/2;
        systemLeft=system_x-helpviewbuttonchangcu/2;
        systemRight=system_x+helpviewbuttonchangcu/2;
        systemBottom=system_y-helpviewbuttonkuandu/2;
        systemTop=system_y+helpviewbuttonkuandu/2;

        //返回xy
        back_x = 0.42f*ButtonRangeX;
        back_y = 0.15f*ButtonRangeY;
        backLeft = back_x-backchangdu/2;
        backRight = back_x+backchangdu/2;
        backBottom = back_y+backkuandu/2;
        backTop = back_y-backkuandu/2;
        //开始游戏xy
        start_x = ButtonRangeX*1.5f+startchangdu;
        start_y = ButtonRangeY*0.45f;
        startLeft = start_x-startchangdu/2;
        startRight = start_x+startkuandu/2;
        startTop = start_y-startkuandu/2;
        startBottom = start_y+startkuandu/2;
        //继续xy
        continue_x = start_x-startchangdu*0.3f;
        continue_y = start_y+startkuandu*0.9f;
        //读取xy
        read_x = start_x+startkuandu*0.4f;
        read_y = start_y+startkuandu*0.9f;
        readLeft = read_x-startchangdu/4;
        readRight = read_x+startchangdu/4;
        readTop = read_y-startkuandu/4;
        readBottom = read_y+startkuandu/4;
        //每一个存档
        cundangchangdu = screenWidth*0.63f;
        cundangkuandu = screenHeight*0.12f;
        cundang_x = screenWidth/2;
        cundang1_y = screenHeight*0.33f;
        cundang1Left = cundang_x-cundangchangdu/2;
        cundang1Right = cundang_x+cundangchangdu/2;
        cundang1Top = cundang1_y-cundangkuandu/2;
        cundang1Bottom = cundang1_y+cundangkuandu/2;

        cundang2_y = cundang1_y+cunkuandu;
        cundang2Left = cundang_x-cundangchangdu/2;
        cundang2Right = cundang_x+cundangchangdu/2;
        cundang2Top = cundang2_y-cundangkuandu/2;
        cundang2Bottom = cundang2_y+cundangkuandu/2;

        cundang3_y = cundang2_y+cunkuandu;
        cundang3Left = cundang_x-cundangchangdu/2;
        cundang3Right = cundang_x+cundangchangdu/2;
        cundang3Top = cundang3_y-cundangkuandu/2;
        cundang3Bottom = cundang3_y+cundangkuandu/2;

        cundang4_y = cundang3_y+cunkuandu;
        cundang4Left = cundang_x-cundangchangdu/2;
        cundang4Right = cundang_x+cundangchangdu/2;
        cundang4Top = cundang4_y-cundangkuandu/2;
        cundang4Bottom = cundang4_y+cundangkuandu/2;
        //存档返回
        cunback_x = cardchangdu;
        cunback_y = cardkuandu;
        cunbackLeft = cunback_x-cardchangdu/2;
        cunbackRight = cunback_x+cardchangdu/2;
        cunbackTop = cunback_y-cardkuandu/2;
        cunbackBottom = cunback_y+cardkuandu/2;
        //存档年月日时分
        cundangyear1_x = ButtonRangeX*1.2f;
        cundangyear1_y = cundang1_y;
        cundangdate11_x = cundangyear1_x+moneychangdu*2.5f;
        cundangdate11_y = cundang1_y;
        cundangmonth1_x = cundangyear1_x+moneychangdu*2.6f;
        cundangmonth1_y = cundang1_y;
        cundangdate21_x = cundangmonth1_x+moneychangdu*1.5f;
        cundangdate21_y = cundang1_y;
        cundangday1_x = cundangmonth1_x+moneychangdu*1.6f;
        cundangday1_y = cundang1_y;
        cundanghour1_x = cundangday1_x+moneychangdu*1.5f;
        cundanghour1_y = cundang1_y;
        cundangdate31_x = cundanghour1_x+moneychangdu*1.5f;
        cundangdate31_y = cundang1_y;
        cundangmin1_x = cundanghour1_x+moneychangdu*1.6f;
        cundangmin1_y = cundang1_y;
        //人物xy
        renwu_x = ButtonRangeX*1.2f;
        renwu_y = ButtonRangeY*0.5f;
        //筛子xy
        go_x = gochangdu/2;
        go_y = screenHeight-gokuandu/2;
        goLeft=go_x-gochangdu/2;
        goRight=go_x+gochangdu/2;
        goTop=go_y-gokuandu/2;
        goBottom=go_y+gokuandu/2;
        //日期背景长宽
        datechangdu = ButtonRangeX*1.3f;
        datekuandu = ButtonRangeX*0.55f;
        //"玩家"长宽
        xingqichang=ButtonRangeX*0.23f;
        xingqikuan=ButtonRangeX*0.17f;
        //年
        year_x=datebg_x*0.9f;
        year_y=datebg_y*0.7f;
        //月
        month_x=datebg_x*1.36f;
        month_y=year_y;
        //日
        day_x=datebg_x*1.63f;
        day_y=year_y;
        //日期xy
        datebg_x=0.5f*datechangdu;
        datebg_y = ButtonRangeY*0.1f+datekuandu*0.25f;
        //"/"
        datex1_x=year_x+moneychangdu*2.33f;
        datex_y=year_y;
        datex2_x=datex1_x+moneychangdu*1.26f;
        //星期xy
        wanjia0_x=datebg_x*1.15f+xingqichang/2;
        wanjia0_y=datebg_y*0.9f+xingqikuan/2;
        //几号玩家xy
        wanjian_x=wanjia0_x+moneychangdu;
        wanjian_y=wanjia0_y;
        //头长宽
        headchangdu=ButtonRangeX*0.38f;
        headkuandu=ButtonRangeY*0.28f;
        //头xy
        head_x = 0.86f*headchangdu;
        head_y = datebg_y*0.82f;
        //现金背景长宽
        shaderchangdu=ButtonRangeX*0.75f;
        shaderkuandu=ButtonRangeY*0.15f;
        //现金图片长宽
        coinchangdu=ButtonRangeX*0.2f;
        coinkuandu=ButtonRangeY*0.15f;
        //现金图片xy
        coin_x=ButtonRangeX*1.4f;
        coin_y=ButtonRangeY*0.1f;
        shader1_x=coin_x+shaderchangdu/2-coinchangdu*0.4f;
        shader1_y=coin_y;
        //现金数字xy
        xMoney_x=coin_x+moneychangdu*0.6f;
        xMoney_y=coin_y;
        //存款图片xy
        bankcard_x=coin_x+ButtonRangeX*0.65f;
        bankcard_y=coin_y;
        //存款背景xy
        shader2_x=bankcard_x+shaderchangdu/2-coinchangdu*0.4f;
        shader2_y=coin_y;
        //存款数字xy
        cMoney_x=bankcard_x+moneychangdu*0.6f;
        cMoney_y=coin_y;
        //点券图片xy
        cash_x=bankcard_x+ButtonRangeX*0.77f;
        cash_y=coin_y;
        //点券背景xy
        shader3_x=cash_x+shaderchangdu*0.6f-coinchangdu;
        shader3_y=coin_y;
        //点券数字xy
        dianquan_x=cash_x+moneychangdu;
        dianquan_y=coin_y;
        //卡片长宽
        cardchangdu=ButtonRangeX*0.33f;
        cardkuandu=ButtonRangeY*0.2f;
        cardchang=0.29f*ButtonRangeX;
        cardkuan=0.18f*ButtonRangeY;
        //卡片背包 关闭按钮
        closebagchang=0.22f*ButtonRangeX;
        closebagkuan=0.12f*ButtonRangeY;
        closebag_x=ButtonRangeX*2.0f+closebagchang*3.85f;
        closebag_y=0.27f*ButtonRangeY;
        closebagLeft=closebag_x-closebagchang/2;
        closeBagRight=closebag_x+closebagchang/2;
        closebagTop=closebag_y-closebagkuan/2;
        closebagBottom=closebag_y+closebagkuan/2;
        //菜单卡片xy
        cardMenu_x=screenWidth-cardchangdu*0.7f;
        cardMenu_y=ButtonRangeY*0.23f+cardkuandu*0.5f;
        cardMenuLeft=cardMenu_x-cardchangdu/2;
        cardMenuRight=cardMenu_x+cardchangdu/2;
        cardMenuTop=cardMenu_y-cardkuandu/2;
        cardMenuBottom=cardMenu_y+cardkuandu/2;
        //菜单股票xy
        gupiaoMenu_x=cardMenu_x;
        gupiaoMenu_y=cardMenu_y+cardkuandu;
        gupiaoMenuLeft=gupiaoMenu_x-cardchangdu/2;
        gupiaoMenuRight=gupiaoMenu_x+cardchangdu/2;
        gupiaoMenuTop=gupiaoMenu_y-cardkuandu/2;
        gupiaoMenuBottom=gupiaoMenu_y+cardkuandu/2;
        //菜单个人信息xy
        infoMenu_x=cardMenu_x;
        infoMenu_y=gupiaoMenu_y+cardkuandu;
        infoMneuLeft=infoMenu_x-cardchangdu/2;
        infoMenuRight=infoMenu_x+cardchangdu/2;
        infoMenuTop=infoMenu_y-cardkuandu/2;
        infoMenuBottom=infoMenu_y+cardkuandu/2;
        //个人信息详细界面
        infoLeftchang=ButtonRangeX * 0.25f;
        infoLeftkuan=ButtonRangeY * 0.17f;
        infoLeft_x=ButtonRangeX;
        infoLeft_y= ButtonRangeY * 0.58f;
        infoLeftLeft=infoLeft_x-infoLeftchang/2;
        infoLeftRight=infoLeft_x+infoLeftchang/2;
        infoLeftTop=infoLeft_y-infoLeftkuan/2;
        infoLeftBottom=infoLeft_y+infoLeftkuan/2;

        infoRight_x=ButtonRangeX+ButtonRangeX*1.63f;
        infoRight_y=infoLeft_y;
        infoRightLeft=infoRight_x-infoLeftchang/2;
        infoRightRight=infoRight_x+infoLeftchang/2;
        infoRightTop=infoRight_y-infoLeftkuan/2;
        infoRightBottom=infoRight_y+infoLeftkuan/2;

        infoClosechang=ButtonRangeX*0.23f;
        infoClosekuan=ButtonRangeY*0.13f;
        infoClose_x=ButtonRangeX*2.0f+infoClosechang*3.3f;
        infoClose_y=ButtonRangeY*0.23f;
        infoCloseLeft=infoClose_x-infoClosechang/2;
        infoCloseRight=infoClose_x+infoClosechang/2;
        infoCloseTop=infoClose_y-infoClosekuan/2;
        infoCloseBottom=infoClose_y+infoClosekuan/2;
        //菜单设置xy
        setMenu_x=cardMenu_x;
        setMenu_y=infoMenu_y+cardkuandu;
        setMenuLeft=setMenu_x-cardchangdu/2;
        setMenuRight=setMenu_x+cardchangdu/2;
        setMenuTop=setMenu_y-cardkuandu/2;
        setMenuBottom=setMenu_y+cardkuandu/2;
        //设置界面
        setPagechang=ButtonRangeX*1.3f;
        setpagekuan=ButtonRangeY*0.85f;
        setPage_x=screenWidth-cardchangdu*1.2f;
        setPage_y=ButtonRangeY*0.5f;
        //设置界面三个按钮
        setback_x=setPage_x+cardchangdu*0.2f;
        setback_y=setPage_y-cardkuandu*1.1f;

        setbackLeft=setback_x-cardchangdu/2;
        setbackRight=setback_x+cardchangdu/2;
        setbackTop=setback_y-cardkuandu/2;
        setbackBottom=setback_y+cardkuandu/2;
        cunchangdu=ButtonRangeX*0.36f;
        cunkuandu=ButtonRangeY*0.21f;
//        //银行存钱xy
//        cun_x=ButtonRangeX*1.38f;
//        cun_y=ButtonRangeY*0.88f;
//        cunLeft=cun_x-cunchangdu/2;
//        cunRight=cun_x+cunchangdu/2;
//        cunTop=cun_y-cunkuandu/2;
//        cunBottom=cun_y+cunkuandu/2;
        //银行存钱xy
        cun_x=ButtonRangeX*1.38f;
        cun_y=ButtonRangeY*0.88f;
        cunLeft=cun_x-cunchangdu/2;
        cunRight=cun_x+cunchangdu/2;
        cunTop=cun_y-cunkuandu/2;
        cunBottom=cun_y+cunkuandu/2;
        //银行取钱xy
        qu_x=ButtonRangeX*2.14f;
        qu_y=ButtonRangeY*0.88f;
        quLeft=qu_x-cunchangdu/2;
        quRight=qu_x+cunchangdu/2;
        quTop=qu_y-cunkuandu/2;
        quBottom=qu_y+cunkuandu/2;

        bankjiachangdu=ButtonRangeX*0.20f;
        bankjiakuandu=ButtonRangeY*0.13f;
        //减1000按钮
        bankjian1_x=ButtonRangeX*1.35f;
        bankjian1_y=ButtonRangeY*0.39f;
        bankjian1Left=bankjian1_x-bankjiachangdu/2;
        bankjian1Right=bankjian1_x+bankjiachangdu/2;
        bankjian1Top=bankjian1_y-bankjiakuandu/2;
        bankjian1Bottom=bankjian1_y+bankjiakuandu/2;
        //加1000按钮
        bankjia1_x=ButtonRangeX*2.18f;
        bankjia1_y=bankjian1_y;
        bankjia1Left=bankjia1_x-bankjiachangdu/2;
        bankjia1Right=bankjia1_x+bankjiachangdu/2;
        bankjia1Top=bankjia1_y-bankjiakuandu/2;
        bankjia1Bottom=bankjia1_y+bankjiakuandu/2;
        //减5000按钮
        bankjian5_x=bankjian1_x;
        bankjian5_y=ButtonRangeY*0.55f;
        bankjian5Left=bankjian5_x-bankjiachangdu/2;
        bankjian5Right=bankjian5_x+bankjiachangdu/2;
        bankjian5Top=bankjian5_y-bankjiakuandu/2;
        bankjian5Bottom=bankjian5_y+bankjiakuandu/2;
        //加5000按钮
        bankjia5_x=bankjia1_x;
        bankjia5_y=bankjian5_y;
        bankjia5Left=bankjia5_x-bankjiachangdu/2;
        bankjia5Right=bankjia5_x+bankjiachangdu/2;
        bankjia5Top=bankjia5_y-bankjiakuandu/2;
        bankjia5Bottom=bankjia5_y+bankjiakuandu/2;

        bankmoney_x=ButtonRangeX*1.6f;
        bankmoney_y=ButtonRangeY*0.7f;

        closebankchang=0.25f*ButtonRangeX;
        closebankkuan=0.15f*ButtonRangeY;

        //银行关闭按钮
        closebank_x=ButtonRangeX*2.0f+closebagchang*2.5f;
        closebank_y=ButtonRangeY*0.19f;
        closebankLeft=closebank_x-closebankchang/2;
        closebankRight=closebank_x+closebankchang/2;
        closebankTop=closebank_y-closebankkuan/2;
        closebankBottom=closebank_y+closebankkuan/2;

        setxuandan_x=setback_x;
        setxuandan_y=setPage_y;
        setxuandanLeft=setxuandan_x-cardchangdu/2;
        setxuandanRight=setxuandan_x+cardchangdu/2;
        setxuandanTop=setxuandan_y-cardkuandu/2;
        setxuandanBottom=setxuandan_y+cardkuandu/2;

        setMusic_x=setback_x;
        setMusic_y=setPage_y+cardkuandu*1.1f;
        setMusicLeft=setMusic_x-cardchangdu/2;
        setMusicRight=setMusic_x+cardchangdu/2;
        setMusicTop=setMusic_y-cardkuandu/2;
        setMusicBottom=setMusic_y+cardkuandu/2;
        //存储
        setcunchu_x = setback_x;
        setcunchu_y = setPage_y+cardkuandu*2.2f;
        setcunchuLeft = setcunchu_x-cardchangdu/2;
        setcunchuRight = setcunchu_x+cardchangdu/2;
        setcunchuTop = setcunchu_y-cardkuandu/2;
        setcunchuBottom = setcunchu_y+cardkuandu/2;
        //购买xy
        buyyes_x=ButtonRangeX*2.25f;
        buyyes_y=ButtonRangeY*0.8f;
        buyyesLeft=buyyes_x-buttonchangdu/2;
        buyyesRight=buyyes_x+buttonchangdu/2;
        buyyesTop=buyyes_y-buttonkuandu/2;
        buyyesBottom=buyyes_y+buttonkuandu/2;
        //不购买xy
        buyno_x=ButtonRangeX*1.37f;
        buyno_y=ButtonRangeY*0.8f;
        buynoLeft=buyno_x-buttonchangdu/2;
        buynoRight=buyno_x+buttonchangdu/2;
        buynoTop=buyno_y-buttonkuandu/2;
        buynoBottom=buyno_y+buttonkuandu/2;


        //购买卡片
        salecardchang=0.5f*ButtonRangeX;
        salecardkuan=0.1f*ButtonRangeY;
        salecard_x=ButtonRangeX+salecardchang*2.9f;
        salecard_y=0.75f*ButtonRangeY;
        salecardLeft = salecard_x - salecardchang/2;
        salecardRight= salecard_x + salecardchang/2;
        salecardTop = salecard_y - salecardkuan/2;
        salecardBottom= salecard_y + salecardkuan/2;
        //使用卡片
        usecardchang =0.5f*ButtonRangeX;
        usecardkuan =0.1f*ButtonRangeY;
        usecard_x =ButtonRangeX+salecardchang*2.9f;
        usecard_y =0.75f*ButtonRangeY;
        usecardLeft = usecard_x - usecardchang/2;
        usecardRight= usecard_x + usecardchang/2;
        usecardTop = usecard_y - usecardkuan/2;
        usecardBottom= usecard_y + usecardkuan/2;
        //card1
        card1_x=SCREEN_WIDTH*2/3-1.45f*ButtonRangeX;
        card1_y=SCREEN_HEIGHT*2/3-0.28f*ButtonRangeY;
        card1Left=card1_x-cardchang/2;
        card1Right=card1_x+cardchang/2;
        card1Top=card1_y-cardkuan/2;
        card1Bottom=card1_y+cardkuan/2;
        //card2
        card2_x=card1_x+ButtonRangeX*0.42f;
        card2_y=card1_y;
        card2Left=card2_x-cardchang/2;
        card2Right=card2_x+cardchang/2;
        card2Top=card2_y-cardkuan/2;
        card2Bottom=card2_y+cardkuan/2;
        //card3
        card3_x=card2_x+ButtonRangeX*0.42f;
        card3_y=card2_y;
        card3Left=card3_x-cardchang/2;
        card3Right=card3_x+cardchang/2;
        card3Top=card3_y-cardkuan/2;
        card3Bottom=card3_y+cardkuan/2;
        //card4
        card4_x=card1_x;
        card4_y=card1_y+ButtonRangeY*0.24f;
        card4Left=card4_x-cardchang/2;
        card4Right=card4_x+cardchang/2;
        card4Top=card4_y-cardkuan/2;
        card4Bottom=card4_y+cardkuan/2;
        //card5
        card5_x=card2_x;
        card5_y=card1_y+ButtonRangeY*0.24f;
        card5Left=card5_x-cardchang/2;
        card5Right=card5_x+cardchang/2;
        card5Top=card5_y-cardkuan/2;
        card5Bottom=card5_y+cardkuan/2;
        //card6
        card6_x=card3_x;
        card6_y=card1_y+ButtonRangeY*0.24f;
        card6Left=card6_x-cardchang/2;
        card6Right=card6_x+cardchang/2;
        card6Top=card6_y-cardkuan/2;
        card6Bottom=card6_y+cardkuan/2;
        //showcard
        showcardchang=cardchang*1.4f;
        showcardkuan=cardkuan*1.5f;
        showcard_x=card3_x+cardchang*2.2f;
        showcard_y=card1_y+cardkuan*0.1f;
        //剩余卡片数量
        cardnumber_x=showcard_x+cardchangdu*0.3f;
        cardnumber_y=card4_y*0.96f;//
        //卡片剩余量数字
        cardNum1_x=card1_x*1.155f;
        cardNum1_y=card1_y*1.2f;

        cardNum2_x=card2_x*1.115f;
        cardNum2_y=card2_y*1.2f;

        cardNum3_x=card3_x*1.085f;
        cardNum3_y=card3_y*1.2f;

        cardNum4_x=card4_x*1.155f;
        cardNum4_y=card4_y*1.13f;

        cardNum5_x=card5_x*1.115f;
        cardNum5_y=card5_y*1.13f;

        cardNum6_x=card6_x*1.085f;
        cardNum6_y=card6_y*1.13f;


        //个人信息界面现金xy
        infoxMoney_x=ButtonRangeX*1.5f+moneychangdu;
        infoxMoney_y=ButtonRangeY*0.24f+moneykuandu;
        //个人信息界面存款xy
        infocMoney_x=infoxMoney_x;
        infocMoney_y=infoxMoney_y+moneykuandu*0.87f;
        //个人信息界面点券xy
        infodianquan_x=infoxMoney_x+moneychangdu*0.7f;
        infodianquan_y=infocMoney_y+moneykuandu*0.87f;
        //个人信息界面地皮xy
        infoRoadn_x=infodianquan_x;
        infoRoadn_y=infodianquan_y+moneykuandu*0.87f;
        wanjia_x=ButtonRangeX*0.95f;
        wanjia_y=ButtonRangeY*0.42f;
        //彩票数字的长宽
        cpnumchang=ButtonRangeX*0.5f;
        cpnumkuan=ButtonRangeY*0.22f;
        //彩票数字"1"
        cp1_x=ButtonRangeX*0.87f;
        cp1_y=ButtonRangeY*0.51f;
        cp1Left=cp1_x-cpnumchang/2;
        cp1Right=cp1_x+cpnumkuan/2;
        cp1Top=cp1_y-cpnumkuan/2;
        cp1Bottom=cp1_y+cpnumkuan/2;
        //彩票数字"2"
        cp2_x=cp1_x+cpnumchang;
        cp2_y=cp1_y;
        cp2Left=cp2_x-cpnumchang/2;
        cp2Right=cp2_x+cpnumchang/2;
        cp2Top=cp2_y-cpnumkuan/2;
        cp2Bottom=cp2_y+cpnumkuan/2;
        //"3"
        cp3_x=cp2_x+cpnumchang;
        cp3_y=cp1_y;
        cp3Left=cp3_x-cpnumchang/2;
        cp3Right=cp3_x+cpnumchang/2;
        cp3Top=cp3_y-cpnumkuan/2;
        cp3Bottom=cp3_y+cpnumkuan/2;
        //"4"
        cp4_x=cp1_x;
        cp4_y=cp1_y+cpnumkuan*0.6f;
        cp4Left=cp4_x-cpnumchang/2;
        cp4Right=cp4_x+cpnumchang/2;
        cp4Top=cp4_y-cpnumkuan/2;
        cp4Bottom=cp4_y+cpnumkuan/2;
        //"5"
        cp5_x=cp2_x;
        cp5_y=cp4_y;
        cp5Left=cp5_x-cpnumchang/2;
        cp5Right=cp5_x+cpnumchang/2;
        cp5Top=cp5_y-cpnumkuan/2;
        cp5Bottom=cp5_y+cpnumkuan/2;
        //"6"
        cp6_x=cp3_x;
        cp6_y=cp4_y;
        cp6Left=cp6_x-cpnumchang/2;
        cp6Right=cp6_x+cpnumchang/2;
        cp6Top=cp6_y-cpnumkuan/2;
        cp6Bottom=cp6_y+cpnumkuan/2;
        //"7"
        cp7_x=cp1_x;
        cp7_y=cp4_y+cpnumkuan*0.6f;
        cp7Left=cp7_x-cpnumchang/2;
        cp7Right=cp7_x+cpnumchang/2;
        cp7Top=cp7_y-cpnumkuan/2;
        cp7Bottom=cp7_y+cpnumkuan/2;
        //"8"
        cp8_x=cp5_x;
        cp8_y=cp7_y;
        cp8Left=cp8_x-cpnumchang/2;
        cp8Right=cp8_x+cpnumchang/2;
        cp8Top=cp8_y-cpnumkuan/2;
        cp8Bottom=cp8_y+cpnumkuan/2;
        //"9"
        cp9_x=cp6_x;
        cp9_y=cp7_y;
        cp9Left=cp9_x-cpnumchang/2;
        cp9Right=cp9_x+cpnumchang/2;
        cp9Top=cp9_y-cpnumkuan/2;
        cp9Bottom=cp9_y+cpnumkuan/2;
        //显示所选号码
        showcpnum_x=ButtonRangeX*2.37f;
        showcpnum_y=cp1_y;
        //中奖号码
        zhongjiang_x=ButtonRangeX*1.7f;
        zhongjiang_y=ButtonRangeY*0.68f;
        //股票关闭按钮
        closegpchang=0.24f*ButtonRangeX;
        closegpkuan=0.14f*ButtonRangeY;
        closegp_x=ButtonRangeX*3.0f+closebagchang*0.4f;
        closegp_y=0.21f*ButtonRangeY;
        closegpLeft=closegp_x-closegpchang/2;
        closegpRight=closegp_x+closegpchang/2;
        closegpTop=closegp_y-closegpkuan/2;
        closegpBottom=closegp_y+closegpkuan/2;
        //买入卖出
        mairuchang=0.3f*ButtonRangeX;
        mairukuan=0.08f*ButtonRangeY;
        mairu_x=ButtonRangeX*2.15f+mairuchang;
        mairu1_y=ButtonRangeY*0.43f;
        mairu2_y=mairu1_y+mairukuan*1.36f;
        mairu3_y=mairu2_y+mairukuan*1.36f;
        mairu4_y=mairu3_y+mairukuan*1.36f;
        mairu5_y=mairu4_y+mairukuan*1.36f;

        mairuLeft=mairu_x-mairuchang/2;
        mairuRight=mairu_x+mairuchang/2;

        mairu1Top=mairu1_y-mairukuan/2;
        mairu1Bottom=mairu1_y+mairukuan/2;

        mairu2Top=mairu2_y-mairukuan/2;
        mairu2Bottom=mairu2_y+mairukuan/2;

        mairu3Top=mairu3_y-mairukuan/2;
        mairu3Bottom=mairu3_y+mairukuan/2;

        mairu4Top=mairu4_y-mairukuan/2;
        mairu4Bottom=mairu4_y+mairukuan/2;

        mairu5Top=mairu5_y-mairukuan/2;
        mairu5Bottom=mairu5_y+mairukuan/2;

        maichu_x=mairu_x+mairuchang*1.37f;
        maichu1_y=mairu1_y;
        maichu2_y=mairu2_y;
        maichu3_y=mairu3_y;
        maichu4_y=mairu4_y;
        maichu5_y=mairu5_y;

        maichuLeft=maichu_x-mairuchang/2;
        maichuRight=maichu_x+mairuchang/2;

        maichu1Top=maichu1_y-mairukuan/2;
        maichu1Bottom=maichu1_y+mairukuan/2;

        maichu2Top=maichu2_y-mairukuan/2;
        maichu2Bottom=maichu2_y+mairukuan/2;

        maichu3Top=maichu3_y-mairukuan/2;
        maichu3Bottom=maichu3_y+mairukuan/2;

        maichu4Top=maichu4_y-mairukuan/2;
        maichu4Bottom=maichu4_y+mairukuan/2;

        maichu5Top=maichu5_y-mairukuan/2;
        maichu5Bottom=maichu5_y+mairukuan/2;
        //买入卖出界面
        mairuyeschang=0.28f*ButtonRangeX;
        mairuyeskuan=0.168f*ButtonRangeY;

        mairuyes_x=ButtonRangeX*1.25f+mairuyeschang;
        mairuyes_y=ButtonRangeY*0.8f;
        mairuyesLeft=mairuyes_x-mairuyeschang/2;
        mairuyesRight=mairuyes_x+mairuchang/2;
        mairuyesTop=mairuyes_y-mairuyeskuan/2;
        mairuyesBottom=mairuyes_y+mairuyeskuan/2;

        mairuno_x=mairuyes_x+mairuyeschang*1.9f;
        mairuno_y=mairuyes_y;
        mairunoLeft=mairuno_x-mairuyeschang/2;
        mairunoRight=mairuno_x+mairuyeschang/2;
        mairunoTop=mairuno_y-mairuyeskuan/2;
        mairunoBottom=mairuno_y+mairuyeskuan/2;
        //"-""+"
        mairupluschang=0.25f*ButtonRangeX;
        mairupluskuan=0.15f*ButtonRangeY;
        mairureduce_x=ButtonRangeX*1.25f;
        mairureduce_y=ButtonRangeY*0.48f;
        mairureduceLeft=mairureduce_x-mairupluschang/2;
        mairureduceRight=mairureduce_x+mairupluschang/2;
        mairureduceTop=mairureduce_y-mairupluskuan/2;
        mairureduceBottom=mairureduce_y+mairupluskuan/2;

        mairuplus_x=mairureduce_x+mairupluschang*4.4f;
        mairuplus_y=mairureduce_y;
        mairuplusLeft=mairuplus_x-mairupluschang/2;
        mairuplusRight=mairuplus_x+mairupluschang/2;
        mairuplusTop=mairuplus_y-mairupluskuan/2;
        mairuplusBottom=mairuplus_y+mairupluskuan/2;
        //购买股票的数字
        gpnum_x=ButtonRangeX*1.65f;
        gpnum_y=ButtonRangeY*0.64f;
        //显示股票数字
        gpnumberchang=ButtonRangeX*0.1f;
        gpnumberkuan=ButtonRangeY*0.15f;

        chengjiaojia_x=ButtonRangeX;
        chengjiaojia1_y=mairu1_y;
        chengjiaojia2_y=mairu2_y;
        chengjiaojia3_y=mairu3_y;
        chengjiaojia4_y=mairu4_y;
        chengjiaojia5_y=mairu5_y;

        zhangdie_x=ButtonRangeX*1.27f+gpnumberchang;
        zhangdie1_y=mairu1_y;
        zhangdie2_y=mairu2_y;
        zhangdie3_y=mairu3_y;
        zhangdie4_y=mairu4_y;
        zhangdie5_y=mairu5_y;


        jiaoyiliang_x=zhangdie_x+gpnumberchang*3.0f;
        jiaoyiliang1_y=mairu1_y;
        jiaoyiliang2_y=mairu2_y;
        jiaoyiliang3_y=mairu3_y;
        jiaoyiliang4_y=mairu4_y;
        jiaoyiliang5_y=mairu5_y;


        chiyoushu_x=jiaoyiliang_x+gpnumberchang*3.6f;
        chiyoushu1_y=mairu1_y;
        chiyoushu2_y=mairu2_y;
        chiyoushu3_y=mairu3_y;
        chiyoushu4_y=mairu4_y;
        chiyoushu5_y=mairu5_y;
        //小数点
        pointchang=0.07f*ButtonRangeX;
        pointkuan=0.1f*ButtonRangeY;
        point_x=ButtonRangeX+pointchang;
        point_y=mairu1_y*1.1f;

        //切换视角
        shijiao_x=cardchangdu*0.7f;
        shijiao_y=datebg_y+cardkuandu*1.4f;
        shijiaoLeft=shijiao_x-cardchangdu/2;
        shijiaoRight=shijiao_x+cardchangdu/2;
        shijiaoTop=shijiao_y-cardkuandu/2;
        shijiaoBottom=shijiao_y+cardkuandu/2;

        selectleft_x=renwu_x-cardchangdu*1.7f;
        selectleft_y=renwu_y+cardchangdu*0.7f;
        selectleftLeft=selectleft_x-cardchangdu/2;
        selectleftRight=selectleft_x+cardchangdu/2;
        selectleftTop=selectleft_y-cardkuandu/2;
        selectleftBottom=selectleft_y+cardkuandu/2;


        selectright_x=renwu_x+cardchangdu*1.6f;
        selectright_y=renwu_y+cardchangdu*0.7f;
        selectrightLeft=selectright_x-cardchangdu/2;
        selectrightRight=selectright_x+cardchangdu/2;
        selectrightTop=selectright_y-cardkuandu/2;
        selectrightBottom=selectright_y+cardkuandu/2;

        coverCunDangchangdu=ButtonRangeX*0.34f;
        coverCunDangkuandu=ButtonRangeY*0.19f;
        coverCunDang_x=ButtonRangeX+coverCunDangchangdu*2.2f;
        coverCunDang_y=ButtonRangeY*0.7f;
        coverCunDangLeft=coverCunDang_x-coverCunDangchangdu/2;
        coverCunDangRight=coverCunDang_x+coverCunDangchangdu/2;
        coverCunDangTop=coverCunDang_y-coverCunDangkuandu/2;
        coverCunDangBottom=coverCunDang_y+coverCunDangkuandu/2;

        nocoverCunDang_x=ButtonRangeX*1.7f+coverCunDangchangdu*2.2f;
        nocoverCunDang_y=ButtonRangeY*0.3f;
        nocoverCunDangLeft=nocoverCunDang_x-coverCunDangchangdu/2;
        nocoverCunDangRight=nocoverCunDang_x+coverCunDangchangdu/2;
        nocoverCunDangTop=nocoverCunDang_y-coverCunDangkuandu/2;
        nocoverCunDangBottom=nocoverCunDang_y+coverCunDangkuandu/2;

        //卡片剩余量的数字
        cardNumchangdu=ButtonRangeX*0.08f;
        cardNumkuandu=ButtonRangeY*0.08f;


    }

}
