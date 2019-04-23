import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2490번 윷놀이 */

public class Main {
	static int N, K;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		int[] yut = new int[4];
		int cnt;

		for (int i = 0; i < 3; i++) {
			strs = br.readLine().split(" ");

			yut[0] = Integer.parseInt(strs[0]);
			yut[1] = Integer.parseInt(strs[1]);
			yut[2] = Integer.parseInt(strs[2]);
			yut[3] = Integer.parseInt(strs[3]);

			cnt = 0;

			for (int j = 0; j < yut.length; j++) {
				if (yut[j] == 0) {
					cnt++;
				}
			}

			switch (cnt) {
			case 0:
				System.out.println('E');
				break;
			case 1:
				System.out.println('A');
				break;
			case 2:
				System.out.println('B');
				break;
			case 3:
				System.out.println('C');
				break;
			case 4:
				System.out.println('D');
			}
		}
	}
}
