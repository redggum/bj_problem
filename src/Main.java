import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/* 1012번 유기농 배추 */

public class Main {
	static int T, M, N, K;
	static ArrayList<Integer> arr;
	static int[] parent;
	static boolean[] visited;
	static boolean[] valid;
	static int[] moveX = { 1, 0, -1, 0 };
	static int[] moveY = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] strs;
		int x, y;

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			strs = br.readLine().split(" ");

			M = Integer.parseInt(strs[0]);
			N = Integer.parseInt(strs[1]);
			K = Integer.parseInt(strs[2]);

			// init;
			visited = new boolean[M * N + 1];
			valid = new boolean[M * N + 1];

			Arrays.fill(visited, false);

			arr = new ArrayList<Integer>();

			int xy;

			for (int i = 0; i < K; i++) {
				strs = br.readLine().split(" ");

				x = Integer.parseInt(strs[0]);
				y = Integer.parseInt(strs[1]);

				xy = getXY(x, y);
				arr.add(xy);
				valid[xy] = true;
			}

			int sum = 0;

			for (int i = 0; i < K; i++) {
				xy = arr.get(i);

				if (visited[xy] == true) {
					continue;
				}

				sum++;				
				System.out.println("xy : " + xy);
				bfs(xy);
			}

			System.out.println(sum);
		}
	}

	static void bfs(int xy) {
		Queue<Integer> q = new LinkedList<Integer>();
		int nextX, nextY;
		int nextXy;

		q.offer(xy);
		visited[xy] = true;

		while (!q.isEmpty()) {
			xy = q.poll();

			for (int j = 0; j < 4; j++) {
				nextX = getX(xy) + moveX[j];
				nextY = getY(xy) + moveY[j];
				nextXy = getXY(nextX, nextY);

//				if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
//					System.out.println("nextXy : " + nextXy + ", visited[nextXy] :" + visited[nextXy]
//							+ ", valid[nextXy] :" + valid[nextXy]);
//				}

				if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N || visited[nextXy] || valid[nextXy] == false) {
					continue;
				}

				q.offer(nextXy);
				visited[nextXy] = true;

//				System.out.println("nextX : " + nextX + ", nextY : " + nextY + ", nextXy : " + nextXy);
			}
		}
	}

	static int getXY(int x, int y) {
		return y * M + x + 1;
	}

	static int getX(int xy) {
		return xy % M - 1;
	}

	static int getY(int xy) {
		return xy / M;
	}
}
