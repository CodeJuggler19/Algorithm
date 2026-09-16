import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int coverage = 2 * w + 1;
        int start = 1;  

        for (int i = 0; i < stations.length; i++) {
            int left = stations[i] - w; 

            if (left > start) {
                int gap = left - start;
                if(gap <= coverage){
                    answer ++;
                }else{
                    answer += gap/coverage;
                    if(gap % coverage > 0) answer ++;
                }
                
                // answer += (gap + coverage - 1) / coverage;  
            }

            // 이 기지국의 커버리지가 start보다 더 뒤까지 미치면 start 갱신
            start = Math.max(start, stations[i] + w + 1);
        }

        if (start <= n) {
            int gap = n - start + 1;
            answer += (gap + coverage - 1) / coverage;
        }

        return answer;
    }
}