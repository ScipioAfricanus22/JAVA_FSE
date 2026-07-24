import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CounterTest {

    // This object serves as our test fixture
    private Counter counter;

    // JUnit 5 equivalent to @Before
    @BeforeEach
    void setUp() {
        // Runs automatically before every @Test method
        counter = new Counter();
        System.out.println("Fixture arranged: Counter initialized to 0.");
    }

    // JUnit 5 equivalent to @After
    @AfterEach
    void tearDown() {
        // Runs automatically after every @Test method clears resources
        counter = null;
        System.out.println("Fixture torn down: Counter reset to null.");
    }

    @Test
    void testIncrementUsingAAA() {
        // 1. ARRANGE
        // (The counter object was already arranged and initialized in our setUp method)
        
        // 2. ACT
        counter.increment();
        
        // 3. ASSERT
        assertEquals(1, counter.getCount(), "Counter should increment to 1");
    }
}