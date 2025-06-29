package Exercise5;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Test;

interface DataProvider {
    String getNextData();
}

public class MultipleReturnsTest {

    @Test
    public void testMultipleReturns() {
        // 1. Mock the interface
        DataProvider mockProvider = mock(DataProvider.class);

        // 2. Stub with multiple return values
        when(mockProvider.getNextData()).thenReturn("Data1", "Data2", "Data3");

        // 3. Use the mock and assert results
        assertEquals("Data1", mockProvider.getNextData());
        assertEquals("Data2", mockProvider.getNextData());
        assertEquals("Data3", mockProvider.getNextData());
    }
}
