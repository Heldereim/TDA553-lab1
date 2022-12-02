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

    public void load(MotorisedVehicle<Engine, Body> car) {
        this.AssertInRange(car);
        this.tryToLoad(car);
    }

    public void carTransfer(CarTransporter transCar, int amountToLoad) {
        
        this.AssertCapacityLeft(transCar, amountToLoad);
        this.AssertInRange(transCar);

        for (int i = 0; i < amountToLoad; i++) {
            this.repairshopGarage.add(transCar.unload());
        }
    }

    private void AssertInRange (LoadableVehicle transCar) throws IllegalArgumentException {
        if (transCar.getDistance(this.x, this.y) > this.LOAD_RANGE) {
            throw new IllegalArgumentException("Too far away from repair shop to transfer.");
        }
    }

    private void AssertCapacityLeft (CarTransporter transCar, int amountToLoad) throws IllegalArgumentException {
        if (amountToLoad > this.maxCapacity - this.repairshopGarage.size()) {
            throw new IllegalArgumentException("Can't unload that many vehicles into garage."); 
        }
    }

    public void carTransfer(CarTransporter transCar) {
        this.AssertInRange(transCar);

        
        if (!this.isFull()) {
            this.repairshopGarage.add(transCar.unload());
        } else {
            throw new IllegalArgumentException("Car Repair Shop already at full capacity");
        }
    }

    public void unload(MotorisedVehicle<Engine, Body> car) {
        this.repairshopGarage.remove(car);
        this.carToRepairShopPos(car);
    }

    private void tryToLoad(MotorisedVehicle<Engine, Body> car) {
    if (!this.isFull()) {
        this.repairshopGarage.add(car);
        } else {
        throw new IllegalArgumentException("Car Repair Shop already at full capacity");
        }
    }
    
    private boolean isFull() {
        return this.repairshopGarage.size() >= this.maxCapacity;
    }

    @Override
    public String toString() {
        return "CarRepairShop [repairshopGarage=" + repairshopGarage + "]";
    }

    private void carToRepairShopPos(MotorisedVehicle<Engine, Body> car) {
        car.setX(this.x);
        car.setY(this.y);
    }
    
    public double getDistance(double x, double y) {
        return Math.sqrt((Math.pow((x - this.x), 2)) + Math.pow((y - this.y), 2));
    }

}
