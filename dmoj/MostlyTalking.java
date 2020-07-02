import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException{
        int n = readInt(), m = readInt();
        ArrayList<edge>adj[] = new ArrayList[n+1], adj1[] = new ArrayList[n+1];
        for(int i = 0; i<=n; i++){
            adj[i] = new ArrayList<>(); 
            adj1[i] = new ArrayList<>();
        }
        for(int i = 0; i<m; i++){
            int a = readInt(), b = readInt(), w = readInt();
            adj[a].add(new edge(b, w));
            adj1[b].add(new edge(a, w));
        }
        long[]dis = new long[n+1];
        Arrays.fill(dis, Long.MAX_VALUE);
        dis[1] = 0;
        Queue<edge>Q = new LinkedList<>();
        Q.add(new edge(1, 0));
        while(!Q.isEmpty()){
            edge cur = Q.poll();
            for(edge e:adj[cur.v]){
                if(dis[e.v]>dis[cur.v]+e.w){
                    dis[e.v] = dis[cur.v]+e.w;
                    Q.add(new edge(e.v, dis[e.v]));
                }
            }
        }
        long[]dis1 = new long[n+1];
        Arrays.fill(dis1, Long.MAX_VALUE);
        dis1[n] = 0;
        Q.add(new edge(n, 0));
        while(!Q.isEmpty()){
            edge cur = Q.poll();
            for(edge e:adj1[cur.v]){
                if(dis1[e.v]>dis1[cur.v]+e.w){
                    dis1[e.v] = dis1[cur.v]+e.w;
                    Q.add(new edge(e.v, dis1[e.v]));
                }
            }
        }
        int d = readInt();
        long ans = Long.MAX_VALUE;
        for(int i = 0; i<d; i++){
            int s = readInt(), e = readInt(), w = readInt();
            if(dis[s]!=Long.MAX_VALUE&&dis1[e]!=Long.MAX_VALUE){
                ans = Math.min(ans, dis[s] + dis1[e] + w);
            }
        }
        ans = Math.min(ans, dis[n]);
        if(ans==Long.MAX_VALUE)System.out.println(-1);
        else System.out.println(ans);
    }
    static class edge{
        int v;
        long w;
        edge(int v0, long w0){
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
