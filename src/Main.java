import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 1152번 단어의 개수 */

public class Main {

	static String[] strs;
	static int len = 0;
	static boolean trigger = false;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String c;
		int cnt = 0;

		for (int i = 0; i < s.length(); i++) {
			c = String.valueOf(s.charAt(i));
			
			if (c.equals(" ")) {
				trigger = false;
			} else {
				if (trigger == false) {
					cnt++;
					trigger = true;
				}
			}
		}
		
		System.out.println(cnt);
	}
}