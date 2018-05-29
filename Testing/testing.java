import org.h2.tools.DeleteDbFiles;
import org.h2.Driver;
import java.util.concurrent.TimeUnit;

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

class testHelper {
    public String[] openL = {"Great", "Gay", "Joyous", "Lucky", "Fortunate", "Delighted", "Overjoyed", "Gleeful", "Thankful", "Important", "Festive", "Ecstatic", "Satisfied", "Glad", "Cheerful", "Sunny", "Merry", "Elated", "Jubilant"};

    public String[] aliveL = {"Playful", "Courageous", "Energetic", "Liberated", "Optimistic", "Provocative", "Impulsive", "Free", "Frisky", "Animated", "Spirited", "Thrilled", "Wonderful"};

    public String[] goodL = {"Calm", "Peaceful", "At Ease", "Comfortable", "Pleased", "Encouraged", "Clever", "Surprised", "Content", "Quiet", "Certain", "Relaxed", "Serene", "Free and Easy", "Bright", "Blessed", "Reassured"};

    public String[] loveL = {"Loving", "Considerate", "Affectionate", "Sensitive", "Tender", "Devoted", "Attracted", "Passionate", "Admiration", "Warm", "Touched", "Sympathy", "Close", "Loved", "Comforted", "Drawn Towards"};

    public String[] interestedL = {"Concerned", "Affected", "Fascinated", "Intrigued", "Absorbed", "Inquisitive", "Nosy", "Snoopy", "Engrossed", "Curious"};

    public String[] positiveL = {"Eager Keen", "Earnest Intent", "Anxious Inspired", "Determined Excited", "Enthusiastic Bold", "Brave Daring", "Challenged Optimistic", "Re - Enforced", "Confident Hopeful"};

    public String[] strongL = {"Impulsive", "Free", "Sure", "Certain", "Rebellious", "Unique", "Dynamic", "Tenacious", "Hardy", "Secure"};

    public String[] angryL = {"Irritated", "Enraged", "Hostile", "Insulting", "Sore", "Annoyed", "Upset", "Hateful", "Unpleasant", "Offensive", "Bitter", "Aggressive", "Resentful", "Inflamed", "Provoked", "Incensed", "Infuriated", "Cross", "Working Up", "Boiling", "Fuming", "Indignant"};

    public String[] depressedL = {"Lousy", "Disappoinnted", "Discouraged", "Ashamed", "Powerless", "Diminished", "Gulity", "Dissatisfied", "Miserable", "Detestable", "Repugnant", "Dispicable", "Disgusting", "Abominable", "Terrible", "In Despair", "Sulky", "Bad", "A Sense of Loss"};

    public String[] confusedL = {"Upset", "Doubtful", "Uncertain", "Indecisive", "Perplexed", "Embarrassed", "Hesitant", "Shy", "Stupefied", "Disillusioned", "Unbelieving", "Skeptical", "Distrustful", "Misgiving", "Lost", "Unsure", "Uneasy", "Pessemistic", "Tense"};

    public String[] helplessL = {"Incapable", "Alone", "Paralyzed", "Fatigued", "Useless", "Inferior", "Vulnerable", "Empty", "Forced", "Hesitant", "Dispair", "Frustrated", "Distressed", "Woeful", "Pathetic", "Tragic", "In A Stew", "Dominated"};

    public String[] indifferentL = {"Insensitive", "Dull", "Nonchalant", "Neutral", "Reserved", "Weary", "Bored", "Preoccupied", "Cold", "Disinterested", "Lifeless"};

    public String[] afraidL = {"Fearful", "Terrified", "Suspicious", "Anxious", "Alarmed", "Panic", "Nervous", "Scared", "Worried", "Frightened", "Timid", "Shaky", "Restless", "Doubtful", "Threatened", "Cowardly", "Quaking", "Menaced", "Wary"};

    public String[] hurtL = {"Crushed", "Tormented", "Deprived", "Pained", "Tortured", "Dejected", "Rejected", "Injured", "Offended", "Afflicted", "Aching", "Victimized", "Heartbroken", "Agonized", "Appalled", "Humiliated", "Wronged", "Alienated"};

    public String[] sadL = {"Tearful", "Sorrowful", "Pained", "Grief", "Anguish", "Desolate", "Desperate", "Pessimistic", "Unhappy", "Lonely", "Grieved", "Mournful", "Dismayed"};

    public testHelper () {

    }
}

public class testing {

    // Variables and methods for sqlDatabase
    // TODO: Needs to be customized for this program

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:./QuotesDatabase";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";

    private static testHelper helper = new testHelper();



