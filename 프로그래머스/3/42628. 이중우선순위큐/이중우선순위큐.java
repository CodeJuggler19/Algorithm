import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        
        for(int i = 0; i < operations.length; i++){
            String operation = operations[i];
            String[] strArr = operation.split(" ");
            
            if(strArr[0].equals("I")){
                int num = Integer.parseInt(strArr[1]);
                
                tm.put(num, tm.getOrDefault(num, 0 ) + 1);
            }else{ // strArr[0].equals("D")
                if(tm.isEmpty()) continue;                
                if(strArr[1].equals("1")){
                    if(tm.get(tm.lastKey()) == 1){
                        tm.remove(tm.lastKey());    
                    }else{
                        tm.put(tm.lastKey(), tm.get(tm.lastKey()) - 1);
                    }
                }else{ // strArr[1].equals("-1")
                    if(tm.get(tm.firstKey()) == 1){
                        tm.remove(tm.firstKey());    
                    }else{
                        tm.put(tm.firstKey(), tm.get(tm.firstKey()) - 1);
                    }
                }
            }

        }
        if(tm.isEmpty()){
            answer[0] = answer[1] = 0; 
        }else{
            answer[0] = tm.lastKey(); 
            answer[1] = tm.firstKey();
        }
        return answer;
    }
}