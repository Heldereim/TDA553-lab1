import static org.junit.Assert.assertEquals;
import java.awt.*;

import org.junit.Test;

public class ScaniaTest {
    

    @Test
    public void testScaniaConstructor(){
        Scania testScania = new Scania();
        assertEquals("Scania", testScania.getModelName());
        assertEquals(Color.WHITE, testScania.getColor());
        assertEquals(150.0, testScania.getEnginePower(), 0.001);
        assertEquals(2, testScania.getNrDoors());
        assertEquals(0.0, testScania.getCurrentSpeed(), 0.001);
    }

    @Test
    public void testScaniaPlatform(){
        Scania testScania = new Scania();
        assertEquals(0, testScania.getPlatformAngle());
        testScania.raisePlatform(20);
        assertEquals(20, testScania.getPlatformAngle());
        testScania.lowerPlatform(10);
        assertEquals(10, testScania.getPlatformAngle());
    }

    @Test
    public void testMovement(){
        Scania testScania = new Scania();
    }
}
