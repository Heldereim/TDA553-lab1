import java.awt.*;
import java.util.Stack;

public class CarTransporter extends Truck {

    private CarPlatform carPlatform;
    private Stack<LoadableVehicle> loadedVehicles;
    private int maxCapacity;

    public CarTransporter(int maxCapacity) {
        super(new Engine(120), new Body("Transporter", Color.black, 2));
        this.carPlatform = new CarPlatform();
        this.maxCapacity = maxCapacity;
        this.loadedVehicles = new Stack<LoadableVehicle>();
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
                loadedVehicles.get(i).setX(this.getX());
                loadedVehicles.get(i).setY(this.getY());
            }
        }
    }

    public boolean isPlatformDown() {
        return this.carPlatform.isPlatformDown();
    }

    public LoadableVehicle lookTopCar() {
        return this.loadedVehicles.peek();
    }

    @Override
    public void gas(double amount) {
        if(!this.isPlatformDown()) {
            super.gas(amount);
        } else {
            throw new IllegalStateException("Cannot gas if ");
        }
    }
}