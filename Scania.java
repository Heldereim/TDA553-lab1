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
         System.out.println("Cannot raise the platform while in movement!");
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
