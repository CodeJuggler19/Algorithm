import java.io.*;
import java.util.*;

public class Main {
    static int N, M, x, y, K;
    static int[][] map;
    static int[] dice = new int[7];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < K; i++){
            int cur = Integer.parseInt(st.nextToken());
            int nx = x + dx[cur];
            int ny = y + dy[cur];
            if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                x = nx;
                y = ny;
                roll(cur, x, y);
            }
        }
        System.out.println(sb);
        br.close();
    }
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static StringBuilder sb = new StringBuilder();
    static void roll(int direction, int x, int y){
        if(direction == 1){
            int num1 = dice[1];
            int num3 = dice[3];
            int num4 = dice[4];
            int num6 = dice[6];
            dice[1] = num4;
            dice[3] = num1;
            dice[4] = num6;
            dice[6] = num3;
        }else if(direction == 2){
            int num1 = dice[1];
            int num3 = dice[3];
            int num4 = dice[4];
            int num6 = dice[6];
            dice[1] = num3;
            dice[3] = num6;
            dice[4] = num1;
            dice[6] = num4;
        }else if(direction == 3){
            int num1 = dice[1];
            int num2 = dice[2];
            int num5 = dice[5];
            int num6 = dice[6];
            dice[1] = num5;
            dice[2] = num1;
            dice[5] = num6;
            dice[6] = num2;
        }else{ // memo direction == 4
            int num1 = dice[1];
            int num2 = dice[2];
            int num5 = dice[5];
            int num6 = dice[6];
            dice[1] = num2;
            dice[2] = num6;
            dice[5] = num1;
            dice[6] = num5;
        }
        under(x, y);
    }
    static void under(int x, int y){
        sb.append(dice[1]).append("\n");
        if(map[x][y] == 0){
            map[x][y] = dice[6];
        }else{
            dice[6] = map[x][y];
            map[x][y] = 0;
        }
    }
}
