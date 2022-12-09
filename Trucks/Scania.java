import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;

public class Scania extends Truck{
    
   private TipPlatform tipPlatform;

   private BufferedImage image;

   public Scania() {
      super(new Engine(90), new Body("Scania", Color.WHITE, 2));
      this.tipPlatform = new TipPlatform();
      try {
            this.image = ImageIO.read(new File("TDA553-lab1/Assets/Scania.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
   }

   public int getPlatformAngle(){
      return this.tipPlatform.getPlatformAngle();
   }

   public void raisePlatform(int degrees){
      if (this.getCurrentSpeed() == 0){
         this.tipPlatform.raisePlatform(degrees);
      }
      else{
         throw new IllegalStateException("Cannot raise platform while moving!");
      }
   }

   public void lowerPlatform(int degrees) {
      this.tipPlatform.lowerPlatform(degrees);
   }

   @Override
   public void gas(double amount){
      if(this.tipPlatform.getPlatformAngle() == 0){
         super.gas(amount);
      }
      else {
         throw new IllegalStateException("You may not move while platform is raised!");
      }
   }
}
