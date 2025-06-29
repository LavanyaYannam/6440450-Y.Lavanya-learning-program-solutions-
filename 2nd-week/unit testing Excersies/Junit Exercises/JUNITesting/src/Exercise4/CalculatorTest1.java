package Exercise4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest1 {

    private Calculator1 calculator;  // Updated class reference

    // Setup: runs before each test
    @Before
    public void setUp() {
        System.out.println("Setting up...");
        calculator = new Calculator1();  // Arrange
    }

    //teardown: runs after each test
    @After
    public void tearDown() {
        System.out.println("Cleaning up...");
        calculator = null;
    }

    @Test
    public void testAddition() {
        // Act
        int result = calculator.add(10, 5);

        // Assert
        assertEquals(15, result);
    }

    @Test
    public void testMultiplication() {
        // Act
        int result = calculator.multiply(4, 3);

        // Assert
        assertEquals(12, result);
    }
}
