import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static boolean[][]vis;
    static int n, m;
    public static void main(String[] args) throws IOException{
        n = readInt(); m = readInt();
        char[][]adj = new char[n][m];
        for(int i = 0; i<n; i++){
            String line = readLine();
            for(int j = 0; j<m; j++){
                adj[i][j] = line.charAt(j);
            }
        }
        int ans = 0;
        vis = new boolean[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(!vis[i][j]){
                    dfs(i, j, adj);
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
    static void dfs(int x, int y, char[][]adj){
        vis[x][y] = true;
        if(x-1>=0&&adj[x-1][y]=='S'&&!vis[x-1][y])dfs(x-1, y, adj);
        if(x+1<n&&adj[x+1][y]=='N'&&!vis[x+1][y])dfs(x+1, y, adj);
        if(y-1>=0&&adj[x][y-1]=='E'&&!vis[x][y-1])dfs(x, y-1, adj);
        if(y+1<m&&adj[x][y+1]=='W'&&!vis[x][y+1])dfs(x, y+1, adj);
        if(adj[x][y]=='S'&&!vis[x+1][y])dfs(x+1, y, adj);
        else if(adj[x][y]=='N'&&!vis[x-1][y])dfs(x-1, y, adj);
        else if(adj[x][y]=='E'&&!vis[x][y+1])dfs(x, y+1, adj);
        else if(adj[x][y]=='W'&&!vis[x][y-1])dfs(x, y-1, adj);
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
