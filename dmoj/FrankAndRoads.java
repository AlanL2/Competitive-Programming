import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException{
        int t = readInt(), n = readInt(), m = readInt(), q = readInt(), arr[] = new int[q];
        for(int i = 0; i<q; i++)arr[i] = readInt();
        ArrayList<edge>adj[] = new ArrayList[n+1];
        for(int i = 0; i<=n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i<m; i++){
            int a = readInt(), b = readInt(), w = readInt();
            adj[a].add(new edge(b, w));
        }
        Queue<edge>Q = new LinkedList<>();
        int[]dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        Q.add(new edge(0, 0));
        while(!Q.isEmpty()){
            edge cur = Q.poll();
            for(edge e:adj[cur.v]){
                if(dis[e.v]>dis[cur.v]+e.w){
                    dis[e.v] = dis[cur.v]+e.w;
                    Q.add(new edge(e.v, dis[e.v]));
                }
            }
        }
        int ans = 0;
        for(int i = 0; i<q; i++){
            if(dis[arr[i]]<t)ans++;
        }
        System.out.println(ans);
    }
    static class edge{
        int v, w;
        edge(int v0, int w0){
            v = v0;
            w = w0;
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
