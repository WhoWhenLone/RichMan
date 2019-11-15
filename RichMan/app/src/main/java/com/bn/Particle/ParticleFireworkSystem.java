package com.bn.Particle;

import android.opengl.GLES30;
import android.support.annotation.NonNull;

import com.bn.Util.MatrixState3D;

import static android.R.attr.direction;
import static com.bn.Constant.Constant.cx;
import static com.bn.Constant.Constant.cz;
import static com.bn.Particle.ParticleFireworkDataConstant.*;
import static com.bn.RichMan.R.attr.elevation;


/**
 * Created by Administrator on 2017/12/21.
 */

public class ParticleFireworkSystem implements Comparable<ParticleFireworkSystem>
{

    //起始颜色
    public float[] startColor;
    //终止颜色
    public float[] endColor;
    //源混合因子
    public int srcBlend;
    //目标混合因子
    public int dstBlend;
    //混合方式
    public int blendFunc;
    //粒子最大生命期
    public float maxLifeSpan;
    //粒子生命期步进
    public float lifeSpanStep;
    //粒子更新线程休眠时间间隔
    public int sleepSpan;
    //每次喷发的例子数量
    public int groupCount;
    //基础发射点
    public float sx;
    public float sy;
    public float sz;
    //绘制位置
    float positionX;
    float positionY;
    float positionZ;
    //发射点变化范围
    public float xRange;
    public float yRange;
    public float zRange;
    //粒子发射的速度
    public float vx;
    public float vy;
    public float vz;
    //旋转角度
    float yAngle=0;
    //绘制者
    ParticleFireworkForDraw fpfd;
    //工作标志位
    boolean flag=true;

