import java.io.*;
import java.util.*;

public class Boj1005ACM {
	private static int N;
	private static List<Integer>[] graph;
	private static int[] conTime;
	private static int[] indegree;

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=T; ++test) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			conTime = new int[N+1];
			indegree = new int[N+1];
			graph = new ArrayList[N+1];
			for(int i=1; i<=N; ++i) graph[i] = new ArrayList<>();
			
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; ++i) {
				conTime[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<K; ++i) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				graph[start].add(end);
				indegree[end] += 1;
			}
			
			int target = Integer.parseInt(br.readLine());
			
			System.out.println(acm(target));
		}
		
	}
	
//	private static int acm(int now, int sum) {
//		if(graph[now].isEmpty()) return sum+conTime[now];
//		
//		int max = Integer.MIN_VALUE;
//		for(int next : graph[now]) {
//			max = Math.max(max, acm(next, sum+conTime[now]));
//		}
//		return max;
//	}
	
	private static int acm (int target) {
//		int[] minDist = new int[N+1];
		PriorityQueue<int[]> pq =  new PriorityQueue<>((v1,v2) -> Integer.compare(v1[1], v2[1]));
		
		for(int i=1; i<=N; ++i) {
			if(indegree[i] == 0) pq.offer(new int[] {i,conTime[i]});
		}
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int now = cur[0];
			int dist = cur[1];
			
			
			if(now == target) return dist;
			
			for(int next : graph[now]) {
				indegree[next] -= 1;
				if(indegree[next] == 0) {
					pq.offer(new int[] {next, dist+conTime[next]});
				}
			}
		}
		
		return -1;
		
	}


}
