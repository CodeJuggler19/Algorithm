import java.util.*;

class Solution {
    static int[] parent;
    public int solution(int n, int[][] computers) {
        parent = new int[n];
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j){
                    if(computers[i][j] == 1){
                        if(find(i) != find(j)){
                            union(i, j);
                        }
                    }
                }
            }
        }
        
        boolean[] check = new boolean[n];
        for(int i = 0; i < n; i++){
            check[find(i)] = true;
        }
        int answer = 0;
        
        for(int i = 0; i < n; i++){
            if(check[i]){
                answer++;  
            } 
        }
        
        return answer;
    }
    
    public int find(int x){
        if(x == parent[x]) return x;
        
        return parent[x] = find(parent[x]);
    }
    public void union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x != y){
            parent[y] = x;
        }
    }
}