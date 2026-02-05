import java.util.*;
import java.io.*;


public class Boj15900TreeEscape {
//	class Node{
//		int data;
//		int height;
//		boolean isLeaf = true;
//		
//		Node(int data, int height, boolean isLeaf){
//			this.data = data;
//			this.height = height;
//			this.isLeaf = isLeaf;
//		}
//	}
	public static void main(String[] args) throws Exception{
		// TODO 모든 리프노드의 높이를 구한다. 합의 홀짝을 구한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int cntLeaf[] = new int[N+1];
		boolean isLeaf[] = new boolean[N+1];
		int height[] = new int[N+1];
		Map<Integer, List<Integer>> graph = new HashMap<>();
		
//		cntLeaf[1]++;
		height[1]=0;
		
		for(int i=0; i<N-1; ++i) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			List<Integer> n1List = graph.getOrDefault(n1, new ArrayList<>());
			n1List.add(n2);
			List<Integer> n2List = graph.getOrDefault(n2, new ArrayList<>());
			n2List.add(n1);
			graph.put(n1, n1List);
			graph.put(n2, n2List);
			
//			// 트리에 없는 노드끼리 미리 간선을 입력받는 경우는 없다고 가정 - 실패
//			if(cntLeaf[n1] > 0) {
//				height[n2] = height[n1]+1;
//			}
//			else if(cntLeaf[n2] > 0) {
//				height[n1] = height[n2]+1;
//			}
			
			cntLeaf[n1]++;
			cntLeaf[n2]++;
		}
		

		boolean[] visited = new boolean[N+1];
		getHeight(graph, height, visited, 1, 1);
		
//		System.out.println(Arrays.toString(height));
//		System.out.println(Arrays.toString(isLeaf));
		
		
		
		int sum = 0;
		for(int i=1; i<=N; ++i) {
			if(cntLeaf[i] == 1) {
				sum+=height[i];
			}
		}
		
		System.out.println(sum%2 == 0 ? "No" : "Yes");
	}
	
	private static void getHeight(Map<Integer, List<Integer>> graph, int[] heightArr, boolean[] visited, int now, int depth) {
		List<Integer> child = graph.get(now);
		Iterator<Integer> it = child.iterator();
		
//		if(child == null || child.isEmpty()) {
//			isLeaf[now] = true;
//		}
		
		visited[now] = true;
		while(it.hasNext()){
			int c = it.next();
			if(visited[c]) {
				continue;
			}
			heightArr[c] = depth;
//			it.remove();
//			graph.get(c).remove(Integer.valueOf(now));
			
			getHeight(graph, heightArr, visited, c, depth+1);
		}
		

	}
}
