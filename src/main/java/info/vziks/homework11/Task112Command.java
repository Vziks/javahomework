package info.vziks.homework11;

import info.vziks.homework11.message.MessageGenerator;
import info.vziks.homework11.message.MessagePriority;
import info.vziks.homework11.message.MessageTask;
import info.vziks.utils.Command;

public class Task112Command implements Command {
    @Override
    public void execute() {

        MessageTask.countEachPriority(MessageGenerator.generate(30));
        MessageTask.countEachCode(MessageGenerator.generate(30));
        MessageTask.uniqueMessageCount(MessageGenerator.generate(30));
        MessageTask.removeEach(MessageGenerator.generate(30), MessagePriority.LOW);
        MessageTask.removeOther(MessageGenerator.generate(30), MessagePriority.LOW);
        MessageTask.uniqueMessagesInOriginalOrder(MessageGenerator.generate(30));

    }
}
