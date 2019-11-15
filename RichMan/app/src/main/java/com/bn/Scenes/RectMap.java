package com.bn.Scenes;

import android.opengl.GLES30;

import com.bn.RichMan.MyGLSurFaceView;
import com.bn.Util.MatrixState3D;
import com.bn.Util.ShaderUtil;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;

import static com.bn.Constant.Constant.Mapscale;

public class RectMap {

	int mProgram;//自定义渲染管线程序id
	int muMVPMatrixHandle;//总变换矩阵引用id
	int maPositionHandle;//顶点位置属性引用id
	int maColorHandle;//顶点纹理坐标属性引用id
	int maTexCoorHandle;//顶点纹理坐标属性引用id
	String mVertexShader;//顶点着色器
	String mFragmentShader;//片元着色器
	FloatBuffer mVertexBuffer;//顶点坐标数据缓冲
	FloatBuffer mTexcoorBuffer;//顶点纹理坐标数据缓冲
	FloatBuffer mColorBuffer;//顶点颜色缓冲
	int vCount=0;//顶点个数
	public int xAngle=0;//绕x轴旋转角度
	public int yAngle=0;//绕y轴旋转角度
	public int zAngle=0;//绕z轴旋转角度

	final float UNIT_SIZE=1f;
	public RectMap(MyGLSurFaceView mv){
		initVertexData();
		initShader(mv);
	}
	public void initVertexData()
	{
		ArrayList<Float> alVertix = new ArrayList<Float>();
		ArrayList<Float> alTexture = new ArrayList<Float>();

		for(int i=-40;i<40;i++){
			for(int j=-20;j<50;j++){
				float x0=UNIT_SIZE*i;
				float y0=0;
				float z0=UNIT_SIZE*j;

				float x1=UNIT_SIZE*i;
				float y1=0;
				float z1=UNIT_SIZE*j+1f;

				float x2=UNIT_SIZE*i+1f;
				float y2=0;
				float z2=UNIT_SIZE*j+1f;

				float x3=UNIT_SIZE*i+1f;
				float y3=0;
				float z3=UNIT_SIZE*j;


				alVertix.add(x1);
				alVertix.add(y1);
				alVertix.add(z1);
				alVertix.add(x3);
				alVertix.add(y3);
				alVertix.add(z3);
				alVertix.add(x0);
				alVertix.add(y0);
				alVertix.add(z0);
				alVertix.add(x1);
				alVertix.add(y1);
				alVertix.add(z1);
				alVertix.add(x2);
				alVertix.add(y2);
				alVertix.add(z2);
				alVertix.add(x3);
				alVertix.add(y3);
				alVertix.add(z3);
			}
		}
		vCount = alVertix.size() / 3;
		float vertices[] = new float[vCount * 3];
		for (int i = 0; i < alVertix.size(); i++) {
			vertices[i] = alVertix.get(i);
		}
		ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
		vbb.order(ByteOrder.nativeOrder());
		mVertexBuffer = vbb.asFloatBuffer();
		mVertexBuffer.put(vertices);
		mVertexBuffer.position(0);


		for(int i=-40;i<40;i++){
			for(int j=-35;j<35;j++){
				if(i==12||i==-14||i==11||i==19||i==20){
					//横向 公路 贴图
					float tx0=0f;
					float ty0=0.25f;
					float tx1=0f;
					float ty1=0.5f;
					float tx2=0.25f;
					float ty2=0.5f;
					float tx3=0.25f;
					float ty3=0.25f;
					alTexture.add(tx1);
					alTexture.add(ty1);
					alTexture.add(tx3);
					alTexture.add(ty3);
					alTexture.add(tx0);
					alTexture.add(ty0);
					alTexture.add(tx1);
					alTexture.add(ty1);
					alTexture.add(tx2);
					alTexture.add(ty2);
					alTexture.add(tx3);
					alTexture.add(ty3);
				}
				else if(j==5||j==-31){
					//竖向 公路 贴图
					float tx0=0f;
					float ty0=0.5f;
					float tx1=0f;
					float ty1=0.75f;
					float tx2=0.25f;
					float ty2=0.75f;
					float tx3=0.25f;
					float ty3=0.5f;
					alTexture.add(tx1);
					alTexture.add(ty1);
					alTexture.add(tx3);
					alTexture.add(ty3);
					alTexture.add(tx0);
					alTexture.add(ty0);
					alTexture.add(tx1);
					alTexture.add(ty1);
					alTexture.add(tx2);
					alTexture.add(ty2);
					alTexture.add(tx3);
					alTexture.add(ty3);
				}
				else{
					//砖贴图
					float tx0=0.75f;
					float ty0=0.25f;
					float tx1=0.75f;
					float ty1=0.5f;
					float tx2=1f;
					float ty2=0.5f;
					float tx3=1f;
					float ty3=0.25f;
					alTexture.add(tx1);
					alTexture.add(ty1);
					alTexture.add(tx3);
					alTexture.add(ty3);
					alTexture.add(tx0);
					alTexture.add(ty0);
					alTexture.add(tx1);
					alTexture.add(ty1);
					alTexture.add(tx2);
					alTexture.add(ty2);
					alTexture.add(tx3);
					alTexture.add(ty3);
				}
			}
		}

		float texCoor[]=new float[vCount*2];
		for (int i = 0; i < alTexture.size(); i++) {
			texCoor[i] = alTexture.get(i);
		}
		ByteBuffer cbb = ByteBuffer.allocateDirect(texCoor.length*4);
		cbb.order(ByteOrder.nativeOrder());
		mTexcoorBuffer = cbb.asFloatBuffer();
		mTexcoorBuffer.put(texCoor);
		mTexcoorBuffer.position(0);
	}

