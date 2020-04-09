import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException{
	int n = readInt(); String[]arr = new String[n];
	for(int i = 0; i<n; i++){
	    String line = readLine();
	    HashMap<Character, Integer> mp = new HashMap<>();
	    int counter = 0; String ans = "";
	    for(int j = 0; j<line.length(); j++){
		if(!mp.containsKey(line.charAt(j))){
		    mp.put(line.charAt(j), counter);
		    counter++;
		}
		ans = ans+(Integer.toString(mp.get(line.charAt(j))));
	    }
	    arr[i] = ans;
	}
	HashMap<String, Integer>mp = new HashMap<>();
	int counter = -1; long val[] = new long[n];
	for(int i = 0; i<n; i++){
	    if(!mp.containsKey(arr[i])){
		counter++;
		mp.put(arr[i], counter);
		val[counter] = 1;
	    }
	    else val[mp.get(arr[i])]++;
	}
	long ans = 0;
	for(int i = 0; i<n; i++){
	    if(val[i]==2)ans++;
	    else if(val[i]>2){
		ans+=(val[i]*(val[i]-1))/2;
	    }
	}
	System.out.println(ans);
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
