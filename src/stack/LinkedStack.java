package stack;
import list.Node;

public class LinkedStack<E> implements StackInterface<E> {
    private Node<E> topNode;
    private final E ERROR = null;
    public LinkedStack() {
        topNode = null;
    }

    public void push(E newItem) {
        topNode = new Node<>(newItem, topNode);        
    }

    public E pop() {
        if (isEmpty()) return ERROR;
        else {
            Node<E> temp = topNode;
            topNode = topNode.next;
            return temp.item;
        }
    }

    public E top() {
        if (isEmpty()) return ERROR;
        else return topNode.item;
    }

    public boolean isEmpty() {
        return (topNode == null);
    }

    public void popAll() {
        topNode = null;
    }
}
