import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2440번 별 찍기 - 3 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());

		for (int i = 1; i <= num; i++) {
			for (int j = num; j >= i; j--) {
				System.out.print('*');
			}
			
			System.out.println();
		}
	}
}