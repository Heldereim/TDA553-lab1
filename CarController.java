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
    ArrayList<MotorisedVehicle<?, ?>> vehicles = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        
        final int INITIAL_DISTANCE = 100; // TODO MITT
        
        CarController cc = new CarController();

        cc.vehicles.add(new Volvo240());
        cc.vehicles.add(new Saab95());      // TODO MITT
        cc.vehicles.add(new Scania());    // TODO MITT
        
        int i = 0;                      // TODO MITT
        for(MotorisedVehicle<?, ?> motorisedVehicle : cc.vehicles) {
            motorisedVehicle.setCoordinates(new Point(0 , (i*INITIAL_DISTANCE)));        // Ökar distansen med 100 mellan varje bil i y-led
            i++;
        }  


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (MotorisedVehicle<?, ?> motorisedVehicle : vehicles) {
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
        for (MotorisedVehicle<?,?> motorisedVehicle : vehicles) {
           
            motorisedVehicle.gas(gas);
        
    }
}

    public void brake(int brakeamount) {
        double brake = ((double) brakeamount) / 100;
        for (MotorisedVehicle<?,?> motorisedVehicle : vehicles) {
           
            motorisedVehicle.brake(brake);
        }
    }

    public void setTurboOn() {
        for (MotorisedVehicle<?, ?> saab : vehicles) {
            
        }
    }

}