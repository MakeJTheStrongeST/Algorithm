import java.util.*;
import java.io.*;

class Solution {
    static List<Node> nodeList = new ArrayList();
    static int[][] answer;
    static int idx1,idx2;
    public int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];
        for(int i=0;i<nodeinfo.length;i++){
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];
            
            nodeList.add(new Node(y,x,i+1));
        }
        nodeList.sort(Node::compareTo);
        Node root = nodeList.get(0);
        for(int i=1;i<nodeList.size();i++){
            build(root,nodeList.get(i));
        }
        preorder(root);
        postorder(root);
        
        return answer;
    }
    static void preorder(Node cur){
        answer[0][idx1++] = cur.num;
        if(cur.l != null) preorder(cur.l);
        if(cur.r != null) preorder(cur.r);
    }
    
    static void postorder(Node cur){
        if(cur.l != null) postorder(cur.l);
        if(cur.r != null) postorder(cur.r);
        answer[1][idx2++] = cur.num;
    }
    
    static void build(Node parent, Node target){
        if(target.x < parent.x){
            if(parent.l == null) parent.l = target;
            else build(parent.l,target);
        }
        else{
            if(parent.r == null) parent.r = target;
            else build(parent.r,target);
        }
    }
    
    static class Node implements Comparable<Node>{
        int y,x,num;
        Node l,r;
        public Node(int y,int x,int num){
            this.y = y;
            this.x = x;
            this.num = num;
        }
        
        @Override
        public int compareTo(Node o){
            return o.y - this.y;
        }
    }
}
