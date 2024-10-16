class Solution {
    public int[] solution(int brown, int yellow) {
        int result_y = 0;
        int result_b = 0;
        
        int x = yellow;
        int y = 1;
        while(x >= y){
            if(yellow % x == 0){
                y = yellow / x; 
                if((x+2)*2 + 2*y == brown){
                    break;
                } 
            }
            x--;
        }
        
        int[] answer = {x+2, y+2};
        return answer;
    }
}