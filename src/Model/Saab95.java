package src.Model;

import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Saab95 extends Car<TurboEngine, Body> {

    private final TurboEngine engine;

    public Saab95(){
        this(new TurboEngine(100.0), new Body("Saab95", Color.gray, 2));
    }

    private Saab95(TurboEngine engine, Body body){
        super(engine, body);
        try {
            this.setImage(ImageIO.read(new File("Assets/Saab95.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.engine = engine;
    }

    public Saab95(double enginePower, String modelName, Color color, int nrDoors) {
        this(new TurboEngine(enginePower), new Body(modelName, color, nrDoors));
    }
    
    public void setTurboOn(){
	    engine.turnOnTurbo();
    }

    public void setTurboOff(){
	    engine.turnOffTurbo();
    }

    public boolean isTurboOn(){
        return engine.isTurboOn();
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(this.isTurboOn()) turbo = 1.3;
        return (this.getEnginePower() * 0.01 * turbo);
    }

}
