import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        int score, blue, red;
        boolean isBlue = false;

        Node(int score, int red) {
            this.score = score;
            this.red = red;
        }
    }

    static int[] dice = new int[10];
    static int max = Integer.MIN_VALUE;
    static Node[] map = new Node[43];
    static int[] perm = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i <= 40; i += 2) {
            map[i] = new Node(i, i + 2);
        }

        map[10].isBlue = map[20].isBlue = map[30].isBlue = true;

        map[10].blue = 11;
        map[11] = new Node(13, 13);
        map[13] = new Node(16, 15);
        map[15] = new Node(19, 25);

        map[20].blue = 21;
        map[21] = new Node(22, 23);
        map[23] = new Node(24, 25);

        map[30].blue = 27;
        map[27] = new Node(28, 29);
        map[29] = new Node(27, 31);
        map[31] = new Node(26, 25);


        map[25] = new Node(25, 33);
        map[33] = new Node(30, 35);
        map[35] = new Node(35, 40);

        map[42] = new Node(0, 42);

        bt(0);
        System.out.println(max);
        br.close();
    }

    static int[] pos;
    static boolean[] vis;
    static void bt(int cnt){
        if(cnt == 9){
            pos = new int[4];
            vis = new boolean[43];
            move();
            return;
        }
        for(int i = 0; i < 4; i ++){
            perm[cnt] = i;
            bt(cnt + 1);
        }

    }

    static void move(){
        int sum = 0;

        for(int i = 0; i < perm.length; i++){
            int now = pos[perm[i]];
            int next = dice[i];
            int end = endCheck(now, next);
            if(end == -1) return;
            sum += map[end].score;
            pos[perm[i]] = end;
        }
        max = Math.max(max, sum);
    }
    static int endCheck(int now, int next){
        int before = now;

        for(int i = 1; i <= next; i++){
            if(i == 1 && map[now].isBlue){
                now = map[now].blue;
                continue;
            }
            now = map[now].red;
        }

        if( now <= 40 && vis[now]){
            return -1;
        }else{
            vis[before] = false;
            vis[now] = true;
            return now;
        }
    }

}
