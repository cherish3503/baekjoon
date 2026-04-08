import java.io.*;
import java.util.*;

public class Boj9238Key {
	private static int H;
	private static int W;
	private static char[][] board;
	private static boolean[] keys;
	private static Deque<int[]>[] unlockDoors;
	
	private static int[][] dirArr = {{-1,0},{1,0},{0,-1},{0,1}};
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
//		System.out.println((int)'A'-'a');
		
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; ++test) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
	
			board = new char[H][W];
			keys = new boolean[26];
			unlockDoors = new ArrayDeque[26];
			for(int i=0; i<26; ++i) unlockDoors[i] = new ArrayDeque<>();
			
			for(int r=0; r<H; ++r) {
				String line = br.readLine();
				for(int c=0; c<W; ++c) {
					board[r][c] = line.charAt(c);
				}
			}
			
			String line = br.readLine();
			if(!line.equals("0")) {
				for(int i=0; i<line.length(); ++i) keys[line.charAt(i)-'a'] = true;
			}
			
			System.out.println(bfs());
		}
	}
	
	private static int bfs() {
		Deque<int[]> dq = new ArrayDeque<>();
		boolean[][] visited = new boolean[H][W];
		
		int result = 0;
		
		for(int r=0; r<H; ++r) {
			if(board[r][0] != '*') {
				dq.offer(new int[] {r,0});
				visited[r][0] = true;
			}
			if(board[r][W-1] != '*') {
				dq.offer(new int[] {r,W-1});
				visited[r][W-1] = true;
			}
		}
		for(int c=1; c<W-1; ++c) { // r에서 고려한거 제외
			if(board[0][c] != '*') {
				dq.offer(new int[] {0,c});
				visited[0][c] = true;
			}
			if(board[H-1][c] != '*') {
				dq.offer(new int[] {H-1,c});
				visited[H-1][c] = true;
			}
		}
		
		while(!dq.isEmpty()) {
			int[] cur = dq.poll();
			int r = cur[0];
			int c = cur[1];
			char now = board[r][c];
			
			if(now == '$') result++;
			else if('a' <= now && now <= 'z') {
				keys[now-'a'] = true;
				while(!unlockDoors[now-'a'].isEmpty()) {
					int[] door = unlockDoors[now-'a'].poll();
					dq.offer(door);
					visited[door[0]][door[1]] = true;
				}
			}
			else if('A' <= now && now <= 'Z') {
				if(!keys[now-'A']) {
					unlockDoors[now-'A'].offer(new int[] {r,c});
					continue;
				}
			}
			

			for(int[] dir : dirArr) {
				int nr = r + dir[0];
				int nc = c + dir[1];
				
				if(nr<0||nc<0||nr>=H||nc>=W) continue;
				if(visited[nr][nc]) continue;
				if(board[nr][nc] == '*') continue;
				
				visited[nr][nc] = true;
				dq.offer(new int[] {nr,nc});
				
			}
			
			
			
		}
		return result;
	}
}
