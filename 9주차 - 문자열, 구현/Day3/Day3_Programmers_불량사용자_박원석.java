package week9;

import java.util.HashSet;

public class Day3_Programmers_ºÒ·®»ç¿ëÀÚ_¹Ú¿ø¼® {
	final static String[][] user_id = {{"frodo", "fradi", "crodo", "abc123", "frodoc"},
			  		   {"frodo", "fradi", "crodo", "abc123", "frodoc"},
			  		   {"frodo", "fradi", "crodo", "abc123", "frodoc"}};
	final static String[][] banned_id = {{"fr*d*", "abc1**"},
					     {"*rodo", "*rodo", "******"},
					     {"fr*d*", "*rodo", "******", "******"}};
	
	static int uLen, bLen;
    	static HashSet<Integer> set;
	
	public static void main(String[] args) {
		for(int tc = 0; tc < 3; tc++) {
			set = new HashSet<>();
			System.out.println(solution(user_id[tc], banned_id[tc]));
		}
	}
	
	public static int solution(String[] user_id, String[] banned_id) {
        uLen = user_id.length; 
        bLen = banned_id.length;
        
        for(int i = 0; i < bLen; i++)
            banned_id[i] = banned_id[i].replace("*", ".");
        
        DFS(0, 0, user_id, banned_id);
        
        return set.size();
    }
    
    private static void DFS(int cnt, int flag, String[] user_id, String[] banned_id) {
        if(cnt == bLen) {
            set.add(flag);
            return;
        }
        
        for(int i = 0; i < uLen; i++) {
            if(user_id[i].matches(banned_id[cnt])) {
            	if ((flag & 1 << i) == 0) {
                    DFS(cnt + 1, flag | 1 << i, user_id, banned_id);
                }
            }
        }
    }
}
