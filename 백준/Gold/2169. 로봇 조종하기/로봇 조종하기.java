import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] vis;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (i == 0 && j > 0) {
                    map[i][j] += map[i][j - 1];
                }
            }
        }
        for (int i = 1; i < N; i++) {
            int[] A = new int[M];
            int[] B = new int[M];
            for (int j = 0; j < M; j++) {
                if (j == 0) {
                    A[j] = map[i - 1][j] + map[i][j];
                } else {
                    A[j] = Math.max(A[j - 1], map[i - 1][j]) + map[i][j];
                }
            }

            for (int j = M - 1; j >= 0; j--) {
                if (j == M - 1) {
                    B[j] = map[i - 1][j] + map[i][j];
                } else {
                    B[j] = Math.max(B[j + 1], map[i - 1][j]) + map[i][j];
                }
            }
            for(int j = 0; j < M; j++){
                map[i][j] = Math.max(A[j], B[j]);
            }
        }
        System.out.println(map[N -1][M - 1]);
        br.close();
    }


}
