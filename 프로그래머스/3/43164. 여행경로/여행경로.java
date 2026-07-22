import java.util.*;

class Solution {
    static List<String> list = new ArrayList<>();
    static boolean[] useTicket;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        useTicket = new boolean[tickets.length];
        
        dfs(0, "ICN", "ICN", tickets);
        
        Collections.sort(list);
        return list.get(0).split(" ");
    }
    
    public void dfs(int depth, String now, String path, String[][] tickets){
        if(depth == tickets.length){
            list.add(path);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(!useTicket[i] && now.equals(tickets[i][0])){
                useTicket[i] = true;
                dfs(depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                useTicket[i] = false;
            }
        }
    }
}