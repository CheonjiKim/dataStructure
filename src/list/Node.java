package list;


public class Node<E> { // Node 구현하기
    public E item;
    public Node<E> next;

    public Node(E newItem) {
        item = newItem;
        next = null;
    }

    public Node(E newItem, Node<E> nextNode) {
        item = newItem;
        next = nextNode;
    }
}
