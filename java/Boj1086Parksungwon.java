import java.io.*;
import java.util.*;

public class Boj1086Parksungwon {
	private static int N;
	private static int K;
	private static int[] len;
	private static int[] mods;
	private static int[] pow10;
	private static long[][] bitModCnt;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		len = new int[N];
		mods = new int[N];
		for(int i=0; i<N; ++i) {
			String line = br.readLine();
			arr[i] = line;
			len[i] = line.length();
		}
		
		
		
		K = Integer.parseInt(br.readLine());
		bitModCnt = new long[1<<N][K];
		pow10 = new int[51];
		pow10[0] = 1;
		for(int i=1; i<51; ++i) pow10[i] = (pow10[i-1] * 10)%K;
		
		for(int i=0; i<N; ++i) mods[i] = stringMod(arr[i], K);
		
		for(int i=0; i<N; ++i) bitModCnt[1<<i][mods[i]] = 1;
		cnt();
		StringBuilder sb = new StringBuilder();
		long factN = fact(N);
		long trueCnt = bitModCnt[(1<<N)-1][0];
		long gcd = gcd(trueCnt, factN);
		sb.append(trueCnt/gcd).append("/");
		if(trueCnt == 0) sb.append(1);
		else sb.append(fact(N)/gcd);
		
		
		System.out.println(sb);
		
	}
	
	private static int stringMod(String str, int K) {
		int mod = 0;
		for(int i=0; i<str.length(); ++i) {
			mod = (mod*10 + (str.charAt(i)-'0'))%K; 
		}
		return mod;
	}
	
	private static void cnt() {
		for(int bit=0; bit<(1<<N); ++bit) {
			for(int i=0; i<N; ++i) {
				if((bit & (1<<i)) != 0) continue;
				int nextBit = bit|(1<<i);
				for(int r=0; r<K; ++r) {
					if(bitModCnt[bit][r] == 0) continue;
					int nextR = (r * pow10[len[i]] + mods[i])%K;
					bitModCnt[nextBit][nextR] += bitModCnt[bit][r];

				}
			}
		}
	}
	
	
	private static long gcd(long a, long b) {
		if(b == 0) return a;
		else return gcd(b, a%b);
	}
	
	private static long fact(int n) {
		if(n == 1) return 1;
		else return fact(n-1)*n;
	}
}
