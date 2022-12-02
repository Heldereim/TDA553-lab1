import java.awt.*;

public class Scania extends MotorisedVehicle<Engine, Body>{
    
   private TipPlatform tipPlatform;


   public Scania() {
      super(new Engine(150), new Body("Scania", Color.WHITE, 2));
      this.tipPlatform = new TipPlatform();
   }

   public int getPlatformAngle(){
      return this.tipPlatform.getPlatformAngle();
   }

   public void raisePlatform(int degrees){
      if (this.getCurrentSpeed() == 0){
         this.tipPlatform.raisePlatform(degrees);
      }
      else{
         throw new IllegalArgumentException("Cannot raise platform while moving!");
      }
   }

   public void lowerPlatform(int degrees) {
      this.tipPlatform.lowerPlatform(degrees);
   }

   @Override
   public void move() {
     if (this.tipPlatform.isPlatformDown()) super.move();
   }

}
