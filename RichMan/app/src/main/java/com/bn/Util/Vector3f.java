package com.bn.Util;
/*
 * 代表3D空间中向量的类
 */
public class Vector3f {
	//向量的三个分量
	public float x, y, z;
	//构造器
	public Vector3f(){}
	public Vector3f(float x, float y, float z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	//将向量规格化的方法
	public void normalize(){
		float mod = module();
		//保证模不为零时再规格化向量
		if(mod != 0){
			x = x/mod;
			y = y/mod;
			z = z/mod;
		}
	}

	//加法
	public Vector3f add(Vector3f v){
		return new Vector3f(this.x+v.x,this.y+v.y,this.z+v.z);
	}
	//减法
	public Vector3f minus(Vector3f v){
		return new Vector3f(this.x-v.x,this.y-v.y,this.z-v.z);
	}
	//与常量相乘
	public Vector3f multiK(float k){
		return new Vector3f(this.x*k,this.y*k,this.z*k);
	}
	//求向量的模的方法
	public float module(){
		return (float) Math.sqrt(x*x + y*y + z*z);
	}
}
