import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    ArrayList<String> menu = new ArrayList<String>();
    Diner diner = new Diner("Isaac's Diner", "3302 West 10th Street", menu);
    Diner diner2 = new Diner("Tiny's Diner", "6785 East 33rd Street");

    diner.addToMenu("chips");
    diner2.addToMenu("cheese crackers");

    System.out.println(diner.getName());
    System.out.println(diner.toString());
    System.out.println(diner2.toString());
  }
}
