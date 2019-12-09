package info.vziks.exam.multithreading.part8.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Part8 {

    public static void main(String[] args) {
        NameList nameList = new NameList();
        nameList.addToList("First");

        class MyThread extends Thread {
            @Override
            public void run() {
                System.out.println(nameList.removeFirst());
            }
        }

        new MyThread().start();
        new MyThread().start();
    }

    static class NameList {
        /*
         Collections.synchronizedList Not Granted, need add synchronized modificator
         */
        private List list = Collections.synchronizedList(new ArrayList<>());

        public synchronized void addToList(String string) {
            list.add(string);
        }

        public synchronized String removeFirst() {
            if (list.size() > 0) {
                return (String) list.remove(0);
            }
            return null;
        }

    }
}
