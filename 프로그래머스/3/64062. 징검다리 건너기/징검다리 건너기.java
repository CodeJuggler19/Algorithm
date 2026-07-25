import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200000000;
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(check(stones, k, mid - 1)){
                left = mid + 1;                
            }else{
                right = mid - 1;
            }
        }
        
        
        return (left - 1);
    }
    
    public boolean check(int[] stones, int k, int num){
        boolean[] check = new boolean[stones.length];
        
        for(int i = 0; i < stones.length; i++){
            if(stones[i] - num > 0) check[i] = true;
        }
        
        int cnt = 0;
        for(int i = 0; i < stones.length; i++){
            if(!check[i]) cnt ++;
            else cnt = 0;
            
            if(cnt == k) return false;
        }
        return true;
    }
}