import javax.swing.*;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int DELAY = 50;

    // each step between delays.
    private Timer timer = new Timer(DELAY, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<MotorisedVehicle<?, ?>> allVehicles = new ArrayList<>();
    ArrayList<Saab95> saabList = new ArrayList<>();
    ArrayList<Scania> scaniaList = new ArrayList<>();
    

    // methods:

    public static void main(String[] args) {
        // Instance of this class

        final int INITIAL_DISTANCE = 1; // TODO MITT

        CarController cc = new CarController();

        Saab95 mySaab = new Saab95();
        Scania myScania = new Scania();

        cc.allVehicles.add(new Volvo240());
        cc.saabList.add(mySaab); // TODO MITT
        cc.allVehicles.add(mySaab);
        cc.scaniaList.add(myScania);
        cc.allVehicles.add(myScania); // TODO MITT



        int i = 0; // TODO MITT
        for (MotorisedVehicle<?, ?> motorisedVehicle : cc.allVehicles) { // TODO MITT
            Point point = new Point(0, (i*INITIAL_DISTANCE));
            motorisedVehicle.setCoordinates(point); // Ökar distansen med 100 mellan varje bil i y-led
            i++;
        }

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /*
     * Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (MotorisedVehicle<?, ?> motorisedVehicle : allVehicles) {
                motorisedVehicle.move();
                Point coordinates = motorisedVehicle.getCoordinates();
                frame.drawPanel.moveIt(coordinates.x, coordinates.y);
                frame.drawPanel.repaint(); // repaint() calls the paintComponent method of the panel
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        System.out.println("Gas CarController: " + gas);
        for (MotorisedVehicle<?, ?> motorisedVehicle : allVehicles) {

            motorisedVehicle.gas(gas);

        }
    }

    public void brake(int brakeamount) {
        double brake = ((double) brakeamount) / 100;
        for (MotorisedVehicle<?, ?> motorisedVehicle : allVehicles) {

            motorisedVehicle.brake(brake);
        }
    }

    public void setTurboOff() {
        System.out.println("TurboOFF");
        for (Saab95 saab : saabList) {
            saab.setTurboOff();
        }
    }

    public void setTurboOn() {
        System.out.println("TurboON");
        for (Saab95 saab : saabList) {
            saab.setTurboOn();
        }
    }

    public void raisePlatform(int liftAmount) {
        for (Scania scania : scaniaList) {
            scania.raisePlatform(liftAmount);
        }
    }

    public void lowerPlatform(int lowerAmount) {
        for (Scania scania : scaniaList) {
            scania.lowerPlatform(lowerAmount);
        }
    }

    public void startEngine() {
        System.out.println("StartEngine");
        for (MotorisedVehicle<?, ?> motorisedVehicle : allVehicles) {
            motorisedVehicle.startEngine();
        }
    }

    public void stopEngine() {
        System.out.println("StopEngine");
        for (MotorisedVehicle<?, ?> motorisedVehicle : allVehicles) {
            motorisedVehicle.stopEngine();
        }
    }
}
