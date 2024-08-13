import java.math.BigDecimal;

public class AccountBuilder {
    private static long nextNo;
    private String ownerName;
    private long accountNo;
    private AccountType accountType;
    private BigDecimal balance;

    enum AccountType {
        Checking,
        Deposit,
        Saving
    }
    
    private AccountBuilder(Builder builder) {
        this.ownerName = builder.ownerName;
        this.accountNo = nextNo();
        this.accountType = builder.accountType;
        this.balance = builder.balance;
    }

    private static long nextNo() {
        return nextNo++;
    }

    public static class Builder {
        private String ownerName;
        private AccountType accountType;
        private BigDecimal balance;

        public Builder ownerName(String ownerName) {
            this.ownerName = ownerName;
            return this;
        }
        
        public Builder accountType(AccountType accountType) {
            this.accountType = accountType;
            return this;
        }

        public Builder balance(BigDecimal balance) {
            this.balance = balance;
            return this;
        }

        public AccountBuilder build(){
            return new AccountBuilder(this);
        }
    }
}
