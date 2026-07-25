import java.util.*;

class Solution {
    static final int MAX = 100000000;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        int[][] map = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++){
            Arrays.fill(map[i], MAX);
            map[i][i] = 0;
        }
        
        for(int i = 0; i < fares.length; i++){
            int n1 = fares[i][0];
            int n2 = fares[i][1];
            int cost = fares[i][2];
            
            map[n1][n2] = map[n2][n1] = cost;
        }
        
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
        
        answer = MAX;
        for(int i = 1; i <= n; i++){
            answer = Math.min(answer, map[s][i] + map[i][a] + map[i][b]);
        }
        
        return answer;
    }
}