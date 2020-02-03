import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2588번 곱셈 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a, b;

		a = Integer.parseInt(br.readLine());
		b = Integer.parseInt(br.readLine());
		
		int fst, snd, trd;
		fst = b / 100;
		snd = (b - fst * 100) / 10;
		trd = b % 10;
		
		System.out.println(trd = a * trd);
		System.out.println(snd = a * snd);
		System.out.println(fst = a * fst);
		System.out.println(fst * 100 + snd * 10 + trd);
	}
}
