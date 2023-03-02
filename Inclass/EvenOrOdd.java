import java.util.Scanner;

public class EvenOrOdd {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Please enter a number: ");
    int input = scanner.nextInt();

    System.out.println("\n");
    while (input >= 0) {
      String output = input % 2 != 1 ? "Even\n" : "Odd\n"; 
      System.out.print(output);
      System.out.print("Please enter a number: ");
      input = scanner.nextInt();
    }
    System.out.println("\n\n");

    scanner.close();
  }
}