	public void initShader(MyGLSurFaceView mv)
	{
		mVertexShader= ShaderUtil.loadFromAssetsFile
				("vertex_tex.sh",mv.getResources());//加载顶点着色器的脚本内容
		mFragmentShader = ShaderUtil.loadFromAssetsFile
				("frag_tex.sh",mv.getResources());//加载片元着色器的脚本内容
		mProgram = ShaderUtil.createProgram(mVertexShader,mFragmentShader);//基于顶点着色器与片元着色器 创建程序
		maPositionHandle= GLES30.glGetAttribLocation(mProgram,"aPosition");///获取程序中的顶点位置属性id
		maTexCoorHandle = GLES30.glGetAttribLocation(mProgram,"aTexCoor");//获取程序中的顶点纹理坐标属性id
		//maColorHandle = GLES30.glGetAttribLocation(mProgram,"aColor");//获取程序中的顶点纹理坐标属性id
		muMVPMatrixHandle = GLES30.glGetUniformLocation(mProgram,"uMVPMatrix");//获取程序中的总变换矩阵id
	}

	public void drawSelf(int texId)
	{
		GLES30.glUseProgram(mProgram);
		MatrixState3D.setInitStack();//初始化变换矩阵
		MatrixState3D.translate(0,2.8f*Mapscale,0);
		MatrixState3D.rotate(90,0,1,0);
		MatrixState3D.scale(Mapscale,Mapscale,Mapscale);
		GLES30.glUniformMatrix4fv(muMVPMatrixHandle, 1, false, MatrixState3D.getFinalMatrix(),0);
		GLES30.glVertexAttribPointer
				(
						maPositionHandle,
						3,
						GLES30.GL_FLOAT,
						false,
						3*4,
						mVertexBuffer
				);
		GLES30.glVertexAttribPointer(//为画笔指定顶点纹理坐标数据
				maTexCoorHandle,
				2,
				GLES30.GL_FLOAT,
				false,
				2*4,
				mTexcoorBuffer);
		GLES30.glEnableVertexAttribArray(maPositionHandle);//允许顶点位置数据数组
		GLES30.glEnableVertexAttribArray(maTexCoorHandle);//允许顶点纹理数据数组

		GLES30.glActiveTexture(GLES30.GL_TEXTURE0);
		GLES30.glBindTexture(GLES30.GL_TEXTURE_2D, texId);
		GLES30.glDrawArrays(GLES30.GL_TRIANGLES, 0, vCount);
	}

}
