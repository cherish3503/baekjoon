
import java.io.*;
import java.util.*;

public class Boj14003asc {
	static class IdxNode{
		int idx;
		int preIdx;
		public IdxNode(int idx, int preIdx) {
			super();
			this.idx = idx;
			this.preIdx = preIdx;
		}
		
	}
	
	public static final int maxMoveCnt = 5;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] minValArr = new int[N];
		IdxNode[] minValIdx = new IdxNode[N];
		for(int i=0; i<N; ++i) minValArr[i] = Integer.MAX_VALUE;
		int[] preArr = new int[N];
		int[] arr = new int[N];
		
		int maxLen = 0;
		st = new StringTokenizer(br.readLine());
//		minValArr[0] = Integer.parseInt(st.nextToken());
	
		
		for(int i=0; i<N; ++i) {
			int target = Integer.parseInt(st.nextToken());
			arr[i] = target;
			int idx = binarySearch(minValArr, 0, maxLen, target);
				
			if(idx == maxLen) {
				maxLen++;
				if(idx == 0) minValIdx[idx] = new IdxNode(i, -1);
				else minValIdx[idx] = new IdxNode(i, minValIdx[idx-1].idx);
			}
			if(target < minValArr[idx]) {
//				int preIdx = minValIdx[idx].preIdx;
				minValArr[idx] = target;
				if(idx == 0) minValIdx[idx] = new IdxNode(i, -1);
				else minValIdx[idx] = new IdxNode(i, minValIdx[idx-1].idx);
			}
			
			preArr[i] = minValIdx[idx].preIdx;
		}
		
		System.out.println(maxLen);
//		System.out.println(minValIdx);
//		System.out.println(preArr);
		
		Deque<Integer> result = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		int now = minValIdx[maxLen-1].idx;
		while(now != -1) {
//			int idx =  preArr[now];
			result.offerFirst(arr[now]);
			
			now = preArr[now];
		}
		while(!result.isEmpty()) {
			sb.append(result.poll()).append(" ");
		}
		
		System.out.println(sb);
		

	}
	
	private static int binarySearch(int[] arr, int start, int end, int target) {
		// end 미포함 구간
//		int ans = -1;
		
		while(start < end) {
			int mid = (start+end) /2;
			
			if(arr[mid] < target) start = mid+1;
			else end = mid;
		}
		
		return start;
	}

}
