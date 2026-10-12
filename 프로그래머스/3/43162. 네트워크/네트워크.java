import java.util.*;

class Solution {
    static boolean[] visited;
    static int[][] link;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        link = new int[computers.length][computers.length];
        link = computers;
        
        visited = new boolean[computers.length];        
        
        for(int i = 0; i < computers.length; i++){
            if(!visited[i]){
                bfs(i);
                answer++;
            }
        }

        return answer;
    }
    
    void bfs(int idx){
        System.out.println(idx);
        Queue<Integer> q = new LinkedList<>();
        
        q.add(idx);
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            if(!visited[cur]){
                visited[cur] = true;
                
                for(int i = 0; i < link[cur].length; i++){
                    if(i == cur) continue;
                    
                    if(!visited[i] && link[cur][i] == 1){
                        q.add(i);
                    }
                }
            }
            
        }
        
    }
}