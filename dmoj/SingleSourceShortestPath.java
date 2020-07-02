import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt();
        ArrayList<edge>adj[] = new ArrayList[n+1];
        for(int i = 1; i<=n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i<m; i++){
            int a = readInt(), b = readInt(), w = readInt();
            adj[a].add(new edge(b, w));
            adj[b].add(new edge(a, w));
        }
        Queue<edge>Q = new LinkedList<>();
        int[]dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1] = 0;
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
        for(int i = 1; i<=n; i++){
            if(dis[i]==Integer.MAX_VALUE)System.out.println(-1);
            else System.out.println(dis[i]);
        }
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
