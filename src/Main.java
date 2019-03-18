import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 1546번 평균 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = Integer.parseInt(br.readLine());
		String[] strs = br.readLine().split(" ");
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for (int i = 0; i < cnt; i++) {
			arr.add(Integer.parseInt(strs[i]));
		}
		
		Collections.sort(arr);
		
		double max = (double) arr.get(cnt - 1);
		double sum = 0;
		
//		System.out.println("max : " + max);
		
		for (int i = 0; i < cnt; i++) {
			sum += (arr.get(i) / max * 100);
		}
		
		System.out.println(sum / arr.size());
	}
}
