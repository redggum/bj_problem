import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/* 11718번 그대로 출력하기 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);

		ArrayList<String> arr = new ArrayList<String>();

		while(sc.hasNextLine()) {
			String in = sc.nextLine();
			
			if (in.isEmpty() || in == null) {
				break;
			}
			arr.add(in);
		}
		sc.close();
		
//		System.out.println(arr.size());
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}
}
