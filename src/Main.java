import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/* 2920번 음계 */

public class Main {
	static int[] num = new int[8];
	static int[] asc = new int[8];
	static Integer[] des = new Integer[8];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] strs = br.readLine().split(" ");
		
		boolean not = false;

		for (int i = 0; i < strs.length; i++) {
			num[i] = Integer.parseInt(strs[i]);
			asc[i] = num[i];
			des[i] = num[i];
		}

		Arrays.sort(asc);
		
		Arrays.sort(des, new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				return arg0 > arg1 ? -1 : 1;
			}
		});
		
		if (checkAsc()) {
			System.out.println("ascending");
		} else if (checkDes() ) {
			System.out.println("descending");			
		} else {
			System.out.println("mixed");			
		}
	}
	
	static boolean checkAsc() {
		for (int i = 0; i < asc.length; i++) {
			if (num[i] != asc[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	static boolean checkDes() {
		for (int i = 0; i < des.length; i++) {
			if (num[i] != des[i]) {
				return false;
			}
		}
		
		
		return true;
	}
}