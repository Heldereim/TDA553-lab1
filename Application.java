import java.awt.Point;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

public class Application {
    
    final static int INITIAL_DISTANCE = 100;
    private static final int DELAY = 50;
    private Timer timer = new Timer(DELAY, new TimerListener());
    
    public static void main(String[] args) {
        

        CarController cc = new CarController();

        Volvo240 myVolvo = new Volvo240();
        Saab95 mySaab = new Saab95();
        Scania myScania = new Scania();

        cc.allVehicles.add(myVolvo);
        cc.saabList.add(mySaab); // TODO MITT
        cc.allVehicles.add(mySaab);
        cc.scaniaList.add(myScania);
        cc.allVehicles.add(myScania); // TODO MITT



        int i = 0; // TODO MITT
        for (MotorisedVehicle<?, ?> motorisedVehicle : cc.allVehicles) { // TODO MITT
            Point point = new Point(0, (i * Application.INITIAL_DISTANCE));
            motorisedVehicle.setCoordinates(point); // Ökar distansen med 100 mellan varje bil i y-led
            i++;
        }

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }
}