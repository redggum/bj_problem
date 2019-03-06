import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 10998번 AxB */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] strs = br.readLine().split(" ");
		
		int a = Integer.parseInt(strs[0]);
		int b = Integer.parseInt(strs[1]);

		System.out.println(a * b);
	}
}