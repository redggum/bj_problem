import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 8958번 OX퀴즈 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 0;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int sum = 0;
			int cnt = 0;
			
			String[] strs = br.readLine().split("");
			
			for (int i = 0; i < strs.length; i++) {
				if (strs[i].equals("O")) {
					cnt++;
					sum += cnt;
				} else {
					cnt = 0;
				}
			}
			
			System.out.println(sum);
		}
		
	}
}
