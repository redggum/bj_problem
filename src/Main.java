import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 11006번 남욱이의 닭장 */

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		int T, N, M, normal, abnormal;
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			strs = br.readLine().split(" ");
			N = Integer.parseInt(strs[0]);
			M = Integer.parseInt(strs[1]);

			// 2 * M = (N + K) // K -> 잃어버린 다리 개수
			// M = (N + K) / 2
			// K = 2M - N 
			// abnormal = (2M - N)
			// normal = M - abnormal
			
			abnormal = 2 * M - N;
			normal = M - abnormal;
			
			System.out.println(abnormal + " " + normal);
		}
	}
}
