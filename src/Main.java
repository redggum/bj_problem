import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1977번 완전제곱수 */

public class Main {

	static int M, N;	// 1 ≤ M <= N ≤ 10,000
	static final int SUM = 0;
	static final int MIN = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		M = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());

		System.out.println(SUM);
		System.out.println(MIN);
	}
}
