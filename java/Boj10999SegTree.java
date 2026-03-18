
import java.io.*;
import java.util.*;

public class Boj10999SegTree {

	
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
		long[] arr = new long[N];
		long[] segTree = new long[4*N];
		long[] lazy = new long[4*N];
//		int a = (int) Math.ceil(Math.log10(K) .log(N)/Math.log(2));
		
		for(int i=0; i<N; ++i) {
			arr[i] =  Long.parseLong(br.readLine());
		}
		
		init(arr, segTree, 0, N-1, 1);
//		System.out.println(Arrays.toString(segTree));
		
		for(int i=0; i<M+K; ++i) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(cmd == CMD_UPDATE) {
				long d = Long.parseLong(st.nextToken());
				update(segTree, lazy, 0, N-1, 1, b-1,c-1, d);
			}
			else if(cmd == CMD_QUERY) System.out.println(fastQuery(segTree, lazy, 0, N-1, 1, b-1,c-1));
//			System.out.println(Arrays.toString(segTree));
//			System.out.println(Arrays.toString(lazy));
		}
		
		
		
	}
	
	private static long init(long[] arr, long[] segTree, int start, int end, int now) {
		if(start == end) return segTree[now] = arr[start];
		int mid = (start+end)/2;
		return segTree[now] = init(arr, segTree, start, mid, 2*now) + init(arr, segTree, mid+1, end, 2*now+1);
	}
	
    static void lazyUpdate(long[] segTree, long[] lazy, int start, int end, int now) {
        if (lazy[now] != 0) {
            segTree[now] += (end - start + 1) * lazy[now];

            if (start != end) {
                lazy[now * 2] += lazy[now];
                lazy[now * 2 + 1] += lazy[now];
            }

            lazy[now] = 0;
        }
    }
	
	private static void update(long[] segTree, long[] lazy, int start, int end, int now, int left, int right, long delta) {
		lazyUpdate(segTree, lazy, start, end, now);
		
		
		if(right < start || end < left) return;
		if(left <= start && end <= right) {
			segTree[now] += (long)(end-start +1) * delta;
			
			if(start != end) {
				lazy[now*2] += delta;
				lazy[now*2+1] += delta;
			}
//			
//			lazy[now] += delta;
			return;
		}
		int mid = (start+end)/2;
		update(segTree, lazy, start, mid, now*2, left, right, delta);
		update(segTree, lazy, mid+1, end, now*2+1, left, right, delta);
		segTree[now] = segTree[now*2] + segTree[now*2+1];
		
		
	}
	
//	private static long query(long[] segTree, long[] lazyTree, int start, int end, int now, int left, int right) {
//		return fastQuery(segTree, start, end, now, left, right) + lazyQuery(lazyTree, start, end, now, left, right).val;
//	}
	
	private static long fastQuery(long[] segTree, long[] lazy, int start, int end, int now, int left, int right) {
		lazyUpdate(segTree, lazy, start, end, now);
		if(right < start || end < left) return 0;
		if(left <= start && end <= right) return segTree[now];
		int mid = (start+end)/2;
		return fastQuery(segTree, lazy, start, mid, 2*now, left, right) + fastQuery(segTree, lazy, mid+1, end, 2*now+1, left, right);
		
	}
//	
//	private static Node lazyQuery(long[] segTree, int start, int end, int now, int left, int right) {
//		if(right < start || end < left) return new Node(0,0);
//		if(left <= start && end <= right) {
//			int cnt = end-start+1;
//			return new Node(segTree[now]*cnt, cnt);
//		}
//		int mid = (start+end)/2;
//		Node lNode = lazyQuery(segTree, start, mid, 2*now, left, right);
//		Node rNode = lazyQuery(segTree, mid+1, end, 2*now+1, left, right);
//		int cnt = lNode.cnt+rNode.cnt;
//		return new Node(lNode.val + rNode.val + segTree[now]*cnt , cnt);
//		
//	}
	

}




