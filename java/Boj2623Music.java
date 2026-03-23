import java.io.*;
import java.util.*;


public class Boj2623Music {
	private static int N;
	private static List<Integer>[] graph;
	private static int[] indegree;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		for(int i=1; i<=N; ++i) graph[i] = new ArrayList<>();
		indegree = new int[N+1];

		
		for(int i=0; i<M; ++i) {
			st = new StringTokenizer(br.readLine());
			int pN = Integer.parseInt(st.nextToken());
			int pre = Integer.parseInt(st.nextToken());
			for(int j=1; j<pN; ++j) {
				int post = Integer.parseInt(st.nextToken());
				graph[pre].add(post);
				indegree[post]++;
				pre = post;
			}
			
		}
		List<Integer> result = tpSort();
		if(result.size() != N) System.out.println(0);
		else for(int i=0; i<N; ++i) System.out.println(result.get(i));
	

	}
	
	private static List<Integer> tpSort() {
		List<Integer> result = new ArrayList<>();
		Deque<Integer> dq = new ArrayDeque<>();
		for(int i=1; i<=N; ++i) {
			if(indegree[i] == 0) dq.offer(i);
		}
		
		while(!dq.isEmpty()) {
			int now = dq.poll();
			result.add(now);
			
			for(int next : graph[now]) {
//				indegree[next]--;
				if(--indegree[next] == 0) dq.offer(next);
			}
		}
		return result;
	}
}
