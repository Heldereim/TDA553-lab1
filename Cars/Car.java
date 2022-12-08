public abstract class Car<E extends Engine, B extends Body> extends MotorisedVehicle<E, B> {
    public Car(E engine, B body) {
        super(engine, body);
    }
}
