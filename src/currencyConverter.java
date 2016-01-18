/** Copyright (c) 2016, Valentino Constantinou <vc@valentino.io>
 Permission to use, copy, modify, and/or distribute this software for any
 purpose with or without fee is hereby granted, provided that the above
 copyright notice and this permission notice appear in all copies.
 THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

import java.util.Scanner; // import the scanner

public class currencyConverter {

    // define variables to be used globally
    public static float exchangeRate = 0;
    public static String currencyName;


    /**
     * This is the main function that calls the remaining functions: printMenu, enterCurrencyName, enterExchangeRate,
     * performCalculation, and printError.
     * @param args String is passed into the main function.
     */
    public static void main(String args[]) {

        // print welcome message
        System.out.println("Welcome and Go Wildcats!\n");

        // enter some sort of cool console art here just because
        System.out.println("|||    |||||   ||||     ||||");
        System.out.println("||||   |||||   ||||     ||||");
        System.out.println("|||||   ||||   ||||     ||||");
        System.out.println("|| |||   |||   ||||     ||||");
        System.out.println("||  |||   ||   ||||     ||||");
        System.out.println("||   |||  ||   ||||     ||||");
        System.out.println("|||   ||| ||   ||||     ||||");
        System.out.println("||||   |||||   ||||     ||||");
        System.out.println("|||||   ||||   |||||||||||||");
        System.out.println("|||||    |||   |||||||||||||");

        // create a Scanner that's going to read from system input on console
        Scanner scan = new Scanner(System.in);

        while (true) {

            // using the try/catch block to log fatal program errors
            try {

                // print the menu
                printMenu();

                // the controller
                if (scan.hasNext()) {

                    // scan for sentinel character entry
                    if (scan.hasNext("exit")) {

                        System.out.println("program stopped");
                        break;

                    }

                    // scan for other cases
                    else if (scan.hasNextInt()) {

                        // switch between cases
                        switch (scan.nextInt()) {

                            // ask for the name of the currency
                            case 1:
                                enterCurrencyName(scan);
                                break;

                            // ask for the exchange rate
                            case 2:
                                enterExchangeRate(scan);
                                break;

                            // perform the calculation
                            case 3:
                                performCalculation();
                                break;

                            // invalid case
                            default:
                                printError("invalid menu entry");
                                scan.nextLine();
                                break;

                        }

                    }

                    // ensures that the menu does not loop infinitely with invalid entry
                    else {

                        printError("invalid menu entry");
                        scan.nextLine();

                    }

                }

            } // end try

            catch (Exception ex) {

                ex.printStackTrace(); // error catching
                System.out.println("a fatal program error has occurred");

            } // end catch

        } // end while

    } // end main

    /**
     * This function asks the user to specify the currency name.
     * @param scan Scanner is passed into this function.
     */
    public static void enterCurrencyName(Scanner scan) {

        // ask the user to enter the name of the currency
        System.out.println("enter the name of the currency (not USD):");
        currencyName = scan.next();

        // print a 'message of success' to the user
        System.out.println("You entered: " + currencyName);

    } // end function

    /**
     * This function asks the user to specify the currency name.
     * @param scan Scanner is passed into this function.
     */
    public static void enterExchangeRate(Scanner scan) {

        // ask the user to input the exchange rate
        System.out.println("enter the exchange rate vs. United States dollar (USD as base):");

        // ensure that the exchange rate is a numerical value
        while (!scan.hasNextFloat()) {

            System.out.println("please enter a numerical value");
            scan.next();

        }

        // if not a numerical value, scan for the next input
        exchangeRate = scan.nextFloat();

        // print a 'message of success' to the user
        System.out.println("You entered: " + exchangeRate);

    } // end function

     /**
     * This function performs the calculation after the user has specified the currency name and exchange rate.
     */
      public static void performCalculation() {

          // check to see if currencyName and exchangeRate have been user-defined
          while (true) {

              // check to see if the currencyName and/or exchangeRate have been user-defined
              if (currencyName == null || exchangeRate == 0) {

                  printError("Please define the currency name and/or exchange rate prior to using option 3");
                  break;

              }

              // if the currencyName and exchangeRate are defined, perform calculation
              else if (exchangeRate != 0) {

                  // convert from dollars to the input currency and vice versa
                  double exchangeRateTwo = (1.0 / currencyConverter.exchangeRate);

                  // print the exchange rates
                  System.out.println("one USD is equal to " + exchangeRate + " " + currencyName);
                  System.out.println("AND");
                  System.out.println("one " + currencyName + " is equal to " + exchangeRateTwo + " USD");
                  break;

              }

          }

    } // end function

     /**
     * This function prints the console menu.
     */
    public static void printMenu() {

        System.out.println("\nPlease select an option below (i.e. enter 1, 2, or 3):");
        System.out.println("--------------------------------");
        System.out.println("1: Enter the name of the currency");
        System.out.println("2: Enter the exchange rate");
        System.out.println("3: Calculate the exchange rates");
        System.out.println("--------------------------------");
        System.out.println("Type 'exit' to stop the program at any time");

    } // end function

     /**
     * This function is used for printing errors.
     */
    public static void printError(String s) {

        System.out.println("\nError: " + s);

    } // end function

} // end currencyConverter class