/**
    Demonstrates the use of Strings and variable
    @author Isaac Denny
*/

public class ModernArt {
    public static void main(String[] args) {
        // constant string variable - cannot be changed
        final String BORDER = "#";
        // string literal is a literal character value inside quotes
        String art = ":)";
        int rows = 10;
        int columns = 4;

        DrawBorder(columns, BORDER);

        for (int i = 0; i < rows; i++) {
            System.out.print(BORDER);
            for (int j = 0; j < columns; j++) {
                System.out.print(art);
            }
            // escape sequence \n creates a new line
            // string concatenation
            System.out.print(BORDER + "\n");
        }
        DrawBorder(columns, BORDER);
    }

    public static void DrawBorder(int col, String character) {
        for (int i = 0; i < col * 2; i++) {
            System.out.print(character);
        }

        System.out.print("\n");
    }
}
