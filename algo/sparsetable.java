import java.util.*;
import java.io.*;
import java.math.*;
/**
 *
 * @author alanl
 * https://dmoj.ca/problem/ncco3d2p1
 */
public class sparsetable {

    /**
     * @param args the command line arguments
     */
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException{
	int n = readInt(), q = readInt(), log = (int)(Math.log(n)/Math.log(2));
	//log = 31-Integer.numberOfLeadingZeros(n);
	int[][]max = new int[log+1][n+1], min = new int[log+1][n+1];
	for(int i = 1; i<=n; i++){
	    min[0][i] = max[0][i] = readInt();
	}
	for(int i = 1; i<=log; i++){
	    for(int j = 1; j+(1<<i)-1<=n; j++){
		max[i][j] = Math.max(max[i-1][j], max[i-1][j+(1<<(i-1))]);
		min[i][j] = Math.min(min[i-1][j], min[i-1][j+(1<<(i-1))]);
	    }
	}
	for(int i = 0; i<q; i++){
	    int a = readInt(), b = readInt(), k = 31-Integer.numberOfLeadingZeros(b-a+1);
	    int mm = Math.max(max[k][a], max[k][b-(1<<k)+1]), mi = Math.min(min[k][a], min[k][b-(1<<k)+1]);
	    System.out.println(mm-mi);
	}
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
    static void print(Object b) {
	System.out.print(b);
    }
    static void println(Object b) {
	System.out.println(b);
    }
    static void println() {
	System.out.println();
    }
}
