import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException {
	int n = readInt();
	Integer[][]arr = new Integer[n][2];
	for(int i = 0; i<n; i++){
	    arr[i][0] = readInt();
	    arr[i][1] = readInt();
	}
	Arrays.sort(arr, new Comparator<Integer[]>() {
	    @Override
	    public int compare(Integer[]arr1, Integer[]arr2){
		return arr1[1].compareTo(arr2[1]);
	    }
	});
	boolean[]vis = new boolean[n];
	boolean flag = false;
	int cur = 1, counter = 0;
	while(cur<=50){
	    for(int i = 0; i<n; i++){
		if(cur>=arr[i][0]&&cur<arr[i][1]&&!vis[i]){
		    flag = true;
		    cur++;
		    counter++;
		    vis[i] = true;
		    i = 0;
		}
	    }
	    if(flag)flag = false;
	    else cur++;
	}
	pr.println(counter);
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
