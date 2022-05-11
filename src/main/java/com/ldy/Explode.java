package com.ldy;

import java.awt.*;

/**
 * @author : ldy
 * @version : 1.0
 */
public class Explode {

    public void explodePaint(Graphics g,int x,int y){
        g.drawImage(ResurseMgr.explode,x,y,30,30,null);
    }
}
