import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2941번 크로아티아 알파벳 */

public class Main {
	static int N, K;
	static String[] two = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=", "dz" };
	static String three = "dz=";

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] letters = br.readLine().split("");
		int cnt = 0;
		boolean found;
		String compare;

		for (int i = 0; i < letters.length; i++) {
			found = false;
//			System.out.println("i : " + i);
			if (i + 1 < letters.length) {
				compare = letters[i] + letters[i + 1];
//				System.out.println("compare : " + compare);
				for (String word : two) {
					if (word.equals(compare)) {
						if (two[8].equals(compare)) {
							if (i + 2 < letters.length && three.equals(compare + letters[i + 2])) {
								i++;
//								System.out.println("three");
							} else {
								break;
							}
						}

						cnt++;
						found = true;
						i++;

//						System.out.println("matched : " + compare);
						break;
					}
				}

				if (found == false) {
					cnt++;
				}
			} else {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
