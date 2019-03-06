import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2908번 상수 */

public class Main {

	static String[] strs;
	static String a, b;
	static int len = 0;
	static boolean trigger = false;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		strs = br.readLine().split(" ");
		
		a = strs[0].charAt(2) + "" + strs[0].charAt(1) + "" + strs[0].charAt(0);
		b = strs[1].charAt(2) + "" + strs[1].charAt(1) + "" + strs[1].charAt(0);
		
		
		
		for (int i = 0; i < 3; i++) {
			if (a.charAt(i) > b.charAt(i)) {
				System.out.println(a);
				break;
			} else if (a.charAt(i) < b.charAt(i)) {
				System.out.println(b);
				break;
			} else {
				continue;
			}
		}
	}
}