
/**
 * Partner Lab 1
 * Description: This program is designed to convert between different 
 * currencies using predefined/quoted exchange rates. 
 * It supports currency conversions between:
 *     - US dollars and Euros
 *     - US dollars and Malaysian Ringgits
 * 
 * @author Huilin Reid
 * @author Vixen La Ruk
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
 *      3. Malaysian Ringgit -> US Dollar
 *      4. US Dollar -> Malaysian Ringgit
 *      Your choice: 4
 *      Enter the amount to convert: 100
 *      $100.0 = RM422.20
 * 
 *      Choose a conversion option:
 *      1. Euro -> US Dollar
 *      2. US Dollar -> Euro
 *      3. Malaysian Ringgit -> US Dollar
 *      4. US Dollar -> Malaysian Ringgit
 *      Your choice: 5
 *      Invalid choice.
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Conversion {
    // constants for conversion ratios
    static final double DOLLAR_EURO_RATIO = 0.85; // US Dollar to Euro, quoted on Sep 9, 2025
    static final double DOLLAR_RINGGIT_RATIO = 4.22; // US dollar to Malaysian Ringgit, quoted on Sep 9, 2025

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

    /** This method converts a given amount in US Dollars to Malaysian Ringgits. 
     * 
     *  @param amountInDollar the amount of US Dollars to be converted
     *  @return the equivalent amount in Malaysian Ringgits
     */
    public static double dollarToRinggit(double amountInDollar) {
        return amountInDollar * DOLLAR_RINGGIT_RATIO;
    }

    /** This method converts a given amount in Malaysian Ringgits to US Dollars. 
     * 
     *  @param amountInRinggit the amount of Malaysian Ringgits to be converted
     *  @return the equivalent amount in US Dollars
     */
    public static double ringgitToDollar(double amountInRinggit) {
        return amountInRinggit / DOLLAR_RINGGIT_RATIO;
    }
 
    /** displays a currency conversion menu to the user with four options. 
     * It then uses the provided Scanner to read the user's numeric choice 
     * and returns that choice as an integer.
     * 
     *  @param sc the Scanner object used to read user input from the console
     *  @return the user-entered choice
     */
    public static int menu (Scanner sc) {
        System.out.println("Choose a conversion option:");
        System.out.println("1. Euro -> US Dollar");
        System.out.println("2. US Dollar -> Euro");
        System.out.println("3. Malaysian Ringgit -> US Dollar");
        System.out.println("4. US Dollar -> Malaysian Ringgit");
        System.out.print("Your choice: ");
        int choice = sc.nextInt();
        return choice;
    }

    /**
     * main method:
     * The entry point of the program. This method is called when the program starts.
     *
     * @param args an array of command-line arguments passed to the program
     */
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
                    // US Dollars -> Euros
                    System.out.println("\u0024" + amount + " = " + "\u20AC" + df.format(result));
                    break;
                case 3:
                    result = ringgitToDollar(amount);
                    // Malaysian Ringgits -> US Dollars
                    System.out.println("\u0052\u004D" + amount + " = " + "\u0024" + df.format(result));
                    break;
                case 4:
                    result = dollarToRinggit(amount);
                    // US Dollars -> Malaysian Ringgits
                    System.out.println("\u0024" + amount + " = " + "\u0052\u004D" + df.format(result));
                    break;
            }
        }
        in.close(); 
    }   
}
