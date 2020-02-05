import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/* 2884번 알람 시계 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strs  = br.readLine().split(" ");
		int H = Integer.parseInt(strs[0]);
		int M = Integer.parseInt(strs[1]);
		int mH = 0;
		
		if (M - 45 < 0) {
			M = 60 - (45 - M);
			mH = 1;
			
			if (H - 1 < 0) {
				H = 23;
			} else {
				H -= mH;
			}
		} else {
			M -= 45;
		}
		
		System.out.println(H + " " + M);
	}
}
