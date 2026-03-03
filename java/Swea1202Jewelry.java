import java.io.*;
import java.util.*;


public class Swea1202Jewelry {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] jewelrys = new int[N][2];
		int[] bags = new int[K];
		
		for(int i=0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			jewelrys[i][0] = Integer.parseInt(st.nextToken());
			jewelrys[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<K; ++i) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bags);
		
		for(int i=0; i<K; ++i) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(jewelrys, (e1,e2) ->{
			if(e1[0] == e2[0]) return Integer.compare(e1[1],e2[1]);
			return Integer.compare(e1[0],e2[0]);
		});
	}
}
/*
 * 
2) 작은 가방 순으로 정렬
그 가방에 들어 갈 수 있는 가장 큰 가치
 */
