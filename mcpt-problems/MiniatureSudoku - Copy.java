import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static ArrayList<pair>arr;
    static char[][]ans = new char[4][4];
    static boolean flag;
    public static void main(String[] args) throws IOException{
	int q = readInt();
	for(int z = 0; z<q; z++){
	    char[][]adj = new char[4][4];
	    arr = new ArrayList<>();
	    flag = false;
	    for(int i = 0; i<4; i++){
		char[]line = readLine().toCharArray();
		adj[i] = line;
		for(int j = 0; j<4; j++){
		    if(adj[i][j]=='X')arr.add(new pair(i, j));
		}
	    }
	    solve(0, adj);
	    for(int i = 0; i<4; i++){
		System.out.println(new String(ans[i]));
	    }
	}
    }
    static void solve(int cur, char[][]adj){
	if(arr.size()==0||cur==arr.size()){
	    for(int i = 0; i<4; i++){
		for(int j = 0; j<4; j++){
		    ans[i][j] = adj[i][j];
		}
	    }
	    flag = true;
	    return;
	}
	int x = arr.get(cur).x, y = arr.get(cur).y;
	boolean[]vis = new boolean[5];
	if(adj[0][y]!='X')vis[Integer.parseInt(String.valueOf(adj[0][y]))] = true;
	if(adj[1][y]!='X')vis[Integer.parseInt(String.valueOf(adj[1][y]))] = true;
	if(adj[2][y]!='X')vis[Integer.parseInt(String.valueOf(adj[2][y]))] = true;
	if(adj[3][y]!='X')vis[Integer.parseInt(String.valueOf(adj[3][y]))] = true;
	if(adj[x][0]!='X')vis[Integer.parseInt(String.valueOf(adj[x][0]))] = true;
	if(adj[x][1]!='X')vis[Integer.parseInt(String.valueOf(adj[x][1]))] = true;
	if(adj[x][2]!='X')vis[Integer.parseInt(String.valueOf(adj[x][2]))] = true;
	if(adj[x][3]!='X')vis[Integer.parseInt(String.valueOf(adj[x][3]))] = true;
	if(x==0&&y==0||x==2&&y==0||x==0&&y==2||x==2&&y==2){
	    if(adj[x][y+1]!='X')vis[Integer.parseInt(String.valueOf(adj[x][y+1]))] = true;
	    if(adj[x+1][y]!='X')vis[Integer.parseInt(String.valueOf(adj[x+1][y]))] = true;
	    if(adj[x+1][y+1]!='X')vis[Integer.parseInt(String.valueOf(adj[x+1][y+1]))] = true;
	}
	else if(x==0&&y==1||x==2&&y==1||x==0&&y==3||x==2&&y==3){
	    if(adj[x][y-1]!='X')vis[Integer.parseInt(String.valueOf(adj[x][y-1]))] = true;
	    if(adj[x+1][y]!='X')vis[Integer.parseInt(String.valueOf(adj[x+1][y]))] = true;
	    if(adj[x+1][y-1]!='X')vis[Integer.parseInt(String.valueOf(adj[x+1][y-1]))] = true;
	}
	else if(x==1&&y==0||x==3&&y==0||x==1&&y==2||x==3&&y==2){
	    if(adj[x][y+1]!='X')vis[Integer.parseInt(String.valueOf(adj[x][y+1]))] = true;
	    if(adj[x-1][y]!='X')vis[Integer.parseInt(String.valueOf(adj[x-1][y]))] = true;
	    if(adj[x-1][y+1]!='X')vis[Integer.parseInt(String.valueOf(adj[x-1][y+1]))] = true;
	}
	else{
	    if(adj[x][y-1]!='X')vis[Integer.parseInt(String.valueOf(adj[x][y-1]))] = true;
	    if(adj[x-1][y]!='X')vis[Integer.parseInt(String.valueOf(adj[x-1][y]))] = true;
	    if(adj[x-1][y-1]!='X')vis[Integer.parseInt(String.valueOf(adj[x-1][y-1]))] = true;
	}
	for(int i = 1; i<=4; i++){
	    if(flag)return;
	    if(!vis[i]){
		if(flag)return;
		adj[x][y] = (char)(i+'0');
		solve(cur+1, adj);
		adj[x][y] = 'X';
		if(flag)return;
	    }
	}
    }
    static class pair{
	int x, y;
	pair(int x0, int y0){
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
