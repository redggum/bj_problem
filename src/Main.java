import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 1076번 저항 */

public class Main {

	static int M, N;	// 1 ≤ M <= N ≤ 10,000
	static int SUM = 0;
	static int MIN = Integer.MAX_VALUE;
	static int from = 0;
	static int to = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String one = br.readLine();
		String two = br.readLine();
		String three = br.readLine();

		Map<String, String> resist12 = new HashMap<String, String>();
		
		resist12.put("black", "0");
		resist12.put("brown", "1");
		resist12.put("red", "2");
		resist12.put("orange", "3");
		resist12.put("yellow", "4");
		resist12.put("green", "5");
		resist12.put("blue", "6");
		resist12.put("violet", "7");
		resist12.put("grey", "8");
		resist12.put("white", "9");
	
		Map<String, String> resist3 = new HashMap<String, String>();
		
		resist3.put("black", "");
		resist3.put("brown", "0");
		resist3.put("red", "00");
		resist3.put("orange", "000");
		resist3.put("yellow", "0000");
		resist3.put("green", "00000");
		resist3.put("blue", "000000");
		resist3.put("violet", "0000000");
		resist3.put("grey", "00000000");
		resist3.put("white", "000000000");
		
		System.out.println(Long.parseLong(resist12.get(one) + resist12.get(two) + resist3.get(three)));
	
	}
}
