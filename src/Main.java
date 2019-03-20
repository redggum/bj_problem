import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/* 9012번 괄호 */

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		String res;
		T = Integer.parseInt(br.readLine());
		String[] strs;
		int open_cnt = 0;

		for (int t = 0; t < T; t++) {			
			open_cnt = 0;
			strs = br.readLine().split("");
			
			for (int i = 0; i < strs.length; i++) {
				if (strs[i].equals("(")) {
					open_cnt++;
				} else if (strs[i].equals(")")) {
					open_cnt--;
					if (open_cnt < 0) {
						break;
					}
				} else {
					open_cnt++;
				}
			}
			
			if (open_cnt != 0) {
				res = "NO";
			} else {
				res = "YES";
			}
			
			System.out.println(res);
		}
		
	}
}
