package com.ldy;

import java.awt.*;
import java.util.Random;

/**
 * @author : ldy
 * @version : 1.0
 */
public class Tank {
    private int x;
    private int y;
    private Dir dir;
    private boolean Moving = true;
    private final static int speed = 5 ;
    private final TankFrame tankFrame;
    private Group group = Group.BAD;
    private Random random = new Random();

    public Tank(int x, int y, Dir dir, TankFrame tankFrame, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
        this.group = group;
    }

    public void tankpaint(Graphics g){
      //g.setColor(Color.MAGENTA);
      //g.fillRect(x,y,50,50);
        if (this.x<=100||this.x>=1100||this.y<=100||this.y>=700){
            switch (dir){
                case LEFT:
                    this.dir=Dir.RIGHT;
                    break;
                case RIGHT:
                    this.dir=Dir.LEFT;
                    break;
                case UP:
                    this.dir=Dir.DOWN;
                    break;
                case DOWN:
                    this.dir=Dir.UP;
                    break;
            }
        }
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
                if (random.nextInt(10)>8){
                    fire();
                }
            }
    }
    public void fire(){
        tankFrame.bullets.add(new Bullet(x,y,this.dir,tankFrame,this.group));
    }


  public void setMoving(boolean moving) {
    Moving = moving;
  }


  public void setDir(Dir dir) {
    this.dir = dir;
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

    public void die(){
        tankFrame.tanks.remove(this);
    }
}
