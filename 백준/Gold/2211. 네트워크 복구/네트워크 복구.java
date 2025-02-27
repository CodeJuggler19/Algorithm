import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int num;
        int cost;

        public Node(int num,  int cost) {
            this.num = num;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node node){
            return this.cost - node.cost;
        }
    }

    static int N, M;
    static boolean[] vis;

    static int[] from;
    static List<List<Node>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }
        vis = new boolean[N + 1];
        from = new int[N + 1];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(s).add(new Node(e, c));
            list.get(e).add(new Node(s, c));
        }

        int[] costs = new int[N + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(1, 0));
        costs[1] = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();
            if(!vis[cur.num]){
                vis[cur.num] = true;
                for(Node next : list.get(cur.num)){
                    if(!vis[next.num]){
                        if(costs[next.num] > costs[cur.num] + next.cost){
                            costs[next.num] = costs[cur.num] + next.cost;
                            from[next.num] = cur.num;
                        }
                        q.add(new Node(next.num, costs[next.num]));
                    }
                }
            }
        }
        bw.write((N - 1) + "\n");
        for(int i = 2; i < from.length; i++){
            bw.write(i + " " + from[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }



}
