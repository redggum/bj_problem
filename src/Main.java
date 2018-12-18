import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1297번 TV 크기 */

public class Main {

	static int T = 0; // 1 <= T < 100
	static int V, E = 0; // 4 <= V, E <= 100

	// V - E + S (surface) = 2

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String[] strs = br.readLine().split(" ");

			V = Integer.parseInt(strs[0]);
			E = Integer.parseInt(strs[1]);

			System.out.println(2 - V + E);
		}
	}
}
