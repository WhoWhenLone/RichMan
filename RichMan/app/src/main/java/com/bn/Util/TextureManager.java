package com.bn.Util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES30;
import android.opengl.GLUtils;
import android.os.Build;

import com.bn.Constant.Constant;
import com.bn.RichMan.MyGLSurFaceView;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import static com.bn.Constant.IdDataConstant.hospitalId;

//初始化所有图片资源
@SuppressLint("InlinedApi") @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
public class TextureManager {
	static HashMap<String,Integer> texList= new HashMap<String,Integer>();
	public static String[] texturesName=
			{
					"hospital.jpg","dipi2.jpg","onsale.jpg","roadZ.png","dipi.png","shop.jpg",
					"jiayouzhan.jpg","housepic.jpg","zonghe2.png","MingBZ.png","sky.png",
					"road20dq.png","road50dq.png","shopCube.jpg","bank.jpg","hospitalcube.jpg",
					"qicheA.png","qicheB.png","qicheC.png","shuiniche.png","busStation.jpg",
					"bus.jpg","taxi.png","simple.png","motianlun.png","redhouse1.jpg","grayhouse.jpg",
					"yellowhouse.jpg","motianlun.png","motel.jpg","tiyuchang.jpg",
					"chezhan.jpg","tiegui.jpg","plane.jpg","huoche.jpg","caoping.jpg",
					"caoping.jpg","fruitshop.jpg","office.jpg","tianshi.png","emo.png","youling.png",
					"caishen.png","fushen.png","shuaishen.png","hutu.png","tudi.png","qiongshen.png",
					"jiantouW.jpg","jiantouZ.jpg",
					"caishenCube.jpg","emoCube.jpg","fushenCube.jpg","hutuCube.png","qiongshenCube.png",
					"shuaishenCube.png","tianshiCube.png","tudiCube.png","youlingCube.png",
					"BZ_hong.jpg","BZ_he.jpg","BZ_lan.jpg","BZ_zong.jpg","shadow.png",
					"Per_he.jpg","Per_hong.jpg","Per_lan.jpg","Per_zong.jpg",
					"play_right.png","play_left.png","caishen.jpg","shuaishen.jpg","chibangTS.png","chibangEMO.png",


					//----------------2d-------------------//
					"bankcard.png","card.png","cash.png","coin.png","go_light.png","gupiao.png","info.png",
					"touxiang.png","setting.png","shader.png","number1.png","week.png","xingqi.png",
					"buymap1.png","upfor1.png","upfor2.png","upfor3.png","upmapfor1.png","upmapfor2.png",
					"upmapfor3.png","no.png","ok.png","pzero.png","pone.png","ptwo.png","pthree.png",
					"bankmoney.png","cardbagView.png","xiegang.png","infoall.png","settingMenu.png","wanjia.png",
					"xuandan.png","yaokong.png", "onepoint.png","sixpoint.png","stopcard.png","caishencard.png",
					"fushencard.png","buybtn.png","plus.png","reduce.png","jia.png","jian.png","point.png","maohao.png",//游戏界面
					"back.png","continue_m.png","playgame_m.png","read_m.png","role.png","svbg.png",//开始游戏界面
					"bg1.png","gameshop.png","help.png","logo1.png","voice.png","voice_close.png","play.png",//开始界面
					"bg.png","loading.png","lu0.png","loading_inner.png","loadingText.png",//加载界面
					"1.png","2.png","3.png","4.png","5.png","6.png","a1.png","a2.png","a3.png","a4.png","fire.png",

					"get20.png","get50.png","payfor.png","payhalf.png","caishenM.png","emoM.png","fushenM.png",
					"shuaishenM.png","tianshiM.png","downlv.png","uplv.png","upfor1.png","upfor2.png","upfor3.png",
					"paylevel1.png","paylevel2.png","paylevel3.png","paylevel4.png",
					"payhalflevel1.png", "payhalflevel2.png","payhalflevel3.png","payhalflevel4.png",
					"paydoublelevel1.png","paydoublelevel2.png","paydoublelevel3.png","paydoublelevel4.png",
					//加油站 商店 旅馆
					"payjyz.png","salejyzC.png","salejyzM.png","jyzoff.png",
					"payshop.png","saleshopC.png","saleshopM.png","shopoff.png",
					"payhotel.png","salehotelC.png","salehotelM.png","hoteloff.png",
					"cardshopView.png","money.png","gohos.png","caipiao.png",
					"cpnum4.png","cpnum7.png","cpnum9.png","cpstation.jpg","kaijiang.png",
					"zhongjiang.png","none.png","GPView.png","GPNum.png","xuhua.png","shijiao.png",
					"numbers_red.png","numbers_green.png","cunchu.png","cundangView.png","saveCD.png",
					"myyaokong.png","myonepoint.png","mysixpoint.png","mystopcard.png","mycaishencard.png","myfushencard.png",
					"fugai.png","pochan.png","uperror.png","moneyno.png","nocontinue.png"



			};//纹理图的名称
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2) @SuppressLint({ "InlinedApi", "NewApi" })
	public static int initTexture(MyGLSurFaceView mv, String texName, boolean isRepeat)//生成纹理id
	{
		int[] textures=new int[1];
		GLES30.glGenTextures
				(
						1,//产生的纹理id的数量
						textures,//纹理id的数组
						0//偏移量
				);
		GLES30.glBindTexture(GLES30.GL_TEXTURE_2D, textures[0]);//绑定纹理id
		//设置MAG时为线性采样
		GLES30.glTexParameterf
				(
						GLES30.GL_TEXTURE_2D,
						GLES30.GL_TEXTURE_MAG_FILTER,
						GLES30.GL_LINEAR
				);
		//设置MIN时为最近点采样
		GLES30.glTexParameterf
				(
						GLES30.GL_TEXTURE_2D,
						GLES30.GL_TEXTURE_MIN_FILTER,
						GLES30.GL_NEAREST
				);
		if(isRepeat)
		{
			//设置S轴的拉伸方式为重复拉伸
			GLES30.glTexParameterf
					(
							GLES30.GL_TEXTURE_2D,
							GLES30.GL_TEXTURE_WRAP_S,
							GLES30.GL_REPEAT
					);
			//设置T轴的拉伸方式为重复拉伸
			GLES30.glTexParameterf
					(
							GLES30.GL_TEXTURE_2D,
							GLES30.GL_TEXTURE_WRAP_T,
							GLES30.GL_REPEAT
					);
		}else
		{
			//设置S轴的拉伸方式为截取
			GLES30.glTexParameterf
					(
							GLES30.GL_TEXTURE_2D,
							GLES30.GL_TEXTURE_WRAP_S,
							GLES30.GL_CLAMP_TO_EDGE
					);
			//设置T轴的拉伸方式为截取
			GLES30.glTexParameterf
					(
							GLES30.GL_TEXTURE_2D,
							GLES30.GL_TEXTURE_WRAP_T,
							GLES30.GL_CLAMP_TO_EDGE
					);
		}
		InputStream in = null;
		try {
			in = mv.getResources().getAssets().open(Constant.TexturePath+texName);
		}catch (IOException e) {
			e.printStackTrace();
		}
		Bitmap bitmap= BitmapFactory.decodeStream(in);//从流中加载图片内容
		GLUtils.texImage2D
				(
						GLES30.GL_TEXTURE_2D,//纹理类型，在OpenGL ES中必须为GL30.GL_TEXTURE_2D
						0,//纹理的层次，0表示基本图像层，可以理解为直接贴图
						bitmap,//纹理图像
						0//纹理边框尺寸
				);
		bitmap.recycle();//纹理加载成功后释放内存中的纹理图
		return textures[0];
	}

	public static void loadingTexture(MyGLSurFaceView mv,int start,int picNum)//加载所有纹理图
	{
		for(int i=start;i<start+picNum;i++)
		{
			int texture=0;
			texture=initTexture(mv,texturesName[i],true);
			texList.put(texturesName[i],texture);//将数据加入到列表中
		}
	}

	public static int getTextures(String texName)//获得纹理图
	{
		int result=0;
		if(texList.get(texName)!=null)//如果列表中有此纹理图
		{
			result=texList.get(texName);//获取纹理图
		}
		else
		{
			result=-1;
		}
		System.out.println("result="+result+"texname="+texName);
		return result;
	}

}
