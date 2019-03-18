package info.vziks.homework4.list;

import java.util.Iterator;

public class DoublyLinkListItertor<T> implements Iterator<T> {
    Node current;

    public DoublyLinkListItertor(DoublyLinkList list) {
        current = list.getHead();
    }

    public boolean hasNext() {
        return current != null;
    }

    public T next() {
        T data = (T) current.getData();
        current = current.getNext();
        return data;
    }
}
