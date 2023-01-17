/**
 * Demonstrates the use of primitive data types,arithmetic
 * expressions, and promotion
 *
 * @author Isaac Denny
 */
public class MyTempConverter
{
	/**
	 * Computes the Celsius equivalent of a specific Fahrenheit
	 * value using the formula (F - 32) / (9/5) = C
	 */
	public static void main(String[] args)
	{
		// @keyterm primitive data time: int
		final int BASE = 32;
		// @keyterm variable declaration and initialization
		final double CONVERSION_FACTOR = 9.0 / 5.0;

		double fahrenheitTemp = 24;
		double celsiusTemp;  // value to convert

		// @keyterm data conversion (implicit cast BASE to double)
		celsiusTemp = (fahrenheitTemp - BASE) / CONVERSION_FACTOR;

		System.out.println("Celsius Temperature: " + celsiusTemp);
		System.out.println("Fahrenheit Equivalent: " + fahrenheitTemp);
	}
}
