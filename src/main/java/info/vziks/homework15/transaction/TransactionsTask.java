package info.vziks.homework15.transaction;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TransactionsTask {
    private Account account1, account2, account3;
    private Transaction transaction1, transaction2, transaction3, transaction4, transaction5, transaction6, transaction7;

    private Stream<Transaction> transactionStream;
    Map<String, Long> sumOfTransactionByEachAccount;

    public TransactionsTask() {
        this.init();
    }

    public void init() {
        account1 = new Account("781057000", 2000);
        account2 = new Account("445259743", 1900);
        account3 = new Account("692343156", 30000);

        transaction1 = new Transaction("935b0b96-a93c-4ba3-b340-7e27918b77a1", 340, account1);
        transaction2 = new Transaction("6b724ed9-7718-4203-8e70-2728d09b7bf3", 560, account1);
        transaction3 = new Transaction("f0f44e9c-56cc-450e-bf92-3b0ff1497e49", 1000, account2);
        transaction4 = new Transaction("ffa44fa0-52c9-490d-aeee-d4d810cd37f0", 500, account2);
        transaction5 = new Transaction("5faef7f5-eca2-4a67-a228-fe4d8b59a2c8", 1600, account3);
        transaction6 = new Transaction("c38209a7-dbb7-47ee-b162-1953e29eab94", 2000, account3);
        transaction7 = new Transaction("c38209a7-dbb7-47ee-b162-1953e29eab94", 3400, account3);

        transactionStream = Stream.of(transaction1, transaction2, transaction3,
                transaction4, transaction5, transaction6, transaction7);

    }

    public Map<String, Long> calculateSumTransaction() {
        return sumOfTransactionByEachAccount =
                transactionStream
                        .collect(Collectors.groupingBy(Transaction::getAccount))
                        .entrySet()
                        .stream()
                        .flatMap(accountListEntry -> accountListEntry.getValue().stream())
                        .collect(Collectors.toMap(transaction -> transaction.getAccount().getNumber(), Transaction::getSum, Long::sum));

    }
}
