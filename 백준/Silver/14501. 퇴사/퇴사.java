import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] dp = new int[N + 1];
        StringTokenizer st;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= N; i++){
            if(i + T[i] <= N + 1){
                dp[i] = P[i];
            }
            int max = 0;
            for(int j = i - 1; j >= 1; j--){
                if(j + T[j] <= i){
                    max = Math.max(max, dp[i] + dp[j]);
                }
            }
            if(max != 0) dp[i] = max;

        }
        int result = 0;
        for(int i = 1; i <=N; i++){
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
        br.close();
    }

}
