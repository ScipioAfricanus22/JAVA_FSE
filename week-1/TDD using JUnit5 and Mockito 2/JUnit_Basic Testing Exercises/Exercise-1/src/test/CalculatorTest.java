import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void testAddition() {
        Calculator calc = new Calculator();
        
        // Assert that 2 + 3 equals 5
        int expectedResult = 5;
        int actualResult = calc.add(2, 3);
        
        assertEquals(expectedResult, actualResult);
    }
}