package jdbctests;

import org.junit.jupiter.api.Test;

import java.sql.*;


public class jdbc_examples {


    String dbUrl="jdbc:oracle:thin:@54.209.8.165:1521:XE";
    String dbUsername="hr";
    String dbPassword="hr";

    @Test
    public void test1() throws SQLException {

        Connection connection= DriverManager.getConnection(dbUrl,dbPassword,dbUsername);
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("SELECT * FROM departments");

        while (resultSet.next()){

            System.out.println(resultSet.getInt(1)+" - "+ resultSet.getString(2)+" - "+ resultSet.getInt(3)+ " - "+ resultSet.getInt(4));
        }


        resultSet.close();
        statement.close();
        connection.close();

    }

    @Test
    public void test2(){


    }


}
