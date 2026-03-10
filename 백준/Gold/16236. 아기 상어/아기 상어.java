import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int fish;
    static int curX, curY;
    static int curSize = 2;
    static int curCnt = 0;
    static int time = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];

        StringTokenizer st;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] >= 1 && map[i][j] <= 6) fish ++;
                if(map[i][j] == 9){
                    curX = i;
                    curY = j;
                    map[i][j] = 0;
                }
            }
        }

        while(true){
            if(!isEat()){
                break;
            }
        }

        System.out.println(time);
        br.close();
    }
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Location{
        int x, y;
        int len;
        public Location(int x, int y){
            this.x = x;
            this.y = y;
        }
        public Location(int x, int y, int len){
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
    static boolean isEat(){
        // 먹 O, 통과 O == 작은 물고기
        // 먹 X, 통과 O == 같은 물고기
        // 먹 X, 통과 X == 큰 물고기

        // 가장 가까운 물고기 List
        List<Location> list = new ArrayList<>();
        boolean[][] visited = new boolean[N + 1][N + 1];

        if(fish >= 1){
            LinkedList<Location> q = new LinkedList<>();
            q.addFirst(new Location(curX, curY, 0));
            visited[curX][curY] = true;

            int min = Integer.MAX_VALUE;

            while(!q.isEmpty()){
                Location cur = q.removeLast();

                for(int i = 0; i < 4; i++){
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if(nx > 0 && nx <= N && ny > 0 && ny <= N && !visited[nx][ny] && min > cur.len){
                        if(map[nx][ny] == curSize || map[nx][ny] == 0){
                            visited[nx][ny] = true;
                            q.addFirst(new Location(nx, ny, cur.len + 1));
                        }else if(map[nx][ny] < curSize){
                            visited[nx][ny] = true;
                            min = cur.len + 1;
                            list.add(new Location(nx, ny));
                        }
                    }
                }
            }

            // 가장 가까운 거리
            // 가장 가까운 거리가 많다면, 가장 위, 그리고 가장 왼쪽
            if(list.size() == 1){
                curX = list.get(0).x;
                curY = list.get(0).y;
            }else if(list.size() > 1){
                for(int i = 0; i < list.size(); i++){
                    if(i != 0){
                        if(list.get(i).x < curX){
                            curX = list.get(i).x;
                            curY = list.get(i).y;
                        }else if(list.get(i).x == curX){
                            if(list.get(i).y < curY){
                                curX = list.get(i).x;
                                curY = list.get(i).y;
                            }
                        }
                    }else{
                        curX = list.get(i).x;
                        curY = list.get(i).y;
                    }
                }
            }else{
                return false;
            }

            if(curCnt + 1 < curSize){
                curCnt ++;
            }else{
                curSize ++;
                curCnt = 0;
            }
            map[curX][curY] = 0;
            fish--;

            time += min;

            return true;
        }else{
            return false;
        }

    }
}
