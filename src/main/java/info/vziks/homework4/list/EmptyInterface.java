package info.vziks.homework4.list;

public interface EmptyInterface {
    default boolean isEmpty(DoublyLinkList list) {
        return list.getFirst() == null;
    }
}
