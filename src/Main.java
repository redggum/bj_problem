import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1350번 진짜 공간 */

public class Main {

	static int N = 0; // nums of files -> N <= 1000
	static int[] S;	// size of each file, S <= 1,000,000,000
	static int C; // size of cluster, C <= 1,048,576

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		String[] strs = br.readLine().split(" ");
		S = new int[N + 1];
		
		for (int i = 0; i < N; i++) {
			S[i + 1] = Integer.parseInt(strs[i]); // 대각선
		}
		
		C = Integer.parseInt(br.readLine());

	}
}
