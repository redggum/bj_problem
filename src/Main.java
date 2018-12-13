import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1075번 나누기 */

public class Main {

	static long N, F; // 100 <= N <= 2,000,000,000, 1 <= F <= 100
	static long s;
	static long v;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Long.parseLong(br.readLine());
		F = Long.parseLong(br.readLine());
		
		s = (N / 100) * 100;
		
		for (v = s; v < s + 100; v++) {
			if (v % F == 0) {
				break;
			}
		}
		
		String str = String.valueOf(v);
		System.out.println(str.substring(str.length() - 2, str.length()));
	}
}
