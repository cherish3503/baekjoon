import java.util.*;
import java.io.*;


public class Boj1799Bishop {
	
	private static int N;
	private static List<int[]>[] rcLs;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());

		rcLs = new ArrayList[2*N-1];
		for(int i=0; i<2*N-1; ++i) rcLs[i] = new ArrayList<>(); 
//		

		
		//r+c 가 같은 좌표를 리스트로 모은다.
		for(int r=0; r<N; ++r) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; ++c) {
				int now = Integer.parseInt(st.nextToken());
//				board[r][c] = now;
				if(now == 1) rcLs[r+c].add(new int[] {r,c});
				
			}
		}
		
		//visited : r-c가 같은 숫자를 방문했는지
		boolean[] visited = new boolean[2*N-1];
		int result = combi(visited, 0, 0) + combi(visited, 1, 0);
		System.out.println(result);

	}
	
	private static int combi(boolean[] visited, int depth, int cnt) {
		if(depth >= 2*N-1) return cnt; 
		List<int[]> nowLs = rcLs[depth];
		int result = Integer.MIN_VALUE;
		
		for(int[] pos : nowLs){
			int r = pos[0];
			int c = pos[1];
			if(visited[r-c+N-1]) continue;
			
			visited[r-c+N-1] = true;
			result = Math.max(result, combi(visited, depth+2, cnt+1));
			visited[r-c+N-1] = false;
		}
		
		result = Math.max(result, combi(visited, depth+2, cnt));
		return result;
			
	}
}
