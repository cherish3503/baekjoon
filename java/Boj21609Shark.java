import java.io.*;
import java.util.*;

public class Boj21609Shark {
	static class Group{
		int normalCnt;
		int rainbowCnt;
		int[] defaultPos;
		boolean[][] visited;
		
		public Group(int normalCnt, int rainbowCnt, int[] defaultPos, boolean[][] visited) {
			super();
			this.normalCnt = normalCnt;
			this.rainbowCnt = rainbowCnt;
			this.defaultPos = defaultPos;
			this.visited = visited;
		}
	}
	
	private static int[][] dirArr = {{-1,0},{1,0},{0,-1},{0,1}};
	private static final int BLANK = -3;
	private static int sum = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N][N];
		
		for(int r=0; r<N; ++r) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; ++c) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		

		while(true) { // 그룹이 없을때까지 반복
			int[][] nextBoard = game(board, M);
			if(nextBoard == null) break;
			board = nextBoard;
		}

		System.out.println(sum);
		
		
		
	}
	
	private static int[][] game(int[][] board, int M) {
		int N = board.length;
		int[][][] clone = new int[M][N][N];
		
		Group bigGroup = null;

		// 타입 마다 보드 초기화
		// 같은 타입내에서는 그룹이 겹치지 않음
		for(int m=1; m<=M; ++m) { 
			for(int r=0; r<N; ++r) { 
				for(int c=0; c<N; ++c) {
					clone[m-1][r][c] = board[r][c];
				}
			}
			
			for(int r=0; r<N; ++r) {
				for(int c=0; c<N; ++c) {
					if(clone[m-1][r][c] != m) continue; // 같은 타입만 연산
					Group g = makeGroup(clone[m-1],r,c,m);
					if(g == null) continue; // 1개인 블럭

					if(isBigger(g, bigGroup)) bigGroup = g; // 초기 null도 고려됨
				}
			}
		}
		
		if(bigGroup == null) return null; // 블럭 없으면 종료
		int bigCnt = bigGroup.normalCnt + bigGroup.rainbowCnt;
		sum += bigCnt*bigCnt;
		
		// clone은 해당타입의 모든 그룹을 다 체크함
		// visited : 처리된 블럭
		for(int r=0; r<N; ++r) {
			for(int c=0; c<N; ++c) {
				if(bigGroup.visited[r][c]) board[r][c] = BLANK;
			}
		}
		
		board = gravity(board);	
		board = rotate(board);
		board = gravity(board);
		
		return board;

	}
	
	private static boolean isBigger(Group g, Group best) {
		if(g == null) return false;
		if(best == null) return true;
		
		int cnt = g.normalCnt + g.rainbowCnt;
		int bigCnt = best.normalCnt + best.rainbowCnt;
		if(cnt != bigCnt) return cnt > bigCnt;
		if(g.rainbowCnt != best.rainbowCnt) return g.rainbowCnt > best.rainbowCnt;
		if(g.defaultPos[0] != best.defaultPos[0]) return g.defaultPos[0] > best.defaultPos[0];
		return g.defaultPos[1] > best.defaultPos[1];
		
	}
	
	private static Group makeGroup(int[][] board, int sR, int sC, int type){
		// 일반블럭부터 시작 : 일반 적어도 하나
		int N = board.length;
		boolean[][] visited = new boolean[N][N];
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] {sR, sC});
		visited[sR][sC] = true;
		
		int normalCnt = 0;
		int rainbowCnt = 0;
		int[] defaultPos = new int[2];
		
		defaultPos[0] = sR;
		defaultPos[1] = sC;
		
		while(!dq.isEmpty()) {
			int[] now = dq.poll();
			int nowR = now[0];
			int nowC = now[1];
			
			if(board[nowR][nowC] == 0) rainbowCnt++;
			else if(board[nowR][nowC] == type) { // 일반 블럭
				normalCnt++;
				if(nowR < defaultPos[0]) { // 기준 블럭
					defaultPos[0] = nowR;
					defaultPos[1] = nowC;
				}
				else if(nowR == defaultPos[0]) defaultPos[1] = Math.min(nowC, defaultPos[1]);
			}
			board[nowR][nowC] = -2; // 선택된 블럭 표시 // 같은 타입으로 하면 
					
			
			for(int[] d : dirArr) {
				int nr = nowR + d[0];
				int nc = nowC + d[1];
				
				if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
				if(visited[nr][nc]) continue;
				if(board[nr][nc] != type && board[nr][nc] != 0) continue; // 무지개나 같은 타입이 아니면 실패

				dq.offer(new int[] {nr,nc});
				visited[nr][nc] = true;

			}
		}
		if(normalCnt + rainbowCnt < 2) return null; // 최소 2개이상의 블럭
		
		return new Group(normalCnt, rainbowCnt, defaultPos, visited);

	}
	
	
	private static int[][] rotate(int[][] board){
		int N = board.length;
		int[][] rotated = new int[N][N];
		
		for(int r=0; r<N; ++r) {
			for(int c=0; c<N; ++c) {
				rotated[N-1-c][r] =  board[r][c];
			}
		}
		return rotated;
	}
	
	private static int[][] gravity(int[][] board) {
		int N = board.length;
		int[][] clone = new int[N][N];
		for(int r=0; r<N; ++r) {
			Arrays.fill(clone[r], BLANK);
		}
		
		for(int c=0; c<N; ++c) {
			int nr = N-1;
			for(int r=N-1; r>=0; --r) {
				if(board[r][c] == BLANK) continue;
				if(board[r][c] == -1) nr=r;
				clone[nr--][c] = board[r][c];
			}
		}
		
		
		return clone;
	}
}
