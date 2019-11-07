package info.vziks.homework10;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.homework10.list.DoublyLinkList;
import info.vziks.utils.Command;

import java.util.*;


public class Task101Command implements Command {
    @Override
    public void execute() throws TaskCommandException {

        DoublyLinkList<String> stringDoublyLinkList = new DoublyLinkList<>();
        stringDoublyLinkList.add("111");
        stringDoublyLinkList.add("222");
        stringDoublyLinkList.add("333");
        stringDoublyLinkList.add("444");
        stringDoublyLinkList.add("555");
        System.out.println(stringDoublyLinkList);
        stringDoublyLinkList.add(4, "666");
        stringDoublyLinkList.add("777");
        System.out.println(stringDoublyLinkList);
        stringDoublyLinkList.remove("666");
        System.out.println(stringDoublyLinkList);

        System.out.println();
        System.out.println("Iterator");
        for (String item :
                stringDoublyLinkList) {
            System.out.println(item);
        }
        System.out.println();

        DoublyLinkList<Integer> integerDoublyLinkList = new DoublyLinkList<>();
        integerDoublyLinkList.add(111);
        integerDoublyLinkList.add(222);
        integerDoublyLinkList.add(333);
        integerDoublyLinkList.add(444);
        integerDoublyLinkList.add(555);
        System.out.println(integerDoublyLinkList);
        integerDoublyLinkList.add(4, 666);
        integerDoublyLinkList.add(777);
        System.out.println(integerDoublyLinkList);
        integerDoublyLinkList.remove(666);
        System.out.println(integerDoublyLinkList);

        System.out.println();
        System.out.println("Iterator");
        for (Integer item :
                integerDoublyLinkList) {
            System.out.println(item);

        }

    }
}
