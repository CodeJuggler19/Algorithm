import java.util.*;

class Solution {
    HashSet<Integer> set = new HashSet<>();
    boolean[] visited;
    char[] arr;
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        arr = new char[numbers.length()];
        
        for(int i=0; i < numbers.length(); i++){
            arr[i] = numbers.charAt(i);
        }
        dfs("", 0);
        int answer = set.size();
        return answer;
    }
    
    void dfs(String str, int len){
        if(!str.equals("")){
            int num = Integer.parseInt(str);
            if(isPrime(num)) set.add(num);
        }
        
        if(len == arr.length) return;
        
        for(int i=0; i<arr.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(str+arr[i], len + 1);
            visited[i] = false;
        }
        
    }
    boolean isPrime(int num){
        if(num < 2) return false;
        
        for(int i=2; i*i<=num; i++){
            if(num%i == 0) return false;
        }
        return true;
    }
    
}