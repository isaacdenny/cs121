import java.util.Random;

public class BubbleSorter {
  private int[] values; // @keyterm array declaration

  /**
   * Constructor for BubbleSorter
   * @param values
   */
  public BubbleSorter(int size) {
    Random rand = new Random();
    this.values = new int[size]; // @keyterm array initialization

    for (int i = 0; i < values.length; i++) { 
      values[i] = rand.nextInt() % 5 + 5;
    }
  }

  /**
   * Sorts the values using the bubble sort algorithm
   */
  public void sort() {
    boolean done = false;
    while (!done) {
      done = true;
      for (int i = 1; i < values.length; i++) { // @keyterm bounds checking
        if (values[i - 1] > values[i]) { // @keyterm array element
          swap(i - 1, i);
          done = false;
        }
      }
    }
  }

  @Override
  public String toString() {
    String toReturn = "Array Contents: ";
    for (int i = 0; i < values.length; i++) {
      toReturn += values[i] + ", ";
    }
    return toReturn;
  }

  private void swap(int x, int y) {
    int temp = values[x];
    values[x] = values[y];
    values[y] = temp;
  }
}
