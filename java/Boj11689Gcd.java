import java.io.*;
import java.util.*;

public class Boj11689Gcd {
	private static long sum;
	private static long n;
	private static final int maxN = 1_000_000; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 10^12 의 소수인 인수를 구하기
		// 인수는 최대 1_000_000이므로 이보다 작은 소수 구하기
		
		
		n = Long.parseLong(br.readLine());
		sum = n;
		
		boolean[] notPrime = new boolean[maxN];
		List<Integer> primeLs = new ArrayList<>();
		for(int i=2; i<maxN; ++i) {
			if(notPrime[i]) continue;
			primeLs.add(i);
			for(int j=0; j<maxN; j+=i) notPrime[j] = true;
		}
//		System.out.println(primeLs);
		
		List<Integer> factors = new ArrayList<>();

		for(int prime : primeLs) {
			if(prime > n) break;
			if(n%prime == 0) factors.add(prime);
		}
		
//		System.out.println(factors);
		long result = n;
		for(int factor : factors) {
			result /= factor;
			result *= factor-1;
		}
		System.out.println(result);
		
		
//		boolean[] visited = new boolean[factors.size()];
//		dfs(factors, visited, 0, 0);
//		System.out.println(sum);
		
	}
	
//	private static void dfs(List<Integer> factors, boolean[] visited, int depth, int cnt) {
//		int N = visited.length;
//		if(depth == N) {
//			if(cnt == 0) return;
//			long mul = cnt%2 == 0 ? 1 : -1;
//			for(int i=0; i<N; ++i) if(visited[i]) mul*=(long)factors.get(i);
//
//			sum += n/mul;
//			return;
//		}
//
//		
//		visited[depth] = true;
//		dfs(factors,visited, depth+1, cnt+1);
//		visited[depth] = false;
//		dfs(factors,visited, depth+1, cnt);
//		
//	}
	
	/*
	if 360 =  2 2 2 3 3 5 7


			2의 배수 / 3의 배수 / 5의배수 / 7의배수
			- 2*3 / 25 / 27/ 35 / 37 / 57 
			- 235 / 237 /  357
			- 2357



			45 = 3 3 5
			3 / 5			45-15-93
			-35

			99 = 3 3 11
	*/

	
	
//	private static int gcd(int a, int b) {
//		if(b == 0) return a;
//		
//		return gcd(b,a%b);
//	}
}
