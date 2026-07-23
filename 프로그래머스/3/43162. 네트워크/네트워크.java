import java.util.*;

class Solution {
    public int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    public void union(int x, int y){
        int x1 = find(x);
        int y1 = find(y);
        
        if(x1 != y1){
            parent[y1] = x1;
        }
        
    }
    static int[] parent;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        parent = new int[n + 1];
        
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
        
        for(int i = 0; i < computers.length; i++){
            for(int j = 0; j < computers[i].length; j++){
                if(i == j) continue;
                
                if(computers[i][j] == 1){
                    int x = i + 1;
                    int y = j + 1;
                    if(find(x) != find(y)){
                        union(x, y);    
                    }
                    
                }
                
            }
        }
        
        boolean[] check = new boolean[n + 1];
        for(int i = 1; i <= n; i++){
            check[find(i)] = true;
        }
        
        for(int i = 1; i <= n; i++){
            if(check[i]){
                answer++;  
            } 
        }
        
        return answer;
    }
}