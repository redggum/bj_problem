import java.io.IOException;

/* 4673번 셀프 넘버 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		boolean[] num = new boolean[10001];
		
		for (int i = 1; i <= 10000; i++) {
			String[] digits = String.valueOf(i).split("");
			int sum = 0;
			for (int j = 0; j < digits.length; j++) {
				sum += Integer.parseInt(digits[j]);
			}
			
			if (i + sum > 10000) {
				continue;
			}
			
			num[i + sum] = true;
		}
		
		for (int i = 1; i < 10000; i++) {
			if (num[i] == false) {
				System.out.println(i);
			}
		}
	}
}
