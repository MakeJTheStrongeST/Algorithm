package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day1_BOJ1991_�ڿ��� {
	static Node[] tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// �ʱ�ȭ
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		tree = new Node[N];

		// �迭�� Ʈ�� ����
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			char data = st.nextToken().charAt(0);
			char leftChildData = st.nextToken().charAt(0);
			char rightChildData = st.nextToken().charAt(0);
			Node node = new Node(data, leftChildData, rightChildData);
			tree[data - 'A'] = node;
		}

		preorder(0);	// ������ȸ
		System.out.println();
		inorder(0);		// ������ȸ
		System.out.println();
		postorder(0);	// ������ȸ
	}

	static void preorder(int idx) {
		char data = tree[idx].data;
		char leftChildData = tree[idx].leftChild;
		char rightChildData = tree[idx].rightChild;

		System.out.print(data);
		if (leftChildData != '.')
			preorder(leftChildData - 'A');
		if (rightChildData != '.')
			preorder(rightChildData - 'A');
	}
	
	static void inorder(int idx) {
		char data = tree[idx].data;
		char leftChildData = tree[idx].leftChild;
		char rightChildData = tree[idx].rightChild;

		if (leftChildData != '.')
			inorder(leftChildData - 'A');
		System.out.print(data);
		if (rightChildData != '.')
			inorder(rightChildData - 'A');
	}
	
	static void postorder(int idx) {
		char data = tree[idx].data;
		char leftChildData = tree[idx].leftChild;
		char rightChildData = tree[idx].rightChild;

		if (leftChildData != '.')
			postorder(leftChildData - 'A');
		if (rightChildData != '.')
			postorder(rightChildData - 'A');
		System.out.print(data);
	}
}

class Node {
	char data;
	char leftChild;
	char rightChild;

	Node(char data, char leftChild, char rightChild) {
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
}
