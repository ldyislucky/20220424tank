package com.ldy;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;

/**
 * @author : ldy
 * @version : 1.0
 */
public class TankFrame extends Frame {
    int x=200; int y=200;

    public TankFrame (){
        this.setSize(800,600);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle("tank war");
        this.addKeyListener(new Mykeystate());
        addWindowListener(new WindowAdapter() {
        });
    }
    @Override
    public void paint(Graphics g){
        System.out.println("paint");
        g.fillRect(200,200,50,50);
        x+=10;
    }

    class Mykeystate extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){

        }
        @Override
        public void keyReleased(KeyEvent e){

        }
    }
}
