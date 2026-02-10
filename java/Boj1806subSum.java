import java.util.*;
import java.io.*;


public class Boj1806subSum {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		//int 가능 100_000 * 10_000
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(twoPointer(arr, S));
	}
	
	private static int twoPointer(int[] arr, int S) {
		int len = arr.length;
		int s=0; 
		int e=0;
		int minLen = Integer.MAX_VALUE;
		int sum =arr[s];
		
		while(s<len && e<len) {
//			System.out.println(s + " " + e + " " + sum);
			if(sum>=S) {
				minLen = Math.min(minLen, e-s+1);
				sum -= arr[s++];
			}
			else {
				if(e==len-1) {
					break;
				}
				sum += arr[++e];
			}
		}
		
		return minLen != Integer.MAX_VALUE ? minLen : 0;
	}
}
