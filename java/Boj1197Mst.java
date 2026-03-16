import java.io.*;
import java.util.*;

public class Boj1197Mst {
	private  static class Edge implements Comparable<Edge>{
		int end;
		int dist;
		
		public Edge(int end, int dist) {
			super();
			this.end = end;
			this.dist = dist;
		}
		
		public int compareTo(Edge edge) {
			return Integer.compare(this.dist, edge.dist);
		}
		
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		List<Edge>[] graph = new ArrayList[V+1];
		for(int i=1; i<=V; ++i) graph[i] = new ArrayList<>();
		
		
		for(int i=0; i<E; ++i) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			graph[s].add(new Edge(e, dist));
			graph[e].add(new Edge(s, dist));
		}
		System.out.println(prim(graph));

		
		
	}
	
	private static int prim(List<Edge>[] graph) {
		int V = graph.length-1;
		int result = 0;
		boolean[] visited = new boolean[V+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1, 0));
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			if(visited[now.end]) continue;
			visited[now.end] = true;
			result += now.dist;
			
			for(Edge e: graph[now.end]) {
				pq.offer(e);
				
			}
		}
		
		return result;
	}
}
