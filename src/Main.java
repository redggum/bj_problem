import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1652번 누울 자리를 찾아라 */

public class Main {

	static long A, B, V;	// 1 <= B < A <= V <= 1,000,000,000
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strs = br.readLine().split(" ");
		
		A = Long.parseLong(strs[0]);
		B = Long.parseLong(strs[1]);
		V = Long.parseLong(strs[2]);
		
		long reminder = (V - A) % (A - B);
		
		long plus = (reminder > 0 ? 2 : 1);
		
		System.out.println((V - A) / (A - B) + plus);
	}
}
