import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long result = 0;

        long[] A = new long[N + 1];
        long[] cnt = new long[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            A[i] = (A[i - 1] + Integer.parseInt(st.nextToken())) % M;
            if (A[i] == 0) {
                result++;
            }
            cnt[(int) A[i]]++;
        }

        for (int i = 0; i < M; i++) {
            if (cnt[i] > 1) {
                result += (cnt[i] * (cnt[i] - 1)) / 2;
            }
        }
        System.out.println(result);
        br.close();
    }
}
