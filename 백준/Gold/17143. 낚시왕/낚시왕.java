import java.io.*;
import java.util.*;

public class Main {
    static int R, C, M;
    static Shark[][] map;
    static int[] dr = {0, -1, 1, 0, 0}; // 1~4: 상,하,우,좌
    static int[] dc = {0, 0, 0, 1, -1};

    static class Shark {
        int r, c, s, d, z;

        Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    static List<Shark> sharks = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            sharks.add(new Shark(r, c, s, d, z));
        }

        int result = 0;

        for (int fisher = 1; fisher <= C; fisher++) {
            int minR = Integer.MAX_VALUE;
            Shark target = null;
            for (Shark s : sharks) {
                if (s.c == fisher && s.r < minR) {
                    minR = s.r;
                    target = s;
                }
            }
            if (target != null) {
                result += target.z;
                sharks.remove(target);
            }

            map = new Shark[R + 1][C + 1];
            for (Shark s : sharks) {
                int r = s.r;
                int c = s.c;
                int d = s.d;
                int sSpeed = s.s;

                int len = (d <= 2) ? (R - 1) * 2 : (C - 1) * 2;
                int move = sSpeed % len;

                while (move-- > 0) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr < 1 || nr > R || nc < 1 || nc > C) {
                        if (d == 1) d = 2;
                        else if (d == 2) d = 1;
                        else if (d == 3) d = 4;
                        else d = 3;
                        nr = r + dr[d];
                        nc = c + dc[d];
                    }
                    r = nr;
                    c = nc;
                }

                Shark moved = new Shark(r, c, s.s, d, s.z);
                if (map[r][c] == null || map[r][c].z < moved.z) {
                    map[r][c] = moved;
                }
            }

            sharks.clear();
            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++) {
                    if (map[i][j] != null) {
                        sharks.add(map[i][j]);
                    }
                }
            }
        }

        System.out.println(result);
    }
}
