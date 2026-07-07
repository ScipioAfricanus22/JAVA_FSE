import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AssertionsTest { 

    @Test 
    void testAssertions() { 
        // 1. Assert equals: Checks if expected matches actual
        assertEquals(5, 2 + 3, "2 + 3 should equal 5"); 
 
        // 2. Assert true: Passes if the condition inside is true
        assertTrue(5 > 3); 
 
        // 3. Assert false: Passes if the condition inside is false
        assertFalse(5 < 3); 
 
        // 4. Assert null: Passes if the object is null
        assertNull(null); 
 
        // 5. Assert not null: Passes if the object exists
        DataService service = new DataService();
        assertNotNull(service.getNewObject()); 
    } 
}