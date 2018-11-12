import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/* 1506번 경찰서 */

public class Main {

	static int N, M, C;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		int s, e, d;
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		Node node;
		int v;
		int[] dist;
		int nextV;
		int adj;
		long sum = 0;
		long result = 0;
		long calc = 0;
		boolean[] check;
		
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		C = Integer.parseInt(strs[2]);
		
		ArrayList<ArrayList<Adj>> al = new ArrayList<ArrayList<Adj>>();
		dist = new int[N];
		check = new boolean[N];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		
		for (int i = 0; i < N; i++) {
			al.add(new ArrayList<Adj>());
		}
		
		for (int i = 0; i < M; i++) {
			strs = br.readLine().split(" ");
			
			s = Integer.parseInt(strs[0]);
			e = Integer.parseInt(strs[1]);
			d = Integer.parseInt(strs[2]);
			
			al.get(s - 1).add(new Adj(e, d));
			al.get(e - 1).add(new Adj(s, d));
			sum += d;
		}
		
		result = sum;
		
		pq.add(new Node(1, 0));
		
		while(!pq.isEmpty()) {
			node = pq.poll();
			v = node.v;
			
			if (check[v - 1]) {
				continue;
			}
			
			check[v - 1] = true;
			
//			System.out.println("pulled v : " + v);
			
			for(int i = 0; i < al.get(v - 1).size(); i++) {
				nextV = al.get(v - 1).get(i).v;
				adj = al.get(v - 1).get(i).adj;
				
				if (check[nextV - 1]) {
					sum -= adj;
					continue;
				}
				
				if (dist[nextV - 1] == Integer.MAX_VALUE || dist[v - 1] + adj < dist[nextV - 1]) {
					dist[nextV - 1] = dist[v - 1] + adj;
					
//					System.out.println("queue add : dist[" + (nextV - 1) + "] : " + dist[nextV - 1]);
					
					pq.add(new Node(nextV, dist[nextV - 1]));
				}
			}
			
			calc = C * dist[v - 1] + sum;
			
//			System.out.println("calc : " + calc + ", C : " + C + ", dist[" + (v - 1) + "] : " + dist[v - 1] + ", sum : " + sum);
			
			if (result > calc) {
				result = calc;
			}
		}
		
		System.out.println(result);
	}
}

class Adj {
	int v;
	int adj;
	
	Adj(int v, int adj) {
		this.v = v;
		this.adj = adj;
	}
}

class Node implements Comparable<Node> {
	int v;
	int dist;
	
	Node(int v, int dist) {
		this.v = v;
		this.dist = dist;
	}

	@Override
	public int compareTo(Node o) {
		return this.dist >= o.dist ? 1 : -1;
	}
}
