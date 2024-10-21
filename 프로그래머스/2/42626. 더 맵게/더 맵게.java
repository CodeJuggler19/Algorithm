import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> q = new PriorityQueue<>();
        
        for(int node : scoville){
            q.add(node);
        }
        int cnt = 0;
        while(!q.isEmpty()){
            int a = q.poll();
            
            if(a >= K){
                break;
            }
            if(!q.isEmpty()){
                int b = q.poll();
            
                q.add(a + b * 2);
            
                cnt++;    
            }else{
                return -1;
            }
            
        }
        
        return cnt;
    }
}