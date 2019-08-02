import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 11660번 구간 합 구하기5 */

public class Main {

	static int N, M;
	static long[][] sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
	
		strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		sum = new long[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			strs = br.readLine().split(" ");
			
			for (int j = 1; j <= N; j++) {
				if (j == 1) {
					sum[i][j] = (sum[i - 1][N]) + Integer.parseInt(strs[j - 1]);
				} else {
					sum[i][j] = sum[i][j - 1] + Integer.parseInt(strs[j - 1]);
				}
				
//				System.out.println("sum[" + i + "][" + j + "] : " + sum[i][j]);
			}
		}
		
		int x1, y1, x2, y2;
		
		for (int i = 1; i <= M; i++) {
			strs = br.readLine().split(" ");
			x1 = Integer.parseInt(strs[0]);
			y1 = Integer.parseInt(strs[1]);
			x2 = Integer.parseInt(strs[2]);
			y2 = Integer.parseInt(strs[3]);
			
			if (y1 > 1) {
				System.out.println(sum[x2][y2] - sum[x1][y1 - 1]);
			} else {
				System.out.println(sum[x2][y2] - sum[x1 - 1][N]);
			}
		}
	}
}	