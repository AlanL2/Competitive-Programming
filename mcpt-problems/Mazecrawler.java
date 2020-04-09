import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static char[][]adj;
    static int n;
    static boolean[][]vis;
    public static void main(String[] args) throws IOException{
	int tests = readInt();
	for(int z = 0; z<tests; z++){
	    n = readInt();
	    int sx = 0, sy = 0;
	    adj = new char[n][n];
	    for(int i = 0; i<n; i++){
		char[]line = readLine().toCharArray();
		adj[i] = line;
		for(int j = 0; j<line.length; j++){
		    if(line[j]=='A'){
			sx = i;
			sy = j;
		    }
		}
	    }
	    vis = new boolean[n][n];
	    System.out.println(dfs(sx, sy));
	}
    }
    static int dfs(int x, int y){
	int ans = Integer.MIN_VALUE;
	if(adj[x][y]=='E')return 0;
	vis[x][y] = true;
	if(x-1>=0&&!vis[x-1][y]&&adj[x-1][y]!='#')ans = Math.max(ans, 1+dfs(x-1, y));
	if(x+1<n&&!vis[x+1][y]&&adj[x+1][y]!='#')ans = Math.max(ans, 1+dfs(x+1, y));
	if(y-1>=0&&!vis[x][y-1]&&adj[x][y-1]!='#')ans = Math.max(ans, 1+dfs(x, y-1));
	if(y+1<n&&!vis[x][y+1]&&adj[x][y+1]!='#')ans = Math.max(ans, 1+dfs(x, y+1));
	vis[x][y] = false;
	return ans;
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
