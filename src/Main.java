import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 14502번 연구소 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
		int[] T;
		int[] P;
		int[] D;
		int max;
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		T = new int[N];
		P = new int[N];
		D = new int[N + 1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i <= N; i++) {
			if (i == 0)
			{
				continue;
			}
			
			max = 0;
			for (int j = 0; j < i; j++) {
//				System.out.println("i : " + i + ", j : " + j + ", T[" + j + "] : " + T[j]);
				if (max < D[j]) {
					max = D[j];
				}
				
				if (j + T[j] == i && max < D[j] + P[j]) {
					max = D[j] + P[j];
//					System.out.println("max : " + max);
				}
				
				D[i] = max;
//				System.out.println("D[" + i + "] : " + D[i]);
			}
		}
		
		System.out.println(D[N]);
	}
}	