package account;

public class Account {
    private String cardNo;
    private String PASSWORD;
    private String NAME;
    private double balance;

    public Account() {
    }

    public Account(String cardNo, String PASSWORD, String NAME, double balance) {
        this.cardNo = cardNo;
        this.PASSWORD = PASSWORD;
        this.NAME = NAME;
        this.balance = balance;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "cardNo='" + cardNo + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                ", NAME='" + NAME + '\'' +
                ", balance=" + balance +
                '}';
    }
}
