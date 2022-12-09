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

    // The delay (ms) corresponds to 50 updates a sec (hz)
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

        final int INITIAL_DISTANCE = 100; // TODO MITT

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
                // Point coordinates = motorisedVehicle.getCoordinates();
                // frame.drawPanel.moveIt(motorisedVehicle, coordinates.x, coordinates.y);
                frame.drawPanel.repaint(); // repaint() calls the paintComponent method of the panel
            }
        }
    }

    // Calls the gas method for each car once
   
    frame.gasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            double gas = ((double) frame.gasAmount) / 100;
            System.out.println("Gas CarController: " + gas);
            for (MotorisedVehicle<?, ?> motorisedVehicle : allVehicles) {

                motorisedVehicle.gas(gas);

            }
        }
    });

    frame.brakeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            double brake = 100.00;
            for (MotorisedVehicle<?, ?> motorisedVehicle : allVehicles) {

                motorisedVehicle.brake(brake);
            }
        }
    }); 

    frame.turboOffButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("TurboOFF");
            for (Saab95 saab : saabList) {
                saab.setTurboOff();
            }
        }
    });

    frame.turboOnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("TurboON");
            for (Saab95 saab : saabList) {
                saab.setTurboOn();
            }
        }
    });

    frame.liftBedButton.addActionListener(new ActionListener() {
        @Override   
        public void actionPerformed(ActionEvent e) {
            for (Scania scania : scaniaList) {
                scania.raisePlatform(100);
            }
        }
    });

    frame.lowerBedButton.addActionListener(new ActionListener()  {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (Scania scania : scaniaList) {
                scania.lowerPlatform(0);
            }
        }
    });

    frame.startButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (MotorisedVehicle<?, ?> motorisedVehicle : allVehicles) {
                motorisedVehicle.startEngine();
            }
        }
    });

    frame.stopButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (MotorisedVehicle<?, ?> motorisedVehicle : allVehicles) {
                motorisedVehicle.stopEngine();
            }
    }});
}
