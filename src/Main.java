import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2742번 기찍 N */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		for (int i = num; i > 0; i--) {
			System.out.println(i);
		}
	}
}