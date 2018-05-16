/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quote;

import org.h2.tools.DeleteDbFiles;

import java.io.*;
import java.lang.Math;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

class QuotesDatabase {

    private ArrayList<Quotes> quotesArr = new ArrayList<Quotes>();

    public QuotesDatabase() {

    }

    public QuotesDatabase(String file, String seperator) {
        Ui aa=new Ui();


        try {
            // quotes file from: https://gist.github.com/erickedji/68802
            BufferedReader fileOpen = new BufferedReader(new FileReader(GetLocation(file)));
            // line initiated as null
            String line = null;

            // temp string and int for while loop
            String temper = null;


            try {

                while ((line = fileOpen.readLine()) != null) {

                    // add the line to the last element
                    // in the arraylist
                    // if the line containes a "--",
                    // add a new arraylist element
                    if (line.contains(seperator)) {
                        quotesArr.add(new Quotes(temper, line.substring(seperator.length() - 1).trim()));
                        temper = "";

                    } else {
                        temper += line + "\n";
                    }

                }
                fileOpen.close();
            } catch (IOException e) {
                System.out.print (e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.print (e.getMessage());
        }



    }

    private String GetLocation(String x) {
        URL url = getClass().getResource(x);
        return url.getPath().replaceAll("%20", " ");

    }
}

class Quotes {
    private String author;
    private String quote;
    private String[] tags;
    private String Loc;





    public Quotes(String author, String quote) {
        this.author = author;
        this.quote = quote;
    }

    public String retAuthor() {
        return author;
    }

    public String retQuote() {
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
<<<<<<< HEAD
=======









>>>>>>> 178b1400facefc46adf6ab012869ecb4693e635c


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

        QuotesDatabase files = new QuotesDatabase("quotes.txt", "--");

        // Value used to store user input
        Double input1;

        // Scanner for getting user input for the year
        Scanner reader = new Scanner(System.in);
        while (true) {
            // Try block so that if a user inputs a letter
            // the code accounts for this
            try {
                print("Enter a double: ");
                input1 = Double.valueOf(reader.nextLine());

                // If the value is one that cannot be worked with, throw exception
                if ((input1 == 1) || (input1 == 0)) {
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
