package Exercise3;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

public class MyServiceTest {

    @Test
    public void testArgumentMatching() {
        // Create mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // Inject mock into service
        MyService service = new MyService(mockApi);

        // Call method with specific userId
        service.notifyUser("user123");

        // Use argument matchers to verify the method was called with expected arguments
        verify(mockApi).sendMessage(eq("user123"), contains("Welcome"));
    }
}
