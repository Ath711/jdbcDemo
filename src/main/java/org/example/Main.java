package org.example;
import java.sql.*;

public class Main {
    private static String url = "jdbc:postgresql://localhost:5432/Demo"; // create Demo database in your local or change name with your preferred database name
    private static String username = "postgres";
    private static String password = "enter your password here";

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet;
        String query = "select marks from student where sid=2;"; // this is a sample table with name student
        String query1 = "select * from student;";

        /*
            1. import the package
            2. load and register
            3. create connection
            4. create statement
            5. execute statement
            6. process the results
            7. close
         */

        // this loading driver is an optional step
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver class not found " + e);
        }

        try {
            //creating connection
            connection = DriverManager.getConnection(url,username,password);

            //creating statements
            statement = connection.createStatement();

            //executing query
            resultSet = statement.executeQuery(query);

            //process the result
            //resultSet.next() returns a boolean value, Moves the cursor forward one row from its current position. If next row present returns true else false
            if (resultSet.next()) {
                System.out.println("Marks for sid=2: " + resultSet.getString("marks"));
                //          we can also add column index System.out.println(resultSet.getString(3));
            }
            System.out.println();


            resultSet = statement.executeQuery(query1);
            while (resultSet.next()){
                System.out.println(resultSet.getInt("sid") + " " + resultSet.getString("sname") + " " + resultSet.getInt("marks"));
            }

        } catch (SQLException e) {
            System.out.println("SQLException " + e);
        }

        finally {
            try {
                connection.close();
                System.out.println("Connection closed");
            } catch (SQLException e) {
                System.out.println("SQLException " + e);
            }
        }


    }
}