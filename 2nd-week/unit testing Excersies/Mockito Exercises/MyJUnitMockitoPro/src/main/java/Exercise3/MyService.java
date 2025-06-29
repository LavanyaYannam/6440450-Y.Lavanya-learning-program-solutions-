package Exercise3;

public class MyService {
    private ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public void notifyUser(String userId) {
        externalApi.sendMessage(userId, "Welcome " + userId);
    }
}
