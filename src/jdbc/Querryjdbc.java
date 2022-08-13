package jdbc;

import com.mysql.jdbc.Driver;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Querryjdbc {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","123456");
        Statement statement=connection.createStatement();
        ResultSet resultSet= statement.executeQuery("select*from sda");
        while (resultSet.next())
        {
            String id=resultSet.getString(1);
            System.out.println(id);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
