import java.io.*;
import java.util.*;

public class Boj9252Lcs {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int[][] mat = lcsMatrix(str1, str2);
//		Arrays.stream(mat).map(Arrays::toString).forEach(System.out::println);
		System.out.println(mat[mat.length-1][mat[0].length-1]);
		System.out.println(getLcs(mat, str1, str2));
	}
	
	private static int[][] lcsMatrix(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		
		int[][] mat = new int[len1+1][len2+1];
		
		for(int c1=1; c1<=len1; ++c1) {
			for(int c2=1; c2<=len2; ++c2) {
				if(str1.charAt(c1-1) == str2.charAt(c2-1)) {
					mat[c1][c2] = mat[c1-1][c2-1] +1;
				}
				else {
					mat[c1][c2] = Math.max(mat[c1-1][c2], mat[c1][c2-1]);
				}
			}
		}

		return mat;
	}
	
	private static String getLcs(int[][] mat, String str1, String str2) {
		StringBuilder sb = new StringBuilder();
		int len1 = str1.length();
		int len2 = str2.length();
		
		int idx1 = len1;
		int idx2 = len2;
		
		while(true) {
			if(idx1 == 0 || idx2 == 0) {
				break;
			}
			
			if(mat[idx1][idx2] == mat[idx1-1][idx2]) { // 좌상 같은게 있으면 이동
				idx1--;
			}
			else if(mat[idx1][idx2] == mat[idx1][idx2-1]) {
				idx2--;
			}
			else { // 대각선 이동 + 문자열 추가
				idx1--;
				idx2--;
				sb.append(str1.charAt(idx1));
			}
		}
		
		return sb.reverse().toString();
	}
}
