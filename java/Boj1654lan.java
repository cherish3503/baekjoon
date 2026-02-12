import java.util.*;
import java.io.*;

public class Boj1654lan {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] lan = new int[K];
		int maxLen = 0;
		for(int i=0; i<K; ++i){
			lan[i] = Integer.parseInt(br.readLine());
			maxLen = Math.max(maxLen, lan[i]);
		}
		
		
		System.out.println(binarySearch(lan, 1, maxLen, N));

		
	}
	
	private static int binarySearch(int[] lan, long sLen, long eLen, int target) {
		if(sLen >= eLen) return (int)sLen;
		
		int K = lan.length;
		long midLen = (sLen+eLen+1)/2; // 구간 길이가 2일때 뒤 원소 선택 eLen이 int 초과할 수 있음
		long sum = 0;
		for(int i=0; i<K; ++i) {
			sum += lan[i]/midLen;
			if(sum >=target) break;
		}
		if(sum >= target) { // sum == target일경우 답일 수도 있고, 더 큰 len이 있을 수도 있음 - midLen 포함
			return binarySearch(lan, midLen, eLen, target); // 
		}
		else {
			return binarySearch(lan, sLen, midLen-1, target);
		}
	}
}
