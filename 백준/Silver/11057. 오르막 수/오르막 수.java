import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int MOD = 10007;

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[1001][10];

        for(int i = 0; i < 10; i++){
            dp[1][i] = 1;
        }


        for(int i = 2; i <= N; i++){
            int sum = 0;
            for(int j = 0; j < 10; j++){
                sum += dp[i - 1][j];
                dp[i][j] = sum % MOD;
            }
        }
        int result = 0;
        for(int i = 0; i < 10; i++){
            result += dp[N][i];
        }

        bw.write((result % MOD) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
