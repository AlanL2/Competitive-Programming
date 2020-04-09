import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
		int numOfBytes = Integer.parseInt(s.nextLine());
		
		String[] bytes = new String[numOfBytes];
		
		String input = s.nextLine();
		for (int i = 0; i < input.length() / 8; i++) {
			bytes[i] = input.substring(i * 8, i * 8 + 8);
		}
		
		ArrayList<Integer> results = new ArrayList<Integer>();
		
		int i = 0;
		String concat = "";
		
		while (i < bytes.length) {
			concat += bytes[i].substring(1);
			if (bytes[i].startsWith("0")) {
				//System.out.println(concat);
				System.out.print(Integer.parseUnsignedInt(concat, 2) + " ");
				concat = "";
			}                       
			i++;
		}
    }
}
