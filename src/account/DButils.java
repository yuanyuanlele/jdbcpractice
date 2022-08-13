package account;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DButils {
    private static final Properties PROPERTIES=new Properties();
    private static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();
    static {
        InputStream is=DButils.class.getResourceAsStream("/db.properties");
        try {
            PROPERTIES.load(is);
            Class.forName(PROPERTIES.getProperty("driver"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getconnection(){
        Connection connection=threadLocal.get();//将当前线程中绑定的connection对象赋给connection
        try {
            if(connection==null){
                connection= DriverManager.getConnection(PROPERTIES.getProperty("url"),PROPERTIES.getProperty("username"), PROPERTIES.getProperty("password"));
                threadLocal.set(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void begin(){
        try {
            Connection connection=getconnection();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void commit(){
        Connection connection=null;
        try {
            connection=getconnection();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeall(connection,null,null);
        }
    }

    public static void rollback(){
        Connection connection=null;
        try {
            connection=getconnection();
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeall(connection,null,null);
        }
    }

    public static void closeall(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if(resultSet!=null)
                resultSet.close();
            if(statement!=null)
                statement.close();
            if(connection!=null){
                connection.close();
                threadLocal.remove();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
