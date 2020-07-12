import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException{
        int n = 1000000;
        boolean[]arr = new boolean[n+1];
        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;
        for(int i = 2; i*i<=n; i++){
            if(arr[i]){
                for(int j = i*i; j<=n; j+=i){
                    arr[j] = false;
                }
            }
        }
        int t = readInt();
        for(int z = 0; z<t; z++){
            int s = readInt(), e = readInt(), ans = 0;
            for(int i = s; i<e; i++){
                if(arr[i])ans++;
            }
            System.out.println(ans);
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
