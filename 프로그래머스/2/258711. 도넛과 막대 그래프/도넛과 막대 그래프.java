import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, int[]> nodes = new HashMap<>();
        int[] answer = new int[4];
        for(int i = 0; i < edges.length; i++){
            int in = edges[i][0];
            int out = edges[i][1];
            
            if(!nodes.containsKey(in)){
                nodes.put(in, new int[]{0,0});
            }
            if(!nodes.containsKey(out)){
                nodes.put(out, new int[]{0,0});
            }
            
            nodes.get(in)[0]++;
            nodes.get(out)[1]++;
       
        }
            
        int total = 0;
        for(int key: nodes.keySet()){
            int[] cnt = nodes.get(key);
            
            if(cnt[0] >= 2 && cnt[1] == 0){
                answer[0] = key;
                total = cnt[0];
            }else if (cnt[0] == 0 && cnt[1] > 0){
                answer[2]++;
            }else if(cnt[0] == 2 && cnt[1] >= 2){
                answer[3]++;
            }
        } 
        answer[1] = total - answer[2] - answer[3];
        return answer;
    }
}