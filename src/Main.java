import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2156번 포도주 시식 */

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[] val = new int[N + 1];
		int[][] d = new int[N + 1][2];

		val[1] = Integer.parseInt(br.readLine());
		val[2] = Integer.parseInt(br.readLine());
		
		d[1][0] = 0;
		d[1][1] = val[1];
		
		d[2][0] = d[1][1];
		d[2][1] = max(val[2] + d[1][1], val[2] + d[1][0]);
		
//		System.out.println("d[" + 1 + "][0] : " + d[1][0]);
//		System.out.println("d[" + 1 + "][1] : " + d[1][1]);
//		System.out.println("d[" + 2 + "][0] : " + d[2][0]);
//		System.out.println("d[" + 2 + "][1] : " + d[2][1]);
		
		for (int i = 3; i <= N; i++) {
			val[i] = Integer.parseInt(br.readLine());
			
			d[i][0] = max(d[i - 1][1], d[i - 1][0]);
			d[i][1] = d[i -1][1] > d[i - 2][1] ? max(val[i] + val[i - 1] + d[i - 2][0], val[i] + d[i - 2][1]) : val[i] + d[i - 1][0];
			
//			System.out.println("d[" + i + "][0] : " + d[i][0]);
//			System.out.println("d[" + i + "][1] : " + d[i][1]);
		}
		
		System.out.println(max(d[N][0], d[N][1]));
	}
	
	public static int max(int a, int b) {
		if (a > b) {
			return a;
		} else {
			return b;
		}
	}
}