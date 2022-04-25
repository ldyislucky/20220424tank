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

    public Tank(int x, int y, Dir dir) {
      this.x = x;
      this.y = y;
      this.dir = dir;
    }

    public void tankpaint(Graphics g){
      g.fillRect(x,y,50,50);
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

  public boolean isMoving() {
    return Moving;
  }

  public void setMoving(boolean moving) {
    Moving = moving;
  }

  public Dir getDir() {
    return dir;
  }

  public void setDir(Dir dir) {
    this.dir = dir;
  }
}
