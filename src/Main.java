import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1110번 더하기 사이클 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		int a = (num >= 10 ? num / 10 : 0);
		int b = num % 10;
		int c = 0;
		
		int cnt = 0;
		
		while (true) {
			c = (b * 10) + (a + b) % 10;
//			System.out.println("a : " + a + ", b : " + b + ", c : " + c);
			cnt++;
			if (c == num) {
				break;
			}
			
			a = (c >= 10 ? c / 10 : 0);
			b = c % 10;
		}
		
		System.out.println(cnt);
	}
}
