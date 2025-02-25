import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int end, cost;

        public Node( int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st;

        List<List<Node>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(s).add(new Node(e, c));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        boolean[] vis = new boolean[N + 1];
        int[] cost = new int[N + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);


        cost[start] = 0;
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));

        while(!q.isEmpty()){
            Node cur = q.poll();
            if(!vis[cur.end]){
                vis[cur.end] = true;
                for(Node c : list.get(cur.end)){
                    if(!vis[c.end]){
                        cost[c.end] = Math.min(cost[c.end] , cost[cur.end] + c.cost);
                        q.add(new Node(c.end, cost[c.end]));
                    }
                }
            }


        }


        System.out.println(cost[end]);
        br.close();
    }


}
