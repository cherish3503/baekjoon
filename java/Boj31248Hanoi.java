import java.io.*;
import java.util.*;


public class Boj31248Hanoi {
	private static int result;
	private static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		result = 0;
		
		int N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();

		moveD(N, 0, 1);
		System.out.println(result);
		System.out.println(sb);
		
	}
	
	public static void moveD(int n, int now, int target) {
		int other = 3-now-target;
		
		if(n==0) return;
		if(n==1) {
			result++;
			sb.append(toChar(now) + " D").append("\n");
			return;
		}
		
		moveOther(n-2, now, target);
		sb.append(toChar(now) + " " + toChar(other)).append("\n");
		sb.append(toChar(now) + " D").append("\n");
		sb.append(toChar(other) + " D").append("\n");
		result+=3;
		moveD(n-2, target, now);
	}
	
	public static void moveOther(int n, int now, int target) {
		if(n<=0) return;
		int other = 3-now-target;

		moveOther(n-1, now, other);
		sb.append((toChar(now) + " " + toChar(target))).append("\n");
		moveOther(n-1, other, target);

		result++;
	}
	
	public static char toChar(int n) {
		return (char)('A'+ n);
	}
}
