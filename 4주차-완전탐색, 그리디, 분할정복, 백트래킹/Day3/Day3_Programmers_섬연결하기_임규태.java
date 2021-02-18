import java.util.*;
import java.io.*;

class Solution {
    static int[] p = new int[100];
    
    static int find(int a){
        if(p[a] == -1) return a;
        return p[a] = find(p[a]);
    }
    
    static boolean merge(int a,int b){
        a = find(a);
        b = find(b);
        if(a == b) return false;
        p[b] = a;
        return true;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<edge> edgeList = new ArrayList();
        for(int[] in : costs){
            edgeList.add(new edge(in[0],in[1],in[2]));
        }
        
        Collections.sort(edgeList, (o1, o2) -> o1.c - o2.c);
        Arrays.fill(p,-1);
        
        int limit = n-1;
        for(int i=0;0<limit;i++){
            edge nowEdge = edgeList.get(i);
            
            int a = nowEdge.a;
            int b = nowEdge.b;
            int c = nowEdge.c;
            
            if(merge(a,b)){
                answer += c;
                limit--;
            }
        }
        
        return answer;
    }
    
    static class edge{
        int a,b,c;
        public edge(int a,int b,int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
