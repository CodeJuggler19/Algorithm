import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int[][] map = new int[board.length + 2][board[0].length + 2];
        int answer = 0;
        for(int[] s : skill){
            // System.out.println(Arrays.toString(s));
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int cost = s[5];
            if(type == 1) cost *= -1;
            
            map[r1 + 1][c1 + 1] += cost;
            map[r1 + 1][c2 + 2] -= cost; 
            map[r2 + 2][c1 + 1] -= cost;
            map[r2 + 2][c2 + 2] += cost;
        }
        for(int i = 1; i < board.length + 2; i++){
            for(int j = 1; j < board[0].length + 2; j++){
                map[i][j] += map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1];
            }
        }
        
        for(int i = 1; i < board.length + 1; i++){
            for(int j = 1; j < board[0].length + 1; j++){
                board[i - 1][j - 1] += map[i][j];
                
                if(board[i - 1][j - 1] > 0) answer ++; 
            }
        }
        
        return answer;
    }
}