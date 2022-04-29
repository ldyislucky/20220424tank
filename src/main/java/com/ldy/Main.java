package com.ldy;

/**
 * @author : ldy
 * @version : 1.0
 */
public class Main {
  public static void main(String[] args) throws InterruptedException {
    TankFrame tankFrame = new TankFrame();
    for (int i = 0; i < 5; i++) {
      tankFrame.tanks.add(new Tank(200+150*i,200,Dir.DOWN,tankFrame));
    }
    while (true){
      Thread.sleep(50);
      tankFrame.repaint();
    }
  }
}
