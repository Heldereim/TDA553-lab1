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

        carTransporter.load(mySaab95);

        //assetEquals()
    }

    @Test
    public void moveCarTransport() {
        CarTransporter carTransporter = new CarTransporter(2);
        Saab95 mySaab95 = new Saab95(new TurboEngine(100.0), new Body("Saab95", Color.red, 4));


        carTransporter.load(mySaab95);

        carTransporter.gas(0.5);
        carTransporter.move();
        carTransporter.turnLeft();
        carTransporter.move();

        assertEquals(carTransporter.getX(), mySaab95.getX(), 0.001);

    }

    
}
