import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1085번 직사각형에서 탈출 */

public class Main {

	static int x;	// 1 <= x <= w - 1 
	static int y;	// 1 <= y <= h - 1
	static int w;	// w <= 1,000
	static int h;	// h <= 1,000
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strs = br.readLine().split(" ");
		
		x = Integer.parseInt(strs[0]);
		y = Integer.parseInt(strs[1]);
		w = Integer.parseInt(strs[2]);
		h = Integer.parseInt(strs[3]);
		
		
		int min = 1000;
		
		if (min > x) min = x;
		if (min > y) min = y;
		if (min > (w - x)) min = w - x;
		if (min > (h - y)) min = h - y;
		
		System.out.println(min);
	}
}
