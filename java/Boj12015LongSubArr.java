import java.io.*;
import java.util.*;

public class Boj12015LongSubArr {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<Integer> longSub = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		longSub.add(0);
		
		for(int i=0; i<N; ++i) {
			int target = Integer.parseInt(st.nextToken());
			if(target > longSub.get(longSub.size()-1)) {
				longSub.add(target);
			}
			else {
				longSub.set(binarySearch(longSub, target, 1, longSub.size()-1),target);
			}
		}
		System.out.println(longSub.size()-1);
//		System.out.println(longSub);
		
//		System.out.println(binarySearch(longSub, N, 0, longSub.size()-1));
	}
	
	
	private static int binarySearch(List<Integer> ls, int target, int s, int e) {
		// 같은 경우 - 해당 인덱스 리턴
		// target 보다 큰 수의 인덱스를 리턴한다.
		// len = 2 , mid : 앞 인덱스
		// len = 짝수, mid : 뒤에 것

		if(e-s <= 0) {
			return s;
		}
		int mid = s + (e-s)/2;
		if(ls.get(mid) < target) {
			return binarySearch(ls, target, mid+1, e);
		}
		else if(ls.get(mid) > target) {
			return binarySearch(ls, target, s, mid);
		}
		else {
			return mid;
		}
	}
}
