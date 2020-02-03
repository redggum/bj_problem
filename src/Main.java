import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2675번 문자열 반복 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int C = Integer.parseInt(br.readLine());
		int r;
		String chr;
		String ret;
		String[] strs;
		
		for (int c = 1; c <= C; c++) {
			ret = "";
			strs = br.readLine().split(" ");

			r = Integer.parseInt(strs[0]);
			chr = strs[1];
	
			for (int i = 0; i < chr.length(); i++) {
				for (int j = 0; j < r; j++) {
					ret += chr.substring(i, i + 1);
				}
			}

			System.out.println(ret);
		}
	}
}
