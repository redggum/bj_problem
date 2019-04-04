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

/* 10952번 A+B - 5 */

public class Main {
	static int N, M, a, b;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] strs;

		while (true) {
			strs = br.readLine().split(" ");

			a = Integer.parseInt(strs[0]);
			b = Integer.parseInt(strs[1]);
			
			if (a == 0 && b == 0) {
				break;
			}
			
			System.out.println(a + b);
		}
	}
}
