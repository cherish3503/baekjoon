
import java.io.*;
import java.util.*;

public class Boj2357Min {
	private static int[] arr;
	private static int[] queryArr;
//	private static int[] segTreeMin;
//	private static int[] segTreeMax;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N];
//		queryArr = 
		int[] segTreeMin = new int[4*N];
		int[] segTreeMax = new int[4*N];
		for(int i=1; i<4*N; ++i) segTreeMin[i] = Integer.MAX_VALUE;
		for(int i=1; i<4*N; ++i) segTreeMax[i] = Integer.MIN_VALUE;
		
		for(int i=0; i<N; ++i) arr[i] = Integer.parseInt(br.readLine());
		build(segTreeMin, 1,0,N-1, true);
		build(segTreeMax, 1,0,N-1, false);
		
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(query(segTreeMin, 1, 0, N-1, a-1, b-1, true)).append(" ");
			sb.append(query(segTreeMax, 1, 0, N-1, a-1, b-1, false)).append("\n");
		}
		
		System.out.println(sb);

		
//		System.out.println(segTreeMin);
	}
	
	
	private static void build(int[] segTree, int node, int start, int end, boolean isMin) {
		if(start==end) {
			segTree[node] = arr[start];
			return;
		}
		int mid = (start+end)/2;
		build(segTree, node*2, start, mid, isMin);
		build(segTree, node*2+1, mid+1, end, isMin);
		segTree[node] = isMin ? Math.min(segTree[node*2] , segTree[node*2+1]) : Math.max(segTree[node*2] , segTree[node*2+1]) ;
	}
	
	private static int query(int[] segTree, int node, int start, int end, int left, int right, boolean isMin) {
		if(end < left || right < start) return isMin ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		if(left <= start && end<=right) return segTree[node];
		
		int mid = (start+end)/2;
		int lq = query(segTree, node*2, start, mid, left, right, isMin);
		int rq = query(segTree, node*2+1, mid+1, end, left, right, isMin);
		return isMin ? Math.min(lq, rq) : Math.max(lq, rq);
		
	}
	
	
}