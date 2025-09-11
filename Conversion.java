
/**
 * Partner Lab 1
 * Description: This program is designed to convert between different 
 * currencies using predefined/quoted exchange rates. 
 * It supports currency conversions between:
 *     - US dollars and Euros
 *     - US dollars and Japanese Yen
 * 
 * @author Huilin Reid, Vixen La Ruk
 * @since September 10, 2025
 * 
 * To compile: javac Conversion.java
 * To run: java Conversion
 *         then select a conversion option
 *         then input converstion amount
 * 
 * e.g. Choose a conversion option:
 *      1. Euro -> US Dollar
 *      2. US Dollar -> Euro
 *      3. Japanese Yen -> US Dollar
 *      4. US Dollar -> Japanese Yen
 *      Your choice: 4
 *      Enter the amount to convert: 100
 *      $100.0 = ¥14735.00
 * 
 *      Choose a conversion option:
 *      1. Euro -> US Dollar
 *      2. US Dollar -> Euro
 *      3. Japanese Yen -> US Dollar
 *      4. US Dollar -> Japanese Yen
 *      Your choice: 5
 *      Invalid choice.
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Conversion {
    // constants for conversion ratios
    static final double DOLLAR_EURO_RATIO = 0.85; // US Dollar to Euro, quoted on Sep 9, 2025
    static final double DOLLAR_YEN_RATIO = 147.35; // US dollar to Japanese Yen, quoted on Sep 9, 2025

    /** This method converts a given amount in UD Dollars to Euros. 
     * 
     *  @param amountInDollar the amount of US Dollars to be converted
     *  @return the equivalent amount in Euros
     */
    public static double dollarToEuro(double amountInDollar) {
        return amountInDollar * DOLLAR_EURO_RATIO;
    }

    /** This method converts a given amount in Euros to UD Dollars. 
     *
     *  @param amountInEuro the amount of Euros to be converted
     *  @return the equivalent amount in US Dollars
     */
    public static double euroToDollar(double amountInEuro) {
        return amountInEuro / DOLLAR_EURO_RATIO;
    }

    /** This method converts a given amount in US Dollars to Japanese Yen. 
     * 
     *  @param amountInDollar the amount of dollars to be converted
     *  @return the equivalent amount in Japanese Yen
     */
    public static double dollarToYen(double amountInDollar) {
        return amountInDollar * DOLLAR_YEN_RATIO;
    }

    /** This method converts a given amount in Japanese Yen to US Dollars. 
     * 
     *  @param amountInYen the amount of Japanese Yen to be converted
     *  @return the equivalent amount in US Dollars
     */
    public static double yenToDollar(double amountInYen) {
        return amountInYen / DOLLAR_YEN_RATIO;
    }
 
    // menu method - displays currency conversion choices for user to choose
    public static int menu (Scanner sc) {
        System.out.println("Choose a conversion option:");
        System.out.println("1. Euro -> US Dollar");
        System.out.println("2. US Dollar -> Euro");
        System.out.println("3. Japanese Yen -> US Dollar");
        System.out.println("4. US Dollar -> Japanese Yen");
        System.out.print("Your choice: ");
        int choice = sc.nextInt();
        return choice;
    }

    // main method
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.00");

        int choice = menu(in);

        if (choice < 1 || choice > 4) {
            System.out.println("Invalid choice.");
        } else {
            System.out.print("Enter the amount to convert: ");
            double amount = in.nextDouble();

            double result = 0;

            switch (choice) {
                case 1:
                    result = euroToDollar(amount);
                    // Euros -> US Dollars
                    System.out.println("\u20AC" + amount + " = " + "\u0024" + df.format(result));
                    break;
                case 2:
                    result = dollarToEuro(amount);
                    // US Dollar -> Euros
                    System.out.println("\u0024" + amount + " = " + "\u20AC" + df.format(result));
                    break;
                case 3:
                    result = yenToDollar(amount);
                    // Japanese Yen -> US Dollar
                    System.out.println("\u00A5" + amount + " = " + "\u0024" + df.format(result));
                    break;
                case 4:
                    result = dollarToYen(amount);
                    // US Dollar -> Japanese Yen
                    System.out.println("\u0024" + amount + " = " + "\u00A5" + df.format(result));
                    break;
            }
        }
        in.close(); 
    }   
}
