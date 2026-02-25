import java.io.*;
import java.util.*;


public class Boj2933Mineral {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] board = new char[R][C];
		
		for(int r=0; r<R; ++r) {
			String str = br.readLine();
			for(int c=0; c<C; ++c) {
				board[r][c] = str.charAt(c);
			}
		}
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int turn = 0;
		for(int i=0; i<N; ++i) {
			int inp = Integer.parseInt(st.nextToken());
			simulation(board, R-inp, (turn++)%2);
//			print(board);
//			System.out.println();
		}
		print(board);
		

	}
	private static void print(char[][] board) {
		int R = board.length;
		int C = board[0].length;
		
		StringBuilder sb = new StringBuilder();
		for(int r=0; r<R; ++r) {
			for(int c=0; c<C; ++c) {
				sb.append(board[r][c]);
			}
			if(r != R-1) sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void simulation(char[][] board, int row, int dir) {
		//dir : l r
		int R = board.length;
		int C = board[0].length;
		
		int targetC = -1;
		for(int c=0; c<C; ++c) {
			int cc = c; //left
			if(dir == 1) cc = C-1-c; //right
			if(board[row][cc] == 'x') {
				targetC = cc;
				break;
			}
		}
		int[] addC = {1,-1}; // l r
		if(targetC == -1) return; // 막대기에 맞은것이 없음
		board[row][targetC] = '.';
		
		// 다른 조각으로 동시에 떨어지는 경우는 없음
		List<int[]> fClusters = findFallCluster(board, row, targetC+addC[dir]);// 반대 옆방향
		if(fClusters == null) fClusters = findFallCluster(board, row-1, targetC); // 윗 방향
		if(fClusters == null) fClusters = findFallCluster(board, row+1, targetC); // 아랫 방향
		if(fClusters == null) return; // 떨어지는 클러스터가 없음
		
		fall(board, fClusters);
	}
	
	private static List<int[]> findFallCluster(char[][] board, int row, int col) {
		int R = board.length;
		int C = board[0].length;
		if(row<0 || col<0 || row>=R || col>=C) return null;
		if(board[row][col] == '.') return null;
		

		int[][] dirArr = {{-1,0},{1,0},{0,-1},{0,1}};
		boolean[][] visited = new boolean[R][C];
		List<int[]> clusters = new ArrayList<>();
		
		Deque<int[]> dq = new ArrayDeque<>();
		visited[row][col] = true;
		dq.offer(new int[] {row, col});
		while(!dq.isEmpty()) {
			int[] cur = dq.poll();
			int curR = cur[0];
			int curC = cur[1];
			if(curR == R-1) return null; // 바닥에 닿아있음
			clusters.add(new int[] {curR, curC});
			
			for(int d=0; d<dirArr.length; ++d) {
				int nr = curR+dirArr[d][0];
				int nc = curC+dirArr[d][1];
				if(nr<0 || nc<0 || nr>=R || nc>=C) continue;
				if(board[nr][nc] != 'x' || visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				dq.offer(new int[]{nr, nc});
			}
		}
		return clusters;
	}
	
//	private static int[] getClustersBottom(List<int[]> fClusters, int C) {
//		int[] clustersBottom = new int[C];
//		Arrays.fill(clustersBottom, -1); // bottom의 row값을 구함
//		
//		for(int c=0; c<fClusters.size(); ++c) {
//			int[] cur = fClusters.get(c);
//			int curR = cur[0];
//			int curC = cur[1];
//			clustersBottom[curC] = Math.max(clustersBottom[curC], curR);
//		}
//		
//		return clustersBottom;
//	}
	
//	private static int fallCnt(char[][] board, int[] clustersBottom) {
//		int R = board.length;
//		int C = clustersBottom.length;
//		int cnt = 0;
//		while(true) {
//			for(int c=0; c<C; ++c) {
//				if(clustersBottom[c] == -1) continue;
//				int nr = ++clustersBottom[c];
//				if(nr == R || board[nr][c] == 'x') return cnt;
//			}
//			cnt++;
//		}
//	}
	
	// 바닥이 아닌 클러스트가 다른 클러스트에 걸리는 경우
	private static int fallCnt(char[][] board, List<int[]> fClusters) {
		int R = board.length;
		int C = board[0].length;
		int cnt = 0;
		while(true) {
			cnt++;
			for(int i=0; i<fClusters.size(); ++i) {
				int[] cur = fClusters.get(i);
				int curR = cur[0];
				int curC = cur[1];
				int nr = curR+cnt;
				if(nr == R || board[nr][curC] == 'x') return cnt-1;
			}
		}
	}
	
	private static void fall(char[][] board, List<int[]> fClusters) {
		int C = board[0].length;
		
		for(int i=0; i<fClusters.size(); ++i) {
			int[] cur = fClusters.get(i);
			board[cur[0]][cur[1]] = '.';
		}
		
		
//		int[] clustersBottom = getClustersBottom(fClusters, C);
		int fallCnt = fallCnt(board, fClusters);
		

		
		for(int i=0; i<fClusters.size(); ++i) {
			int[] cur = fClusters.get(i);
			board[cur[0]+fallCnt][cur[1]] = 'x';
		}
	}
	
	
	// 동시에 두개 떨어지는 경우는 제외한 테스트케이스만 있다고함.
	
	// 부서진 칸과 붙어있는 두 칸을 검사한다. (위, 아래, 막대기 반대 방향)
	// 두 부분이 이어지는 지 확인
	// 두 부분이 이어지지 않고 떨어지는 경우
		// 부서진 부분은 아래에 지지되고 있음 -> 윗 칸은 최대 1칸 내려감 / 옆칸 먼저 내리고 윗 칸 내리기
	// 나머지 경우는 전체 fall
	
	//가장 낮은 높이의 칸 -1 이 x인지 확인하면서 반복하며 
	
}
