import java.util.*;

class Solution {
    static int[] b;
    static int result = Integer.MIN_VALUE;
    
    public int solution(int[] a) {
        
        b = new int[a.length + 1];
        for(int i = 0; i < a.length; i ++){
           b[a[i]]++; 
        }
        // System.out.println("b");
        // System.out.println(Arrays.toString(b));
        
        for(int i = 0; i < b.length; i++){
            if(result >= b[i]) continue;
            if(b[i] == 0) continue;
            find(a, i, b[i]);
        }
        // System.out.println(result);
        int answer = result * 2;
        return answer;
    }
    static void find(int[] a, int targetNum, int max){
        int cnt = 0;
        System.out.println("target : " +  targetNum + ", max :  " + max);
        for(int i = 0; i < a.length; i++){
            if(a[i] == targetNum){
                if(cnt > -1){
                    cnt--;  
                }else{
                    max --;    
                }
            }else{
                if(cnt < 1) cnt ++;
            }
        }
        
        if(cnt != 1){
            max += cnt;    
        }
    
        if( max != 0){
            result = Math.max(result, max);
        }
    }
}