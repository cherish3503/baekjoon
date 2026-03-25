import java.io.*;
import java.util.*;

public class Boj2239sudoku {
	private static final int N = 9;
	private static List<int[]> zeros;
	private static int[][] result = null;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int[][] board = new int[N][N];
//		int[][] result = new int[N][N];
		zeros = new ArrayList<>();
		for(int r=0; r<N; ++r) {
			String line = br.readLine();
			for(int c=0; c<N; ++c) {
				int now = line.charAt(c)-'0';
				board[r][c] = now;
				if(now == 0) zeros.add(new int[] {r,c});
			}
		}
		
		dfs(board, 0);
		StringBuilder sb = new StringBuilder();
		for(int r=0; r<N; ++r) {
			for(int c=0; c<N; ++c) {
				sb.append(result[r][c]);
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}
	
	
	
	
	private static void dfs(int[][] board, int depth) {
		if(result != null) return;
		if(depth == zeros.size()) {
			
			int[][] clone = new int[N][N];
			for(int r=0; r<N; ++r) {
				for(int c=0; c<N; ++c) {
					clone[r][c] = board[r][c];
				}
			}
			result = clone;
			return;
		}
		int row = zeros.get(depth)[0];
		int col = zeros.get(depth)[1];
		
		for(int i=1; i<=N; ++i) {
			if(result != null) return;
			if(!can(board, row, col, i)) continue;
//			int[][] clone = new int[N][N];
//			for(int r=0; r<N; ++r) {
//				for(int c=0; c<N; ++c) {
//					clone[r][c] = board[r][c];
//				}
//			}
			board[row][col] = i;
			dfs(board, depth+1);
			board[row][col] = 0;
			
		}
	}
	
	private static boolean can(int[][] board, int row, int col, int num) {
		int sr = (row/3)*3;
		int sc = (col/3)*3;
		for(int r=0; r<N; ++r) if(board[r][col] == num) return false;
		for(int c=0; c<N; ++c) if(board[row][c] == num) return false;
		for(int r=sr; r<sr+3; ++r) { 
			for(int c=sc; c<sc+3; ++c) { 
				if(board[r][c] == num) return false;
			}
		}
		return true;
		
	}
}
