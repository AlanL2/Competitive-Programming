import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException{
        int h = readInt(), v = readInt(), a[] = new int[h], b[] = new int[v];
        Map<Integer, Integer>mp = new HashMap();
        for(int i = 0; i<h; i++){
            a[i] = readInt();
        }
        for(int i = 0; i<h; i++){
            for(int j = i+1; j<h; j++){
                mp.put(a[j]-a[i], mp.getOrDefault(a[j]-a[i], 0)+1);
            }
        }
        for(int i = 0; i<v; i++){
            b[i] = readInt();
        }
        long ans = 0;
        for(int i = 0; i<v; i++){
            for(int j = i+1; j<v; j++){
                ans+=mp.getOrDefault(b[j]-b[i], 0);
            }
        }
        println(ans);
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
    static void print(Object b) {
        System.out.print(b);
    }
    static void println(Object b) {
        System.out.println(b);
    }
    static void println() {
        System.out.println();
    }
}
