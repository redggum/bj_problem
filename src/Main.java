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

/* 1193번 분수찾기 */

public class Main {
	static long N, diff;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Long.parseLong(br.readLine());
		for(int i = 2; i <= (int) Math.sqrt(N) * 2; i++) {
			if (N > i * (i - 1) / 2 && N <= i * (i + 1) / 2 ) {
//				System.out.println("i : " + i);
				
				diff = N - i * (i - 1) / 2;
//				System.out.println(diff);
				
				if (i % 2 == 1) { // odd
					System.out.println((i - diff + 1) + "/" + diff);
				} else { // even
					System.out.println(diff + "/" + (i - diff + 1));
				}
				
//				break;
			}
		}
	}
}
