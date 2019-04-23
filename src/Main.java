import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* 1158번 조세퍼스 문제 */

public class Main {
	static int N, K;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] strs = br.readLine().split(" ");

		N = Integer.parseInt(strs[0]);
		K = Integer.parseInt(strs[1]);

		ArrayList<Integer> arr = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			arr.add(i);
		}
		
		int[] check = new int[N + 1];
		Arrays.fill(check, 1);
		
		int index = -1;
		int end;
		
		System.out.print("<");
		
		while(!arr.isEmpty()) {
//			System.out.println("arr.size() : " + arr.size());
//			for (Object obj : arr) {
//				System.out.print(obj + " ");
//			}
//			System.out.println();
//			System.out.println("index : " + index + ", K : " + K);
			if (index + K < arr.size()) {
				index += K;
			} else {
				index = (index + K - arr.size()) % arr.size();
			}
			
//			System.out.println("index : " + index);
			System.out.print(arr.remove(index));
			if (!arr.isEmpty()) {
				System.out.print(", ");
			}
			index--;
		}
		
		System.out.println(">");
	}
}
