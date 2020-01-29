import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 10871번 X보다 작은 수 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strs = br.readLine().split(" ");
		
		int a = Integer.parseInt(strs[0]);
		int x = Integer.parseInt(strs[1]);
		
		int[] arr = new int[a + 1];
		String str = "";
		
		strs = br.readLine().split(" ");
		
		for (int i = 0; i < a; i++) {
			arr[i] = Integer.parseInt(strs[i]);
			
			if (arr[i] < x) {
				str += arr[i] + " ";
			}
		}
		
		System.out.println(str);
	}
}
