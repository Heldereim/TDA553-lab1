package src.View;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

import src.Model.*;


// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.GRAY);

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (MotorisedVehicle<?, ?> motorisedVehicle : CarFactory.getAllVehicles()) {
            BufferedImage image = motorisedVehicle.getImage();
            int x = motorisedVehicle.getCoordinates().x;
            int y = motorisedVehicle.getCoordinates().y;

            g.drawImage(image, x, y, null);
        }
    }
}
