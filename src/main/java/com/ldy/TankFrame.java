package com.ldy;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author : ldy
 * @version : 1.0
 */
public class TankFrame extends Frame {
    int x=200; int y=200;
    Dir dir = Dir.DOWN;
    Tank tank = new Tank(x,y,dir);
    public TankFrame (){

        this.setSize(800,600);
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
    @Override
    public void paint(Graphics g){
        tank.tankpaint(g);
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
