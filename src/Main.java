import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1572번 중앙값 */

public class Main {

	static int N, K;
	static long[] tree;
	static int[] a;
	static int[] pos;
	static int[] idx;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		strs = br.readLine().split(" ");
		
		N = Integer.parseInt(strs[0]);
		K = Integer.parseInt(strs[1]);
		
		tree = new long[3 * N + 1];
		idx = new int[N + 1];
		a = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {			
			a[i] = Integer.parseInt(br.readLine());			
			update(a[i], 1);
		}
		
//		System.out.println(Arrays.toString(tree));
		
		long big, small = 0;
		int first = 1;
		int last = N;
		int first_mv = 1;
		int last_mv = 3 * N;
		int inc_first = 1;
		int inc_last = 1;
		
		long result = 0;
	}
	
	static long sum(int i) {
		long sum = 0;

		for (int x = i; x > 0; x -= (x & -x)) {
			sum += tree[x];
		}

//		System.out.println("zero_sum(" + i + ") : " + sum);
		return sum;
	}

	static void update(int i, int val) {

		for (int x = i; x <= 3 * N; x += (x & -x)) {
			tree[x] += val;
		}

//		System.out.println(Arrays.toString(tree));
	}
}