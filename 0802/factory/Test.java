package factory;

import account.BankAccount;

public class Test {
    public static void main(String[] args) {
        BankAccount b = new BankAccount();
        AccountFactory f = new BankAccountFactory(b);
    }
}
