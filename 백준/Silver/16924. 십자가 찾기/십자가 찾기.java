import java.io.*;
import java.util.*;

public class Main {
    static int[][] inputs;
    static int[][] draw;

    static class Node {
        int x, y, s;

        public Node(int x, int y, int s) {
            this.x = x;
            this.y = y;
            this.s = s;
        }
    }

    static List<Node> list = new ArrayList<>();
    static int N, M;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        min = Math.min(N, M);
        if (min % 2 == 0) {
            min--;
        }
        inputs = new int[N + 1][M + 1];
        draw = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {
                inputs[i][j] = input[j - 1] == '.' ? 0 : 1;
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(inputs[i][j] == 1){
                    check(i, j);
                }
            }
        }
        for(Node cur : list){
            drawImage(cur.x, cur.y , cur.s);
        }


//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= M; j++) {
//                System.out.print(inputs[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("=======");
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= M; j++) {
//                System.out.print(draw[i][j] + " ");
//            }
//            System.out.println();
//        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(inputs[i][j] != draw[i][j]){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(list.size());
        for(Node cur : list){
            System.out.print(cur.x + " " + cur.y + " " + cur.s);
            System.out.println();
        }
    }
    static void drawImage(int x, int y, int s){
        draw[x][y] = 1;
        for(int i = 1; i <= s; i++){
            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j] * i;
                int ny = y + dy[j] * i;
                draw[nx][ny] = 1;
            }
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void check(int x, int y) {
        if (x == 1 || y == 1 || x == N || y == M) return;

        boolean ip = true;
        for (int i = 1; i <= min; i++) {
            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j] * i;
                int ny = y + dy[j] * i;
                if(nx < 1 || nx > N || ny < 1 || ny > M || inputs[nx][ny] != 1){
                    ip = false;
                    break;
                }
            }
            if(ip){
                list.add(new Node(x, y, i));
            }
        }

    }

}
