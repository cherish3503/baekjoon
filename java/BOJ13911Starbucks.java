import java.util.*;
import java.io.*;

public class BOJ13911Starbucks {
	private static class Edge{
		int e;
		int dist;
		public Edge(int e, int dist) {
			super();
			this.e = e;
			this.dist = dist;
		}
	}
	
	private static int V;
	private static int E;
	private static int X;
	private static int Y;
	private static final int BUILDING_HOME = 0;
	private static final int BUILDING_MCD = 1;
	private static final int BUILDING_STARB = 2;
	
	private static int[] buildingType;
	
	private static Map<Integer,Integer>[] graph;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		graph = new HashMap[V+1];
		for(int i=1; i<=V; ++i) graph[i] = new HashMap<>();
		buildingType = new int[V+1];
		
		//edge
		for(int i=0; i<E; ++i) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			graph[v1].put(v2, Math.min(dist, graph[v1].getOrDefault(v2,Integer.MAX_VALUE)));
			graph[v2].put(v1, Math.min(dist, graph[v2].getOrDefault(v1,Integer.MAX_VALUE)));
		}
		
		
		
		//mcd
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Set<Integer> mcdSet = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; ++i) {
			int now = Integer.parseInt(st.nextToken());
			buildingType[now] = BUILDING_MCD;
			mcdSet.add(now);
		}
		
		//starb
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		Set<Integer> starbSet = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<S; ++i) {
			int now = Integer.parseInt(st.nextToken());
			buildingType[now] = BUILDING_STARB;
			starbSet.add(now);
		}
		
		int[] minDistMcd = dijkstra(mcdSet);
		int[] minDistStarb = dijkstra(starbSet);
//		int[] minDistSum = new int[V+1];
//		for(int v=1; v<=V; ++v) minDistSum[v] = Integer.MAX_VALUE;
		
		int min = Integer.MAX_VALUE;
		for(int v=1; v<=V; ++v) {
			if(buildingType[v] != BUILDING_HOME) continue;
			if(minDistMcd[v] > X || minDistStarb[v] > Y) continue;
			min = Math.min(min, minDistMcd[v] + minDistStarb[v]);
 		}
		
		System.out.println(min==Integer.MAX_VALUE ? -1 : min);
		
		
		
	}
	
	
	private static int[] dijkstra(Set<Integer> set) {
		int[] minDist = new int[V+1];
//		boolean[] visited = new boolean[] 
		for(int i=1; i<=V; ++i) minDist[i] = Integer.MAX_VALUE;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2)->Integer.compare(e1.dist, e2.dist));
		for(int v : set) {
			pq.offer(new Edge(v, 0));
			minDist[v] = 0;
		}
		
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if(cur.dist > minDist[cur.e]) continue;
			
			Map<Integer, Integer> nMap = graph[cur.e];
			for(int nv : nMap.keySet()) {
				int nDist = cur.dist + nMap.get(nv);
				if(nDist > minDist[nv]) continue;
				minDist[nv] = nDist;
				pq.offer(new Edge(nv, nDist));
			}
			 
			
		}
		
		return minDist;
		
	}
}
