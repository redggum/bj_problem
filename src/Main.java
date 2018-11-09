	import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
	
	/* 1701번 Cubeditor */
	
	public class Main {
	
		static String T;
		static int[] pi; 
		
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			T = br.readLine();
	
			char[] tc = T.toCharArray();
			
			int pIdx = 0;
			int[] matchPos = new int[tc.length];
			int matchCnt = 0;
			pi = new int[P.length()];
			int matchBegin = 0;
			
			calcPI(P);
			
			for (int i = 0; i < tc.length; i++) {
	//			System.out.println("tc[" + i + "] : " + tc[i] + ", tp[" + pIdx + "] : " + tp[pIdx]);
				
				if (tc[i] == tp[pIdx]) {
					pIdx++;
				} else {
	//				System.out.println("pIdx : " + pIdx);
					
					if (pIdx > 0) {
	//					System.out.println("pi[" + (pIdx - 1) + "] : " + pi[pIdx - 1]);				
						pIdx = pi[pIdx - 1];
						i--;
					}
				}
				
				if (pIdx == tp.length) {
	//				System.out.println("Matched!!!!!, i : " + i);
					matchBegin = (i + 1) - (tp.length - 1); 
					matchPos[matchCnt++] = matchBegin;
					pIdx = pi[tp.length - 1];
				}
			}
			
			System.out.println(matchCnt);
			
			for (int i = 0; i < matchCnt; i++) {
				System.out.print(matchPos[i] + " ");
			}
			
		}
		
		static void calcPI(String pattern) {
			char[] p = pattern.toCharArray();
			
			int j = 0;
			
			for (int i = 1; i < pattern.length(); i++) {
				while(j > 0 && p[j] != p[i]) {
					j = pi[j - 1];
				}
				
				if (p[j] == p[i]) {
					pi[i] = ++j;
				}
			}
		}
	
	}
