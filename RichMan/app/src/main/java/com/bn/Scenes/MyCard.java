package com.bn.Scenes;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.opengl.GLES30;
import android.os.Build;

import com.bn.Constant.Constant;
import com.bn.RichMan.MyGLSurFaceView;
import com.bn.Util.MatrixState2D;
import com.bn.Util.ShaderUtil;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import static com.bn.Constant.Constant.SCREEN_HEIGHT;
import static com.bn.Constant.Constant.SCREEN_WIDTH;

/**
 * Created by Administrator on 2017/12/8.
 */

public class MyCard {
    int vCount = 6;

    FloatBuffer mVertexBuffer;//顶点坐标数据缓冲
    FloatBuffer mTextureBuffer;//顶点纹理坐标数据缓冲
    int mCardCountHandle;//卡片数量的引用
    int mProgram;// 自定义渲染管线程序id
    int muMVPMatrixHandle;// 总变换矩阵引用id
    int maPositionHandle; // 顶点位置属性引用id
    int maTexCoorHandle; // 顶点纹理坐标属性引用id
    int maNormalHandle; //顶点法向量属性引用
    int muMMatrixHandle;//位置、旋转变换矩阵
    String mVertexShader;// 顶点着色器
    String mFragmentShader;// 片元着色器
    float hlafHigh;
    float hlafWidth;
    public float targetX;
    public float inittargetX;
    public float currX;
    public float initX;
    final float US = 0.03f;
    public float[] textures;//定义纹理坐标
    float[] vertices;//定义顶点坐标
    public boolean drawState;//是否绘制标志位

    public MyCard(MyGLSurFaceView mv, boolean drawState)
    {
        this.drawState=drawState;
        initVertexData();
        initShader(mv);
    }

    private void initVertexData()
    {
        float vertices[] = new float[] {
                -1,1,0,//0
                1,-1,0,//2
                1,1,0,//3
                -1,1,0,//0
                -1,-1,0,//1
                1,-1,0//2
        };
        ByteBuffer vbb_advance = ByteBuffer
                .allocateDirect(vertices.length * 4);
        vbb_advance.order(ByteOrder.nativeOrder());
        mVertexBuffer = vbb_advance.asFloatBuffer();
        mVertexBuffer.put(vertices);
        mVertexBuffer.position(0);
        float[] textures = new float[] {
                0, 0,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1};
        ByteBuffer cbb_advance = ByteBuffer
                .allocateDirect(textures.length * 4);
        cbb_advance.order(ByteOrder.nativeOrder());
        mTextureBuffer = cbb_advance.asFloatBuffer();
        mTextureBuffer.put(textures);
        mTextureBuffer.position(0);

    }

    @SuppressLint("NewApi")
    public void initShader(MyGLSurFaceView mv) {
        // 加载顶点着色器的脚本内容
        mVertexShader = ShaderUtil.loadFromAssetsFile("vertex_card.sh",
                mv.getResources());
        // 加载片元着色器的脚本内容
        mFragmentShader = ShaderUtil.loadFromAssetsFile("frag_card.sh",
                mv.getResources());
        // 基于顶点着色器与片元着色器创建程序
        mProgram = ShaderUtil.createProgram(mVertexShader, mFragmentShader);
        //获取位置、旋转变换矩阵引用
        muMMatrixHandle = GLES30.glGetUniformLocation(mProgram, "uMMatrix");
        //获取程序中顶点颜色属性引用
        maNormalHandle= GLES30.glGetAttribLocation(mProgram, "aNormal");
        // 获取程序中顶点位置属性引用id
        maPositionHandle = GLES30.glGetAttribLocation(mProgram, "aPosition");
        // 获取程序中顶点纹理坐标属性引用id
        maTexCoorHandle = GLES30.glGetAttribLocation(mProgram, "aTexCoor");
        // 获取程序中总变换矩阵引用id
        muMVPMatrixHandle = GLES30.glGetUniformLocation(mProgram, "uMVPMatrix");
        //获取程序中卡片数量的引用
        mCardCountHandle = GLES30.glGetUniformLocation(mProgram, "cardCount");
    }

