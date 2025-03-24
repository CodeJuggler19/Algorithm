import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[][] sticker;
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sticker = new int[n][2];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    sticker[j][i] = Integer.parseInt(st.nextToken());
                }
            }
            if(n == 1){
                sb.append(Math.max(sticker[0][0], sticker[0][1])).append("\n");
                continue;
            }
            sticker[1][0] += sticker[0][1];
            sticker[1][1] += sticker[0][0];

            for (int i = 2; i < n; i++) {
                sticker[i][0] += Math.max(Math.max(sticker[i - 1][1], sticker[i - 2][0]), sticker[i - 2][1]);
                sticker[i][1] += Math.max(Math.max(sticker[i - 1][0], sticker[i - 2][1]), sticker[i - 2][0]);
            }

            sb.append(Math.max(sticker[n - 1][0], sticker[n - 1][1])).append("\n");

        }
        System.out.println(sb);
        br.close();
    }
}
