class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int [][]dp = new int[n][m];
        
        for (int[] i : puddles)
            dp[i[1] - 1][i[0] - 1] = -1;
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == 0) {
                    if (i != 0 && dp[i - 1][j] != -1)
                        dp[i][j] += dp[i - 1][j];
                    if (j != 0 && dp[i][j - 1] != -1)
                        dp[i][j] += dp[i][j - 1];
                    dp[i][j] %= 1000000007;
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}