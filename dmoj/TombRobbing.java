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
            String s = readLine();
            for(int j = 0; j<m; j++){
                adj[i][j] = s.charAt(j);
            }
        }
        int ans = 0;
        vis = new boolean[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
               if(!vis[i][j]&&adj[i][j]!='X'){
                   ans++;
                   dfs(i, j, adj);
               }
            }
        }
        System.out.println(ans);
    }
    static void dfs(int x, int y, char[][]adj){
        vis[x][y] = true;
        if(x+1<n && adj[x+1][y]=='.' && !vis[x+1][y])dfs(x+1, y, adj);
        if(x-1>=0 && adj[x-1][y]=='.' && !vis[x-1][y])dfs(x-1, y, adj);
        if(y+1<m && adj[x][y+1]=='.' && !vis[x][y+1])dfs(x, y+1, adj);
        if(y-1>=0 && adj[x][y-1]=='.' && !vis[x][y-1])dfs(x, y-1, adj);
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
