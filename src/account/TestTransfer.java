package account;


public class TestTransfer {
    public static void main(String[] args) {
        AccountServiceImpl accountService=new AccountServiceImpl();
        accountService.transfer("0002","1234","0001", 100.0);
    }
}
