
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out))); static char[][]adj; 
    static int n, dis[][], ex = 0, ey = 0;
    public static void main(String[] args) throws IOException{
	n = readInt();
	adj = new char[n][n]; 
	dis = new int[n][n];
	int sx = 0, sy = 0; 
	for(int i = 0; i<n; i++){
	    String line = readLine();
	    for(int j = 0; j<n; j++){
		char a = line.charAt(j);
		if(a=='S'){
		    sx = i; sy = j;
		}
		else if(a=='E'){
		    ex = i; ey = j;
		}
		adj[i][j] = a;
		dis[i][j] = 250001;
	    }
	}
	dis[sx][sy] = 0;
	Queue<edge>Q = new LinkedList<>();
	Q.add(new edge(sx, sy));
	while(!Q.isEmpty()){
	    edge cur = Q.poll();
	    if(cur.y+1<n&&dis[cur.x][cur.y+1]>dis[cur.x][cur.y]+1&&(adj[cur.x][cur.y+1]=='.'||adj[cur.x][cur.y+1]=='E')){//right
		dis[cur.x][cur.y+1] = Math.min(dis[cur.x][cur.y+1], dis[cur.x][cur.y]+1);
		Q.add(new edge(cur.x, cur.y+1));
	    }
	    if(cur.y-1>=0&&dis[cur.x][cur.y-1]>dis[cur.x][cur.y]+1&&(adj[cur.x][cur.y-1]=='.'||adj[cur.x][cur.y-1]=='E')){//left
		dis[cur.x][cur.y-1] = Math.min(dis[cur.x][cur.y-1], dis[cur.x][cur.y]+1);
		Q.add(new edge(cur.x, cur.y-1));
	    }
	    if(cur.x+1<n&&dis[cur.x+1][cur.y]>dis[cur.x][cur.y]+1&&(adj[cur.x+1][cur.y]=='.'||adj[cur.x+1][cur.y]=='E')){//down
		dis[cur.x+1][cur.y] = Math.min(dis[cur.x+1][cur.y], dis[cur.x][cur.y]+1);
		Q.add(new edge(cur.x+1, cur.y));
	    }
	    if(cur.x-1>=0&&dis[cur.x-1][cur.y]>dis[cur.x][cur.y]+1&&(adj[cur.x-1][cur.y]=='.'||adj[cur.x-1][cur.y]=='E')){//up
		dis[cur.x-1][cur.y] = Math.min(dis[cur.x-1][cur.y], dis[cur.x][cur.y]+1);
		Q.add(new edge(cur.x-1, cur.y));
	    }
	}
	if(dis[ex][ey]==250001)System.out.println("There is no path, Andy!");
	else System.out.println(dis[ex][ey]);
    }
    static class edge{
	int x, y;
	edge(int x0, int y0){
	    x = x0;
	    y = y0;
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
