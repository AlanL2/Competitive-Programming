import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException{
	int n = readInt(), m = readInt();
	HashMap<String, Integer>mp = new HashMap<>();
	for(int i = 0; i<m; i++){
	    String[]line = readLine().split(" ");
	    mp.put(line[0], Integer.parseInt(line[1]));
	}
	for(int i = 0; i<n; i++){
	    String[]line = readLine().split(",");
	    int ans = 0;
	    for(int j = 0; j<line.length; j++){
		if(mp.containsKey(line[j]))ans+=mp.get(line[j]);
	    }
	    if(ans>=0)pr.println("real");
	    else pr.println("false");
	}
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
