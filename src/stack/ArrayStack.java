package stack;

public class ArrayStack<E> implements StackInterface<E>{
    private E stack[];
    private int topIndex;
    private static final int DEFAULT_CAPACITY = 64;
    private final E ERROR = null;

    public ArrayStack() {
        stack = (E[]) new Object[DEFAULT_CAPACITY]; // stack = new E[DEFAULT_CAPACITY] 이 표현은 자바에서 구현이 불가능하다고 한다.
        topIndex = -1;
    }

    public ArrayStack(int n) {
        stack = (E[]) new Object[n]; // stack = new E(n) 이 표현은 자바에서 구현이 불가능하다고 한다.
        topIndex = -1;
    }

    public void push(E newItem) {
        if (isFull()) { /* 에러 처리 */}
        else stack[++topIndex] = newItem;
    }

    public E pop() {
        if (isEmpty()) return ERROR;
        else return stack[topIndex--];
    }

    public E top() {
        if (isEmpty()) return ERROR;
        else return stack[topIndex];
    }

    public boolean isEmpty() {
        return (topIndex < 0);
    }

    public boolean isFull() {
        return (topIndex == stack.length - 1);
    }

    public void popAll() {
        stack = (E[]) new Object[stack.length];
        topIndex = -1;
    }  
}

