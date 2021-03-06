package com.ldy;

import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.lang.model.element.VariableElement;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : ldy
 * @version : 1.0
 */
public class TankFrame extends Frame {
    int x=200; int y=500;
    final int w=1200,h=800;
    Dir dir = Dir.DOWN;
    Tank tank = new Tank(x,y,dir,this,Group.GOOD);
    List<Bullet> bullets = new ArrayList();
    List<Tank> tanks = new ArrayList<>();
    public TankFrame (){

        this.setSize(w,h);
        this.setResizable(false);
        this.setVisible(true);

        this.setTitle("tank war");
        this.addKeyListener(new Mykeystate());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    Image offScreenImage = null;//防闪烁代码，固定的。
    @Override
    public void update(Graphics g){//防闪烁代码，固定的。
        if (offScreenImage==null){
            offScreenImage=this.createImage(w,h);
        }
        Graphics goffscreen = offScreenImage.getGraphics();
        Color c = goffscreen.getColor();
        goffscreen.setColor(Color.BLACK);
        goffscreen.fillRect(0,0,w,h);
        goffscreen.setColor(c);
        paint(goffscreen);
        g.drawImage(offScreenImage,0,0,null);
    }
    @Override
    public void paint(Graphics g){//画板
       // Color c = g.getColor();不知道有啥用
        for (int j = 0; j < tanks.size(); j++) {
            tanks.get(j).tankpaint(g);
        }
        g.setColor(Color.white);
        g.drawString("子弹数量"+bullets.size(),30,70);
       // g.setColor(c);不知道有啥用
        tank.tankpaint(g);
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).bPaint(g);
            for (int j = 0; j < tanks.size(); j++) {
                bullets.get(i).collision(tanks.get(j),g);
            }
        }
    }



    class Mykeystate extends KeyAdapter{
        boolean bl = false;
        boolean br = false;
        boolean bu = false;
        boolean bd = false;
        @Override
        public void keyPressed(KeyEvent e){
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                    bl = true;
                    break;

                case KeyEvent.VK_RIGHT:
                    br = true;
                    break;

                case KeyEvent.VK_UP:
                    bu = true;
                    break;

                case KeyEvent.VK_DOWN:
                    bd = true;
                    break;
                case KeyEvent.VK_CONTROL:
                    tank.fire();
                    break;

                default:
                    break;
           }
            setMainTankDir();

        }
        @Override
        public void keyReleased(KeyEvent e){
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bl = false;
                    break;

                case KeyEvent.VK_RIGHT:
                    br = false;
                    break;

                case KeyEvent.VK_UP:
                    bu = false;
                    break;

                case KeyEvent.VK_DOWN:
                    bd = false;
                    break;

                default:
                    break;
            }
            setMainTankDir();
        }
        private void setMainTankDir(){
            if (!bd&&!bl&&!bu&&!br){
                tank.setMoving(false);
            }else {
                tank.setMoving(true);
                if (bl) dir=Dir.LEFT;
                if (br) dir=Dir.RIGHT;
                if (bu) dir=Dir.UP;
                if (bd) dir=Dir.DOWN;
                tank.setDir(dir);
            }

        }
    }
}
