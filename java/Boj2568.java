import java.util.*;
import java.io.*;


public class Boj2568 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		Map<Integer, Integer> pre = new HashMap<>(); // key : b, value :b
//		for(int i=0; i<N; ++i) pre[i] = -1;
		
		for(int i=0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (n1, n2) -> Integer.compare(n1[0], n2[0]));
		
		List<int[]> minLs = new ArrayList<>();
		for(int i=0; i<N; ++i) {
			int[] node = arr[i];
//			int target = node[1];
			int idx = binarySearch(minLs, 0, minLs.size(), node[1]);
			if(idx >= minLs.size()) {
				if(idx == 0) pre.put(node[1], -1);
				else pre.put(node[1], minLs.get(idx-1)[1]);
				minLs.add(node);
			}
			else{
				if(idx == 0) pre.put(node[1], -1);
				else pre.put(node[1], minLs.get(idx-1)[1]);
//				pre.put(node[1], pre.get(minLs.get(idx)[1]));
				minLs.set(idx, node);
			}
			
		}
		Set<Integer> maxSet = new HashSet<>();
		int now = minLs.get(minLs.size()-1)[1];
		while(now != -1) {
			maxSet.add(now);
			now = pre.get(now);
		}
//		System.out.println(maxSet);
		
		
		
		int cnt = N - maxSet.size();
		System.out.println(cnt);
		for(int[] node : arr) {
			if(!maxSet.contains(node[1])) {
				System.out.println(node[0]);
			}
		}
		


	}
	
	private static int binarySearch(List<int[]> minLs, int s, int e, int target) {
		while(s<e) {
			int mid = (s+e)/2;
			if(minLs.get(mid)[1] <= target) {
				s = mid+1;
			}
			else e = mid;
		}
		
		return s;
	}
}
