package src.Model;

import java.awt.*;
import java.lang.Math;
import java.awt.image.BufferedImage;

public abstract class MotorisedVehicle<E extends Engine, B extends Body> implements Movable {

    private E engine;
    private B body;
    private Boolean engineOn;
    private double currentSpeed;
    private BufferedImage image;

    private Point coordinates; // Coordinates

    private Direction direction; // Current direction

    public MotorisedVehicle(E engine, B body) {
        this.engine = engine;
        this.engineOn = false;
        this.body = body;
        this.stopEngine();
        this.coordinates = new Point(0, 0);
        this.direction = Direction.EAST;
    }

    // ------------------------------------- Engine misc
    // ----------------------------------------//
    public void startEngine() {
        this.engineOn = true;
    }

    public void stopEngine() {
        this.currentSpeed = 0;
        this.engineOn = false;
    }

    // ------------------------------------- Getters
    // ----------------------------------------//
    public int getNrDoors() {
        return this.body.getNrDoors();
    }

    public double getEnginePower() {
        return this.engine.getEnginePower();
    }

    public String getModelName() {
        return this.body.getModelName();
    }

    public double getCurrentSpeed() {
        return this.currentSpeed;
    }

    public Color getColor() {
        return this.body.getColor();
    }

    public B getBody() {
        return this.body;
    }

    public E getEngine() {
        return this.engine;
    }

    public Point getCoordinates() {
        return this.coordinates;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public double getDistance(Point coordinates) {
        double x = coordinates.x;
        double y = coordinates.y;
        return Math.sqrt((Math.pow((x - this.coordinates.x), 2)) + Math.pow((y - this.coordinates.y), 2));
    }

    public Boolean getEngineOn() {
        return this.engineOn;
    }

    public BufferedImage getImage() {
        return this.image;
    }

    // -------------------------------------
    // Setters----------------------------------------//
    public void setEnginePower(double enginePower) { // Might be unnecessary
        this.engine.setEnginePower(enginePower);
    }

    private void setCurrentSpeed(double amount) { // Input from increment- and decrementSpeed can't be outside range 0 -
                                                  // enginePower
        this.currentSpeed = amount;
    }

    public void setColor(Color color) {
        this.body.setColor(color);
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

    public void setImage(BufferedImage image){
        this.image = image;
    }

    // ------------------------------------- Handle speed
    // ----------------------------------------//
    public double speedFactor() {
        return (this.getEnginePower() * 0.01);
    }

    private void incrementSpeed(double amount) { // Increse movementspeed of the vehicle
        this.setCurrentSpeed((Math.min(getCurrentSpeed() + speedFactor() * amount, this.getEnginePower())));
    }

    private void decrementSpeed(double amount) { // Lowers the speed of the vehicle, using the highest value when
        this.setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0)); // comparing getCurrentSpeed() -
                                                                                       // speedFactor() * amount with 0
    }

    public void gas(double amount) {
        if (!this.engineOn) {
            throw new IllegalStateException("Error! Can not gas, the engine is off");
        }

        if (amount > 1) {
            this.incrementSpeed(1); // Magic number???
            return;
        }

        if (amount < 0) {
            this.incrementSpeed(0);
            return;
        }

        this.incrementSpeed(amount); // Räcker med denna, om den skulle vara < 0 eller
                                     // > 1 hade ovan if-statements fångat det.
    }

    public void brake(double amount) { // Check input is between [0..1]. If > 1 then 1, if < 0 then 0
        
        if (amount > 1) {
            this.decrementSpeed(1); // Magic number???
            return;
        }

        if (amount < 0) {
            this.decrementSpeed(0);
            return;
        }

        this.decrementSpeed(amount); // Räcker med denna, om den skulle vara < 0 eller
                                     // > 1 hade ovan if-statements fångat det.
    }

    // ------------------------------------- Direction and movement
    // ----------------------------------------//

    public void turnLeft() {
        int dirValue = this.direction.getValue();
        this.direction = Direction.values()[Math.floorMod(dirValue - 1, 4)];
    }

    public void turnRight() {
        int dirValue = this.direction.getValue();
        this.direction = Direction.values()[Math.floorMod(dirValue + 1, 4)];
    }

    // Moves the vehicle in the current direction
    public void move() {
        switch (this.direction) {
            case NORTH:
                this.coordinates.y += this.currentSpeed;
                break;
            case EAST:
                this.coordinates.x += this.currentSpeed;
                break;
            case SOUTH:
                this.coordinates.y -= this.currentSpeed;
                break;
            case WEST:
                this.coordinates.x -= this.currentSpeed;
                break;
        }
    }

    @Override
    public String toString() {
        return "MotorisedVehicle [engine=" + engine + ", body=" + body + ", currentSpeed=" + currentSpeed + ", x="
                + this.coordinates.x
                + ", y=" + this.coordinates.y + "]";
    }

}
