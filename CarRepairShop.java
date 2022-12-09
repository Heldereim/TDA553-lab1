import java.awt.Point;

public class CarRepairShop {
    private Point coordinates;

    private final double LOAD_RANGE = 5.0;

    private CarStorage repairshopGarage;

    public CarRepairShop(double x, double y, int maxCapacity) { 
        this.coordinates = new Point((int) x, (int) y);
        this.repairshopGarage = new CarStorage(maxCapacity);
    }

    public CarRepairShop(Point coordinates, int maxCapacity) {
        this.coordinates = coordinates;
        this.repairshopGarage = new CarStorage(maxCapacity);
    }



    //--------------------Getters---------------------------------
    
    public Point getCoordinates() {
        return this.coordinates;
    }

    //--------------------Setters--------------------------------

    public void setCoordiantes(Point coordinates) {
        this.coordinates = coordinates;
    }

    //-------------------Repairshop misc-------------------------

    public void load(Car<?, ?> car) {
        this.AssertInRange(car.getCoordinates());
        repairshopGarage.load(car);
    }

    public void carTransfer(CarTransporter transCar, int amountToLoad) {
        
        this.AssertCapacityLeft(transCar, amountToLoad);
        this.AssertInRange(transCar.getCoordinates());

        for (int i = 0; i < amountToLoad; i++) {
            this.repairshopGarage.load(transCar.unload());
        }
    }

    private void AssertInRange (Point coordinates) throws IllegalArgumentException {
        if (this.getDistance(coordinates) > this.LOAD_RANGE) {
            throw new IllegalStateException("Too far away from repair shop to transfer.");
        }
    }

    private void AssertCapacityLeft (CarTransporter transCar, int amountToLoad) throws IllegalArgumentException {
        if (amountToLoad > this.getMaxCapacity() - this.repairshopGarage.size()) {
            throw new IllegalArgumentException("Can't unload that many vehicles into garage."); 
        }
    }

    public void carTransfer(CarTransporter transCar) {
        this.AssertInRange(transCar.getCoordinates());

        if (!this.isFull()) {
            this.repairshopGarage.load(transCar.unload());
        } else {
            throw new IllegalStateException("Car Repair Shop already at full capacity");
        }
    }

    public void unload(Car<?, ?> car) {
        if (!this.repairshopGarage.isEmpty()) {
            this.repairshopGarage.unload(car);
            this.carToRepairShopPos(car);
        }
        else {
            throw new IllegalStateException();
        }
    }
    
    private boolean isFull() {
        return this.repairshopGarage.size() >= this.getMaxCapacity();
    }

    @Override
    public String toString() {
        return "CarRepairShop [repairshopGarage=" + repairshopGarage + "]";
    }

    private void carToRepairShopPos(Car<?, ?> car) {
        car.setCoordinates(this.coordinates);
    }
    
    public double getDistance(Point coordiantes) {
        int x = coordinates.x;
        int y = coordinates.y;
        return Math.sqrt((Math.pow((this.coordinates.x - x), 2)) + Math.pow((this.coordinates.y - y), 2));
    }

    public int getMaxCapacity() {
        return repairshopGarage.getMaxCapacity();
    }
}
