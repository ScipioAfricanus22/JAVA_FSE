public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public void processAndSend(String originalText) {
        // Appends a suffix to show argument transformation business logic
        String updatedText = originalText + "_processed";
        
        // The service calls the external api dependency
        externalApi.doProcessing(updatedText);
    }
}