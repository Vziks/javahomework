package info.vziks.homework10.list;

import java.util.Iterator;

public class DoublyLinkListIterator<T> implements Iterator<T> {

    private Node current;

    public DoublyLinkListIterator(DoublyLinkList list) {
        current = list.getFirst();
    }

    public boolean hasNext() {
        return current != null;
    }
    @SuppressWarnings("unchecked")
    public T next() {
        T data = (T) current.getData();
        current = current.getNext();
        return data;
    }


}
