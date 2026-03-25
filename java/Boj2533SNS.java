import java.util.*;
import java.io.*;



public class Boj2533SNS {

	
	private static int N;
	private static int[][] dp;
	private static List<Integer>[] graph;
	private static List<Integer>[] children;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		for(int i=1; i<=N; ++i) graph[i] = new ArrayList<>();
		children = new ArrayList[N+1];
		for(int i=1; i<=N; ++i) children[i] = new ArrayList<>();
		dp = new int[N+1][2];
		
		
		for(int i=0; i<N-1; ++i) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
//			if(root == -1) root = u;
			graph[u].add(v);
			graph[v].add(u);
		}
		
		int root = 1;
		makeTree(root); // root :1 
		sns(root);
		System.out.println(Math.min(dp[root][0], dp[root][1]));
		
		
//		System.out.println(sns());

	}
	
	private static void makeTree(int root) {
		boolean[] visited = new boolean[N+1];
		
		Deque<Integer> dq = new ArrayDeque<>();
		dq.offer(root);
		visited[root] = true;
		
		while(!dq.isEmpty()) {
			int cur = dq.poll();
			for(int next : graph[cur]) {
				if(visited[next]) continue;
				visited[next] = true;
				children[cur].add(next);
				dq.offer(next);
			}
		}
		
	}
	
	
	private static void sns(int node) {
		
		for(int c : children[node]) {
			sns(c);
			dp[node][0] += dp[c][1];
			dp[node][1] += Math.min(dp[c][0], dp[c][1]);
		}
		dp[node][1]++;

	}
}
