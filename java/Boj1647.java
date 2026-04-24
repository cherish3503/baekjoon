import java.util.*;
import java.io.*;


public class Boj1647 {
	private static class Edge{
		int e;
		int dist;
		public Edge(int e, int dist) {
			super();
			this.e = e;
			this.dist = dist;
		}
		@Override
		public String toString() {
			return "Edge [e=" + e + ", dist=" + dist + "]";
		}
		
	}
	
	private static int N;
	private static int M;
	private static List<Edge>[] graph;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		for(int i=1; i<=N; ++i) graph[i] = new ArrayList<>();
		
		
		for(int i=0; i<M; ++i) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			graph[A].add( new Edge(B, C));
			graph[B].add( new Edge(A, C));
		}
		prim();
		System.out.println();
		
	}
	
	public static int[] prim() {
		int[] minDist = new int[N+1];
		Arrays.fill(minDist, Integer.MAX_VALUE);
		PriorityQueue<Edge> pq = new PriorityQueue<>((e1,e2)->Integer.compare(e1.dist,e2.dist));
		pq.offer(new Edge(1,0));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if(cur.dist > minDist[cur.e]) continue;
			
			for(Edge ne : graph[cur.e]) {
				if(ne.dist > minDist[ne.e]) continue;
				pq.offer(ne);
			}
		}
		
		return minDist;
	}
}
