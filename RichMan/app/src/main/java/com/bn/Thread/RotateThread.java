package com.bn.Thread;

import static com.bn.Constant.Constant.Mapscale;
import static com.bn.Scenes.ScenesData.*;

public class RotateThread extends Thread {
    float angle = 0 ;
    @Override
    public void run()
    {
        while (true)
        {
            //i++;
            angle = angle + 0.3f;
            motianlundata[0][3] = angle;

            qichedata[0][0]+=0.1f*Mapscale;
            if(qichedata[0][0]>=14.5f*Mapscale)
            {
                qichedata[0][0] = -14.5f*Mapscale;
            }
            qichedata[1][0]+=0.1f*Mapscale;
            if(qichedata[1][0]>=14.5f*Mapscale)
            {
                qichedata[1][0] = -14.5f*Mapscale;
            }
            qichedata[2][0]+=0.1f*Mapscale;
            if(qichedata[2][0]>=14.5f*Mapscale)
            {
                qichedata[2][0] = -14.5f*Mapscale;
            }
            qichedata[3][0]-=0.1f*Mapscale;
            if(qichedata[3][0]<=-14.5f*Mapscale)
            {
                qichedata[3][0] = 14.5f*Mapscale;
            }

            qichedata[4][0]+=0.1f*Mapscale;
            if(qichedata[4][0]>=14.5f*Mapscale)
            {
                qichedata[4][0] = -14.5f*Mapscale;
            }
            qichedata[5][0]+=0.1f*Mapscale;
            if(qichedata[5][0]>=14.5f*Mapscale)
            {
                qichedata[5][0] = -14.5f*Mapscale;
            }
            qichedata[6][0]+=0.1f*Mapscale;
            if(qichedata[6][0]>=14.5f*Mapscale)
            {
                qichedata[6][0] = -14.5f*Mapscale;
            }
            qichedata[7][0]-=0.1f*Mapscale;
            if(qichedata[7][0]<=-14.5f*Mapscale)
            {
                qichedata[7][0] = 14.5f*Mapscale;
            }

            motianlunroom1data[0][0] = (float) (4.7f*Mapscale+(4.0f-2.45f)*Mapscale*Math.sin(Math.toRadians(0-angle)));
            motianlunroom1data[0][1] = (float) (3.85f*Mapscale+1.0f*Mapscale+(4.0f-2.45f)*Mapscale*Math.cos(Math.toRadians(0-angle)));

            motianlunroom2data[0][0] = (float) (4.7f*Mapscale+(4.0f-2.45f)*Mapscale*Math.sin(Math.toRadians(30.0f-angle)));
            motianlunroom2data[0][1] = (float) (3.85f*Mapscale+1.0f*Mapscale+(4.0f-2.45f)*Mapscale*Math.cos(Math.toRadians(30.0f-angle)));

            motianlunroom3data[0][0] = (float) (4.7f*Mapscale+(4.0f-2.45f)*Mapscale*Math.sin(Math.toRadians(30.0f*2-angle)));
            motianlunroom3data[0][1] = (float) (3.85f*Mapscale+1.0f*Mapscale+(4.0f-2.45f)*Mapscale*Math.cos(Math.toRadians(30.0f*2-angle)));

            motianlunroom4data[0][0] = (float) (4.7f*Mapscale+(4.0f-2.45f)*Mapscale*Math.sin(Math.toRadians(30.0f*3-angle)));
            motianlunroom4data[0][1] = (float) (3.85f*Mapscale+1.0f*Mapscale+(4.0f-2.45f)*Mapscale*Math.cos(Math.toRadians(30.0f*3-angle)));

            motianlunroom5data[0][0] = (float) (4.7f*Mapscale+(4.0f-2.45f)*Mapscale*Math.sin(Math.toRadians(30.0f*4-angle)));
            motianlunroom5data[0][1] = (float) (3.85f*Mapscale+1.0f*Mapscale+(4.0f-2.45f)*Mapscale*Math.cos(Math.toRadians(30.0f*4-angle)));

            motianlunroom6data[0][0] = (float) (4.7f*Mapscale+(4.0f-2.45f)*Mapscale*Math.sin(Math.toRadians(30.0f*5-angle)));
            motianlunroom6data[0][1] = (float) (3.85f*Mapscale+1.0f*Mapscale+(4.0f-2.45f)*Mapscale*Math.cos(Math.toRadians(30.0f*5-angle)));

            motianlunroom7data[0][0] = (float) (4.7f*Mapscale+(4.0f-2.45f)*Mapscale*Math.sin(Math.toRadians(30.0f*6-angle)));
            motianlunroom7data[0][1] = (float) (3.85f*Mapscale+1.0f*Mapscale+(4.0f-2.45f)*Mapscale*Math.cos(Math.toRadians(30.0f*6-angle)));

            motianlunroom8data[0][0] = (float) (4.7f*Mapscale+(4.0f-2.45f)*Mapscale*Math.sin(Math.toRadians(30.0f*7-angle)));
            motianlunroom8data[0][1] = (float) (3.85f*Mapscale+1.0f*Mapscale+(4.0f-2.45f)*Mapscale*Math.cos(Math.toRadians(30.0f*7-angle)));

            motianlunroom9data[0][0] = (float) (4.7f*Mapscale+(4.0f-2.45f)*Mapscale*Math.sin(Math.toRadians(30.0f*8-angle)));
            motianlunroom9data[0][1] = (float) (3.85f*Mapscale+1.0f*Mapscale+(4.0f-2.45f)*Mapscale*Math.cos(Math.toRadians(30.0f*8-angle)));

            motianlunroom10data[0][0] = (float) (4.7f*Mapscale+(4.0f-2.45f)*Mapscale*Math.sin(Math.toRadians(30.0f*9-angle)));
            motianlunroom10data[0][1] = (float) (3.85f*Mapscale+1.0f*Mapscale+(4.0f-2.45f)*Mapscale*Math.cos(Math.toRadians(30.0f*9-angle)));

            motianlunroom11data[0][0] = (float) (4.7f*Mapscale+(4.0f-2.45f)*Mapscale*Math.sin(Math.toRadians(30.0f*10-angle)));
            motianlunroom11data[0][1] = (float) (3.85f*Mapscale+1.0f*Mapscale+(4.0f-2.45f)*Mapscale*Math.cos(Math.toRadians(30.0f*10-angle)));

            motianlunroom12data[0][0] = (float) (4.7f*Mapscale+(4.0f-2.45f)*Mapscale*Math.sin(Math.toRadians(30.0f*11-angle)));
            motianlunroom12data[0][1] = (float) (3.85f*Mapscale+1.0f*Mapscale+(4.0f-2.45f)*Mapscale*Math.cos(Math.toRadians(30.0f*11-angle)));
            try
            {
                sleep(50);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

}
