import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.awt.Color;

import org.junit.Test;

public class carReparShopTest {
    

    @Test
    public void constructorTest(){
        CarRepairShop myShop = new CarRepairShop(0, 0, 2);
        assertEquals(0.0, myShop.getX(), 0.001);
        assertEquals(0.0, myShop.getY(), 0.001);
        assertEquals(2, myShop.getMaxCapacity(), 0.001);
    }

    @Test
    public void loadTest(){
        Volvo240 testVolvo = new Volvo240(new Engine(100.0), new TrimBody("Volvo", Color.black, 4, 1.25));
        Saab95 testSaab1 = new Saab95(new TurboEngine(100.0), new Body("Saab", Color.white, 4));
        Saab95 testSaab2 = new Saab95(new TurboEngine(100.0), new Body("Saab", Color.green, 4));

        CarRepairShop myShop = new CarRepairShop(1, 1, 2);

        myShop.load(testVolvo);
        myShop.load(testSaab1);
        assertThrows(IllegalArgumentException.class, () -> myShop.load(testSaab2));
    }

    @Test
    public void unloadTest(){
        Volvo240 testVolvo = new Volvo240(new Engine(100.0), new TrimBody("Volvo", Color.black, 4, 1.25));

        CarRepairShop myShop = new CarRepairShop(2, 2, 2);

        assertEquals(0.0, testVolvo.getX(), 0.001);
        assertEquals(0.0, testVolvo.getY(), 0.001);

        myShop.load(testVolvo);
        myShop.unload(testVolvo);

        assertEquals(2.0, testVolvo.getX(), 0.001);
        assertEquals(2.0, testVolvo.getY(), 0.001);
    }

    @Test
    public void loadTestRange() {
        Volvo240 testVolvo = new Volvo240(new Engine(100.0), new TrimBody("Volvo", Color.black, 4, 1.25));
        CarRepairShop myShop = new CarRepairShop(10, 10, 2);

        assertThrows(IllegalArgumentException.class, () -> myShop.load(testVolvo));
    }
}
