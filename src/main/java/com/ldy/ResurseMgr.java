package com.ldy;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author : ldy
 * @version : 1.0
 */
public class ResurseMgr {
  public static BufferedImage tankL,tankR,tankU,tankD,
                              explode;
  static {
    try {
      tankL = ImageIO.read(new FileInputStream("D:\\D\\document\\javaprograms1\\code" +
              "\\20220424Tank\\src\\main\\resources\\images\\enemy\\enemy1L.gif"));
      tankR = ImageIO.read(new FileInputStream("D:\\D\\document\\javaprograms1\\code" +
              "\\20220424Tank\\src\\main\\resources\\images\\enemy\\enemy1R.gif"));
      tankU = ImageIO.read(new FileInputStream("D:\\D\\document\\javaprograms1\\code" +
              "\\20220424Tank\\src\\main\\resources\\images\\enemy\\enemy1U.gif"));
      tankD = ImageIO.read(new FileInputStream("D:\\D\\document\\javaprograms1\\code" +
              "\\20220424Tank\\src\\main\\resources\\images\\enemy\\enemy1D.gif"));
      explode = ImageIO.read(new FileInputStream("D:\\D\\document\\javaprograms1\\code" +
              "\\20220424Tank\\src\\main\\resources\\images\\explode.gif"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
