import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2903번 중앙 이동 알고리즘 */

public class Main {

	static int[] alphabet1 = new int[26];	// <= 26
	static int[] alphabet2 = new int[26]; // <= 26
	
	static int cnt_1 = 0;
	static int cnt_2 = 0;
	static int cnt_common = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] strs = br.readLine().split("");
//		cnt_1 = strs.length;
		check(strs, alphabet1);
		
		strs = br.readLine().split("");
//		cnt_2 = strs.length;
		check(strs, alphabet2);
		
		for (int i = 0; i < alphabet1.length; i++) {
//			System.out.println("alphabet1[" + i + "] : " + alphabet1[i] + ", alphabet2[" + i + "] : " + alphabet2[i]);
			/*if (alphabet1[i] != 0 && alphabet2[i] != 0) {
				if (alphabet1[i] != alphabet2[i]) {
					cnt_common += Math.abs(alphabet1[i] - alphabet2[i]);
				} else {
					cnt_common += alphabet1[i];
				}
			}*/
			
			if (alphabet1[i] != 0 && alphabet2[i] != 0) {
				if (alphabet1[i] != alphabet2[i]) {
					if (alphabet1[i] - alphabet2[i] > 0) {
						cnt_1 += Math.abs(alphabet1[i] - alphabet2[i]);
					} else {						
						cnt_2 += Math.abs(alphabet1[i] - alphabet2[i]);
					}
				}
			} else {
				if (alphabet1[i] != 0 && alphabet2[i] == 0) {
					cnt_1 += alphabet1[i]; 
				}
				
				else if (alphabet1[i] == 0 && alphabet2[i] != 0) {
					cnt_2 += alphabet2[i]; 
				}
			}
		
//			System.out.println("cnt_1 : " + cnt_1 + ", cnt_2 : " + cnt_2);
		}
		
//		System.out.println("cnt_1 : " + cnt_1 + ", cnt_2 : " + cnt_2 + ", cnt_common : " + cnt_common);
//		System.out.println((cnt_1 - cnt_common) + (cnt_2 - cnt_common));
		System.out.println(cnt_1 + cnt_2);
	}
	
	public static void check(String[] strs, int[] alphabet) {
		int idx = 0;
		
		for (int i = 0; i < strs.length; i++) {
			idx = strs[i].charAt(0) - 'a';
//			System.out.println("idx : " + idx);
			alphabet[idx]++;
		}
	}
}
