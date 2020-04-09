import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static ArrayList<Integer>path, adj[];
    static boolean[]vis;
    static int counter = 0;
    public static void main(String[] args) throws IOException{
	int n = readInt(), root = readInt(), m = readInt();
	adj = new ArrayList[n+1];
	path = new ArrayList<>();
	vis = new boolean[n+1];
	for(int i = 1; i<=n; i++)adj[i] = new ArrayList<>();
	for(int i = 0; i<n-1; i++){
	    int a = readInt(), b = readInt();
	    adj[a].add(b); 
	    adj[b].add(a);
	}
	dfs(root);
	Collections.sort(path);
	pr.println(path.get(m-1));
	pr.close();
    }
    static int dfs(int u){
	vis[u] = true;
	counter = 1;
	for(int v:adj[u]){
	    if(!vis[v])counter+=dfs(v);
	}
	path.add(counter);
	return counter;
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
