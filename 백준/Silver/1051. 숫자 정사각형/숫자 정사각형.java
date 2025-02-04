import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;

    static int result = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] inputs = br.readLine().toCharArray();
            for (int j = 0; j < inputs.length; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(inputs[j]));
            }
        }

        for(int size = 1; size < Math.min(N, M); size++){
            for(int i = 0; i + size < N; i++){
                for(int j = 0; j + size < M; j++){
                    if (map[i][j] == map[i][j + size] && map[i][j] == map[i + size][j] && map[i][j] == map[i + size][j + size]){
                        result = Math.max(result, size + 1);
                    }
                }
            }
        }

        System.out.println(result * result);
        br.close();
    }


}
