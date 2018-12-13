import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1107번 리모컨 */

public class Main {

	static int N; // 0 <= N <= 500,000
	static int M; // 0 <= N <= 10
	static int S = 100;
	static boolean[] brokenBtn = new boolean[10];
	static int cnt = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		String[] strs = br.readLine().split(" ");
		
		for (int i = 0; i < strs.length; i++) {
			brokenBtn[Integer.parseInt(strs[i])] = true;
		}
		
		
	}
}
