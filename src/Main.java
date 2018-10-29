import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/* 6118번 숨바꼭질 */

public class Main {
	private static final int INF = Integer.MAX_VALUE;

	static PriorityQueue<Element> pqueue;
	static int[] dist;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> adj;
	static int N, M, f, t;
	static int max_dist = 0;
	static int max_v = 1;
	static int dup_cnt = 0;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");

		N = Integer.parseInt(str[0]);	// 20,000
		M = Integer.parseInt(str[1]);	// 50,000
		
		f = 0;
		t = 0;
		
//		adj = new int[N + 100][N + 100];
		
		adj = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i < N + 1; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		dist = new int[N + 100];
		visited = new boolean[N + 100];
		
		Arrays.fill(dist, INF);
		
		for (int e = 1; e <= M; e++) {
			str = br.readLine().split(" ");
			
			f = Integer.parseInt(str[0]);
			t = Integer.parseInt(str[1]);
			
			adj.get(f).add(t);
			adj.get(t).add(f);
		}
		
		pqueue = new PriorityQueue<Element>();
		
		dijkstra(1);
		
//		System.out.println(result[0] + " " + result[1] + " " + result[2]);
	}
	
	public static void dijkstra(int base) {
		Element e;
		int v;
		int nextV = 0;
		dist[base] = 0;
		
		pqueue.offer(new Element(base, dist[base]));
		visited[base] = true;
		
		while(!pqueue.isEmpty()) {
			
			e = pqueue.poll();
			v = e.v;
			
//			System.out.println("poll - v : " + v + ", d : " + d);
			
			for (int i = 0; i < adj.get(v).size(); i++) {
				nextV = adj.get(v).get(i);
				if (visited[nextV] == true) {
					continue;
				}
				
//				System.out.println("nextV : " + nextV);
				if (dist[v] != INF && dist[nextV] > dist[v] + 1) {
					dist[nextV] = dist[v] + 1;
					pqueue.offer(new Element(nextV, dist[nextV]));
					visited[nextV] = true;
				}
			}
		}
		
		
		for (int i = 1; i <= N; i++) {
			if (max_dist < dist[i]) {
				max_dist = dist[i];
				max_v = i;
				dup_cnt = 1;
			} else if (i != 1 && max_dist == dist[i]) {
				dup_cnt++;
			}
		}
		
		System.out.println(max_v + " " + max_dist + " " + dup_cnt);
	}
}

class Element implements Comparable<Element>{
	int v;
	int d;
	
	public Element(int v, int d) {
		this.v = v;
		this.d = d;
	}
	
	@Override
	public int compareTo(Element o) {
		
		return d < o.d ? -1 : 1;
	}
}
