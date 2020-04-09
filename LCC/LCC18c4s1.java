import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException{
	try{
	int n = readInt(); double counter = 0;
	String[]arr = new String[n];
	double percentage = 0;
	for(int i = 0; i<n; i++){
	    String val = readLine();
	    String line[] = val.split(" ");
	    arr[i] = val;
	    if(line[1].equals("added")){
		counter+=Double.parseDouble(line[0]);
	    }
	    else if(line[1].equals("increased")){
		percentage+=Double.parseDouble(line[0]);
	    }
	}
	percentage/=100;
	percentage+=1;
	counter*=percentage;
	for(int i = 0; i<n; i++){
	    String line[] = arr[i].split(" ");
	    if(line[1].equals("more")){
		counter*=1+(Double.parseDouble(line[0])/100);
	    }
	}
	String ans = Double.toString(counter);
	String[]arr1 = ans.split("\\.0");
	pr.println(arr1[0]);
	pr.close();
	} catch (Exception e){
	    System.out.println(0);
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
	static String readLine () throws IOException {
		return input.readLine().trim();
	}
}
