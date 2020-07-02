import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static boolean[]vis = new boolean[10];
    static int n, m;
    public static void main(String[] args) throws IOException{
        n = readInt(); m = readInt();
        int sx = -1, sy = -1;
        char[][]adj = new char[m][n];
        for(int i = 0; i<m; i++){
            String line = readLine();
            for(int j = 0; j<n; j++){
                adj[i][j] = line.charAt(j);
                if(adj[i][j]=='1'){
                    sx = i;
                    sy = j;
                }
            }
        }
        dfs(sx, sy, adj);
        boolean print = false;
        for(int i = 0; i<vis.length; i++){
            if(vis[i]){
                if(!print){
                    System.out.print(i);
                    print = true;
                }
                else System.out.print(" "+i);
            }
        }
        System.out.println();
    }
    static void dfs(int x, int y, char[][]adj){
        if(adj[x][y]!='O'&&adj[x][y]!='#'){
            vis[Character.getNumericValue(adj[x][y])] = true;
        }
        adj[x][y] = '#';
        if(x+1<m&&adj[x+1][y]!='#'){
            dfs(x+1, y, adj);
        }
        if(x-1>=0&&adj[x-1][y]!='#'){
            dfs(x-1, y, adj);
        }
        if(y+1<n&&adj[x][y+1]!='#'){
            dfs(x, y+1, adj);
        }
        if(y-1>=0&&adj[x][y-1]!='#'){
            dfs(x, y-1, adj);
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
