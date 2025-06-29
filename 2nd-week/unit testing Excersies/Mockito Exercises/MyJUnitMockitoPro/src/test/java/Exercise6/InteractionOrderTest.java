package Exercise6;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.InOrder;

interface Printer {
    void printTitle();
    void printContent();
    void printFooter();
}

public class InteractionOrderTest {

    @Test
    public void testInteractionOrder() {
        // 1. Create mock
        Printer mockPrinter = mock(Printer.class);

        // 2. Call methods in a specific order
        mockPrinter.printTitle();
        mockPrinter.printContent();
        mockPrinter.printFooter();

        // 3. Verify the order
        InOrder inOrder = inOrder(mockPrinter);
        inOrder.verify(mockPrinter).printTitle();
        inOrder.verify(mockPrinter).printContent();
        inOrder.verify(mockPrinter).printFooter();
    }
}
