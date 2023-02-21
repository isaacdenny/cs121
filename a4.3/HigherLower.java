import java.util.Random;
import java.util.Scanner;

/**
 * Lesson 10: Activity - while Loops and Iterators 
 * 
 * @author Java Foundations
 * @author CS121 Instructors
 * @author Isaac Denny
 * @version Fall 2018
 */
public class HigherLower
{
	public static void main(String[] args)
    {
    // @keyterm initial conditions
    final int MAX = 10;
    String response = "yes";
		int answer;
		int guess;
		
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
    // @keyterm terminating conditions
    while (response.equals("yes")) {
      System.out.println("\n\nI'm thinking of a number between 1 and " + MAX + ". ");
      System.out.print("Guess what it is: ");
      answer = random.nextInt(MAX) + 1;
      guess = Integer.parseInt(scan.nextLine());
      // @keyterm equality
      while (guess != answer) { // @keyterm loop
        if (guess > MAX || guess < 1) {
          System.out.print("Out of bounds! Please try again: ");
        } else if (guess < answer) {
          System.out.print("Your guess is too low! Please try again: ");
        } else if (guess > answer) {
          System.out.print("Your guess is too high! Please try again: ");
        }
        guess = Integer.parseInt(scan.nextLine());
      }

      System.out.println("\nYou got it! Good guessing!");
		  System.out.println("The number was " + answer + ".");
      
      System.out.print("\nWould you like to play again? [yes|no]: ");
      response = scan.nextLine();
    }
    
    System.out.println("Goodbye!\n\n");
		
		scan.close();
	}
}
