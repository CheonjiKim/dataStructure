import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] numsArr = new int[N];
		
		int i;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (i = 0; i < N; i++) numsArr[i] = Integer.parseInt(st.nextToken()); // N개의 수 담기
		Arrays.sort(numsArr); // 정렬하기
		System.out.println(Arrays.toString(numsArr));
		// 배열에서 좋은 수는 최소 2번째 index에서부터 존재할 수 있다.
		
		// k k k k k k k k k (k + 1) (k + 2)

		int startIndex = 0, endIndex = N - 1, currIndex = 0, count = 0;
		int start = numsArr[startIndex];
		int end = numsArr[endIndex];
		int curr = numsArr[currIndex];

		for (i = 0; i < N; i++) {
			startIndex = 0;
			endIndex = N - 1;

			while(currIndex < N) {
				if (startIndex == currIndex) {
					startIndex++;
				}
				if (endIndex == currIndex) {
					endIndex--;
				}
				if (start == end) { // curr는 좋은 수가 아니다.
					currIndex++;
					break; 
				} 
				if (curr > (start + end)) {
					startIndex++;
				} else if (curr < (start + end)) {
					endIndex--;
				} else { // curr == start + end
					count++;
					currIndex++;
				}
			}
		}
		System.out.println(count);
	}
}