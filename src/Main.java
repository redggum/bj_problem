import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 3653번 영화 수집 */

public class Main {

	static int T, N, M;
	static long[] tree;
	static int[] pos;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		T = Integer.parseInt(br.readLine());
		
		int tmp = 0;
	
		for (int tc = 0; tc < T; tc++) {
			strs = br.readLine().split(" ");
			N = Integer.parseInt(strs[0]);
			M = Integer.parseInt(strs[1]);
			
			tree = new long[M + N + 1];
			pos = new int[N + 1];
			
			for (int i = 1; i <= N; i++) {
				update(M + i, 1);
				pos[i] = M + i;
			}
			
//			System.out.println(Arrays.toString(tree));
				
			strs = br.readLine().split(" ");
			
			for (int m = 0; m < M; m++) {
				tmp = Integer.parseInt(strs[m]);
				
				// System.out.println("tmp : " + tmp);
				
				// how many DVDs are on top of DVD which is picked up?
				System.out.print(sum(pos[tmp] - 1) + " ");
				
				// move picked DVD to on top of stack (also update fenwick tree)
				update(pos[tmp], -1);
				pos[tmp] = M - m;
				update(pos[tmp], 1);
			}
			
			System.out.println();
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

		for (int x = i; x <= N + M; x += (x & -x)) {
			tree[x] += val;
		}
	}
}