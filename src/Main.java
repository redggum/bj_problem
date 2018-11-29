import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1476번 날짜 계산 */

public class Main {

	static int E, S, M;	// 1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19
	static final int E_MOD = 15;
	static final int S_MOD = 28;
	static final int M_MOD = 19;
	static int year = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		strs = br.readLine().split(" ");
		E = Integer.parseInt(strs[0]);
		S = Integer.parseInt(strs[1]);
		M = Integer.parseInt(strs[2]);

		year = E;
		
		while(true) {
//			System.out.println("year : " + year);
			if ( ((year % S_MOD == S) || (year % S_MOD == 0 && S_MOD == S)) && 
					(year % M_MOD == M || (year % M_MOD == 0 && M_MOD == M)) ) {
//				System.out.println("Find!!");
				break;
			}
			
			year += E_MOD;
		}
		
		System.out.println(year);
	}
}
