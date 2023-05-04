public class PopSickle {
  public static void main(String[] args) {
    final int LIMIT = 100;
    
    // for any multiple of 3: "Pop"
    // for any multiple of 8: "Sickle"
    // multiples of both 3 && 8: "PopSickle"

    for (int i = 0; i < LIMIT; i++) {
      if (i % 3 == 0 && i % 8 == 0) {
        System.out.print("PopSickle ");
      }
      else if (i % 3 == 0) {
        System.out.print("Pop ");
      }
      else if (i % 8 == 0) {
        System.out.print("Sickle ");
      }
      else {
        System.out.print(i + " ");
      }
    }
  }
}