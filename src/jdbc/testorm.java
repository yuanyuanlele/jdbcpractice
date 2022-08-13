package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class testorm {
    public static void main(String[] args) {
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Shuzi> Shuzilist=new ArrayList<>();
        try {
            connection = null;
            preparedStatement = null;
            connection = DButils.getconnection();
            preparedStatement = connection.prepareStatement("select * from shuzi;");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String first = resultSet.getString("first");
                String second = resultSet.getString("second");
                String third = resultSet.getString("third");
                Shuzi shuzi=new Shuzi();
                shuzi.setFirst(first);
                shuzi.setSecond(second);
                shuzi.setThird(third);
                Shuzilist.add(shuzi);
            }
            for(Shuzi t:Shuzilist)
                System.out.println(t);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButils.closeall(connection, preparedStatement, resultSet);
        }
    }
}
