import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/* 9461번 파도반 수열 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int N;
		long[] D;

		D = new long[100 + 1];
		
		D[1] = 1;
		D[2] = 1;
		D[3] = 1;
		D[4] = 2;
		D[5] = 2;
		
		for (int n = 6; n <= 100; n++) {
			D[n] = D[n - 1] + D[n - 5];
		}
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			System.out.println(D[N]);
		}
	}
}
