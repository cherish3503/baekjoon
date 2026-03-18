
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Boj13460Escape {
	static class Pos{
		int row;
		int col;
		public Pos(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
		
		private void move(int nr ,int nc) {
			this.row = nr;
			this.col = nc;
		}
		private boolean sameLoc(Pos pos) {
			return pos.row==this.row && pos.col == this.col;
		}

		@Override
		public String toString() {
			return "Pos [row=" + row + ", col=" + col + "]";
		}
		
	}
	
	private static int N;
	private static int M;
	private static char[][] board;
	private static Pos oPos;
	private static int[][] dirArr = {{-1,0},{1,0},{0,-1},{0,1}}; // udlr
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		Pos rPos = null;
		Pos bPos = null;
		
		for(int r=0; r<N; ++r) {
			String line = br.readLine();
			for(int c=0; c<M; ++c) {
				char now = line.charAt(c);
				
				if(now == 'R') rPos = new Pos(r,c);
				else if(now == 'B') bPos = new Pos(r,c);
				else if(now == 'O') oPos = new Pos(r,c);
				
				if(now == '#') board[r][c] = now;
				else board[r][c] = '.';
			}
		}
		int result = simulation(0, rPos, bPos, -1);
		
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
		
	}
	
	private static int simulation(int depth, Pos rPos, Pos bPos, int dir) {
		// 각각 기울이면 구슬이 겹칠 수 있음.
		// 앞쪽에 있는 구슬 먼저 이동하고 뒤에 있는 구슬 이동
		// 동시에 들어가면 실패(?)
		// 이전 dir 다시 할 필요 없음 & R만 벽붙은곳은 해야됨
//		Pos nrPos
		if(depth == 10) return Integer.MAX_VALUE;
		
		int result = Integer.MAX_VALUE;
		for(int d=0; d<dirArr.length; ++d) {
			if(d == dir) continue;
			Pos nrPos = new Pos(rPos.row, rPos.col);
			Pos nbPos = new Pos(bPos.row, bPos.col);
			boolean isFinish = false;
			int temp = Integer.MAX_VALUE;
			
			Pos[] posArr = new Pos[2];

			if(isRFirst(rPos, bPos, d)) {
				if(lean(nrPos, d, nbPos)) {
					temp = depth+1;
					isFinish = true;
				}
				if(lean(nbPos, d, nrPos)) {
					temp = Integer.MAX_VALUE;
					isFinish = true;
				}
				if(isFinish) {
					result = Math.min(result, temp);
					continue;
				}
			}
			else {
				if(lean(nbPos, d, nrPos)) {
					result = Math.min(result, Integer.MAX_VALUE);
					continue;
				}
				if(lean(nrPos, d, nbPos)) {
					result = Math.min(result, depth+1);
					continue;
				}

			}
			

			



			result = Math.min(result, simulation(depth+1, nrPos, nbPos, d));
		}
		return result;
		
		
	}
	
	private static boolean isRFirst(Pos rPos, Pos bPos, int dir) {
		boolean result = true;
		if(dir%2 == 0) result ^= true;
		
		if(dir/2 == 0) {
			if(rPos.row<bPos.row) result ^= true;
		}
		else {
			if(rPos.col<bPos.col) result ^= true;
		}
		return result;
	}
	
	private static boolean lean(Pos pos, int dir, Pos counterPos) {
		int sr = pos.row;
		int sc = pos.col;
		
		int nr = sr + dirArr[dir][0];
		int nc = sc + dirArr[dir][1];
		while(board[nr][nc] == '.' && !(nr == counterPos.row && nc == counterPos.col)) {
			pos.move(nr, nc);
			if(oPos.sameLoc(pos)) {
				pos.move(-1, -1);
				return true;
			}

			nr += dirArr[dir][0];
			nc += dirArr[dir][1];

		}
		
//		if(board[nr][nc] == 'O') return true;
		return false;
	}




}
