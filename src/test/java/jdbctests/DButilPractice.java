package jdbctests;

import org.junit.jupiter.api.Test;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class DButilPractice {

    @Test
    public void test1(){

        DBUtils.createConnection();
        String query="SELECT first_name, last_name, salary, job_id FROM employees where rownum<6";
        List<Map<String, Object>> queryData = DBUtils.getQueryResultMap(query);

        for (Map<String, Object> row : queryData) {

            System.out.println(row.toString());


        }

        DBUtils.destroy();
        }

        }


