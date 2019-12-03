package info.vziks.homework15;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.homework15.transaction.TransactionsTask;
import info.vziks.utils.Command;

public class Task152Command implements Command {
    @Override
    public void execute() throws TaskCommandException {
        try {
            TransactionsTask transactionsTask = new TransactionsTask();
            System.out.println(transactionsTask.calculateSumTransaction());
        } catch (TaskCommandException e) {
            e.printStackTrace();
        }
    }
}
