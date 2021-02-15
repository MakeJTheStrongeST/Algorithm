/*트리순회*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {

	static class BinaryTree {

		private char[][] nodes;
		private int lastIndex;
		private final int SIZE;
		
		public BinaryTree(int size) {
			SIZE = size;
			nodes = new char[size+1][];//0인덱스는 안쓰므로, 예 : 11
		}
		
		public boolean isEmpty() {
			return lastIndex==0;
		}
		
		public boolean isFull() {
			return lastIndex==SIZE; //예 : 10
		}
		public void add(char e1, char[] e2) {
			if(isFull()){
				System.out.println("포화상태입니다.");//예외로 처리할수도있음
				return;
			}
			nodes[e1-65] = e2;
			lastIndex++;
		}
		
		//전위순회 dfs
		public void dfs1(int current) {
			if(current <= lastIndex) {
				//VLR
				System.out.print((char)(current+65)); 
				if(nodes[current][0]!='.') dfs1(nodes[current][0]-65);
				if(nodes[current][1]!='.') dfs1(nodes[current][1]-65);
			}
		}
		//중위순회
		public void dfs2(int current) {
			if(current <= lastIndex) {
				//LVR
				if(nodes[current][0]!='.') dfs2(nodes[current][0]-65);
				System.out.print((char)(current+65)); 
				if(nodes[current][1]!='.') dfs2(nodes[current][1]-65);
			}
		}
		//후위순회
		public void dfs3(int current) {
			if(current <= lastIndex) {
				//LRV
				if(nodes[current][0]!='.') dfs3(nodes[current][0]-65);
				if(nodes[current][1]!='.') dfs3(nodes[current][1]-65);
				System.out.print((char)(current+65)); 
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		BinaryTree tree = new BinaryTree(N*2);
		String str;
		for(int i=0;i<N;i++) {
			str = br.readLine();
			tree.add(str.charAt(0), new char[] {str.charAt(2), str.charAt(4)});
		}
		
		tree.dfs1(0);
		System.out.println();
		tree.dfs2(0);
		System.out.println();
		tree.dfs3(0);
	}
	
}
