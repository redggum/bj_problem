import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/* 2178번 미로 탐색 */

public class Main {
	static final int INF = Integer.MAX_VALUE;
	
	static int[] nextR = {0, 1, 0, -1};
	static int[] nextC = {1, 0, -1, 0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] strs = br.readLine().split(" ");

		int N, M;
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node arg0, Node arg1) {
				return arg0.getD() > arg1.getD() ? 1 : -1;
			}
		});

		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);

		int[][] v = new int[N + 1][M + 1];

		Node[] node = new Node[N * M + 1];
		
		for (int i = 0; i < node.length; i++) {
			node[i] = new Node();
		}
		
//		System.out.println("Node[] cnt : " + (N * M + 1));

		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= M; j++) {
				node[M * i + j].set(i + 1, j, INF);
				
//				System.out.println("node[" + (M * i + j) + "] - d : " + node[M * i + j].getD());
			}
		}

		// init matrix
		for (int i = 1; i <= N; i++) {
			strs = br.readLine().split("");
			for (int j = 1; j <= strs.length; j++) {
				v[i][j] = Integer.parseInt(strs[j - 1]);
			}
		}
		

		// Dijkstra
		node[1].set(1, 1, 1);
		
		pq.offer(node[1]);
		Node temp;
		int n;
		int m;
		int d;
		int nextN;
		int nextM;
		int nodeI;
		int cnt = 1;
		
		while(!pq.isEmpty()) {
			temp = pq.poll();
			
			n = temp.getN();
			m = temp.getM();
			d = temp.getD();
			
//			if (cnt > 10) break;
			
//			System.out.println("n : " + n + ", m : " + m + ", d : " + d);
			
			for (int i = 0; i < nextR.length; i++) {
				nextN = n + nextR[i];
				nextM = m + nextC[i];
				nodeI = (nextN - 1) * M  + nextM;
//				System.out.println("nextN : " + nextN + ", nextM : " + nextM + ", nodeI : " + nodeI);
				if (nextN > N || nextN < 0 || nextM > M || nextM < 0 || v[nextN][nextM] == 0) {
					continue;
				}
				
//				System.out.println("nodeI - d : " + node[nodeI].getD());
				
				if (node[nodeI].getD() > d + 1 && node[nodeI].getD() != d + 1) {
					node[nodeI].set(nextN, nextM, d + 1);
					pq.offer(node[nodeI]);
//					System.out.println("offer - nodeI : " + nodeI);
					cnt++;
				}
			}
		}

		System.out.println(node[N * M].getD());
	}

}

class Node {
	private int n;
	private int m;
	private int d;

	public void set(int n, int m, int d) {
		this.n = n;
		this.m = m;
		this.d = d;
	}

	public int getN() {
		return this.n;
	}
	public int getM() {
		return this.m;
	}
	public int getD() {
		return this.d;
	}
}