import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	int n = input.nextInt();
	System.out.println((((input.nextLong()-12345+2147483648l)%2147483648l)*1857678181)%2147483648l);
    }
}
