import java.util.*;
import java.io.*;

public class Boj16565four {
	private static final int K = 13;
	private static final int MOD_INT = 10_007;
	private static int N;
	private static int[][] dp;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		dp = new int[4*K+1][4*K+1];
		for(int i=0; i<=K*4; ++i) {
			Arrays.fill(dp[i], -1);
		}

		System.out.println((comb(52,N) - notFourCard(0,0,1) +MOD_INT)%MOD_INT);
	}
	
	private static int notFourCard(int depth, int cnt, int sum) {
		if(cnt > N || cnt + (K-depth)*3 < N) return 0;
		if(depth == K && cnt == N) {
			return sum;
		}
		int result = 0;
		for(int c=0; c<=3; ++c) {
			result += notFourCard(depth+1, cnt+c, (sum*(comb(4,c)%MOD_INT))%MOD_INT)%MOD_INT;
		}
		return result%MOD_INT;
		
	}
	
	private static int comb(int n, int k) {
		if(k == 0) return 1;
		if(n == k) return 1;
		if(dp[n][k] != -1) return dp[n][k];
		return dp[n][k] = (comb(n-1,k-1)%MOD_INT + comb(n-1,k)%MOD_INT)%MOD_INT;
	}
}
