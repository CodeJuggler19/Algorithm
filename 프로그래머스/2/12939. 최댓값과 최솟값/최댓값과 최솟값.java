import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        
        String[] sArray = s.split(" ");
        int[] nArray = new int[sArray.length];
        
        for(int i=0; i<sArray.length; i++){
            nArray[i] = Integer.parseInt(sArray[i]);
        }
        Arrays.sort(nArray);
        
        String answer = nArray[0] + " "+ nArray[nArray.length-1];
        return answer;
    }
}