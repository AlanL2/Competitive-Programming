import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException{
	long n = readLong();
	Queue<edge>Q = new LinkedList<>();
	Q.add(new edge(n, 0));
	int ans = 0;
	while(!Q.isEmpty()){
	    edge cur = Q.poll();
	    if(cur.v==1){
		ans = cur.w;
		break;
	    }
	    String[]val = Long.toString(cur.v).split("");
	    int div = 0;
	    for(int i = 0; i<val.length; i++){
		div+=Integer.parseInt(val[i]);
	    }
	    long a = cur.v-1, b = -1;
	    if(cur.v%b==0)b = cur.v/div;
	    if(b!=-1&&b!=cur.v)Q.add(new edge(b,cur.w+1));
	    Q.add(new edge(a, cur.w+1));
       }
       pr.println(ans);
       pr.close();
    }
    static class edge{
	long v; int w;
	edge(long v0, int w0){
	    v = v0;
	    w = w0;
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
}
