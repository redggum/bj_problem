import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/* 1967번 트리의 지름 */

public class Main {

	static int N, M;
	static ArrayList<Node>[] arr;
	
	static final long INF = Long.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		int a, b, c;
		int[] dist;
		Queue<Integer> q;
		boolean[] visit;
		ArrayList<Node> res;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new ArrayList[N + 1];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<>();
		}
		
		dist = new int[N + 1];
		q = new LinkedList<Integer>();
		visit = new boolean[N + 1];
		res = new ArrayList<>();
		
		for (int i = 1; i < N; i++) {
			strs = br.readLine().split(" ");
			a = Integer.parseInt(strs[0]);
			b = Integer.parseInt(strs[1]);
			c = Integer.parseInt(strs[2]);
			
			arr[a].add(new Node(b, c));
			arr[b].add(new Node(a, c));			
		}
		
		q.offer(1);
		visit[1] = true;
		dist[1] = 0;
		
		while(!q.isEmpty()) {
			int v = q.poll();
			
			res.add(new Node(v, dist[v]));
			
			
			
			visit[v] = true;
			
			System.out.println("v : " + v);
			
			for (int i = 0; i < arr[v].size(); i++) {
				Node n = arr[v].get(i);
				if (visit[n.v]) {
					continue;
				}
				
				dist[n.v] = dist[v] + n.e;
				q.offer(n.v);
			}
		}
		
		res.sort(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o2.e - o1.e;
			}
		});
		
		
		System.out.println(res.get(0).e + res.get(1).e);
	}
}	

class Node {
	int v;
	int e;
	
	Node(int v, int e) {
		this.v = v;
		this.e = e;
	}
}
