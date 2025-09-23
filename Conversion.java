/**
 * Currency Converter Program
 *
 * <p>This program is an interactive currency converter that allows users to convert 
 * monetary amounts between four supported currency pairs using fixed exchange rates:
 * <ul>
 *     <li>Euro → US Dollar</li>
 *     <li>US Dollar → Euro</li>
 *     <li>Malaysian Ringgit → US Dollar</li>
 *     <li>US Dollar → Malaysian Ringgit</li>
 * </ul>
 *
 * <p>The program:
 * <ul>
 *     <li>Displays a menu of conversion options</li>
 *     <li>Validates user input for both menu choice and amount</li>
 *     <li>Handles invalid input gracefully (e.g., letters, symbols, out-of-range numbers)</li>
 *     <li>Performs the selected currency conversion using fixed rates</li>
 *     <li>Displays results using appropriate currency symbols (€ for Euro, $ for USD, RM for Ringgit)</li>
 *     <li>Asks the user if they want to perform another conversion</li>
 * </ul>
 *
 * <p>The program loops until the user chooses to stop by entering "no" or "n". 
 * It provides a user-friendly and fault-tolerant interface for currency conversion tasks.
 *
 * @author Huilin Reid
 * @author Vixen La Ruk
 * @since 2025-09-10
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Conversion {
    // constants for conversion ratios
    static final double DOLLAR_EURO_RATIO = 0.85; // US Dollar to Euro, quoted on Sep 10, 2025
    static final double DOLLAR_RINGGIT_RATIO = 4.22; // US dollar to Malaysian Ringgit, quoted on Sep 10, 2025

    /** This method converts a given amount in US Dollar to Euro. 
     * 
     *  @param amountInDollar the amount in US Dollar to be converted
     *  @return the equivalent amount in Euro
     */
    public static double dollarToEuro(double amountInDollar) {
        return amountInDollar * DOLLAR_EURO_RATIO;
    }

    /** This method converts a given amount in Euro to US Dollar. 
     *
     *  @param amountInEuro the amount in Euro to be converted
     *  @return the equivalent amount in US Dollar
     */
    public static double euroToDollar(double amountInEuro) {
        return amountInEuro / DOLLAR_EURO_RATIO;
    }

    /** This method converts a given amount in US Dollar to Malaysian Ringgit. 
     * 
     *  @param amountInDollar the amount in US Dollar to be converted
     *  @return the equivalent amount in Malaysian Ringgit
     */
    public static double dollarToRinggit(double amountInDollar) {
        return amountInDollar * DOLLAR_RINGGIT_RATIO;
    }

    /** This method converts a given amount in Malaysian Ringgit to US Dollar. 
     * 
     *  @param amountInRinggit the amount in Malaysian Ringgit to be converted
     *  @return the equivalent amount in US Dollar
     */
    public static double ringgitToDollar(double amountInRinggit) {
        return amountInRinggit / DOLLAR_RINGGIT_RATIO;
    }
 
    /** displays a currency conversion menu to the user with four options. 
     * It then uses the provided Scanner to read the user's numeric choice 
     * and returns that choice as an integer.
     * 
     *  @param sc the Scanner object used to read user input from the console
     *  @return the validated menu choice (user input) as integer
     */
    public static int menu (Scanner sc) {
        int choice = -1;
        
        while (true) {
            System.out.println("\nChoose a conversion option:");
            System.out.println("    1. Euro -> US Dollar");
            System.out.println("    2. US Dollar -> Euro");
            System.out.println("    3. Malaysian Ringgit -> US Dollar");
            System.out.println("    4. US Dollar -> Malaysian Ringgit");
            System.out.print("Your choice: ");

            if (sc.hasNextInt()) { 
                choice = sc.nextInt();
                if (choice >=1 && choice <= 4) {
                    break; // valid input, exit loop
                } else {
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); // consume the invalid input
            }   
        }
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

        boolean keepGoing = true;

        while (keepGoing) {
            // get a valid converion option from the user
            int choice = menu(in);

            // prompt for the amount to convert
            System.out.print("Enter the amount to convert: ");
            
            // validate user input: make sure it's a number
            while (!in.hasNextDouble()) {
                String word = in.next();
                System.err.println(word + " is not a number!");
                System.out.println("Enter a number:");
            }
            double amount = in.nextDouble();

            double result = 0;

            // perform the selected conversion
            switch (choice) {
                case 1:
                    result = euroToDollar(amount);
                    // Euro -> US Dollar
                    System.out.println("\u20AC" + amount + " = " + "\u0024" + df.format(result) + "\n");
                    break;
                case 2:
                    result = dollarToEuro(amount);
                    // US Dollar -> Euro
                    System.out.println("\u0024" + amount + " = " + "\u20AC" + df.format(result) + "\n");
                    break;
                case 3:
                    result = ringgitToDollar(amount);
                    // Malaysian Ringgit -> US Dollar
                    System.out.println("\u0052\u004D" + amount + " = " + "\u0024" + df.format(result) + "\n");
                    break;
                case 4:
                    result = dollarToRinggit(amount);
                    // US Dollar -> Malaysian Ringgit
                    System.out.println("\u0024" + amount + " = " + "\u0052\u004D" + df.format(result) + "\n");
                    break;
            }

            // consume leftover newline after nextDouble()
            in.nextLine();

            System.out.print("Do you want to do another conversion? (yes/no): ");
            String response = in.nextLine().trim().toLowerCase();

            if (response.equals("no") || response.equals("n")) {
                keepGoing = false;
                System.out.println("Thank you for using the currency converter!\n");
            }
        }
        in.close();
    }   
}
