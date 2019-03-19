import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 4344번 평균은 넘겠지 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		String[] strs;
		int N;
		ArrayList<Integer> arr;

		for (int t = 1; t <= T; t++) {
			strs = br.readLine().split(" ");
			N = Integer.parseInt(strs[0]);

			arr = new ArrayList<Integer>();
			int sum = 0;

			for (int i = 0; i < N; i++) {
				arr.add(Integer.parseInt(strs[i + 1]));
				sum += arr.get(i);
			}

			double avr = sum / N;
			double cnt = 0;
//			System.out.println("avr : " + avr);

			for (int i = 0; i < N; i++) {
				if (avr < arr.get(i)) {
					cnt++;
				}
			}

//			System.out.println("cnt : " + cnt);

			System.out.printf("%.3f", Math.round(cnt / N * 100000) / 1000.0);
			System.out.println("%");
		}
	}
}
