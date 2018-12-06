import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2914번 저작권 */

public class Main {

	static int A, B, C;	// 0 < A < B < C < 100
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strs = br.readLine().split(" ");
		
		A = Integer.parseInt(strs[0]);
		B = Integer.parseInt(strs[1]);
		C = Integer.parseInt(strs[2]);
		
		System.out.println(B - A - 1 > C - B - 1 ? B - A - 1 : C - B - 1);
	}
}
