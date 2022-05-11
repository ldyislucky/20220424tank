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
  private Group group = Group.BAD;
  private Explode explode = new Explode();
  Rectangle rect = new Rectangle();

  public Bullet(int x, int y, Dir dir, TankFrame tankFrame, Group group) {
    this.x = x;
    this.y = y;
    this.dir = dir;
    this.tankFrame = tankFrame;
    this.group = group;
    rect.x=this.x;
    rect.y=this.y;
    rect.height=10;
    rect.width=10;
  }

  public void bPaint(Graphics g){
    g.setColor(Color.GREEN);
    switch (dir){
      case LEFT:
        g.fillOval(x-5,y+25,10,10);
        break;
      case RIGHT:
        g.fillOval(x+55,y+25,10,10);
        break;
      case UP:
        g.fillOval(x+25,y-5,10,10);
        break;
      case DOWN:
        g.fillOval(x+25,y+55,10,10);
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
      rect.x=this.x;
      rect.y=this.y;
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

  public Group getGroup() {
    return group;
  }

  public void setGroup(Group group) {
    this.group = group;
  }

  public  void collision(Tank tank,Graphics g){//碰撞检测
    if (tank.getGroup()==this.group) return;
    Rectangle rec1 = tank.rect;
    Rectangle rec2 = this.rect;
    if (rec1.intersects(rec2)){
      explode.explodePaint(g,this.x,this.y);
      this.die();
      tank.die();
    }

  }

  private void die() {
    tankFrame.bullets.remove(this);
  }
}
