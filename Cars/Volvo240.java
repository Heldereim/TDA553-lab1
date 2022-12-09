import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Volvo240 extends Car<Engine, TrimBody> {

    public Volvo240(){
        super(new Engine(100), new TrimBody("Volvo240", Color.black, 4, 1.25));
        try {
        this.setImage(ImageIO.read(new File("Assets/Volvo240.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Volvo240(Engine engine, TrimBody body) {
        super(engine, body);
        try {
            this.setImage(ImageIO.read(new File("Assets/Volvo240.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Volvo240(double enginePower, String modelName, Color color, int nrDoors, double trimFactor) {
        super(new Engine(enginePower), new TrimBody(modelName, color, nrDoors, trimFactor));
        
        try {
            this.setImage(ImageIO.read(new File("Assets/Volvo240.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getTrimFactor(){
        return this.getBody().getTrimFactor();
    }
    
    @Override
    public double speedFactor(){
        return (this.getEnginePower() * 0.01 * this.getTrimFactor());
    }
}
