import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException{
	int n = readInt(); ArrayList<Integer>negative = new ArrayList<>(), positive = new ArrayList<>();
	for(int i = 0; i<n; i++){
	    int a = readInt();
	    if(a<0)negative.add(a);
	    else positive.add(a);
	}
	Collections.sort(negative);
	Collections.sort(positive);
	long ans = 0;
	for(int i = 0; i<negative.size()-1; i+=2){
	    ans+=negative.get(i)*negative.get(i+1);
	}
	for(int i = positive.size()-1; i>0; i-=2){
	    ans+=positive.get(i)*positive.get(i-1);
	}
	System.out.println(ans);
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
