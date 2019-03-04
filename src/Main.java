import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1267번  */

public class Main {

	static int N, sum, call = 0;
	static int DIV_Y = 30;
	static int DIV_M = 60;
	static int PRC_Y = 10;
	static int PRC_M = 15;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		N = Integer.parseInt(br.readLine());
		
		strs = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			call = Integer.parseInt(strs[0]);
			
			
		}
	}		
}
