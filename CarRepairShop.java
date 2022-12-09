import java.lang.reflect.Executable;
import java.util.ArrayList;

public class CarRepairShop {
    private double x;
    private double y;

    private int maxCapacity;

    private final double LOAD_RANGE = 5.0;

    private ArrayList<LoadableVehicle> repairshopGarage;

    public CarRepairShop(double x, double y, int maxCapacity) { 
        this.x = x;
        this.y = y;
        this.maxCapacity = maxCapacity;
        this.repairshopGarage = new ArrayList<LoadableVehicle>();
    }

    //--------------------Getters---------------------------------
    
    public double getX(){
        return this.x;
    }

        public double getY(){
        return this.y;
    }

        public double getMaxCapacity(){
        return this.maxCapacity;
    }

    //--------------------Setters--------------------------------

    public void setX(double x) {
        this.x = x;
    }

        public void setY(double y) {
        this.y = y;
    }

    //-------------------Repairshop misc-------------------------

    public void carTransfer(CarTransporter transCar, int amountToLoad) {
        
        this.AssertCapacityLeft(transCar, amountToLoad);
        this.AssertInRange(transCar.getX(), transCar.getY());

        for (int i = 0; i < amountToLoad; i++) {
            this.repairshopGarage.add(transCar.unload());
        }
    }

    private void AssertInRange (double x, double y) throws IllegalArgumentException {
        if (this.getDistance(x, y) > this.LOAD_RANGE) {
            throw new IllegalStateException("Too far away from repair shop to transfer.");
        }
    }

    private void AssertCapacityLeft (CarTransporter transCar, int amountToLoad) throws IllegalArgumentException {
        if (amountToLoad > this.maxCapacity - this.repairshopGarage.size()) {
            throw new IllegalArgumentException("Can't unload that many vehicles into garage."); 
        }
    }

    public void carTransfer(CarTransporter transCar) {
        this.AssertInRange(transCar.getX(), transCar.getY());

        if (!this.isFull()) {
            this.repairshopGarage.add(transCar.unload());
        } else {
            throw new IllegalStateException("Car Repair Shop already at full capacity");
        }
    }
    
    private boolean isFull() {
        return this.repairshopGarage.size() >= this.maxCapacity;
    }

    private int numberOfCars() {
        return repairshopGarage.size();
    }

    @Override
    public String toString() {
        return "CarRepairShop [repairshopGarage=" + repairshopGarage + "]";
    }

    private void carToRepairShopPos(LoadableVehicle car) {
        car.setX(this.x);
        car.setY(this.y);
    }
    
    public double getDistance(double x, double y) {
        return Math.sqrt((Math.pow((this.x - x), 2)) + Math.pow((this.y - y), 2));
    }

}
