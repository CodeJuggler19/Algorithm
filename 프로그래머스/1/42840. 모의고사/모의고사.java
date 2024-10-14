import java.util.ArrayList;
class Solution {
    int[][] students = new int[3][10]; 
    public ArrayList solution(int[] answers) {
        int[] student_1 = {1,2,3,4,5};
        int[] student_2 = {2,1,2,3,2,4,2,5};
        int[] student_3 = {3,3,1,1,2,2,4,4,5,5};
        
        int cnt_1 = 0;
        int cnt_2 = 0;
        int cnt_3 = 0;
        
        int[] result = new int[3];
        for(int i=0; i < answers.length; i++){
            int ans = answers[i];
            if(cnt_1 == 5) cnt_1 = 0;
            if(student_1[cnt_1] == ans){
                result[0]++;
            }
            if(cnt_2 == 8) cnt_2 = 0;
            if(student_2[cnt_2] == ans){
                result[1]++;
            }
            if(cnt_3 == 10) cnt_3 = 0;
            if(student_3[cnt_3] == ans){
                result[2]++;
            }
            cnt_1++;
            cnt_2++;
            cnt_3++;
        }
        
        int max = Math.max(result[0], Math.max(result[1], result[2]));
        
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0; i<3; i++){
            if(max == result[i]){
                temp.add(i+1);
            }
        }
        
        return temp;
    }
}