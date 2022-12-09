import java.util.ArrayList;
import java.util.EmptyStackException;

public class CarStorage {
    ArrayList<Car<?, ?>> loadedCars;
    int maxCapacity;

    public CarStorage(int maxCapacity){
        this.maxCapacity = maxCapacity;
        this.loadedCars = new ArrayList<>();
    }

    public void load(Car<?, ?> car) {

        if (this.loadedCars.size() < this.maxCapacity) {
            this.loadedCars.add(car);
        } else {
            throw new IllegalStateException("Car Transporter already at full capacity");
        }
    }
    
    public Car<?, ?> unload() {
        if (this.loadedCars.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.loadedCars.remove(loadedCars.size() - 1); // Will throw exception if loadedVehicles is empty
    }

    public Car<?, ?> unload(Car<?, ?> car) {
        if (!this.loadedCars.isEmpty()) {
            this.loadedCars.remove(car);
            return car;
        }
        else {
            throw new IllegalStateException();
        }
    }

    public int size() {
        return loadedCars.size();
    }

    public Car<?, ?> get(int i) {
        if (loadedCars.isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            return loadedCars.get(i);
        }
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    public boolean isEmpty() {
        return loadedCars.isEmpty();
    }
}
