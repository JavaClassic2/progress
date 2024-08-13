package factory;
import account.Account;
import account.BankAccount;

public abstract class AccountFactory {
    Account account;
    
    public AccountFactory(Account account) {
        this.account = account;
    }
    
    public abstract boolean checkInformation(BankAccount account);
    public abstract boolean checkService(BankAccount account);
    public abstract int getBalance(BankAccount account);
    public abstract boolean validate(BankAccount account);
    public abstract BankAccount createAccount(BankAccount account);

    public BankAccount getAccount(BankAccount account) {
        if (checkInformation(account) && checkService(account)) {
            return createAccount(account);
        }
        return null;
    }
}
