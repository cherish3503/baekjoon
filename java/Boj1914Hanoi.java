
import java.util.*;
import java.io.*;
import java.math.*;

class BigLong{
	long front;
	long back;
	
	public BigLong(long n){
		front = 0;
		back = n;
	}
	
	public BigLong mul2() {
		long pow = (long)Math.pow(10, 18);
		long back2 = (back*2);
		back = back2%pow;
		front = front*2 + back2/pow;
		return this;
	}
	
	public BigLong add(int n) {
		back = back + n;
		return this;
	}
	
	@Override
	public String toString() {
		return ""+ (front==0 ? "" : front)  + back;
	}
}

public class Boj1914Hanoi {
	private static BigLong[] dpMove;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		dpMove = new BigLong[N+1];
		for(int i=1; i<=N; ++i) dpMove[i] = new BigLong(-1);
		dpMove[1].back = 1;
		
		System.out.println(move(N));
		
		if(N<=20) printMove(N, 1, 3);
		
		
	}
	
	
//	1 -> 1
//	2 -> move(1) + 1 + move(1)
//	3 -> move(2) + 1 + move(2)
	
	public static void printMove(int n, int now, int target) {
		if(n <= 0) return;
//		StringBuilder sb = new StringBuilder();
		int other = 6-now-target;
		printMove(n-1, now, other);
//		sb.append(now).append(" ").append(target);
		System.out.println(now + " " + target);
		printMove(n-1, other, target);
	}
	
	
	public static BigLong move(int n) {
		// n개의 피라미드 블럭을 다른 위치로 그대로 옮김
		if(dpMove[n].back != -1) return dpMove[n];
		return dpMove[n] = move(n-1).mul2().add(1);		
	}
	
}