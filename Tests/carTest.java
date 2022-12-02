// Old test class

// import static org.junit.Assert.assertEquals;

// import java.awt.Color;

// import org.junit.Test;

// public class carTest {
    
//     @Test
//     public void testCar(){ //Tests id the getters in the insance work
//         Car myCar = new Car("VolvoXC60", Color.white, 200, 1);
//         assertEquals("VolvoXC60", myCar.getModelName());
//         assertEquals(1, myCar.getNrDoors());
//         System.out.println(myCar.getModelName());
//         System.out.println(myCar.getNrDoors());
//     }

//     @Test
//     public void carRuns() { //Tests if the movement system workes
//         Car myCar = new Car("Volvo240", Color.black, 100, 4);
//             myCar.startEngine();
//             myCar.gas(0.5);
//             System.out.println(myCar.getXPos() + " " + myCar.getYPos());

//             myCar.move();

//             System.out.println(myCar.getXPos() + " " + myCar.getYPos());

//             assertEquals(Direction.NORTH,myCar.getDirection());

//             myCar.turnRight();
//             myCar.move();
//             assertEquals(Direction.EAST,myCar.getDirection());
//             System.out.println(myCar.getXPos() + " " + myCar.getYPos());

//         }

// }
