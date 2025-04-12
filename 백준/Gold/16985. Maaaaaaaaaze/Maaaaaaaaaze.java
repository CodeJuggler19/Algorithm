import java.io.*;
import java.util.*;

public class Main {
    static int result = Integer.MAX_VALUE;
    static int[][][] map = new int[6][6][6];
    static int[] seq = new int[6];
    static boolean[] vis = new boolean[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
//        StringTokenizer st;
        for (int cnt = 1; cnt <= 5; cnt++) {
            for (int i = 1; i <= 5; i++) {
//                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= 5; j++) {
                    map[cnt][i][j] = sc.nextInt();
//                    map[cnt][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }
        combination(1);

        if(result == Integer.MAX_VALUE) result = -1;

        System.out.println(result);
        br.close();
    }


    static void combination(int idx) {
        if (idx > 5) {
            rotation(1);
            return;
        }

        for (int i = 1; i <= 5; i++) {
            if (!vis[i]) {
                seq[idx] = i;
                vis[i] = true;
                combination(idx + 1);
                seq[idx] = 0;
                vis[i] = false;
            }
        }
    }

    static int[] rotation = new int[6];

    static void rotation(int start) {
        if (start > 5) {
            cal();
            return;
        }

        for (int r = 1; r <= 4; r++) {
            rotation[start] = r;
            rotation(start + 1);
        }

    }

    static void cal() {
        int[][][] tempMap = new int[6][6][6];

        // 회전 맵 할당
        for (int cnt = 1; cnt <= 5; cnt++) {
            int[][] page = new int[6][6];

            for (int i = 1; i <= 5; i++) {
                for (int j = 1; j <= 5; j++) {
                    page[i][j] = map[seq[cnt]][i][j];
                }
            }

            int[][] rotated = new int[6][6];
            for (int i = 2; i <= rotation[cnt]; i++) {
                for (int a = 1; a <= 5; a++) {
                    for (int b = 1; b <= 5; b++) {
                        rotated[b][6 - a] = page[a][b];
                    }
                }

                for (int a = 1; a <= 5; a++) {
                    for (int b = 1; b <= 5; b++) {
                        page[a][b] = rotated[a][b];
                    }
                }
            }


            for(int i = 1; i <= 5; i ++){
                for(int j = 1; j <= 5; j ++){
//                    if((cnt == 1 && i == 1 && j == 1) || (cnt == 5 && i == 5 && j == 5)){
//                        if(page[i][j] == 0){
//                            return;
//                        }
//                    }
                    tempMap[cnt][i][j] = page[i][j];
                }
            }
        }
        bfs(tempMap);

    }

    static int[] dx = {0, -1, 0, 1, 0, 0};
    static int[] dy = {0, 0, 1, 0, -1, 0};
    static int[] dz = {-1 , 0, 0, 0, 0, 1};

    static class Node{
        int x, y, z;
        int depth;

        private Node(int x, int y, int z, int depth){
            this.x = x;
            this.y = y;
            this.z = z;
            this.depth = depth;
        }
    }
    static void bfs(int[][][] tempMap){
        if(tempMap[1][1][1] == 0 || tempMap[5][5][5] == 0) return;

        boolean[][][] vis = new boolean[6][6][6];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 1, 1, 0));
        vis[1][1][1] = true;
        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.x == 5 && cur.y == 5 && cur.z == 5){

                result = Math.min(result, cur.depth);
                break;
            }
            for(int i = 0; i < 6; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nz = cur.z + dz[i];

                if(nx >= 1 && nx <= 5 && ny >= 1 && ny <= 5 && nz >= 1 && nz <= 5
                    && !vis[nz][nx][ny] && tempMap[nz][nx][ny] == 1){
                    vis[nz][nx][ny] = true;
                    q.add(new Node(nx, ny, nz, cur.depth + 1));
                }
            }
        }
    }
}
