import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException {
        int n = readInt(), arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = readInt();
        }
        int[]dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i<n; i++){
            if(i+1<n)dp[i+1] = Math.min(dp[i+1], dp[i] + Math.abs(arr[i+1] - arr[i]));
            if(i+2<n)dp[i+2] = Math.min(dp[i+2], dp[i] + Math.abs(arr[i+2] - arr[i]));
        }
        System.out.println(dp[n-1]);
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
