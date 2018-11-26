import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1037번 약수 */

public class Main {

	static int N;	// N <= 50 
	static int[] v;
	static int gcd_val = 0;
	static int lcm_val = 0;
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		N = Integer.parseInt(br.readLine());
		strs = br.readLine().split(" ");
		v = new int[N];
		
		// lcm(a, b) = a x b / gcd(a, b)
		for (int i = 0; i < N; i++) {
			v[i] = Integer.parseInt(strs[i]);
//			System.out.println(v[i]);
			
			if (max < v[i]) {
				max = v[i];
			}
		}
		
		for (int i = 0; i < N - 1; i++) {
			lcm_val = v[i] * v[i + 1] / (gcd_val = gcd(v[i], v[i + 1]));
			
			v[i + 1] = lcm_val;
			
//			System.out.println(gcd_val + " " + v[i + 1]);
		}
		
		if (v[N - 1] <= max) {
			v[N - 1] *= 2;
		}
		
		System.out.println(v[N - 1]);
	}
	
	static int gcd(int a, int b) {
		int rem = a % b;
		
		if (rem == 0) {
			return b;
		}
		
		return gcd (b, rem);
	}
}
