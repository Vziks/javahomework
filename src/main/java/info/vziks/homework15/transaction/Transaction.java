package info.vziks.homework15.transaction;

public class Transaction {
    private String uuid;
    private long sum;
    private Account account;

    public Transaction(String uuid, long sum, Account account) {
        this.uuid = uuid;
        this.sum = sum;
        this.account = account;
    }

    public String getUuid() {
        return uuid;
    }

    public Transaction setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public long getSum() {
        return sum;
    }

    public Transaction setSum(long sum) {
        this.sum = sum;
        return this;
    }

    public Account getAccount() {
        return account;
    }

    public Transaction setAccount(Account account) {
        this.account = account;
        return this;
    }
}
