import static org.junit.Assert.assertEquals;

import java.awt.Color;

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
        Saab95 mySaab95 = new Saab95(new TurboEngine(125.0), new Body("Saab85", Color.black, 4));
        Volvo240 myVolvo = new Volvo240(new Engine(100), new TrimBody("Volvo", Color.black, 4, 1.25));

        carTransporter.lowerPlatform();

        carTransporter.load(mySaab95);
        carTransporter.load(myVolvo);

        assertEquals(myVolvo, carTransporter.lookTopCar());
    }

    @Test
    public void moveCarTransport() {
        CarTransporter carTransporter = new CarTransporter(2);
        Saab95 mySaab95 = new Saab95(new TurboEngine(100.0), new Body("Saab95", Color.red, 4));
        Volvo240 myVolvo = new Volvo240(new Engine(100), new TrimBody("Volvo", Color.black, 4, 1.25));

        carTransporter.lowerPlatform();

        carTransporter.load(mySaab95);
        carTransporter.load(myVolvo);

        carTransporter.raisePlatform();

        carTransporter.gas(0.5);
        carTransporter.move();
        carTransporter.turnLeft();
        carTransporter.move();

        assertEquals(carTransporter.getX(), mySaab95.getX(), 0.001);
        assertEquals(carTransporter.getX(), myVolvo.getX(), 0.001);
    }
}
