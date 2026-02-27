package swea;


import java.io.*;
import java.util.*;

public class Boj2143SubSum {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[] prefix1 = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; ++i) {
			prefix1[i] = prefix1[i-1] + Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		int[] prefix2 = new int[m+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=m; ++i) {
			prefix2[i] = prefix2[i-1] + Integer.parseInt(st.nextToken());
		}
		
		Map<Integer, Integer> cntMap1 = new HashMap<>();
		Map<Integer, Integer> cntMap2 = new HashMap<>();
		List<Integer> subSum1 = getSubSum(prefix1, cntMap1);
		List<Integer> subSum2 = getSubSum(prefix2, cntMap2);
		
		System.out.println(twoPointer(subSum1, cntMap1, subSum2, cntMap2, T));
	}
	
	private static List<Integer> getSubSum(int[] prefix, Map<Integer, Integer> cntMap){
		int n = prefix.length;
		List<Integer> subSum = new ArrayList<>();
		for(int i=0; i<n; ++i) {
			for(int j=i+1; j<n; ++j) {
				int now = prefix[j]-prefix[i];
				if(!cntMap.containsKey(now)) subSum.add(now);
//				System.out.println((i + " " + j + " " + now);
				cntMap.put(now, cntMap.getOrDefault(now, 0)+1);
			}
		}
		subSum.sort((a,b) -> a.compareTo(b));
		return subSum;
	}
	
	private static long twoPointer(List<Integer> ls1,  Map<Integer, Integer> cntMap1, List<Integer> ls2,  Map<Integer, Integer> cntMap2, int target) {
		int len1 = ls1.size(); 
		int len2 = ls2.size(); 
		int p1 = 0;
		int p2 = len2-1;
		long cnt = 0;
		
		while(p1<len1 && p2>=0) {
			int n1 = ls1.get(p1);
			int n2 = ls2.get(p2);
			int sum = n1 + n2;
			if(sum == target) {	// 같은 숫자 어떻게 처리??
				cnt += (long)cntMap1.get(n1)*(long)cntMap2.get(n2);
				p1++;
			}
			else if(sum > target) p2--;
			else p1++;
		}
		return cnt;
	}

}



/*
 * 일단 누적합
 * 음수인 입력이 있음
 * 모든 서브배열의 합을 구함 - n^2
 * 정렬
 * 투포인터
 * 
 * 같은 숫자 어떻게 처리?
 * 			3	4	4	4
			3	3	3	3	3	4
 * 
 * 
 */
