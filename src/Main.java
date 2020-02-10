import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 2562번 최대값 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = 9;
		
		int[] notOrder = new int[n];
		int[] order = new int[n];
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			notOrder[i] = num;
			order[i] = num;
		}
		
		Arrays.sort(order);
		
		int max = order[n - 1];
		System.out.println(max);
		
		for (int i = 0; i < notOrder.length; i++) {
			if (notOrder[i] == max) {
				System.out.println(i + 1);
				break;
			}
		}
	}
}