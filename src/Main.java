import java.io.LineNumberInputStream;
import java.security.Principal;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		int[] dataTypeArr = new int[N]; // 0 == q, 1 == s
		int[] queStArr = new int[N];

		int i, j;
		for(i = 0; i < N; i++) dataTypeArr[i] = sc.nextInt();
		sc.nextLine();
		for(i = 0; i < N; i++) queStArr[i] = sc.nextInt();
		sc.nextLine();
		int M = sc.nextInt();
		int[] insrtArr = new int[M];
		int[] ansArr = new int[M];
		sc.nextLine();
		for(i = 0; i < M; i++) insrtArr[i] = sc.nextInt();

		int cntVal = 2;
		int tmp, next, sync;

		for (i = 0; i < N; i++) { // 큐스택에 값을 하나 씩 집어넣자.
			if (dataTypeArr[i] == 0){ // 큐 인경우
				tmp = queStArr[i];
				queStArr[i] = cntVal;
				next = tmp;
			} else { // 스택인 경우
				//tmp = queStArr[i];
				queStArr[i] = cntVal;
				next = cntVal;
			}
			
			queStArr[i + 1] = next; 

		}
	}
}

class queueStack {
	private int inputvalue, outputValue;
	public int[] qstArr;
	public int[] qOrSArr;

	queueStack(int len) { // 길이를 설정하여 큐스택 생성
		qstArr = new int[len];
	}

	get(int inp) {
		inputvalue = inp;
		









		
		return outputValue;
	}

}

