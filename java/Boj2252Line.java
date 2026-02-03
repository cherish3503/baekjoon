import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Boj2252Line {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
//		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
		List<Integer>[] graph = new ArrayList[N+1];
		for(int i=1; i<N+1; ++i) {
			graph[i] = new ArrayList<Integer>(0);
		}
		int[] indegree = new int[N+1];
//		indegree[0] = -1;
		 
		for(int i=0; i<M; ++i) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
//			if(graph[from] == null) {
//				graph.put(from, );new ArrayList<Integer>(Arrays.asList({to}))
//			}
			graph[from].add(to);
			indegree[to]++;
			
		}
		;
		System.out.println(topologicalSort(graph, indegree, N).stream().map(String::valueOf).collect(Collectors.joining(" ")));
		
	}
	
	
	
	private static List<Integer> topologicalSort(List<Integer>[] graph, int[] indegree, int N) {
		List<Integer> result = new ArrayList<>(N);
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i=1; i<N+1; ++i) {
			if(indegree[i] == 0)	q.offer(i);
		}
		while(!q.isEmpty()) {
			int now = q.poll();
			result.add(now);
			List<Integer> ls = graph[now];
	
			for(int e : ls) {
				if(--indegree[e] == 0) {
					q.offer(e);
				}
			}
		}
		
		
		return result;
	}
}
