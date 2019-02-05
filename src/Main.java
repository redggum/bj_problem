import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 1722번 순열의 순서 */

public class Main {

	static int N, type, K = 0; // <= 15
	static int[] arr;
	static int[] comp;
	static int[] sol;
	static int sol_idx = 0;
	static boolean[] visited;
	static int order = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1];
		sol = new int[N + 1];
		comp = new int[N + 1];
		visited = new boolean[N + 1];

		String[] strs = br.readLine().split(" ");
		type = Integer.parseInt(strs[0]);

		if (type == 1) {
			K = Integer.parseInt(strs[1]);
		} else {
			for (int i = 1; i < strs.length; i++) {
				comp[i - 1] = Integer.parseInt(strs[i]);
			}
		}

		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		if (type == 1) {
			recursive(N, 0, 0);
			for (int i = 0; i < N; i++) {
				System.out.print(sol[i] + " ");
			}
		} else {
			System.out.println(order(N, 0, 0) + 1);
		}
	}

	static boolean recursive(int n, int index, long sum) {
		long fact = 0;
//		System.out.println(Arrays.toString(visited));
//		System.out.println("n : " + n);
		for (int i = 1; i <= N; i++) {
			if (visited[i - 1]) {
				continue;
			}

			fact = factorial(n - 1);

//			System.out.println("n : " + n + ", index : " + index + ", sum : " + sum + ", i : " + i + ", fact : " + fact);
//			System.out.println(Arrays.toString(sol));
//			System.out.println(Arrays.toString(visited));

			if (K == sum + fact) {
//				System.out.println("K == " + (sum + fact));
				sol[index] = i;
				visited[i - 1] = true;
				/*for (int j = 0; j < N; j++) {
					if (visited[j] == false) {
						sol[index + 1] = j + 1;
						break;
					}
				}
				return true;*/
//				System.out.println(Arrays.toString(sol));
				if (recursive(n - 1, index + 1, sum)) {
//					System.out.println("find!!");
					return true;
				}
			} else if (K < sum + fact) {
//				System.out.println("index : " + i);
				sol[index] = i;
				visited[i - 1] = true;
//				System.out.println(Arrays.toString(sol));
				if (recursive(n - 1, index + 1, sum)) {
//					System.out.println("find!!");
					return true;
				}
			} else {
				sum += fact;
			}
		}

		return true;
	}

	static long order(int n, int index, long sum) {
		long result;

		if (index + 1 >= N) {
			result = sum;
			return result;
		}

//		System.out.println(Arrays.toString(visited));

		for (int i = 1; i < comp[index]; i++) {
			if (visited[i - 1] != true) {
				sum += factorial(n - 1);
			}
		}

//		System.out.println("sum : " + sum);
		visited[comp[index] - 1] = true;
		result = order(n - 1, index + 1, sum);

		return result;
	}

	static long factorial(int n) {
		long ret = 1;
		for (int i = n; i > 1; i--) {
			ret *= i;
		}

		return ret;
	}
}
