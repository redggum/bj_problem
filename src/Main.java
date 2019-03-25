import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 11726번 2xn 타일링 */

public class Main {
	
	final static int DIV = 10007;

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
		
		sum[1] = 1;
		sum[2] = 2;
		
		for (int n = 3; n <= N; n++) {
			sum[n] = ((sum[n - 1] % DIV) + (sum[n - 2] % DIV)) % DIV;
		}

		System.out.println(sum[N]);
	}

}