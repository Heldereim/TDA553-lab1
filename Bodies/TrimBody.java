import java.awt.*;

public class TrimBody extends Body{
    private double trimFactor;
    public TrimBody(String modelName, Color color, int nrDoors, double trim){
        super(modelName, color, nrDoors);
        this.trimFactor = trim;
    }
    public double getTrimFactor(){
        return this.trimFactor;
    }
}
