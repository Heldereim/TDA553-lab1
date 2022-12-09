import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import src.Model.*;

import java.awt.*;

import org.junit.Test;

public class ScaniaTest {
    

    @Test
    public void testScaniaConstructor(){
        Scania testScania = new Scania();
        assertEquals("Scania", testScania.getModelName());
        assertEquals(Color.WHITE, testScania.getColor());
        assertEquals(100.0, testScania.getEnginePower(), 0.001);
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
        testScania.lowerPlatform(30);
        assertEquals(0, testScania.getPlatformAngle());
    }

    @Test
    public void testPlatformWhileMoving(){
        Scania testScania = new Scania();
        testScania.startEngine();
        testScania.gas(1);
        assertEquals(1, testScania.getCurrentSpeed(), 0.001);
        
        assertThrows(IllegalStateException.class, () -> testScania.raisePlatform(20));
        testScania.move();
        assertEquals(0.0, testScania.getCoordinates().y, 0.001);
        testScania.turnLeft();
        testScania.move();
        assertEquals(1.0, testScania.getCoordinates().x, 0.001);
    }
}
