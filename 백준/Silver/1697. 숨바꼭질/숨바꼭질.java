import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int K;
    static int[][] list;
    static int[] min;
    static boolean[] vis;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new int[100001][3];
        min = new int[100001];
        for (int i = 0; i <= 100000; i++) {
            min[i] = Integer.MAX_VALUE;
            if (i - 1 < 0) {
                list[i][0] = -1;
            } else {
                list[i][0] = i - 1;
            }
            if (i + 1 > 100000) {
                list[i][1] = -1;
            } else {
                list[i][1] = i + 1;
            }
            if (2 * i > 100000) {
                list[i][2] = -1;
            } else {
                list[i][2] = 2 * i;
            }

        }
        vis = new boolean[100001];

        vis[N] = true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(N, 0));
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(min[cur.num] > cur.depth){
                min[cur.num] = cur.depth;
            }
            for (int c : list[cur.num]) {
                if(c != -1 && !vis[c]){
                    vis[c] = true;
                    q.add(new Node(c, cur.depth + 1));
                }
            }
        }
        System.out.println(min[K]);
        br.close();
    }
    static class Node{
        int num;
        int depth;

        public Node(int num, int depth){
            this.num = num;
            this.depth = depth;
        }

    }

}
