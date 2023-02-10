package queue;

public class ArrayQueueTwo<E> implements QueueInterface<E> {
    private E queue[];
    private int front, tail, numItems;
    private static final int DEFAULT_CAPACITY = 64;
    private final E ERROR = null;

    public ArrayQueue() {
        queue = (E[]) new Object[DEFAULT_CAPACITY];
        front = 0;
        tail = DEFAULT_CAPACITY - 1;
        numItems = 0;
    }

    public ArrayQueue(int n) {
        queue = (E[]) new Object[n];
        front = 0;
        tail = n - 1;
        numItems = 0;
    }

    public boolean isFull() {
        return (numItems == queue.length);
    }

    public void enqueue(E newItem) {
        if (isFull()) {
            ArrayQueue<E> tempQueue = new ArrayQueue<>(queue.length);
            tempQueue.enqueue(dequeue());
            queue = (E[]) new Object[queue.length * 2];
            enqueue(tempQueue.dequeue());
            
            tail = (tail + 1) % queue.length;
            queue[tail] = newItem;
            ++numItems;
        } else {
            tail = (tail + 1) % queue.length;
            queue[tail] = newItem;
            ++numItems;
        }
    }

    public E dequeue() {
        if (isEmpty()) return ERROR;
        else {
            E queueFront = queue[front];
            front = (front + 1) % queue.length;
            --numItems;
            return queueFront;
        }
    }

    public E front() {
        if (isEmpty()) return ERROR;
        else return queue[front];
    }

    public boolean isEmpty() {
        return (numItems == 0);
    }

    public void dequeueAll() {
        queue = (E[]) new Object[queue.length];
        front = 0;
        tail = queue.length - 1;
        numItems = 0;
    }    
}