package bankAccountExample;

public class BankAccount {
    private Integer balance = 100;

    public Integer getBalance() {
        return balance;
    }

    public void withdrawMoney(Integer amount){
        balance = balance - amount;
    }
}
