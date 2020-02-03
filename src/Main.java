import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 11021번 A+B - 7 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;

		int a, b;

		int CASE = Integer.parseInt(br.readLine());

		for (int i = 1; i <= CASE; i++) {
			strs = br.readLine().split(" ");

			a = Integer.parseInt(strs[0]);
			b = Integer.parseInt(strs[1]);

			System.out.println("Case #" + i + ": " + (a + b));
		}
	}
}
