import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException {
        int t = readInt();
        for(int z = 0; z<t; z++){
            int n = readInt();
            Map<Integer, Integer>mp = new HashMap<>(), map = new HashMap<>();
            for(int i = 0; i<n; i++){
                int a = readInt();
                if(!mp.containsKey(a)){
                    mp.put(a, i);
                }
            }
            for(int i = 0; i<n; i++){
                int a = readInt();
                map.put(a, i);
            }
            int ans = 0;
            for(int i = 1; i<=n; i++){
                if(!mp.containsKey(i)||!map.containsKey(i))continue;
                ans = Math.max(ans, map.get(i)-mp.get(i));
            }
            System.out.println("The maximum distance is " + ans);
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
