import java.util.*;
import java.io.*;

public class Boj14428_query {
	
	private static int N;
	private static int[] arr;
	private static int[] segTree;
	private static final int CMD_CHANGE = 1;
	private static final int CMD_QUERY = 2;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		arr[0] = Integer.MAX_VALUE;
		segTree = new int[4*N];

		st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; ++i) arr[i] = Integer.parseInt(st.nextToken());
		
		build(1, 1, N);
		
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; ++i) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(cmd == CMD_CHANGE) {
				arr[a] = b;
				update(1, 1, N, a);
			}
			else if(cmd == CMD_QUERY) {
				System.out.println(query(1, 1, N, a, b));
			}
			
		}
		
		

		
		
	}
	
	private static void build(int node, int start, int end) {
		if(start == end) {
			segTree[node] = start; 
			return;
		}
		
		int mid = (start+end)/2;
		build(node*2, start, mid);
		build(node*2+1, mid+1, end);
		
		if(arr[segTree[node*2]] <= arr[segTree[node*2+1]]) {
			segTree[node] = segTree[node*2];
		}
		else segTree[node] = segTree[node*2+1];

		
		
	}
	
	private static void update(int node, int start, int end, int idx) {
		if(idx<start || end<idx) return;
		if(start == end) {
//			segTree[node] = start;
			return;
		}
		
		
		int mid = (start+end)/2;
		update(node*2, start, mid, idx);
		update(node*2+1, mid+1, end, idx);
		
		if(arr[segTree[node*2]] <= arr[segTree[node*2+1]]) {
			segTree[node] = segTree[node*2];
		}
		else segTree[node] = segTree[node*2+1];
		
		
	}
	
	private static int query(int node, int start, int end, int left, int right) {
		if(end<left || right<start) return 0; // max값 인덱스
		
		if(start == end) return segTree[node]; 
		
		if(left<=start && end<=right) return segTree[node];
		
		int mid = (start+end)/2;
		int lIdx = query(node*2, start, mid, left, right);
		int rIdx = query(node*2+1, mid+1, end, left, right);
		if(arr[lIdx] <= arr[rIdx]) return lIdx;
		else return rIdx; 

	}
}
