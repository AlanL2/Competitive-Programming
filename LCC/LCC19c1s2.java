import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException{
	int n = readInt(), arr[][] = new int[2*n][2*n];
	for(int i = 0; i<2*n; i++){
	    for(int j = 0; j<2*n; j++){
		arr[i][j] = readInt();
	    }
	}
	int ans = 0, left = 0, right = 2*n-1;
	for(int i = 0; i<n; i++){
	    int min = Integer.MAX_VALUE;
	    for(int j = left; j<=right; j++){
		if(arr[j][left]<min)min = arr[j][left];
		if(arr[j][right]<min)min = arr[j][right];
		if(arr[left][j]<min)min = arr[left][j];
		if(arr[right][j]<min)min = arr[right][j];
	    }
	    ans+=min;
	    left++;
	    right--;
	}
	pr.println(ans);
	pr.close();
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
