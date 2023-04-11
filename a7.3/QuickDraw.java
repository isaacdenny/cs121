/*
 * Driver for the card game application
 * Usage: <player1Name> <player2Name>
 */
public class QuickDraw {
  /**
   *  Main method for the card game application
   */
  public static void main(String[] args) {
    if (args.length != 2) { // @keyterm validating arguments
      System.out.println("Usage: QuickDraw <player1Name> <player2Name>");
      return;
    }
    DeckOfCards deck = new DeckOfCards();
    deck.shuffle();

    String player1Name = args[0]; // @keyterm command-line arguments
    String player2Name = args[1];

    Card player1Card = deck.draw();
    Card player2Card = deck.draw();
    
    System.out.println(player1Name + " drew " + player1Card.toString());
    System.out.println(player2Name + " drew " + player2Card.toString());

    if (player1Card.compareTo(player2Card) > 0) {
      System.out.println(player1Name + " Wins!");
    }
    else if (player1Card.compareTo(player2Card) < 0) {
      System.out.println(player2Name + " Wins!");
    }
    else {
      System.out.println("Tie Game!");
    }
  }
}
