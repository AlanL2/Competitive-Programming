import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt();
        ArrayList<edge>adj[] = new ArrayList[n+1];
        for(int i = 1; i<=n; i++)adj[i] = new ArrayList<>();
        for(int i = 0; i<m; i++){
            int a = readInt(), b = readInt(), w = readInt();
            adj[a].add(new edge(b, w));
            adj[b].add(new edge(a, w));
        }
        int mindis[] = new int[n+1], maxdis[] = new int[n+1], dis[] = new int[n+1];
        Arrays.fill(mindis, Integer.MAX_VALUE);
        Arrays.fill(maxdis, Integer.MIN_VALUE);
        Queue<edge>Q = new LinkedList<>();
        Q.add(new edge(1, 0));
        boolean[]vis = new boolean[n+1];
        vis[1] = true; dis[1] = 0; mindis[1] = 0; maxdis[1] = 0;
        while(!Q.isEmpty()){
            edge cur = Q.poll();
            for(edge e:adj[cur.v]){
                if(!vis[e.v]){
                    vis[e.v] = true;
                    dis[e.v] = dis[cur.v]+1;
                    mindis[e.v] = mindis[cur.v]+e.w;
                    maxdis[e.v] = maxdis[cur.v]+e.w;
                    Q.add(new edge(e.v, dis[e.v]));
                }
                else if(vis[e.v]&&dis[e.v]==dis[cur.v]+1){
                    mindis[e.v] = Math.min(mindis[e.v], mindis[cur.v]+e.w);
                    maxdis[e.v] = Math.max(maxdis[e.v], maxdis[cur.v]+e.w);
                }
            }
        }
        int q = readInt();
        for(int i = 0; i<q; i++){
            String[]line = readLine().split(" ");
            int end = Integer.parseInt(line[0]);
            System.out.print(dis[end]+" ");
            if(line[1].equals("Black")){
                System.out.println(mindis[end]);
            }
            else{
                System.out.println(maxdis[end]);
            }
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
