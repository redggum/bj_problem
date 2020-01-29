import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/* 10828번 스택 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N;
		String cmd;
		int num;
		int index = -1;
		Stack<Integer> stack = new Stack<Integer>();
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			String[] strs = br.readLine().split(" "); 
			cmd = strs[0];
			
			if(cmd.equals("push")) {
				num = Integer.parseInt(strs[1]);
				stack.push(num);
			} else if(cmd.equals("pop")) {
				if(stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.peek());
					stack.pop();
				}
			} else if(cmd.equals("size")) {
				System.out.println(stack.size());
			} else if(cmd.equals("empty")) {
				if(stack.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if(cmd.equals("top")) {
//				System.out.println("size : " + stack.size());
				if(stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.peek());
				}
			}
		}
	}
}
