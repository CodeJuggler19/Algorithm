import java.io.*;
import java.util.*;

public class Main {
    static int V, E;

    static int[] cost;

    static boolean[] vis;

    static class Node implements Comparable<Node> {
        int node, cost;

        private Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        public int compareTo(Node node) {
            return this.cost - node.cost;
        }

    }

    static List<List<Node>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        cost = new int[V + 1];
        vis = new boolean[V + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }
        int start = Integer.parseInt(br.readLine());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(s).add(new Node(e, c));
        }

        Queue<Node> q = new PriorityQueue<>();

        q.add(new Node(start, 0));
        cost[start] = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();
            if(!vis[cur.node]){
                vis[cur.node] = true;

                for(Node next : list.get(cur.node)){
                    if(!vis[next.node]){
                        if(cost[next.node] > next.cost + cost[cur.node]){
                            cost[next.node] = next.cost + cost[cur.node];
                            q.add(new Node(next.node, cost[next.node]));
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= V; i++){
            if(cost[i] == Integer.MAX_VALUE){
                sb.append("INF").append("\n");
            }else{
                sb.append(cost[i]).append("\n");
            }
        }
        System.out.println(sb);

        br.close();
    }
}
