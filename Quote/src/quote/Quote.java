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

// Junk class for using functions in a static/non-static
// context that are the opposite
class QuotesDatabase {

    // Default constructor just for grabbing an instance
    // of this class to be used in another class
    public QuotesDatabase() {

    }

    // Get location function for finding any file
    // in the path from any computer for maximum
    // cross compatability.
    public String GetLocation(String x) {
        URL url = getClass().getResource(x);
        return url.getPath().replaceAll("%20", " ");

    }
}

// Exception thrown when the value is not an expected value in user input.
class NegNumber extends Exception {
    public NegNumber(String s) {
        super(s);
    }
}

// Default class
public class Quote {

    // Variables and methods for sqlDatabase

    // Grabbing the databse driver
    private final String DB_DRIVER = "org.h2.Driver";

    // String that tells the driver the type and location of the
    // file to be accessed
    private final String DB_CONNECTION = "jdbc:h2:" + (new QuotesDatabase().GetLocation("QuotesDatabase.mv.db")
            .substring(0, new QuotesDatabase().GetLocation("QuotesDatabase.mv.db").length() - 1 - 5));

    // The database user and password,
    // is only the default user
    private final String DB_USER = "sa";
    private final String DB_PASSWORD = "";

    // SQL method for inserting a quote into the quote table
    // takes the | Author | Body of quote | tags of quote |
    // all as strings, returns nothing.
    public void insertQuotes(String value1, String value2, String value3) throws SQLException {
        // Grabs connection and creates statement as null
        Connection connection = getDBConnection();
        Statement stmt = null;
        try {
            // Resets the id numbering in the table
            // for easier manual editing in the H2.jar
            // program
            resetNumbering("QUOTES");

            connection.setAutoCommit(false);
            stmt = connection.createStatement();

            // Checks each value entered for whether they contain damaging
            // SQL statements by checking against multiple regexes in the
            // isValid() method. If they could damage, throws error
            // and exits
            if (isValid(value1) || isValid(value2) || isValid(value3)) {
                throw new NegNumber("The string contains a valid SQL damaging statement");
            }

            // Actual statement that creates the quote in the document
            stmt.execute("INSERT INTO QUOTES(AUTHOR, BODY, TAGS) VALUES('" + value1 + "', '" + value2 + "', '" + value3
                    + "')");

            // closes the statement and the database connection after
            // successful completion
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

    // SQL method for inserting an author into the author table
    // takes the | Author | Info | tags of author |
    // all as strings, returns nothing.
    public void insertAuthor(String value1, String value2, String value3) throws SQLException {
        // Grabs connection and creates statement as null
        Connection connection = getDBConnection();
        Statement stmt = null;

        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();

            // Checks each value entered for whether they contain damaging
            // SQL statements by checking against multiple regexes in the
            // isValid() method. If they could damage, throws error
            // and exits
            if (isValid(value1) || isValid(value2) || isValid(value3)) {
                throw new NegNumber("The string contains a valid SQL damaging statement");
            }

            // Actual statement that creates the author in the document
            stmt.execute("INSERT INTO AUTHORS(AUTHOR, INFO, TAGS) VALUES('" + value1 + "', '" + value2 + "', '" + value3
                    + "')");

            // closes the statement and the database connection after
            // successful completion
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

    // Method for removing author from author database by any of
    // three types, by author, by info, or by tags
    // Only three types for later implementation
    public void removeAuthor(String deleteTerm, int typeInt) throws SQLException {
        // Grabs connection and creates statement as null
        Connection connection = getDBConnection();
        Statement stmt = null;
        String type = "";

        // Decides what type the deletion is by
        if (typeInt == 1) {
            type = "AUTHOR";
        } else if (typeInt == 2) {
            type = "INFO";
        } else if (typeInt == 3) {
            type = "TAGS";
        }

        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();

            // Checks the value entered for whether they contain damaging
            // SQL statements by checking against multiple regexes in the
            // isValid() method. If it could damage, throws error
            // and exits
            if (isValid(deleteTerm)) {
                throw new NegNumber("The string contains a valid SQL damaging statement");
            }

            // Actual statement that removes the author from the document
            stmt.execute("DELETE FROM AUTHORS WHERE " + type + "='" + deleteTerm + "'");

            // close statement and connection after sucessful
            // execution
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

    // Method for removing quote from quote database by any of
    // four types, by id, by author, by body, or by tags
    // Only four types for later implementation
    public void removeQuote(String deleteTerm, int typeInt) throws SQLException {
        // Grabs connection and creates statement as null
        Connection connection = getDBConnection();
        Statement stmt = null;
        String type = "";

        // Decides what type the deletion is by
        if (typeInt == 1) {
            type = "ID";
        } else if (typeInt == 2) {
            type = "AUTHOR";
        } else if (typeInt == 3) {
            type = "BODY";
        } else if (typeInt == 4) {
            type = "TAGS";
        }

        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();

            // Checks the value entered for whether they contain damaging
            // SQL statements by checking against multiple regexes in the
            // isValid() method. If it could damage, throws error
            // and exits
            if (isValid(deleteTerm)) {
                throw new NegNumber("The string contains a valid SQL damaging statement");
            }

            // Actual statement that removes the quote from the document
            stmt.execute("DELETE FROM QUOTES WHERE " + type + "='" + deleteTerm + "'");

            // close statement and connection after sucessful
            // execution
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

    // Method for returning the number of entries
    // in a table. Could be changed to count
    // the number of any type
    // UNIMPLIMENTED
    public int getCount(String table) throws SQLException {
        // Grabs connection and creates statement as null
        Connection connection = getDBConnection();
        Statement stmt = null;
        ResultSet rs = null;
        int returnVal = 0;

        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();

            // Grabs count of all rows from table
            rs = stmt.executeQuery("SELECT COUNT(*) FROM " + table);

            // clears the null value at top of table
            rs.next();

            // sets returnVal equal to the first value in the
            // first row of the rs set
            returnVal = rs.getInt(1);

            stmt.close();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }


        // returns the number of rows
        return returnVal;

    }

    // Function to return true if the value passed
    // could damage the database
    public boolean isValid(String term) {

        // Splits by ; since that is the sql line ending
        // and could be used to make a single statement
        // into multiple statements
        String[] splitTerms = term.split(";");

        for (String x : splitTerms) {
            // Checks if it means to alter, drop, or truncate
            // table
            if (x.matches(
                    "^\\s*[[D|d][R|r][O|o][P|p]|[A|a][L|l][T|t][E|e][R|r]|[T|t][R|r][U|u][N|n][C|c][A|a][T|t][E|e]]\\s+?[T|t][A|a][B|b][L|l][E|e]\\s+?[[Q|q][U|u][O|o][T|t][E|e][S|s]|[A|a][U|u][T|t][H|h][O|o][R|r][S|s]]")) {
                return true;

            // if it means to select or delete from table
            } else if (x.matches(
                    "^\\s*[[S|s][E|e][L|e][E|e][C|c][T|t]|[D|e][L|l][E|e][T|t][E|e]]\\s+?.+?\\s+?[F|f][R|r][O|o][M|m][\\s+?[[Q|q][U|u][O|o][T|t][E|e][S|s]|[A|a][U|u][T|t][H|h][O|o][R|r][S|s]]|]")) {
                return true;

            // if it means to drop database
            } else if (x.matches("^\\s*[D|d][R|r][O|o][P|p]\\s+?[D|d][A|a][T|t][A|a][B|b][A|a][S|s][E|e]")) {
                return true;

            // if it means to create, alias, agregate, or index a table
            } else if (x.matches(
                    "^\\s*[C|c][R|r][E|e][A|a][T|t][E|e]\\s+?[[A|a][L|l][I|i][A|a][S|s]|[A|a][G|g][G|g][R|r][E|e][G|g][A|a][T|t][E|e]|[I|i][N|n][D|e][X|x]|[T|t][A|a][B|b][L|l][E|e]|[U|u][S|s][E|e][R|r]]")) {
                return true;

            // if it means to add an or condition to
            // get all values in the table

            // kinda useless since they could just put an "a"
            // or a null query to get everything, but just for
            // proof of concept at moment
            } else if (x.matches(".*?[O|o][R|r]\\s+?(.+?)\\s*?\\=\\s*?\\1.*?")) {
                return true;
            } else if (x
                    .matches(".*?[O|o][R|r]\\s+?(-+|)\\s*?\\d+\\s*?(\\=|\\<\\=|\\>\\=|\\>|\\<)\\s*?(-+|)\\s*?\\d+.*?")) {
                return true;
            }
        }

        // if it passes, return false
        return false;
    }

    // Search exactly for a phrase instead of
    // searching for something that just looks like it
    public ResultSet searchExact(int tables, String searchTerm, int type, Connection connection, Statement stmt)
            throws SQLException {

        // Set resultSet, database connection is passed, along
        // with statement due to the resultset needing to be
        // used at the other side
        ResultSet rs = null;
        String table = "";

        // what table to select from
        if (tables == 1) {
            table = "AUTHORS";
        } else {
            table = "QUOTES";
        }

        try {
            connection.setAutoCommit(false);

            // Check if valid sql
            if (isValid(searchTerm)) {
                throw new NegNumber("The string contains a valid SQL damaging statement");
            }

            // Check what type of search it is, and do that type
            // Different types are required since they require different amounts
            // of escaping and accuracy
            if (type == 1) {
                rs = stmt.executeQuery("SELECT * FROM " + table + " WHERE ID=" + searchTerm + " ORDER BY AUTHOR");
            } else if (type == 2) {
                rs = stmt.executeQuery("SELECT * FROM " + table + " WHERE AUTHOR='" + searchTerm + "' ORDER BY AUTHOR");
            } else if (type == 3) {
                rs = stmt.executeQuery("SELECT * FROM " + table + " WHERE BODY='" + searchTerm + "' ORDER BY AUTHOR");
            } else if (type == 4) {
                rs = stmt.executeQuery("SELECT * FROM " + table + " WHERE TAGS like '% " + searchTerm + " %' ORDER BY AUTHOR");
            } else if (type == 5) {
                rs = stmt.executeQuery("SELECT * FROM " + table + " WHERE INFO='" + searchTerm + "' ORDER BY AUTHOR");
            }

            connection.commit();
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // return the result set with the data in it
        return rs;
    }

    // Same as return exact except with more rough
    // An example is that in this 'bill' would return
    // 'billy', 'arbilly' and any other configuration with
    // the consecutive letters 'bill' in their order.
    public ResultSet searchRough(int tables, String searchTerm, int type, Connection connection, Statement stmt)
            throws SQLException {

        ResultSet rs = null;
        String table = "";

        if (tables == 1) {
            table = "AUTHORS";
        } else {
            table = "QUOTES";
        }

        try {
            connection.setAutoCommit(false);

            if (isValid(searchTerm)) {
                throw new NegNumber("The string contains a valid SQL damaging statement");
            }

            if (type == 1) {
                rs = stmt.executeQuery(
                        "SELECT * FROM " + table + " WHERE ID like '%" + searchTerm.trim() + "%' ORDER BY AUTHOR");
            } else if (type == 2) {
                rs = stmt.executeQuery(
                        "SELECT * FROM " + table + " WHERE AUTHOR like '%" + searchTerm.trim() + "%' ORDER BY AUTHOR");
            } else if (type == 3) {
                rs = stmt.executeQuery(
                        "SELECT * FROM " + table + " WHERE BODY like '%" + searchTerm.trim() + "%' ORDER BY AUTHOR");
            } else if (type == 4) {
                rs = stmt.executeQuery(
                        "SELECT * FROM " + table + " WHERE TAGS like '%" + searchTerm.trim() + "%' ORDER BY AUTHOR");
            } else if (type == 5) {
                rs = stmt.executeQuery(
                        "SELECT * FROM " + table + " WHERE INFO like '%" + searchTerm.trim() + "%' ORDER BY AUTHOR");
            }

            connection.commit();
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }

    // method provided by h2 to grab the database connection
    public Connection getDBConnection() {
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

    // Functino to reset the numbering in the table
    // so that a added quote doesn't have the number
    // like '1000' when their are only 100 quotes
    // due to deletions
    public void resetNumbering(String table) throws SQLException {

        Connection connection = getDBConnection();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();

            // Sets a variable to 0
            stmt.execute("SET  @num = 0");
            // Set the id column to the variable '0', which is
            // increased by 1 each time
            stmt.execute("UPDATE " + table + " SET id = @num := (@num+1)");
            // then auto uncrement is set back on at 1
            stmt.execute("ALTER TABLE " + table + " AUTO_INCREMENT =1");

            stmt.close();
            connection.commit();
        } catch (SQLException e) {
            //System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            //e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    ////////////////////////////////////////////////////
    ///////////////////////////////////////////////////



    public static void main(String[] args) {
        // Taken from stack overflow: https://stackoverflow.com/questions/1611931/catching-ctrlc-in-java
        // Neatens up  output after shutdown. Otherwise when run from terminal next line from terminal
        // is on same line as the user input line when terminated with ctrl-c.
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                try {
                    Thread.sleep(200);
                    System.out.print("\n");
                    //some cleaning up code...

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // runs the user interface and sets to visible.
        // exits when this closes
        UserInterfaec aa = new UserInterfaec();

        aa.setVisible(true);



    }

}
