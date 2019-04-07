import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/* 1012번 유기농 배추 */

public class Main {
	static int T, M, N, K;
	static ArrayList<Node> arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] strs;
		int x, y;
		int[] moveX = {1, 0, -1, 0};
		int[] moveY = {0, 1, 0, -1};
		int nextX, nextY;
		boolean[][] visited;
		Node node, nextNode, nodeParA, nodeParB;
		Queue<Node> q;
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			strs = br.readLine().split(" ");
			
			M = Integer.parseInt(strs[0]);
			N = Integer.parseInt(strs[1]);
			K = Integer.parseInt(strs[2]);
			
			// init;
			visited = new boolean[M][N];
			q = new LinkedList<Node>();
			for (int i = 0; i < visited.length; i++) {
				Arrays.fill(visited[i], false);
			}
			
			arr = new ArrayList<Node>();
			
			for (int i = 0; i < K; i++) {
				strs = br.readLine().split(" ");
				
				x = Integer.parseInt(strs[0]);
				y = Integer.parseInt(strs[1]);
				
				arr.add(new Node(x, y));
				arr.get(i).setPar(arr.get(i));
			}
			
			for (int i = 0; i < K; i++) {
				node = arr.get(i);
				
				if (visited[node.getX()][node.getY()] == true) {
					continue;
				}
				
				q.offer(node);
				
				while(!q.isEmpty()) {
					node = q.poll();
					
					for (int j = 0; j < 4; j++) {
						nextX = node.getX() + moveX[j];
						nextY = node.getY() + moveY[j];
						
						if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N || visited[nextX][nextY]) {
							continue;
						}
						
						nextNode = searchNodeByXY(nextX, nextY);
						
						if (nextNode == null) {
							continue;
						}
						
						nodeParA = find(node);
						nodeParB = find(nextNode); 
						if (!nodeParA.equals(nodeParB)) {
							nextNode.setPar(nodeParA);
							q.offer(nextNode);
							visited[nextX][nextY] = true;
						}
					}
					
				}
			}
			
			int sum = 0;
			Node tmp = new Node(-1, -1);
			
			for (int i = 0; i < K; i++) {
				if (!arr.get(i).getPar().equals(tmp)) {
					sum++;
					tmp = arr.get(i).getPar();
				}
			}
			
			System.out.println(sum);
		}
	}
	
	static Node find(Node node) {
		if (node.getPar().equals(node)) {
			return node;
		}
		
		return find(node.getPar());
	}
	
	static Node searchNodeByXY(int x, int y) {
		Node node;
		
//		System.out.println("param x :" + x + ", y : " + y);
		
		for (int i = 0; i < K; i++) {
			node = arr.get(i); 
			
//			System.out.println("node x : " + node.getX() + ", y : " + node.getY());
			
			if (node.getX() == x && node.getY() == y) {
				return node;
			}
		}
		
		return null;
	}
}

class Node {
	private int x;
	private int y;
	private Node par;
	private Node node;
	
	Node(int x, int y) {
		this.x = x;
		this.y = y;
		this.par = this;
		this.node = this;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Node getPar() {
		return par;
	}

	public void setPar(Node par) {
		this.par = par;
	}
	
	public Node getNode() {
		return node;
	}
}
