import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/* 1697번 숨바꼭질 */

public class Main {
	static int MUL = 6;
	static int[] visited = new int[200000 + 1];
	static int N, K;
	static int steps = 0;
	static int result = Integer.MAX_VALUE;
	static Queue<Integer> q = new LinkedList<Integer>();
	static int level = 0;
	static double sum = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strs = br.readLine().split(" ");
		int node;
		int next;
		
		N = Integer.parseInt(strs[0]);
		K = Integer.parseInt(strs[1]);
	
		q.offer(N);
		visited[N] = 1;
		
		
		while(!q.isEmpty()) {
			node = q.poll();
//			System.out.println("node : " + node);
			
			if (node == K) {
				System.out.println(visited[node] - 1);
				return;
			}
			
			for (int i = 0; i < 3; i++) {
				next = nextNode(node, i);
				
				if (next > visited.length - 1) {
					continue;
				}
				
				if (next >= 0 && visited[next] == 0) {
					q.offer(next);
					visited[next] = visited[node] + 1;
				}
			}
		}
	}
	
	static int nextNode(int node, int index) {
//		System.out.println("node : " + node + ", index : " + index);
		if (index == 0) {
			return node - 1;
		} else if (index == 1) {
			return node + 1;
		} else {
			return node * 2;
		}
	}
}