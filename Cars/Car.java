public abstract class Car<E extends Engine, B extends Body> extends MotorisedVehicle<Engine, Body> implements LoadableVehicle {
    public Car(E engine, B body) {
        super(engine, body);
    }

    @Override
    public E getEngine(){
        return this.getEngine();
    }

    @Override
    public B getBody(){
        return this.getBody();
    }
}
