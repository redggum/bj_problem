import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 11047번 동전 0 */

public class Main {
	static int DIV = 42;
	static int[] coin;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		int N, K;

		N = Integer.parseInt(strs[0]);
		K = Integer.parseInt(strs[1]);
		
		coin = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(count(N, K));
	}
	
	static int count(int idx, int k) {
		if (idx == 0 || k == 0) {
			return 0;
		}
		
		int val = k / coin[idx];
		if (0 == val) {
			return count(idx - 1, k);
		}
		
		return val + count(idx - 1, k - val * coin[idx]);
	}
}