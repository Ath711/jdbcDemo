package org.example;

import java.sql.*;

public class CRUD {

    private static String url = "jdbc:postgresql://localhost:5432/Demo"; // create Demo database in your local or change name with your preferred database name
    private static String username = "postgres";
    private static String password = "enter your password here";

    public static void main(String[] args) {

        String insert  = "insert into student values(4,'GHI',43);";  // this is a sample table with name student
        String read = "select * from student;";
        String update  = "update student set sname = 'GGG' where sid=4";
        String delete = "delete from student where sid=4";
        ResultSet resultSet;

        try(Connection connection= DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement()) {

            System.out.println("initial DB");
            readTable(executeRead(statement));
            System.out.println();

            statement.execute(insert);

            System.out.println("insert into student values(4,'GHI',43);");
            readTable(executeRead(statement));
            System.out.println();

            statement.execute(update);

            System.out.println("update student set sname = 'GGG' where sid=4");
            readTable(executeRead(statement));
            System.out.println();

            statement.execute(delete);

            System.out.println("delete from student where sid=4");
            readTable(executeRead(statement));
            System.out.println();

            //PreparedStatement, used for preventing SQLInjection attack, or to cache a query in DB
            int sid =101;
            String sname = "Max";
            int marks = 44;

            /*
            this won't work as we are writing that in " "
            statement.execute("insert into student values(sid,sname,marks);");
            we can use below code, however its bit complex
            statement.execute("insert into student values(" + sid + ",'" + sname + "'," + marks + ");");
            */

            String sql = "insert into student values (?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,sid);
            preparedStatement.setString(2,sname);
            preparedStatement.setInt(3,marks);
            preparedStatement.execute();
            readTable(executeRead(statement));

        } catch (SQLException e) {
            System.out.println("SQLException " + e);
        }
    }

    private static void readTable(ResultSet resultSet) throws SQLException {
        while(resultSet.next()){
            System.out.print(resultSet.getInt(1) + " ");
            System.out.print(resultSet.getString(2) + " ");
            System.out.println(resultSet.getInt(3));
        }
    }

    private static ResultSet executeRead(Statement statement) throws SQLException {
        return statement.executeQuery("select * from student;");
    }
}
