import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2864번 5와 6의 차이 */

public class Main {

	static long A, B; // A, B <= 1,000,000
	static long minA, minB, maxA, maxB;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		A = Long.parseLong(strs[0]);
		B = Long.parseLong(strs[1]);

		String str1 = String.valueOf(A);
		String str2 = String.valueOf(B);

		minA = Long.parseLong(str1.replaceAll("6", "5"));
		minB = Long.parseLong(str2.replaceAll("6", "5"));

		maxA = Long.parseLong(str1.replaceAll("5", "6"));
		maxB = Long.parseLong(str2.replaceAll("5", "6"));
		
		System.out.println((minA + minB) + " " + (maxA + maxB));
	}
}
