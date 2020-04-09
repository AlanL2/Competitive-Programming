import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException{
	int n = readInt(), k = readInt(), arr[] = new int[n];
	for(int i = 0; i<n; i++)arr[i] = readInt();
	long[]psa = new long[n+1];
	for(int i = 0; i<n; i++){
	    psa[i+1] = psa[i]+(long)arr[i];
	}
	int ans = n+1;
	Deque<Integer>Q = new LinkedList<>();
	for(int i = 0; i<psa.length; i++){
	    while(!Q.isEmpty()&&psa[i]<=psa[Q.getLast()]){
		Q.removeLast();
	    }
	    while(!Q.isEmpty()&&psa[i]>=psa[Q.getFirst()]+k){
		ans = Math.min(ans, i-Q.removeFirst());
	    }
	    Q.addLast(i);
	}
	if(ans<n+1)pr.println(ans);
	else pr.println(-1);
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
