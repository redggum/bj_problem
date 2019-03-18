import java.io.IOException;
import java.util.Scanner;

/* 11719번 그대로 출력하기 2 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String input = sc.nextLine();
            System.out.println(input);
        }
        sc.close();
	}
}
