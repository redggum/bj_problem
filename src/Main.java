import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 10868번 최솟값 */

public class Main {

	static int N, M;
	static long[] treeA;
	static long[] treeB;
	static int[] arr;
	
	static final long INF = Long.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		treeA = new long[4 * N + 1];
		treeB = new long[4 * N + 1];
		arr = new int[N + 1];
		int tmp;
		
		for (int i = 1; i <= N; i++) {
			tmp = Integer.parseInt(br.readLine());
			arr[i] = tmp;
		}
		
		initA(1, 1, N);
		initB(1, 1, N);
		
//		System.out.println(Arrays.toString(tree));
		
		int a, b;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			System.out.print(mA(1, 1, N, a, b) + " " + mB(1, 1, N, a, b));
			System.out.println();
		}
	}
	
	static long initA(int node, int s, int e) {
		if (s == e) {
			return treeA[node] = arr[s];
		}
		
		return treeA[node] = min(initA(node * 2, s, (s + e) / 2), initA(node * 2 + 1, (s + e) / 2 + 1, e));
	}
	
	static long initB(int node, int s, int e) {
		if (s == e) {
			return treeB[node] = arr[s];
		}
		
		return treeB[node] = max(initB(node * 2, s, (s + e) / 2), initB(node * 2 + 1, (s + e) / 2 + 1, e));

	}
	
	static long mA(int node, int s, int e, int l, int r) {
		if (l > e || r < s) {
			return INF;
		} else if (l <= s && r >= e) {
			return treeA[node];
		}
		
		return min(mA(node * 2, s, (s + e) / 2, l, r), mA(node * 2 + 1, (s + e) / 2 + 1, e, l, r));
	}
	
	static long mB(int node, int s, int e, int l, int r) {
		if (l > e || r < s) {
			return 0;
		} else if (l <= s && r >= e) {
			return treeB[node];
		}
		
		return max(mB(node * 2, s, (s + e) / 2, l, r), mB(node * 2 + 1, (s + e) / 2 + 1, e, l, r));
	}
	
	static long min(long a, long b) {
		if (a > b) return b;
		else return a;
	}
	
	static long max(long a, long b) {
		if (a > b) return a;
		else return b;
	}
}	