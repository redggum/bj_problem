import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 9550번 아이들은 사탕을 좋아해 */

public class Main {

	static int T = 0; // 1 <= T <= 100
	static int N, K = 0; // 1 <= N, K <= 100
	static int[] arr;
	static int[] comp;
	static int[] sol;
	static int sol_idx = 0;
	static boolean[] visited;
	static int order = 0;
	static int candy[];
	static int sum;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;

		T = Integer.parseInt(br.readLine());


		for (int tc = 1; tc <= T; tc++) {
			strs = br.readLine().split(" ");
			
			N = Integer.parseInt(strs[0]);
			K = Integer.parseInt(strs[1]);

			candy = new int[N];
			sum = 0;
			
			strs = br.readLine().split(" ");
			
			for (int i = 0; i < strs.length; i++) {
				candy[i] = Integer.parseInt(strs[i]);
				sum += (candy[i] / K);
			}
			
			System.out.println(sum);
		}
	}
}
