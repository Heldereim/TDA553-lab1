import static org.junit.Assert.assertEquals;

import java.awt.Color;

import src.Model.*;

import org.junit.Test;

public class carTransportTest {

    @Test
    public void carPlatformLowerTest(){
        CarTransporter carTransporter = new CarTransporter(2);
        carTransporter.lowerPlatform();
        assertEquals(true, carTransporter.isPlatformDown());
    }

    @Test
    public void carPlatformRaiseTest(){
        CarTransporter carTransporter = new CarTransporter(2);
        carTransporter.raisePlatform();
        assertEquals(false, carTransporter.isPlatformDown());
    }

    @Test
    public void loadCarTest() {
        CarTransporter carTransporter = new CarTransporter(2);
        Saab95 mySaab95 = new Saab95();
        Volvo240 myVolvo = new Volvo240(new Engine(100), new TrimBody("Volvo", Color.black, 4, 1.25));

        carTransporter.lowerPlatform();

        carTransporter.load(mySaab95);
        carTransporter.load(myVolvo);

        assertEquals(myVolvo, carTransporter.lookTopCar());
    }

    @Test
    public void moveCarTransport() {
        CarTransporter carTransporter = new CarTransporter(2);
        Saab95 mySaab95 = new Saab95();
        Volvo240 myVolvo = new Volvo240(new Engine(100), new TrimBody("Volvo", Color.black, 4, 1.25));

        carTransporter.lowerPlatform();

        carTransporter.load(mySaab95);
        carTransporter.load(myVolvo);

        carTransporter.raisePlatform();

        carTransporter.startEngine();

        carTransporter.gas(0.5);
        carTransporter.move();
        carTransporter.turnLeft();
        carTransporter.move();

        assertEquals(carTransporter.getCoordinates().x, mySaab95.getCoordinates().x, 0.001);
        assertEquals(carTransporter.getCoordinates().x, myVolvo.getCoordinates().x, 0.001);
    }
}
