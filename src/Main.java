import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1357번 뒤집힌 덧셈 */

public class Main {

	static int X, Y;	// X, Y <= 1,000
	static long DIV = 15746;
	static long sum = 0;
	static long[] D;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		
		X = Integer.parseInt(strs[0]);
		Y = Integer.parseInt(strs[1]);
		
		System.out.println(Rev(Rev(X) + Rev(Y)));
	}
	
	static int Rev(int frd) {
		String[] strs = String.valueOf(frd).split("");
		String tmp;
		String ret = "";
		int len = strs.length;
		for (int i = 0; i < len / 2; i++) {
			tmp = strs[i];
			strs[i] = strs[len - 1 - i];
			strs[len - 1 - i] = tmp;
		}

		for (int i = 0; i < len; i++) {
			ret += strs[i];
		}
		
		return Integer.parseInt(ret);
	}
	
}
