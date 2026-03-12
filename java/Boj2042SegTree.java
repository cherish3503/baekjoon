import java.io.*;
import java.util.*;

public class Boj2042SegTree {
	private static long[] arr;
	private static long[] segTree;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new long[N];
		segTree = new long[4*N];
		
		for(int i=0; i<N; ++i) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		//todo:build
		build(0, N-1, 1);
		
		for(int i=0; i<M+K; ++i) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(cmd == 1) update(0, N-1, 1, b-1, c);
			if(cmd == 2) System.out.println(query(0, N-1, 1, b-1, (int)c-1));

		}
//		System.out.println();
	}
	
	private static long build(int start, int end, int node) {
		if(start == end) return segTree[node] = arr[start];
		
		int mid = (start+end)/2;
		return segTree[node] = build(start, mid, node*2) + build(mid+1, end, node*2+1);
	}
	
	private static long query(int start, int end, int node, int left, int right) {
		if(right < start || end < left) return 0;
		if(left <= start && end <= right) return segTree[node];
		
		int mid = (start+end)/2;
		return query(start, mid, node*2, left, right) + query(mid+1, end, node*2+1, left, right);
	}
	
	private static void update(int start, int end, int node, int idx, long value) {
		if(idx < start || end < idx) return;
		
		
		if(start == end) { 
			segTree[node] = value;
			return;
		}
		
		int mid = (start+end)/2;
		update(start, mid, node*2, idx, value);
		update(mid+1, end, node*2+1, idx, value);
		segTree[node] = segTree[node*2] + segTree[node*2+1];
		return;
	}
}

