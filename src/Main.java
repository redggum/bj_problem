import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 11399번 ATM */

public class Main {
	static int N;
	static int[] time;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;

		N = Integer.parseInt(br.readLine());
		strs = br.readLine().split(" ");
		
		time = new int[N];
		
		for (int i = 0; i < N; i++) {
			time[i] = Integer.parseInt(strs[i]);
		}
		
		Arrays.sort(time);
		
		int[] sum = new int[N];
		sum[0] = time[0];
		int total = sum[0];
		
		for (int i = 1; i < N; i++) {
			sum[i] = sum[i - 1] + time[i];
			
//			System.out.println(time[i] + " " + sum[i]);
			
			total += sum[i];
			
		}
		
		System.out.println(total);
	}
}
