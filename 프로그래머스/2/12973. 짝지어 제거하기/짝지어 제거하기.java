import java.io.*;
import java.util.*;

class Solution
{
    public int solution(String s){
        int answer = -1;
        Stack<Character> temp = new Stack<Character>();
        
        for(int i=0; i< s.length(); i++){
            if(temp.isEmpty()){
                temp.push(s.charAt(i));
            }else{
                if(temp.peek() == s.charAt(i)){
                    temp.pop();
                }else{
                    temp.push(s.charAt(i));
                }
            }
            
        }
        
        if(temp.isEmpty()){
            return 1;
        }else{
            return 0;
        }
    }
}