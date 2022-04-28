package com.ldy;

import java.awt.*;

/**
 * @author : ldy
 * @version : 1.0
 */
public class Tank {
    private int x;
    private int y;
    private Dir dir;
    private boolean Moving = false;
    private final static int speed = 10 ;
    private final TankFrame tankFrame;

    public Tank(int x, int y, Dir dir, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }


    public void tankpaint(Graphics g){
      //g.setColor(Color.MAGENTA);
      //g.fillRect(x,y,50,50);
        switch (dir){
            case LEFT:
                g.drawImage(ResurseMgr.tankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResurseMgr.tankR,x,y,null);
                break;
            case UP:
                g.drawImage(ResurseMgr.tankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResurseMgr.tankD,x,y,null);
                break;
        }

      if (Moving){
        switch (dir){
          case LEFT:
            x-=speed;
            break;
          case RIGHT:
            x+=speed;
            break;
          case UP:
            y-=speed;
            break;
          case DOWN:
            y+=speed;
            break;
        }
      }
    }
    public void fire(){
        tankFrame.list.add(new Bullet(x+15,y+15,this.dir,tankFrame));
    }


  public void setMoving(boolean moving) {
    Moving = moving;
  }


  public void setDir(Dir dir) {
    this.dir = dir;
  }
}
