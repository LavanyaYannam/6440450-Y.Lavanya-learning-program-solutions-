package Exercise2;

import static org.junit.Assert.*;
import org.junit.Test;

public class MathUtilsTest {

    @Test
    public void testAdd() {
        MathUtils math = new MathUtils();
        int result = math.add(5, 3);
        assertEquals(8, result);
    }

    @Test
    public void testSubtract() {
        MathUtils math = new MathUtils();
        int result = math.subtract(10, 4);
        assertEquals(6, result);
    }

    @Test
    public void testMultiply() {
        MathUtils math = new MathUtils();
        int result = math.multiply(2, 6);
        assertEquals(12, result);
    }

    @Test
    public void testDivide() {
        MathUtils math = new MathUtils();
        int result = math.divide(8, 2);
        assertEquals(4, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        MathUtils math = new MathUtils();
        math.divide(5, 0); // Should throw exception
    }
}
