import java.io.*;
import java.util.*;

public class Boj13334train {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] hoArr = new int[N][2];
		
		// d보다 큰것은 필요없음
		// 도착점 순으로 정렬 -> 시작점이 들어오면 PQ(시작순서 작은 순)에 넣기 다음 도착하면 pq에서 빼기
		for(int i=0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int o = Integer.parseInt(st.nextToken());
			

			int[] ho = new int[2];
			
			// 집과 사무실 순서는 상관없으니 작은 것을 앞으로 정렬하자
			if(h<=o) {
				ho[0] = h; ho[1] = o; 
			}
			else {
				ho[0] = o; ho[1] = h; 
			}
			hoArr[i] = ho;
		}
		
		int D = Integer.parseInt(br.readLine());
		
		Arrays.sort(hoArr, (e1,e2) -> Integer.compare(e1[1], e2[1]));
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1,e2) -> Integer.compare(e1[0], e2[0]));
		
		int maxSize = 0;
		
		for(int i=0; i<N; ++i) {
			while(!pq.isEmpty()) {
				if(pq.peek()[0] < hoArr[i][1]-D) pq.poll();
				else break;
			}
			if(hoArr[i][0] >= hoArr[i][1]-D) pq.offer(hoArr[i]);
			maxSize = Math.max(maxSize, pq.size());
			
		}
		System.out.println(maxSize);
		
	}
	
}