    private static ArrayList<String> retTags (String searchBody) {
        ArrayList<String> tags = new ArrayList<String>();

        for (String x : helper.openL) {
            if (searchBody.toUpperCase().contains(x.toUpperCase())) {
                tags.add("Open");
            }
        }

        for (String x : helper.sadL) {
            if (searchBody.toUpperCase().contains(x.toUpperCase())) {
                tags.add("Sad");
            }
        }

        for (String x : helper.aliveL) {
            if (searchBody.toUpperCase().contains(x.toUpperCase())) {
                tags.add("Alive");
            }
        }

        for (String x : helper.goodL) {
            if (searchBody.toUpperCase().contains(x.toUpperCase())) {
                tags.add("Good");
            }
        }

        for (String x : helper.loveL) {
            if (searchBody.toUpperCase().contains(x.toUpperCase())) {
                tags.add("Love");
            }
        }

        for (String x : helper.interestedL) {
            if (searchBody.toUpperCase().contains(x.toUpperCase())) {
                tags.add("Interested");
            }
        }

        for (String x : helper.positiveL) {
            if (searchBody.toUpperCase().contains(x.toUpperCase())) {
                tags.add("Positive");
            }
        }

        for (String x : helper.strongL) {
            if (searchBody.toUpperCase().contains(x.toUpperCase())) {
                tags.add("Strong");
            }
        }

        for (String x : helper.angryL) {
            if (searchBody.toUpperCase().contains(x.toUpperCase())) {
                tags.add("Angry");
            }
        }

        for (String x : helper.depressedL) {
            if (searchBody.toUpperCase().contains(x.toUpperCase())) {
                tags.add("Depressed");
            }
        }

        for (String x : helper.confusedL) {
            if (searchBody.toUpperCase().contains(x.toUpperCase())) {
                tags.add("Confused");
            }
        }

        for (String x : helper.helplessL) {
            if (searchBody.toUpperCase().contains(x.toUpperCase())) {
                tags.add("Helpless");
            }
        }

        for (String x : helper.indifferentL) {
            if (searchBody.toUpperCase().contains(x.toUpperCase())) {
                tags.add("Indifferent");
            }
        }

        for (String x : helper.afraidL) {
            if (searchBody.toUpperCase().contains(x.toUpperCase())) {
                tags.add("Afraid");
            }
        }

        for (String x : helper.hurtL) {
            if (searchBody.toUpperCase().contains(x.toUpperCase())) {
                tags.add("Hurt");
            }
        }

        return tags;
    }


