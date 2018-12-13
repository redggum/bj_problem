import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1074번 Z */

public class Main {

	static int N, r, c; // 1 <= N <= 15, 0 <= r, c <= 2^N-1
	static int n;
	static int[] X = { 0, 1, 0, 1 };
	static int[] Y = { 0, 0, 1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = null;

		strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		r = Integer.parseInt(strs[1]);
		c = Integer.parseInt(strs[2]);

		n = (int) Math.pow(2, N);
//		System.out.println(n);

		System.out.println(move(r, c) - 1);
	}

	public static long move(int row, int col) {
		int size = n;
		int nextRow = 0;
		int nextCol = 0;
		long cnt = 0;

		for (int y = 0; y < size; y += 2) {
			for (int x = 0; x < size; x += 2) {
				for (int z = 0; z < 4; z++) {
					nextRow = y + Y[z];
					nextCol = x + X[z];
					cnt++;

//					System.out.println("nextRow : " + nextRow + ", nextCol : " + nextCol + ", cnt : " + cnt);

					if (nextRow == row && nextCol == col) {
						return cnt;
					}
				}
			}
		}

		return cnt;
	}
}
