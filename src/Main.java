import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 3006번 터보소트 */

public class Main {

	static int N;
	static long[] tree;
	static int[] a;
	static int[] pos;
	static int[] idx;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		tree = new long[3 * N + 1];
		idx = new int[N + 1];
		a = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {			
			a[i] = Integer.parseInt(br.readLine());
			idx[a[i]] = N + i;
			update(idx[a[i]], 1);
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

		for (int i = 1; i <= N; i++) {
			if (i % 2 == 1)	{ // odd, first
				System.out.println(sum(idx[first] - 1) - first + 1);
//				System.out.println("first - idx[" + first + "] : " + idx[first]);
				update(idx[first], -1);
//				System.out.println("first mv : " + Arrays.toString(tree));
				
				idx[first] = first_mv;
				update(idx[first], 1);
				first++;
				first_mv++;
				
//				System.out.println("first mv : " + Arrays.toString(tree));
			} else {	// last
				big = sum(3 * N);
				small = sum(idx[last]);
				
//				System.out.println("last - idx[" + last + "] : " + idx[last]);
				
//				System.out.println("big : " + big + ", small : " + small);
				
				result = big - small - inc_last + 1;
				System.out.println(result);
				
				update(idx[last], -1);
				
				idx[last] = last_mv;
				
				update(idx[last], 1);
				last--;
				last_mv--;
				inc_last++;
				
//				System.out.println("last mv : " + Arrays.toString(tree));
			}
			
		}
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