    // H2 SQL Statement Example
    private static void insertQuotes(String value1, String value2, String value3) throws SQLException {
        Connection connection = getDBConnection();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();

            stmt.execute("INSERT INTO QUOTES(AUTHOR, BODY, TAGS) VALUES('" + value1 + "', '" + value2 + "', '" + value3
                    + "')");

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

    private static void insertAuthor(String value1, String value2, String value3) throws SQLException {
        Connection connection = getDBConnection();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();

            stmt.execute("INSERT INTO AUTHORS(AUTHOR, INFO, TAGS) VALUES('" + value1 + "', '" + value2 + "', '" + value3
                    + "')");

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

    private static String refactorTagsAuthor (String curTags, ArrayList<String> addTags) {
        String[] curTagsArr = curTags.split("\n");
        String newTags = "";

        ArrayList<String> newTagsList = new ArrayList<String>();

        for (String x : curTagsArr) {
            if (!x.equals("\n")) {
                newTagsList.add(x.trim());
            }

        }

        for (String x : addTags.toArray(new String[addTags.size()])) {
            if (!newTagsList.contains(x)) {
                newTagsList.add(x);
            }
        }

        String[] newTagsArr = newTagsList.toArray(new String[newTagsList.size()]);
        Arrays.sort(newTagsArr);

        for (String x : newTagsArr) {
            newTags += " " + x + " \n";
        }

        return " " + newTags.trim() + " ";
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

    private static boolean tagsInAuthors (ArrayList<String[]> turnover, String searching) {
        for (String[] x : turnover.toArray(new String[turnover.size()][2])) {
            if (x[1].toUpperCase().contains(" " + searching.toUpperCase() + " ")) {
                return true;
            }
        }
        return false;
    }

    private static boolean authorInAuthors (ArrayList<String[]> turnover, String searching) {
        for (String[] x : turnover.toArray(new String[turnover.size()][2])) {
            if (x[0].equalsIgnoreCase(searching)) {
                return true;
            }
        }
        return false;
    }

    private static int indexAuthorInAuthors (ArrayList<String[]> turnover, String searching) {
        int counter = 0;
        for (String[] x : turnover.toArray(new String[turnover.size()][2])) {
            if (x[0].equalsIgnoreCase(searching)) {
                return counter;
            }
            counter += 1;
        }
        return counter;
    }

    /*private String GetLocation(String x) {
        URL url = getClass().getResource(x);
        return url.getPath().replaceAll("%20", " ");

    }*/

    public static void main(String[] args) throws SQLException, InterruptedException {
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




        Connection connection = getDBConnection();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();

            stmt.execute("ALTER TABLE quotes MODIFY COLUMN ID INT(10) UNSIGNED");
            stmt.execute("COMMIT");
            stmt.execute("ALTER TABLE quotes MODIFY COLUMN ID INT(10) UNSIGNED AUTO_INCREMENT");
            stmt.execute("COMMIT");

            stmt.close();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

        ArrayList<String[]> authors = new ArrayList<String[]>();

        boolean found = false;

        String currentTags = "";

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
                        String author = line.trim().substring(seperator.length()).trim();

                        if (!authorInAuthors(authors, author)) {
                            authors.add(new String[] {author, refactorTagsAuthor("", retTags(temper.trim()))});
                        } else {
                            authors.set(indexAuthorInAuthors(authors, author), new String[] {line.trim().substring(seperator.length()).trim(), refactorTagsAuthor(authors.get(indexAuthorInAuthors(authors, author))[1] , retTags(temper.trim()))});
                        }

                        try {
                            insertQuotes(author.replaceAll("'", "''"), temper.trim().replaceAll("'", "''"), refactorTagsAuthor("", retTags(temper.trim())));
                        } catch (SQLException e) {
                            //e.getMessage();
                        }

                        temper = "";

                    } else if (!line.matches("\n")) {
                        //print (line);
                        //TimeUnit.SECONDS.sleep(5);
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

        String[][] authorsNew = authors.toArray(new String[authors.size()][2]);

        // found at http://www.finesrc.com/2018/04/05/sorting-2d-array-to-row-and-column-wise-in-java/
        // and modified for strings May 24th
        Arrays.sort(authorsNew, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
                                //get the item ids which are at index 0 of the array
				String itemIdOne = o1[0];
				String itemIdTwo = o2[0];
				// sort on item id
				return itemIdOne.compareTo(itemIdTwo);
			}
		});

        ArrayList<String[]> authorInfo = new ArrayList<String[]>();
        try {
            // quotes file from: https://gist.github.com/erickedji/68802
            BufferedReader fileOpen = new BufferedReader(new FileReader("authorInfo.txt"));
            // line initiated as null
            String line = null;

            // temp string and int for while loop
            String temper = "";

            try {

                while ((line = fileOpen.readLine()) != null) {

                    // add the line to the last element
                    // in the arraylist
                    // if the line containes a "--",
                    // add a new arraylist element
                    if (line.contains(seperator)) {

                        String author = line.trim().substring(seperator.length()).trim();

                        if (!authorInAuthors(authorInfo, author)) {
                            temper = temper.trim();


                            boolean continues = true;

                            int count = 1;
                            while (continues && temper.contains(" ")){
                                continues = false;
                                //count = 0;
                                for (int x = 0; x < temper.length(); x ++){
                                    if (!String.valueOf(temper.charAt(x)).matches("\n") && (x % 73 == 0) && x != 0 && x == 73* count) {
                                        count ++;
                                        String tempStore = temper.substring(0,x);
                                        int location = tempStore.lastIndexOf(" ");

                                        if (location == -1) {
                                            continues = false;
                                            //print(tempStore + "\n");
                                            continue;
                                        }


                                        temper = temper.substring(0, location) + "\n" + temper.substring(location+1);
                                        continues = true;
                                        break;
                                    }


                                }

                            }


                            temper = temper.trim();

                            authorInfo.add(new String[] {author, temper.trim()});
                        }


                        temper = "";

                    } else if (!line.matches("\n")) {
                        //print (line);
                        //TimeUnit.SECONDS.sleep(5);
                        temper += line;
                    }

                }
                fileOpen.close();
            } catch (IOException e) {
                System.out.print(e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.print(e.getMessage());
        }

        //Arrays.sort(authorsNew);
        for (String[] x : authorsNew) {
            try {
                String info = "";
                if (authorInAuthors(authorInfo, x[0])) {
                    info = authorInfo.get(indexAuthorInAuthors(authorInfo, x[0]))[1];
                }

                insertAuthor(x[0].replaceAll("'", "''"), info.replaceAll("'", "''"), x[1].replaceAll("'", "''"));
            } catch (SQLException e) {
                e.getMessage();
            }

        }

    }

}
