import java.io.*;
import java.util.*;

public class Main {
    static int V, M;

    static class Node implements Comparable<Node> {
        int node;
        int cost;
//        int depth;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
//        public Node(int node, int cost, int depth) {
//            this.node = node;
//            this.cost = cost;
//            this.depth = depth;
//        }

        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost;
        }

    }

    static List<List<Node>> list = new ArrayList<>();

//    static List<Integer> depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] JA = new int[V + 1];
        boolean[] JV = new boolean[V + 1];
        int[] SA = new int[V + 1];
        boolean[] SV = new boolean[V + 1];
        Arrays.fill(JA, Integer.MAX_VALUE);
        Arrays.fill(SA, Integer.MAX_VALUE);

        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }
//        for(int i = 0; i < list.size(); i++){
//            System.out.print(i + " :  ");
//            for(Node cur : list.get(i)){
//                System.out.print(cur.node + "/" + cur.cost + "  ");
//            }
//            System.out.println();
//        }

        st = new StringTokenizer(br.readLine());
        int J = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        dstra(JA, JV, J);
        dstra(SA, SV, S);

        int sum = Integer.MAX_VALUE;
        List<Integer> idxList = new ArrayList<>();
        for (int i = 1; i <= V; i++) {
            if (i == J || i == S) continue;
            if (JA[i] == Integer.MAX_VALUE || SA[i] == Integer.MAX_VALUE) continue;
            if (sum > JA[i] + SA[i]) {
                idxList.clear();
                idxList.add(i);
                sum = JA[i] + SA[i];
            } else if (sum == JA[i] + SA[i]) {
                idxList.add(i);
            }
        }
        List<Integer> idxList2 = new ArrayList<>();
        for(int idx : idxList){
            if(JA[idx] <= SA[idx]){
                idxList2.add(idx);
            }
        }
        int min = Integer.MAX_VALUE;
        idxList.clear();
        for(int idx : idxList2){
            if(min > JA[idx]){
                idxList.clear();
                idxList.add(idx);
                min = JA[idx];
            }else if(min == JA[idx]){
                idxList.add(idx);
            }
        }
        Collections.sort(idxList);

        if (idxList.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(idxList.get(0));
        }

        br.close();
    }

    static void dstra(int[] costs, boolean[] vis, int start) {
        Queue<Node> q = new PriorityQueue<>();

        costs[start] = 0;
        q.add(new Node(start, costs[start]));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (!vis[cur.node]) {
                vis[cur.node] = true;
                for (Node next : list.get(cur.node)) {
                    if (vis[next.node]) continue;
                    if (costs[next.node] > costs[cur.node] + next.cost) {
                        costs[next.node] = costs[cur.node] + next.cost;
                    }
                    q.add(new Node(next.node, costs[next.node]));
                }
            }
        }
    }
}
