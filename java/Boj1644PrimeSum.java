import java.util.*;
import java.io.*;


public class Boj1644PrimeSum {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//4M 이하 소수 : 283_146개
		List<Integer> primeLs = new ArrayList<>();
		boolean[] notPrime = new boolean[N+1];
		
		for(int i=2; i<=Math.sqrt(N); ++i) {
			if(notPrime[i]) continue;
			primeLs.add(i);
			for(int j=i; j<=N; j+=i) notPrime[j] = true;
		}
		for(int i=2; i<=N; ++i) {
			if(!notPrime[i]) primeLs.add(i);
		}

		System.out.println(twoPointer(primeLs, N));
		
	}
	
	private static int twoPointer(List<Integer> primeLs, int N) {
		int len = primeLs.size();
		if(len == 0) return 0;
		
		int cnt = 0;

		int s=0;
		int e=0;
		int sum = primeLs.get(s);
		
		while(s<len && e<len) {
			if(sum == N) {
				cnt++;
				if(++s >= len) break;
				sum += primeLs.get(s);
//				System.out.println(s+ " " + e);
			}
			else if(sum > N) {
				sum -= primeLs.get(e++);
			}
			else {
				if(++s >= len) break;
				sum += primeLs.get(s);
			}
		}
		return cnt;
	}
}
