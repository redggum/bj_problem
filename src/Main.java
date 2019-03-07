import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* 10817번 세 수 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		
		int a = Integer.parseInt(strs[0]);
		int b = Integer.parseInt(strs[1]);
		int c = Integer.parseInt(strs[2]);

		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		arr.add(a);
		arr.add(b);
		arr.add(c);
		
		Collections.sort(arr);
		
		System.out.println(arr.get(1));
	}
}
