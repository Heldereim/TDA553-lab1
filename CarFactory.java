import java.util.ArrayList;

public class CarFactory {

    public ArrayList<MotorisedVehicle<?, ?>> allVehicles;
    public ArrayList<Saab95> saabList;
    public ArrayList<Scania> scaniaList;

    public void makeSaab() {
        Saab95 saab = new Saab95();
        allVehicles.add(saab);
        saabList.add(saab);
    }

    public void makeVolvo() {

    }
}
