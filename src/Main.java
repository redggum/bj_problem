import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 11659번 구간 합 구하기 4 */

public class Main {

	static int N, M;
	static int[] A;
	static long[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;

		strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		A = new int[N + 1];
		tree = new long[N + 1];

		strs = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(strs[i - 1]);
			update(i, A[i]);
		}
		
		for (int m = 1; m <= M; m++) {			
			strs = br.readLine().split(" ");
			int i = Integer.parseInt(strs[0]);
			int j = Integer.parseInt(strs[1]);
			
			System.out.println(sum(j) - sum(i - 1));
		}
	}

	static long sum(int i) {
		long sum = 0;

		for (int x = i; x > 0; x -= (x & -x)) {
			sum += tree[x];
		}

		// System.out.println("sum(" + i + ", " + j + ") : " + sum);
		return sum;
	}

	static void update(int i, int val) {

		for (int x = i; x <= N; x += (x & -x)) {
			tree[x] += val;
		}
	}
}