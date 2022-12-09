import java.awt.*;

public class CarTransporter extends Truck {

    private CarPlatform carPlatform;
    private CarStorage loadedVehicles;

    public CarTransporter(int maxCapacity) {
        super(new Engine(120), new Body("Transporter", Color.black, 2));
        this.carPlatform = new CarPlatform();
        this.loadedVehicles = new CarStorage(maxCapacity);
    }

    public void load(Car<?, ?> car) {
        loadedVehicles.load(car);
    }

    public Car<?, ?> unload() {
        return loadedVehicles.unload();
    }

    public void raisePlatform() {
        this.carPlatform.raisePlatform();
    }

    public void lowerPlatform() {
        if (this.getCurrentSpeed() == 0) this.carPlatform.lowerPlatform();
    }

    @Override
    public void move() {
        if (!this.carPlatform.isPlatformDown()) {
            super.move();
            for (int i = 0; i < loadedVehicles.size(); i++) { // Update positions of loaded vehicles
                loadedVehicles.get(i).setCoordinates(this.getCoordinates());
                loadedVehicles.get(i).setCoordinates(this.getCoordinates());
            }
        }
    }

    public boolean isPlatformDown() {
        return this.carPlatform.isPlatformDown();
    }

    public Car<?, ?> lookTopCar() {
        return this.loadedVehicles.get(loadedVehicles.size() - 1);
    }

    @Override
    public void gas(double amount) {
        if(!this.isPlatformDown()) {
            super.gas(amount);
        } else {
            throw new IllegalStateException("Cannot gas if platform is down");
        }
    }
}