import java.io.*;
import java.util.*;

public class Main {
    static int N, E;

    static class Edge implements Comparable<Edge> {
        int num;
        int cost;

        public Edge(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.cost - edge.cost;
        }

    }

    static List<List<Edge>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());


        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(s).add(new Edge(e, c));
            list.get(e).add(new Edge(s, c));
        }

        st = new StringTokenizer(br.readLine());

        int top1 = Integer.parseInt(st.nextToken());
        int top2 = Integer.parseInt(st.nextToken());

        int[] sCost = dstra(1);
        int[] eCost = dstra(N);
        int sum;
        if (sCost[top1] == Integer.MAX_VALUE ||
                sCost[top2] == Integer.MAX_VALUE ||
                eCost[top1] == Integer.MAX_VALUE ||
                eCost[top2] == Integer.MAX_VALUE) {
            sum = -1;
        } else {
            sum = Math.min(sCost[top1] + eCost[top2], sCost[top2] + eCost[top1]);

            int[] mCost = dstra(top1);
            sum += mCost[top2];
        }

        System.out.println(sum);
        br.close();
    }

    static int[] dstra(int start) {
        boolean[] vis = new boolean[N + 1];
        int[] costs = new int[N + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        Queue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(start, 0));
        costs[start] = 0;
        while (!q.isEmpty()) {
            Edge cur = q.poll();

            if (!vis[cur.num]) {
                vis[cur.num] = true;
                for (Edge next : list.get(cur.num)) {
                    if (!vis[next.num]) {
                        costs[next.num] = Math.min(costs[next.num], costs[cur.num] + next.cost);
                        q.add(new Edge(next.num, costs[next.num]));
                    }
                }
            }
        }
        return costs;
    }

}
