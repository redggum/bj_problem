import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2741번 N 찍기 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= input; i++) {
			System.out.println(i);
		}
	}
}