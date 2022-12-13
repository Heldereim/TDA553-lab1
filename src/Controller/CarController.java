package src.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import src.View.CarView;
import src.Model.*;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController { 

    private int X;
    private int Y;

    CarView carview;
    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    public CarController(CarView cw, int X, int Y) {
        this.carview = cw;
        this.X = X;
        this.Y = Y;
    }


    public void instantiateActionsAndComponents(){

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setLayout(new GridLayout(2,4));
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        controlPanel.setBackground(Color.CYAN);
        addComponent(controlPanel);

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        addComponent(gasPanel);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.addButton(startButton);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.addButton(stopButton);

        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (MotorisedVehicle<?, ?> motorisedVehicle : CarFactory.getAllVehicles()) {
                    motorisedVehicle.gas(gasAmount); 
                }
            }
        });

         brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double brakeAmount = 100;
                for (MotorisedVehicle<?, ?> motorisedVehicle : CarFactory.getAllVehicles()) {
                    motorisedVehicle.brake(brakeAmount); 
                }
            }
        });

       turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Saab95 saab : CarFactory.getSaabList()) {
                    saab.setTurboOn();
                }
            }
        });

        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Saab95 saab : CarFactory.getSaabList()) {
                    saab.setTurboOff();
                }
            }
        });

        liftBedButton.addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                for (Scania scania : CarFactory.getScaniaList()) {
                    scania.raisePlatform(70);; // Hard coded value for max raise
                }
            }
        });

        lowerBedButton.addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                for (Scania scania : CarFactory.getScaniaList()) {
                    scania.lowerPlatform(70); // Hard coded value for max lower
                }
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (MotorisedVehicle<?, ?> motorisedVehicle : CarFactory.getAllVehicles()) {
                    motorisedVehicle.startEngine();
                }
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (MotorisedVehicle<?, ?> motorisedVehicle : CarFactory.getAllVehicles()) {
                    motorisedVehicle.stopEngine();
                }
            }
        });
    }

    public CarView getCarView(){
        return this.carview;
    }

    public void addComponent(Component comp){
        carview.add(comp);
    }

    public void addButton(JButton button){
        carview.add(button);
    }
}
