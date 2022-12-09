import static org.junit.Assert.assertEquals;
import src.Model.*;

import java.awt.Color;

import org.junit.Test;

public class Saab95Test {
    @Test
    public void constructorTest(){
        Saab95 testSaab = new Saab95(new TurboEngine(100.0), new Body("Test", Color.black, 4));
        assertEquals("Test", testSaab.getModelName());
        assertEquals(100.0, testSaab.getEnginePower(), 0.001);
    }
}
