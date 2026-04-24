import java.io.*;
import java.util.*;

public class Boj17404RGB {
	private static final int BIG_INT = 1_000_000_000;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		

		int[][][] minRGB = new int[N+1][3][3]; // [i][1번집][현재집]
		
		st = new StringTokenizer(br.readLine());
		for(int c=0; c<3; ++c) {
			minRGB[1][c][c] = Integer.parseInt(st.nextToken());
			minRGB[1][c][(c+2)%3] = BIG_INT;
			minRGB[1][c][(c+1)%3] = BIG_INT;
		}
		
		
		for(int i=2; i<=N-1; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<3; ++c) {
				int now = Integer.parseInt(st.nextToken());
				for(int c1=0; c1<3; ++c1) {
					minRGB[i][c1][c] = now;
					minRGB[i][c1][c] += Math.min(minRGB[i-1][c1][(c+2)%3], minRGB[i-1][c1][(c+1)%3]);
				}
			}
		}
		
		int min = BIG_INT;
		st = new StringTokenizer(br.readLine());
		for(int c=0; c<3; ++c) {
			int now = Integer.parseInt(st.nextToken());
			for(int c1=0; c1<3; ++c1) {
				if(c1 == c)	continue; //minRGB[N][c1][c] = Integer.MAX_VALUE;
				else {
					minRGB[N][c1][c] = now;
					minRGB[N][c1][c] += Math.min(minRGB[N-1][c1][(c+2)%3], minRGB[N-1][c1][(c+1)%3]);
					min = Math.min(min, minRGB[N][c1][c]);
				}
			}
		}
		
		System.out.println(min);
		
	}
}
