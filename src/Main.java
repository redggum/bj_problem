import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1904번 01타일 */

public class Main {

	static int N;	// N <= 1,000,000
	static long DIV = 15746;
	static long sum = 0;
	static long[] D;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		D = new long[1000000 + 1];
		
		D[1] = 1;
		D[2] = 2;
		
		for (int i = 3; i <= N; i++) {
				D[i] = (D[i-1] + D[i - 2]) % DIV;
		}
		
		System.out.println(D[N]);
	}
}
