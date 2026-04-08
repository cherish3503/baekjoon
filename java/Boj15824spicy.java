import java.util.*;
import java.io.*;


public class Boj15824spicy {
	private static final long K = 1_000_000_007;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		long min = 0; 
		long max = 0;
		long[] pow2 = new long[N];
		pow2[0] = 1;
		for(int i=1; i<N; ++i) pow2[i] = (pow2[i-1]*2)%K;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		for(int i=0; i<N; ++i) {
			min = (min + ((long)arr[i] * pow2[N-1-i])%K)%K;
			max = (max + ((long)arr[N-1-i] * pow2[N-1-i])%K)%K;
		}
		long result = max-min;
		System.out.println(((result%K)+K)%K);
		
	}
}
