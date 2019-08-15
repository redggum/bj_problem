import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 10868번 최솟값 */

public class Main {

	static int N, M;
	static long[] tree;
	static int[] arr;
	
	static final long INF = Long.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		tree = new long[4 * N + 1];
		arr = new int[N + 1];
		int tmp;
		
		for (int i = 1; i <= N; i++) {
			tmp = Integer.parseInt(br.readLine());
			arr[i] = tmp;
		}
		
		init(1, 1, N);
		
//		System.out.println(Arrays.toString(tree));
		
		int a, b;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			System.out.println(m(1, 1, N, a, b));
		}
	}
	
	static long init(int node, int s, int e) {
		if (s == e) {
			return tree[node] = arr[s];
		}
		
		return tree[node] = min(init(node * 2, s, (s + e) / 2), init(node * 2 + 1, (s + e) / 2 + 1, e));
	}
	
	static void update(int node, int s, int e, int v, int d) {
		if (v < s || v > e) {
			return;
		}
		
		tree[node] += d;
		
		if (s != e) {
			update(node * 2, s, (s + e) / 2, v, d);
			update(node * 2 + 1, (s + e) / 2 + 1, e, v, d);
		}
	}
	
	static long m(int node, int s, int e, int l, int r) {
		if (l > e || r < s) {
			return INF;
		} else if (l <= s && e <= r) {
			return tree[node];
		}
		
		return min(m(node * 2, s, (s + e) / 2, l, r), m(node * 2 + 1, (s + e) / 2 + 1, e, l, r));
	}
	
	static long min(long a, long b) {
		if (a > b) return b;
		else return a;
	}
}	