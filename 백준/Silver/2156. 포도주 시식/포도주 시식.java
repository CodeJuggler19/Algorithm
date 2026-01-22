import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] wine = new int[N + 1];
        int[][] dp = new int[N + 1][2];

        for(int i = 1; i <= N; i++){
            wine[i] = Integer.parseInt(br.readLine());
        }
        int max;
        if(N == 1){
            max = wine[1];
        }else if(N == 2){
            max = wine[1] + wine[2];
        }else{
            dp[1][0] = wine[1];
            dp[2][0] = wine[2];
            dp[2][1] = wine[1] + wine[2];
            for(int i = 3; i <= N; i++){
                dp[i][0] = Math.max(Math.max(dp[i - 2][0] , dp[i - 2][1]), dp[i -3][1]) + wine[i];
                dp[i][1] = dp[i - 1][0] + wine[i];
            }
            max =Math.max(Math.max(dp[N][0], dp[N][1]), Math.max(dp[N - 1][0], dp[N - 1][1]));
        }
        System.out.println(max);
        br.close();
    }
}
