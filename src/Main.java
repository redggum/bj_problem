import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 10872번 팩토리얼 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		if (N == 0) {
			System.out.println(1);
		} else {
			System.out.println(facto(N));
		}
	}
	
	static long facto(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * facto(n - 1);
		}
	}
}