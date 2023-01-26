import java.util.Scanner;

/**
 * This class takes in a seconds amount 
 * and converts it to hours, minutes, seconds
 * 
 * @author Isaac Denny
 */

public class ConvertToHMS {
  public static void main(String[] args) {

    // @keyterm Scanner
    Scanner scn = new Scanner(System.in);
    int hours;
    int minutes;
    int seconds;
    
    // @keyterm String (parameter)
    System.out.print("Enter an amount of seconds: ");
    // @keyterm Token
    int input = Integer.parseInt(scn.next());
    scn.close();

    hours = input / 3600;
    // @keyterm modulo
    minutes = (input % 3600) / 60;
    seconds = (input % 3600) % 60;

    System.out.println(input + " seconds is " + hours + " Hours, " + minutes + " Minutes, " + seconds + " Seconds");
  }

}
