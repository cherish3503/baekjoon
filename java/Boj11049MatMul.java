import java.util.*;
import java.io.*;

public class Boj11049MatMul {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); 
		int[] arr = new int[N+1]; // size = N+1
		int[][] dp = new int[N+1][N+1];
		
		for(int i=0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			if(i==0) {
				arr[0] = Integer.parseInt(st.nextToken());
			} else	st.nextToken();
			arr[i+1] = (Integer.parseInt(st.nextToken()));
		}
		System.out.println(minMul(arr, dp, 0, N));
		System.out.println();
	}
	
	
	private static int minMul(int[] arr, int[][] dp, int s, int e) {
		int size = e-s+1;
		if(size<=2) {
			return 0;
		}
		if(dp[s][e] != 0) {
			return dp[s][e];
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=s+1; i<e; ++i) {
			int res = minMul(arr, dp, s, i) + minMul(arr, dp, i, e) + arr[s]*arr[i]*arr[e];
			min = Math.min(min, res);
		}
		
		dp[s][e] = min;
		return min;
	}
	
}
