import static org.mockito.Mockito.*; 
import static org.junit.jupiter.api.Assertions.assertEquals; // JUnit 5 assert package

import org.junit.jupiter.api.Test; 

class MyServiceTest { 

    @Test 
    void testExternalApi() { 
        // 1. ARRANGE: Create a fake/mock instance of the external dependency
        ExternalApi mockApi = mock(ExternalApi.class); 
        
        // STUB: Hardcode the behavior of the mock when a specific method is called
        when(mockApi.getData()).thenReturn("Mock Data"); 
        
        // Inject our mock tool right into our service layer
        MyService service = new MyService(mockApi); 
 
        // 2. ACT
        String result = service.fetchData(); 
 
        // 3. ASSERT
        assertEquals("Mock Data", result, "Service did not pass through mocked api data safely."); 
    } 
}