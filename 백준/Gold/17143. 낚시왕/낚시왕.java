import java.io.*;
import java.util.*;

public class Main {
    static int R, C, M;

    static class Shark {
        int r, c, s, d, z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, 1, -1};
    static Shark[][] map;
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

        for (int i = 1; i <= C; i++) {
            int min = Integer.MAX_VALUE;
            Shark target = null;
            for (Shark shark : sharks) {
                if (shark.c == i && shark.r < min) {
                    min = shark.r;
                    target = shark;
                }
            }

            if (target != null) {
                result += target.z;
                sharks.remove(target);
            }

            map = new Shark[R + 1][C + 1];

            for (Shark shark : sharks) {
                int r = shark.r;
                int c = shark.c;
                int d = shark.d;
                int s = shark.s;

                int len = (d <= 2) ? (R - 1) * 2 : (C - 1) * 2;
                int move = s % len;

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

                Shark moved = new Shark(r, c, shark.s, d, shark.z);
                if (map[r][c] == null || map[r][c].z < moved.z) {
                    map[r][c] = moved;
                }
            }
            sharks.clear();

            for (int j = 1; j <= R; j++) {
                for (int k = 1; k <= C; k++) {
                    if (map[j][k] != null) {
                        sharks.add(map[j][k]);
                    }
                }
            }

        }
        System.out.println(result);
        br.close();
    }
}
