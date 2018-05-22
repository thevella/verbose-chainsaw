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
                System.out.print(e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.print(e.getMessage());
        }

    }

    public String GetLocation(String x) {
        URL url = getClass().getResource(x);
        return url.getPath().replaceAll("%20", " ");

    }
}

class Quotes {
    private String author;
    private String quote;
    private String[] tags;

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

    // Variables and methods for sqlDatabase
    // TODO: Needs to be customized for this program

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:" + (new QuotesDatabase().GetLocation("QuotesDatabase.mv.db")
            .substring(0, new QuotesDatabase().GetLocation("QuotesDatabase.mv.db").length() - 1 - 5));
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";

    // H2 SQL Statement Example
    public static void insertQuotes(String value1, String value2, String value3) throws SQLException {
        Connection connection = getDBConnection();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();

            stmt.execute("INSERT INTO QUOTES(AUTHOR, BODY, TAGS) VALUES('" + value1 + "', '" + value2 + "', '" + value3 + "')");

            stmt.close();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public static void insertAuthor(String value1, String value2, String value3) throws SQLException {
        Connection connection = getDBConnection();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();

            stmt.execute("INSERT INTO AUTHORS(AUTHOR, INFO, TAGS) VALUES('" + value1 + "', '" + value2 + "', '" + value3 + "')");

            stmt.close();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public static int getCount (String table) throws SQLException {
        Connection connection = getDBConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();

            rs = stmt.executeQuery("SELECT COUNT(*) FROM " + table);

            stmt.close();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

        rs.next();
        return rs.getInt(1);

    }

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

    private static void resetNumbering(String table) throws SQLException {

        Connection connection = getDBConnection();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();

            stmt.execute("SET  @num = 0");
            stmt.execute("UPDATE " + table + " SET id = @num := (@num+1)");
            stmt.execute("ALTER TABLE " + table + " AUTO_INCREMENT =1");

            stmt.close();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    ////////////////////////////////////////////////////
    ///////////////////////////////////////////////////

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

    public static void main(String[] args) {
        // Taken from stack overflow: https://stackoverflow.com/questions/1611931/catching-ctrlc-in-java
        // Neatens up  output after shutdown. Otherwise when run from terminal next line from terminal
        // is on same line as the user input line when terminated with ctrl-c.
        UserInterfaec aa = new UserInterfaec();

        aa.setVisible(true);

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




    }

}
