import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < number.length(); i++){
            int num = number.charAt(i) - '0';
            
            
            while(!stack.isEmpty() && stack.peek() < num && k-- > 0){
                stack.pop();
            }
            
            stack.push(num);
            
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            if(k-- > 0){
                stack.pop();
                continue;
            } 
            sb.append(stack.pop());
            
        }
        
        return sb.reverse().toString();
    }
}