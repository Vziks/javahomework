package info.vziks.homework4.list;


import info.vziks.exceptions.TaskCommandException;

import java.util.Iterator;

public class DoublyLinkList<T> implements Iterable<T>, Stack, Queue, List {

    private Node first, last;
    private int count;
    public DoublyLinkList() {
        this.first = null;
        this.last = null;
        this.count = 0;
    }

    @Override
    public void add(Node node) {
        node.setPrev(last);
        if (isEmpty(this)) {
            first = last = node;
        } else {
            last.setNext(node);
            last = node;
        }
        count++;
    }

    @Override
    public void remove(Node node) {
        Node nodeR = first;

        while (nodeR != null) {
            if (nodeR.getData() == node.getData()) {
                Node newNode = new Node(node, nodeR, nodeR.getPrev());
                nodeR.getPrev().setNext(newNode);
                nodeR.setPrev(newNode);
                count++;
            }
            nodeR = nodeR.getNext();
        }
    }


    public void delete(Node i) {
        Node nodeR = first;

        while (nodeR.getNext() != null) {
            nodeR = nodeR.getNext();
            Node node = first;
            while (node != null && node.getData() != i.getData()) {
                node = node.getNext();
            }
            if (node != null) {
                swapNode(node);
            }
        }
    }

    public void insertAfter(Object fData, int cData) {

        Node nodeR = first;

        while (nodeR != null) {
//            if (nodeR.getData() == fData) {
            if (nodeR.getData() == fData) {
                if (nodeR.getNext() == null) {
                    Node newNode = new Node(cData, null, nodeR);
                    nodeR.setNext(newNode);
                } else {
                    Node newNode = new Node(cData, nodeR.getNext(), nodeR);
                    nodeR.getNext().setPrev(newNode);
                    nodeR.setNext(newNode);
                }

                count++;
            }

            nodeR = nodeR.getNext();
        }
    }

    public void insertBefore(Object fData, int cData) {

        Node nodeR = first;

        while (nodeR != null) {
            if (nodeR.getData() == fData) {
                Node newNode = new Node(cData, nodeR, nodeR.getPrev());
                nodeR.getPrev().setNext(newNode);
                nodeR.setPrev(newNode);
                count++;
            }

            nodeR = nodeR.getNext();
        }
    }

    public void remove() {
        if (!isEmpty(this)) {
            if (first == last) {
                first = last = null;
            } else {
                last = last.getPrev();
                last.setNext(null);
            }
        }
        count--;
    }

//    public void delete(int i) {
//        Node nodeR = first;
//
//        while (nodeR.getNext() != null) {
//            nodeR = nodeR.getNext();
//            Node node = first;
//            while (node != null && node.getData() != i) {
//                node = node.getNext();
//            }
//            if (node != null) {
//                swapNode(node);
//            }
//        }
//    }

    private void swapNode(Node node) {

        if (node.getPrev() == null) {
            first = node.getNext();
            if (!isEmpty(this)) {
                first.setPrev(null);
            }
        } else if (node.getNext() == null) {
            last = node.getPrev();
            if (!isEmpty(this)) {
                last.setNext(null);
            }
        } else {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
        }
        count--;
    }

    public void deleteByIndex(int index) throws TaskCommandException {

        if (index > getCount()) {
            throw new TaskCommandException("invalid index " + index);
        }

        Node node = first;
        int y = 1;
        while (node.getNext() != null && y != index) {
            node = node.getNext();
            y++;
        }
        swapNode(node);
    }


//    @Override
//    public boolean isEmpty() {
//        return getFirst() == null;
//    }

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
            ;
            node = node.getNext();
        }
        return str.toString();
    }

    public int getCount() {
        return count;
    }


    public Node getHead() {
        return first;
    }

    public Node getTail() {
        return last;
    }

    @Override
    public Iterator<T> iterator() {
        return new DoublyLinkListItertor<T>(this);
    }

    @Override
    public Object popStack() {
        Node save = getLast();
        if (last.getPrev() != null) {
            last.getPrev().setNext(null);
            setLast(last.getPrev());
        } else {
            first = null;
        }
        count--;
        return save.getData();
    }

    @Override
    public void pushStack(Node node) {
        if (isEmpty(this)) {
            first = last = node;
        } else {
            last.setNext(node);
            node.setPrev(last);
            last = node;
        }
        count++;
    }

    @Override
    public Object popQueue() {
        Node save = getFirst();
        if (first.getNext() != null) {
            first.getNext().setPrev(null);
            setFirst(first.getNext());
        } else {
            first = null;
        }
        count--;
        return save.getData();
    }

    @Override
    public void pushQueue(Node node) {
        if (isEmpty(this)) {
            first = last = node;
        } else {

            first.setPrev(node);
            node.setNext(first);

            first = node;
        }
        count++;
    }


}
