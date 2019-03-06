import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1008번 A/B */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strs = br.readLine().split(" ");
		
		double a = Double.parseDouble(strs[0]);
		double b = Double.parseDouble(strs[1]);
		
		System.out.println(a / b);
	}
}