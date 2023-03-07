/**
 * Driver for CatalogItem
 * Tests the functionality of CatalogItem
 * 
 * @author Isaac Denny
 */
public class Main {
  
  public static void main(String[] args) {
    CatalogItem banana = new CatalogItem("Golden Banana", 0.45);
    CatalogItem legendaryDragon = new CatalogItem("Legendary Dragon", "Firehazard, keep away from children", 3.50);

    System.out.println(banana.toString());
    System.out.println(legendaryDragon.toString());

    for (int i = -1; i < 2; i++) {
      banana.setPrice(i);
      if (i >= 0) {
        System.out.println("Should be " + i + ": " + banana.getPrice());
      } else {
        System.out.println("Should be 0: " + banana.getPrice());
      }
    }
    
    System.out.println("Should be 'Golden Banana': " + banana.getName());
    banana.setDescription("Mmm Tasty");
    System.out.println("Should be 'Mmm Tasty': " + banana.getDescription());

  }
}
