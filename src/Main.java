import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 11654번 아스키 코드 */

public class Main {

	static char in;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		in = br.readLine().charAt(0);

		System.out.println((int) in);
	}
}