
import java.io.*;
import java.util.*;

public class Boj14725Ant {
	static class Node{
		String data;
		Map<String, Node> next;
		
		public Node() {
			super();
			this.next = new TreeMap<String, Node>();
		}

		@Override
		public String toString() {
			final int maxLen = 10;
			return "Node [data=" + data + ", next=" + (next != null ? toString(next.entrySet(), maxLen) : null) + "]";
		}

		private String toString(Collection<?> collection, int maxLen) {
			StringBuilder builder = new StringBuilder();
			builder.append("[");
			int i = 0;
			for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
				if (i > 0) {
					builder.append(", ");
				}
				builder.append(iterator.next());
			}
			builder.append("]");
			return builder.toString();
		}
		
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Node root = new Node();
//		Map<String, Map<String, Map>> cave = new HashMap<>();
		
		for(int i=0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());

			Node now = root;
			String food = "";
			for(int j=0; j<K; ++j) {
				food = st.nextToken();
				Node next = now.next.getOrDefault(food, new Node());
				now.next.put(food, next);
				now = next;
			}
			now.data = food;
		}
		
		printCave(root, 0);
		
	}
	
	private static void printCave(Node node, int depth) {
		for(String child : node.next.keySet()) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<depth; ++i) sb.append("--");
			System.out.println(sb.append(child));
			printCave(node.next.get(child), depth+1);
		}
	}


}
