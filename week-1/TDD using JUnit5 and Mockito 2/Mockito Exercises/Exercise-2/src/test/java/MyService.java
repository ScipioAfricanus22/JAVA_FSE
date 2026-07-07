import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

class MyServiceTest {

    @Test
    void testVerifyInteraction() {
        // 1. ARRANGE
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // 2. ACT
        service.processAndSend("data");

        // 3. ASSERT / VERIFY
        // Checks that doProcessing was called exactly once with the exact string "data_processed"
        verify(mockApi, times(1)).doProcessing("data_processed");
    }
}