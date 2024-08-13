package factory;

import account.Account;
import account.BankAccount;

public class BankAccountFactory extends AccountFactory{
    public BankAccountFactory(Account account) {
        super(account);
    }

    public boolean checkInformation(BankAccount account) {
        return true;
    }

    public boolean checkService(BankAccount account) {
        return true;
    }

    public int getBalance(BankAccount account) {
        return 0;
    }

    public boolean validate(BankAccount account) {
        return true;
    }

    public BankAccount createAccount(BankAccount account) {
        if (checkInformation(account) && checkService(account) && validate(account)) {
            return new BankAccount();
        }
        return null;
    }
}
