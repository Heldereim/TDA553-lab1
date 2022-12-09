public class loadFunctionality {
    
    public LoadableVehicle popCar(Stack stack) {
        
        if(stack.getCurrentSpeed() > 0) {

            throw new IllegalStateException("Cannot unload if car transporter is moving!");
        }
        else {
            return stack.pop(); // Will throw exception if loadedVehicles is empty
        }
    }

    public void loadStackCar(Stack stack) {
        if (this.carPlatform.isPlatformDown()) {
            this.tryToLoad(stack);
        } else {
            throw new IllegalStateException("Cannot load if platform isn't down.");
        }
    }

    private void tryToLoad(LoadableVehicle car) {

        if (stack.size() < this.maxCapacity) {
            this.loadedVehicles.push(car);
        } else {
            throw new IllegalStateException("Car Transporter already at full capacity");
        }
    }

    public void unload(LoadableVehicle car) {
        if(this.numberOfCars() > 0) {
            this.repairshopGarage.remove(car);
            this.carToRepairShopPos(car);
        } else {
            throw new IllegalStateException("Cannot unload, Carrepairshop is empty!");
        }
    }

    private void tryToLoad(LoadableVehicle car) {
        if (!this.isFull()) {
                this.repairshopGarage.add(car);
                this.carToRepairShopPos(car);
            } else {
                throw new IllegalStateException("Car Repair Shop already at full capacity");
            }
        }

        public void load(LoadableVehicle car) {
            this.AssertInRange(car.getX(), car.getY());
            this.tryToLoad(car);
        }
}
