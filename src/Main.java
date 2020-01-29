import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2753번 윤년 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int year = Integer.parseInt(br.readLine());
		int yun = 0;	// true - 1, false = 0;
		
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			yun = 1;
		}
		
		System.out.println(yun);
	}
}
