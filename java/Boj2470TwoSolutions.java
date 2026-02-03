import java.util.*;
import java.io.*;


public class Boj2470TwoSolutions {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int[] res = twoPointer(arr);
		System.out.println(res[0] + " " + res[1]);
		
//		Arrays.stream(twoPointer(arr)).map(String::Valueof).
		
		
		
	}
	
	
	private static int[] twoPointer(int[] arr) {
		int s=0; int e=arr.length-1;
		int min = Integer.MAX_VALUE;
		int[] res = new int[2];
		
		while(s<e) {
			int sum = arr[s]+arr[e];
			int absSum = Math.abs(sum);
			if(sum==0) { // 중복 값 x
				res[0] = arr[s];
				res[1] = arr[e];
				break;
			}
			else if(sum<0) {
				
				if(absSum < min) {
					min = absSum;
					res[0] = arr[s];
					res[1] = arr[e];
				}
				s++;
			}
			else {
				if(absSum < min) {
					min = absSum;
					res[0] = arr[s];
					res[1] = arr[e];
				}
				e--;
			}

		}

		
		return res;
	}
}
