import java.io.*;
import java.util.*;

public class Boj1019Page {
	private static int N;
	private static int[] dp;

	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		dp = new int[10];

		cntHere(N);
		StringBuilder sb = new StringBuilder();
		for(int i : dp) sb.append(i).append(" ");
		System.out.println(sb);
	}
	
	private static void cntHere(int n) {
		String str = "" + n;
		int len = str.length();

		for (int c = 0; c < len; ++c) {
			int now = str.charAt(c) - '0';

			String pre = str.substring(0, c);
			String post = str.substring(c + 1, len);

			int preInt = pre.equals("") ? 0 : Integer.parseInt(pre);
			int postInt = post.equals("") ? 0 : Integer.parseInt(post);
			int pow = (int) Math.pow(10, post.length());

			// 0 처리
			if (preInt != 0) {
				if (now == 0) {
					dp[0] += (preInt - 1) * pow + postInt + 1;
				} else {
					dp[0] += preInt * pow;
				}
			}

			// 1 ~ 9 처리
			for (int i = 1; i <= 9; ++i) {
				if (now > i) {
					dp[i] += (preInt + 1) * pow;
				} else if (now == i) {
					dp[i] += preInt * pow + postInt + 1;
				} else {
					dp[i] += preInt * pow;
				}
			}
		}
	}
}
