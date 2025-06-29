package Exercise1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // Create mock of ExternalApi
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub the getData() method
        when(mockApi.getData()).thenReturn("Mock Data");

        // Inject mock into service
        MyService service = new MyService(mockApi);

        // Test
        String result = service.fetchData();

        // Verify
        assertEquals("Mock Data", result);
    }
}
