import java.text.NumberFormat;

/**
 * Catalog Item class for our online sale.
 * @author Isaac Denny
 */
public class CatalogItem {

  private String name;
  private String description; // @keyterm visibility modifier
  private double price; // @keyterm encapsulation

  /**
   * Constructs a new CatalogItem
   * @param price
   * @param name
   */
  public CatalogItem(String name, double price) {
    this.name = name;
    description = "No description provided";
    setPrice(price);
  }

  /**
   * Constructs a new CatalogItem with description
   * @param price
   * @param name
   * @param description
   */
  public CatalogItem(String name, String description, double price) {
    this.name = name;
    this.description = description;
    setPrice(price);
  }

  /**
   * Gets the price of the item.
   * @return double
   */
  public double getPrice() {
    return price;
  }

  /**
   * Gets the name of the item.
   * @return String
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description of the item.
   * @return String
   */
  public String getDescription() { // @keyterm return type
    return description;
  }

  /**
   * Sets price of the item
   * @param price
   */
  public void setPrice(double price) {
    if (price < 0) price = 0;
    this.price = price;
  }

  /**
   * Sets the description of the item
   * @param description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Returns a String to be used for display in the format
   *
   * <name> (<price>)
   * <description>
   */
  @Override
  public String toString() {
    NumberFormat currency = NumberFormat.getCurrencyInstance();
    String res = name + " (" + currency.format(price) + ")";
    res += "\n" + description;

    return res;
  }
}
