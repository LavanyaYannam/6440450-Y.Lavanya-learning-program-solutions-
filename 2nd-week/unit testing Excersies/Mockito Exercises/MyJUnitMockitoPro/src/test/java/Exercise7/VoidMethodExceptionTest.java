package Exercise7;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Test;

interface EmailSender {
    void send(String email);
}

public class VoidMethodExceptionTest {

    @Test(expected = RuntimeException.class)
    public void testVoidMethodException() {
        // 1. Create mock
        EmailSender mockSender = mock(EmailSender.class);

        // 2. Stub the void method to throw exception
        doThrow(new RuntimeException("Email server down")).when(mockSender).send("user@example.com");

        // 3. Call the method to trigger exception
        mockSender.send("user@example.com");
    }
}
