import java.io.*;
import java.util.*;

public class Boj2342Dance {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int[] pos = {0,0}; // culdr : 01234
		
		int[][] add = 	{	{0,2,2,2,2},
							{0,1,3,4,3},
							{0,3,1,3,4},
							{0,4,3,1,3},
							{0,3,4,3,1}	};
		
		List<Integer> order = new ArrayList<>();
		while(true) {
			int next = Integer.parseInt(st.nextToken());
			if(next == 0) break;
			order.add(next);
		}

		System.out.println(move(order));
	}
	
	
	// 현재 배치 -> 다음 배치, 각 턴 마다 현재 자세에서의 점수 최솟값을 저장
	// dp[low][high]
	
	
	private static int move(List<Integer> order) {
		int[][] add = 	{	{0,2,2,2,2},
							{0,1,3,4,3},
							{0,3,1,3,4},
							{0,4,3,1,3},
							{0,3,4,3,1}	};
		

		int[][] minArr = new int[5][5];
		for(int i=0; i<5; ++i) Arrays.fill(minArr[i], Integer.MAX_VALUE);
		int[][] nextMinArr;
		minArr[0][0] = 0;
		
		for(int next : order) {
			nextMinArr = new int[5][5];
			for(int i=0; i<5; ++i) Arrays.fill(nextMinArr[i], Integer.MAX_VALUE);
			
			for(int left=0; left<5; ++left) {
				for(int right=left; right<5; ++right) {
					if(left == right && left != 0) continue; // 발이 같은 곳에 있었을 수 없다.
					int score = minArr[left][right];
					if(score == Integer.MAX_VALUE) continue;
					
//					int low, high;
					if(next != right) { // 같은 발이 되어서는 안된다.
						int low = Math.min(next, right);
						int high = Math.max(next, right);
						nextMinArr[low][high] = Math.min(nextMinArr[low][high], score+add[left][next]);
					}
					
					if(next != left) {
						int low = Math.min(next, left);
						int high = Math.max(next, left);
						nextMinArr[low][high] = Math.min(nextMinArr[low][high],score+add[right][next]);
					}
					
				}
			}
			
			minArr = nextMinArr;
		}
		
		int min = Integer.MAX_VALUE;
		for(int left=0; left<5; ++left) {
			for(int right=left; right<5; ++right) {
				min = Math.min(min, minArr[left][right]);
			}
		}
			
		return min;

	}
}
