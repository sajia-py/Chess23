import java.util.Scanner;

public class Main {

    private static Pieces pieces = new Pieces();  // Make pieces static so it can be accessed in the test

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to CHESS23. Enter \"GUI\" to play on a Graphical User Interface. Alternatively, enter \"TBI\" to play on the terminal.");

        boolean correctType = false;

        while (!correctType) {
            try {
                String gameType = sc.next();

                if (gameType.equals("GUI")) {
                    pieces.setGUIGame(true); // Set the game type to GUI
                    new GUIBoard(pieces);
                    correctType = true;
                }
                else if (gameType.equals("TBI")) {
                    pieces.setGUIGame(false); // Set the game type to TBI
                    TBIBoard.gameLoop(pieces);
                    correctType = true;
                }
                else {
                    throw new IllegalArgumentException("Incorrect game format. Please enter either 'GUI' or 'TBI'.");
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // Print the error message if incorrect input is provided
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    // Getter for the 'pieces' object to access in tests
    public static Pieces getPieces() {
        return pieces;
    }
}
