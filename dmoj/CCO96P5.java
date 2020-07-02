import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException{
        int n = readInt(), q = readInt();
        Map<String, Integer> mp = new HashMap<>();
        Map<Integer, String> mp1 = new HashMap<>();
        mp.put("Rome", 0);
        mp1.put(0, "Rome");
        ArrayList<Integer>adj[] = new ArrayList[n*2];
        for(int i = 0; i<n*2; i++){
            adj[i] = new ArrayList<>();
        }
        int c = 1;
        for(int i = 0; i<n; i++){
            String a = next(), b = next();
            if(!mp.containsKey(a)){
                mp.put(a, c);
                mp1.put(c, a);
                c++;
            }
            if(!mp.containsKey(b)){
                mp.put(b, c);
                mp1.put(c, b);
                c++;
            }
            adj[mp.get(a)].add(mp.get(b));
            adj[mp.get(b)].add(mp.get(a));
        }
        for(int i = 0; i<q; i++){
            String start = next(), end = next();
            int s = mp.get(start), e = mp.get(end), prev[] = new int[n*2];
            prev[0] = -1;
            Queue<Integer>Q = new LinkedList<>();
            boolean[]vis = new boolean[n*2];
            Q.add(s); vis[s] = true;
            while(!Q.isEmpty()){
                int cur = Q.poll();
                if(cur==e)break;
                for(int v:adj[cur]){
                    if(!vis[v]){
                        vis[v] = true;
                        Q.add(v);
                        prev[v] = cur;
                    }
                }
            }
            Stack<String>st = new Stack<>();
            st.add(end);
            int cur = e;
            while(cur!=s){
                st.add(mp1.get(prev[cur]));
                cur = prev[cur];
            }
            while(!st.isEmpty()){
                System.out.print(st.pop().charAt(0));
            }
            System.out.println();
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
