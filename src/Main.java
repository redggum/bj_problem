import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 11658번 구간 합 구하기 3 */

public class Main {

	static int N, M;
	static int[][] A;
	static long[][] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;

		strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		A = new int[N + 1][N + 1];
		tree = new long[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			strs = br.readLine().split(" ");

			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(strs[j - 1]);
				update(i, j, A[i][j]);
			}
		}
		
//		for (int i = 1; i <= N; i++) {
//			System.out.println(Arrays.toString(tree[i]));
//		}

		int c, a, b, v, tmp, x1, y1, x2, y2;

		for (int i = 1; i <= M; i++) {
			strs = br.readLine().split(" ");
			c = Integer.parseInt(strs[0]);

			if (c == 0) {
				a = Integer.parseInt(strs[1]);
				b = Integer.parseInt(strs[2]);
				v = Integer.parseInt(strs[3]);

				tmp = A[a][b];
				A[a][b] = v;

				update(a, b, v - tmp);
			} else {
				x1 = Integer.parseInt(strs[1]);
				y1 = Integer.parseInt(strs[2]);
				x2 = Integer.parseInt(strs[3]);
				y2 = Integer.parseInt(strs[4]);

				System.out.println(sum(x2, y2) - sum(x2, y1 - 1) - sum(x1 - 1, y2) + sum(x1 - 1, y1 - 1));
			}

		}
	}

	static long sum(int i, int j) {
		long sum = 0;
		
		for (int x = i; x > 0; x -= (x & -x)) {
			for (int y = j; y > 0; y -= (y & -y)) {
				sum += tree[x][y];
			}			
		}

//		System.out.println("sum(" + i + ", " + j + ") : " + sum);
		return sum;
	}

	static void update(int i, int j, int val) {

		for (int x = i; x <= N; x += (x & -x)) {
			for (int y = j; y <= N; y += (y & -y)) {
				tree[x][y] += val;
			}			
		}
	}
}