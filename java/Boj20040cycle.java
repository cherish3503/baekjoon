import java.io.*;
import java.util.*;

public class Boj20040cycle {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] parent = new int[N];
		for(int i=0; i<N; ++i) parent[i] = i;
		int result = 0;
		for(int i=0; i<M; ++i) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			if(!union(parent, v1, v2)) {
				result =  i+1;
				break;
			}
		}
		System.out.println(result);
		
	}
	private static boolean union(int[] parent, int a, int b) {
		int ra = find(parent, a);
		int rb = find(parent, b);
		
		if(ra == rb) return false;
		parent[rb] = ra;
		return true;
	}
	
	private static int find(int[] parent, int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent, parent[x]);
	}
}
