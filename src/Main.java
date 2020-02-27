import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2444번 별 찍기 - 7 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N;
		String star;
		int max;
		int space;
		int cnt;
		
		
		N = Integer.parseInt(br.readLine());
		
		max = (N * 2 - 1);
		
		
		for (int i = 1; i <= N; i++) {
			star = "";
			cnt = i * 2 - 1;
			space = (max - cnt) / 2;
			
			for (int j = 1; j <= space; j++) {
				star += " ";
			}
			
			for (int j = 1; j <= cnt; j++) {
				star += "*";
			}
			
			for (int j = 1; j <= space; j++) {
				star += " ";
			}
			
			System.out.printf("%s\n", star);
		}
		
		for (int i = N - 1; i >= 1; i--) {
			star = "";
			cnt = i * 2 - 1;
			space = (max - cnt) / 2;
			
			for (int j = 1; j <= space; j++) {
				star += " ";
			}
			
			for (int j = cnt; j >= 1; j--) {
				star += "*";
			}
			
			for (int j = 1; j <= space; j++) {
				star += " ";
			}
			
			System.out.printf("%s\n", star);
		}
	}
}
