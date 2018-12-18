import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1297번 TV 크기 */

public class Main {

	static int A, B, C = 0; // 5 <= A < 1000, 1 <= B <= 99, 2 <= C <= 100, C > B
	static int H, W = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] strs = br.readLine().split(" ");

		A = Integer.parseInt(strs[0]); // 대각선
		B = Integer.parseInt(strs[1]); // 높이 비율
		C = Integer.parseInt(strs[2]); // 너비 비율

		// H^2 + W^2 = A^2
		// B : C = H : W -> C * H = B * W
		// H = Bx, W = Cx
		// Bx^2 + Cx^2 = A^2
		// B^2 * x^2 + C^2 * x^2 = A^2
		// (B^2 + C^2) * x^2 = A^2

		double tmp = Math.pow((double) A, 2) / (Math.pow((double) B, 2) + Math.pow((double) C, 2));

		tmp = Math.sqrt(tmp);
		
		System.out.println((int) (B * tmp) + " " + (int) (C * tmp));
	}
}