    float halfSize;
    public float[] points;//粒子数
    public ParticleFireworkSystem(float positionx, float positiony, float positionz, ParticleFireworkForDraw fpfd, int count)
    {
        this.positionX=positionx;//初始化此粒子系统的绘制位置x坐标
        this.positionY=positiony;//初始化此粒子系统的绘制位置y坐标
        this.positionZ=positionz;//粒子的
        this.startColor=START_COLOR;//初始化粒子起始颜色
        this.endColor=END_COLOR;//初始化粒子终止颜色
        this.srcBlend=SRC_BLEND;//初始化源混合因子
        this.dstBlend=DST_BLEND;//初始化目标混合因子
        this.blendFunc=BLEND_FUNC;//初始化混合方式
        this.maxLifeSpan=MAX_LIFE_SPAN;//初始化每个粒子的最大生命期
        this.lifeSpanStep=LIFE_SPAN_STEP;//初始化每个粒子的生命步进
        this.groupCount=GROUP_COUNT;//初始化每批喷发的粒子数
        this.sleepSpan=THREAD_SLEEP;//初始化线程的休眠时间
        this.sx=0;//初始化此粒子系统的中心点x坐标
        this.sy=0;//初始化此粒子系统的中心点y坐标
        this.sz=0;//初始化此粒子系统的中心点z坐标
        this.xRange=X_RANGE;//初始粒子距离中心点x方向的最大距离
        this.yRange=Y_RANGE;//初始粒子距离中心点y方向的最大距离
        this.zRange=Z_RANGE;
        this.vx=0;//初始化粒子的x方向运动速度
        this.vy=VY;//初始化粒子的y方向运动速度
        this.vz=0;//初始化粒子的z方向运动速度
        this.halfSize=RADIS;//初始化此粒子系统的粒子半径

        this.fpfd=fpfd;//初始化粒子群的绘制者

        this.points=initPoints(count);//初始化粒子顶点数据数组
        fpfd.initVertexData(points);//调用初始化顶点坐标的方法

        new Thread()
        {
            public void run()
            {
                while(flag)
                {
                    update();
                    try
                    {
                        Thread.sleep(sleepSpan);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public float[] initPoints(int zcount)
    {//初始化粒子顶点数据的方法
        float[] points=new float[zcount*4];//临时存放顶点数据的数组-每个粒子对应1个顶点，每个顶点包含4个值
        for(int i=0;i<zcount;i++)//groupCount
        {//循环遍历所有粒子
//            //在中心附近产生产生粒子的位置------**/
            double elevation=Math.random()*Math.PI-Math.PI/2;//仰角
            double direction=Math.random()*Math.PI*2;//方位角

            float px = (float)(Math.cos(elevation)*Math.cos(direction));
            float py = (float)(Math.cos(elevation)*Math.sin(direction));
            float pz = (float)Math.sin(elevation);

            //计算出粒子在XYZ轴方向的速度分量
            float vy1=(float)(vy*Math.sin(elevation));
            float vx=(float)(vy*Math.cos(elevation)*Math.cos(direction));
            float vz=(float)(vy*Math.cos(elevation)*Math.sin(direction));
            points[i*4]=  vy1;//粒子对应的第一个点的x坐标
            points[i*4+1]=vx;//粒子对应的第一个点的y坐标
            points[i*4+2]=vz;//粒子对应的第一个点的z坐标

//            points[i*4]=  px;//粒子对应的第一个点的x坐标
//            points[i*4+1]=py;//粒子对应的第一个点的y坐标
//            points[i*4+2]=pz;//粒子对应的第一个点的z坐标
            points[i*4+3]=10.0f;//粒子对应的第一个点的当前生命期--10代表粒子处于未激活状态
        }
        for(int j=0;j<groupCount;j++)
        {//循环遍历第一批的粒子
            points[j*4+3]=lifeSpanStep;//设置粒子生命期，不为10时，表示粒子处于活跃状态
        }
        return points;//返回所有粒子顶点属性数据
    }

//    int countt=0;//计算帧速率的时间间隔次数--计算器
//	long timeStart=System.nanoTime();//开始时间

    public void drawSelf(int texId)
    {

        //关闭深度检测
        GLES30.glDisable(GLES30.GL_DEPTH_TEST);
        //开启混合
        GLES30.glEnable(GLES30.GL_BLEND);
        //设置混合方式
        GLES30.glBlendEquation(blendFunc);
        //设置混合因子
        GLES30.glBlendFunc(srcBlend,dstBlend);

      //  MatrixState3D.translate(positionX, 1, positionZ);
        MatrixState3D.rotate(yAngle, 0, 1, 0);

        MatrixState3D.pushMatrix();//保护现场
        fpfd.drawSelf(texId,startColor,endColor,maxLifeSpan);//绘制粒子群
        MatrixState3D.popMatrix();//恢复现场

        //开启深度检测
        GLES30.glEnable(GLES30.GL_DEPTH_TEST);
        //关闭混合
        GLES30.glDisable(GLES30.GL_BLEND);
    }

    int count=1;//激活粒子的位置计算器
    public void update()//更新粒子状态的方法
    {
        if(count>=(points.length/groupCount/4))//计算器超过激活粒子位置时
        {
            count=0;//重新计数
        }

        //查看生命期以及计算下一位置
        for(int i=0;i<points.length/4;i++)
        {//循环遍历所有粒子
            if(points[i*4+3]!=10.0f)//当前为活跃粒子时
            {
                points[i*4+3]+=lifeSpanStep;//计算当前生命期
                if(points[i*4+3]>this.maxLifeSpan)//当前生命期大于最大生命期时---重新设置该粒子参数
                {
                    float px=(float) (sx+xRange*(Math.random()*2-1.0f));//计算粒子位置x坐标
                    float py=(float) (sy+yRange*(Math.random()*2-1.0f));//计算粒子位置y坐标
                    float pz=(float) (sz+zRange*(Math.random()*2-1.0f));//计算粒子位置z坐标

                    double elevation=Math.random()*Math.PI-Math.PI/2;//仰角
                    double direction=Math.random()*Math.PI*2;//方位角

                    //计算出粒子在XYZ轴方向的速度分量
                    float vy1=(float)(vy*Math.sin(elevation));
                    float vx=(float)(vy*Math.cos(elevation)*Math.cos(direction));
                    float vz=(float)(vy*Math.cos(elevation)*Math.sin(direction));
                    points[i*4]=  vy1;//粒子对应的第一个点的x坐标
                    points[i*4+1]=vx;//粒子对应的第一个点的y坐标
                    points[i*4+2]=vz;//粒子对应的第一个点的z坐标
//                    points[i*4]=px;//将粒子位置的x坐标存入points数组中
//                    points[i*4+1]=py;//将粒子位置的y坐标存入points数组中
//                    points[i*4+2]=vy;//将粒子x方向的速度存入points数组中
                    points[i*4+3]=10.0f;//将粒子的当前生命期存入points数组中----为10时，粒子处于没有被激活状态，不为10时，粒子处于活跃状态
                }else//当前生命期小于最大生命期时----计算粒子的下一位置坐标
                {
                    points[i*4]+=points[i*4+2];//计算粒子位置的x坐标
                    points[i*4+1]+=vy*Math.cos(Math.cos(elevation)*Math.cos(direction));//计算粒子位置的y坐标
                    points[i*4+2]-=vz;
                }
            }
        }

        for(int i=0;i<groupCount;i++)
        {//循环发射一批激活计数器所指定位置的粒子
            if(points[groupCount*count*4+4*i+3]==10.0f)//如果粒子处于未激活状态时
            {
                points[groupCount*count*4+4*i+3]=lifeSpanStep;//激活粒子--设置粒子当前的生命期
            }
        }

        synchronized(lock)
        {//加锁--防止在更新顶点坐标数据时，将顶点坐标数据送入渲染管线
            fpfd.updatVertexData(points);//更新顶点坐标数据缓冲的方法
        }
        //下次激活粒子的位置
        count++;
    }

    public void calculateBillboardDirection()
    {
        //根据摄像机位置计算火焰朝向
        float xspan=positionX-cx;
        float zspan=positionZ-cz;

        if(zspan<=0)
        {
            yAngle=(float)Math.toDegrees(Math.atan(xspan/zspan));
        }
        else
        {
            yAngle=180+(float)Math.toDegrees(Math.atan(xspan/zspan));
        }
    }
    @Override
    public int compareTo(ParticleFireworkSystem another) {
        //重写的比较两个火焰离摄像机距离的方法
        float xs=positionX- MatrixState3D.cameraPosition[0];//cx
        float zs=positionZ- MatrixState3D.cameraPosition[1];//cz

        float xo=another.positionX- MatrixState3D.cameraPosition[0];//cx
        float zo=another.positionZ- MatrixState3D.cameraPosition[2];//cz

        float disA=(float)(xs*xs+zs*zs);
        float disB=(float)(xo*xo+zo*zo);
        return ((disA-disB)==0)?0:((disA-disB)>0)?-1:1;
    }


}
