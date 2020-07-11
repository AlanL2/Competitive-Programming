import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt(), mod = 1000000007;
        char[][]adj = new char[n][m];
        for(int i = 0; i<n; i++){
            String line = readLine();
            for(int j = 0; j<m; j++){
                adj[i][j] = line.charAt(j); 
            }
        }
        int[][]dp = new int[n][m];
        dp[0][0] = 1;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(i==0&&j==0||adj[i][j]=='#')continue;
                if(i==0||adj[i-1][j]=='#'){
                    if(j==0)dp[i][j] = 0;
                    else dp[i][j] = dp[i][j-1];
                }
                else if(j==0||adj[i][j-1]=='#'){
                    if(i==0)dp[i][j] = 0;
                    else dp[i][j] = dp[i-1][j];
                }
                else dp[i][j] = ((dp[i-1][j]%mod)+(dp[i][j-1]%mod))%mod;
            }
        }
        System.out.println(dp[n-1][m-1]);
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
