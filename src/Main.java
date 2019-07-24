import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 10999번 구간 합 구하기2 */

public class Main {

	static int N, M, K;
	static long[] tree;
	static long[] tp, tn;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		tree = new long[N + 1];
		tp = new long[N + 1];
		tn = new long[N + 1];
		arr = new int[N + 1];
		int tmp;
		
		for (int i = 1; i <= N; i++) {
			tmp = Integer.parseInt(br.readLine());
			point_update(i, tmp);
//			range_update(i, i, tmp);
		}
		
//		System.out.println(Arrays.toString(tree));
		
		int a, b, c, d;
		
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			switch(a) {
			case 1 :
				d = Integer.parseInt(st.nextToken());
				range_update(b, c, d);
//				System.out.println(Arrays.toString(tp));
//				System.out.println(Arrays.toString(tn));
				break;
			case 2 :
//				System.out.println(range_sum(b, c));
//				System.out.println(point_sum(c) - point_sum(b - 1));
				
				System.out.println(range_sum(b, c) + point_sum(c) - point_sum(b - 1));
				break;
			}
		}
	}
	
	static void update(int pos, int p, int n) {
		
		while(pos <= N) {
			tp[pos] += p;
			tn[pos] += n;
			
			pos += (pos & -(pos));
			
//			System.out.println("next pos : " + pos);
		}
	}
	
	static void point_update(int pos, int v) {
		
		while(pos <= N) {
			tree[pos] += v;
			
			pos += (pos & -(pos));
			
//			System.out.println("next pos : " + pos);
		}
	}
	
	static void range_update(int s, int e, int v) {
		update(s, v, -(v) * (s - 1));
		update(e + 1, -(v), v * e);
	}
	
	static long range_sum(int s, int e) {
		return sum(e) - sum(s - 1);
	}
	
	static long point_sum(int pos) {
		int tmp = pos;
		int sum = 0;
		
		while(tmp > 0) {
			sum += tree[tmp];	
			tmp -= (tmp & -(tmp));
			
//			System.out.println("next tmp : " + tmp);
		}
		
		return sum;
	}
	
	static long sum(int pos) {
		long p = 0, n = 0;
		int tmp = pos;
		
		while(tmp > 0) {
			p += tp[tmp];
			n += tn[tmp];
					
			tmp -= (tmp & -(tmp));
			
//			System.out.println("next tmp : " + tmp);
		}
		
		return pos * p + n;
	}
}	