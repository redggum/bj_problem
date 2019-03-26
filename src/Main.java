import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 10950번 A + B - 3 */

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] strs;
		int a;
		int b;
		
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			
			a = Integer.parseInt(strs[0]);
			b = Integer.parseInt(strs[1]);
			
			System.out.println((a + b));
		}
	}
}