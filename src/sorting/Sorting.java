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
    
}
