import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1712번 손익분기점 */

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		long A, B, C, tmpA, tmpB;

		strs = br.readLine().split(" ");

		A = Long.parseLong(strs[0]);
		B = Long.parseLong(strs[1]);
		C = Long.parseLong(strs[2]);

		// A + Bn < Cn
		// A < n (C - B)
		// A / (C - B) < n
		// A, B, C 는 21억 이하의 자연수

		tmpA = (C - B);

		if (tmpA == 0) {
			System.out.println(-1);
		} else {
			tmpB = A / tmpA;

			if (tmpB < 0) {
				System.out.println(-1);
			} else {
				System.out.println(tmpB + 1);
			}
		}

	}
}
