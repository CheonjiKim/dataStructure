package list;

public class ArrayList<E> implements ListInterface<E> {
    private E item[];
    private int numItems;
    private static final int DEFAULT_CAPACITY = 64;

    public ArrayList() { // 생성자 1
        item = (E[]) new Object[DEFAULT_CAPACITY];
        numItems = 0;
    }

    public ArrayList(int n) { // 생성자 2
        item = (E[]) new Object[n];
        numItems = 0;
    }

    public void add(int index, E x) {
        if (numItems >= item.length || index < 0 || index > numItems) { /* 예외 처리 */}
        else {
            for (int i = numItems - 1; i >= index; i--) item[i + 1] = item[i];
            item[index] = x;
            numItems++;
        }
    }

    public void append(E x) {
        if (numItems >= item.length) { /* 에러 처리 */}
        else item[numItems++] = x;
    }

    public E remove(int index) {
        if (isEmpty() || index < 0 || index > numItems - 1) return null;
        else {
            E tmp = item[index];
            for (int i = index; i < numItems - 2; i++) item[i] = item[i + 1]; // 좌시프트   
            numItems--;
            return tmp;
        }
    }

    public boolean removeItem(E x) {
        int k = 0;
        while (k < numItems && ((Comparable)item[k]).compareTo(x) != 0) k++;
        if (k == numItems) return false;
        else {
            for (int i = k; i < numItems - 2; i++) item[i] = item[i + 1];
            numItems--;
            return true;
        }
    }

    public E get(int index) {
        if (index >= 0 && index <= numItems - 1) return item[index];
        else return null;
    }

    public void set(int index, E x) {
        if (index >= 0 && index <= numItems - 1) item[index] = x;
        else { /* 예외 처리 */}
    }

    private final int NOT_FOUND = -12345;
    public int indexOf(E x) {
        int i = 0;
        for (i = 0; i < numItems; i++) {
            if (((Comparable)item[i]).compareTo(x) == 0) return i;
        }
        return NOT_FOUND;
    }

    public int len() {
        return numItems;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public void clear() {
        item = (E[]) new Object[item.length];
        numItems = 0;
    }
}

