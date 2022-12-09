package src.Model;

import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Saab95 extends Car<TurboEngine, Body> {

    
    public Saab95(){
        super(new TurboEngine(100.0), new Body("Saab95", Color.gray, 2));
        try {
            this.setImage(ImageIO.read(new File("Assets/Saab95.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Saab95(TurboEngine engine, Body body){
        super(engine, body);
        try {
            this.setImage(ImageIO.read(new File("Assets/Saab95.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Saab95(double enginePower, String modelName, Color color, int nrDoors) {
        super(new TurboEngine(enginePower), new Body(modelName, color, nrDoors));
        try {
            this.setImage(ImageIO.read(new File("Assets/Saab95.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void setTurboOn(){
	    this.getEngine().turnOnTurbo();
        this.getEngine();
    }

    public void setTurboOff(){
	    this.getEngine().turnOffTurbo();
    }

    public boolean isTurboOn(){
        return this.getEngine().isTurboOn();
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(this.isTurboOn()) turbo = 1.3;
        return (this.getEnginePower() * 0.01 * turbo);
    }

}
