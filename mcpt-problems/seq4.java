import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException{
	int n = readInt(), m = readInt(), arr[] = new int[n], reverse[] = new int[n];
	boolean reversed = false;
	int[]psa = new int[n+1], rpsa = new int[n+1];
	for(int i = 0; i<n; i++){
	    arr[i] = readInt();
	    if(i==0)psa[i+1] = arr[i];
	    else{
		psa[i+1] = psa[i]+arr[i];
	    }
	}
	for(int i = 0; i<n; i++){
	    reverse[i] = arr[n-i-1];
	    if(i==0)rpsa[i+1] = reverse[i];
	    else rpsa[i+1] = rpsa[i]+reverse[i];
	}
	for(int i = 0; i<m; i++){
	    String[]line = readLine().split(" ");
	    if(line[0].equals("REVERSE"))reversed = !reversed;
	    else if(line[0].equals("MAX-SUM")){
		if(reversed)System.out.println(max(reverse, n));
		else System.out.println(max(arr, n));
	    }
	    else{
		int pos = Integer.parseInt(line[1]), tot = Integer.parseInt(line[2]);
		if(reversed)System.out.println(rpsa[pos+tot-1]-rpsa[pos-1]);
		else System.out.println(psa[pos+tot-1]-psa[pos-1]);
	    }
	}
    }
    static int max(int arr[], int n){
	int ans = Integer.MIN_VALUE, max = 0;
	for(int i = 0; i<n; i++){
	    max+=arr[i];
	    if(ans<max)ans = max; 
	    if(max<0)max = 0; 
	} 
	return ans; 
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
