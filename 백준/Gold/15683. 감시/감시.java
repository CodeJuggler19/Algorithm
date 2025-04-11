import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;

    static class CCTV {
        int x, y, t, d; // 1 : 위 , 2: 오른쪽, 3: 아래, 4: 왼쪽

        public CCTV(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }

        public CCTV(int x, int y, int t, int d) {
            this.x = x;
            this.y = y;
            this.t = t;
            this.d = d;
        }
    }

    static List<CCTV> position = new ArrayList<>();
    static List<CCTV> list = new ArrayList<>();

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
                if (map[i][j] > 0 && map[i][j] < 6) {
                    position.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        combination(0);
        System.out.println(min);
        br.close();

    }

    static void combination(int start) {
        if (list.size() == position.size()) {
//            for(int i = 0; i< list.size(); i++){
//                CCTV c = list.get(i);
//                System.out.println(c.x + " " + c.y + " " + c.t + " " + c.d);
//            }
            cal();
            return;
        }

        for (int i = start; i < position.size(); i++) {
            CCTV cur = position.get(i);

            if (cur.t == 2) {
                for (int j = 1; j <= 2; j++) {
                    list.add(new CCTV(cur.x, cur.y, cur.t, j));
                    combination(i + 1);
                    list.remove(list.size() - 1);
                }
            } else if (cur.t == 5) {
                list.add(new CCTV(cur.x, cur.y, cur.t, 1));
                combination(i + 1);
                list.remove(list.size() - 1);
            } else {
                for (int j = 1; j <= 4; j++) {
                    list.add(new CCTV(cur.x, cur.y, cur.t, j));
                    combination(i + 1);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    static int min = Integer.MAX_VALUE;

    static int[] dx = {0, -1, 0, 1, 0};
    static int[] dy = {0, 0, 1, 0, -1};
    static void cal() {
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < list.size(); i++) {
            CCTV c = list.get(i);
            int x = c.x;
            int y = c.y;

            List<Integer> dlist = new ArrayList<>();
            if(c.t == 1){
                dlist.add(c.d);
            }else if(c.t == 2){
                if(c.d == 1){
                    dlist.add(1);
                    dlist.add(3);
                }else{ // c.d == 2
                    dlist.add(2);
                    dlist.add(4);
                }

            }else if(c.t == 3){
                if(c.d == 1){
                    dlist.add(1);
                    dlist.add(2);
                }else if(c.d == 2){
                    dlist.add(2);
                    dlist.add(3);
                }else if(c.d == 3){
                    dlist.add(3);
                    dlist.add(4);
                }else{
                    dlist.add(4);
                    dlist.add(1);
                }
            }else if(c.t == 4){
                if(c.d == 1){
                    dlist.add(4);
                    dlist.add(1);
                    dlist.add(2);
                }else if(c.d == 2){
                    dlist.add(1);
                    dlist.add(2);
                    dlist.add(3);
                }else if(c.d == 3){
                    dlist.add(2);
                    dlist.add(3);
                    dlist.add(4);
                }else{
                    dlist.add(3);
                    dlist.add(4);
                    dlist.add(1);
                }
            }else{ // c.t == 5
                dlist.add(1);
                dlist.add(2);
                dlist.add(3);
                dlist.add(4);
            }
            for (int j = 0; j < dlist.size(); j++) {
                int cx = x;
                int cy = y;
                while (true) {
                    int nx = cx + dx[dlist.get(j)];
                    int ny = cy + dy[dlist.get(j)];
                    if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                        if (temp[nx][ny] == 6) {
                            break;
                        } else {
                            if(temp[nx][ny] == 0){
                                temp[nx][ny] = 7;
                            }
                            cx = nx;
                            cy = ny;
                        }
                    }else{
                        break;
                    }
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(temp[i][j] == 0){
                    cnt ++;
                }
            }
        }
//        System.out.println(cnt);
//        System.out.println(Arrays.deepToString(temp));
        min = Math.min(min, cnt);

    }

}
