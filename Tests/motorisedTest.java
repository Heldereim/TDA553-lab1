import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Test;

public class motorisedTest {
    @Test
    public void testMotorisedConstr(){
        MotorisedVehicle<Engine,Body> myVehic = new MotorisedVehicle<Engine,Body>(new Engine(100), new Body("Test", Color.white, 4));
        assertEquals(100, myVehic.getEnginePower(), 0.001);
        assertEquals("Test", myVehic.getModelName());
        assertEquals(Color.white, myVehic.getColor());
        assertEquals(4, myVehic.getNrDoors());
    }

    @Test
    public void testMotorStartEngine(){
        MotorisedVehicle<Engine,Body> myVehic = new MotorisedVehicle<Engine,Body>(new Engine(100), new Body("Test", Color.white, 4));
        myVehic.startEngine(); // Current speed now 0.1
        assertEquals(0.1, myVehic.getCurrentSpeed(), 0.001);
    }

    @Test
    public void testMotorGas(){
        MotorisedVehicle<Engine,Body> myVehic = new MotorisedVehicle<Engine,Body>(new Engine(100), new Body("Test", Color.white, 4));
        myVehic.gas(0.5);
        double expectedSpeed = 0.5 * 100 * 0.01; // Formula for speed
        assertEquals(expectedSpeed, myVehic.getCurrentSpeed(), 0.001);
    }

    @Test
    public void testMovement(){
        MotorisedVehicle<Engine,Body> myVehic = new MotorisedVehicle<Engine,Body>(new Engine(100), new Body("Test", Color.white, 4));
        myVehic.startEngine();
        myVehic.move();
        assertEquals(0.1, myVehic.getY(), 0.001);
    }

    @Test
    public void testTurnLeft(){
        MotorisedVehicle<Engine,Body> myVehic = new MotorisedVehicle<Engine,Body>(new Engine(100), new Body("Test", Color.white, 4));
        myVehic.turnLeft();
        assertEquals(Direction.WEST, myVehic.getDirection());
    }

    @Test
    public void testTurnRight(){
        MotorisedVehicle<Engine,Body> myVehic = new MotorisedVehicle<Engine,Body>(new Engine(100), new Body("Test", Color.white, 4));
        myVehic.turnRight();
        assertEquals(Direction.EAST, myVehic.getDirection());
    }

    @Test
    public void testTurnMove(){
        MotorisedVehicle<Engine,Body> myVehic = new MotorisedVehicle<Engine,Body>(new Engine(100), new Body("Test", Color.white, 4));
        myVehic.turnLeft();
        myVehic.startEngine();
        myVehic.move();
        assertEquals(-0.1, myVehic.getX(), 0.001);
    }
}
