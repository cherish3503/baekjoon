import java.io.*;
import java.util.*;

public class Boj2166polygon {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] polygon = new int[N][2];
		for(int i=0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			polygon[i] = new int[] {x,y};
		}
		
		long result =0;
		//삼각형과 나머지로 나누기
		for(int i=0; i<N-2; ++i) {
			result += areaTri(polygon[0],polygon[i+1],polygon[i+2]);
		}
		System.out.println(result);
		System.out.printf("%.1f\n", result/2.0);
	}
	
	private static long areaTri(int[] a, int[] b, int[] c) {
		long cross = (long)a[0]*(b[1]-c[1])+(long)b[0]*(c[1]-a[1])+(long)c[0]*(a[1]-b[1]); // ab X ac

		return Math.abs(cross);
	}
}
