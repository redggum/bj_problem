import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

/* 1506번 경찰서 */

public class Main {

	static int N;	// 1 <= N <= 100
	static int[] cost;
	static boolean[][] adj;
	static Stack<Integer> stack;
	static ArrayList<PriorityQueue<Node>> al;
	static int[] visited;
	static int sum;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		cost = new int[N + 1];
		
		String[] strs = br.readLine().split(" ");
		String str;
		
		for (int i = 1; i <= N; i++) {
			cost[i] = Integer.parseInt(strs[i - 1]);
		}
		
		adj = new boolean[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			str = br.readLine();
			
			for (int j = 1; j <= N; j++) {
				if (str.charAt(j - 1) == '1') {
					adj[i][j] = true;
				}
			}
		}
		
		
		for (int v = 1; v <= N; v++) {
			stack = new Stack<Integer>();
			visited = new int[N + 1];
			al = new ArrayList<PriorityQueue<Node>>();
			cnt = 0;
			sum = 0;
			
			stack.push(v);
			
			findCycle(v);
			
			for (int i = 0; i < al.size(); i++) {
				sum += al.get(i).poll().cost;
			}
			
			while(!stack.isEmpty()) {
				sum += cost[stack.pop()];
				cnt++;
			}
			
			if (cnt == N) {
				break;
			}
		}
		
		System.out.println(sum);
	}
	
	static void findCycle(int node) {
		if (visited[node] != 0) {
			if (visited[node] == -1) {	// cycle
				int pop = 0;
				PriorityQueue<Node> pq = new PriorityQueue<Node>();
				while(stack.contains(node)) {
					pop = stack.pop();
					pq.add(new Node(pop, cost[pop]));
					cnt++;
				}
				
				al.add(pq);
				
				return;
			}
			
			return;
		}
		
		visited[node] = -1;
		
		for (int i = 1; i <= N; i++) {
			
			if (adj[node][i]) {
//				System.out.println("node : " + node + ", child : " + i);
				
				stack.push(i);
				findCycle(i);
			}
		}
		
		visited[node] = 1;
		
		return;
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
