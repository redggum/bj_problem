import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/* 1934번 최소공배수 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		String[] strs;
		int a, b;
		
		for (int tc = 1; tc <= T; tc++) {
			strs = br.readLine().split(" ");
			a = Integer.parseInt(strs[0]);
			b = Integer.parseInt(strs[1]);

			System.out.println(a * b / gcd(a, b));
		}
	}
	
	static int gcd(int a, int b){
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

}
