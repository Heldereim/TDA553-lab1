
public class Engine {
    private double power;

    public Engine(double enginePower){
        this.power = enginePower;
    }
    public double getEnginePower(){
        return this.power;
    }
    public void setEnginePower(double enginePower){
        this.power = enginePower;
    }
    @Override
    public String toString() {
        return "Engine : " + power;
    }
}
