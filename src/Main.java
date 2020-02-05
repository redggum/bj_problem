import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/* 1003번 피보나치 함수 */

public class Main {
	static int n0;
	static int n1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int N;
		int[][] D; 

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			D = new int[50][2];
			
			D[0][0] = 1;
			D[1][1] = 1;
			
			for (int i = 2; i <= N; i++) {
				D[i][1] = D[i-1][1] + D[i-2][1];
				D[i][0] = D[i-1][0] + D[i-2][0];
			}
			
			System.out.println(D[N][0] + " " + D[N][1]);
		}
	}
}
