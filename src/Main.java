import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 10250번 ACM 호텔 */

public class Main {
	static int T, H, W, N;
	static int[] arr;
	static int[] D;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			String[] strs = br.readLine().split(" ");
			
			H = Integer.parseInt(strs[0]);
			W = Integer.parseInt(strs[1]);
			N = Integer.parseInt(strs[2]);
			
			int x, y;
			
			x = N / H;
			y = N % H;
			
//			System.out.println("y : " + y);
//			System.out.println("x : " + x);
			
			if (y == 0) {
				y = H;
			} else {
				x = x + 1;
			}
			
			if (x < 10) {
				System.out.println(y + "0" + x);
			} else {
				System.out.println(y + "" + x);
			}
		}
	}
}
