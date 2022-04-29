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
    switch (dir){
      case LEFT:
        g.fillOval(x-20,y+10,10,10);
        break;
      case RIGHT:
        g.fillOval(x+40,y+10,10,10);
        break;
      case UP:
        g.fillOval(x+10,y-20,10,10);
        break;
      case DOWN:
        g.fillOval(x+10,y+40,10,10);
        break;
      default:
        break;
    }

    move();
    if (!live){
      tankFrame.bullets.remove(this);
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

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }
  public  void collision(Tank tank){
    Rectangle rec1 = new Rectangle(this.x, this.y, 10, 10);
    Rectangle rec2 = new Rectangle(tank.getX(), tank.getY(), 60, 60);
    if (rec1.intersects(rec2)){
      this.die();
      tank.die();
    }

  }

  private void die() {
    tankFrame.bullets.remove(this);
  }
}
