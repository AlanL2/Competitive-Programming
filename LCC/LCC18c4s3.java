import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException{
	int n = readInt(), diff = readInt();
	Map<Integer, Integer>f = new HashMap<>(), t = new HashMap<>();
	for(int i = 0; i<n; i++){
	    int day = readInt();
	    String val = next();
	    int cost = readInt();
	    if(val.equals("T")){
		if(t.containsKey(day)){
		    int cur = t.get(day);
		    if(cur>cost)t.remove(day);
		}
		t.put(day, cost);
	    }
	    else{
		if(f.containsKey(day)){
		    int cur = f.get(day);
		    if(cur>cost)f.remove(day);
		}
		f.put(day, cost);
	    }
	}
	long min = Long.MAX_VALUE;
	if(f.size()>t.size()){
	    for(Map.Entry<Integer, Integer> i:t.entrySet()){
		int k = i.getKey(), v = i.getValue();
		if(f.containsKey(k+diff)){
		    v+=f.get(k+diff);
		    min = Math.min(min, v);
		}
	    }
	}
	else{
	    for(Map.Entry<Integer, Integer> i:f.entrySet()){
		int k = i.getKey(), v = i.getValue();
		if(t.containsKey(k-diff)){
		    v+=t.get(k-diff);
		    min = Math.min(min, v);
		}
	    }
	}
	if(min==Long.MAX_VALUE)System.out.println(-1);
	else System.out.println(min);
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
