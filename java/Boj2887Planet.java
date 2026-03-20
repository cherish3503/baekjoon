import java.util.*;
import java.io.*;


public class Boj2887Planet{
	static class Pos{
		int id;
		int x;
		int y;
		int z;
		public Pos(int id, int x, int y, int z) {
			super();
			this.id = id;
			this.x = x;
			this.y = y;
			this.z = z;
		}
		@Override
		public String toString() {
			return "Pos [id=" + id + ", x=" + x + ", y=" + y + ", z=" + z + "]";
		}
		
		
	}

	static class Edge{
		int end;
		int dist;
		public Edge(int end, int dist) {
			super();
			this.end = end;
			this.dist = dist;
		}
		@Override
		public String toString() {
			return "Edge [end=" + end + ", dist=" + dist + "]";
		}
		
		
	}
	private static List<Edge>[] graph;
	private static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		Map<Integer, Pos> mapPos = new HashMap<>();
		Integer[] planetsX = new Integer[N];
		Integer[] planetsY = new Integer[N];
		Integer[] planetsZ = new Integer[N];
		graph = new ArrayList[N];
		for(int i=0; i<N; ++i) graph[i] = new ArrayList<>();
		
		for(int i=0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			mapPos.put(i, new Pos(i,x,y,z));
			
			planetsX[i] = i;
			planetsY[i] = i;
			planetsZ[i] = i;
		}
		
		Arrays.sort(planetsX, (i1,i2)-> Integer.compare(mapPos.get(i1).x, mapPos.get(i2).x));
		Arrays.sort(planetsY, (i1,i2)-> Integer.compare(mapPos.get(i1).y, mapPos.get(i2).y));
		Arrays.sort(planetsZ, (i1,i2)-> Integer.compare(mapPos.get(i1).z, mapPos.get(i2).z));
		
		int preId = planetsX[0];
		for(int i=1; i<N; ++i) {
			int id = planetsX[i];
			Pos nowPos = mapPos.get(id);
			Pos prePos = mapPos.get(preId);
			graph[id].add(new Edge(preId, nowPos.x-prePos.x));
			graph[preId].add(new Edge(id, nowPos.x-prePos.x));
			preId = id;
		}
		
		preId = planetsY[0];
		for(int i=1; i<N; ++i) {
			int id = planetsY[i];
			Pos nowPos = mapPos.get(id);
			Pos prePos = mapPos.get(preId);
			graph[id].add(new Edge(preId, nowPos.y-prePos.y));
			graph[preId].add(new Edge(id, nowPos.y-prePos.y));
			preId = id;
		}
		
		preId = planetsZ[0];
		for(int i=1; i<N; ++i) {
			int id = planetsZ[i];
			Pos nowPos = mapPos.get(id);
			Pos prePos = mapPos.get(preId);
			graph[id].add(new Edge(preId, nowPos.z-prePos.z));
			graph[preId].add(new Edge(id, nowPos.z-prePos.z));
			preId = id;
		}
		
		
		System.out.println(prim(0));
		

		
		
	}
	
	
	private static long prim(int start) {
		long sum = 0;
		boolean[] visited = new boolean[N];
		PriorityQueue<Edge> pq = new PriorityQueue<>((e1,e2) -> Integer.compare(e1.dist, e2.dist));
		pq.offer(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if(visited[cur.end]) continue;
			visited[cur.end] = true;
			sum += cur.dist;
			
			for(Edge next : graph[cur.end]) {
				if(visited[next.end]) continue;
				pq.offer(next);
			}
			
		}
		
		return sum;
	}
	
	
}
