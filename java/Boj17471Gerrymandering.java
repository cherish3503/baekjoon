import java.io.*;
import java.util.*;

public class Boj17471Gerrymandering {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] populations = new int[N]; // 0~N-1
		st = new StringTokenizer(br.readLine());
		int sumPopulation = 0;
		for(int i=0; i<N; ++i) {
			int inp = Integer.parseInt(st.nextToken());
			sumPopulation += inp;
			populations[i] = inp;
		}
		

		List<Integer>[] graph = new ArrayList[N]; // 0~N-1
		for(int i=0; i<N; ++i) graph[i] = new ArrayList<>();
		for(int i=0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			for(int j=0; j<K; ++j) {
				int e = Integer.parseInt(st.nextToken());
				graph[i].add(e-1); // 0~N-1
			}
		}
		
//		 System.out.println(getPopulation(graph, populations, 0b1101));
		
		System.out.println(choose(graph, populations, 0, 0, sumPopulation));
		
	}
	
	
	private static int choose(List<Integer>[] graph, int[] populations, int depth, int bit, int sumPopulation) {
		int N = populations.length;
		if(depth >= N) {
			int getP = getPopulation(graph, populations, bit);
			int getNP = getPopulation(graph, populations, (bit^((1<<N)-1)));
			if(getP != -1 && getNP != -1) return Math.abs(sumPopulation - 2*getP);
			return Integer.MAX_VALUE;
		}
		
		if(Integer.bitCount(bit) >= N-1) {
			return Integer.MAX_VALUE;
		}
		
		return Math.min(choose(graph, populations, depth+1, bit, sumPopulation), choose(graph, populations, depth+1, bit|(1<<depth), sumPopulation));
	}
	
	
	
	private static int getPopulation(List<Integer>[] graph, int[] populations, int bit) {
		if(Integer.bitCount(bit) == 0) return -1;
		
		int N = populations.length;
		int sum =0;
		
		int now =0;
		for(int i=0; i<N; ++i) {
			if((bit&(1<<i)) != 0) {
				now = i;
				break;
			}
		}

		boolean[] visited = new boolean[N];
		Arrays.fill(visited, false);
		Deque<Integer> dq = new ArrayDeque<>();
		dq.offer(now);
		bit = bit & ~(1<<now); // 비트 꺼줌
		
		while(!dq.isEmpty()) {
			int cur = dq.poll(); 
			List<Integer> edges = graph[cur];
			sum += populations[cur];

			
			for(int i=0; i<edges.size(); ++i) {
				int next = edges.get(i);
				if((bit&(1<<next)) == 0) continue;

				bit = bit & ~(1<<next); // 비트 꺼줌
				dq.offer(next);
			}
		}
		if(bit == 0) return sum;
		else return -1;
	}
}





























