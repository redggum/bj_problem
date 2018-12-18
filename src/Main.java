import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 10569번 다면체 */

public class Main {

	static int N = 0;	// 1 <= N < 1000
	static int sum = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				if (i != j) {
					sum += (i + j);
				}
			}
		}
		
		sum /= 2;
		
		System.out.println(N * (N + 1) + sum);
	}
}
