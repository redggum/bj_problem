import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.Arrays;

/* 10809번 알파벳 찾기 */

public class Main {

	static int[] pos = new int[26];
	static int index = -1;
	static String S;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Arrays.fill(pos, -1);
		
		S = br.readLine();

		for (int i = 0; i < S.length(); i++) {
			index = S.charAt(i) - 'a';
			
			if (pos[index] == -1) {
				pos[index] = i;
			}
		}
		
		for (int i = 0; i < pos.length; i++) {
			System.out.print(pos[i] + " ");
		}
	}
}