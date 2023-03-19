package jdbctests;

import java.sql.*;

public class TestConnection {
    public static void main(String[] args) throws SQLException {
        String dbUrl="jdbc:oracle:thin:@54.209.8.165:1521:XE";
        String dbUsername="hr";
        String dbPassword="hr";

        Connection connection= DriverManager.getConnection(dbUrl,dbPassword,dbUsername);
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("SELECT * FROM regions");

       //resultSet.close();
       // statement.close();
        //connection.close();

        resultSet.next();

        //System.out.println(resultSet.getString("REGION_NAME"));

        //System.out.println(resultSet.getString(2));

    /*    System.out.println(resultSet.getInt(1)+" - "+ resultSet.getString(2));

        resultSet.next();
        System.out.println(resultSet.getInt(1)+" - "+ resultSet.getString(2));

        resultSet.next();
        System.out.println(resultSet.getInt(1)+" - "+ resultSet.getString(2));

        resultSet.next();
        System.out.println(resultSet.getInt(1)+" - "+ resultSet.getString(2));

*/

        while (resultSet.next()){
            System.out.println(resultSet.getInt(1)+" - "+ resultSet.getString(2));

        }


    }
}
