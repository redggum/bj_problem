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
	static ArrayList<String> arr;
	static int[] parent;
	static boolean[][] visited;
	static boolean[][] valid;
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
			visited = new boolean[M][N];
			valid = new boolean[M][N];

			arr = new ArrayList<String>();

			for (int i = 0; i < K; i++) {
				strs = br.readLine().split(" ");

				x = Integer.parseInt(strs[0]);
				y = Integer.parseInt(strs[1]);

				arr.add(x + ":" + y);
				valid[x][y] = true;
			}

			int sum = 0;

			for (int i = 0; i < K; i++) {
				String[] st = arr.get(i).split(":");
				x = Integer.parseInt(st[0]);
				y = Integer.parseInt(st[1]);

				if (visited[x][y] == true) {
					continue;
				}

				sum++;				
				bfs(x, y);
			}

			System.out.println(sum);
		}
	}

	static void bfs(int x, int y) {
		Queue<String> q = new LinkedList<String>();
		int nextX, nextY;

		q.offer(x + ":" + y);
		visited[x][y] = true;

		while (!q.isEmpty()) {
			String[] st = q.poll().split(":");

			for (int j = 0; j < 4; j++) {
				nextX = Integer.parseInt(st[0]) + moveX[j];
				nextY = Integer.parseInt(st[1]) + moveY[j];

//				if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
//					System.out.println("nextXy : " + nextXy + ", visited[nextXy] :" + visited[nextXy]
//							+ ", valid[nextXy] :" + valid[nextXy]);
//				}

				if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) {
					continue;
				}
				
				if (visited[nextX][nextY] || valid[nextX][nextY] == false) {
					continue;
				}

				q.offer(nextX + ":" + nextY);
				visited[nextX][nextY] = true;

//				System.out.println("nextX : " + nextX + ", nextY : " + nextY + ", nextXy : " + nextXy);
			}
		}
	}
}
