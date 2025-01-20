import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        Arrays.sort(times);
        long start = times[0];
        long end = 1_000_000_000L * 100_000L;
        long mid = 0;
        
        long answer = 0;
        while(start <= end){
            mid = (start + end) / 2;
            long sum = 0;
            
            for(int i = 0; i < times.length; i++){
                sum += (mid / times[i]);
            }
            
            if(sum < n){
                start = mid + 1;
            }else{
                answer = mid;
                end = mid - 1;
            }
        }
        return answer;
    }
}