/*Clone of https://dmoj.ca/problem/ncco4d1p3, except less strict on time, directed paths instead of undirected, and a -1 edge case. */

import java.io.*;
import java.util.*;

public class Main {
    private static Reader in;
    private static PrintWriter out;
    private static final String INPUT_FILE_NAME = "input.txt";
    private static final String OUTPUT_FILE_NAME = "output.txt";
    private static boolean stdIn = true;
    private static boolean stdOut = true;
    private static boolean crash = true;
    private static boolean flush = false;
    public static void main(String[] args) throws IOException{
	if (stdIn) in = new Reader(System.in);
	else in = new Reader(INPUT_FILE_NAME);
	if (stdOut) out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	else out = new PrintWriter(new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME)));
	int n = in.nextInt(), m = in.nextInt();
	ArrayList<edge>adj[] = new ArrayList[n+1];
	for(int i = 0; i<=n; i++){
            adj[i] = new ArrayList<edge>();
        }
	for(int i = 0; i<m; i++){
	    int a = in.nextInt(), b = in.nextInt(), w = in.nextInt();
	    adj[a].add(new edge(b, w));
	}
	int[]dis = new int[n+1], dis1 = new int[n+1];
	Arrays.fill(dis, Integer.MAX_VALUE); Arrays.fill(dis1, Integer.MAX_VALUE);
	dis[1] = 0;
	PriorityQueue<edge>Q = new PriorityQueue<edge>();
	Q.add(new edge(1,0));
	while(!Q.isEmpty()){
	    edge cur = Q.poll();
	    for(edge e:adj[cur.v]){
		if(dis[e.v]>dis[cur.v]+e.w){
		    dis1[e.v] = dis[e.v];
		    dis[e.v] = cur.w + e.w;
		    Q.add(new edge(e.v,dis[e.v]));
		}
		else if(cur.w+e.w<dis1[e.v]&&dis[e.v]!=cur.w+e.w){
		    dis1[e.v] = cur.w+e.w;
		    Q.add(new edge(e.v,dis1[e.v]));
		}
	    }
	}
        if(dis1[n]==Integer.MAX_VALUE)out.println(-1);
        else out.println(dis1[n]);
	out.close();
    }
    static class edge implements Comparable<edge>{
	int v, w;
	edge(int v0, int w0){
	    v = v0; 
            w = w0;
	}
	@Override
	public int compareTo(edge compareEdge){
	    if(this.w>compareEdge.w)return 1;
	    else if(this.w<compareEdge.w)return -1;
	    else return 0;
	}
    }
    public static class Reader {
	private final int BUFFER_SIZE = 1 << 12;
	private int LENGTH = -1;
	private DataInputStream din;
	private byte[] buffer;
	private int bufferPointer, bytesRead;

	public Reader(InputStream inputStream) {
	    din = new DataInputStream(inputStream);
	    buffer = new byte[BUFFER_SIZE];
	    bufferPointer = bytesRead = 0;
	}

	public Reader(String file_name) throws IOException {
	    din = new DataInputStream(new FileInputStream(file_name));
	    buffer = new byte[BUFFER_SIZE];
	    bufferPointer = bytesRead = 0;
	}

	public int nextInt() throws IOException {
	    int ret = 0;
	    byte c;
	    do {
		c = read();
	    } while (c <= ' ');
	    boolean neg = (c == '-');
	    if (neg) c = read();
	    do {
		ret = ret * 10 + c - '0';
	    } while ((c = read()) >= '0');
	    if (neg) return -ret;
	    return ret;
	}

	public long nextLong() throws IOException {
	    long ret = 0;
	    byte c;
	    do {
		c = read();
	    } while (c <= ' ');
	    boolean neg = (c == '-');
	    if (neg) c = read();
	    do {
		ret = ret * 10 + c - '0';
	    } while ((c = read()) >= '0');
	    if (neg) return -ret;
	    return ret;
	}

	public double nextDouble() throws IOException {
	    double ret = 0, div = 1;
	    byte c;
	    do {
		c = read();
	    } while (c <= ' ');
	    boolean neg = (c == '-');
	    if (neg) c = read();
	    do {
		ret = ret * 10 + c - '0';
	    } while ((c = read()) >= '0');
	    if (c == '.') while ((c = read()) >= '0') ret += (c - '0') / (div *= 10);
	    if (neg) return -ret;
	    return ret;
	}

	public char nextChar() throws IOException {
	    byte c;
	    do {
		c = read();
	    } while (c <= ' ');
	    return (char) c;
	}

	public String next() throws IOException {
	    byte[] buf = new byte[LENGTH];
	    int cnt = 0;
	    byte c;
	    do {
		c = read();
	    } while (c <= ' ');
	    do {
		buf[cnt++] = c;
	    } while ((c = read()) > ' ');
	    return new String(buf, 0, cnt);
	}

	public String nextLine() throws IOException {
	    byte[] buf = new byte[LENGTH];
	    int cnt = 0;
	    byte c;
	    do {
		c = read();
	    } while (c <= ' ');
	    do {
		buf[cnt++] = c;
	    } while ((c = read()) >= ' ');
	    return new String(buf, 0, cnt);
	}
	
	public void setLength(int length) {
	    LENGTH = length;
	}

	private void fillBuffer() throws IOException {
	    bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
	    if (bytesRead == -1) buffer[0] = -1;
	}

	private byte read() throws IOException {
	    if (bufferPointer == bytesRead) fillBuffer();
	    return buffer[bufferPointer++];
	}

	public void close() throws IOException {
	    if (din == null) return;
	    din.close();
	}
    }
}
