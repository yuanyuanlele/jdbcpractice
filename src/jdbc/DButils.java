package jdbc;

import java.sql.*;

public class DButils {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //1.获得连接
    public static Connection getconnection(){
        Connection connection= null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //2.释放连接
    public static void closeall(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if(resultSet!=null)
                resultSet.close();
            if (statement!=null)
                statement.close();
            if(connection!=null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
