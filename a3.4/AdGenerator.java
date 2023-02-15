import java.text.NumberFormat;
import java.util.Scanner;

/**
 *  This class generates an Ad from information provided by the user.
 *  Author: Isaac Denny
 */
public class AdGenerator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    NumberFormat nf = NumberFormat.getInstance();

    System.out.println("\n\nWelcome to AdGenerator!");
    System.out.println("Please enter your profile information");
    System.out.println("=====================================");
    
    System.out.print("First Name: ");
    String firstName = scanner.nextLine();
    System.out.print("Middle Name: ");
    String middleName = scanner.nextLine();
    System.out.print("Last Name: ");
    String lastName = scanner.nextLine();
    System.out.print("Job Title: ");
    String job = scanner.nextLine();
    System.out.print("Phone Number (10 digit): ");
    String phoneNumber = scanner.nextLine();
    System.out.print("Hourly rate: ");
    double hourlyRate = scanner.nextDouble();

    // @keyterm static method invocation
    int areaCode = Integer.valueOf(phoneNumber.substring(0, 3));
    System.out.println("\n\n=====================================");
    System.out.println("Need a " + job + "?");
    System.out.printf("CALL NOW! " + "(%d) " + "%s" + "-" + "%s" + "\n", areaCode, phoneNumber.substring(3, 6),
        phoneNumber.substring(6, 10)); // @keyterm String class method invocation
    System.out.println("Ask for " + firstName + " " + middleName.charAt(0) + ". " + lastName);
    // @keyterm format number as string
    System.out.println("(Rates start at $" + nf.format(hourlyRate) + "/hr)");
    System.out.println("=====================================\n\n");

    scanner.close();
  }
}
