import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        boolean[] visited = new boolean[routes.length];
        
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        
        System.out.println(Arrays.deepToString(routes));
        int answer = 0;
        
        for(int i = 0; i < routes.length; i++){
            if(!visited[i]){
                int camera = routes[i][1];
                answer ++;
                visited[i] = true;
                for(int j = i + 1; j < routes.length; j++){
                    if(routes[j][0] <= camera){
                        visited[j] = true;
                    }
                }
            }
        }
        
        return answer;
    }
}