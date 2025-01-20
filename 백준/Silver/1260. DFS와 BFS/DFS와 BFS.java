import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;

    static boolean[] vis;

    static List<List<Integer>> list;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.get(s).add(e);
            list.get(e).add(s);
        }
        vis = new boolean[N + 1];
        dfs(V);
        sb.append("\n");

        vis = new boolean[N + 1];
        bfs(V);
        System.out.println(sb);
        br.close();
    }

    static void dfs(int s){
        sb.append(s + " ");
        vis[s] = true;
        Collections.sort(list.get(s));
        for(Integer n : list.get(s)){
            if(!vis[n]){
                dfs(n);
            }
        }
    }

    static void bfs(int s){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        vis[s] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur + " ");
            Collections.sort(list.get(cur));
            for(Integer n : list.get(cur)){
                if(!vis[n]){
                    q.add(n);
                    vis[n] = true;
                }
            }
        }
    }
}
