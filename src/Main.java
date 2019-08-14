import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSeparatorUI;

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
		
		tree = new long[4 * N + 1];
		arr = new int[N + 1];
		int tmp;
		
		for (int i = 1; i <= N; i++) {
			tmp = Integer.parseInt(br.readLine());
			arr[i] = tmp;
		}
		
		init(1, 1, N);
		
//		System.out.println(Arrays.toString(tree));
		
		int a, b, c;
		
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			switch(a) {
			case 1 :
				update(1, 1, N, b, c - arr[b]);
				arr[b] = c;
				break;
			case 2 :
				System.out.println(sum(1, 1, N, b, c));
				break;
			}
		}
	}
	
	static long init(int node, int s, int e) {
//		System.out.println("node : " + node + ", s : " + s + ", e : " + e);
		if (s == e) {
//			System.out.println("last one - node : " + node + ", s : " + s);
			return tree[node] = arr[s];
		}
		
		return tree[node] = init(node * 2, s, (s + e) / 2) + init(node * 2 + 1, (s + e) / 2 + 1, e);
	}
	
	static void update(int node, int s, int e, int target, int newVal) {
//		System.out.println("node : " + node + ", s : " + s + ", e : " + e + ", target : " + target + ", newVal : " + newVal);
		if (target < s || target > e) {
			return;
		}
		
		tree[node] += newVal;
		
		if (s != e) {
			update(node * 2, s, (s + e) / 2, target, newVal);
			update(node * 2 + 1, (s + e) / 2 + 1, e, target, newVal);
		}
	}
	
	static long sum(int node, int s, int e, int l, int r) {
		
		if (l > e || r < s) {
			return 0;
		}
		
		if (l <= s && r >= e) {
			return tree[node];
		}
		
		return sum(node * 2, s, (s + e) / 2, l, r) + sum(node * 2 + 1, (s + e) / 2 + 1, e, l, r);
	}
}	