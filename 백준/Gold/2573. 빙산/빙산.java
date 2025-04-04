import java.io.*;
import java.util.*;
 
class IceBerg {
    int x;
    int y;
 
    IceBerg(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
 
public class Main {
    static int[] rangeX = { -1, 0, 1, 0 };
    static int[] rangeY = { 0, 1, 0, -1 };
 
    static int N, M;
    static int[][] map;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
 
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
 
        int ans = 0;
        int cnt = 0;
 
        while ((cnt = SeparateNum()) < 2) {
            if (cnt == 0) {
                ans = 0;
                break;
            }
 
            Melt();
            ans++;
        }
 
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
 

    public static int SeparateNum() {
        boolean[][] visited = new boolean[N][M];
 
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    DFS(i, j, visited); 
                    cnt++;
                }
            }
        }
        return cnt;
    }
 
    public static void DFS(int x, int y, boolean[][] visited) {
        visited[x][y] = true;
 
        int dx, dy;
        for (int i = 0; i < 4; i++) {
            dx = x + rangeX[i];
            dy = y + rangeY[i];
 
            if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
                continue;
            }
 
            if (map[dx][dy] != 0 && !visited[dx][dy]) {
                DFS(dx, dy, visited);
            }
        }
    }
 
    public static void Melt() {
        Queue<IceBerg> q = new LinkedList<>();
 
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    q.offer(new IceBerg(i, j));
                    visited[i][j] = true;
                }
            }
        }
 
        int dx, dy;
        while (!q.isEmpty()) {
            IceBerg ice = q.poll();
 
            int seaNum = 0; // 빙하 상하좌우에 존재하는 바다 영역의 수.
 
            for (int i = 0; i < 4; i++) {
                dx = ice.x + rangeX[i];
                dy = ice.y + rangeY[i];
 
                if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
                    continue;
                }
 
                if (!visited[dx][dy] && map[dx][dy] == 0) {
                    seaNum++;
                }
            }
 
            if (map[ice.x][ice.y] - seaNum < 0) {
                map[ice.x][ice.y] = 0;
            } else {
                map[ice.x][ice.y] -= seaNum;
            }
        }
    }
}