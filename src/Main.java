import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1072번 게임 */

public class Main {

	static long X, Y, Z, found = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;

		strs = br.readLine().split(" ");
		X = Long.parseLong(strs[0]);
		Y = Long.parseLong(strs[1]);
		
		// Z = Y / X * 100
		// Z = 8 / 10 * 100 = 80
		// Z + 1 = 9 / 10 * 100 = 90
		
		// Z = Y * 100 / X
		// Z = 8 * 100 / 10 = 80
		// Z < (Y + K) * 100 / (X + K)
		// 80 < 9 * 100 / 10 = 90
		// (Z + 1) * X / 100 - Y = K
		// (Y * 100 / X + 1) * X / 100 - Y = K
		// (8 * 100 / 10 + 1) * 10 / 100 - 8 = 
		
		Z = Y * 100 / X;
//		System.out.println("Z : " + Z);
		
//		for (long i = 1; i <= 1000000000; i++) {
//			if (Z < ((Y + i) * 100) / (X + i)) {
//				found = i;
//				break;
//			}
//		}

		binSearch(1, 1000000000);
		
		if (found > 0) {
			System.out.println(found);
		} else {
			System.out.println(-1);
		}
	}
	
	static void binSearch(long start, long end) {
		long s = start;
		long e = end;
		long mid = (e + s) / 2;
		
		long calc = ((Y + mid) * 100) / (X + mid);
		
		System.out.println("s : " + s + ", e : " + e + ", mid : " + mid);
		System.out.println("calc : " + calc);
		
		if (Z + 1 == calc) {
			found = mid;
			return;
		} else if (Z + 1 < calc) {
			System.out.println("s : " + s + ", mid - 1 : " + (mid - 1));
			binSearch(s, mid);
		} else {
			System.out.println("mid + 1 : " + (mid + 1) + ", end : " + end);
			binSearch(mid, end);
		}
	}
}
