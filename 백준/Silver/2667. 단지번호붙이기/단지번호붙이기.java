import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] map;
    static boolean[][] vis;
    static List<Integer> results = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        vis = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !vis[i][j]) {
                    results.add(bfs(i, j));
                }
            }
        }

        Collections.sort(results);
        System.out.println(results.size());
        for(int result: results){
            System.out.println(result);
        }
        br.close();
    }

    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        vis[x][y] = true;

        int cnt = 0;
        while(!q.isEmpty()){
            Node cur = q.poll();
            cnt++;
            for(int i = 0; i < 4; i ++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny <N
                        && !vis[nx][ny] && map[nx][ny] == 1){
                    vis[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }
            }

        }
        return cnt;
    }
}
