
public class TurboEngine extends Engine{
    private boolean turboOn;
    public TurboEngine(Double enginePower){
        super(enginePower);
        this.turboOn = false;
    }
    public void turnOnTurbo(){
        this.turboOn = true;
    }
    public void turnOffTurbo(){
        this.turboOn = false;
    }
    public boolean isTurboOn(){
        return this.turboOn;
    }
}
