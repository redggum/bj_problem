import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 2309번 일곱 난쟁이 */

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dwarf = new int[9];
		int[] noDwarf = new int[2];
		int sum = 0;
		
		for (int i = 0; i < dwarf.length; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
			sum += dwarf[i];
		}
		
		for (int i = 0; i < dwarf.length; i++) {
			for (int j = i + 1; j < dwarf.length; j++) {
				if (sum - dwarf[i] - dwarf[j] == 100) {
					noDwarf[0] = dwarf[i];
					noDwarf[1] = dwarf[j];
				}
			}
		}
		
		Arrays.sort(dwarf);
		
		for (int i = 0; i < dwarf.length; i++) {
			if (dwarf[i] == noDwarf[0] || dwarf[i] == noDwarf[1]) {
				continue;
			}
			
			System.out.println(dwarf[i]);
		}
		
	}
}