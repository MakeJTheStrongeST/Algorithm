import java.io.*;
import java.util.*;

public class Day1_BOJ1991_임규태 {
	static BufferedReader br;
	static StringTokenizer st;

	static Node[] arr = new Node[26];
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			char cur = st.nextToken().charAt(0);
			arr[cur-'A'] = new Node(cur,st.nextToken().charAt(0),st.nextToken().charAt(0));
		}
		preorder(0);
		System.out.println();
		inorder(0);
		System.out.println();
		postorder(0);
	}
	
	static void preorder(int idx) {
		System.out.print(arr[idx].val);
		if(arr[idx].l != '.') preorder(arr[idx].l-'A');
		if(arr[idx].r != '.') preorder(arr[idx].r-'A');
	}
	
	static void inorder(int idx) {
		if(arr[idx].l != '.') inorder(arr[idx].l-'A');
		System.out.print(arr[idx].val);
		if(arr[idx].r != '.') inorder(arr[idx].r-'A');
	}
	
	static void postorder(int idx) {
		if(arr[idx].l != '.') postorder(arr[idx].l-'A');
		if(arr[idx].r != '.') postorder(arr[idx].r-'A');
		System.out.print(arr[idx].val);
	}
	
	static class Node{
		char l,r,val;
		public Node(char val,char l,char r) {
			this.l = l;
			this.r = r;
			this.val = val;
		}
		
	}
}
