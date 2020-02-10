import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 10818번 최소, 최대 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] strs = br.readLine().split(" ");
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (String str : strs) {
			int num = Integer.parseInt(str);
			
			if (min > num) {
				min = num;
			}
			
			if (max < num) {
				max = num;
			}
		}
		
		System.out.println(min + " " + max);
	}
}
