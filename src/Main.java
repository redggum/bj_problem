import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.Arrays;

/* 1157번 단어 공부 */

public class Main {

	static String S;
	static String[] strs;
	static int[] freqAlphabet = new int[26];	// Upper, lower diff = 32
	static int ascii;
	static char max;
	static int maxAlphabetIndex = -1;
	static int maxCnt = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		
		for (int i = 0; i < S.length(); i++) {
			ascii = (int) (S.charAt(i) - 'A');
			
			if (ascii >= 32) {
				ascii -= 32;
			}
			
			freqAlphabet[ascii]++;
//			System.out.println("ascii : " + ascii);
		}
		
		for (int i = 0; i < freqAlphabet.length; i++) {
			if (freqAlphabet[i] > 0 && freqAlphabet[i] > maxCnt) {
				maxCnt = freqAlphabet[i];
				max = (char) (i + (int) 'A');
				maxAlphabetIndex = i;
				
//				System.out.println("maxAlphabetIndex : " + maxAlphabetIndex);
			}
		}
		
		for (int i = 0; i < freqAlphabet.length; i++) {
			if (maxCnt == freqAlphabet[i] && maxAlphabetIndex != i) {
				max = '?';
				break;
			}
		}
		
		System.out.println(max);
	}
}