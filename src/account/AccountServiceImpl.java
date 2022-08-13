package account;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountServiceImpl {
    public void transfer(String fromNo,String pwd,String toNo,Double money){
        AccountDaoImpl accountDao=new AccountDaoImpl();
        //1验证from是否存在
        try {
            DButils.begin();
            Account account=accountDao.select(fromNo);
            if(account==null){
                throw new RuntimeException("卡号不存在！");
            }
            //2验证pwd是否正确
            if(!account.getPASSWORD().equals(pwd)){
                throw new RuntimeException("密码错误！");
            }
            //3验证余额充足否
            if (account.getBalance()<money){
                throw new RuntimeException("余额不足！");
            }
            //4验证to是否存在
            Account account1=accountDao.select(toNo);
            if(account1==null){
                throw new RuntimeException("对方卡号不存在！");
            }
            //5减少from余额
            account.setBalance(account.getBalance()-money);
            accountDao.update(account);

            //6增加to余额
            account1.setBalance(account1.getBalance()+money);
            accountDao.update(account1);
            System.out.println("转账成功！");
            DButils.commit();
        } catch (RuntimeException e) {
            System.out.println("转账失败！");
            DButils.rollback();
            e.printStackTrace();
        }
    }
}
