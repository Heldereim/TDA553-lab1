import java.util.*;
import java.awt.Color;

public class CarFactory {

    private ArrayList<Saab95> saabList;
    private ArrayList<Scania> scaniaList;
    private ArrayList<Volvo240> volvoList;
    private ArrayList<ArrayList<MotorisedVehicle<?, ?>>> carList;

    public CarFactory() {
        this.saabList = new ArrayList<Saab95>();
        this.scaniaList = new ArrayList<Scania>();
        this.volvoList = new ArrayList<Volvo240>();
        this.carList = new ArrayList<ArrayList<MotorisedVehicle<?, ?>>>();

        this.carList.add(this.saabList); // TODO fucked because of 

    }

    public void makeSaab() {
        Saab95 saab = new Saab95();
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
}
