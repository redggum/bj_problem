import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 11720번 숫자의 합 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuffer sb = new StringBuffer();
		sb.append(br.readLine());
		
		int len = 0;
		
		for (int i = 0; i < sb.length(); i++) {
//			System.out.println("len : " + len);
			
			if (len + 10 >= sb.length()) {
				System.out.println(sb.substring(len, sb.length()));
				break;
			}
			
			System.out.println(sb.substring(len, len + 10));
			
			
			len += 10;
			i += 9;
		}
		
	}
}
