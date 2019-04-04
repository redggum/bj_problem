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

/* 2442번 별 찍기 - 5 */

public class Main {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		String str;
		
		for (int i = 1; i <= N; i++) {
			str = "";
			
			for (int j = 1; j <= N - i; j++) {
				str += " ";
			}
			
			for (int j = 1; j <= 2 * i - 1; j++) {
				str += "*";
			}
			
			System.out.println(str);
		}
	}
}