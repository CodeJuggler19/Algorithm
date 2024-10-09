import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] pairs = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            pairs[i][0] = Integer.parseInt(st.nextToken());
            pairs[i][1] = Integer.parseInt(st.nextToken());
        }
        int answer = answer(a,b,pairs, n);
        if(answer != Integer.MAX_VALUE){
            System.out.println(answer);
        }else{
            System.out.println(-1);
        }

        br.close();
    }

    static int answer(int a, int b, int[][] pairs, int n) {
        List<List<Integer>> nodes = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<>());
        }
        for (int i = 0; i < pairs.length; i++) {
            nodes.get(pairs[i][0]).add(pairs[i][1]);
            nodes.get(pairs[i][1]).add(pairs[i][0]);
        }

        int[] costs = new int[n + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(a);
        costs[a] = 0;
        while(!q.isEmpty()){
            int current = q.poll();

            for(Integer node: nodes.get(current)){
                if(costs[node] == Integer.MAX_VALUE){
                    q.add(node);
                }
                costs[node] = Math.min(costs[node], costs[current] + 1);
            }

        }

        return costs[b];
    }
}

