package Exercise2;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        // Create mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // Inject into service
        MyService service = new MyService(mockApi);

        // Call method
        service.fetchData();

        // Verify that getData() was called
        verify(mockApi).getData();
    }
}
