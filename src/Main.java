import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2839번 설탕 배달 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int comp1;
		int comp2;
		int[] d = new int[5001];
		// 5 kg - plastic bag
		// 3 kg - plastic bag
		// minimum bags to carry

//		d[1] = 0
//		d[2] = 0
//		d[3] = 1
//		d[4] = 0
//		d[5] = 1
//		d[6] = 2
//		d[7] = if (d[7-5] != 0) d[7-5] + 1 비교해서 작은 값으로 if (d[7-3] != 0) d[7-3] + 1;

		d[3] = 1;
		d[5] = 1;

		for (int i = 6; i <= n; i++) {
//			System.out.println("i : " + i);
			comp1 = Integer.MAX_VALUE;
			comp2 = Integer.MAX_VALUE;

			if (d[i - 5] != 0) {
//				System.out.println("d[" + (i - 5) + "] : " + d[i - 5]);
				comp1 = d[i - 5] + 1;
			}

			if (d[i - 3] != 0) {
//				System.out.println("d[" + (i - 3) + "] : " + d[i - 3]);
				comp2 = d[i - 3] + 1;
			}

//			System.out.println("comp1 : " + comp1 + ", comp2 : " + comp2);

			if (comp1 == Integer.MAX_VALUE && comp2 == Integer.MAX_VALUE) {
				d[i] = 0;
			} else {
				d[i] = (comp1 > comp2 ? comp2 : comp1);
			}
		}

		if (d[n] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(d[n]);
		}
	}
}
