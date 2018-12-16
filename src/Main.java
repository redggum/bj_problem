import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2355번 시그마 */

public class Main {

	static long A = 0;	// -2,147,483,648 ≤ A, B ≤ 2,147,483,647
	static long B = 0;	// -2,147,483,648 ≤ A, B ≤ 2,147,483,647
	static long sum = 0;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] strs = br.readLine().split(" ");
		A = Long.parseLong(strs[0]);
		B = Long.parseLong(strs[1]);
		
//		in / N = in % N
		
		// in 결과
		
		// 몫 X, 나머지 X
		// X 는 N보다 작음
		// X * N + X = in -> X * (N + 1) = in;
		// X -> 1 ~ 1,999,999 for문
		// 곱하기 N 값 중 나머지 N이 X로 되는 수
		
		// e.g.) N = 3;
		// i = 1, 2
		// i = 1 -> in = 3; 1 * (3 + 1) = 4;
		// i = 2 -> in = 6; 2 * (3 + 1) = 8;
		
		for (int i = 1; i < N; i++) {
			in = i * (N + 1);
//			System.out.println(in);
			sum += in;
		}
		
		System.out.println(sum);
		
	}
}
