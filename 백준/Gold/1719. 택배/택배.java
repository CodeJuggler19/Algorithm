import java.io.*;
import java.util.*;

public class Main {
    static int n, m;

    static List<List<Node>> list = new ArrayList<>();

    static class Node implements Comparable<Node> {
        int num, cost, parent;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        public Node(int num, int cost, int parent) {
            this.num = num;
            this.cost = cost;
            this.parent = parent;
        }

        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost;
        }

    }

    static int[][] parent;

    static boolean[] vis;

    static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(s).add(new Node(e, c));
            list.get(e).add(new Node(s, c));
        }

        for (int i = 1; i <= n; i++) {
            distra(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(parent[i][j] == 0){
                    sb.append("- ");
                }else{
                    sb.append(parent[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    static void distra(int start) {
        vis = new boolean[n + 1];
        cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        Queue<Node> q = new PriorityQueue<>();
        vis[start] = true;
        cost[start] = 0;
        parent[start][start] = 0;

        for(Node next : list.get(start)){
//            System.out.println(next.num);
            q.add(new Node(next.num, next.cost, next.num));
            cost[next.num] = next.cost;
        }
//        System.out.println(Arrays.toString(cost));
        while(!q.isEmpty()){
            Node cur = q.poll();
//            System.out.println("cur.num : " + cur.num);
            if(!vis[cur.num]){
                vis[cur.num] = true;
                parent[start][cur.num] = cur.parent;
                for(Node next : list.get(cur.num)){
                    if(!vis[next.num]){
                        if(cost[next.num] >  cost[cur.num] + next.cost){
                            cost[next.num]  = cost[cur.num] + next.cost;
                            q.add(new Node(next.num, cost[next.num], cur.parent));
                        }
                    }
                }
            }
        }
    }
}
