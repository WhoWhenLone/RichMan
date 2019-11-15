package com.bn.Util;

import android.opengl.Matrix;

import com.bn.Constant.Constant;

public class ScreenUtil 
{
	public static float[] getscreen
	(float r,float x,float y,float z)
	{
		float[] m=MatrixState3D.getVPMatrix();
		float[] p={x,y,z,1.0f};
		float[] pr=new float[4];
		Matrix.multiplyMV(pr, 0, m, 0, p, 0);
		if (Constant.SCREEN_HEIGHT>Constant.SCREEN_WIDTH)
		{
			return new float[]{pr[0]/pr[3],pr[1]/pr[3]*r};
		}
		else
		{
			return new float[]{pr[0]/pr[3]*r,pr[1]/pr[3]};
		}

	}
}