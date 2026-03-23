import java.io.*;
import java.util.*;

public class Boj1106hotel {
	public static int MAX = 1_000_000_000;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] minCost = new int[N+1][C+1];
		Arrays.fill(minCost[0], MAX);
		
		for(int i=1; i<=N; ++i) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
		
			for(int c=1; c<=C; ++c) {
//				int value = (int)Math.ceil((double)c/p)*cost;
				int pre = 0;
				int pre2 =0;
				if(c>=p) {
					pre = minCost[i-1][c-p];
					pre2 = minCost[i][c-p];
				}
				
				minCost[i][c] = Math.min(pre2+cost, Math.min(minCost[i-1][c], pre + cost));
//				System.out.println(j/p + " "+ p +" "+ Math.ceil((double)j/p));
			}
		}
				System.out.println(minCost[N][C]);

		
		
	}

}
