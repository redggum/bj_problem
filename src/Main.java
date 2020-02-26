import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2775번 부녀회장이 될테야 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T, K, N;
		
		long[][] D;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			K = Integer.parseInt(br.readLine());
			N = Integer.parseInt(br.readLine());
			
			D = new long[K + 1][N + 1];
			
			for (int i = 1; i <= N; i++) {
				D[0][i] = i;
			}
			
			for (int k = 1; k <= K; k++) {
				for (int n = 1; n <= N; n++) {
					for (int m = 1; m <= n; m++) {
						D[k][n] += D[k -1][m];
					}
				}
			}
			
			System.out.println(D[K][N]);
		}
	}
}
