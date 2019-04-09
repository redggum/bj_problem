import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 10951번 A+B - 4 */

public class Main {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner sc = new Scanner(System.in);
		int a, b;
		
		while(sc.hasNextInt()) {
			a = sc.nextInt();
			b = sc.nextInt();
			
			System.out.println(a + b);
		}
	}
}
