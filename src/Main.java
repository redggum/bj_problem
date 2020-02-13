import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2156번 포도주 시식 */

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[] val = new int[N + 1];
		int[] d = new int[N + 1];

		val[1] = Integer.parseInt(br.readLine());
		
		if (N == 1) {
			System.out.println(val[1]);
			return;
		}
		
		
		val[2] = Integer.parseInt(br.readLine());
		
		d[1] = val[1];
		d[2] = d[1] + val[2];
		
		int a, b, c;
		
		for (int i = 3; i <= N; i++) {
			val[i] = Integer.parseInt(br.readLine());
			
			a = d[i - 2] + val[i];
			b = d[i - 3] + val[i - 1] + val[i];
			c = d[i - 1];
			
//			System.out.println(a + ", " + b + ", " + c);
			
			d[i] = max(a, b);
			d[i] = max(c, d[i]);
		}
		
		System.out.println(d[N]);
	}
	
	public static int max(int a, int b) {
		if (a > b) {
			return a;
		} else {
			return b;
		}
	}
}