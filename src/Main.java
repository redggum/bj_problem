import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* 11403번 경로 찾기 */

public class Main {
	static int N;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		String[] strs;
		int val = 0;
		
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			
			for (int j = 0; j < strs.length; j++) {
				val = Integer.parseInt(strs[j]);
				if (val == 1) {
					list.get(i).add(j);
//					list.get(j).add(i);
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				val = bfs(i, j) ? 1 : 0;
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}
	
	static boolean bfs(int from, int end) {
		Queue<Integer> q = new LinkedList<Integer>();
		int node = 0;
		int nextNode = 0;
		boolean[][] visited = new boolean[N][N];
		
		q.offer(from);
		
		while(!q.isEmpty()) {
			node = q.poll();
			
			for (int i = 0; i < list.get(node).size(); i++) {
				nextNode = list.get(node).get(i);
				
				if (visited[node][nextNode]) {
					continue;
				}
				
				if (nextNode == end) {
					return true;
				}
				
//				System.out.println("q.offer : " + nextNode);
				q.offer(nextNode);
				visited[node][nextNode] = true;
//				visited[nextNode][node] = true;
			}
		}
		
		return false;
	}
}
