package account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDaoImpl {
    public int insert(Account account){return 0;}
    public int delete(String cardNo){return 0;}
    public int update(Account account){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        connection=DButils.getconnection();
        String sql="update account set PASSWORD=?,NAME=?,balance=? where cardNo=?";
        try {
            preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1,account.getPASSWORD());
            preparedStatement.setString(2,account.getNAME());
            preparedStatement.setDouble(3,account.getBalance());
            preparedStatement.setString(4,account.getCardNo());
            int result=preparedStatement.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils.closeall(null,preparedStatement,null);
        }
        return 0;}
    public Account select(String cardNo){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select * from account where cardNo= ?";
        connection=DButils.getconnection();
        Account account = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cardNo);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                account = new Account();
                String account_cardNo=resultSet.getString("cardNo");
                String account_PASSWORD = resultSet.getString("PASSWORD");
                String account_NAME = resultSet.getString("NAME");
                Double account_balance = resultSet.getDouble("balance");
                account.setCardNo(account_cardNo);
                account.setPASSWORD(account_PASSWORD);
                account.setNAME(account_NAME);
                account.setBalance(account_balance);
            }
            return account;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils.closeall(null,preparedStatement,resultSet);
        }
        return null;}
}
