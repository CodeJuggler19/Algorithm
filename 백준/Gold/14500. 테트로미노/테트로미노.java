import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;

    static boolean[][] vis;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        vis = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                vis[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                vis[i][j] = false;
                check(i,j);
            }
        }
        System.out.println(result);
    }
    static void check(int x, int y){

        if(x - 1 >= 0 && y - 1 >= 0 && x + 1 < N){
            result = Math.max(result, map[x][y] + map[x - 1][y] + map[x][y - 1] + map[x + 1][y]);
        }

        if(x - 1 >= 0 && y - 1 >= 0 && y + 1 < M){
            result = Math.max(result, map[x][y] + map[x - 1][y] + map[x][y - 1] + map[x][y + 1]);
        }

        if(x - 1 >= 0 && y + 1 < M && x + 1 < N){
            result = Math.max(result, map[x][y] + map[x - 1][y] + map[x][y + 1] + map[x + 1][y]);
        }

        if(x + 1 < N  && y - 1 >= 0 && y + 1 < M){
            result = Math.max(result, map[x][y] + map[x + 1][y] + map[x][y - 1] + map[x][y + 1]);
        }
    }
    static void dfs(int x, int y, int cnt, int sum) {
        if(cnt == 4){
            result = Math.max(result, sum);
            return;
        }
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < M && !vis[nx][ny]){
                vis[nx][ny] = true;
                dfs(nx, ny, cnt + 1, sum + map[nx][ny]);
                vis[nx][ny] = false;
            }
        }

    }
}
