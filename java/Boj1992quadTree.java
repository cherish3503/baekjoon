import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1992quadTree {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		for(int r=0; r<N; ++r) {
			String str = br.readLine();
			for(int c=0; c<N; ++c) {
				board[r][c] = str.charAt(c) - '0';
			}
		}
		
		System.out.println(makeQuad(board, 0,0, N));
	}
	
	
	private static String makeQuad(int[][] board, int sr, int sc, int len) {
		if(len == 1) return board[sr][sc] + "";
	
		StringBuilder sb = new StringBuilder("(");
		sb.append(makeQuad(board,sr,sc,len/2));
		sb.append(makeQuad(board,sr,sc+len/2,len/2));
		sb.append(makeQuad(board,sr+len/2,sc,len/2));
		sb.append(makeQuad(board,sr+len/2,sc+len/2,len/2));
		sb.append(")");
		String str = sb.toString();
		
		char temp = sb.charAt(1);
		if(temp == '0' || temp == '1') {
			if(!str.contains(((temp-'0')^1) + "")) return temp +""; // 모두 한가지 비트인경우
		}
		return str;

	}
}
