import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2292번 벌집 */

public class Main {
	static int MUL = 6;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());
		long sum = 1;
		
		// 1,(6) 7, (12) 19, (18) 37, (24) 61
		for (int i = 1; i <= N; i++) {
			sum += (MUL * (i - 1));
			
			if (N <= sum) {
				System.out.println(i);
				break;
			}
		}
	}
}