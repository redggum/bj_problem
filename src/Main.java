import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 16404번 주식회사 승범이네 */

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
	
	static long init(int node, int s, int e) {
	}
	
	static long sum(int node, int s, int e, int l, int r) {
	}
	
	static long update(int node, int s, int e, int v, int t) {
		
	}
	
}	