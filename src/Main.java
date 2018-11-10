import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 1658번 돼지 잡기 */

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M, N;
		int maxSoldPigsCnt = 0;

		M = Integer.parseInt(st.nextToken());	// pigpen
		N = Integer.parseInt(st.nextToken());	// customer
		
		int[] pigCnt = new int[M];
		int[] pigWantCnt = new int[M];
		int[] pmPigCnt = new int[M];
		int[][] customerInput = new int[N][M + 2];
		
		String[] strs = br.readLine().split(" ");
		
		for (int i = 0; i < M; i++) {
			pigCnt[i] = Integer.parseInt(strs[i]);
		}		
		
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			
			customerInput[i][0] = Integer.parseInt(strs[0]);
			customerInput[i][customerInput[i][0] + 1] = Integer.parseInt(strs[customerInput[i][0] + 1]);
			
			for (int j = 1; j <= customerInput[i][0]; j++) {
				customerInput[i][j] = Integer.parseInt(strs[j]);
				pigWantCnt[customerInput[i][j] - 1] += customerInput[i][customerInput[i][0] + 1];
			}
		}
		
		for (int i = 0; i < M; i++) {
			pmPigCnt[i] = pigCnt[i] - pigWantCnt[i];
		}
		
		int calc = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= customerInput[i][0]; j++) {
				calc = pigCnt[i] - customerInput[i][j];
				
				if (calc >= 0) {
					pigCnt[i] -= customerInput[i][j];
				} else {
					pmPigCnt[i] -= calc;
					pigCnt[i] = 0;
				}
			}
		}
	
	}

	static void calcPI(String pattern) {
		char[] p = pattern.toCharArray();
//		System.out.println(p);

		int j = 0;

		for (int i = 1; i < pattern.length(); i++) {
			while (j > 0 && p[j] != p[i]) {
				j = pi[j - 1];
			}

			if (p[j] == p[i]) {
				pi[i] = ++j;

				max = (max < pi[i]) ? pi[i] : max;
			}
		}
	}

}
