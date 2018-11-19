import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1085번 직사각형에서 탈출 */

public class Main {

	static int x, y, w, h;	// 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strs = br.readLine().split(" ");
		
		x = Integer.parseInt(strs[0]);
		y = Integer.parseInt(strs[1]);
		w = Integer.parseInt(strs[2]);
		h = Integer.parseInt(strs[3]);
		
	}

	public static int calcSetCnt(int inputNum) {
		String str = String.valueOf(inputNum);
		int[] numCnt = new int[10];
		int num = 0;
		int maxCnt = 0;
		
		for (int i = 0; i < str.length(); i++) {
			num = str.charAt(i) - '0';
			numCnt[num] += 1;
		}
		
		int mid = (numCnt[6] + numCnt[9]) / 2 + (numCnt[6] + numCnt[9]) % 2;
		numCnt[6] = mid;
		numCnt[9] = mid;
		
		for (int i = 0; i < 10; i++) {
			maxCnt = maxCnt < numCnt[i] ? numCnt[i] : maxCnt;  
		}
		
		return maxCnt;
	}
}
