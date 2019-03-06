import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2441번 별 찍기 - 4 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= num; i++) {
			String str = "";
			for (int j = 1; j < i; j++) {
				str += " ";
			}
			for (int j = num; j >= i ; j--) {
				str += "*";
			}
			System.out.println(str);
		}
	}
}