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

public class currencyConverter
{
    public static void main(String args[]) {
        // create a Scanner that's going to read from system input on console
        Scanner scan = new Scanner(System.in);

        while(true) {
            try {
                // ask the user to enter the name of the currency
                System.out.println("enter the name of the currency (not USD):");
                String currencyName = scan.next();

                // define the exchange rate as a float
                float exchangeRate;

                // ask the user to input the exchange rate
                System.out.println("enter the exchange rate vs. United States dollar (USD as base):");
                // ensure that the exchange rate is a numerical value
                while (!scan.hasNextFloat()) {
                    System.out.println("please enter a numerical value");
                    scan.next();
                }
                // if not a numerical value, scan for the next input
                exchangeRate = scan.nextFloat();

                // convert from dollars to the input currency and vice versa
                double exchangeRateTwo = (1.0 / exchangeRate);

                // print the exchange rates
                System.out.println("one USD is equal to " + exchangeRate + " " + currencyName);
                System.out.println("AND");
                System.out.println("one " + currencyName + " is equal to " + exchangeRateTwo + " USD");

                // ask the user if they would like to change the currency or exchange rate
                System.out.println("would you like to change the currency or exchange rate? (enter Y or N)");
                String exitCondition = scan.next(); // the sentinel character entry

                // the exit condition, i.e. entry of sentinel character
                if(exitCondition.equals("N")) {
                    System.out.println("program stopped");
                    break;
                }
            } // end try

            catch (Exception ex) {
                ex.printStackTrace(); // error catching
                System.out.println("an error has occurred");
            } // end catch
        }

    } // end main

} // end class