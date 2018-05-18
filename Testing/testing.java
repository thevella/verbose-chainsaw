import org.h2.tools.DeleteDbFiles;
import org.h2.Driver;

import java.io.*;
import java.util.*;
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



public class testing {

    // Variables and methods for sqlDatabase
    // TODO: Needs to be customized for this program

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:./QuotesDatabase";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";

    // H2 SQL Statement Example
    private static void insertQuotes(String value1, String value2, String value3) throws SQLException {
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

    private static void insertAuthor(String value1, String value2, String value3) throws SQLException {
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

    /*private String GetLocation(String x) {
        URL url = getClass().getResource(x);
        return url.getPath().replaceAll("%20", " ");

    }*/

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

        ArrayList<String> authors = new ArrayList<String>();
        
        String seperator = "--";

        try {
            // quotes file from: https://gist.github.com/erickedji/68802
            BufferedReader fileOpen = new BufferedReader(new FileReader("quotes.txt"));
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

                        if (!authors.contains(line.trim().substring(seperator.length()).trim())) {
                            authors.add(line.trim().substring(seperator.length()).trim());
                        }

                        try {
                            insertQuotes(line.trim().substring(seperator.length()).trim(), temper, "");
                        } catch (SQLException e) {
                            e.getMessage();
                        }

                        temper = "";

                    } else if (!line.equals("\n")) {
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

        String[] authorsNew = authors.toArray(new String[authors.size()]);
        Arrays.sort(authorsNew);
        for (String x : authorsNew) {
            try {
                insertAuthor(x, "", "");
            } catch (SQLException e) {
                e.getMessage();
            }

        }


    }


}
