import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static int[]id, arr;
    public static void main(String[] args) throws IOException{
	int n = readInt(), m = readInt();
	id = new int[n];
	arr = new int[n];
	for(int i = 0; i<n; i++){
	    id[i] = i;
	    arr[i] = i;
	}
	ArrayList<edge>adj = new ArrayList<>();
	for(int i = 0; i<m; i++){
	    int a = readInt()-1, b = readInt()-1, c = readInt();
	    adj.add(new edge(a, b, c));
	}
	Collections.sort(adj);
	for(edge e:adj){
	    merge(e.u, e.v);
	    if(find(0)==find(n-1)){
		System.out.println(e.w);
		return;
	    }
	}
	System.out.println(-1);
    }
    static int find(int x){
	if(x==id[x])return x;
	else return id[x] = find(id[x]);
    }
    static void merge(int x, int y){
	x = find(x); 
	y = find(y);
	if(arr[x]>arr[y]){
	    arr[x]+=arr[y];
	    id[y] = x;
	}
	else{
	    arr[y]+=arr[x];
	    id[x] = y;
	}
    }
    static class edge implements Comparable<edge>{
	int u, v, w;
	edge(int u0, int v0, int w0){
	    u = u0;
	    v = v0;
	    w = w0;
	}
	@Override
	public int compareTo(edge e){
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
