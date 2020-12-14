import java.util.*;
import java.io.*;
import java.math.*;
/**
 *  
 * @author alanl
 */
public class Kruskals {

    /**
     * @param args the command line arguments
     */
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static int[]idx, arr;
    static ArrayList<Integer>edges = new ArrayList();
    public static void main(String[] args) throws IOException{
        int n = readInt(), m = readInt();
        idx = new int[n+1];
        arr = new int[n+1];
        for(int i = 1; i<=n; i++){
            idx[i] = i;
        }
        for(int i = 1; i<=m; i++){
            int a = readInt(), b = readInt();
            if(find(a)!=find(b)){
                edges.add(i);
                solve(a, b);
            }
        }
        for(int i = 1; i<=n; i++){
            find(i);
        }
        Arrays.sort(idx);
        if(idx[1]!=idx[n]){
            println("Disconnected Graph");
            return;
        }
        for(int i:edges)println(i);
    }
    static int find(int x){
        if(idx[x]==x)return x;
        else return idx[x] = find(idx[x]);
    }
    static void solve(int a, int b){
        a = find(a);
        b = find(b);
        if(idx[a]==idx[b])return;
        else if(arr[a]>arr[b])idx[b] = a;
        else if(arr[a]<arr[b])idx[a] = b;
        else{
            idx[a] = b;
            arr[b]++;
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
