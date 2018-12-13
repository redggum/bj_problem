import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1789번 수들의 합 */

public class Main {

	static long S; // 1 ≤ S ≤ 4,294,967,295
	static long sub = 1;
	static long cnt = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = Long.parseLong(br.readLine());
		
		if (S == 1) {
			System.out.println(1);
			return;
		}

		while (S - sub > 0) {
			S -= sub;
			cnt++;
			sub++;
		}
		
		System.out.println(cnt);
	}
}
