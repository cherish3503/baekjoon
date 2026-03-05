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
			int M = Integer.parseInt(st.nextToken());
			jewelrys[i][0] = M;
			jewelrys[i][1] = Integer.parseInt(st.nextToken());

		}
		
		for(int i=0; i<K; ++i) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bags);
		
		Arrays.sort(jewelrys, (e1,e2) ->Integer.compare(e1[0],e2[0]));
		//무게 내림차순 정렬
		

		PriorityQueue<int[]> pq = new PriorityQueue<>((e1,e2)-> Integer.compare(e2[1],e1[1]));
		long result = 0;
		int idx = 0;
		for(int b : bags) {
			while(idx<N) {
				if(jewelrys[idx][0] > b) break;
				pq.offer(jewelrys[idx]);
				idx++;
			}
			if(!pq.isEmpty()) result += pq.poll()[1];
		}
		
		System.out.println(result);
	}
}

/*
	2) 작은 가방 순으로 정렬
	그 가방에 들어 갈 수 있는 가장 큰 가치
	
	가방 내림차순으로 처리하면서 pq(value내림차순)에 가방보다 작은 보석 넣기 
 */
