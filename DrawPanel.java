import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage; // MITT
    BufferedImage scaniaImage; // MITT

    // To keep track of a singel cars position
    // Point volvoPoint = new Point();
    // Point saabPoint = new Point();  // MITT
    // Point scaniaPoint = new Point(); // MITT

    MotorisedVehicle<?, ?> myVolvo;
    MotorisedVehicle<?, ?> mySaab;
    MotorisedVehicle<?, ?> myScania;

    // void moveIt(MotorisedVehicle<?,?> motorisedVehicle, double x, double y) {
    //     volvoPoint.x = (int) motorisedVehicle.getCoordinates().x;
    //     volvoPoint.y = (int) motorisedVehicle.getCoordinates().y;

    //     saabPoint.x = (int) x + 100;
    //     saabPoint.y = (int) y;

    //     scaniaPoint.x = (int) x + 200;
    //     scaniaPoint.y = (int) y;

     //   Point testPoint = new Point( ( (int) x) , ( (int) y) );
     //  motorisedVehicle.setCoordinates(testPoint);
    

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<MotorisedVehicle<?, ?>> allVehicles) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.GRAY);

        this.myVolvo = allVehicles.get(0);
        this.mySaab = allVehicles.get(1);
        this.myScania = allVehicles.get(2);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            volvoImage = ImageIO.read(new File("Assets/Volvo240.jpg"));
            saabImage = ImageIO.read(new File("Assets/Saab95.jpg"));
            scaniaImage = ImageIO.read(new File("Assets/Scania.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            // volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("Assets/Volvo240.jpg"));
            // saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("Assets/Saab95.jpg"));   // MITT
            // scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("Assets/Scania.jpg")); // MITT 
        }
        catch (IOException ex) { 
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        // g.drawImage(saabImage, saabPoint.x, saabPoint.y, null);         // MITT
        // g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null);  // MITT  

        g.drawImage(volvoImage, this.myVolvo.getCoordinates().x, this.myVolvo.getCoordinates().y, null);
        g.drawImage(saabImage, this.mySaab.getCoordinates().x , this.mySaab.getCoordinates().y, null);
        g.drawImage(scaniaImage, this.myScania.getCoordinates().x, this.myScania.getCoordinates().y, null);
    }
}
