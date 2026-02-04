package ad;
import java.util.*;
import java.io.*;

class Node{
	char data;
	Node left;
	Node right;
	
	Node(char data, Node left, Node right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

public class Boj1991TreeOrder {

	public static void main(String[] args) throws Exception{
		//이진 트리?
		// 최악의 경우 길이 2^25+2 - 생각보다 작음?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Node rootNode = new Node('A',null,null);
		
		for(int i=0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
//			Node node = new Node()
			char dataC = st.nextToken().charAt(0);
			char leftC = st.nextToken().charAt(0);
			char rightC = st.nextToken().charAt(0);
			
			Node leftNode = null;
			Node rightNode = null;
			//자식부터 만들어지기 없다고 가정
			if(leftC != '.') {
				leftNode = new Node(leftC, null, null);
			}
			if(rightC != '.') {
				rightNode = new Node(rightC, null, null);
			}
			
			if(dataC == 'A') {
				rootNode.left = leftNode;
				rootNode.right = rightNode;
			}
			
			else	makeTree(rootNode, dataC, leftNode, rightNode);
			

		}
		
//		System.out.println(rootNode.right.data + " " +  rootNode.right.left.data  + " "+ rootNode.right.right.data);
		// 
		
		
		
		StringBuilder sb1 = new StringBuilder();
		preorder(rootNode ,sb1);
		System.out.println(sb1);
		
		StringBuilder sb2 = new StringBuilder();
		inorder(rootNode ,sb2);
		System.out.println(sb2);
		
		StringBuilder sb3 = new StringBuilder();
		postorder(rootNode ,sb3);
		System.out.println(sb3);

		
		
	}
	
	private static void makeTree(Node curNode, char dataC, Node leftNode, Node rightNode) {
		if(curNode.left != null) {
			if(curNode.left.data == dataC) {
				curNode.left = new Node(dataC, leftNode, rightNode);
				return;
			}
			else {
				makeTree(curNode.left, dataC, leftNode, rightNode);
			}
		}

		if(curNode.right != null) {
			if(curNode.right.data == dataC) {
				curNode.right = new Node(dataC, leftNode, rightNode);
				return;
			}
			else {
				makeTree(curNode.right, dataC, leftNode, rightNode);
			}
		}
		return;
	}
	
	
	private static void preorder(Node node, StringBuilder sb) {
		sb.append(node.data);
		if(node.left != null)	preorder(node.left, sb);
		if(node.right != null)	preorder(node.right, sb);
	}
	
	private static void inorder(Node node, StringBuilder sb) {
		if(node.left != null)	inorder(node.left, sb);
		sb.append(node.data);
		if(node.right != null)	inorder(node.right, sb);
	}
	
	private static void postorder(Node node, StringBuilder sb) {
		if(node.left != null)	postorder(node.left, sb);
		if(node.right != null)	postorder(node.right, sb);
		sb.append(node.data);
	}
}
