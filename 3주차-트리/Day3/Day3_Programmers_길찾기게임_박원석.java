package week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Day3_Programmers_길찾기게임_박원석 {
	static int[][] nodeinfo = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 }, { 2, 2 } };
	static int idx;
	static int[][] answer;
	
	public static void main(String[] args) {
		// 좌표, 노드번호, 왼쪽자식노드, 오른쪽자식노드 정보를 가진 Node 객체를 구현
		// Node 들을 리스트에 저장하고 y 값이 큰순으로, y 값이 같으면 x 값이 작은순으로 정렬
		// (이진트리의 조건에 맞게 구현하기 위해 이러한 순서로 뽑아내며 루트노드에 노드들을 추가)
		ArrayList<Node> list = new ArrayList<>();
		for(int i=0; i<nodeinfo.length; i++) {
			list.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i+1));
		}
		Collections.sort(list);
		
		// 이진트리 구현
		Node root = list.get(0); // y 값이 가장 큰 노드가 루트노드
		answer = new int[2][list.size()]; // 전위순회, 후위순회 결과
		for(int i=1; i<list.size(); i++) {
			addNode(root, list.get(i)); // 재귀를 이용해 노드들을 이진트리 조건에 맞게 추가
		}
		
		preorder(root);
		idx = 0;
		postorder(root);
		
		System.out.println(Arrays.toString(answer[0]));
		System.out.println(Arrays.toString(answer[1]));
	}
	
	static void addNode(Node parent, Node child) {
		if(parent.x > child.x) { // 왼쪽 방향
			if(parent.left == null) // 왼쪽 자식 비어있으면 바로 추가
				parent.left = child;
			else // 왼쪽 자식 있으면 재귀를 통해 왼쪽 자식에서 다시 탐색
				addNode(parent.left, child);
		} else { // 오른쪽 방향
			if(parent.right == null) // 오른쪽 자식 비어있으면 바로 추가
				parent.right = child;
			else // 오른쪽 자식 있으면 재귀를 통해 오른쪽 자식에서 다시 탐색
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
