package queue;
import list.Node;

public class LinkedQueue<E> implements QueueInterface<E> {
    private Node<E> tail;
    private final E ERROR = null;
    public LinkedQueue() {
        tail = null;
    }

    public void enqueue(E newItem) {
        Node<E> newNode = new Node<>(newItem);
        if (isEmpty()) {
            newNode.next = newNode;
            tail = newNode;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public E dequeue() {
        if (isEmpty()) return ERROR;
        else {
            Node<E> front = tail.next;
            if (front == tail) tail = null; // only one item in queue
            else tail.next = front.next; // more then one item
            return front.item;
        }
    }

    public E front() {
        if (isEmpty()) return ERROR;
        else return tail.next.item; // tail.next: front
    }

    public boolean isEmpty() {
        return tail == null;
    }

    public void dequeueAll() {
        tail = null;
    }
}
