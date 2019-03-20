import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/* 1260번 DFS와 BFS */

public class Main {
	static int N;	// 1000
	static int M;	// 1000
	static int V;
	static ArrayList<ArrayList<Integer>> arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = 0;
		int b = 0;
		
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		V = Integer.parseInt(strs[2]);
		
		arr = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i <= N; i++) {
			arr.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			strs = br.readLine().split(" ");
			
			a = Integer.parseInt(strs[0]);
			b = Integer.parseInt(strs[1]);
			
			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		
		// sorted
		for (int i = 1; i <= N; i++) {
			Collections.sort(arr.get(i));
		}
		
		visited = new boolean[N + 1];
		dfs(V);
		System.out.println();
		
		visited = new boolean[N + 1];
		bfs(V);
		System.out.println();
	}
	
	
	static void dfs(int v) {
		ArrayList<Integer> list = arr.get(v);
		
		if (visited[v] == false) {
			System.out.print(v + " ");
			visited[v] = true;
			
			for (int i = 0; i < list.size(); i++) {
				dfs(list.get(i));
			}
		}
		
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> list;
		q.offer(start);
		int v;
		int len;
		
		visited[start] = true;
		
		while(!q.isEmpty()) {
			v = q.poll();
			list = arr.get(v);
			len = arr.get(v).size();

			System.out.print(v + " ");
			
			for (int i = 0; i < len; i++) {
				v = list.get(i);
				if (visited[v] == false) {
					q.offer(v);
					visited[v] = true;
				}
			}
			
		}
	}
}
