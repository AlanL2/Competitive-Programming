import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static int r, c, counter = 0;
    static char[][]adj; 
    static boolean[][]vis;
    public static void main(String[] args) throws IOException{
	r = readInt(); c = readInt();
	char[][]arr = new char[r][c];
	for(int i = 0; i<r; i++){
	    String line = readLine();
	    for(int j = 0; j<c; j++){
		arr[i][j] = line.charAt(j);
	    }
	}
	adj = new char[r][c];
	for(int i = 0; i<r; i++){
	    String line = readLine();
	    for(int j = 0; j<c; j++){
		adj[i][j] = arr[i][j]!=line.charAt(j)?'.':'#';
	    }
	}
	vis = new boolean[r][c];
	for(int i = 0; i<r; i++){
	    for(int j = 0; j<c; j++){
		if(!vis[i][j]&&adj[i][j]=='.'){
		    counter++;
		    dfs(i, j);
		}
	    }
	}
	System.out.println(counter);
    }
    static void dfs(int x, int y){
	vis[x][y] = true;
	if(y+1<c&&!vis[x][y+1]&&adj[x][y+1]=='.'){//right
	    dfs(x, y+1);
	}
	if(y-1>=0&&!vis[x][y-1]&&adj[x][y-1]=='.'){//left
	    dfs(x, y-1);
	}
	if(x+1<r&&!vis[x+1][y]&&adj[x+1][y]=='.'){//down
	    dfs(x+1, y);
	}
	if(x-1>=0&&!vis[x-1][y]&&adj[x-1][y]=='.'){//up
	    dfs(x-1, y);
	}
	if(x-1>=0&&y-1>=0&&!vis[x-1][y-1]&&adj[x-1][y-1]=='.'){//top left
	    dfs(x-1, y-1);
	}
	if(x+1<r&&y+1<c&&!vis[x+1][y+1]&&adj[x+1][y+1]=='.'){//bottom right
	    dfs(x+1, y+1);
	}
	if(x-1>=0&&y+1<c&&!vis[x-1][y+1]&&adj[x-1][y+1]=='.'){//top right
	    dfs(x-1, y+1);
	}
	if(x+1<r&&y-1>=0&&!vis[x+1][y-1]&&adj[x+1][y-1]=='.'){//bottom left
	    dfs(x+1, y-1);
	}
	return;
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
