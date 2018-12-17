import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2921번 도미노 */

public class Main {

	static int n = 0;	// 2 < n < 100,000
	static int val = 0;
	static int start = 0;
	static int sum = 0;
	static String result = "";
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			n = Integer.parseInt(br.readLine());
			
			if (n == -1) {
				break;
			}
			
			sum = 0;
			result = n + " = ";
			cnt = 0;
			
			for (int i = 1; i < n; i++) {
				if (n % i == 0) {
					sum += i;
					if (cnt == 0) {
						result += i;
					} else {
						result += " + " + i;
					}
					cnt++;
				}
			}
			
			if (sum != n) {
				System.out.println(n + " is NOT perfect.");
			} else {
				System.out.println(result);
			}
			
		}

	}
}
