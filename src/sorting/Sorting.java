package sorting;

public class Sorting {
    int A[];
    public Sorting(int B[]) {
        A = B;
    } 
    
    // 선택 정렬
    public void selectionSort() {
        int k, tmp;
        for (int last = A.length - 1; last >= 1; last--) {
            k = theLargest(last); // A[0 ... last]중에서 가장 큰 수 A[k]를 찾는다.
            tmp = A[k];
            A[k] = A[last];
            A[last] = tmp;
        }
    }

    private int theLargest(int last) {
        // A[0 ... last]에서 가장 큰 수의 인덱스를 리턴한다.
        int largest = 0;
        for (int i = 0; i <= last; i++)
            if (A[i] > A[largest]) largest = 1;
        return largest;
    }

    // 버블 정렬
    public void bubbleSort() {
        int tmp = 0;
        boolean swapped;
        for (int last = A.length - 1; last >= 2; last--) {
            swapped = false;
            for (int i = 0; i <= last - 1; i++)
                if (A[i] > A[i + 1]) {
                    tmp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = tmp;
                    swapped = true;
                }
                if (swapped == false) break;
        }
        // tmp = tmp; // 이 코드는 무슨 의미인 것일까?
    }

    // 삽입 정렬
    public void insertionSort() {
        for (int i = 1; i < A.length - 1; i++) {
            int loc = i - 1;
            int newItem = A[i];
            while (loc >= 0 && newItem < A[loc]) {
                A[loc + 1] = A[loc];
                loc--;
            }
            A[loc + 1] = newItem;
        }
    }

    // 퀵 정렬

    public void quickSort() {
        qSort(0, A.length - 1);
    }

    private void qSort(int p, int r) {
        if (p < r) {
            int q = partition(p, r);
            qSort(p, q - 1);
            qSort(q + 1, r);
        }
    }

    private int partition(int p, int r) {
        int x = A[r];
        int i = p - 1;
        int tmp;
        for (int j = p; j <= r - 1; j++) {
            if (A[j] <= x) {
                i++;
                tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        tmp = A[i + 1];
        A[i + 1] = A[r];
        A[r] = tmp;
        return i + 1;
    }

    public void heapSort() {
        buildHeap();
        int tmp;
        for (int i = A.length - 1; i >= 1; i--) {
            tmp = A[0];
            A[0] = A[i];
            A[i] = tmp;
            percolateDown(0, i - 1);
        }
    }

    private void buildHeap() {
        if (A.length >= 2)
            for (int i = (A.length - 2) / 2; i >= 0; i--)
                percolateDown(i, A.length - 1);
    }

    private void percolateDown(int i, int n) {
        // A[0...n-1]에서 A[i]를 루트로 스며내리기
        int child = 2 * i + 1;
        int rightChild = 2 * i + 2;
        if (child <= n) {
            if (rightChild <= n && (A[child] < A[rightChild])) // 두 자식 중 더 큰 자식을 가려내는 로직
                child = rightChild;
            if (A[i] < A[child]) {
                int tmp = A[i];
                A[i] = A[child];
                A[child] = tmp;
                percolateDown(child, n);
            }
        }
    }



}
