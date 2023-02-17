import java.util.Scanner;

/**
 * Lesson 9: Activity - Data Comparisons and Switch Statements
 * 
 * @author CS121 Instructors
 * @author Isaac Denny
 */
public class Verses
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Which day is it (1 - 12)? ");
		int day = scan.nextInt();
		
		String daySuffix = "st";
		switch (day) {
			case 1:
				daySuffix = "st";
				break;
			case 2:
				daySuffix = "nd";
				break;
			case 3:
				daySuffix = "rd";
				break;
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
			case 11:
			case 12:
				daySuffix = "th";
			default:
				break;
		}
		
		System.out.println("On the " + day + daySuffix + " day of Christmas my true love gave to me");

		switch (day) {
			case 12:
				System.out.println("Twelve drummers drumming,");
			case 11:
				System.out.println("Eleven pipers piping,");
			case 10:
				System.out.println("Ten lords a leaping,");
			case 9:
				System.out.println("Nine ladies dancing,");
			case 8:
				System.out.println("Eight maids a milking,");
			case 7:
				System.out.println("Seven swans a swimming,");
			case 6:
				System.out.println("Six geese a laying,");
			case 5:
				System.out.println("Five golden rings,");
			case 4:
				System.out.println("Four calling birds,");
			case 3:
				System.out.println("Three french hens,");
			case 2:
				System.out.println("Two turtle doves, and");
			case 1:
				System.out.println("A partridge in a pear tree.");
				break;
			default:
				break;
		}
		
		scan.close();
	}
}