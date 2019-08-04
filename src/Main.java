import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 5676번 음주 코딩 */

public class Main {

	static int N, K;
	static long[] treeZ;
	static long[] treeM;
	static int[] A;
	static int[] pos;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;

		while (true) {
			strs = br.readLine().split(" ");

			N = 0;

			if (strs == null || "".equals(strs[0])) {
				return;
			}

			N = Integer.parseInt(strs[0]);
			K = Integer.parseInt(strs[1]);

			treeZ = new long[N + 1];
			treeM = new long[N + 1];
			A = new int[N + 1];
			pos = new int[N + 1];

			strs = br.readLine().split(" ");
			
			int tmp = 0;

			for (int n = 0; n < N; n++) {
				tmp = Integer.parseInt(strs[n]);
				if (tmp != 0) {
					m_update(n + 1, tmp);
					A[n + 1] = tmp;
				} else {
					A[n + 1] = -1;
					zero_update(n + 1, 0);
					A[n + 1] = 0;
				}
			}

			int i, j, v;

			for (int k = 0; k < K; k++) {
				strs = br.readLine().split(" ");
				if ("C".equals(strs[0])) {
					i = Integer.parseInt(strs[1]);
					v = Integer.parseInt(strs[2]);

					zero_update(i, v);
					m_update(i, v);

					A[i] = v;
				} else {
					i = Integer.parseInt(strs[1]);
					j = Integer.parseInt(strs[2]);

					
					long tmp1 = zero_sum(j) - zero_sum(i - 1);
//					System.out.println("tmp1 : " + tmp1);

					if (tmp1 > 0) {
						System.out.print(0);
					} else {
						long tmp2 = m_sum(j) - m_sum(i - 1);
//						System.out.println("tmp2 : " + tmp2);

						if (tmp2 % 2 == 0) {
							System.out.print("+");
						} else {
							System.out.print("-");
						}
					}
				}
			}

			System.out.println();
		}
	}

	static long zero_sum(int i) {
		long sum = 0;

		for (int x = i; x > 0; x -= (x & -x)) {
			sum += treeZ[x];
		}

//		System.out.println("zero_sum(" + i + ") : " + sum);
		return sum;
	}

	static void zero_update(int i, int val) {
		int tmp = 1;

		if (val != 0 && A[i] != 0) {
			return;
		}

		if (val != 0 && A[i] == 0) {
			tmp = -1;
		}

		for (int x = i; x <= N; x += (x & -x)) {
			treeZ[x] += tmp;
		}

//		System.out.println(Arrays.toString(treeZ));
	}

	static long m_sum(int i) {
		long sum = 0;

		for (int x = i; x > 0; x -= (x & -x)) {
			sum += treeM[x];
		}

		// System.out.println("sum(" + i + ", " + j + ") : " + sum);
		return sum;
	}

	static void m_update(int i, int val) {
		int tmp = 1;
		
//		System.out.println("m_update() => i : " + i + ", val : " + val + ", A[" + i + "] : " + A[i]);
		
		if (val >= 0 && A[i] >= 0) {
			return;
		}
		
		if (val >= 0 && A[i] < 0) {
			tmp = -1;
		}
		
		if (val < 0 && A[i] < 0) {
			return;
		}

		for (int x = i; x <= N; x += (x & -x)) {
			treeM[x] += tmp;
		}
		
//		System.out.println(Arrays.toString(treeM));
	}
}