import java.io.*;
import java.util.*;

public class Main {
    static int N, M;

    static int[][] map;
    static boolean[][][] vis;

    static class Node {
        int x, y, depth, check;


        private Node(int x, int y, int depth, int check) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.check = check;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        vis = new boolean[N + 1][M + 1][2];

        for (int i = 1; i <= N; i++) {
            char[] inputs = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j + 1] = Integer.parseInt(String.valueOf(inputs[j]));
            }
        }

        Queue<Node> q = new LinkedList<>();

        q.add(new Node(1, 1, 1, 0));
        vis[0][0][0] = true;
        int cnt = 0;
        int result = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == N && cur.y == M) {
                result = Math.min(result, cur.depth);
                cnt++;
                if (cnt == 2) {
                    break;
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx > 0 && nx <= N && ny > 0 && ny <= M) {
                    if (map[nx][ny] == 0) {
                        if (!vis[nx][ny][cur.check]) {
                            vis[nx][ny][cur.check] = true;
                            q.add(new Node(nx, ny, cur.depth + 1, cur.check));
                        }
                    } else {
                        if (cur.check == 0) {
                            if (!vis[nx][ny][1]) {
                                vis[nx][ny][1] = true;
                                q.add(new Node(nx, ny, cur.depth + 1, 1));
                            }
                        }
                    }
                }
            }

        }
        if (result == Integer.MAX_VALUE) result = -1;
        System.out.println(result);

        br.close();
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
}