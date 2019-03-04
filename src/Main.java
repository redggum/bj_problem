import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.Arrays;

/* 2675번 문자열 반복 */

public class Main {

	static String S;
	static String[] strs;
	static int T;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			strs = br.readLine().split(" ");
			
			cnt = Integer.parseInt(strs[0]);
			S = strs[1];
			
			for (int i = 0; i < S.length(); i++) {
				for (int j = 0; j < cnt; j++) {
					System.out.print(S.charAt(i));
				}
			}
		}
	}
}