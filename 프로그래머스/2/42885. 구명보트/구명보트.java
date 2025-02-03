import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        Arrays.sort(people);
        int l = 0;
        int r = people.length - 1;
        
        int cnt = 0;
        
        while(l <= r){
            int sum = people[r];
            r--;
            if(sum + people[l] <= limit){
                sum += people[l];
                l++;
            }
            cnt++;
        }
        
        
        int answer = cnt;
        return answer;
    }
}