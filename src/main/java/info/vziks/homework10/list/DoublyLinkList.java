package info.vziks.homework10.list;


import info.vziks.exceptions.TaskCommandException;

import java.util.Iterator;

public class DoublyLinkList<T> implements Iterable<T>{

    private Node first, last;
    private int count;

    public DoublyLinkList() {
        this.first = null;
        this.last = null;
        this.count = 0;
    }

    public void add(T date) {
        Node<T> node = new Node<>(date);
        node.setPrev(last);
        if (isEmpty(this)) {
            first = last = node;
        } else {
            last.setNext(node);
            last = node;
        }
        count++;
    }

    public void add(int index, T data) throws TaskCommandException {

        Node<T> node = new Node<>(data);
        Node fNode = first;

        if (index > this.getCount() - 1) {
            throw new TaskCommandException("invalid index " + index);
        }

        int y = 0;
        while (fNode != null) {
            if (y == index) {
                if (fNode == first) {
                    first = node;
                    node.setNext(fNode);
                    fNode.setPrev(node);
                } else if (fNode == last) {
                    node.setNext(fNode);
                    node.setPrev(fNode.getPrev());
                    fNode.getPrev().setNext(node);
                } else {
                    fNode.getPrev().setNext(node);
                    node.setPrev(fNode.getPrev());
                    node.setNext(fNode);
                    fNode.setPrev(node);
                }
            }
            count++;
            y++;

            fNode = fNode.getNext();
        }

    }

    private boolean isEmpty(DoublyLinkList<T> list) {
        return list.getFirst() == null;
    }

    public void remove(T data) {
        Node nodeR = first;
        Node<T> node = new Node<>(data);

        while (nodeR != null) {
            if (nodeR.getData().equals(node.getData())) {

                if (nodeR.getPrev() != null) {
                    nodeR.getPrev().setNext(nodeR.getNext());
                } else {
                    nodeR.getNext().setPrev(null);
                    first = nodeR.getNext();
                }
                if (nodeR.getNext() != null) {
                    nodeR.getNext().setPrev(nodeR.getPrev());
                } else {
                    last = nodeR.getPrev();
                }
                count--;
            }
            nodeR = nodeR.getNext();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new DoublyLinkListIterator<>(this);
    }


    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public String toString() {
        Node node = first;
        StringBuilder str = new StringBuilder();
        while (node != null) {
            str.append(node.getData());
            if (node.getNext() != null) {
                str.append(" ");
            }
            node = node.getNext();
        }
        return str.toString();
    }

    public int getCount() {
        return count;
    }
}
