import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                list.get(u).add(v);
                list.get(v).add(u);
            }

            boolean[] vis = new boolean[V + 1];
            int[] color = new int[V + 1];
            boolean isBipartite = true;

            for (int i = 1; i <= V; i++) {
                if (!vis[i]) {
                    if (!bfs(i, list, vis, color)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            if (isBipartite) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static boolean bfs(int start, List<List<Integer>> list, boolean[] vis, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;
        color[start] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int n : list.get(cur)) {
                if (!vis[n]) {
                    q.add(n);
                    vis[n] = true;
                    color[n] = 3 - color[cur];
                } else if (color[n] == color[cur]) {
                    return false;
                }
            }
        }
        return true;
    }
}
