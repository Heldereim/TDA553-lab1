import java.util.*;
import java.awt.Color;

public abstract class CarFactory {

    private ArrayList<Saab95> saabList = new ArrayList<>();
    private ArrayList<Scania> scaniaList = new ArrayList<>();
    private ArrayList<Volvo240> volvoList = new ArrayList<>();
    private ArrayList<MotorisedVehicle<?, ?>> allVehicles = new ArrayList<>();


    // Make cars

    public void makeSaab() {
        Saab95 saab = new Saab95();
        allVehicles.add(saab);
        saabList.add(saab);
    }

    public void makeSaab(TurboEngine engine, Body body) {
        Saab95 saab = new Saab95(engine, body);
        allVehicles.add(saab);
        saabList.add(saab);
    }

    public void makeSaab(double enginePower, String modelName, Color color, int nrDoors) {
        Saab95 saab = new Saab95(enginePower, modelName, color, nrDoors);
        allVehicles.add(saab);
        saabList.add(saab);
    }

    public void makeVolvo() {
        Volvo240 volvo = new Volvo240();
        allVehicles.add(volvo);
    }

    public void makeVolvo(Engine engine, TrimBody body) {
        Volvo240 volvo = new Volvo240(engine, body);
        allVehicles.add(volvo);
    }

    public void makeVolvo(double enginePower, String modelName, Color color, int nrDoors, double trimFactor) {
        Volvo240 volvo = new Volvo240(enginePower, modelName, color, nrDoors, trimFactor);
        allVehicles.add(volvo);
    }

    public void makeScania() {
        Scania scania = new Scania();
        scaniaList.add(scania);
        allVehicles.add(scania);
    }

    public void makeCarTransporter(int maxCapacity) {
        CarTransporter carTransporter = new CarTransporter(maxCapacity);
        allVehicles.add(carTransporter);
    }

    // Getters
    
    public ArrayList<Saab95> getSaabList() {
        return saabList;
    }

    public ArrayList<Scania> getScaniaList() {
        return scaniaList;
    }

    public ArrayList<Volvo240> getVolvoList() {
        return volvoList;
    }

    public ArrayList<MotorisedVehicle<?, ?>> getAllVehicles() {
        return allVehicles;
    }
}
