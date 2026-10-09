import java.util.*;

class Solution {
    static List<List<Integer>> list = new ArrayList<>();
    static Set<Integer> result = new HashSet<>(); 
    public int solution(String[] user_id, String[] banned_id) {
        
        for(int i = 0; i < banned_id.length; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < banned_id.length; i++){
            String banId = banned_id[i];
            
            for(int j = 0; j < user_id.length; j++){
                if(check(banId, user_id[j])){
                    list.get(i).add(j);
                }
            }
        }
        
        
        backTracking(0, 0);
        
        return result.size();
    }
    
    static void backTracking(int idx, int mask) {
        if(idx == list.size()){
            result.add(mask);
            return;
        }
        
        for(Integer ele : list.get(idx)){
            if((mask & (1 << ele)) == 0){
                backTracking(idx + 1, mask | (1 << ele));
            }
        }
    }
    
    static boolean check(String banId, String id){
        if(banId.length() != id.length()) return false;
        
        char[] banCharArr = banId.toCharArray();
        char[] idCharArr  = id.toCharArray();
        
        for(int i = 0; i < banCharArr.length; i++){
            if(banCharArr[i] != '*' && banCharArr[i] != idCharArr[i]) return false;
        }
        return true;
    }
}