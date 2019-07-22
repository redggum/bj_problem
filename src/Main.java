import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 2042번 구간 합 구하기 */

public class Main {

	static int N, M, K;
	static long[] tree;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		tree = new long[N + 1];
		arr = new int[N + 1];
		int tmp;
		
		for (int i = 1; i <= N; i++) {
			tmp = Integer.parseInt(br.readLine());
			update(i, tmp);
			arr[i] = tmp;
		}
		
		int a, b, c;
		
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			switch(a) {
			case 1 :
				update(b, c);
				break;
			case 2 :
				System.out.println(get(c) - get(b - 1));
				break;
			}
		}
	}
	
	static void update(int node, int newVal) {
		int tmp = node;
		long gap = newVal - arr[tmp];
		
		while(tmp <= N) {
			tree[tmp] += gap;
//			System.out.println("gap : " + gap + ", tmp : " + tmp + ", tree[" + tmp + "] : " + tree[tmp]);
			
			tmp += tmp & -(tmp);
			
		}
		
//		System.out.println(Arrays.toString(tree));
	}
	
	static long get(int node) {
		int tmp = node;
		long sum = 0;
		
		while(tmp > 0) {
			sum += tree[tmp];
			tmp -= tmp & -(tmp);
		}
		
		return sum;
	}
}	