package jdbctests;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.*;

public class DynamicList {

    String dbUrl = "jdbc:oracle:thin:@54.209.8.165:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";
    @Test
    public void test1() throws SQLException {

        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement =connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT first_name, last_name, salary, job_id FROM employees where rownum<6");

        //in order to get column names we need resultsetmetadata
        ResultSetMetaData rsmd = resultSet.getMetaData();

        List<Map<String,Object>> queryData=new ArrayList<>();
        int colCount= rsmd.getColumnCount();

        while (resultSet.next()){

            Map<String, Object> row=new LinkedHashMap<>();

            for (int i = 1; i <=colCount ; i++) {

                row.put(rsmd.getColumnName(i),resultSet.getString(i) );
            }

            queryData.add(row);

        }

        for(Map<String,Object>row:queryData){
            System.out.println(row.toString());
        }










        //close connection
        resultSet.close();
        statement.close();
        connection.close();
    }



}



