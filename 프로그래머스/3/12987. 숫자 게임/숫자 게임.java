import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int idx = A.length - 1;
        
        for(int i = B.length - 1; i >= 0; i--){
            while(idx >= 0 && B[i] <= A[idx]){
                idx--;
            }
            
            if(idx < 0) break;
            
            answer ++;
            idx --;
            
        }
        
        return answer;
    }
}