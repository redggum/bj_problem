import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 11057번 오르막 수 */

public class Main {

	static int N, M;
	static long[][] sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
	
		int count = 0;
		int num = 10;
		for (int i = 0; i < 10; i++) {
			count += (num - i);
		}
		
		System.out.println(count);
		
		
	}
}	