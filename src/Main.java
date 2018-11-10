import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 1507번 궁금한 민호 */

public class Main {

	public static void main(String[] args) throws IOException {
		int N;
		int[][] noRoad;
		String[] line;
		int[][] edge;
		int sum = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		noRoad = new int[N][N];
		edge = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			line = br.readLine().split(" ");
			
			for (int j = 0; j < N; j++) {
				edge[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
//					System.out.println("edge[" + i + "][" + j + "] : " + edge[i][j] + 
//							", edge[" + i + "][" + k + "] : " + edge[i][k] + 
//							", edge[" + k + "][" + j + "] : " + edge[k][j]);
					
					if (i == j || j == k || k == i) {
						continue;
					}
					
					if (edge[i][j] > edge[i][k] + edge[k][j]) {
						System.out.println("-1");
						return;
					}
					
					if (noRoad[i][j] == 0 && edge[i][j] == edge[i][k] + edge[k][j]) {
//						System.out.println("get i : " + i + ", j : " + j);
						noRoad[i][j] = 1;
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
//				System.out.println("noRoad[" + i + "][" + j + "] : " + noRoad[i][j]);
				if (noRoad[i][j] == 0) {
//					System.out.println("result i : " + i + ", j : " + j + ", edge : " + edge[i][j]);
					sum += edge[i][j];
				}
			}
		}
		
		System.out.println(sum / 2);
	}
}
