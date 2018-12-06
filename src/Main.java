import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2869번 달팽이는 올라가고 싶다 */

public class Main {

	static int A, I;	// 1 <= A, I <= 100
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strs = br.readLine().split(" ");
		
		A = Integer.parseInt(strs[0]);
		I = Integer.parseInt(strs[1]);
		
		System.out.println(A * (I - 1) + 1);
	}
}
