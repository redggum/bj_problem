import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1076번 저항 */

public class Main {

	static int M, N;	// 1 ≤ M <= N ≤ 10,000
	static int SUM = 0;
	static int MIN = Integer.MAX_VALUE;
	static int from = 0;
	static int to = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		M = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());

		from = (int) Math.sqrt(M);
		to = (int) Math.sqrt(N);
		
		int val = 0;
		
		for (int i = from; i <= to; i++) {
			val = i * i;
			if (val >= M) {
				SUM += val;
				if (MIN > val) {
					MIN = val;
				}
			}
		}
		
		if (SUM > 0) {
			System.out.println(SUM);
			System.out.println(MIN);
		} else {
			System.out.println(-1);
		}
	}
}
