package com.bn.Scenes;

import com.bn.Util.LoadedObjectVertexNormalTexture;
import com.bn.Util.MatrixState2D;
import com.bn.Util.MatrixState3D;

public class Draw {
    public static void drawself(int datatlength, float data[][], LoadedObjectVertexNormalTexture lovo,int Id)
    {
        for(int i=0;i<datatlength;i++){
            MatrixState3D.pushMatrix();
            MatrixState3D.translate(data[i][0],data[i][1],data[i][2]);
            MatrixState3D.rotate(data[i][3], data[i][4], data[i][5],data[i][6]);
            MatrixState3D.scale(data[i][7], data[i][8], data[i][9]);
            lovo.drawSelf(Id);
            MatrixState3D.popMatrix();
        }
    }
    //绘制2d纹理图形
    public static void drawself2D(TextureRectangle2D tr2D,int Id,float cx,float cy,float width,float height,int type){
        MatrixState2D.pushMatrix();
        tr2D.drawSelf(Id,cx,cy,width,height,type);
        MatrixState2D.popMatrix();
    }

    public static void drawselfSingle(LoadedObjectVertexNormalTexture lovo,int id,float data[])
    {
        MatrixState3D.pushMatrix();
        MatrixState3D.translate(data[0],data[1],data[2]);
        MatrixState3D.rotate(data[3],data[4],data[5],data[6]);
        MatrixState3D.scale(data[7],data[8],data[9]);
        lovo.drawSelf(id);
        MatrixState3D.popMatrix();
    }
    //绘制卡片
    public static void drawselfMyCard(MyCard myCard ,int Id,float cx,float cy,float width,float height,int type,int cardCount){
        MatrixState2D.pushMatrix();
        myCard.drawSelf(Id,cx,cy,width,height,type,cardCount);
        MatrixState2D.popMatrix();
    }
}
