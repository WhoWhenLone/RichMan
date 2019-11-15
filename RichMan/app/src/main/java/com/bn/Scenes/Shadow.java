package com.bn.Scenes;

import android.opengl.GLES30;
import com.bn.RichMan.MyGLSurFaceView;
import com.bn.Util.MatrixState3D;
import com.bn.Util.ShaderUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import static com.bn.Constant.Constant.CameraState;
import static com.bn.Constant.Constant.Mapscale;

public class Shadow {

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

    final float UNIT_SIZE=1f;
    public Shadow(MyGLSurFaceView mv){
        initVertexData();
        initShader(mv);
    }
    public void initVertexData()
    {
        vCount = 6;
        float vertices[] = new float[]
        {
                0*UNIT_SIZE,0*UNIT_SIZE,0*UNIT_SIZE,
                0*UNIT_SIZE,0*UNIT_SIZE,1*UNIT_SIZE,
                1*UNIT_SIZE,0*UNIT_SIZE,1*UNIT_SIZE,

                0*UNIT_SIZE,0*UNIT_SIZE,0*UNIT_SIZE,
                1*UNIT_SIZE,0*UNIT_SIZE,1*UNIT_SIZE,
                1*UNIT_SIZE,0*UNIT_SIZE,0*UNIT_SIZE,
        };

        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        mVertexBuffer = vbb.asFloatBuffer();
        mVertexBuffer.put(vertices);
        mVertexBuffer.position(0);

        float texCoor[]=new float[]
        {
                0,0,
                0,1,
                1,1,

                0,0,
                1,1,
                1,0,
        };

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

    public void drawSelf(int texId,float lx,float ly,float lz)
    {
        GLES30.glUseProgram(mProgram);

        GLES30.glEnable(GLES30.GL_BLEND);			//开启混合
        GLES30.glBlendFunc(GLES30.GL_SRC_ALPHA,	//设置混合因子
                GLES30.GL_ONE_MINUS_SRC_ALPHA);
        MatrixState3D.setInitStack();//初始化变换矩阵

        if(CameraState==true)
        {
            MatrixState3D.translate(lx-0.4f*Mapscale,ly,lz-0.4f*Mapscale);
            MatrixState3D.scale(0.85f*Mapscale,0.85f*Mapscale,0.85f*Mapscale);
        }
        else
        {
            MatrixState3D.translate(lx-0.2f*Mapscale,ly,lz-0.2f*Mapscale);
            MatrixState3D.scale(0.45f*Mapscale,0.45f*Mapscale,0.45f*Mapscale);
        }

        //MatrixState3D.rotate(180,1,0,0);
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

        GLES30.glDisable(GLES30.GL_BLEND);
    }

}
