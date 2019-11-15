package com.bn.Scenes;

import com.bn.Util.LoadedObjectVertexNormalTexture;
import com.bn.Util.MatrixState3D;

public class CubeRoad {

    int CubeRoadId;
    public int RoadState;
    int CurrtexId;
    float dataArray[];
    LoadedObjectVertexNormalTexture lovoCurr;

    public CubeRoad(int CubeRoadId,int RoadState,
            LoadedObjectVertexNormalTexture lovoCurr,int CurrtexId,float dataArray[])
    {
        this.CubeRoadId = CubeRoadId;
        this.RoadState = RoadState;
        this.lovoCurr = lovoCurr;
        this.CurrtexId = CurrtexId;
        this.dataArray = dataArray;
    }

    public int getRoadState()
    {
        return RoadState;
    }

    public void changeData(int RoadState,
           LoadedObjectVertexNormalTexture lovoCurr,int CurrtexId,float dataArray[])
    {
        this.RoadState = RoadState;
        this.lovoCurr = lovoCurr;
        this.CurrtexId = CurrtexId;
        this.dataArray = dataArray;
    }
    public void drawSelf()
    {
        MatrixState3D.pushMatrix();
        MatrixState3D.translate(dataArray[0],dataArray[1],dataArray[2]);
        MatrixState3D.rotate(dataArray[3],dataArray[4],dataArray[5],dataArray[6]);
        MatrixState3D.scale(dataArray[7],dataArray[8],dataArray[9]);
        lovoCurr.drawSelf(CurrtexId);
        MatrixState3D.popMatrix();
    }
}
