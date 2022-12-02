public class CarPlatform {
    private boolean platformIsDown;

    public CarPlatform() {
        this.platformIsDown = false;
    }

    public void raisePlatform() {
        this.platformIsDown = false;
    }

    public void lowerPlatform() {
        this.platformIsDown = true;
    }

    public boolean isPlatformDown() {
        return this.platformIsDown;
    }  
}
