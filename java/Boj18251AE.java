import java.util.*;
import java.io.*;

public class Boj18251AE {
	static int idx = 0;
	private static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		int H = (int)Math.ceil(Math.log(N+1)/Math.log(2));

		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; ++i) {
			int now = Integer.parseInt(st.nextToken());
			arr[i] = now;
		}
		
		
		long max = Integer.MIN_VALUE;
		for(int sh=0; sh<H; ++sh) {
			
			for(int eh=sh+1; eh<=H; ++ eh) {
				idx = 1;
				long[] dp = new long[N+1];
				inorder(dp, 0, 1, sh, eh);
				for(int i=1; i<idx; ++i) max = Math.max(max, dp[i]);
//				System.out.println(Arrays.toString(dp));
//				System.out.println(idx);
			}
		}

		System.out.println(max);
		
		
	}
	
	
	private static void inorder(long[] dp, int depth, int node, int sh, int eh) {
		if(depth == eh) return;
		
		inorder(dp, depth+1, 2*node, sh, eh);
		
		if(depth >= sh) {
			dp[idx] = Math.max(dp[idx-1]+arr[node], arr[node]);
			idx++;
		}
		
		inorder(dp, depth+1, 2*node+1, sh, eh);
	}
	

}
