package Exercise4;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

// External dependency with void method
interface AlertService {
    void sendAlert(String message);
}

// Class under test
class AlarmSystem {
    private AlertService alertService;

    public AlarmSystem(AlertService alertService) {
        this.alertService = alertService;
    }

    public void triggerAlarm() {
        alertService.sendAlert("Intruder detected!");
    }
}

public class VoidMethodTest {

    @Test
    public void testVoidMethod() {
        // 1. Create mock
        AlertService mockAlertService = Mockito.mock(AlertService.class);

        // 2. Stub void method (optional if no exception thrown)
        doNothing().when(mockAlertService).sendAlert(anyString());

        // 3. Inject into system under test
        AlarmSystem alarmSystem = new AlarmSystem(mockAlertService);

        // 4. Call method
        alarmSystem.triggerAlarm();

        // 5. Verify interaction
        verify(mockAlertService).sendAlert("Intruder detected!");
    }
}
