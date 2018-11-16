import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1763번 트리 색칠 */

public class Main {

	static int N, R;	// 1 <= N <= 1,000   1 <= R <= N
	static boolean[][] adj;
	static int[] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		adj = new boolean[N + 1][N + 1];
		
		String[] strs;
		
		for (int i = 1; i <= N; i++) {
			strs = br.readLine().split("");
			
			for (int j = 1; j <= N; j++) {
				if (strs[j - 1].equals("Y")) {
					if (adj[j][i] == false) {
						adj[i][j] = true;
					} else {
						// if the edge is bidirectional, don't care of checking cycle
						adj[j][i] = false;
					}
				}
			}
		}
		
		for (int v = 1; v <= N; v++) {
			visited = new int[N + 1];

			if (findCycle(v)) {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
	}
	
	static boolean findCycle(int node) {
		if (visited[node] != 0) {
			if (visited[node] == -1) {	// cycle
				return true;
			}
			
			return false;
		}
		
		visited[node] = -1;
		
		for (int i = 1; i <= N; i++) {
			
			if (adj[node][i]) {
//				System.out.println("node : " + node + ", child : " + i);
				if (findCycle(i)) {
					return true;
				}
			}
		}
		
		visited[node] = 1;
		
		return false;
	}
}

class Node implements Comparable<Node> {
	int v;
	int cost;
	
	Node(int v, int cost) {
		this.v = v;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost >= o.cost ? 1 : -1;
	}
}
