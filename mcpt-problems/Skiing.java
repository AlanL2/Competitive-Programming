import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException{
	int t = readInt();
	for(int z = 0; z<t; z++){
	    int n = readInt();
	    long[][]dp = new long[n][n+2]; 
	    char[][]arr = new char[n][n];
	    for(int i = 0; i<n; i++){
		char[]line = readLine().toCharArray();
		arr[i] = line;
	    }
	    for(int i = 0; i<n; i++){
		for(int j = 0; j<n; j++){
		    if(i==0){
			if(arr[i][j]=='X')dp[i][j+1] = 0;
			else dp[i][j+1] = 1;
		    }
		    else{
			if(arr[i][j]=='O'){
			    dp[i][j+1] = dp[i-1][j]+dp[i-1][j+1]+dp[i-1][j+2];
			}
			else dp[i][j+1] = 0;
		    }
		}
	    }
	    long ans = 0; int mod = 1000000007;
	    for(int i = 1; i<=n; i++){
		ans = ((ans%mod)+(dp[n-1][i]%mod))%mod;
	    }
	    System.out.println(ans%mod);
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
