import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 10039번 평균 점수 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[5];
		int sum = 0;
		
		for (int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			
			if (arr[i] <= 40) {
				arr[i] = 40;
			}
			
			sum += arr[i];
		}
		
		System.out.println(sum / 5);
	}
}
