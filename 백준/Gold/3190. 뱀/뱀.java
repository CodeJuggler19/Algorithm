import java.io.*;
import java.util.*;

public class Main {
    static int N, K, L;
    static int[][] map;
    static boolean[][] vis;
    static int resultTime = 0;
    static int len = 1;
    static int xs,ys;
    static int tx, ty;

    static class Node{
        int x, y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

    }
    static Deque<Node> link = new ArrayDeque<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // map의 크기
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        map[1][1] = 1;
        // 사과의 개수
        K = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 사과는 2로 표현
            map[x][y] = 2;
        }
        L = Integer.parseInt(br.readLine());
        xs = ys = tx = ty = 1;
        link.addFirst(new Node(1, 1));
        int beforeRadius = 0;
        int beforeTime = 0;
        for(int i = 0; i < L; i++){
            st = new StringTokenizer(br.readLine());
            int time =  Integer.parseInt(st.nextToken());
            time -= beforeTime;
            String radius = st.nextToken();

            if(!move(xs, ys, beforeRadius, time)){
                break;
            }


//            for(int j = 1; j <= N; j++){
//                for(int y = 1; y <= N; y++){
//                    System.out.print(map[j][y] + " ");
//                }
//                System.out.println();
//            }

            beforeTime += time;
            if(radius.equals("D")){
                if(beforeRadius != 3){
                    beforeRadius ++;
                }else{
                    beforeRadius = 0;
                }
            }else{ // L
                if(beforeRadius != 0){
                    beforeRadius --;
                }else{
                    beforeRadius = 3;
                }
            }

            if(i == L - 1){
                move(xs, ys, beforeRadius, N);
            }

        }

        System.out.println(resultTime);
        br.close();
    }
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean move(int x, int y, int radius /*방향*/ ,int time){
        for(int i = 0; i < time; i++){
            int nx = x + dx[radius];
            int ny = y + dy[radius];
            resultTime ++;
            if(nx > 0 && nx <= N && ny > 0 && ny <= N && map[nx][ny] != 1){
                if(map[nx][ny] == 2){
                    map[nx][ny] = 1;
                    link.addFirst(new Node(nx, ny));
                }else{
                    map[nx][ny] = 1;
                    link.addFirst(new Node(nx, ny));
                    Node tail = link.removeLast();
                    map[tail.x][tail.y] = 0;
                }
                x = nx;
                y = ny;
                if(i == time - 1){
                    xs = x;
                    ys = y;
                }
            }else{
                return false;
            }
        }

        return true;
    }
}
