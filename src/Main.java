import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 3640번 제독 */

public class Main {

	static String T;
	static int[] pi;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = br.readLine();

		char[] tc = T.toCharArray();

		pi = new int[T.length()];

		for (int i = 0; i < tc.length; i++) {
			Arrays.fill(pi, 0);
			calcPI(T.substring(i, T.length()));
		}

		System.out.println(max);

	}

	static void calcPI(String pattern) {
		char[] p = pattern.toCharArray();
//		System.out.println(p);

		int j = 0;

		for (int i = 1; i < pattern.length(); i++) {
			while (j > 0 && p[j] != p[i]) {
				j = pi[j - 1];
			}

			if (p[j] == p[i]) {
				pi[i] = ++j;

				max = (max < pi[i]) ? pi[i] : max;
			}
		}
	}

}
