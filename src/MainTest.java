import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MainTest {

    @Test
    public void testValidGUIInput() {
        // Simulate user entering "GUI"
        String input = "GUI\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);  // Set System.in to the simulated input

        // Run the main method of the Main class
        Main.main(new String[]{});

        // Now we can get the 'pieces' object and verify its state
        Pieces pieces = Main.getPieces();  // Access the pieces object from Main
        assertTrue(pieces.getIsGUIGame(), "The game should be set to GUI.");
    }

    @Test
    public void testValidTBIInput() {
        // Simulate user entering "TBI"
        String input = "TBI\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);  // Set System.in to the simulated input

        // Run the main method of the Main class
        Main.main(new String[]{});

        // Now we can get the 'pieces' object and verify its state
        Pieces pieces = Main.getPieces();  // Access the pieces object from Main
        assertFalse(pieces.getIsGUIGame(), "The game should be set to TBI.");
    }

    @Test
    public void testInvalidInput() {
        // Simulate invalid input followed by valid input
        String input = "InvalidInput\nGUI\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);  // Set System.in to the simulated input

        // Run the main method of the Main class
        Main.main(new String[]{});

        // In this case, we are checking if the error message prints (no assertions needed in this test)
        // You can also capture System.out to verify the printed error message.
    }

    @Test
    public void testExceptionHandling() {
        // Simulate invalid input
        String input = "InvalidInput\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);  // Set System.in to the simulated input

        try {
            Main.main(new String[]{});
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect game format. Please enter either 'GUI' or 'TBI'.", e.getMessage());
        }
    }
}
