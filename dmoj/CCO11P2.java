import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static int ans = -1;
    public static void main(String[] args) throws IOException{
        int s = readInt(), n = readInt(), m = readInt();
        ArrayList<edge>adj[] = new ArrayList[n+1];
        for(int i = 0; i<n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i<m; i++){
            int a = readInt(), b = readInt(), w = readInt(), u = readInt();
            adj[a].add(new edge(b, w, u));
            adj[b].add(new edge(a, w, u));
        }
        int[][]dis = new int[s+1][n];
        for(int i = 0; i<=s; i++){
            Arrays.fill(dis[i], Integer.MAX_VALUE);
            dis[i][0] = 0;
        }
        PriorityQueue<edge>Q = new PriorityQueue<>();
        Q.add(new edge(0, 0, 0));
        while(!Q.isEmpty()){
            edge cur = Q.poll();
            if(cur.v==n-1){
                ans = cur.d;
                break;
            }
            for(edge e:adj[cur.v]){
                if(e.d==1){
                    if(cur.d+e.w<=s && cur.w+e.w<dis[cur.d+e.w][e.v]){
                        dis[cur.d+e.w][e.v] = cur.w+e.w;
                        Q.add(new edge(e.v, dis[cur.d+e.w][e.v], cur.d+e.w));
                    }
                }
                else if(cur.w+e.w<dis[cur.d][e.v]){
                    dis[cur.d][e.v] = cur.w+e.w;
                    Q.add(new edge(e.v, dis[cur.d][e.v], cur.d));
                }
            }
        }
        if(ans==-1)System.out.println(-1);
        else System.out.println(dis[ans][n-1]);
    }
    static class edge implements Comparable<edge>{
        int v, w, d;
        edge(int v0, int w0, int d0){
            v = v0;
            w = w0;
            d = d0;
        }
        @Override
        public int compareTo(edge e){
            if(w==e.w){
                return d-e.d;
            }
            return w-e.w;
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
