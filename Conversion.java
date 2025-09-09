
/**
 * Partner Lab 1
 * Description: This program is designed to convert between different 
 * currencies using predefined/quoted exchange rates. It supports 
 * conversions between:
 *     US dollars and Euros
 *                     
 * ....
 * 
 * @author Huilin Reid, Vixen Ruk
 * @since September 6, 2025
 * 
 * To compile: javac Conversion.java
 * To run: java Conversion
 * then select a conversion option
 * then input converstion amount
 * 
 * e.g.
 * 
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Conversion {
    // constants for conversion ratios
    static final double DOLLAR_EURO_RATIO = 0.85; // quoted on Sep 9, 2025
    // static final double DOLLAR_EURO_RATIO = 0.85; // quoted on Sep 9, 2025

    // conversion method - dollar to euro
    public static double dollarToEuro(double amountInDollar) {
        return amountInDollar * DOLLAR_EURO_RATIO;
    }

    // conversion method - euro to dollar
    public static double euroToDollar(double amountInEuro) {
        return amountInEuro / DOLLAR_EURO_RATIO;
    }

    // menu method
    public static int menu (Scanner sc) {
        System.out.println("Choose a conversion option:");
        System.out.println("1. Euro -> US Dollar");
        System.out.println("2. US Dollar -> Euro");
        System.out.println("3. ");
        System.out.println("4. ");
        System.out.print("Your choice: ");
        int choice = sc.nextInt();
        return choice;
    }

    // main method
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.00");

        int choice = menu(sc);

        System.out.print("Enter the amount to convert: ");
        double amount = sc.nextDouble();

        double result = 0;

        switch (choice) {
            case 1:
                result = euroToDollar(amount);
                // System.out.println(amount + " Euros = " + df.format(result) + " US Dollars");
                System.out.println(" \u20AC " + amount  + " = " + " \u0024" + df.format(result));
                break;
            case 2:
                result = dollarToEuro(amount);
                System.out.println(" \u0024" + amount + " = " + " \u20AC" + df.format(result));
                break;
            // case 3:
            //     result = Euro2Dollar(amount);
            //     System.out.println(amount + " Euro = " + df.format(result) + " US Dollar");
            //     break;
            // case 4:
            //     result = Dollar2Euro(amount);
            //     System.out.println(amount + " US Dollar = " + df.format(result) + " Euro");
            //     break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        

        sc.close();
    }
    
}
