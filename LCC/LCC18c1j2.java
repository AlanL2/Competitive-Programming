
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException{
	int n = readInt(); String[][]arr = new String[n][2];
	for(int i = 0; i<n; i++){
	    String[]split = readLine().split("\\-");
	    arr[i][0] = split[0];
	    arr[i][1] = split[1];
	}
	String val = readLine();
	String[]q = val.split("\\.");
	boolean flag = true, inRange = false;
	for(int i = 0; i<n; i++){
	    String[]split = arr[i][0].split("\\.");
	    for(int j = 0; j<4; j++){
		if(Integer.parseInt(split[j])<Integer.parseInt(q[j])){
		    inRange = true;
		    break;
		}
		else if(Integer.parseInt(split[j])>Integer.parseInt(q[j])){
		    inRange = false;
		    break;
		}
	    }
	    if(inRange){
		split = arr[i][1].split("\\.");
		for(int j = 0; j<4; j++){
		    if(Integer.parseInt(split[j])>Integer.parseInt(q[j])){
			flag = false;
			break;
		    }
		    else if(Integer.parseInt(split[j])<Integer.parseInt(q[j]))break;
		}
	    }
	    if(!flag)break;
	}
	if(flag)System.out.println("good ip");
	else System.out.println("bad ip");
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
