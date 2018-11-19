import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1475번 방 번호 */

public class Main {

	static int N;	// 0 <= N <= 1,000,000
	static int s, b; // small, big
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		System.out.println(calcSetCnt(N));
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
