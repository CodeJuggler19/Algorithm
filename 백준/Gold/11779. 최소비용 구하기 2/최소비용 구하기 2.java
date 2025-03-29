import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] cityCost;
    static boolean[] vis;
    static List<List<Edge>> list = new ArrayList<>();

    static class Edge implements Comparable<Edge> {
        int city, cost;
        List<Integer> path;
        public Edge(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }
        public Edge(int city, int cost, List<Integer> path) {
            this.city = city;
            this.cost = cost;
            this.path = path;
        }

        public int compareTo(Edge edge) {
            return this.cost - edge.cost;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        cityCost = new int[n + 1];
        vis = new boolean[n + 1];
        Arrays.fill(cityCost, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(s).add(new Edge(e,c));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Edge> q = new PriorityQueue<>();
        List<Integer> init = new ArrayList<>();
        init.add(start);
        q.add(new Edge(start, 0, init));
        cityCost[start] = 0;
        while(!q.isEmpty()){
            Edge cur = q.poll();

            if(cur.city == end){
                System.out.println(cur.cost);
                System.out.println(cur.path.size());
                for(int ele : cur.path){
                    System.out.print(ele + " ");
                }
                break;
            }
            if(!vis[cur.city]){
                vis[cur.city] = true;
                List<Integer> curPath = cur.path;
                for(Edge next : list.get(cur.city)){
                    if(!vis[next.city]){
                        List<Integer> nextPath = new ArrayList<>(curPath);
                        nextPath.add(next.city);
                        q.add(new Edge(next.city, cityCost[cur.city] + next.cost, nextPath));
                        if(cityCost[next.city] > cityCost[cur.city] + next.cost){
                            cityCost[next.city] = cityCost[cur.city] + next.cost;
                        }
                    }
                }
            }
//            System.out.println(cur.city);
//            System.out.println(Arrays.toString(cityCost));
        }
        br.close();
    }
}
