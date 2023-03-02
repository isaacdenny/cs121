public class MultiplicationTable {
  public static void main(String[] args) {
    int i = 1;
    int j = 1;

    System.out.println("\n");
    while (i < 6) {
      while (j < 6) {
        System.out.print(i * j + " ");
        j++;
      }
      System.out.println();
      i++;
      j = 1;
    }
  }
}
