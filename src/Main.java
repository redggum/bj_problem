import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 2934번 LHR 식물 */

public class Main {

	static int N, L, R;
	static int[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		N = Integer.parseInt(br.readLine());
		tree = new int[100000 + 1];
		
		long sum1, sum2 = 0;
		
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			L = Integer.parseInt(strs[0]);
			R = Integer.parseInt(strs[1]);
			
			sum1 = sum(L);
			sum2 = sum(R);
			
			System.out.println(sum1 + sum2);
			
			update(L, (int)(0 - sum1));
			update(L + 1, (int)sum1);
			update(R, (int)(0 - sum2));
			update(R + 1, (int)sum2);
			
			update(L + 1, 1);
			update(R, -1);
		}
		
	}
	
	static long sum(int i) {
		long sum = 0;

		for (int x = i; x > 0; x -= (x & -x)) {
			sum += tree[x];
		}

		return sum;
	}

	static void update(int i, int val) {

		for (int x = i; x <= 100000; x += (x & -x)) {
			tree[x] += val;
		}

	}
}