package src;
import java.awt.Point;
import javax.swing.*;

import src.Model.CarFactory;
import src.Model.MotorisedVehicle;
import src.Controller.CarController;
import src.View.CarView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Application {
    private static final int X = 800;
    private static final int Y = 800;
    
    private final static int INITIAL_DISTANCE = 100;
    private static final int DELAY = 50;
    
    private static Timer timer = new Timer(DELAY, new TimerListener());
     // The frame that represents this instance View of the MVC pattern
    private static CarView frame;
    
    public static void main(String[] args) {
        frame = new CarView(X, Y);
        CarController cc = new CarController(frame, X, Y);
        
        frame.initComponents("CarSim 1.0");
        
        cc.instantiateActionsAndComponents();

        CarFactory.makeVolvo();
        CarFactory.makeSaab();
        CarFactory.makeScania();

        int i = 0;
        for (MotorisedVehicle<?, ?> motorisedVehicle : CarFactory.getAllVehicles()) { 
            Point point = new Point(0, (i * Application.INITIAL_DISTANCE));
            motorisedVehicle.setCoordinates(point); // Ökar distansen med 100 mellan varje bil i y-led
            i++;
        }

        // Start the timer
        timer.start();
    }

    private static class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            for (MotorisedVehicle<?, ?> motorisedVehicle : CarFactory.getAllVehicles()) {
                motorisedVehicle.move();
            }
            frame.repaint(); // repaint() calls the paintComponent method of the panel
        }
    }
}