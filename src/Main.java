import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.Arrays;

/* 1316번 그룹 단어 체크 */

public class Main {

	static String S;
	static String[] strs;
	static int[] alphabet;
	static int T;
	static int total = 0;
	static boolean failed;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		int index = 0;
		
		for (int tc = 1; tc <= T; tc++) {
			strs = br.readLine().split("");
			
			failed = false;
			
			total++;
			alphabet = new int[26];
			
			for (int i = 0; i < strs.length; i++) {
//				System.out.println("word : " + strs[i]);
				index = strs[i].charAt(0) - 'a';
				
//				System.out.println("alphabet[" + index + "] : " + alphabet[index]);
				
				if (alphabet[index] == 0 || i == 0) {
					alphabet[index] = 1;
					continue;
				} else {
//					System.out.println("strs[i - 1].charAt(0) - 'a' : " + (strs[i - 1].charAt(0) - 'a'));
					if (strs[i - 1].charAt(0) - 'a' == index) {
						continue;
					} else {
						total--;
						break;
					}
				}
			}
			
//			System.out.println("total : " + total);
		}
		
		System.out.println(total);
	}
}