package heap;

public class Heap<E extends Comparable> implements PQInterface<E> {
    private E[] A;
    private int numItems;

    public Heap(int arraySize) {
        A = (E[]) new Comparable[arraySize];
        numItems = 0;
    }

    public Heap(E[] B, int numElements) {
        A = B;
        numItems = numElements;
    }

    public void insert(E newItem) throws PQException {
        // 힙에 새 newItem을 추가한다.
        if (numItems < A.length) {
            A[numItems] = newItem;
            percolateUp(numItems);
            numItems++;
        } else throw new PQException("HeapErr: insert() - Overflow!");
    }

    private void percolateUp(int i) {
        // A[i] 부터 시작하여 힙 성질을 만족하도록 수정한다.
        // A[0 ... i-1]은 힙 성질을 이미 만족하고 있다.
        int parent = (i - 1) / 2;
        if (parent >= 0 && A[i].compareTo(A[parent]) > 0) {
            E tmp = A[i];
            A[i] = A[parent];
            A[parent] = tmp;
            percolateUp(parent);
        }
    }

    public E deleteMax() throws PQException {
        // 힙 A[0...numItems-1]에서 최댓값을 삭제하면서 리턴한다.
        if ( !isEmpty() ) {
            E max = A[0];
            A[0] = A[numItems - 1];
            numItems--;
            percolateDown(0);
            return max;
        }   else throw new PQException("HeapErr: DeleteMax() - Underflow!");
    }

    private void percolateDown(int i) {
        // A[0...numItems-1]에서 A[i]를 루트로 스며내리기
        int child = 2 * i + 1;
        int rightChild = 2 * i + 2;
        if (child <= numItems - 1) {
            if (rightChild <= numItems - 1 && A[child].compareTo(A[rightChild]) < 0) // 두 자식 중 더 큰 자식을 가려내는 로직
                child = rightChild;
            if (A[i].compareTo(A[child]) < 0) {
                E tmp = A[i];
                A[i] = A[child];
                A[child] = tmp;
                percolateDown(child);
            }
        }
    }

    public void buildHeap() {
        if (numItems >= 2)
            for (int i = (numItems - 2) / 2; i >= 0; i--)
                percolateDown(i);
    }

    public E max() throws PQException {
        if ( !isEmpty() ) return A[0];
        else throw new PQException("HeapErr: Max() - Empty!");
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public void clear() {
        A = (E[]) new Object[A.length];
        numItems = 0;
    }
}
