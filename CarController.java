import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController { 

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

        carview.getBrakeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double brakeAmount = 100;
                for (MotorisedVehicle<?, ?> motorisedVehicle : CarFactory.getAllVehicles()) {
                    motorisedVehicle.brake(brakeAmount); 
                }
            }
        });

        carview.getTurboOnButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Saab95 saab : CarFactory.getSaabList()) {
                    saab.setTurboOn();
                }
            }
        });

        carview.getTurboOffButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Saab95 saab : CarFactory.getSaabList()) {
                    saab.setTurboOff();
                }
            }
        });

        carview.getLiftBedButton().addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                for (Scania scania : CarFactory.getScaniaList()) {
                    scania.raisePlatform(70);; // Hard coded value for max raise
                }
            }
        });

        carview.getLowerBedButton().addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                for (Scania scania : CarFactory.getScaniaList()) {
                    scania.lowerPlatform(70); // Hard coded value for max lower
                }
            }
        });

        carview.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (MotorisedVehicle<?, ?> motorisedVehicle : CarFactory.getAllVehicles()) {
                    motorisedVehicle.startEngine();
                }
            }
        });

        carview.getStopButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (MotorisedVehicle<?, ?> motorisedVehicle : CarFactory.getAllVehicles()) {
                    motorisedVehicle.stopEngine();
                }
            }
        });
    }
}
