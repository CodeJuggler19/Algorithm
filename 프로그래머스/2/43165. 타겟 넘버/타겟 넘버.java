class Solution {
    int result = 0;
    int[] d ={1, -1};
    int[] numbers_1;
    int target_1;
    int len;
    public int solution(int[] numbers, int target) {
        numbers_1 = numbers;
        target_1 = target;
        len = numbers.length;
        
        dfs(0, 0);
        
        return result;
    }
    public void dfs(int cnt, int num){
        if(cnt == len){
            if(num == target_1){
                result++;
            }
            return;
        }
        for(int i=0; i < 2; i++){
            dfs(cnt + 1, num + d[i] * numbers_1[cnt]);
        }
    }
    
    
}