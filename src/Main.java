import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2903번 중앙 이동 알고리즘 */

public class Main {

	static int n = 0;	// <= 15
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		double val = Math.pow(2, (double)n);
//		System.out.println(val);
		String str = Double.toString(val);
		str = str.substring(0, str.length() - 2);
//		System.out.println(str);
		long s = Long.parseLong(str);
		
		System.out.println((s + 1) * (s + 1));
	}
}	
