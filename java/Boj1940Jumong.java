import java.util.*;
import java.io.*;

public class Boj1940Jumong {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		System.out.println(twoPointer(arr, M));

	}
	
	
	private static int twoPointer(int[] arr, int target) {
		int s=0; int e=arr.length-1;
		int cnt = 0;
		
		while(s<e) {
			int sum = arr[s]+arr[e];
			if(sum==target) { // 두 재료 사용
				s++;
				e--;
				cnt++;
			}
			else if(sum<target) {
				s++;
			}
			else {
				e--;
			}
		}
		return cnt;
	}
}
