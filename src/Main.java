import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1057번 토너먼트 */

public class Main {

	static int N;	// 1 ≤ M <= N ≤ 100,000
	static int KIM;
	static int IM;
	static int final_round = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strs = br.readLine().split(" ");
		
		N = Integer.parseInt(strs[0]);
		KIM = Integer.parseInt(strs[1]);
		IM = Integer.parseInt(strs[2]);
		
		while(KIM != IM) {
			KIM = KIM / 2 + KIM % 2;
			IM = IM / 2 + IM % 2;
			final_round++;
		}
		
		System.out.println(final_round);
	}
}
