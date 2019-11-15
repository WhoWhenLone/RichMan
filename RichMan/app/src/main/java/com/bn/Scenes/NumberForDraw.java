package com.bn.Scenes;

import com.bn.RichMan.MyGLSurFaceView;
import com.bn.Util.MatrixState2D;
import com.bn.Util.ScreenScaleUtil;

import static com.bn.Constant.IdDataConstant.pointId;

/**
 * Created by Administrator on 2017/10/21.
 */

public class NumberForDraw {
    //创建十个数字纹理矩形
    TextureRectangle2D[] number;
    String priceStr;//价格数字字符串
    float width_height[]=new float[2];//0 w 1 h
    MyGLSurFaceView mv;
    public NumberForDraw(int numberSize, float width, float height, MyGLSurFaceView mv)
    {
        this.mv=mv;
        number=new TextureRectangle2D[numberSize];
        width_height= ScreenScaleUtil.from2DSizeTo3DSize(width,height);
        //生成十个数字纹理矩形
        for (int i=0;i<numberSize;i++)
        {
            number[i]=new TextureRectangle2D(
                    width_height[0],
                    width_height[1],
                    new float[]
                            {
                                   1f/numberSize*i,0,
                                    1f/numberSize*i,1,
                                    1f/numberSize*(i+1),0,
                                    1f/numberSize*(i+1),1,
                             },
                    mv
             );
        }
    }

    public void drawSelfPrice(String price,int texId,float x,float y)//传入数字和纹理坐标
    {
        priceStr = price;
        float xy[] = ScreenScaleUtil.fromPixPositionToScreenPosition(x,y);
        MatrixState2D.pushMatrix();
        MatrixState2D.translate(xy[0],xy[1],0);
        for (int i=0;i<priceStr.length();i++)
        {
            char c=priceStr.charAt(i);
            MatrixState2D.translate(width_height[0],0,0);
            number[c-'0'].numberdrawSelf(texId);
        }

        MatrixState2D.popMatrix();
    }
}
