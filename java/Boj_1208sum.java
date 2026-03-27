import java.io.*;
import java.util.*;


/*
 	두 집단으로 나누고
 	각 2^20 sum sum하고
 	한 집단에서 반대 집합 이분 탐색
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 */
public class Boj_1208sum {
//	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int half = N/2;
		int S = Integer.parseInt(st.nextToken());
		int[] arr1 = new int[half];
		int[] arr2 = new int[N-half];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<half; ++i) arr1[i] = Integer.parseInt(st.nextToken());
		for(int i=0; i<N-half; ++i) arr2[i] = Integer.parseInt(st.nextToken());
		
		List<Integer> leftLs = new ArrayList<>();
		List<Integer> rightLs = new ArrayList<>();
		
		sumArr(leftLs, arr1, 0, 0, false);
		sumArr(rightLs, arr2, 0, 0, false);
		
//		Map<Integer, Integer> rightCntMap
		rightLs.sort(Integer::compare);
		
		int result = 0;
		for(int left : leftLs) {
			if(left == S) result++;
			int lowerIdx = lower(rightLs, S-left);
			int upperIdx = upper(rightLs, S-left);
			result += upperIdx - lowerIdx;
		}
		
		System.out.println(result);
	}
	
	private static void sumArr(List<Integer> ls, int[] arr, int depth, int sum, boolean once) {
		int N = arr.length;
		if(N==depth) {
			if(once) ls.add(sum);
			return;
		}
		sumArr(ls, arr, depth+1, sum, once);
		sumArr(ls, arr, depth+1, sum+arr[depth], true);
		
	}
	
	
	
	
	
	private static int lower(List<Integer> ls, int target) {
		int left = 0;
		int right = ls.size();
		
		while(left<right) {
			int mid = (left+right)/2;
			if(ls.get(mid) >= target) {
				right = mid;
			}
			else {
				left = mid+1;
			}
			
		}
		return left;
	}
	
	private static int upper(List<Integer> ls, int target) {
		int left = 0;
		int right = ls.size();
		
		while(left<right) {
			int mid = (left+right)/2;
			if(ls.get(mid) > target) {
				right = mid;
			}
			else {
				left = mid+1;
			}
			
		}
		return left;
	}

}





