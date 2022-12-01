import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Test;

public class carTest {
    
    @Test
    public void testCar(){ //Tests id the getters in the insance work
        Car myCar = new Car("VolvoXC60", Color.white, 200, 1);
        assertEquals("VolvoXC60", myCar.getModelName());
        assertEquals(1, myCar.getNrDoors());
        assertEquals(Color.white, myCar.getColor());
        assertEquals(200, myCar.getEnginePower(), 0.001);
        assertEquals(1, myCar.getNrDoors());
    }

    @Test
    public void carTurnRight() { //Tests if the movement system workes
        Car myCar = new Car("Volvo240", Color.black, 100, 4);
        assertEquals(Direction.NORTH,myCar.getDirection());
        myCar.turnRight();
        assertEquals(Direction.EAST,myCar.getDirection());
    }

    @Test
    public void carEngineStart(){
        Car testCar = new Car("Test", Color.white, 100, 4);
        testCar.startEngine();
        assertEquals(0.1, testCar.getCurrentSpeed(), 0.001);
    }

    @Test
    public void carMove(){
        Car testCar = new Car("Test", Color.white, 100, 4);
        testCar.startEngine();                                                                 // Car gets currentspeed 0.1
        testCar.move();
        assertEquals(0.1, testCar.getYPos(), 0.001);
    }
        
    @Test
    public void carTurnLeft(){
        Car myCar = new Car("Volvo240", Color.black, 100, 4);
        myCar.turnLeft();
        assertEquals(Direction.WEST, myCar.getDirection());
    }

    @Test
    public void carBrake(){
        Car testCar = new Car("Volvo240", Color.BLACK, 100, 4);

        testCar.gas(0.5);
        testCar.move();
        assertEquals(0.5, testCar.getYPos(), 0.001);

        testCar.brake(0.5);
        testCar.move();
        assertEquals(0.5, testCar.getYPos(), 0.001);
    }

    @Test
    public void carTurnMove(){
        Car testCar = new Car("Test", Color.white, 100, 4);
        testCar.startEngine();
        testCar.turnLeft();
        testCar.move();
        assertEquals(-0.1, testCar.getXPos(), 0.001);
    }
}
