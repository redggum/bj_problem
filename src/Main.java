import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1330번 두 수 비교하기 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;

		int a, b;
		
		strs = br.readLine().split(" ");
		
		a = Integer.parseInt(strs[0]);
		b = Integer.parseInt(strs[1]);
		
		if (a > b) {
			System.out.println(">");
		} else if (a < b) {
			System.out.println("<");
		} else {
			System.out.println("==");
		}
	}
}	
