import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2581번 소수 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int m, n;
		long sum = 0;
		int min = 10001;

		m = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());

		for (int i = m; i <= n; i++) {
			if (isDecimal(i)) {
//				System.out.println(i);
				sum += i;

				if (i < min) {
					min = i;
				}
			}
		}

		if (sum > 0) {
			System.out.println(sum);
			System.out.println(min);
		} else {
			System.out.println(-1);
		}
	}

	static boolean isDecimal(int n) {
		if (n == 1) {
			return false;
		} else if (n != 2 && n % 2 == 0) {
			return false;
		} else {
			for (int i = 3; i < n; i += 2) {
				if (n % i == 0) {
					return false;
				}
			}
		}

		return true;
	}
}
