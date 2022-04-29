import com.ldy.ResurseMgr;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * @author : ldy
 * @version : 1.0
 */
public class Test {
  @org.junit.Test
  public void test(){
    try {
      //BufferedImage tankl = ImageIO.read(ResurseMgr.class.getClassLoader().getResourceAsStream("main/java/images/enemy/enemy1L.gif"));
      BufferedImage image = ImageIO.read(
              new FileInputStream("D:\\D\\document\\javaprograms1\\code" +
                      "\\20220424Tank\\src\\main\\resources\\images\\enemy\\enemy1L.gif"));
     //BufferedImage image1 = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/enemy/enemy1L.gif"));
      System.out.println(this.getClass().getClassLoader().getResourceAsStream
              ("images/enemy/enemy1L.gif"));
      System.out.println(this.getClass().getClassLoader().getResourceAsStream
              ("main/resources/images/enemy/enemy1L.gif"));
      System.out.println(new FileInputStream("D:\\D\\document\\javaprograms1" +
              "\\code\\20220424Tank\\src\\main\\resources\\images\\enemy\\enemy1L.gif"));
      System.out.println(this.getClass().getPackage());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  @org.junit.Test
  public void  test2(){
    int width = ResurseMgr.tankD.getWidth();
    Graphics graphics = ResurseMgr.tankD.getGraphics();
    System.out.println(graphics);
    System.out.println(width);
  }
}
