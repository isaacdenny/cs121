import java.util.Random;

public class DeckOfCards implements DeckOfCardsInterface {
  private Card[] deck; // @keyterm array of objects
  private final int DECKSIZE = 52;
  private int nextCardIndex;
  
  /**
   * Constructs a new DeckOfCards
   */
  public DeckOfCards() {
    this.deck = new Card[DECKSIZE];
    this.nextCardIndex = 0;

    for (Suit s : Suit.values()) {
      for (Rank r : Rank.values()) {
        deck[nextCardIndex] = new Card(s, r);
        nextCardIndex++;
      }
    }
    this.nextCardIndex = 0;
  }

  @Override
  public void shuffle() {
    Random rand = new Random();
    for (int i = 0; i < deck.length; i++) {
      int j = rand.nextInt(deck.length);
      Card temp = deck[i];
      deck[i] = deck[j];
      deck[j] = temp;
    }
    nextCardIndex = 0;
  }

  @Override
  public Card draw() {
    if (nextCardIndex > deck.length - 1) {
      return null;
    }
    Card drawnCard = deck[nextCardIndex];
    nextCardIndex++;
    return drawnCard;
  }

  @Override
  public int numCardsRemaining() {
    int numCards = 0;
    for (int i = nextCardIndex; i < deck.length; i++) {
      numCards++;
    }
    return numCards;
  }

  @Override
  public int numCardsDealt() {
    int numCards = 0;
    for (int i = nextCardIndex - 1; i >= 0; i--) {
      numCards++;
    }
    return numCards;
  }

  @Override
  public Card[] dealtCards() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'dealtCards'");
  }

  @Override
  public Card[] remainingCards() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'remainingCards'");
  }

  @Override
  public String toString() {
    String result = "--Deck--\n";
    for (Card card : this.deck) {
      result += card.toString() + "\n";
    }
    return result;
  }
  
}
