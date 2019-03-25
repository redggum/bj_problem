import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2747번 피보나치 수 */

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// n = 1 -> 1
		// n = 2 -> 2
		// n = 3 -> n(2) + n(1)
		// n = 4 -> n(3) + n(2)
		// n = 5 -> n(4) + n(3)
		// n = 6 -> n(5) + n(4)
		// n = n -> n(n - 1) + n(n - 2)
		
		int[] sum = new int[N + 1];
		
		sum[0] = 0;
		sum[1] = 1;
		
		for (int n = 2; n <= N; n++) {
			sum[n] = sum[n - 2] + sum[n - 1];
		}

		System.out.println(sum[N]);
	}

}