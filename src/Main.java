import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1978번 소수 찾기 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
		int cnt = 0;

		N = Integer.parseInt(br.readLine());

		String[] strs = br.readLine().split(" ");

		for (int i = 0; i < strs.length; i++) {
			if (checkPrimeNum(Integer.parseInt(strs[i]))) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	static boolean checkPrimeNum(int n) {
		if (n == 1) {
			return false;
		}
		
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}
}
