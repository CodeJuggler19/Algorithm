class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int row = triangle.length;
        
        
        for (int i=1; i<row; i++){
            for(int j=0; j < triangle[i].length; j++){
                if(i==1){
                    triangle[i][j] = triangle[i-1][0] + triangle[i][j]; 
                    continue;
                }
                if(j == 0){
                    triangle[i][j] = triangle[i-1][0] + triangle[i][j]; 
                }else if (j == i){
                    triangle[i][j] = triangle[i-1][j-1] + triangle[i][j]; 
                }else {
                    triangle[i][j] = Math.max(triangle[i][j] + triangle[i-1][j], triangle[i][j] + triangle[i-1][j-1]);
                }
                
            }
        }
        
        int max = 0;
        
        for (int i =0; i<triangle[row-1].length; i++){
            max = Math.max(max, triangle[row-1][i]);
        }
        
        answer= max;
        return answer;
    }
}