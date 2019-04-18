import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/* 11053번 가장 긴 증가하는 부분 수열 */

public class Main {
	static int N;
	static int[] arr;
	static int[] D;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int max = 0;
		
		arr = new int[N];
		D = new int[N];
		
		String[] strs = br.readLine().split(" ");
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		
		Arrays.fill(D, 1);
		
		for (int i = 1; i < N; i++) {
			max = 0;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && D[j] > max) {
					D[i] = D[j] + 1;
					max = D[j];
				}				
			}
			
//			System.out.println("D[" + i + "] : " + D[i]);
		}
		
		max = 0;
		for (int i = 0; i < N; i++) {
			if (max < D[i]) {
				max = D[i];
			}
		}
		
		System.out.println(max);
		
		
		
	}
}
