import java.util.*;

class Solution {
    static List<List<Integer>> list = new ArrayList<>();
    static int answer = 0;
    static Set<String> result = new HashSet<>();
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
        
        // for(int i = 0; i < list.size(); i++){
        //     System.out.println(banned_id[i]);
        //     for(Integer idx : list.get(i)){
        //         System.out.print(idx+ ": " +user_id[idx] + " ");
        //     }
        //     System.out.println("");
        // }
        
        visited = new boolean[user_id.length];
        
        backTracking(0);
        
        return result.size();
    }
    static boolean[] visited;
    
    static void backTracking(int idx){
        if(idx == list.size()){
            int[] temp = new int[list.size()];        
            int cnt = 0;
            for(int i = 0; i < visited.length; i++){
                if(visited[i]) temp[cnt++] = i;
            }
            Arrays.sort(temp);
            StringBuilder sb = new StringBuilder();
            for(int ele : temp){
                sb.append(ele);
            }
            
            if(!result.contains(sb.toString())){
                answer++;
                result.add(sb.toString());
            }
            
            answer++;
            return;
        }
        
        for(Integer ele : list.get(idx)){
            if(!visited[ele]){
                visited[ele] = true;
                backTracking(idx + 1);
                visited[ele] = false;
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