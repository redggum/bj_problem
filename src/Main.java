import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* 3052번 나머지 */

public class Main {
	static int DIV = 42;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Set<Integer> numset = new HashSet<Integer>();
		
		for (int i = 0; i < 10; i++) {
			int num = Integer.parseInt(br.readLine());
			
			numset.add(num % DIV);
		}
		
		System.out.println(numset.size());
	}
}