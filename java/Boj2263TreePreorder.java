import java.util.*;
import java.io.*;

public class Boj2263TreePreorder {
	private static class Node{
		int data;
		Node right;
		Node left;
		
		public Node(int data){
			this.data = data;
		}
	}
	
	private static int[] inIdx;
	private static int[] postArr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		
		int N = Integer.parseInt(br.readLine());
		
		inIdx = new int[N+1];
		postArr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i) {
			int now = Integer.parseInt(st.nextToken());
			inIdx[now] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i) {
			int now = Integer.parseInt(st.nextToken());
//			postIdx[now] = i;
			postArr[i] = now;
		}
		
		Node root = tree(0, N, 0, N);
		preOrder(root);
		System.out.println();
		
	}
	
	private static Node tree(int ps, int pe, int is, int ie) {
		int len = pe-ps;
		if(len <= 0) return null;
		int root = postArr[pe-1];
		Node node = new Node(root);
		int inI = inIdx[root];
		int rightLen = ie-1-inI-1+1;
		int leftLen = inI-1-is+1;
		node.right = tree(pe-1-rightLen, pe-1, inI+1, ie);
		node.left = tree(ps, ps+leftLen, is, is+leftLen);
		return node;
	}
	
	private static void preOrder(Node node) {
		if(node == null) return;
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
}
