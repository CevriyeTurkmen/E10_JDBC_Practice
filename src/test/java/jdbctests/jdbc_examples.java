package jdbctests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.*;


public class jdbc_examples {


    String dbUrl="jdbc:oracle:thin:@54.209.8.165:1521:XE";
    String dbUsername="hr";
    String dbPassword="hr";

    @DisplayName("Result.Set methods")
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
    public void test2() throws SQLException {
        Connection connection= DriverManager.getConnection(dbUrl,dbPassword,dbUsername);
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet=statement.executeQuery("SELECT * FROM departments");


        //How to find how many rows we have for the query
    resultSet.last();
    System.out.println(resultSet.getRow());

    //print all second column information

    resultSet.beforeFirst();
    while (resultSet.next()){
        System.out.println(resultSet.getString(2));
    }


}


    @Test
    public void test3() throws SQLException {
        Connection connection= DriverManager.getConnection(dbUrl,dbPassword,dbUsername);
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet=statement.executeQuery("SELECT * FROM departments");

//get the database related data inside dbMetadata object

        DatabaseMetaData dbMetadata= connection.getMetaData();
        System.out.println("dbMetadata.getUserName() = " + dbMetadata.getUserName());
        System.out.println("dbMetadata.getDatabaseProductName() = " + dbMetadata.getDatabaseProductName());
        System.out.println("dbMetadata.getDatabaseProductVersion() = " + dbMetadata.getDatabaseProductVersion());
        System.out.println("dbMetadata.getDriverName() = " + dbMetadata.getDriverName());
        System.out.println("dbMetadata.getDriverVersion() = " + dbMetadata.getDriverVersion());



ResultSetMetaData rsMetaData= resultSet.getMetaData();

//how many colums we have?

        int colCount=rsMetaData.getColumnCount();

        System.out.println("rsMetaData.getColumnCount() = " + colCount);

// get the colums names

        System.out.println("rsMetaData.getColumnName(2) = " + rsMetaData.getColumnName(2));

        for (int i = 1; i <= colCount; i++) {
            System.out.println(rsMetaData.getColumnName(i));
        }

        }


//close connection

    }



