import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/* 2667번 단지번호붙이기 */

public class Main {
	static int N;
	static int[] parent;
	static boolean[] visited;
	static int[] moveX = new int[] { 1, 0, -1, 0 };
	static int[] moveY = new int[] { 0, 1, 0, -1 };
	static int[][] xy;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		xy = new int[N + 1][N + 1];
		String[] strs;

		parent = new int[N * N + 1];
		visited = new boolean[N * N + 1];

		for (int x = 1; x <= N; x++) {
			strs = br.readLine().split("");
			for (int y = 1; y <= N; y++) {
				xy[x][y] = Integer.parseInt(strs[y - 1]);

				parent[xy(x, y)] = xy(x, y);
			}
		}

		for (int x = 1; x <= N; x++) {
			for (int y = 1; y <= N; y++) {
				if (xy[x][y] == 1 && visited[xy(x, y)] == false) {
					bfs(x, y);
				}
			}
		}

		Set<Integer> index = new HashSet<Integer>();
		int[] par_cnt = new int[N * N + 1];
		int idx;

		for (int x = 1; x <= N; x++) {
			for (int y = 1; y <= N; y++) {
				if (xy[x][y] == 0) {
					continue;
				}

				idx = parent[xy(x, y)];

				par_cnt[idx]++;
				index.add(idx);
			}
		}
		
		System.out.println(index.size());
		
		int[] arr = new int[index.size()];
		
		Iterator<Integer> it = index.iterator();
		for (int i = 0; i < index.size(); i++) {
			arr[i] = par_cnt[it.next()];
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < index.size(); i++) {
			System.out.println(arr[i]);
		}
	}
	
	static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<Node>();
		int nextX, nextY;
		int curX, curY;
		
		q.offer(new Node(x, y));
		visited[xy(x, y)] = true;
		
		while(!q.isEmpty()) {
			curX = q.peek().getX();
			curY = q.peek().getY();
			q.poll();
			
			for (int i = 0; i < 4; i++) {
				nextX = curX + moveX[i];
				nextY = curY + moveY[i];

				if (nextX >= 1 && nextX <= N && nextY >= 1 && nextY <= N && xy[nextX][nextY] == 1 && visited[xy(nextX, nextY)] == false) {
//					System.out.println("xy : " + xy(x, y) + ", next xy : " + xy(nextX, nextY));
					union(xy(x, y), xy(nextX, nextY));
					visited[xy(nextX, nextY)] = true;
//					System.out.println("par(xy) : " + parent[xy(x, y)] + ", next par(xy) : " + parent[xy(nextX, nextY)]);
					q.offer(new Node(nextX, nextY));
				}
			}
			
		}
	}

	static int xy(int x, int y) {
		return N * (x - 1) + y;
	}

	static int find(int xy) {
		if (xy == parent[xy]) {
			return parent[xy];
		}

		return find(parent[xy]);
	}

	static void union(int xy1, int xy2) {
		int parA = find(xy1);
		int parB = find(xy2);

		if (parA != parB) {
			parent[xy2] = parA;
		}
	}
}

class Node {
	private int x;
	private int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	int getX() {
		return x;
	}
	
	int getY() {
		return y;
	}
}