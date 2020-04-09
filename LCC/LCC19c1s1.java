import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException{
	Date a = new Date(readInt(), readInt(), readInt()), end = (Date)a.clone();
	end.setDate(a.getDate()+readInt());
	Date b = new Date(readInt(), readInt(), readInt()), end1 = (Date)b.clone();
	end1.setDate(b.getDate()+readInt());
	if((end.after(b)&&a.before(end1))||(end1.after(a)&&b.before(a)))pr.println("YES");
	else pr.println("NO");
	pr.close();
    }
    static String next () throws IOException {
	while (st == null || !st.hasMoreTokens())
		st = new StringTokenizer(input.readLine().trim());
	return st.nextToken();
    }
    static long readLong () throws IOException {
	return Long.parseLong(next());
    }
    static int readInt () throws IOException {
	return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
	return Double.parseDouble(next());
    }
    static char readChar () throws IOException {
	return next().charAt(0);
    }
    static String readLine () throws IOException {
	return input.readLine().trim();
    }
}
