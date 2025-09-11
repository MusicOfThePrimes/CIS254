
/**
 * Partner Lab 1
 * Description: This program is designed to convert between different 
 * currencies using predefined/quoted exchange rates. It supports 
 * conversions between:
 *     US dollars and Euros
 *                     
 * ....
 * 
 * @author Huilin Reid, Vixen La Ruk hii
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
 *      3. YEN -> US Dollar
 *      4. US Dollar -> Yen
 *      Your choice: 4
 *      Enter the amount to convert: 100
 *      $100.0 = ¥14735.00
 * 
 *      Choose a conversion option:
 *      1. Euro -> US Dollar
 *      2. US Dollar -> Euro
 *      3. YEN -> US Dollar
 *      4. US Dollar -> Yen
 *      Your choice: 5
 *      Invalid choice.
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Conversion {
    // constants for conversion ratios
    static final double DOLLAR_EURO_RATIO = 0.85; // quoted on Sep 9, 2025
    static final double DOLLAR_YEN_RATIO = 147.35; // quoted on Sep 9, 2025

    /** This method converts dollar to euro, 
        using the inputed dollar amount.
        @param amountInDollar the amount of dollars to be converted
    */
    public static double dollarToEuro(double amountInDollar) {
        return amountInDollar * DOLLAR_EURO_RATIO;
    }

    
    /** This method converts euro to dollar, 
        using the inputed euro amount.
        @param amountInEuro the amount of euros to be converted
    */
    public static double euroToDollar(double amountInEuro) {
        return amountInEuro / DOLLAR_EURO_RATIO;
    }

    /** This method converts yen to dollar, 
        using the inputed yen amount.
        @param amountInYen the amount of yens to be converted
    */
    public static double yenToDollar(double amountInYen) {
        return amountInYen / DOLLAR_YEN_RATIO;
    }

    /** This method converts dollar to yen, 
        using the inputed dollar amount.
        @param amountInDollar the amount of dollars to be converted
    */
    public static double dollarToYen(double amountInDollar) {
        return amountInDollar * DOLLAR_YEN_RATIO;
    }

    // menu method - displays currency conversion choices for user to choose
    public static int menu (Scanner sc) {
        System.out.println("Choose a conversion option:");
        System.out.println("1. Euro -> US Dollar");
        System.out.println("2. US Dollar -> Euro");
        System.out.println("3. YEN -> US Dollar");
        System.out.println("4. US Dollar -> Yen");
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
                    // System.out.println(amount + " Euros = " + df.format(result) + " US Dollars");
                    System.out.println("\u20AC" + amount + " = " + "\u0024" + df.format(result));
                    break;
                case 2:
                    result = dollarToEuro(amount);
                    System.out.println("\u0024" + amount + " = " + "\u20AC" + df.format(result));
                    break;
                case 3:
                    result = yenToDollar(amount);
                    System.out.println("\u00A5" + amount + " = " + "\u0024" + df.format(result));
                    break;
                case 4:
                    result = dollarToYen(amount);
                    System.out.println("\u0024" + amount + " = " + "\u00A5" + df.format(result));
                    break;
            }
        }
        in.close();
    }   
}
