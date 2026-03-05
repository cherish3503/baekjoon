import java.io.*;
import java.util.*;

public class Boj10942Palindrome {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i) arr[i] = Integer.parseInt(st.nextToken());
		int[] dpOdd = makeRangeOdd(arr);
		int[] dpEven = makeRangeEven(arr);
		
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; ++i) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			sb.append(palindrome(dpOdd, dpEven, s-1 ,e-1)).append("\n");
//			System.out.println();
//			System.out.println(palindrome(dpOdd, dpEven, s-1 ,e-1));
		}
		System.out.println(sb.toString().trim());
		
	}
	private static int palindrome(int[] dpOdd, int[] dpEven, int s, int e) {
//		if(e==s) return 1;
		
		int mid = (e+s)/2;
		int len = e-s+1;
		
		if(len%2 != 0) { // 홀수 길이
			return dpOdd[mid]>=len ? 1 : 0 ;
		}
		else return dpEven[mid]>=len ? 1 : 0; // 짝수 길이
	}
	
	private static int[] makeRangeOdd(int[] arr) {
		int N = arr.length;
		int[] dp = new int[N];
		for(int i=0; i<N; ++i) {
			int s=i-1;
			int e=i+1;
			int cnt=1;
			while(s>=0 && e<N) {
				if(arr[s] != arr[e]) break;
				cnt+=2;
				s--;
				e++;
			}
			dp[i] = cnt;
		}
		return dp;
	}
	
	private static int[] makeRangeEven(int[] arr) { // dp[i] : dp[i]와 dp[i+1]을 기준으로 중복개수
		int N = arr.length;
		int[] dp = new int[N-1];
		for(int i=0; i<N-1; ++i) {
			int s=i;
			int e=i+1;
			int cnt=0;
			while(s>=0 && e<N) {
				if(arr[s] != arr[e]) break;
				cnt+=2;
				s--;
				e++;
			}
			dp[i] = cnt;
		}
		return dp;
	}
}
