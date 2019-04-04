import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/* 2606번 바이러스 */

public class Main {
	static int N, M, a, b;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<ArrayList<Integer>> arr;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		String[] strs;
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N + 1];
		
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
		
		q.offer(1);
		visited[1] = true;
		
		int node;
		int next;
		int cnt = -1;
		
		while(!q.isEmpty()) {
			node = q.poll();
			cnt++;
			
			for (int i = 0; i < arr.get(node).size(); i++) {
				next = arr.get(node).get(i);
				
				if (visited[next] == false) {
					q.offer(next);
					visited[next] = true;
				}
			}
		}
		
		System.out.println(cnt);
		
		
	}
}
