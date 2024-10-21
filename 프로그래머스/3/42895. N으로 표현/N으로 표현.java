import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> list = new ArrayList<>();
        if(N == number){
            return 1;
        }
        
        for(int i = 0; i < 8; i++){
            list.add(new HashSet<Integer>());
        }
        list.get(0).add(N);
        
        for(int i = 0; i < 8; i++){
            int temp = 0;
            for(int j = 0; j <= i; j++){
                temp = temp * 10 + N;
            }
            list.get(i).add(temp);
        }
        for(int i = 1; i < 8; i++){
            for(int j = 0; j < i; j++){
                for(int a : list.get(j)){
                    for(int b : list.get(i-j-1)){
                        
                        list.get(i).add(a+b);
                        
                        list.get(i).add(a-b);
                        
                        list.get(i).add(a*b);
                        
                        if(b != 0){
                            list.get(i).add(a/b);
                        }
                    }
                }
            }
            if(list.get(i).contains(number)){
                return i+1;
            }
            
        }
        return -1;
    }
}