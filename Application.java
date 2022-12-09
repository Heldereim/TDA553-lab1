import java.awt.Point;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

public class Application {
    
    private final static int INITIAL_DISTANCE = 100;
    private static final int DELAY = 50;
    
    private static Timer timer = new Timer(DELAY, new TimerListener());
     // The frame that represents this instance View of the MVC pattern
    private static CarView frame;
    
    public static void main(String[] args) {
        
        CarController cc = new CarController();

        CarFactory.makeVolvo();
        CarFactory.makeSaab();
        CarFactory.makeScania();

        int i = 0; // TODO MITT
        for (MotorisedVehicle<?, ?> motorisedVehicle : CarFactory.getAllVehicles()) { // TODO MITT
            Point point = new Point(0, (i * Application.INITIAL_DISTANCE));
            motorisedVehicle.setCoordinates(point); // Ökar distansen med 100 mellan varje bil i y-led
            i++;
        }

        // Start a new view and send a reference of self
        frame = new CarView("CarSim 1.0");

        // Start the timer
        timer.start();
    }

    private static class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (MotorisedVehicle<?, ?> motorisedVehicle : CarFactory.getAllVehicles()) {
                motorisedVehicle.move();
                // Point coordinates = motorisedVehicle.getCoordinates();
                // frame.drawPanel.moveIt(motorisedVehicle, coordinates.x, coordinates.y);
            }
            
            frame.drawPanel.repaint(); // repaint() calls the paintComponent method of the panel
        }
    }
}