package info.vziks.homework4.list;


import info.vziks.exceptions.TaskCommandException;

public class DoublyLinkList {
    private Node first, last;
    private int count;

    public DoublyLinkList() {
        this.first = null;
        this.last = null;
        this.count = 0;
    }

    public void add(int i) {

        Node node = new Node(i, null, last);
        if (isEmpty()) {
            first = last = node;
        } else {
            last.setNext(node);
            last = node;
        }
        count++;
    }

    public void insertAfter(int fData, int cData) {

        Node nodeR = first;

        while (nodeR != null) {
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

    public void insertBefore(int fData, int cData) {

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
        if (!isEmpty()) {
            if (first == last) {
                first = last = null;
            } else {
                last = last.getPrev();
                last.setNext(null);
            }
        }
        count--;
    }

    public void delete(int i) {
        Node nodeR = first;

        while (nodeR.getNext() != null) {
            nodeR = nodeR.getNext();
            Node node = first;
            while (node != null && node.getData() != i) {
                node = node.getNext();
            }
            if (node != null) {
                swapNode(node);
            }
        }
    }

    private void swapNode(Node node) {

        if (node.getPrev() == null) {
            first = node.getNext();
            if (!isEmpty()) {
                first.setPrev(null);
            }
        } else if (node.getNext() == null) {
            last = node.getPrev();
            if (!isEmpty()) {
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
            throw new TaskCommandException();
        }

        Node node = first;
        int y = 1;
        while (node.getNext() != null && y != index) {
            node = node.getNext();
            y++;
        }
        swapNode(node);
    }


    public boolean isEmpty() {
        return getFirst() == null;
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
            ;
            node = node.getNext();
        }
        return str.toString();
    }

    public int getCount() {
        return count;
    }

}
