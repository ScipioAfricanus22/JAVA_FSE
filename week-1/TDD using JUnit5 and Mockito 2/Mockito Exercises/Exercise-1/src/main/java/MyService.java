public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        // Business logic interacting with the injected API dependency
        return externalApi.getData();
    }
}