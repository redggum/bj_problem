import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1924번 2007년 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		
		int month = Integer.parseInt(strs[0]);
		int day = Integer.parseInt(strs[1]);
		
//		0 : Sun
//		1 : Mon
//		2 : Tue
//		3 : Wed
//		4 : Thu
//		5 : Fri
//		6 : Sat
		String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		
		int[] mons = new int[13];
		mons[1] = 0;	// 31			% 7
		mons[2] = 31;	// 28
		mons[3] = 59;	// 31
		mons[4] = 90;	// 30
		mons[5] = 120;	// 31
		mons[6] = 151;	// 30
		mons[7] = 181;	// 31
		mons[8] = 212;	// 31
		mons[9] = 243;	// 30
		mons[10] = 273;	// 31
		mons[11] = 304;	// 30
		mons[12] = 334;	// 31
		
		System.out.println(week[(mons[month] + day) % 7]);
	}
}