import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int num, cnt, clip;

        private Node(int num, int cnt, int clip) {
            this.num = num;
            this.cnt = cnt;
            this.clip = clip;
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int S = Integer.parseInt(br.readLine());

        Queue<Node> q = new LinkedList<>();


        boolean[] vis = new boolean[1001];

        q.add(new Node(1, 0, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if(cur.num == S){
                System.out.println(cur.cnt);
                break;
            }

            if(!vis[cur.num]){
                vis[cur.num] = true;
                q.add(new Node(cur.num, cur.cnt + 1, cur.num));
            }

            if(cur.num + cur.clip <= 1000){
                q.add(new Node(cur.num + cur.clip, cur.cnt + 1, cur.clip));
            }
            if(cur.num > 0){
                q.add(new Node(cur.num - 1, cur.cnt + 1, cur.clip));
            }
        }
        br.close();
    }

}





