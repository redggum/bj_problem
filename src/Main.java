import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 7576번 토마토 */

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M, N;
		String[] strs;
		
		int[][] date;
		int[][] box;
		Queue<Matrix> q = new LinkedList<Matrix>();
		
		int[] moveN = new int[] {1, 0, -1, 0};
		int[] moveM = new int[] {0, 1, 0, -1};
		
		int n, m;
		int nextN, nextM;
		
		strs = br.readLine().split(" ");
		
		M = Integer.parseInt(strs[0]);
		N = Integer.parseInt(strs[1]);
		
		date = new int[N + 1][M + 1];
		box = new int[N + 1][M + 1];
		
		for (int i = 1; i <= N; i++) {
			strs = br.readLine().split(" ");
			
//			System.out.println(Arrays.toString(strs));
			
			for (int j = 1; j <= M; j++) {
				box[i][j] = Integer.parseInt(strs[j - 1]);
				
				if (box[i][j] == 1) {
					q.offer(new Matrix(i, j));
					date[i][j] = 1;
				}
				
				if (box[i][j] == -1) {
					date[i][j] = -1;
				}
			}
		}
		
		// bfs
		Matrix tempMat;
		
		while(!q.isEmpty()) {
			tempMat = q.poll();
			n = tempMat.getN();
			m = tempMat.getM();
			
//			System.out.println("n : " + n + ", m : " + m);
			
			for (int i = 0; i < 4; i++) {
				nextN = n + moveN[i];
				nextM = m + moveM[i];
				
				if (nextN <= 0 || nextN > N || nextM <= 0 || nextM > M) {
					continue;
				}
				
				if (box[nextN][nextM] == -1 || date[nextN][nextM] != 0) {
					continue;
				}
				
				q.offer(new Matrix(nextN, nextM));
				date[nextN][nextM] = date[n][m] + 1;
			}
		}
		
		int max = -1;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
//				System.out.print(date[i][j] + " ");
				
				if (date[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				
				if (max < date[i][j]) {
					max = date[i][j];
				}
			}
			
		}
		
		System.out.println(max - 1);
	}
}

class Matrix {
	private int n;
	private int m;
	
	public Matrix(int n, int m) {
		this.n = n;
		this.m = m;
	}
		
	int getN() {
		return n;
	}
	
	int getM() {
		return m;
	}
}