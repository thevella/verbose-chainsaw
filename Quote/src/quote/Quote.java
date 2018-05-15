/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quote;

/**
 *
 * @author Coles Laptop
 */

import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.Math;
import java.io.*;

class QuotesDatabase {

    ArrayList<Quote> quotes = new ArrayList<Quote>();

    public QuotesDatabase () {

    }

    public QuotesDatabase () {

    }
}

class Quote {
    private String author;
    private String quote;
    private String[] tags;

    public Quote (String author, String quote) {
        this.author = author;
        this.quote = quote;
    }

    public String retAuthor () {
        return author;
    }

    public String retQuote () {
        return quote;
    }
}

// Exception thrown when the value is not an expected value in user input.
class NegNumber extends Exception {
    public NegNumber(String s) {
        super(s);
    }
}

public class Quote {
    static void print(String stringer) {
        // Just a function to simplify output
        System.out.print(stringer);
    }

    // String to hold os value
    private static String OS = null;

    // return the os value
    public static String getOsName() {
        if (OS == null) {
            OS = System.getProperty("os.name");
        }
        return OS;
    }

    // Return true if windows
    public static boolean isWindows() {
        return getOsName().startsWith("Windows");
    }

    // return true if linux
    public static boolean isUnix() {
        return getOsName().startsWith("Linux");
    }

    // function to clear screen
    static void clearScreen() {
        // try block to stop all exceptions
        // so that errors do not cause problems
        try {
            // Get runtime
            java.lang.Runtime rt = java.lang.Runtime.getRuntime();

            // Start a new process:
            // if unix, use the clear command
            // if windows, use the cls command
            // otherwise do not create a command
            if (isUnix()) {
                java.lang.Process p = rt.exec("clear");
                p.waitFor();
                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

                String line = "";
                while ((line = reader.readLine()) != null) {
                    print(line);
                }
            } else if (isWindows()) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                ;
            }
        } catch (Exception e) {
            ;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Taken from stack overflow: https://stackoverflow.com/questions/1611931/catching-ctrlc-in-java
        // Neatens up  output after shutdown. Otherwise when run from terminal next line from terminal
        // is on same line as the user input line when terminated with ctrl-c.
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                try {
                    Thread.sleep(200);
                    print("\n");
                    //some cleaning up code...

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // quotes file from: https://gist.github.com/erickedji/68802
        BufferedReader file = new BufferedReader(new FileReader("quotes.txt"));

        // Value used to store user input
        String input1;

        // Scanner for getting user input for the year
        Scanner reader = new Scanner(System.in);
        while (true) {
            // Try block so that if a user inputs a letter
            // the code accounts for this
            try {
                print("Enter a double: ");
                input1 = Double.valueOf(reader.nextLine());
                print("Enter another double: ");
                input2 = Double.valueOf(reader.nextLine());
                // If the value is one that cannot be worked with, throw exception
                if ((input1 == 1) || (input1 == 0) || (input2 == 1) || (input2 == 0)) {
                    throw new NegNumber(
                            "The number entered was either a 1 or a zero, please enter a number that can be worked with properly.");
                }
                // If successful, exit
                break;
                // If the user inputs a number that is not an integer
            } catch (InputMismatchException e) {
                print("\n" + "A letter or a symbol please enter a double." + "\n");
                // Clear the input so that the code isn't stuck in an infinite loop with same error
                reader.next();
                continue;
                // If the user inputs a number that is not an integer
            } catch (NumberFormatException e) {
                print("\n" + "A letter or a symbol please enter an integer." + "\n");
                // Clear the input so that the code isn't stuck in an infinite loop with same error
                continue;
                // If the number entered is less than the minimum number
            } catch (NegNumber ex) {
                print("\n" + ex.getMessage() + "\n");
                continue;
            }
        }
        // Closes the reader
        reader.close();
    }

}
