import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] dp = new int[3][2];

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 3; i++){
            dp[i][0] = Integer.parseInt(st.nextToken());
            dp[i][1] = dp[i][0];
        }
        int[][] temp = new int[3][2];
        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int num;
            for(int j = 0; j < 3; j++){
                num = Integer.parseInt(st.nextToken());
                if(j == 0){
                    temp[j][0] = num + Math.min(Math.min(dp[j][0], dp[j][1]),Math.min(dp[j + 1][0], dp[j + 1][1]));
                    temp[j][1] = num + Math.max(Math.max(dp[j][0], dp[j][1]),Math.max(dp[j + 1][0], dp[j + 1][1]));
                }else if(j == 1){
                    temp[j][0] = num + Math.min(Math.min(dp[j - 1][0], dp[j - 1][1]), Math.min(Math.min(dp[j][0], dp[j][1]),Math.min(dp[j + 1][0], dp[j + 1][1])));
                    temp[j][1] = num + Math.max(Math.max(dp[j - 1][0], dp[j - 1][1]), Math.max(Math.max(dp[j][0], dp[j][1]),Math.max(dp[j + 1][0], dp[j + 1][1])));
                }else{
                    temp[j][0] = num + Math.min(Math.min(dp[j][0], dp[j][1]),Math.min(dp[j - 1][0], dp[j - 1][1]));
                    temp[j][1] = num + Math.max(Math.max(dp[j][0], dp[j][1]),Math.max(dp[j - 1][0], dp[j - 1][1]));
                }
            }
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 2; k ++){
                    dp[j][k] = temp[j][k];
                }
            }
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < 3; j++){
            for(int k = 0; k < 2; k ++){
                max = Math.max(max, dp[j][k]);
                min = Math.min(min, dp[j][k]);
            }
        }
        System.out.println(max + " " + min);
        br.close();
    }
}
