package info.vziks.homework11.message;

import java.util.*;

public class MessageTask {

    public static void countEachPriority(List<Message> messageList) {

        Map<MessagePriority, Integer> messagePriorityIntegerMap = new HashMap<>();


        for (Message item :
                messageList) {

            messagePriorityIntegerMap.put(item.getPriority(),
                    (
                            messagePriorityIntegerMap.containsKey(item.getPriority())
                                    ?
                                    messagePriorityIntegerMap.get(item.getPriority()) + 1 : 1));

        }

        System.out.println(messagePriorityIntegerMap);
    }

    public static void countEachCode(List<Message> messageList) {

        Map<Integer, Integer> messagePriorityIntegerMap = new HashMap<>();

        for (Message item :
                messageList) {

            messagePriorityIntegerMap.put(item.getCode(),
                    (
                            messagePriorityIntegerMap.containsKey(item.getCode())
                                    ?
                                    messagePriorityIntegerMap.get(item.getCode()) + 1 : 1));

        }

        System.out.println(messagePriorityIntegerMap);
    }

    public static void uniqueMessageCount(List<Message> messageList) {

        Set<List<Message>> uniqueSet = new HashSet<>();
        for (Message a : messageList) {
            uniqueSet.add(Collections.singletonList(a));
        }

        System.out.println(uniqueSet.size());

    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {
        System.out.println("item");
        List<Message> tempMessage = new ArrayList<>();

        for (Message item :
                messageList) {
            if (!tempMessage.contains(item)) {
                tempMessage.add(item);
            }
        }
        return tempMessage;
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority) {
        System.out.println();
        System.out.println("Before removeEach");
        for (Message item :
                messageList) {
            System.out.println(item);

        }
        messageList.removeIf(mess -> (priority.equals(mess.getPriority())));
        System.out.println();
        System.out.println("After removeEach");
        for (Message item :
                messageList) {
            System.out.println(item);

        }

    }

    public static void removeOther(List<Message> messageList, MessagePriority priority) {

        System.out.println();
        System.out.println("Before removeOther");
        for (Message item :
                messageList) {
            System.out.println(item);

        }
        messageList.removeIf(mess -> (!priority.equals(mess.getPriority())));
        System.out.println();
        System.out.println("After removeOther");

        for (Message item :
                messageList) {
            System.out.println(item);

        }

    }

}
