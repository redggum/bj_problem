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

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] strs;
		int x, y;
		int[] moveX = { 1, 0, -1, 0 };
		int[] moveY = { 0, 1, 0, -1 };
		int nextX, nextY;
		boolean[] visited;
		Queue<Integer> q;

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			strs = br.readLine().split(" ");

			M = Integer.parseInt(strs[0]);
			N = Integer.parseInt(strs[1]);
			K = Integer.parseInt(strs[2]);

			// init;
			visited = new boolean[M * N + 1];
			q = new LinkedList<Integer>();
			Arrays.fill(visited, false);

			arr = new ArrayList<Integer>();

			parent = new int[M * N + 1];

			int xy;
			int nextXy;

			for (int i = 0; i < K; i++) {
				strs = br.readLine().split(" ");

				x = Integer.parseInt(strs[0]);
				y = Integer.parseInt(strs[1]);

				xy = getXY(x, y);
				arr.add(xy);

				parent[xy] = xy;
				
//				System.out.println("x : " + x + ", y : " + y + ", xy : " + xy);
			}

			int sum = 0;
			
			for (int i = 0; i < K; i++) {
				xy = arr.get(i);
				
//				System.out.println(visited[xy]);

				if (visited[xy] == true) {
					continue;
				}

				q.offer(xy);
				visited[xy] = true;
				
				sum++;

				while (!q.isEmpty()) {
					xy = q.poll();

					for (int j = 0; j < 4; j++) {
						nextX = getX(xy) + moveX[j];
						nextY = getY(xy) + moveY[j];
						
						if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N || visited[nextXy = getXY(nextX, nextY)]) {
							continue;
						}
						
						
						if(parent[nextXy] == 0) {
							continue;
						}

						q.offer(nextXy);
						visited[nextXy] = true;
						
//						System.out.println("nextX : " + nextX + ", nextY : " + nextY);
						
//						if (find(xy) != find(nextXy)) {
////							System.out.println("nextXy : " + nextXy + ", xy : " + xy);
////							System.out.println("parent of nextXy : " + parent[nextXy] + ", parent of xy : " + parent[xy]);
//							parent[nextXy] = parent[xy];
//							q.offer(nextXy);
//							visited[nextXy] = true;
//						}
					}

				}
			}

//			int sum = 0;
//			Set<Integer> tmp = new HashSet<Integer>();
//			int val;
//			
//			for (int i = 0; i < K; i++) {
//				val = parent[arr.get(i)];
////				System.out.println("val : " + val);
//				if (!tmp.contains(val)) {
//					sum++;
//					tmp.add(val);
//				}
//			}

			System.out.println(sum);
		}
	}

	static int find(int xy) {
		if (parent[xy] == xy) {
			return xy;
		}

		return find(parent[xy]);
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
