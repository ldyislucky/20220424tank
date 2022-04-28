package com.ldy;

import java.awt.*;

/**
 * @author : ldy
 * @version : 1.0
 */
public class Bullet {
  private int x,y;
  private Dir dir;
  private final int speed = 20;
  private TankFrame tankFrame ;
  private boolean live = true;

  public Bullet(int x, int y, Dir dir, TankFrame tankFrame) {
    this.x = x;
    this.y = y;
    this.dir = dir;
    this.tankFrame = tankFrame;
  }


  public void bPaint(Graphics g){
    g.setColor(Color.GREEN);
    g.fillOval(x,y,20,20);
    move();
    if (!live){
      tankFrame.list.remove(this);
    }
  }

  private void move() {
      switch (dir) {
        case LEFT:
          x -= speed;
          break;
        case RIGHT:
          x += speed;
          break;
        case UP:
          y -= speed;
          break;
        case DOWN:
          y += speed;
          break;
      }
      if (x<0||y<0||x>tankFrame.w||y>tankFrame.h){
        this.live=false;
      }
  }
}
