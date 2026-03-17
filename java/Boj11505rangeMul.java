import java.io.*;
import java.util.*;

public class Boj11505rangeMul {
	static final int CMD_UPDATE = 1;
	static final int CMD_QUERY = 2;
	static final int MOD = 1_000_000_007;
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		long[] segTree = new long[4*N];
//		int a = (int) Math.ceil(Math.log10(K) .log(N)/Math.log(2));
		
		for(int i=0; i<N; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		init(arr, segTree, 0, N-1, 1);
//		System.out.println(Arrays.toString(segTree));
		
		for(int i=0; i<M+K; ++i) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(cmd == CMD_UPDATE) update(segTree, 0, N-1, 1, b-1,c);
			else if(cmd == CMD_QUERY) System.out.println(query(segTree, 0, N-1, 1, b-1,c-1));
		}
//		System.out.println(Arrays.toString(segTree));
		
		
	}
	
	private static long init(int[] arr, long[] segTree, int start, int end, int now) {
		if(start == end) return segTree[now] = (long)arr[start];
		int mid = (start+end)/2;
		return segTree[now] = (init(arr, segTree, start, mid, 2*now) * init(arr, segTree, mid+1, end, 2*now+1))%MOD;
	}
	
	private static void update(long[] segTree, int start, int end, int now, int idx, int value) {
		if(idx < start || end < idx) return;
		if(start == end) {
			segTree[now] = (long)value;
			return;
		}
		int mid = (start+end)/2;
		update(segTree, start, mid, now*2, idx, value);
		update(segTree, mid+1, end, now*2+1, idx, value);
		segTree[now] = (segTree[now*2] *segTree[now*2+1])%MOD;
		
		
	}
	
	
	private static long query(long[] segTree, int start, int end, int now, int left, int right) {
		if(right < start || end < left) return 1;
		if(left <= start && end <= right) return segTree[now];
		int mid = (start+end)/2;
		return (query(segTree, start, mid, 2*now, left, right) * query(segTree, mid+1, end, 2*now+1, left, right))%MOD;

		
	}

}
