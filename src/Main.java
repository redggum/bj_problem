import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1964번 오각혁,오각형,오각형... */

public class Main {

	static int N;	// 1 <= N <= 10,000,000
	static int[] D;
	static int DIV = 45678;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		D = new int[N + 1];
		
		D[0] = 1;
		//D[1] = D[0] + 4 + 3 * 0;
		//D[2] = D[1] + 4 + 3 * 1;
		//D[3] = D[2] + 4 + 3 * 2;
		//D[4] = D[3] + 4 + 3 * 3;
		
		for (int i = 1; i <= N; i++) {
			D[i] = (D[i -1] + 4 + 3 * (i - 1)) % DIV;
		}
		
		System.out.println(D[N]);
	}
}
