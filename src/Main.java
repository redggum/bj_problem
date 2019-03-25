import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 10845번 큐 */

public class Main {
	
	static List<Integer> arr = new ArrayList<Integer>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] strs;
		String cmd;
		int param = 0;
		
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			if (strs.length > 1) {
				param = Integer.parseInt(strs[1]);
			}
			
			cmd = strs[0];
			
			queue(cmd, param);
		}
	}
	
	static void queue(String command, int param) {
//		System.out.println("cmd : " + command);
		
		if (command.equals("push")) {
			arr.add(param);
		} else if (command.equals("pop")) {
			if (arr.size() == 0) {
				System.out.println(-1);
			} else {
				System.out.println(arr.get(0));
				arr.remove(arr.get(0));
			};
		} else if (command.equals("size")) {
			System.out.println(arr.size());
		} else if (command.equals("empty")) {
			System.out.println(arr.size() == 0 ? 1 : 0);
		} else if (command.equals("front")) {
			if (arr.size() == 0) {
				System.out.println(-1);
			} else {
				System.out.println(arr.get(0));
			};
		} else if (command.equals("back")) {
			if (arr.size() == 0) {
				System.out.println(-1);
			} else {
				System.out.println(arr.get(arr.size() - 1));
			};
		}
	}

}