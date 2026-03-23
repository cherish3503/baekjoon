import java.io.*;
import java.util.*;

public class Boj7453Sumzero {
//	private static Map<Integer, Integer> cntMapLeft;
//	private static Map<Integer, Integer> cntMapRight;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//
//		cntMapLeft = new TreeMap<>();
//		cntMapRight = new TreeMap<>();
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[4][N];
		int[] leftArray = new int[N*N];
		int[] rightArray = new int[N*N];
		for(int i=0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; ++j) {
				arr[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				int sumLeft = arr[0][i] + arr[1][j];
				int sumRight = arr[2][i] + arr[3][j];
				leftArray[i*N+j] = sumLeft;
				rightArray[i*N+j] = sumRight;
//				cntMapLeft.put(sumLeft, cntMapLeft.getOrDefault(sumLeft, 0)+1);
//				cntMapRight.put(sumRight, cntMapRight.getOrDefault(sumRight, 0)+1);
				
			}

		}

		System.out.println(twoPointer(leftArray, rightArray));

	}
	
	
	private static long twoPointer(int[] leftArray, int[] rightArray) {
		int s=0;
		int e=rightArray.length-1;
		Arrays.sort(leftArray);
		Arrays.sort(rightArray);
		
		
		long result = 0;
		while(s<leftArray.length && e>=0) {
			int sum = leftArray[s] + rightArray[e];
			if(sum == 0) {
				int lcnt = 1;
				int rcnt = 1;
				while(s+1<leftArray.length && leftArray[s] == leftArray[s+1]) {
					lcnt++;
					s++;
				}
				while(e-1>=0 && rightArray[e] == rightArray[e-1]) {
					rcnt++;
					e--;
				}
				result += (long)lcnt*rcnt;
				s++;
				e--;
				
//				result += cntMapLeft.get(leftArray[s])*cntMapRight.get(rightArray[e]);
				
			}
			else if(sum >0) e--;
			else s++;
		}
		return result;
	}
	
	
}


