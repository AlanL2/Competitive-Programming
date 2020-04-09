import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static int[]dis, arr;
    static ArrayList<Integer>adj[];
    public static void main(String[] args) throws IOException{
	int n = readInt(), start = -1, prev[] = new int[n+1];
	arr = new int[n+1];
	adj = new ArrayList[n+1];
	for(int i = 1; i<=n; i++){
	    adj[i] = new ArrayList<>();
	}
	for(int i = 1; i<=n; i++){
	    int a = readInt();
	    prev[i] = a;
	    if(a!=0){
		adj[a].add(i);
	    }
	    else start = i;
	}
	for(int i = 1; i<=n; i++){
	    arr[i] = readInt();
	}
	dis = new int[n+1];
	dis[start] = dfs(start);
	for(int i = 1; i<=n; i++){
	    System.out.println(dis[i]);
	}
    }
    static int dfs(int u){
	for(int v:adj[u]){
	    dis[u]+=dis[v]+dfs(v);
	}
	dis[u]+=arr[u];
	return dis[u];
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
