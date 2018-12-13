import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 1652번 누울 자리를 찾아라 */

public class Main {

	static int N;	// 1 <= N <= 100
	static char[][] arr;
	static int cnt;
	static int len;
	static char ch;
	static int x, y;
	static boolean trigger;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = null;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new char[N + 1][N + 1];
		cnt = 0;
		x = 0;
		y = 0;
		
		
		for (int i = 1; i <= N; i++) {
			strs = br.readLine().split("");
			
			for (int j = 1; j <= N; j++) {
				ch = strs[j - 1].charAt(0);
				arr[i][j] = ch;
			}
		}
		
		x = cnt;
		cnt = 0;
		
		System.out.println(xy_calc() + " " + yx_calc());
	}
	
	static int xy_calc() {
		int cnt = 0;
		char ch;
		
		for (int i = 1; i <= N; i++) {		
			len = 0;
			ch = 0;
			trigger = false;
			
			for (int j = 1; j <= N; j++) {
				ch = arr[i][j];
				if (ch == '.') {
					 if (trigger == false) {
						 len++;
					 }
				} else {
					len = 0;
					trigger = false;
				}
				
				if (len == 2 && trigger == false) {
					cnt++;
					trigger = true;
				}
			}
		}
		
		return cnt;
	}
	
	static int yx_calc() {
		int cnt = 0;
		char ch;
	
		for (int i = 1; i <= N; i++) {		
			len = 0;
			ch = 0;
			trigger = false;
			
			for (int j = 1; j <= N; j++) {
				ch = arr[j][i];
				if (ch == '.') {
					 if (trigger == false) {
						 len++;
					 }
				} else {
					len = 0;
					trigger = false;
				}
				
				if (len == 2 && trigger == false) {
					cnt++;
					trigger = true;
				}
			}
		}
		
		return cnt;
	}
}
