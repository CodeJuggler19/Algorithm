import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] map;
    static boolean[][] vis;

    static int day = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            vis = new boolean[N][N];

            int[][] before = copy();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!vis[i][j]) {
                        bfs(i, j);
                    }
                }
            }

//            System.out.println("before");
//            System.out.println(Arrays.deepToString(before));
//            System.out.println("map");
//            System.out.println(Arrays.deepToString(map));
            if(check(before)){
                if(day == 2000){
                    break;
                }
                day ++;

            }else{
                break;
            }

        }
        System.out.println(day);
        br.close();
    }
    static int[][] copy(){
        int[][] copy = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                copy[i][j] = map[i][j];
            }
            //System.arraycopy(map[i], 0, copy[i], 0, N);
        }
        return copy;
    }
    static boolean check(int[][] before){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] != before[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
    static class Node {
        int x, y;

        private Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void bfs(int x, int y) {
        int sum = 0;
        int cnt = 0;
        boolean[][] curVis = new boolean[N][N];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (!vis[cur.x][cur.y]) {
                vis[cur.x][cur.y] = true;
                curVis[cur.x][cur.y] = true;
                sum += map[cur.x][cur.y];
                cnt++;
                for(int i = 0; i < 4; i++){
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if(nx >= 0 && nx < N && ny >= 0 && ny < N && !vis[nx][ny]
                        && Math.abs(map[cur.x][cur.y] - map[nx][ny]) >= L
                        && Math.abs(map[cur.x][cur.y] - map[nx][ny]) <= R){
                        q.add(new Node(nx, ny));
                    }
                }
            }
        }
        if(cnt == 1){
            vis[x][y] = false;
        }else{
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(curVis[i][j]){
                        map[i][j] = (sum / cnt);
                    }
                }
            }
        }
    }

}
