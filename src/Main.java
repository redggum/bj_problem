import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/* 1065번 한수 */

public class Main {
	static int N;	// 1000
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String[] strs;
		int cnt = 0;
		int gap = 0;
		for (int i = 1; i <= N; i++) {
			
			if (i < 10) {
				cnt++;
				continue;
			}
			
			strs = String.valueOf(i).split("");
			gap = Integer.parseInt(strs[0]) - Integer.parseInt(strs[1]);
			for (int j = 0; j < strs.length - 1; j++) {
				if (gap != Integer.parseInt(strs[j]) - Integer.parseInt(strs[j + 1])) {
					cnt--;
					break;
				}
			}
			
			cnt++;
		}
		
		System.out.println(cnt);
	}
}
