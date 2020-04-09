import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static int n = 0, arr[][];
    public static void main(String[] args) throws IOException{
	n = readInt(); int q = readInt(); 
	arr = new int[5030][5030];
	for(int i = 0; i<q; i++){
	    int a = readInt();
	    if(a==1){
		int x = readInt(), y = readInt(), x1 = readInt(), y1 = readInt(), val = readInt();
		update(x, y, val);
		update(x, y1+1, -val);
		update(x1+1, y, -val);
		update(x1+1, y1+1, val);
	    }
	    else{
		int x = readInt(), y = readInt();
		pr.println(solve(x, y));
	    }
	}
	pr.close();
    }
    static void update(int a, int b, int val){
	for(int i = a; i<=n; i+=(i&-i)){
	    for(int j = b; j<=n; j+=(j&-j)){
		arr[i][j]+=val;
	    }
	}
    }
    static int solve(int a, int b){
	int counter = 0;
	for(int i = a; i>0; i-=(i&-i)){
	    for(int j = b; j>0; j-=(j&-j)){
		counter+=arr[i][j];
	    }
	}
	return counter;
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
