import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2558번 A + B - 2 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());

		System.out.println(a + b);
	}
}