import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 11726번 2xn 타일링 */

public class Main {

	final static int DIV = 10007;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		long[] D = new long[n + 1];

		if (n >= 3) {

			D[1] = 1;
			D[2] = 2;

			for (int i = 3; i <= n; i++) {
				D[i] = D[i - 1] + D[i - 2];
				D[i] %= DIV;
			}
		} else {
			if (n == 1) {
				D[1] = 1;
			}
			if (n == 2) {
				D[2] = 2;
			}
		}
		

		System.out.println(D[n] % DIV);
	}
}