import java.util.*;

class Solution {
    static int answer;
    static boolean[] user_id_chk;
    public int solution(String[] user_id, String[] banned_id) {
        user_id_chk = new boolean[1<<user_id.length];
        f(0,user_id,banned_id,0);
        return answer;
    }
    
    static void f(int banned_cnt,String[] user_id,String[] banned_id,int mask){
        if(banned_cnt == banned_id.length){
            if(!user_id_chk[mask]){
                user_id_chk[mask] = true;
                answer++;
            }
            return;
        }
        
        String cur_banned_id = banned_id[banned_cnt];
        for(int i=0;i<user_id.length;i++){
            if((mask&(1<<i)) != 0) continue;
            String cur = user_id[i];
            
            boolean flag = true;
            if(cur.length() != cur_banned_id.length()) continue;
            
            for(int j=0;j<cur_banned_id.length();j++){
                if(cur.charAt(j) != cur_banned_id.charAt(j) && cur_banned_id.charAt(j) != '*'){
                    flag = false;
                    break;
                }
            }
            if(flag){
                f(banned_cnt+1,user_id,banned_id,mask|1<<i);
            }
        }
    }
}
