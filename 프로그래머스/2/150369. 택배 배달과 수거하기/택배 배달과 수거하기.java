import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long result = 0;
        
        int dStart = -1;
        int pStart = -1;
        int dIdx = n - 1;
        int pIdx = n - 1;
        int dSum = 0;
        int pSum = 0;
        
        while(true){
            while(dSum < cap){
                if(dSum == 0 && deliveries[dIdx] == 0){
                    if(dIdx == 0) break;
                    dIdx --;
                    continue;
                }
                
                if(dStart == -1){
                    dStart = dIdx;
                }
                
                if(dSum + deliveries[dIdx] < cap){
                    dSum += deliveries[dIdx];
                    deliveries[dIdx] = 0;
                    
                    if(dIdx == 0) break;
                    dIdx --;
                }else if (dSum + deliveries[dIdx] == cap){
                    dSum = cap;
                    deliveries[dIdx] = 0;
                    break;
                }else{
                    deliveries[dIdx] -= (cap - dSum); 
                    dSum = cap;
                    break;
                }
            }
            
            while(pSum < cap){
                if(pSum == 0 && pickups[pIdx] == 0){
                    if(pIdx == 0) break;
                    pIdx --;
                    continue;
                }
                
                if(pStart == -1){
                    pStart = pIdx;
                }
                
                if(pSum + pickups[pIdx] < cap){
                    pSum += pickups[pIdx];
                    pickups[pIdx] = 0;
                    
                    if(pIdx == 0) break;
                    pIdx --;
                }else if (pSum + pickups[pIdx] == cap){
                    pSum = cap;
                    pickups[pIdx] = 0;
                    break;
                }else{
                    pickups[pIdx] -= (cap - pSum); 
                    pSum = cap;
                    break;
                }
            }
    
            // System.out.println("dStart : " + dStart + ", pStart : " +  pStart);
            // System.out.println("dIdx : " + dIdx + ", pIdx : " +  pIdx);
            // System.out.println(Arrays.toString(deliveries));
            // System.out.println(Arrays.toString(pickups));
            
            int start = Math.max(dStart, pStart);
            result += ((start + 1) * 2);
            
            // System.out.println("result : " + result);
            
            if(dIdx == 0 && pIdx == 0 && deliveries[0] == 0 && pickups[0] == 0) break;
            dStart = pStart = -1;
            dSum = pSum = 0;
            dIdx = pIdx = Math.max(dIdx, pIdx);
            // System.out.println("new Start : " + dIdx + " " + pIdx);
        }
        
        long answer = result;
        return answer;
    }
}