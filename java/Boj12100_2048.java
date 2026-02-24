import java.io.*;
import java.util.*;

public class Boj12100_2048 {
	public static final int maxMoveCnt = 5;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		
		
		for(int r=0; r<N; ++r) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; ++c) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(moveDfs(board, 0));

		
//		Arrays.toString(null)
//		move(board, 3);
//		Arrays.stream(board).map(Arrays::toString).forEach(System.out::println);
//		System.out.println();
//		
//		move(board, 0);
//		Arrays.stream(board).map(Arrays::toString).forEach(System.out::println);
//		System.out.println();
//		
//		move(board, 3);
//		Arrays.stream(board).map(Arrays::toString).forEach(System.out::println);
//		System.out.println();
	}
	
	
	private static int moveDfs(int[][] board, int depth) {
		int N = board.length;
		int[][] clone = new int[N][N];
		int res = 0;
		
		if(depth == maxMoveCnt) {
			int max = 0;
			for(int r=0; r<N; ++r) {
				for(int c=0; c<N; ++c) {
					max = Math.max(max, board[r][c]);
				}
			}
			return max;
		}
		
		for(int d=0; d<4; ++d) {
			for(int r=0; r<N; ++r) {
				for(int c=0; c<N; ++c) {
					clone[r][c] = board[r][c];
				}
			}
			move(clone, d);
			res = Math.max(res, moveDfs(clone, depth+1));
		}
		return res;
		
	}
	
	
	private static void move(int[][] board, int dir) {
		// dir : udlr
		// 덱으로 관리 이전과 이후를 계산하기
		int N = board.length;
		Deque<Integer>[] dqList = new ArrayDeque[N];
		for(int i=0; i<N; ++i) dqList[i] = new ArrayDeque<>();
		 
		// now를 넣는다. 겹치면 뺴고 2배넣기
		for(int i=0; i<N; ++i) {
			int pre = -1;
			for(int j=0; j<N; ++j) {
				// left dir:2
				int ii = i;
				int jj = j;
				if(dir == 0) {
					ii = j;
					jj = i;
				}
				if(dir == 1) {
					ii = N-1-j;
					jj = N-1-i;
				}
				if(dir == 3) {
					ii = N-1-i;
					jj = N-1-j;
				}

				int now = board[ii][jj];
				if(now == 0) continue;
				if(pre == now) {
					dqList[i].pollLast(); // 앞에것 빼고 합쳐서 넣기
					dqList[i].add(now*2);
					pre = -1;
				}
				else {
					dqList[i].add(now);
					pre = now;
				}
			}
		}
		
		// 덱으로 행렬 채우기
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				// left dir:2
				int ii = i;
				int jj = j;
				if(dir == 0) {
					ii = j;
					jj = i;
				}
				if(dir == 1) {
					ii = N-1-j;
					jj = N-1-i;
				}
				if(dir == 3) {
					ii = N-1-i;
					jj = N-1-j;
				}
				
				int now = 0;
				if(!dqList[i].isEmpty()) now = dqList[i].poll();
				board[ii][jj] = now;
			}
		}
	}
}
