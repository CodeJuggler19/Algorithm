import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();

        int[][] dp = new int[A.length + 1][B.length + 1];


        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
 
        Stack<Character> st = new Stack<>();
        int i = A.length;
        int j = B.length;
        while(i > 0 && j > 0){
            if(dp[i][j] == dp[i - 1][j]){
                i--;
            }else if(dp[i][j] == dp[i][j - 1]){
                j--;
            }else{
                st.push(A[i - 1]);
                i--;
                j--;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        System.out.println(dp[A.length][B.length]);
        System.out.println(sb);

        br.close();
    }
}
