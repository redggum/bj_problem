import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2751번 수 정렬하기 2 */

public class Main {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		int[] minus = new int[1000000 + 1];
		int[] plus = new int[1000000 + 1];
		int num = 0;

		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(br.readLine());

			if (num < 0) {
				minus[Math.abs(num)] = 1;
			} else {
				plus[num] = 1;
			}
		}

		for (int i = 1000000; i > 0; i--) {
			if (minus[i] == 1) {
				System.out.println(0 - i);
			}
		}
		
		for (int i = 0; i <= 1000000; i++) {
			if (plus[i] == 1) {
				System.out.println(i);
			}
		}
	}
}