    public void drawSelf(int texId,int cardCount) {
        // 制定使用某套shader程序
        GLES30.glUseProgram(mProgram);
        // 将最终变换矩阵传入shader程序
        GLES30.glUniformMatrix4fv(muMVPMatrixHandle, 1, false,
                MatrixState2D.getFinalMatrix(), 0);
        //将当前卡片数量传入渲染管线
        GLES30.glUniform1i(mCardCountHandle,cardCount);
        // 为画笔指定顶点位置数据
        GLES30.glVertexAttribPointer(maPositionHandle, 3, GLES30.GL_FLOAT,
                false, 3 * 4, mVertexBuffer);
        // 为画笔指定顶点纹理坐标数据
        GLES30.glVertexAttribPointer(maTexCoorHandle, 2, GLES30.GL_FLOAT,
                false, 2 * 4, mTextureBuffer);

        // 允许顶点位置数据数组
        GLES30.glEnableVertexAttribArray(maPositionHandle);
        GLES30.glEnableVertexAttribArray(maTexCoorHandle);

        // 绑定纹理
        GLES30.glActiveTexture(GLES30.GL_TEXTURE0);
        GLES30.glBindTexture(GLES30.GL_TEXTURE_2D, texId);
        // 绘制纹理矩形
        GLES30.glDrawArrays(GLES30.GL_TRIANGLES, 0, vCount);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2) @SuppressLint("NewApi")
    public void drawSelf(int texId,float cx,float cy, float Width,float High,int type ,int cardCount)
    {
        if(drawState==true)
        {
            // 制定使用某套shader程序
            GLES30.glUseProgram(mProgram);

            float xDraw=cx;
            float yDraw=cy;
            if(type!=2)//位置不是Open GL ES坐标
            {
                if (SCREEN_HEIGHT>SCREEN_WIDTH)
                {
                    xDraw=(cx- Constant.SCREEN_WIDTH/2)/(Constant.SCREEN_WIDTH/2);
                    yDraw=(Constant.SCREEN_HEIGHT/2-cy)/(Constant.SCREEN_HEIGHT/2)*(Constant.SCREEN_HEIGHT/Constant.SCREEN_WIDTH);
                }
                else if (SCREEN_HEIGHT<SCREEN_WIDTH)
                {
                    yDraw= 	((Constant.SCREEN_HEIGHT/2)-cy)/(Constant.SCREEN_HEIGHT/2);
                    xDraw= (cx-(SCREEN_WIDTH/2))/(SCREEN_WIDTH/2)*(SCREEN_WIDTH/SCREEN_HEIGHT);
                }
            }

            if(type==0)//根据Open GL ES的坐标大小绘制一个长方形
            {
                this.hlafHigh = High;
                this.hlafWidth = Width;
            }
            else if(SCREEN_HEIGHT>SCREEN_WIDTH)//根据像素大小的坐标绘制一个长方形
            {
                this.hlafHigh = (High/Constant.SCREEN_HEIGHT)*(Constant.SCREEN_HEIGHT/Constant.SCREEN_WIDTH);
                this.hlafWidth = Width/Constant.SCREEN_WIDTH;
            }
            else if (SCREEN_HEIGHT<SCREEN_WIDTH)
            {
                this.hlafHigh = (High/Constant.SCREEN_HEIGHT);
                this.hlafWidth =( Width/Constant.SCREEN_WIDTH)*(Constant.SCREEN_WIDTH/Constant.SCREEN_HEIGHT);
            }
            //保护现场
            MatrixState2D.translate(xDraw,yDraw,0);
            MatrixState2D.scale(hlafWidth,hlafHigh,1);

            // 将最终变换矩阵传入shader程序
            GLES30.glUniformMatrix4fv(muMVPMatrixHandle, 1, false,
                    MatrixState2D.getFinalMatrix(), 0);
            //将当前卡片数量传入渲染管线
            GLES30.glUniform1i(mCardCountHandle,cardCount);
            // 为画笔指定顶点位置数据
            GLES30.glVertexAttribPointer(maPositionHandle, 3, GLES30.GL_FLOAT,
                    false, 3 * 4, mVertexBuffer);
            // 为画笔指定顶点纹理坐标数据
            GLES30.glVertexAttribPointer(maTexCoorHandle, 2, GLES30.GL_FLOAT,
                    false, 2 * 4, mTextureBuffer);

            // 允许顶点位置数据数组
            GLES30.glEnableVertexAttribArray(maPositionHandle);
            GLES30.glEnableVertexAttribArray(maTexCoorHandle);

            // 绑定纹理
            GLES30.glActiveTexture(GLES30.GL_TEXTURE0);
            GLES30.glBindTexture(GLES30.GL_TEXTURE_2D, texId);
            // 绘制纹理矩形
            GLES30.glDrawArrays(GLES30.GL_TRIANGLES, 0, vCount);
        }
    }
}
