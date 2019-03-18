import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2577번 숫자의 개수 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num1 = Integer.parseInt(br.readLine());
		int num2 = Integer.parseInt(br.readLine());
		int num3 = Integer.parseInt(br.readLine());
		
		long sum = num1 * num2 * num3;
		
		String[] strs = String.valueOf(sum).split("");
		
		int[] cnt = new int[10];
		
		
		for (int i = 0; i < strs.length; i++) {
			cnt[Integer.parseInt(strs[i])]++;
		}
		
		for (int i = 0; i < cnt.length; i++) {
			System.out.println(cnt[i]);
		}
	}
}
