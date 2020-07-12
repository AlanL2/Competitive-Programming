import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException{
        int n = readInt(), k = readInt(), arr[] = new int[n], idx[] = new int[n+1];
        for(int i = 0; i<n; i++){
            arr[i] = readInt();
            idx[arr[i]] = i;
        }
        int cur = n;
        for(int i = 0; i<k; i++){
            if(cur==0)break;
            if(idx[cur]!=n-cur){
                int sub = idx[cur], num = arr[n-cur];
                idx[cur] = n-cur;
                idx[num] = sub;
                arr[n-cur] = cur;
                arr[sub] = num;
            }
            else{
                i--;
            }
            cur--;
        }
        for(int i = 0; i<n; i++){
            if(i==n-1)System.out.println(arr[i]);
            else System.out.print(arr[i] + " ");
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
