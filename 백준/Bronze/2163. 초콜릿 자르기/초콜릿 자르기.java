import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int max = Math.max(n, m);
        int[][] dp = new int[max + 1][max + 1];

        for (int i = 1; i <= max; i++) {
            dp[1][i] = i - 1;
        }
        System.out.println(
                Math.min(
                        dp[1][m] * n +(n-1),
                        dp[1][n] *m + (m-1)
                )
        );
    }
}
