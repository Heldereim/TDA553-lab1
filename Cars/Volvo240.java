import java.awt.*;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Volvo240 extends Car<Engine, TrimBody> {

    private BufferedImage image;

    public Volvo240(){
        super(new Engine(100), new TrimBody("Volvo240", Color.black, 4, 1.25));
        try {
        this.image = ImageIO.read(new File("TDA553-lab1/Assets/Volvo240.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Volvo240(Engine engine, TrimBody body) {
        super(engine, body);
        try {
            this.image = ImageIO.read(new File("TDA553-lab1/Assets/Volvo240.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Volvo240(double enginePower, String modelName, Color color, int nrDoors, double trimFactor) {
        super(new Engine(enginePower), new TrimBody(modelName, color, nrDoors, trimFactor));
        
        try {
            this.image = ImageIO.read(new File("TDA553-lab1/Assets/Volvo240.jpg"));
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
