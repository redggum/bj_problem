import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 5012번 불만 정렬 */

public class Main {

	static int N;
	static int[] tree;
	static int[] A;
	static long[] t1;
	static long[] t2;
	static long result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		N = Integer.parseInt(br.readLine());
		tree = new int[N + 1];
		A = new int[N + 1];
		t1 = new long[N + 1];
		t2 = new long[N + 1];
		result = 0;
		
		strs = br.readLine().split(" ");
		
		for (int i = 0; i < N; i++) {
			A[i + 1] = Integer.parseInt(strs[i]);
		}
		
		for (int i = 1; i <= N; i++) {
			t1[i] = sum(N) - sum(A[i]);
			update(A[i], 1);
		}
		
		Arrays.fill(tree, 0);
		
		for (int i = N; i > 0; i--) {
			t2[i] = sum(N) - sum(A[i]);
			update(A[i], 1);
		}			
		
		System.out.println("t1 : " + Arrays.toString(t1));
		System.out.println("t2 : " + Arrays.toString(t2));
		
		for (int i = 1; i <= N; i++) {
			result += t1[i] * t2[i];
		}
		
		System.out.println(result);
	}
	
	static long sum(int i) {
		long sum = 0;

		for (int x = i; x > 0; x -= (x & -x)) {
			sum += tree[x];
		}

		return sum;
	}

	static void update(int i, int val) {

		for (int x = i; x <= N; x += (x & -x)) {
			tree[x] += val;
		}

	}
}