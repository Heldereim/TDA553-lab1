import static org.junit.Assert.assertEquals;
import src.Model.*;

import org.junit.Test;

public class Saab95Test {
    @Test
    public void constructorTest(){
        Saab95 testSaab = new Saab95();
        assertEquals("Test", testSaab.getModelName());
        assertEquals(100.0, testSaab.getEnginePower(), 0.001);
    }
}
