import java.io.*;
import java.util.*;


public class Boj5052Phone {
	static class Trie{
		String data;
		Trie[] children;
		
		
		public Trie() {
			super();
			this.children = new Trie[10];
		}


		public Trie(String data) {
			super();
			this.data = data;
			this.children = new Trie[10];
//			for(int i=0; i<10; ++i) this.children[i] = new Trie(i);
		}


		@Override
		public String toString() {
			final int maxLen = 10;
			return "Trie [data=" + data + ", children="
					+ (children != null ? Arrays.asList(children).subList(0, Math.min(children.length, maxLen)) : null)
					+ "]";
		}
		
		
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
//		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=T; ++test) {
			int N = Integer.parseInt(br.readLine());
			String[] arr  = new String[N];
			
			
			for(int i=0; i<N; ++i) arr[i] = br.readLine();
			
			Arrays.sort(arr, (s1,s2)-> Integer.compare(s1.length(), s2.length()));
			
			System.out.println(triePhone(arr) ? "YES" : "NO");
			
			
		}
		
		
		
		
	}
	
	private static boolean triePhone(String[] arr) {
		Trie root = new Trie();
		
		for(String phone :arr) {
			Trie node = root;
			for(int i=0; i<phone.length(); ++i) {
				int now = phone.charAt(i) - '0';
				
				if(node.children[now] == null) node.children[now] = new Trie();

				node = node.children[now];
				if(node.data != null) return false; // 같은 경우는 없으므로 뒤에서 해줘도 됨
			}
			
			node.data = phone;
		}
		
		return true;
	}


}
