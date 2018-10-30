import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 1043번 거짓말 */

public class Main {

	static int N, M;
	static ArrayList<ArrayList<Integer>> inPartyNo;		// 각 사람당 참여한 파티 번호 모음
	static int[] kPeopleTruth; 	// 진실을 알고 있는 사람들 번호
	static boolean[] check; 	// 각 사람별로 파티에 참여하여 진실을 알고 있는 사람 번호
	static int result = 0;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		strs = br.readLine().split(" ");
		
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		
		inPartyNo = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i <= 50; i++) {
			inPartyNo.add(new ArrayList<Integer>());
		}
		
		result = M;
		check = new boolean[50 + 1];

		strs = br.readLine().split(" ");
		
		int cnt = Integer.parseInt(strs[0]);
		
		if (cnt > 0) {
			kPeopleTruth = new int[cnt];
			
			for (int i = 1; i <= cnt; i++) {
				kPeopleTruth[i - 1] = Integer.parseInt(strs[i]);
			}
			
			int ppCnt = 0;
			int ppNo = 0;
			
			for (int i = 1; i <= M; i++) {
				strs = br.readLine().split(" ");
				
//				System.out.println(Arrays.toString(strs));
				
				ppCnt = Integer.parseInt(strs[0]);
				
				for (int j = 1; j <= ppCnt; j++) {
					ppNo = Integer.parseInt(strs[j]);
					
					inPartyNo.get(ppNo).add(i);
				}
			}
			
			for (int i = 0; i < kPeopleTruth.length; i++) {
				for (int j = 0; j < inPartyNo.get(kPeopleTruth[i]).size(); j++) {
					ppNo = inPartyNo.get(kPeopleTruth[i]).get(j);
					if (check[ppNo] == false) {
						check[ppNo] = true;
						result--;
					}
				}
			}
			
		}
		
		System.out.println(result);
	}

}
