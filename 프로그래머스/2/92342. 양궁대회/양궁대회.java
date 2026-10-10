import java.util.*;

class Solution {
    static int N;
    static int max = Integer.MIN_VALUE;
    static int[] answer = new int[11];
    static int[] apeach = new int[11];
    public int[] solution(int n, int[] info) {
        N = n;
        
        for(int i = 0; i <= 10; i++){
            apeach[i] = info[i];
        }
        
        bt(1, 0);

        if(max == Integer.MIN_VALUE) return new int[]{-1};
        return answer;
    }
    
    void bt(int idx, int mask){
        if(idx == 11){
            check(mask);
            return;
        }
        
        bt(idx + 1, mask); // 진경우 
        bt(idx + 1, mask | 1 << (10 - idx)); // 이긴 경우
        
    }
    
    void check(int mask){
        int need = 0;
        int a_score = 0;
        int l_score = 0;
        int[] result = new int[11];
        
        for(int i = 0; i < 10; i++){
            if((mask & (1 << i)) != 0){
                need += (apeach[9 - i] + 1);
                l_score += (i + 1);
                result[9 - i] = (apeach[9 - i] + 1);
            }else{
                if(apeach[9 - i] != 0) a_score += (i + 1);
            }
        }
        
        int diff = l_score - a_score;
        if(need > N || diff <= 0 || max > diff) return;
        
        
        result[10] = N - need;
        
        if(max < diff){
            max = diff;
            answer = result;
            return;
        }
        
        for(int i = 10; i >= 0; i--){
            if(result[i] == answer[i]) continue;
            if(result[i] > answer[i]) answer = result;
            
            return;
        }
        
    }
}