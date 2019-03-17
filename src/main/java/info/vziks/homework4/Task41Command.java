package info.vziks.homework4;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.homework4.list.DoublyLinkList;
import info.vziks.utils.Command;

import java.util.Random;

public class Task41Command implements Command {
    @Override
    public void execute() throws TaskCommandException {

        Random rnd = new Random(47);
        DoublyLinkList list = new DoublyLinkList();
        for (int i = 0; i < 15; i++) {
            list.add(rnd.nextInt(10));
        }

        list.delete(7);
        list.deleteByIndex(2);
        list.insertBefore(1, 3);
        list.insertAfter(5, 2);
        list.insertBefore(9, 5);
        System.out.println(list);
    }
}
