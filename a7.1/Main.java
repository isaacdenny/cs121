public class Main {
  public static void main(String[] args) {
    final int LENGTH = 12;
    BubbleSorter bSorter = new BubbleSorter(LENGTH); 

    System.out.println("Array before sort: ");
    System.out.println(bSorter.toString());
    bSorter.sort();
    System.out.println("Array after sort: ");
    System.out.println(bSorter.toString());
  }
}
