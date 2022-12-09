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

public class CarController implements ActionListener {

    CarView carview = new CarView("CarSim 1.0");

    public void instantiateActions(){


        carview.getGasButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (MotorisedVehicle<?, ?> motorisedVehicle : CarFactory.getAllVehicles()) {
                    motorisedVehicle.gas(carview.getGasAmount()); 
                }
            }
        });
    }


    // @Override
    //     public void actionPerformed(ActionEvent e) {
    //         double gas = ((double) this.carview.gasAmount) / 100;
    //         System.out.println("Gas CarController: " + gas);
    //         for (MotorisedVehicle<?, ?> motorisedVehicle : allVehicles) {
    //             motorisedVehicle.gas(gas);
    //             }
    //     });

    // Calls the gas method for each car once

    carview.brakeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            double brake = 100.00;
            for (MotorisedVehicle<?, ?> motorisedVehicle : allVehicles) {

                motorisedVehicle.brake(brake);
            }
        }
    }); 

    carview.turboOffButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("TurboOFF");
            for (Saab95 saab : saabList) {
                saab.setTurboOff();
            }
        }
    });

    carview.turboOnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("TurboON");
            for (Saab95 saab : saabList) {
                saab.setTurboOn();
            }
        }
    });

    this.carview.liftBedButton.addActionListener(new ActionListener() {
        @Override   
        public void actionPerformed(ActionEvent e) {
            for (Scania scania : scaniaList) {
                scania.raisePlatform(100);
            }
        }
    });

    this.carview.lowerBedButton.addActionListener(new ActionListener()  {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (Scania scania : scaniaList) {
                scania.lowerPlatform(0);
            }
        }
    });

    this.carview.startButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (MotorisedVehicle<?, ?> motorisedVehicle : allVehicles) {
                motorisedVehicle.startEngine();
            }
        }
    });

    this.carview.stopButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (MotorisedVehicle<?, ?> motorisedVehicle : allVehicles) {
                motorisedVehicle.stopEngine();
            }
    }});
}
