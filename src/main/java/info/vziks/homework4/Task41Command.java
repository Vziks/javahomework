package info.vziks.homework4;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.homework4.list.DoublyLinkList;
import info.vziks.homework4.list.Node;
import info.vziks.utils.Command;

import java.util.Random;

public class Task41Command implements Command {
    @Override
    public void execute() throws TaskCommandException {

        Random rnd = new Random(47);
        DoublyLinkList list = new DoublyLinkList();
        for (int i = 0; i < 15; i++) {
            list.add(new Node(rnd.nextInt(10)));
        }
        list.deleteByIndex(2);
        list.pushStack(new Node(1));
        list.pushStack(new Node(2));
        list.pushStack(new Node(3));

        int stackSize = list.getCount();
        System.out.println(list);
        for (int i = 0; i < stackSize; i++) {
            Object save = list.popStack();
//            System.out.println(save);
        }



//        DoublyLinkList list2 = new DoublyLinkList();
//        for (int i = 0; i < 15; i++) {
//            list2.add(new Node(rnd.nextInt(10)));
//        }
//        list2.deleteByIndex(2);
//        list2.pushStack(new Node(1));
//        list2.pushStack(new Node(2));
//        list2.pushStack(new Node(3));
//
//        int queueSize = list2.getCount();
//        System.out.println(list2);
//        for (int i = 0; i < stackSize; i++) {
//            Object save = list2.popQueue();
//            System.out.println(save);
//        }

    }
}
