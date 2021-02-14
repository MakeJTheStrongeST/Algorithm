package week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Day3_Programmers_��ã�����_�ڿ��� {
	static int[][] nodeinfo = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 }, { 2, 2 } };
	static int idx;
	static int[][] answer;
	
	public static void main(String[] args) {
		// ��ǥ, ����ȣ, �����ڽĳ��, �������ڽĳ�� ������ ���� Node ��ü�� ����
		// Node ���� ����Ʈ�� �����ϰ� y ���� ū������, y ���� ������ x ���� ���������� ����
		// (����Ʈ���� ���ǿ� �°� �����ϱ� ���� �̷��� ������ �̾Ƴ��� ��Ʈ��忡 ������ �߰�)
		ArrayList<Node> list = new ArrayList<>();
		for(int i=0; i<nodeinfo.length; i++) {
			list.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i+1));
		}
		Collections.sort(list);
		
		// ����Ʈ�� ����
		Node root = list.get(0); // y ���� ���� ū ��尡 ��Ʈ���
		answer = new int[2][list.size()]; // ������ȸ, ������ȸ ���
		for(int i=1; i<list.size(); i++) {
			addNode(root, list.get(i)); // ��͸� �̿��� ������ ����Ʈ�� ���ǿ� �°� �߰�
		}
		
		preorder(root);
		idx = 0;
		postorder(root);
		
		System.out.println(Arrays.toString(answer[0]));
		System.out.println(Arrays.toString(answer[1]));
	}
	
	static void addNode(Node parent, Node child) {
		if(parent.x > child.x) { // ���� ����
			if(parent.left == null) // ���� �ڽ� ��������� �ٷ� �߰�
				parent.left = child;
			else // ���� �ڽ� ������ ��͸� ���� ���� �ڽĿ��� �ٽ� Ž��
				addNode(parent.left, child);
		} else { // ������ ����
			if(parent.right == null) // ������ �ڽ� ��������� �ٷ� �߰�
				parent.right = child;
			else // ������ �ڽ� ������ ��͸� ���� ������ �ڽĿ��� �ٽ� Ž��
				addNode(parent.right, child);
		}
	}
	
	static void preorder(Node node) {
		if(node != null) {
			answer[0][idx++] = node.num;
			preorder(node.left);
			preorder(node.right);
		}
	}
	
	static void postorder(Node node) {
		if(node != null) {
			postorder(node.left);
			postorder(node.right);
			answer[1][idx++] = node.num;
		}
	}

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int num;
		Node left;
		Node right;

		Node(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
		
		@Override
		public int compareTo(Node o) {
			if(y == o.y)
				return x - o.x;
			return o.y - y;
		}
	}
}
