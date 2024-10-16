import java.util.*;

class Solution {
    boolean[] visited;
    int answer;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        answer = 0;
        
        Queue<String> q = new LinkedList<>();
        
        q.add(begin);
        
        int len = 0;
        int before = 1;
        int after = 0;
        while(!q.isEmpty()){
            String current = q.poll();
            
            if(len != 0 && current.equals(target)){
                answer = len;
                break;
            }
            
            if(words.length == len){
                break;
            }
            for(int i = 0; i < words.length; i++){
                boolean check = checkWord(current, words[i]);
                if(check){
                    q.add(words[i]);
                    after++;
                }        
            }
            before--;
            if(before == 0){
                before = after;
                len++;
                after =0;
            }
            
        }
        
        return answer;
    }
    boolean checkWord(String a, String b){
        int cnt = 0;
        for(int i=0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                cnt++;
            }
            if(cnt>1){
                break;
            }
        }
        if(cnt < 2){
            return true;
        }else{
            return false;
        }
    }
    
}