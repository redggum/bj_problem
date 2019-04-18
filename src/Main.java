import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/* 1929번 소수 구하기 */

public class Main {
	static int M, N;
	static int[] arr;
	static int[] D;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] strs = br.readLine().split(" ");

		M = Integer.parseInt(strs[0]);
		N = Integer.parseInt(strs[1]);

		boolean[] num = new boolean[N + 1];

		Arrays.fill(num, true);

		num[1] = false;

		// i's mul
		for (int i = 2; (i * i) <= N; i++) {
			for (int j = i * i; j <= N; j += i) {
				num[j] = false;
			}
		}

		for (int i = M; i <= N; i++) {
			if (num[i] == true) {
				System.out.println(i);
			}

		}
	}
}
