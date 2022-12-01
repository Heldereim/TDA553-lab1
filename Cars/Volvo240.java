import java.awt.*;

public class Volvo240 extends MotorisedVehicle<Engine, TrimBody> {

    
    public Volvo240(){
        super(new Engine(100), new TrimBody("Volvo240", Color.black, 4, 1.25));
    }

    public Volvo240(Engine engine, TrimBody body) {
        super(engine, body);
    }

    public Volvo240(double enginePower, String modelName, Color color, int nrDoors, double trimFactor) {
        super(new Engine(enginePower), new TrimBody(modelName, color, nrDoors, trimFactor));
    }

    public double getTrimFactor(){
        return this.getBody().getTrimFactor();
    }
    
    @Override
    public double speedFactor(){
        return (this.getEnginePower() * 0.01 * this.getTrimFactor());
    }
}
