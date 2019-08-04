import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 1280번 나무 심기 */

public class Main {

	static int N;
	static long[] treeZ;
	static long[] treeM;
	static int[] A;
	static int[] pos;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		N = Integer.parseInt(br.readLine());

	}
	
	static long sum(int i) {
		long sum = 0;

		for (int x = i; x > 0; x -= (x & -x)) {
			sum += treeZ[x];
		}

//		System.out.println("zero_sum(" + i + ") : " + sum);
		return sum;
	}

	static void update(int i, int val) {
		int tmp = 1;

		if (val != 0 && A[i] != 0) {
			return;
		}

		if (val != 0 && A[i] == 0) {
			tmp = -1;
		}

		for (int x = i; x <= N; x += (x & -x)) {
			treeZ[x] += tmp;
		}

//		System.out.println(Arrays.toString(treeZ));
	}
}