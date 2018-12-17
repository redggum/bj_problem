import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1024번 수열의 합 */

public class Main {

	static int N = 0;	// N <= 1,000,000,000
	static int L = 0;	// 2 <= L <= 100
	static int val = 0;
	static int start = 0; 
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		L = Integer.parseInt(strs[1]);

		// 합이 N이면서, 길이가 적어도 L이면서 가장 짧은 연속된 음이 아닌 정수 리스트
		for (int i = L; i <= 100; i++) {
			val = (N - (i - 1) * i / 2);
			
			if (val < 0) {
				continue;
			}
			
			if (val % i == 0) {
				start =  val / i;
				
				for (int j = 0; j < i; j++) {
					System.out.print((start + j) + " ");
				}
				
				return;
			}
		}
		
		System.out.println(-1);
	}
}
