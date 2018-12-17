import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1024번 수열의 합 */

public class Main {

	static long A = 0;	// -2,147,483,648 ≤ A, B ≤ 2,147,483,647
	static long B = 0;	// -2,147,483,648 ≤ A, B ≤ 2,147,483,647
	static long sum = 0;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] strs = br.readLine().split(" ");
		A = Long.parseLong(strs[0]);
		B = Long.parseLong(strs[1]);
		
		
		// guess B >= A
		if (A > B) {
			long tmp = A;
			A = B;
			B = tmp;
		}
		
//		if (A >= 0 && B >= 0) {
			
			sum = (B * (B + 1) / 2) - (A * (A - 1) / 2);
			
//		} else if (A < 0 && B >= 0) {
//			sum = (B * (B + 1) / 2) + (A * (A - 1) / 2);
//			
//		} else {	// A < 0 && B < 0
//			sum = (A * (A - 1) / 2) + (B * (B + 1) / 2);
//		}
		
		System.out.println(sum);
	}
}
